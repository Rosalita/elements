package com.rosie.elements

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.rule.GrantPermissionRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {


    // a rule to launch a single activity prior to every test
    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    // a rule to grant tests the run time permission ACCESS_FINE_LOCATION
    @Rule
    @JvmField
    val permissionRule = GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION)

    @Test
    fun shouldSayHello() {
        onView(withId(R.id.welcome_text))
                .check(matches(isDisplayed()))
                .check(matches(withText("Hello")))
    }

    @Test
    fun shouldNotDisplayLocationTextOnStartUp(){
        onView(withId(R.id.location_text_view))
                .check(matches(not(isDisplayed())))
    }

    @Test
    fun shouldDisplayGettingLocationTextAfterGetLocationButtonClicked(){
        onView(withId(R.id.location_button)).perform(click())
        onView(withId(R.id.location_text_view))
                .check(matches(isDisplayed()))

    }
}