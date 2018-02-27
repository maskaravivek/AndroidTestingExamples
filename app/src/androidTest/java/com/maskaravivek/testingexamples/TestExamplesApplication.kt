package com.maskaravivek.testingexamples

import android.content.Context
import com.maskaravivek.testingexamples.di.AppComponent
import com.maskaravivek.testingexamples.di.AppModule
import com.maskaravivek.testingexamples.di.DaggerAppComponent
import com.maskaravivek.testingexamples.service.UserService
import dagger.Module
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.`when`


class TestExamplesApplication : ExamplesApplication() {

    override fun initAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .application(this)
                .build()
    }

    @Module
    private inner class MockApplicationModule internal constructor() : AppModule() {
        override fun provideUserService(context: Context): UserService {
            val mock = Mockito.mock(UserService::class.java)
            `when`(mock.displayUserName(ArgumentMatchers.anyString())).thenReturn("Hello Test!")
            return mock
        }
    }
}

