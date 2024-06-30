package com.gorauskas.euler.sequences

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SequencesTest {
    @Test
    fun testFibonacciSequence() {
        Assertions.assertInstanceOf(Sequence::class.java, fibonacciSequence(3))
        Assertions.assertTrue(fibonacciSequence(5).toList() == listOf(0L, 1, 1, 2, 3))
        Assertions.assertTrue(fibonacciSequence(10).toList().equals(listOf(0L, 1, 1, 2, 3, 5, 8)))
    }

    @Test
    fun testPrimeSequence() {
        Assertions.assertInstanceOf(Sequence::class.java, primeSequence(3))
        Assertions.assertTrue(primeSequence(10).toList() == listOf(2L, 3, 5, 7))
        Assertions.assertTrue(primeSequence(6, 14).toList().equals(listOf(7L, 11, 13)))
    }

    @Test
    fun testTriangleSequence() {
        Assertions.assertInstanceOf(Sequence::class.java, triangleSequence(3))
        Assertions.assertTrue(triangleSequence(10).toList() == listOf(1L, 3, 6))
        Assertions.assertTrue(triangleSequence(20).toList() == listOf(1L, 3, 6, 10, 15))
    }

    @Test
    fun testCollatzSequence() {
        Assertions.assertInstanceOf(Sequence::class.java, collatzSequence(3))
        Assertions.assertTrue(collatzSequence(2).toList() == listOf(2L, 1))
        Assertions.assertTrue(collatzSequence(5).toList() == listOf(5L, 16, 8, 4, 2, 1))
    }

    @Test
    fun testPermutations() {
        Assertions.assertInstanceOf(Sequence::class.java, permutations("ABC".toList(), 2))
        Assertions.assertTrue(
            permutations("ABCD".toList(), 2).map { it.joinToString("") }.toList() ==
                listOf("AB", "AC", "AD", "BA", "BC", "BD", "CA", "CB", "CD", "DA", "DB", "DC"),
        )
        Assertions.assertTrue(
            permutations((0 until 3)).map { it.joinToString("") }.toList() ==
                listOf("012", "021", "102", "120", "201", "210"),
        )
    }
}
