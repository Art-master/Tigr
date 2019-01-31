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
import com.app.tigr.domain.response.lpserver.InitLongPollServer
import kotlinx.android.synthetic.main.activity_chat.*
import android.content.IntentFilter



class ChatActivity: MvpAppCompatActivity(), ContractChatView {

    @InjectPresenter
    lateinit var presenter: ChatPresenter

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerMessages!!.layoutManager = linearLayoutManager

        if(!presenter.isInRestoreState(this)){
            presenter.attachView(this)
            presenter.viewIsReady()
        }

        bindNetworkingService()
        createReceiver()
    }

    private fun bindNetworkingService() {
        val intent = Intent(applicationContext, NotificationsService::class.java)
        bindService(intent, NotificationServConnection(), BIND_AUTO_CREATE)
    }

    private fun createReceiver() {
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val data = intent!!.getParcelableExtra<InitLongPollServer>(Constants.Keys.REQUEST_DATA.value)

            }
        }
        val intFilter = IntentFilter(Constants.Actions.NEW_MESSAGE.value)
        registerReceiver(receiver, intFilter)
    }

    override fun showChat(adapter: ChatAdapter) {
        recyclerMessages.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.viewIsResumed()
    }

    override fun onPause() {
        super.onPause()
        presenter.viewIsPaused()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView(this)
        presenter.destroyView(this)
    }
}