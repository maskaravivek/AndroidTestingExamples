package com.maskaravivek.testingexamples.service

import android.content.Context
import com.maskaravivek.testingexamples.R

import java.util.Locale

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class UserService @Inject
constructor(private var context: Context) {

    open fun displayUserName(name: String): String {
        val userNameFormat = context.getString(R.string.display_user_name)
        return String.format(Locale.ENGLISH, userNameFormat, name)
    }
}
