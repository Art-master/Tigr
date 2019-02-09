package com.app.tigr.data.services

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import com.app.tigr.common.Constants.Companion.PROJECT_DIR
import com.app.tigr.data.notification.MusicPlayerNotification
import com.app.tigr.domain.response.attachments.Audio

class AudioService : Service(), MediaPlayer.OnPreparedListener {

    private val bind: AudioService.MyBinder = MyBinder()

    private lateinit var receiver: BroadcastReceiver

    private var audioInfo = Audio()

    private var playerPrepareFlag = false

    private var notification: MusicPlayerNotification? = null

    companion object {
        const val AUDIO_DATA = "$PROJECT_DIR.audio.player.audio.info"
        const val EXTRA_COMMAND_KEY = "$PROJECT_DIR.audio.player.transmitter"
        const val EXTRA_STATE_KEY = "$PROJECT_DIR.audio.player.receiver"
        const val INTENT_COMMAND_KEY = "$PROJECT_DIR.audio.player.control"
        const val INTENT_STATE_KEY = "$PROJECT_DIR.audio.player.state"
    }

    enum class Player(val value: String) {
        START("$PROJECT_DIR.audio.player.play"),
        STOP("$PROJECT_DIR.audio.player.stop"),
        PAUSE("$PROJECT_DIR.audio.player.pause")
    }

    override fun onBind(intent: Intent?): IBinder? {
        return bind
    }

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()
        receiver = createReceiver()
        applicationContext.registerReceiver(receiver, getIntentFilter())
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val info = intent.getParcelableExtra<Audio>(AUDIO_DATA)

        if (audioInfo.uniqueId != info.uniqueId) {
            audioInfo = info
            val uri = Uri.parse(info.url)
            playerInit(uri)
        }
        return START_STICKY
    }

    private fun playerInit(uri: Uri) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer().apply {
            setDataSource(applicationContext, uri)
            isLooping = false
            setOnPreparedListener(this@AudioService)
            prepareAsync()
        }
        mediaPlayer?.setOnCompletionListener {
            exchangeCommand(Player.STOP)
            stopSelf()
        }
    }

    override fun onPrepared(mediaPlayer: MediaPlayer) {
        playerPrepareFlag = true
        mediaPlayer.start()
        exchangeCommand(Player.START)
    }

    private fun createReceiver(): BroadcastReceiver {
        return object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val key = EXTRA_COMMAND_KEY
                val name = intent?.getStringExtra(key) ?: return
                intent.removeExtra(key)

                if (playerPrepareFlag.not()) return

                exchangeCommand(Player.valueOf(name))

            }
        }
    }

    private fun getIntentFilter() = IntentFilter(INTENT_COMMAND_KEY)

    private fun exchangeCommand(state: Player) {
        when (state) {
            Player.START -> {
                musicPlay()
            }
            Player.PAUSE -> {
                musicPause()
            }
            Player.STOP -> {
                musicStop()
            }
        }
        val uniqueId = "${audioInfo.uniqueId}+${state.name}"
        sendState(uniqueId)
        notification = MusicPlayerNotification(applicationContext)
        notification?.build(audioInfo, state)
    }

    private fun sendState(name: String) {
        applicationContext.sendBroadcast(prepareIntent(name))
    }

    private fun prepareIntent(data: String): Intent {
        val intent = Intent(INTENT_STATE_KEY)
        intent.putExtra(EXTRA_STATE_KEY, data)
        return intent
    }

    private fun musicPlay() {
        mediaPlayer?.apply {
            if (isPlaying.not()) {
                start()
            }
        }
    }

    private fun musicPause() {
        mediaPlayer?.apply {
            if (isPlaying) {
                pause()
            }
        }
    }

    private fun musicStop() {
        mediaPlayer?.apply {
            if (isPlaying) {
                stop()
            }
        }
    }

    inner class MyBinder : android.os.Binder() {
        internal val service: AudioService
            get() = this@AudioService
    }

    override fun onDestroy() {
        super.onDestroy()
        notification?.deleteNotification()
        applicationContext.unregisterReceiver(receiver)
        mediaPlayer?.release()
    }
}
