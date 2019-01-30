package com.app.tigr.data.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.app.tigr.App
import com.app.tigr.common.Constants
import com.app.tigr.domain.params.InitLongPollServerPrm
import com.app.tigr.domain.params.LongPollServerPrm
import com.app.tigr.domain.response.LongPollServerRsp
import com.app.tigr.domain.response.lpserver.InitLongPollServer
import com.app.tigr.ui.chat.mvp.ChatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class NotificationsService : Service() {

    private val dispose = CompositeDisposable()

    private val connection = App.appComponent.getApi()

    private var key = ""
    private var server = ""

    private var ts = 0

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val requestRx = connection.getLongPoolServer(LongPollServerPrm())
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = { it ->
                            it.response.let {
                                key = it.key
                                server = it.server
                                ts = it.ts
                                initLongPoolServer()
                            }
                        },
                        onError = { it.printStackTrace() })

        dispose.add(requestRx)

        return START_STICKY
    }

    private fun initLongPoolServer() {
        val requestRx = connection.initLongPoolServer(initParam())
                .repeat()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = { it -> processingData(it.response) },
                        onError = { it.printStackTrace() })

        dispose.add(requestRx)
    }

    private fun initParam(): InitLongPollServerPrm {
        return InitLongPollServerPrm(
                key = key,
                server = server,
                ts = ts,
                mode = buildMode())
    }

    private fun buildMode() = InitLongPollServerPrm.Mode.ALL.value

    private fun processingData(data: InitLongPollServer) {
        val intent = Intent(applicationContext, ChatActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        intent.putExtra(Constants.Keys.NEW_MESSAGE.name, data)
        startActivity(intent)
    }

    private fun buildNotifications(data: LongPollServerRsp) {

    }

    override fun onDestroy() {
        super.onDestroy()
        dispose.clear()
    }
}
