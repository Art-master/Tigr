package com.app.tigr.ui.dialog.list

import android.arch.paging.DataSource
import com.app.tigr.domain.response.dialog.ItemsItem

class DialogDataSourceFactory(userId: Int, peerId: Int) : DataSource.Factory<Int, ItemsItem>() {

    private val dataSource = DialogDataSource(userId, peerId)

    override fun create(): DataSource<Int, ItemsItem> {
        return  dataSource
    }

    fun invalidate(){
        dataSource.invalidate()
    }

    fun getData() = dataSource.oldData
}