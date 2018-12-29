package com.app.tigr.ui.chat

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.app.tigr.R
import kotlinx.android.synthetic.main.chat_item.view.*
import android.view.LayoutInflater
import com.app.tigr.common.Constants
import com.app.tigr.data.transformations.CircularTransformation
import com.app.tigr.domain.response.common.Peer
import com.app.tigr.domain.response.message.Conversations
import com.app.tigr.ui.dialog.mvp.DialogActivity
import com.squareup.picasso.Picasso


class ChatAdapter(private val data: Conversations?, private val ctx: Context)
    : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val inflatedView = inflater.inflate(R.layout.chat_item, parent, false)
        return ViewHolder(inflatedView!!)
    }

    override fun getItemCount(): Int = data!!.count!!

    override fun onBindViewHolder(holder: ViewHolder, index: Int) {
        holder.bind(data, index)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        var view: View? = view
        private var userId = 0
        private var peerId =0

        fun bind(data: Conversations?, index: Int) {
            view!!.setOnClickListener(this)
            val items = data!!.items
            itemView.textLastMessage.text = items!![index]!!.lastMessage!!.text
            var uri = ""
            var name = ""
            var uriImageLastMsgPersona = ""
            peerId = items[index]!!.conversation!!.peer!!.id!!

            if (items[index]!!.conversation!!.peer!!.type == Peer.USER) {
                var ind = findUserForId(data, data.items!![index]!!.lastMessage!!.peerId!!)
                name = data.profiles!![ind]!!.firstName!! + " " + data.profiles[ind]!!.lastName!!
                uri = data.profiles[ind]!!.photo100!!
                ind =findUserForId(data, data.items[index]!!.lastMessage!!.fromId!!)
                userId = data.profiles[ind]!!.id!!
                uriImageLastMsgPersona = data.profiles[ind]!!.photo50!!
            } else if (items[index]!!.conversation!!.peer!!.type == Peer.GROUP) {
                var ind = findGroupForId(data, data.items!![index]!!.lastMessage!!.peerId!!)
                name = data.groups!![ind]!!.name!!
                uri = data.groups[ind]!!.photo100!!
                userId = data.groups[ind]!!.id!!
                ind =findUserForId(data, data.items[index]!!.lastMessage!!.fromId!!)
                uriImageLastMsgPersona = data.groups[ind]!!.photo50!!
            }

            itemView.textUserName.text = name
            val adr = uri
            Picasso.with(view!!.context)
                    .load(adr)
                    .transform(CircularTransformation())
                    .into(itemView.imageUser)
            Picasso.with(view!!.context)
                    .load(uriImageLastMsgPersona)
                    .transform(CircularTransformation())
                    .into(itemView.imageLastMessagePersona)
        }

        private fun findUserForId(data: Conversations?, id: Int): Int {
            for ((index, element) in data!!.profiles!!.withIndex()) {
                if (element!!.id == id) {
                    return index
                }
            }
            return 0
        }

        private fun findGroupForId(data: Conversations?, id: Int): Int {
            for ((index, element) in data!!.groups!!.withIndex()) {
                if (element!!.id == id) {
                    return index
                }
            }
            return 0
        }

        override fun onClick(v: View?) {
            view!!.context.startActivity(prepareIntent())
        }

        private fun prepareIntent(): Intent {
            val intent = Intent(view!!.context, DialogActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            intent.putExtra(Constants.Keys.USER_ID.name, userId)
            intent.putExtra(Constants.Keys.PEER_ID.name, peerId)
            return intent
        }
    }
}


