package com.maskaravivek.testingexamples

import android.app.Activity
import android.app.Application
import com.maskaravivek.testingexamples.di.AppComponent
import com.maskaravivek.testingexamples.di.AppModule

import com.maskaravivek.testingexamples.di.DaggerAppComponent

import javax.inject.Inject

import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector

open class ExamplesApplication : Application(), HasActivityInjector {
    @Inject lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        initAppComponent().inject(this)
    }

    open fun initAppComponent(): AppComponent {
        return DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingActivityInjector
    }
}