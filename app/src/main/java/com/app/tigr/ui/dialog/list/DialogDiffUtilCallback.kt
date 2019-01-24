package com.app.tigr.ui.dialog.list

import android.support.v7.util.DiffUtil
import com.app.tigr.domain.response.dialog.Dialogs
import com.app.tigr.domain.response.dialog.ItemsItem


class DialogDiffUtilCallback : DiffUtil.ItemCallback<ItemsItem>() {

    override fun areItemsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
        return oldItem.date == newItem.date
    }
}