package com.app.tigr.ui.dialog.mvp

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.paging.PagedList
import android.arch.paging.PagedListAdapter
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.app.tigr.R
import com.app.tigr.domain.response.dialog.ItemsItem
import com.app.tigr.domain.send.Message
import com.app.tigr.ui.dialog.impl.ContractDialogView
import com.app.tigr.ui.dialog.list.DialogAdapter
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity: MvpAppCompatActivity(), ContractDialogView {

    @InjectPresenter
    lateinit var presenter: DialogPresenter

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.reverseLayout = true
        recyclerDialog!!.layoutManager = linearLayoutManager

        presenter.attachView(this)
        if(savedInstanceState==null){
            presenter.viewIsReady(intent)
        }

        sendMessageButton.setOnClickListener { _ ->
            val text = editTextSendMessage.text.toString()
            editTextSendMessage.text!!.clear()
            val message = Message(text = text)
            presenter.messageIsSending(message)
        }

    }

    override fun showDialog(pagedListLiveData: LiveData<PagedList<ItemsItem>>,
                            adapter: PagedListAdapter<ItemsItem, DialogAdapter.DialogViewHolder>) {

        pagedListLiveData.observe(this, Observer { data-> adapter.submitList(data) })
        recyclerDialog.adapter = adapter
    }

    override fun showEditField() {

    }

    override fun messageIsSent() {

    }

    override fun onStop() {
        super.onStop()
        recyclerDialog.adapter = null
    }
}