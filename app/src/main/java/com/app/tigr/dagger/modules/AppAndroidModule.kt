package com.app.tigr.dagger.modules

import com.app.tigr.MainActivity
import com.app.tigr.dagger.AuthAppActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Basic application module
 */
@Module(includes = [AndroidSupportInjectionModule::class])
interface AppAndroidModule {

    @AuthAppActivityScope
    @ContributesAndroidInjector
    fun loadingScreenActivityInjector(): MainActivity
}