package com.app.tigr.data.services

import android.content.ComponentName
import android.os.IBinder
import android.content.ServiceConnection


object NotificationServConnection : ServiceConnection {
    override fun onServiceConnected(cName: ComponentName, service: IBinder) {
        val binder = service as NotificationsService.MyBinder
    }

    override fun onServiceDisconnected(cName: ComponentName) {
    }

    operator fun invoke(): NotificationServConnection {
        return this
    }
}