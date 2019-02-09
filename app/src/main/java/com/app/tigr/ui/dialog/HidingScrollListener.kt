package com.app.tigr.ui.dialog

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager


abstract class HidingScrollListener : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val firstVisibleItem =
                (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

        if (firstVisibleItem == 1) {
            onHide()
        } else if (firstVisibleItem == 0) {
            onShow()
        }
    }

    abstract fun onHide()
    abstract fun onShow()
}