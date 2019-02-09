package com.app.tigr.ui.chat.mvp

import com.app.tigr.App
import com.app.tigr.domain.extras.Message
import com.app.tigr.domain.response.ConversationsRsp
import com.app.tigr.domain.params.ConversationsParam
import com.app.tigr.domain.response.message.Conversations
import com.app.tigr.ui.chat.ChatAdapter
import com.app.tigr.ui.chat.impl.ContractChatPresenter
import com.app.tigr.ui.chat.impl.ContractChatView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy

@InjectViewState
class ChatPresenter : MvpPresenter<ContractChatView>(), ContractChatPresenter {

    private val connection = App.appComponent.getApi()

    private val dispose = CompositeDisposable()

    private var adapter: ChatAdapter = ChatAdapter(Conversations())

    private lateinit var single: Disposable

    override fun viewIsReady() = takeData()

    private fun takeData() {
        single = connection.getMessages(buildParam())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onError = { it.printStackTrace() },
                        onSuccess = { it -> setData(it) })
        dispose.add(single)
    }

    private fun setData(takeData: ConversationsRsp) {
        adapter = ChatAdapter(takeData.response)
        viewState.showChat(adapter)
    }

    override fun dataChanged(msg: Message) {
/*        val audioData = adapter!!.audioData.items
        val found = audioData.find{it -> it.conversation.peer.id == msg.peerId}
        if (found != null){
            found.lastMessage.apply {
                date = msg.timestamp
                text = msg.text
            }
        }*/
        adapter.notifyDataSetChanged()
    }

    private fun buildParam() = ConversationsParam(extended = 1)

    override fun viewIsPaused() {}

    override fun viewIsResumed() = takeData()

    override fun onDestroy() {
        super.onDestroy()
        dispose.clear()
    }
}