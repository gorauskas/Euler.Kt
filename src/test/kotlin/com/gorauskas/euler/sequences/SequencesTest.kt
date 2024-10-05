package com.gorauskas.euler.sequences

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.stream.Collectors.toList

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
    fun testPentagonalSequence() {
        Assertions.assertInstanceOf(Sequence::class.java, pentagonalSequence(3L))
        Assertions.assertTrue(pentagonalSequence(25L).toList() == listOf(1L, 5, 12, 22))
        Assertions.assertTrue(pentagonalSequence(100L).toList() == listOf(1L, 5, 12, 22, 35, 51, 70, 92))
        Assertions.assertTrue(pentagonalSequence(100).count() == 100)
    }

    @Test
    fun testHexagonalSequence() {
        Assertions.assertInstanceOf(Sequence::class.java, hexagonalSequence(3))
        Assertions.assertTrue(hexagonalSequence(5).toList() == listOf(1L, 6, 15, 28, 45))
        Assertions.assertTrue(hexagonalSequence(50L).toList() == listOf(1L, 6, 15, 28, 45))
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

    @Test
    fun testProduct() {
        Assertions.assertInstanceOf(Sequence::class.java, product(listOf(1, 2), "ab".toList(), listOf(3.0, 4.0)))
        Assertions.assertTrue(
            product("ABCD".map { it.toString() }, "xy".map { it.toString() }).toList() ==
                listOf(
                    listOf("A", "x"),
                    listOf("A", "y"),
                    listOf("B", "x"),
                    listOf("B", "y"),
                    listOf("C", "x"),
                    listOf("C", "y"),
                    listOf("D", "x"),
                    listOf("D", "y"),
                ),
        )
        Assertions.assertTrue(
            product(0 until 2, repeat = 3).toList() ==
                listOf(
                    listOf(0, 0, 0),
                    listOf(0, 0, 1),
                    listOf(0, 1, 0),
                    listOf(0, 1, 1),
                    listOf(1, 0, 0),
                    listOf(1, 0, 1),
                    listOf(1, 1, 0),
                    listOf(1, 1, 1),
                ),
        )
    }

    @Test
    fun testCycle() {
        val cycles = "ABCD".map { it.toString() }.cycle()
        Assertions.assertInstanceOf(Sequence::class.java, cycles)
        Assertions.assertTrue(
            cycles.take(10).toList() ==
                listOf("A", "B", "C", "D", "A", "B", "C", "D", "A", "B"),
        )
    }
}
