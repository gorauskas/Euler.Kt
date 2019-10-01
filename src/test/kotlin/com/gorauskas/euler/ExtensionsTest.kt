package com.gorauskas.euler

import com.gorauskas.euler.extensions.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ExtensionsTest {

    @Test
    fun testIsPrime() {
        Assertions.assertTrue(1217L.isPrime())
        Assertions.assertTrue(65867L.isPrime())
        Assertions.assertFalse(4L.isPrime())
        Assertions.assertFalse(6005L.isPrime())
    }

    @Test
    fun testIsPalindrome() {
        Assertions.assertTrue(2442L.isPalindrome())
        Assertions.assertTrue(12321L.isPalindrome())
        Assertions.assertFalse(123456L.isPalindrome())
    }

    @Test
    fun testGcd() {
        Assertions.assertEquals(14, 98L.gcd(56))
        Assertions.assertEquals(3, 57L.gcd(144))
        Assertions.assertEquals(24, 144L.gcd(168))
    }
}