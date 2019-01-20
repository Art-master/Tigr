package com.app.tigr.ui.chat.mvp

import com.app.tigr.App
import com.app.tigr.common.Settings
import com.app.tigr.impl.AppPreferences
import com.app.tigr.ui.chat.impl.ContractChatPresenter
import com.app.tigr.ui.chat.impl.ContractChatView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@InjectViewState
class ChatPresenter : MvpPresenter<ContractChatView>(), ContractChatPresenter {

    private var preferences: AppPreferences = App.appComponent.getPreferences()
    private val connection = App.appComponent.getApi()

    private val dispose = CompositeDisposable()

    override fun viewIsReady() {
        getData()
    }

    private fun getData() {
        val token = getSavedToken()
        firstRequest(token)
    }

    private fun firstRequest(token: String) {
        val request = connection.getMessages(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onSuccess = { it ->
                            viewState.showChat(it.response)
                            repeatRequest(token)
                        },
                        onError = { it.printStackTrace() })
        dispose.add(request)
    }

    private fun repeatRequest(token: String) {
        val request = connection.getMessages(token)
                .delay(1, TimeUnit.SECONDS, Schedulers.io())
                .repeat()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onComplete = {},
                        onError = { it.printStackTrace() },
                        onNext = { it -> viewState.showChat(it.response) })
        dispose.add(request)
    }

    private fun getSavedToken() = preferences.get(Settings.Name.USER_TOKEN)!!

    override fun viewIsPaused() = dispose.clear()

    override fun viewIsResumed() = firstRequest(getSavedToken())

    override fun destroyView(view: ContractChatView?) {
        super.destroyView(view)
        dispose.clear()
    }
}