package com.app.tigr.ui.dialog.list

import android.support.v7.util.DiffUtil
import com.app.tigr.domain.response.dialog.ItemsItem


class DialogDiffUtilCallback(oldList: List<ItemsItem>, newList: List<ItemsItem>)
    : DiffUtil.ItemCallback<ItemsItem>(){

    private var old: List<ItemsItem>? = oldList
    private var new: List<ItemsItem>? = newList

    override fun areItemsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ItemsItem, newItem: ItemsItem): Boolean {
        return oldItem.date == newItem.date
    }
}