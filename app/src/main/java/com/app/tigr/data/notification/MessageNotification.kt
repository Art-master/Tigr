package com.app.tigr.data.notification

import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.v4.app.NotificationCompat
import com.app.tigr.R

class MessageNotification(private val context: Context) {
    companion object {
        const val CHANNEL_ID = "34"
        const val CHANNEL_NAME = "App"
    }

    fun build() {
        getBuilder()
                .setSmallIcon(R.drawable.ic_button_send)
                .setContentTitle("My notification")
                .setContentText("Hello World!")
    }

    private fun getBuilder(): NotificationCompat.Builder {
        return if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O) {
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