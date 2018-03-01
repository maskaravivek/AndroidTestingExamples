package com.maskaravivek.testingexamples.di

import android.app.Application
import android.content.Context
import com.maskaravivek.testingexamples.service.UserService

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
open class AppModule(val application: Application) {

    @Provides
    @Singleton
    internal open fun provideContext(): Context {
        return application
    }

    @Provides
    @Singleton
    internal open fun provideUserService(context: Context): UserService {
        return UserService(context)
    }
}
