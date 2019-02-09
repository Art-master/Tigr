package com.app.tigr.ui.chat.mvp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.app.tigr.ui.chat.ChatAdapter
import com.app.tigr.ui.chat.impl.ContractChatView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.app.tigr.R
import com.app.tigr.common.Constants
import com.app.tigr.data.services.NotificationServConnection
import com.app.tigr.data.services.NotificationsService
import kotlinx.android.synthetic.main.activity_chat.*
import android.content.IntentFilter
import com.app.tigr.domain.extras.Message
import com.arellomobile.mvp.presenter.PresenterType

class ChatActivity: MvpAppCompatActivity(), ContractChatView {

    @InjectPresenter(tag = "ChatPresenter", type = PresenterType.GLOBAL)
    lateinit var presenter: ChatPresenter

    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var receiver: BroadcastReceiver

    private lateinit var serviceConnection: NotificationServConnection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerMessages!!.layoutManager = linearLayoutManager

        presenter.attachView(this)

        if (savedInstanceState == null) presenter.viewIsReady()

        bindNetworkingService()
        createReceiver()
    }

    private fun bindNetworkingService() {
        serviceConnection = NotificationServConnection()
        val intent = Intent(applicationContext, NotificationsService::class.java)
        bindService(intent, serviceConnection, BIND_AUTO_CREATE)
    }

    private fun createReceiver() {
        receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val data = intent!!.getParcelableExtra<Message>(Constants.Keys.EVENT_NEW_MESSAGE.value)
                presenter.dataChanged(data)
            }
        }
        registerReceiver(receiver, getIntentFilter())
    }

    private fun getIntentFilter() = IntentFilter(Constants.Actions.NEW_MESSAGE.value)

    override fun showChat(adapter: ChatAdapter) {
        recyclerMessages.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.viewIsResumed()
        registerReceiver(receiver, getIntentFilter())
        bindNetworkingService()
    }

    override fun onPause() {
        super.onPause()
        unbindService(serviceConnection)
        unregisterReceiver(receiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView(this)
    }
}