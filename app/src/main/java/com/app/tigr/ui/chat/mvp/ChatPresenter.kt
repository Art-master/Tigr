package com.app.tigr.ui.chat.mvp

import com.app.tigr.App
import com.app.tigr.domain.response.ConversationsRsp
import com.app.tigr.domain.params.ConversationsParam
import com.app.tigr.ui.chat.ChatAdapter
import com.app.tigr.ui.chat.impl.ContractChatPresenter
import com.app.tigr.ui.chat.impl.ContractChatView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

@InjectViewState
class ChatPresenter : MvpPresenter<ContractChatView>(), ContractChatPresenter {

    private val connection = App.appComponent.getApi()

    private val dispose = CompositeDisposable()

    private var adapter: ChatAdapter? = null

    override fun viewIsReady() = takeData()

    private fun takeData() {
        val request = connection.getMessages(buildParam())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onError = { it.printStackTrace() },
                        onSuccess = { it -> checkData(it) })
        dispose.add(request)
    }

    private fun checkData(takeData: ConversationsRsp) {
        adapter = adapter ?: ChatAdapter(takeData.response)
        adapter?.let { viewState.showChat(it) }
    }

    override fun dataChanged() {
        adapter!!.notifyDataSetChanged()
    }

    private fun buildParam() = ConversationsParam(extended = 1)

    override fun viewIsPaused() = dispose.clear()

    override fun viewIsResumed() = takeData()

    override fun destroyView(view: ContractChatView?) {
        super.destroyView(view)
        dispose.clear()
    }
}