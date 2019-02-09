package com.app.tigr.data.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.app.tigr.App
import com.app.tigr.domain.params.InitLongPollServerPrm
import com.app.tigr.domain.params.LongPollServerPrm
import com.app.tigr.domain.response.lpserver.InitLongPollServer
import com.app.tigr.domain.response.lpserver.LongPollServer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class NotificationsService : Service() {

    private val dispose = CompositeDisposable()

    private val connection = App.appComponent.getApi()

    private val bind: MyBinder = MyBinder()

    private val serverParam = InitLongPollServerPrm()

    override fun onBind(intent: Intent): IBinder {
        return bind
    }

    private fun initState() {
        val requestRx = connection.getLongPoolServer(LongPollServerPrm())
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = { it ->
                            initData(it.response)
                            initLongPoolServer()
                        },
                        onError = { it.printStackTrace() })

        dispose.add(requestRx)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (serverParam.ts == 0) {
            initState()
        } else {
            initLongPoolServer()
        }

        return START_STICKY
    }

    private fun initData(it: LongPollServer) {
        serverParam.key = it.key
        serverParam.server = it.server
        serverParam.ts = it.ts
    }

    private fun initLongPoolServer() {
        val requestRx = connection.initLongPoolServer(serverParam)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = { it -> processingData(it) },
                        onError = { it.printStackTrace() })

        dispose.add(requestRx)
    }

    private fun processingData(data: InitLongPollServer) {
        if (data.failed.isEmpty()) {
            if (data.updates.isEmpty().not()) {
                EnentsParser(applicationContext, data.updates)
            }
            newEventNumber(data)
            dispose.clear()
            initLongPoolServer()
        } else {
            processingErrors(data)
        }

    }

    private fun newEventNumber(data: InitLongPollServer) {
        serverParam.ts = data.ts
    }

    private fun processingErrors(data: InitLongPollServer) {
        when (data.failed) {
            "1" -> serverParam.ts = data.ts
            "2", "3" -> {
                initState(); initLongPoolServer()
            }
            "4" -> {
                Log.e("VK API ERROR", "wrong version the Long Poll Server")
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        dispose.clear()
    }

    inner class MyBinder : android.os.Binder() {
        internal val service: NotificationsService
            get() = this@NotificationsService
    }
}
