package com.gorauskas.euler

import com.gorauskas.euler.extensions.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigInteger

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

    @Test
    fun testLongFactorial() {
        Assertions.assertEquals(479001600L, 12L.factorial())
        Assertions.assertEquals(120L, 5L.factorial())
        Assertions.assertEquals(6227020800L, 13L.factorial())
        Assertions.assertEquals(2432902008176640000L, 20L.factorial())
    }

    @Test
    fun testDoubleFactorial() {
        Assertions.assertEquals(479001600L, 12L.factorial())
        Assertions.assertEquals(120L, 5L.factorial())
        Assertions.assertEquals(6227020800L, 13L.factorial())
        Assertions.assertEquals(2432902008176640000L, 20L.factorial())
    }

    @Test
    fun testBigIntegerFactorial() {
        Assertions.assertEquals(BigInteger("15511210043330985984000000"), BigInteger("25").factorial())
        Assertions.assertEquals(BigInteger("8222838654177922817725562880000000"), BigInteger("31").factorial())
        Assertions.assertEquals(BigInteger("2432902008176640000"), BigInteger("20").factorial())
    }

    @Test
    fun testSumOfDivisors() {
        Assertions.assertEquals(6L, 6L.sumOfDivisors())
        Assertions.assertEquals(117L, 100L.sumOfDivisors())
    }

    @Test
    fun testIsPanDigital() {
        Assertions.assertFalse(135587254L.isPanDigital())
        Assertions.assertTrue(391867254L.isPanDigital())
    }

    @Test
    fun testGetDataFromUri() {
        Assertions.assertEquals("Jonas Gorauskas", javaClass.getResource("/test.txt")!!.toURI().getData())
    }
}
