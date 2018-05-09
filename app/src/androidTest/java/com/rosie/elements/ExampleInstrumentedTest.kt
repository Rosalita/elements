package com.rosie.elements

import android.app.Activity
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import android.widget.TextView
import com.rosie.elements.R.id.hello_text
//import com.rosie.elements.R.id.main_text
import com.rosie.elements.R.id.text
import org.junit.Assert

import kotlinx.android.synthetic.main.activity_main.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.rosie.elements", appContext.packageName)
    }

    //@Test
    //fun test_itDisplaysHelloWorld()
       // import the view, not the id

       // val text = findViewById<TextView>(R.id.main_text)
       // val textView : textView  = main_text
       // val textView: TextView = findViewById<TextView>(R.id.main_text) as TextView

       // Log.d("TAG", textView)
       // val actual = textView.text.toString()
       // Assert.assertEquals("Hello World!", actual)
    //}
}




