package com.celites.kutils

import junit.framework.TestCase
import org.junit.Test

/**
 * Created by Prasham on 2/6/2016.
 */
class TextUtilsKtTest : TestCase() {

    @Test
    fun testIsEmptyString() {
        assertTrue("".isEmptyString())
        assertTrue("null".isEmptyString())
        assertFalse("Welcome to kotlin unit test".isEmptyString())
    }

    @Test
    fun testIsDigitOnly() {
        assertTrue("2488".isDigitOnly())
        assertFalse("15.0".isDigitOnly())
        assertFalse("null".isDigitOnly())
        assertTrue("12345678".isDigitOnly())

    }

    @Test
    fun testGetNumber() {
        assertTrue("2488".getNumber() == 2488)
        assertFalse("15.0".getNumber() == 15)
        assertTrue("15.0".getNumber() == 0)
        assertTrue("null".getNumber() == 0)
        assertTrue("12345678".getNumber() == 12345678)
    }

    @Test
    fun testAddToCommaSeparatedString() {
        var string = "a,b,c,d"
        assertTrue(string.addToCommaSeparatedString("a").equals(string))
        assertTrue(string.addToCommaSeparatedString("a", true).equals("a,b,c,d,a"))
        assertTrue(string.addToCommaSeparatedString("F").equals("a,b,c,d,F"))
    }

    @Test
    fun testFailSafeSplit() {
        assertEquals("a,b,c,d".failSafeSplit(","), (listOf("a", "b", "c", "d")))
        assertEquals("a@b@c@d".failSafeSplit("@"), (listOf("a", "b", "c", "d")))
        assertEquals("a@b@c@d".failSafeSplit(","), (listOf("a@b@c@d")))
        assertEquals("a".failSafeSplit(","), (listOf("a")))

    }
}