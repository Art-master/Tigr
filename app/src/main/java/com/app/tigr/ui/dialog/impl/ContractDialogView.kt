package com.app.tigr.ui.dialog.impl

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.paging.PagedList
import android.arch.paging.PagedListAdapter
import com.app.tigr.domain.response.dialog.ItemsItem
import com.app.tigr.ui.dialog.list.DialogAdapter
import com.arellomobile.mvp.MvpView

interface ContractDialogView: MvpView {
    fun showDialog(pagedListLiveData: LiveData<PagedList<ItemsItem>>,
                   adapter: PagedListAdapter<ItemsItem, DialogAdapter.DialogViewHolder>)

    fun showEditField()
    fun messageIsSent()
}