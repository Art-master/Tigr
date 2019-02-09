package com.app.tigr.ui.dialog.list

import android.arch.paging.PagedListAdapter
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.app.tigr.R
import com.app.tigr.common.TUtils
import com.app.tigr.data.transformations.CircularTransformation
import com.app.tigr.domain.response.common.ProfilesItem
import com.app.tigr.domain.response.dialog.ItemsItem
import com.app.tigr.domain.response.message.Attachment
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dialog_item.view.*
import org.jetbrains.anko.image
import org.jetbrains.anko.padding
import java.text.SimpleDateFormat
import java.util.*
import com.app.tigr.App
import com.app.tigr.ui.dialog.custom.MusicMsgPlayerLayout


class DialogAdapter(val peerId: Int, itemCallback: DialogDiffUtilCallback)
    : PagedListAdapter<ItemsItem, DialogAdapter.DialogViewHolder>(itemCallback) {

    private val context = App.appComponent.getContext()

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
            val userItem = getUserById(items.profiles, userId)!!

            view.messageTextContainer.removeAllViews()

            chooseSideForMessage(items.fromId)
            loadAvatar(userItem)
            setTextMessage(items)
            prepareAttachments(items)
            setDate(items.date)
        }

        private fun getUserById(data: List<ProfilesItem>, id: Int) = data.find { it -> it.id == id }

        private fun chooseSideForMessage(fromId: Int) {
            if (isPeerUser(fromId)) {
                reflectContainer(-1F)
                view.messageDialog.gravity = Gravity.START
            } else {
                reflectContainer(1F)
                view.messageDialog.gravity = Gravity.END
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
            if (item.text.isEmpty().not()) {
                val textView = TextView(context)
                textView.text = item.text
                view.messageTextContainer.addView(textView)
            }

            // view.textMessage.text = item.text

/*            view.messageTextContainer.visibility =
                    if (item.text.isEmpty())
                        View.GONE
                    else
                        View.VISIBLE*/
        }

        private fun prepareAttachments(data: ItemsItem) {
            clearStickerContainer()
            view.photoContainer.removeAllViews()
            for (element in data.attachments) {
                when (element.type) {
                    Attachment.Type.PHOTO.value -> {
                        val key = element.photo.accessKey
                        val image = ImageView(context)
                        image.padding = 2
                        //image.layoutParams.width = element.photo.sizes[0].width
                        //image.layoutParams.height = element.photo.sizes[0].height
                        Picasso.with(context)
                                .load(element.photo.sizes[2].url)
                                .into(image)
                        view.photoContainer.addView(image)
                        //loadPhotos(element.photo)
                    }

                    Attachment.Type.STICKER.value -> {
                        val url = element.sticker.images[2].url
                        loadSticker(url)
                    }

                    Attachment.Type.AUDIO.value -> {
                        val musicView = MusicMsgPlayerLayout(context)
                        musicView.init(element.audio)
                        view.messageTextContainer.addView(musicView)
                    }
                    else -> {
                    }
                }
            }

        }

        private fun clearStickerContainer() {
            view.sticker.apply {
                image = null
                layoutParams.width = 0
                layoutParams.height = 0
            }
        }

        private fun loadSticker(link: String, heightPx: Int = 120, widthPx: Int = 120) {
            val height = TUtils.convertDpToPx(heightPx.toFloat())
            val width = TUtils.convertDpToPx(widthPx.toFloat())
            view.sticker.apply {
                layoutParams.height = height
                layoutParams.width = width
                setImageDrawable(null)
            }
            Glide.with(context)
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

        private fun loadPhotos() {

        }
    }
}