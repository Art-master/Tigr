package com.app.tigr.ui.sender.mvp

import com.app.tigr.data.network.ApiProvider
import com.app.tigr.domain.send.Message
import com.app.tigr.ui.sender.impl.ContractSenderPresenter
import com.app.tigr.ui.sender.impl.ContractSenderView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

@InjectViewState
class DataSenderPresenter : MvpPresenter<ContractSenderView>(), ContractSenderPresenter {

    private val dispose = CompositeDisposable()

    override fun viewIsReady() {
    }

    override fun dataMaybeSend(data: Message) {
        val request = ApiProvider().sendMessage(message = data)
                .subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = {dat ->
                            viewState.addDataIntoDialog(dat.response!!)},
                        onError = { it.printStackTrace() })
        dispose.add(request)
        // dispose.clear()
    }

    override fun viewIsPaused() {}

    override fun viewIsResumed() {}

}