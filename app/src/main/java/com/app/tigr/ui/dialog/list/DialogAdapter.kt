package com.app.tigr.ui.dialog.list

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.tigr.R
import com.app.tigr.common.TUtils
import com.app.tigr.data.transformations.CircularTransformation
import com.app.tigr.domain.response.common.ProfilesItem
import com.app.tigr.domain.response.dialog.ItemsItem
import com.app.tigr.domain.response.message.Attachment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dialog_item.view.*
import org.jetbrains.anko.image
import java.text.SimpleDateFormat
import java.util.*

class DialogAdapter(val context: Context, val peerId: Int, itemCallback: DialogDiffUtilCallback)
    : PagedListAdapter<ItemsItem, DialogAdapter.DialogViewHolder>(itemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): DialogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val inflatedView = inflater.inflate(R.layout.dialog_item, parent, false)
        return DialogViewHolder(inflatedView!!)
    }

    override fun onBindViewHolder(viewHolder: DialogViewHolder, index: Int) {
        viewHolder.bind(getItem(index)!!)
    }

    inner class DialogViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(items: ItemsItem) {

            val userId = items.fromId
            val userItem = getUserById(items.profiles, userId)

            chooseSideForMessage(items.fromId)
            loadAvatar(userItem!!)
            setTextMessage(items)
            prepareAttachments(items)
            setDate(items.date)
        }

        private fun getUserById(data: List<ProfilesItem>, id: Int) = data.find { it -> it.id == id }

        private fun chooseSideForMessage(fromId: Int) {
            if (isPeerUser(fromId)) {
                reflectContainer(-1F)
                view.messageDialog.gravity = Gravity.END
            } else {
                reflectContainer(1F)
                view.messageDialog.gravity = Gravity.START
            }
        }

        private fun isPeerUser(id: Int) = (id == peerId)

        private fun reflectContainer(value: Float) {
            view.apply {
                scaleX = value
                userAvatar.scaleX = value
                messageDialog.scaleX = value
            }
        }

        private fun loadAvatar(userItem: ProfilesItem) {
            Picasso.with(context)
                    .load(userItem.photo100)
                    .transform(CircularTransformation())
                    .into(view.userAvatar)
        }

        private fun setTextMessage(item: ItemsItem) {
            view.textMessage.text = item.text

            view.messageTextContainer.visibility =
                    if (item.text.isEmpty())
                        View.GONE
                    else
                        View.VISIBLE
        }

        private fun prepareAttachments(data: ItemsItem) {
            clearStickerContainer()
            for (element in data.attachments) {
                when (element.type) {
                    Attachment.Type.PHOTO.value -> element.photo.accessKey

                    Attachment.Type.STICKER.value -> {
                        val url = element.sticker.images[2].url
                        loadSticker(url, 120, 120)
                    }
                }
            }
        }

        private fun clearStickerContainer() {
            view.sticker.image = null
            view.sticker.layoutParams.width = 0
            view.sticker.layoutParams.height = 0
        }

        private fun loadSticker(link: String, heightPx: Int, widthPx: Int) {
            val height = TUtils.convertDpToPx(heightPx.toFloat())
            val width = TUtils.convertDpToPx(widthPx.toFloat())
            view.sticker.layoutParams.height = height
            view.sticker.layoutParams.width = width
            view.sticker.setImageDrawable(null)
            Picasso.with(context)
                    .load(link)
                    .into(view.sticker)
        }

        private fun setDate(dataInUnixtime: Int) {
            if (dataInUnixtime == 0) {
                view.messageTime.text = ""
            } else {
                val timePattern = SimpleDateFormat("d MMM HH:mm", Locale.getDefault())
                view.messageTime.text = timePattern.format((dataInUnixtime * 1000L))
            }
        }
    }
}