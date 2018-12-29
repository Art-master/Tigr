package com.app.tigr.ui.dialog.mvp

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.app.tigr.App
import com.app.tigr.common.Constants
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


    override fun viewIsReady(intent: Intent) {
        getParcelableData(intent.extras!!)
        buildPagedListAdapter()
        viewState.showEditField(messageDataParser())
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
        val callback = DialogDiffUtilCallback(sourceFactory.mOldData, sourceFactory.mNewData)
        val adapter = DialogAdapter(context, callback)
        return pagedListLiveData to adapter
    }

    private fun messageDataParser(): Message {
        return Message(userId = userId, peerId = peerId)
    }

    override fun dataMaybeUpdate(id: Int) {
        if(id!=0){
            sourceFactory.invalidate()
        }
    }

    override fun viewIsPaused(){}

    override fun viewIsResumed(){}
}