package com.app.tigr.ui.dialog.list

import android.arch.paging.PositionalDataSource
import com.app.tigr.data.network.ApiProvider
import com.app.tigr.domain.response.ResponseDialog
import com.app.tigr.domain.response.dialog.ItemsItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class DialogDataSource(private val userId: Int,
                       private val peerId: Int) : PositionalDataSource<ItemsItem>() {
    var oldData: List<ItemsItem> = emptyList()

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<ItemsItem>) {
        ApiProvider().getDialog(params.startPosition, params.loadSize, userId, peerId)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = { data ->
                            callback.onResult(data.response.items)
                            setValue(data)
                        },
                        onError = { it.printStackTrace() })
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<ItemsItem>) {
        ApiProvider().getDialog(params.requestedStartPosition, params.requestedLoadSize, userId, peerId)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = { data ->
                            callback.onResult(data.response.items, 0)
                            setValue(data)
                        },
                        onError = { it.printStackTrace() })
    }

    private fun setValue(data: ResponseDialog) {
        oldData = data.response.items
    }
}