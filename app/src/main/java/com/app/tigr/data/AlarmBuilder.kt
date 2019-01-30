package com.app.tigr.data

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.ComponentName
import android.content.Context.ALARM_SERVICE
import com.app.tigr.data.recieiver.AlarmReceiver
import com.app.tigr.data.services.NotificationsService
import java.util.*


class AlarmBuilder(val context: Context) {
    private val ALARM_TYPE = 192837

    private val intervalSecond = 1000L

    private var alarmManager: AlarmManager? = null

    private var alarmIntent: PendingIntent? = null

    fun build() {

        val cal = Calendar.getInstance()
        cal.timeZone = TimeZone.getDefault()
        cal.set(Calendar.SECOND, 1)

        val intent = Intent(context, AlarmReceiver::class.java)

        alarmIntent = PendingIntent.getBroadcast(context,
                ALARM_TYPE, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        alarmManager = context.getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager!!.setInexactRepeating(AlarmManager.RTC, cal.timeInMillis, intervalSecond, alarmIntent)
    }

    /**
     * Enable boot receiver to persist alarms set for notifications across device reboots
     */
    fun enableBootReceiver(context: Context) {
        val receiver = ComponentName(context, AlarmReceiver::class.java)
        val pm = context.packageManager

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP)
    }

    /**
     * Disable boot receiver when user cancels/opt-out from notifications
     */
    fun disableBootReceiver(context: Context) {
        val receiver = ComponentName(context, AlarmReceiver::class.java)
        val pm = context.packageManager

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP)
    }

    fun cancelAlarmElapsed() {
        if (alarmManager != null) {
            alarmManager!!.cancel(alarmIntent)
        }
    }
}