package com.app.tigr.data.recieiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.app.tigr.data.services.NotificationsService


class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        context.startService(Intent(context, NotificationsService::class.java))
    }
}
