package com.app.tigr.data.notification

import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.graphics.Color
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.widget.RemoteViews
import com.app.tigr.R
import com.app.tigr.common.Constants.Companion.PROJECT_DIR
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.NotificationTarget
import com.squareup.picasso.Picasso


class MessageNotification(private val context: Context) {
    companion object {
        const val CHANNEL_ID = "$PROJECT_DIR.notifications.channel.message"
        const val CHANNEL_NAME = "$PROJECT_DIR.notifications.channel.users.msg"
        const val NOTIFICATION_ID = 213
    }

    fun build(url: String) {
        val notification = getBuilder()
                .setSmallIcon(R.drawable.ic_button_send)
                .setLargeIcon(Picasso.with(context).load(url).get())
                .setContentTitle("My notification")
                .setContentText("Hello World!")
                .build()

        val notificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFICATION_ID, notification)
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
        return NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH)
                .apply {
                    description = "My channel description"
                    enableLights(true)
                    lightColor = Color.RED
                    enableVibration(false)
                }
    }
}