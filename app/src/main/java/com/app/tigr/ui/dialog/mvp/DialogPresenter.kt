package com.app.tigr.ui.dialog.mvp

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.content.Intent
import android.os.Bundle
import com.app.tigr.App
import com.app.tigr.common.Constants
import com.app.tigr.domain.response.ResponseMsgSend
import com.app.tigr.domain.response.dialog.ItemsItem
import com.app.tigr.domain.send.Message
import com.app.tigr.ui.dialog.impl.ContractDialogPresenter
import com.app.tigr.ui.dialog.impl.ContractDialogView
import com.app.tigr.ui.dialog.list.*
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class DialogPresenter: MvpPresenter<ContractDialogView>(), ContractDialogPresenter {

    private val context = App.appComponent.getContext()

    private var userId: Int = 0
    private var peerId: Int = 0

    private lateinit var config: PagedList.Config
    private lateinit var sourceFactory: DialogDataSourceFactory

    private lateinit var adapter: DialogAdapter

    private var newData: List<ItemsItem> = emptyList()


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
        config = DialogPageConfig.get()
        sourceFactory = DialogDataSourceFactory(userId, peerId)
        val pagedListLiveData = LivePagedListBuilder(sourceFactory, config).build()
        val callback = DialogDiffUtilCallback(sourceFactory.getData(), newDataInit(sourceFactory.getData()))
        adapter = DialogAdapter(context, callback)
        return pagedListLiveData to adapter
    }

    private fun newDataInit(oldData: List<ItemsItem>): List<ItemsItem> {
        return if (newData.isEmpty()) oldData else newData
    }

    override fun messageIsSending(message: Message) {
        val items = ItemsItem(
                fromId = userId,
                peerId = peerId,
                text = message.text,
                randomId = message.randomId
        )
        val messages = sourceFactory.getData() as ArrayList
        messages.add(0, items)
        newData = messages.toList()
        adapter.notifyItemChanged(0)

    }

    override fun messageIsSent(request: ResponseMsgSend) {
        sourceFactory.invalidate()
    }

    override fun viewIsPaused(){}

    override fun viewIsResumed(){}
}