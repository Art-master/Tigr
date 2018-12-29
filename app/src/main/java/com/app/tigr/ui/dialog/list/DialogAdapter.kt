package com.app.tigr.ui.dialog.list

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.tigr.R
import com.app.tigr.domain.response.dialog.ItemsItem
import kotlinx.android.synthetic.main.dialog_item.view.*

class DialogAdapter(val context: Context, itemCallback: DialogDiffUtilCallback)
    : PagedListAdapter<ItemsItem, DialogAdapter.DialogViewHolder>(itemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): DialogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val inflatedView = inflater.inflate(R.layout.dialog_item, parent, false)
        return DialogViewHolder(inflatedView!!)
    }

    override fun onBindViewHolder(viewHolder: DialogViewHolder, index: Int) {
        viewHolder.bind(getItem(index))
    }

    inner class DialogViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(data: ItemsItem?) {
            view.textMessage.text = data!!.text

        }
    }
    private fun prepareAttachments(data: ItemsItem?, index: Int) {
        for (element in data!!.attachments!!) {
            when (element!!.type){
                ItemsItem.Type.PHOTO.name -> {
                    val key= data.attachments!![index]!!.photo!!.accessKey
                }
                ItemsItem.Type.STICKER.name -> {}
            }

        }
    }

    private fun loadImage(){

    }
}