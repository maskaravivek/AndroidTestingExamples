package com.maskaravivek.testingexamples

import android.app.Application
import android.content.Context
import com.maskaravivek.testingexamples.di.AppComponent
import com.maskaravivek.testingexamples.di.AppModule
import com.maskaravivek.testingexamples.di.DaggerAppComponent
import com.maskaravivek.testingexamples.service.UserService
import dagger.Module
import org.mockito.Mockito
import org.mockito.Mockito.`when`


class TestExamplesApplication : ExamplesApplication() {

    override fun initAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(MockApplicationModule(this))
                .build()
    }

    @Module
    private inner class MockApplicationModule internal constructor(application: Application) : AppModule(application) {
        override fun provideContext(): Context {
            return application
        }

        override fun provideUserService(context: Context): UserService {
            val mock = Mockito.mock(UserService::class.java)
            `when`(mock!!.displayUserName("Test")).thenReturn("Hello Test!")
            return mock
        }
    }
}

