package com.maskaravivek.testingexamples

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.maskaravivek.testingexamples.service.UserService
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    var button: Button? = null
    var userNameField: EditText? = null
    var displayUserName: TextView? = null

    @Inject lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        button = this.findViewById(R.id.set_user_name)
        userNameField = this.findViewById(R.id.name_field)
        displayUserName = this.findViewById(R.id.display_user_name)

        this.button!!.setOnClickListener({
            displayUserName!!.text = userService.displayUserName(userNameField!!.text.toString())
        })
    }
}
