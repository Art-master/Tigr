package com.app.tigr.ui.sender.mvp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.tigr.R
import com.app.tigr.common.Constants
import com.app.tigr.domain.send.Message
import com.app.tigr.ui.dialog.mvp.DialogActivity
import com.app.tigr.ui.sender.impl.ContractSenderView
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_dialog_text_send.view.*

class DataSenderFragment: MvpAppCompatFragment(), ContractSenderView{

    @InjectPresenter
    lateinit var presenter: DataSenderPresenter

    private lateinit var message: Message

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        if(savedInstanceState==null){
            message = arguments!!.get(Constants.Keys.MESSAGE.name) as Message
            presenter.viewIsReady()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dialog_text_send, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.sendMessageButton.setOnClickListener { _ ->
            message.message = view.editTextSendMessage.text.toString()
            view.editTextSendMessage.text!!.clear()
            view.editTextSendMessage.clearFocus()
            presenter.dataMaybeSend(message) }
    }

    override fun addDataIntoDialog(msgId: Int) {
        val intent = Intent(context, DialogActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        intent.putExtra(Constants.Keys.MESSAGE_SENT.name, msgId)
        startActivity(intent)
    }
}