package com.app.tigr.ui.dialog.custom

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.support.v7.widget.LinearLayoutCompat
import android.util.AttributeSet
import android.view.Gravity
import com.app.tigr.R
import com.app.tigr.data.services.AudioService
import com.app.tigr.data.services.AudioService.*
import com.app.tigr.domain.response.attachments.Audio
import kotlinx.android.synthetic.main.music_layout.view.*
import com.vk.sdk.VKUIHelper.getApplicationContext
import android.view.LayoutInflater
import com.app.tigr.common.TUtils


class MusicMsgPlayerLayout : LinearLayoutCompat {

    private var currentState = Player.STOP

    var audioData = Audio()

    private var receiver: BroadcastReceiver? = null

    constructor(ctx: Context) : this(ctx, null)

    constructor(ctx: Context, attr: AttributeSet?) : this(ctx, attr, 0)

    constructor(ctx: Context, attr: AttributeSet?, defStyleAttr: Int) : super(ctx, attr, defStyleAttr) {
        val li = LayoutInflater.from(getApplicationContext())
        val cv = li.inflate(R.layout.music_layout, this, false)
        addView(cv)
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
    }

    fun init(data: Audio) {
        audioData = data
        musicArtist.text = data.artist
        musicTitle.text = data.title
        musicDuration.text = TUtils.parseDuration(data.duration)
        buttonMusicPlay.setOnClickListener { exchangeOnclick() }
    }

    private fun exchangeOnclick() {
        receiver = receiver ?: createReceiver()
        context.registerReceiver(receiver, getIntentFilter())
        createService()
        when (currentState) {
            Player.START -> sendCommand(Player.PAUSE)
            Player.PAUSE, Player.STOP -> sendCommand(Player.START)
        }
    }

    private fun createService() {
        if (audioData.url.isEmpty()) return

        val intent = Intent(context, AudioService::class.java)
        intent.putExtra(AudioService.AUDIO_DATA, audioData)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent)
        } else {
            context.startService(intent)
        }
    }

    private fun sendCommand(name: Player) {
        context.sendBroadcast(prepareIntent(name))
    }

    private fun prepareIntent(data: Player): Intent {
        val intent = Intent(AudioService.INTENT_COMMAND_KEY)
        intent.putExtra(AudioService.EXTRA_COMMAND_KEY, data.name)
        return intent
    }

    private fun iconPause() {
        buttonMusicPlay.background = context.getDrawable(R.drawable.pause)
    }

    private fun iconPlay() {
        buttonMusicPlay.background = context.getDrawable(R.drawable.play)
    }

    private fun createReceiver(): BroadcastReceiver {
        return object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val name = intent?.getStringExtra(AudioService.EXTRA_STATE_KEY) ?: return

                val key = name.substringAfter("+")
                val id = name.substringBefore("+")
                if (audioData.uniqueId == id) {
                    currentState = when (AudioService.Player.valueOf(key)) {
                        Player.START -> {
                            iconPause()
                            Player.START
                        }
                        Player.PAUSE -> {
                            iconPlay()
                            Player.PAUSE
                        }
                        Player.STOP -> {
                            iconPlay()
                            Player.STOP
                        }
                    }
                } else {
                    iconPlay()
                    this@MusicMsgPlayerLayout.context.unregisterReceiver(receiver)
                }
                intent.removeExtra(AudioService.EXTRA_STATE_KEY)
            }
        }
    }

    private fun getIntentFilter() = IntentFilter(AudioService.INTENT_STATE_KEY)


    fun onDestroy() {
        context.unregisterReceiver(receiver)
    }
}