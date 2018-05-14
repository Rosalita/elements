package com.rosie.elements

import android.support.test.espresso.Espresso
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun shouldSayHello() {
        Espresso.onView(ViewMatchers.withId(R.id.welcome_text))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                .check(ViewAssertions.matches(withText("Hello")))
    }

    @Test
    fun shouldDisplayGettingLocationTextAfterGetLocationButtonClicked(){
        Espresso.onView(ViewMatchers.withId(R.id.location_button)).perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.location_text_view))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}