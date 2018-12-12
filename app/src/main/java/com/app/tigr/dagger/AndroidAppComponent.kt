package com.app.tigr.dagger

import android.content.Context
import com.app.tigr.App
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppAndroidModule::class])
interface AndroidAppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AndroidAppComponent
    }

    fun inject(app: App)
}