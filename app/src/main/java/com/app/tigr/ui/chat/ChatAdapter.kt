package com.app.tigr.ui.chat

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.app.tigr.R
import kotlinx.android.synthetic.main.chat_item.view.*
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.app.tigr.common.Constants
import com.app.tigr.data.transformations.CircularTransformation
import com.app.tigr.domain.response.common.Peer
import com.app.tigr.domain.response.message.Conversations
import com.app.tigr.ui.dialog.mvp.DialogActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.notification_template_lines_media.view.*


class ChatAdapter(var data: Conversations)
    : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val inflatedView = inflater.inflate(R.layout.chat_item, parent, false)
        return ViewHolder(inflatedView!!)
    }

    override fun getItemCount(): Int = data.count

    override fun onBindViewHolder(holder: ViewHolder, index: Int) {
        holder.bind(data, index)
    }

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private var userId = 0
        private var peerId = 0

        fun bind(data: Conversations, index: Int) {
            view.setOnClickListener(this)

            val items = data.items
            items[index].apply {
                itemView.textLastMessage.text = lastMessage.text
                checkUnreadMessages(conversation.unreadCount)
            }

            peerId = items[index].conversation.peer.id

            if (items[index].conversation.peer.type == Peer.USER) {
                var profileId = items[index].lastMessage.peerId

                findUserById(data, profileId)!!
                        .apply {
                            setDialogName("$firstName $lastName")
                            loadAvatarDialog(photo100)
                            userId = id
                        }
                profileId = items[index].lastMessage.fromId
                findUserById(data, profileId)!!
                        .apply {
                            loadLastMsgAvatar(photo50)
                        }
            } else if (items[index].conversation.peer.type == Peer.GROUP) {
                val groupId = Math.abs(items[index].lastMessage.peerId)
                findGroupById(data, groupId)!!
                        .apply {
                            setDialogName(name)
                            loadAvatarDialog(photo100)
                            loadLastMsgAvatar(photo50)
                            userId = id
                        }
            }
        }

        private fun checkUnreadMessages(count: Int) {
            itemView.unReadContainer.apply {
                if (count > 0) {
                    itemView.unReadMessages.text = "+$count"
                    visibility = View.VISIBLE
                    animation = AnimationUtils.loadAnimation(context, R.anim.scale_item)
                    animation.start()
                } else {
                    itemView.unReadMessages.text = ""
                    visibility = View.GONE
                }
            }
        }

        private fun findUserById(data: Conversations, id: Int) = data.profiles.find { it.id == id }

        private fun findGroupById(data: Conversations, id: Int) = data.groups.find { it.id == id }

        private fun setDialogName(name: String) {
            itemView.textUserName.text = name
        }

        private fun setMessageText(name: String) {
            itemView.textUserName.text = name
        }

        private fun loadAvatarDialog(url: String) = loadCircularImage(url, itemView.imageUser)

        private fun loadLastMsgAvatar(url: String) = loadCircularImage(url, itemView.imageLastMessagePersona)

        private fun loadCircularImage(url: String, image: ImageView) {
            Picasso.with(view.context)
                    .load(url)
                    .transform(CircularTransformation())
                    .into(image)
        }

        override fun onClick(v: View?) = view.context.startActivity(prepareIntent())

        private fun prepareIntent(): Intent {
            return Intent(view.context, DialogActivity::class.java)
                    .apply {
                        addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                        putExtra(Constants.Keys.USER_ID.name, userId)
                        putExtra(Constants.Keys.PEER_ID.name, peerId)
                    }
        }
    }
}


