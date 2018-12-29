package com.app.tigr.ui.dialog.list

import android.arch.paging.DataSource
import com.app.tigr.domain.response.dialog.ItemsItem

class DialogDataSourceFactory(private val userId: Int,
                              private val peerId: Int): DataSource.Factory<Int, ItemsItem>() {
    var mOldData: List<ItemsItem> = emptyList()
    var mNewData: List<ItemsItem> = emptyList()

    private lateinit var dataSource: DialogDataSource

    override fun create(): DataSource<Int, ItemsItem> {
        dataSource = DialogDataSource(userId, peerId)
        return  dataSource
    }

    fun invalidate(){
        dataSource.invalidate()
    }
}