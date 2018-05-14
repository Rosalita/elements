package com.rosie.elements

import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito

class MainActivityTest {
    @Test
    fun trueIsTrue() {
        assertTrue(true)
    }

    @Test
    fun mockitoCanMockAClass(){
        val mockclass = Mockito.mock(MainActivity.Person::class.java)
        val greeting = mockclass.greet()
        assertEquals(greeting, "test")

    }


}