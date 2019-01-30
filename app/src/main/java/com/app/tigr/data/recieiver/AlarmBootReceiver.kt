package com.app.tigr.data.recieiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.app.tigr.data.services.NotificationsService

class AlarmBootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            context.startService(Intent(context, NotificationsService::class.java))
        }
    }
}
