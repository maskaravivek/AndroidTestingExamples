package com.maskaravivek.testingexamples

import com.maskaravivek.testingexamples.di.AppComponent
import com.maskaravivek.testingexamples.di.DaggerAppComponent

class TestExamplesApplication : ExamplesApplication() {

    override fun initAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .application(this)
                .build()
    }
}

