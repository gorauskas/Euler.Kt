package com.gorauskas.euler.extensions

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigInteger

class ExtensionsTest {
    @Test
    fun testIsPrime() {
        Assertions.assertTrue(1_217L.isPrime())
        Assertions.assertTrue(65_867L.isPrime())
        Assertions.assertFalse(4L.isPrime())
        Assertions.assertFalse(6_005L.isPrime())
    }

    @Test
    fun testIsPalindrome() {
        Assertions.assertTrue(2_442L.isPalindrome())
        Assertions.assertTrue(12_321L.isPalindrome())
        Assertions.assertFalse(123_456L.isPalindrome())
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
    fun testDivisors() {
        Assertions.assertInstanceOf(List::class.java, 999L.divisors())
        Assertions.assertTrue(999L.divisors().sorted() == listOf(1L, 3, 9, 27, 37, 111, 333, 999))
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
        Assertions.assertEquals(479_001_600L, 12L.factorial())
        Assertions.assertEquals(120L, 5L.factorial())
        Assertions.assertEquals(6_227_020_800L, 13L.factorial())
        Assertions.assertEquals(2_432_902_008_176_640_000L, 20L.factorial())
    }

    @Test
    fun testDoubleFactorial() {
        Assertions.assertEquals(479_001_600L, 12L.factorial())
        Assertions.assertEquals(120L, 5L.factorial())
        Assertions.assertEquals(6_227_020_800L, 13L.factorial())
        Assertions.assertEquals(2_432_902_008_176_640_000L, 20L.factorial())
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
        Assertions.assertFalse(135_587_254L.isPanDigital())
        Assertions.assertTrue(391_867_254L.isPanDigital())
    }

    @Test
    fun testIsPentagonal() {
        Assertions.assertTrue(35L.isPentagonal())
        Assertions.assertTrue(51L.isPentagonal())
        Assertions.assertTrue(70L.isPentagonal())
        Assertions.assertFalse(100L.isPentagonal())
    }

    @Test
    fun testStringLongLength() {
        Assertions.assertEquals("Euler".longLength(), 5L)
    }

    @Test
    fun testStringScore() {
        Assertions.assertEquals("Euler".toScore(), 189L)
    }

    @Test
    fun testGetDataFromUri() {
        Assertions.assertEquals("Project Euler", javaClass.getResource("/test.txt")!!.toURI().getData())
    }
}
