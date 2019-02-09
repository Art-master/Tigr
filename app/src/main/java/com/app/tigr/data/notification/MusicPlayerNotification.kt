package com.app.tigr.data.notification

import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_HIGH
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.widget.RemoteViews
import com.app.tigr.R
import com.app.tigr.common.Constants.Companion.PROJECT_DIR
import com.app.tigr.data.services.AudioService
import com.app.tigr.domain.response.attachments.Audio


class MusicPlayerNotification(private val context: Context) {
    companion object {
        const val CHANNEL_ID = "$PROJECT_DIR.notifications.channel.audio"
        const val CHANNEL_NAME = "$PROJECT_DIR.notifications.channel.audio.player"
        const val NOTIFICATION_ID = 2133453463
    }

    private var notificationManager: NotificationManager? = null

    private var remView: RemoteViews? = null

    private lateinit var audioInfo: Audio

    fun build(audio: Audio, state: AudioService.Player) {

        audioInfo = audio
        remView = buildRemoteView()
        remView?.setImageViewResource(R.id.button_play, getIcon(state))

        var pendingIntent = getPendingIntent(getPlayerPurpose(state))
        remView?.setOnClickPendingIntent(R.id.button_play, pendingIntent)

        pendingIntent = getPendingIntent(getPlayerPurpose(AudioService.Player.STOP))
        remView?.setOnClickPendingIntent(R.id.closeButton, pendingIntent)


        val notification = createNotification()
        notification.flags = notification.flags or Notification.FLAG_ONGOING_EVENT

        notificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager?.notify(NOTIFICATION_ID, notification)
    }

    private fun buildRemoteView(): RemoteViews {
        val audioName = audioInfo.artist + "\n" + audioInfo.title
        return RemoteViews(context.packageName, R.layout.notification_player)
                .apply {
                    setTextViewText(R.id.audioName, audioName)
                }
    }

    private fun createNotification(): Notification {
        return getBuilder()
                .setSmallIcon(R.drawable.ic_button_send)
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setContentTitle("Music player")
                .setContent(remView)
                .build()
    }

    private fun getBuilder(): NotificationCompat.Builder {
        return if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O) {
            createChannel()
            NotificationCompat.Builder(context, CHANNEL_ID)
        } else {
            NotificationCompat.Builder(context)
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private fun createChannel(): NotificationChannel {
        val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, IMPORTANCE_HIGH)
        channel.description = "Music channel"
        channel.enableVibration(false)
        return channel
    }

    private fun getPendingIntent(command: AudioService.Player): PendingIntent {
        return PendingIntent.getBroadcast(
                context, 0, getPlayIntent(command.name), FLAG_UPDATE_CURRENT)
    }

    private fun getPlayIntent(command: String): Intent {
        val intent = Intent(AudioService.INTENT_COMMAND_KEY)
        intent.putExtra(AudioService.EXTRA_COMMAND_KEY, command)
        return intent
    }


    private fun getIcon(state: AudioService.Player): Int {
        return when (state) {
            AudioService.Player.START -> R.drawable.pause
            AudioService.Player.PAUSE -> R.drawable.play
            AudioService.Player.STOP -> R.drawable.play
        }
    }

    private fun getPlayerPurpose(state: AudioService.Player): AudioService.Player {
        return when (state) {
            AudioService.Player.START -> AudioService.Player.PAUSE
            AudioService.Player.PAUSE -> AudioService.Player.START
            AudioService.Player.STOP -> AudioService.Player.START
        }
    }

    fun deleteNotification() {
        notificationManager?.cancel(NOTIFICATION_ID)
    }
}