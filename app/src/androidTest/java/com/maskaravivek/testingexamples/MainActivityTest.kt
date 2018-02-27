package com.maskaravivek.testingexamples

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField var activityActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {

    }

    @Test
    fun setUserName() {
        onView(withId(R.id.name_field)).perform(typeText("Vivek Maskara"))
        onView(withId(R.id.set_user_name)).perform(click())
        onView(withText("Hello Vivek Maskara!")).check(matches(isDisplayed()))
    }
}