package com.app.tigr.ui.chat.mvp

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.app.tigr.ui.chat.ChatAdapter
import com.app.tigr.ui.chat.impl.ContractChatView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.app.tigr.R
import com.app.tigr.domain.response.message.Conversations
import kotlinx.android.synthetic.main.activity_chat.*

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
    }

    override fun showChat(data: Conversations?){
        recyclerMessages.adapter = ChatAdapter(data, applicationContext)
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