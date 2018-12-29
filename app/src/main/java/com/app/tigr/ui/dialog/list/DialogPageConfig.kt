package com.app.tigr.ui.dialog.list

import android.arch.paging.PagedList

object DialogPageConfig{
    fun get(): PagedList.Config {
        return PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(INITIAL_LOAD_SIZE)
                .setPageSize(DIALOG_LIST_SIZE)
                .build()
    }
    private const val DIALOG_LIST_SIZE = 20
    private const val INITIAL_LOAD_SIZE = 60
}