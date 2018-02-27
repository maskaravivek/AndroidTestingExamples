package com.maskaravivek.testingexamples.di

import android.app.Application
import android.content.Context
import com.maskaravivek.testingexamples.service.UserService

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
open class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal open fun provideUserService(context: Context): UserService {
        return UserService(context)
    }
}
