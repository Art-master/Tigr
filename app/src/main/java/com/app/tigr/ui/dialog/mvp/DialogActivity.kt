package com.app.tigr.ui.dialog.mvp

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.paging.PagedList
import android.arch.paging.PagedListAdapter
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.app.tigr.R
import com.app.tigr.common.Constants
import com.app.tigr.domain.response.dialog.ItemsItem
import com.app.tigr.domain.send.Message
import com.app.tigr.ui.dialog.impl.ContractDialogView
import com.app.tigr.ui.dialog.list.DialogAdapter
import com.app.tigr.ui.sender.mvp.DataSenderFragment
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
    }

    override fun showDialog(pagedListLiveData: LiveData<PagedList<ItemsItem>>,
                            adapter: PagedListAdapter<ItemsItem, DialogAdapter.DialogViewHolder>) {

/*        adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                if (positionStart == 0) {
                    linearLayoutManager.scrollToPosition(0)
                }
            }
        })*/
        pagedListLiveData.observe(this, Observer { data-> adapter.submitList(data) })
        recyclerDialog.adapter = adapter
    }

    override fun updateDialog(pagedListLiveData: LiveData<PagedList<ItemsItem>>,
                              adapter: PagedListAdapter<ItemsItem, DialogAdapter.DialogViewHolder>) {
    }

    override fun showEditField(sendData: Message){
        val intent = Intent(applicationContext, DataSenderFragment::class.java)
        intent.putExtra(Constants.Keys.MESSAGE.name, sendData)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

        val fragment = DataSenderFragment()
        fragment.arguments = intent.extras
        supportFragmentManager.beginTransaction()
                .add(R.id.fmEditTextContainer, fragment)
                .commit()
    }

    override fun onStop() {
        super.onStop()
        recyclerDialog.adapter = null
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val id = intent!!.getIntExtra(Constants.Keys.MESSAGE_SENT.name, -1)
        presenter.dataMaybeUpdate(id)
    }
}