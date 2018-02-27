package com.maskaravivek.testingexamples.service

import android.content.Context
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.MockitoAnnotations


class UserServiceTest {

    @Mock internal var context: Context? = null

    @InjectMocks internal var userService: UserService? = null

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun displayUserName() {
        doReturn("Hello %s!").`when`(context)!!.getString(any(Int::class.java))
        val displayUserName = userService!!.displayUserName("Test")
        assertEquals(displayUserName, "Hello Test!")
    }
}