package com.app.tigr.ui.dialog.mvp

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.paging.PagedList
import android.arch.paging.PagedListAdapter
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.app.tigr.R
import com.app.tigr.domain.response.dialog.ItemsItem
import com.app.tigr.domain.params.MessageParam
import com.app.tigr.ui.dialog.HidingScrollListener
import com.app.tigr.ui.dialog.impl.ContractDialogView
import com.app.tigr.ui.dialog.list.DialogAdapter
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import kotlinx.android.synthetic.main.activity_dialog.*
import android.view.animation.DecelerateInterpolator
import android.view.animation.AccelerateInterpolator


class DialogActivity: MvpAppCompatActivity(), ContractDialogView {

    @InjectPresenter(tag = "dialog_presenter", type = PresenterType.GLOBAL)
    lateinit var presenter: DialogPresenter

    private val linearLayoutManager = LinearLayoutManager(this)
            .apply { reverseLayout = true }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        recyclerDialog!!.layoutManager = linearLayoutManager

        presenter.attachView(this)

        if (savedInstanceState == null) presenter.viewIsReady(intent)

        sendMessageButton.setOnClickListener { _ ->
            val text = editTextSendMessage.text.toString()
            if (text.isEmpty().not()) {
                editTextSendMessage.text!!.clear()
                val message = MessageParam(text = text)
                presenter.messageIsSending(message)
            }
        }
    }

    override fun showDialog(pagedListLiveData: LiveData<PagedList<ItemsItem>>,
                            adapter: PagedListAdapter<ItemsItem, DialogAdapter.DialogViewHolder>) {

        pagedListLiveData.observe(this, Observer { data-> adapter.submitList(data) })
        recyclerDialog.adapter = adapter

        recyclerDialog.addOnScrollListener(object : HidingScrollListener() {
            override fun onHide() = hideViews()
            override fun onShow() = showViews()
        })
    }

    override fun showEditField() {}

    override fun messageIsSent() {}

    private fun hideViews() {
        senderContainer
                .animate()
                .translationY(senderContainer.height.toFloat())
                .setDuration(300)
                .setInterpolator(AccelerateInterpolator(1f))
                .withStartAction { senderContainer.visibility = View.GONE }
                .start()
    }

    private fun showViews() {
        senderContainer
                .animate()
                .translationY(0F)
                .setDuration(300)
                .setInterpolator(DecelerateInterpolator(1f))
                .withEndAction { senderContainer.visibility = View.VISIBLE }
                .start()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView(this)
        recyclerDialog.adapter = null
    }
}