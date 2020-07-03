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

    @Test
    fun testIsMultipleOf() {
        Assertions.assertTrue(10L.isMultipleOf(5L))
        Assertions.assertTrue(21L.isMultipleOf(7L))
        Assertions.assertFalse(10L.isMultipleOf(3L))
    }

    @Test
    fun testNumberOfDivisors() {
        Assertions.assertEquals(6L, 12L.numberOfDivisors())
        Assertions.assertEquals(8L, 24L.numberOfDivisors())
        Assertions.assertEquals(3L, 49L.numberOfDivisors())
        Assertions.assertEquals(2L, 53L.numberOfDivisors())
        Assertions.assertEquals(12L, 96L.numberOfDivisors())
    }
}