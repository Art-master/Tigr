package com.app.tigr.dagger

import com.app.tigr.StartActivity
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
    fun loadingScreenActivityInjector(): StartActivity
}