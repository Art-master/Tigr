package com.app.tigr.ui.dialog.mvp

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.content.Intent
import android.os.Bundle
import com.app.tigr.App
import com.app.tigr.common.Constants
import com.app.tigr.data.network.ApiProvider
import com.app.tigr.domain.response.dialog.ItemsItem
import com.app.tigr.domain.params.MessageParam
import com.app.tigr.ui.dialog.impl.ContractDialogPresenter
import com.app.tigr.ui.dialog.impl.ContractDialogView
import com.app.tigr.ui.dialog.list.*
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

@InjectViewState
class DialogPresenter: MvpPresenter<ContractDialogView>(), ContractDialogPresenter {

    private val context = App.appComponent.getContext()

    private val dispose = CompositeDisposable()

    private var userId: Int = 0
    private var peerId: Int = 0

    private lateinit var sourceFactory: DialogDataSourceFactory

    private lateinit var adapter: DialogAdapter

    override fun viewIsReady(intent: Intent) {
        getParcelableData(intent.extras!!)
        buildPagedListAdapter()
        viewState.showEditField()
        val pair = buildPagedListAdapter()
        viewState.showDialog(pair.first, pair.second)
    }

    private fun getParcelableData(bundle: Bundle){
        userId = bundle.getInt(Constants.Keys.USER_ID.name)
        peerId = bundle.getInt(Constants.Keys.PEER_ID.name)
    }

    private fun buildPagedListAdapter(): Pair<LiveData<PagedList<ItemsItem>>, DialogAdapter> {
        val config = DialogPageConfig.get()
        sourceFactory = DialogDataSourceFactory(userId, peerId)
        val pagedListLiveData = LivePagedListBuilder(sourceFactory, config).build()
        val callback = DialogDiffUtilCallback()
        adapter = DialogAdapter(context, peerId, callback)
        //adapter.submitList(pagedListLiveData.value)
        return pagedListLiveData to adapter
    }

    override fun messageIsSending(message: MessageParam) {
        val sendMessage = prepareMessage(message)
        addDataInList(sendMessage)
        messageSend(sendMessage)
    }

    private fun addDataInList(msg: MessageParam) {
        val firstPosition = 0
        val messages = sourceFactory.getData() as ArrayList<ItemsItem>
        val copyItem = messages[firstPosition].copy()
        val newItem = prepareItem(copyItem, msg)
        messages.add(firstPosition, newItem)
        dialogUpdate()
    }

    private fun prepareMessage(msg: MessageParam): MessageParam {
        return MessageParam(text = msg.text, peerId = userId, userId = peerId)
    }

    private fun dialogUpdate() = adapter.notifyDataSetChanged()

    private fun prepareItem(item: ItemsItem, msg: MessageParam): ItemsItem {
        item.fromId = userId
        item.peerId = peerId
        item.text = msg.text
        item.randomId = msg.randomId
        item.date = 0
        return item
    }

    private fun messageSend(msg: MessageParam) {
        val request = ApiProvider().sendMessage(message = msg)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = { it -> it.response.toString() },
                        onError = { it.printStackTrace() })
        dispose.add(request)
    }

    override fun viewIsDestroyed() {
        dispose.clear()
    }

    override fun viewIsPaused() {

    }

    override fun viewIsResumed(){}
}