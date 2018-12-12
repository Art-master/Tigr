package com.app.tigr

import android.app.Activity
import android.app.Application
import com.app.tigr.common.Settings
import com.app.tigr.dagger.AppComponent
import com.app.tigr.dagger.ContextModule
import com.app.tigr.dagger.DaggerAndroidAppComponent
import com.app.tigr.dagger.DaggerAppComponent
import com.squareup.leakcanary.LeakCanary
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKAccessTokenTracker
import com.vk.sdk.VKSdk
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    companion object {
        lateinit var appComponent: AppComponent
    }

    private val tokenTracker = object : VKAccessTokenTracker() {
        override fun onVKAccessTokenChanged(oldToken: VKAccessToken?, newToken: VKAccessToken?) {
            if (newToken == null) {
                val preference = appComponent.getPreferences()
                preference.set(Settings.Name.USER_TOKEN, oldToken!!.accessToken)
            }
        }

    }

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)

        DaggerAndroidAppComponent
                .builder()
                .context(this)
                .build()
                .inject(this)


        appComponent = DaggerAppComponent
                .builder()
                .contextModule(ContextModule(this))
                .build()

        tokenTracker.startTracking()
        VKSdk.initialize(applicationContext)
    }

    override fun activityInjector() = dispatchingAndroidInjector


}