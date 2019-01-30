package com.app.tigr.ui.dialog.mvp

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.paging.PagedList
import android.arch.paging.PagedListAdapter
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.app.tigr.R
import com.app.tigr.domain.response.dialog.ItemsItem
import com.app.tigr.domain.params.MessageParam
import com.app.tigr.ui.dialog.impl.ContractDialogView
import com.app.tigr.ui.dialog.list.DialogAdapter
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_dialog.*
class DialogActivity: MvpAppCompatActivity(), ContractDialogView {

    @InjectPresenter
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
        recyclerDialog.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                senderContainer.apply {
                    if (dy < 0 && visibility == View.VISIBLE) {
                        visibility = View.GONE
                    } else if (dy > 0 && visibility != View.VISIBLE) {
                        visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    override fun showEditField() {}

    override fun messageIsSent() {}

    override fun onStop() {
        super.onStop()
    }
}