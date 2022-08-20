package com.gorauskas.euler.solutions

import com.gorauskas.euler.EULER34_CHAR_OFFSET
import com.gorauskas.euler.EULER34_HIGH_RANGE
import com.gorauskas.euler.EulerSolution
import kotlin.Long

class Euler34 : EulerSolution {
    override fun solve(): Long {
        // pre-calculated factorials from 1 to 9
        val fact = listOf(1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L)
        var r = 0L

        (10..EULER34_HIGH_RANGE).map { n ->
            val x: Long = n.toString()
                .toCharArray()
                .map { it.code - EULER34_CHAR_OFFSET }
                .map { i -> fact.get(i) }
                .sum()

            if (n == x) {
                r += n
            }
        }
        return r
    }

    override val problem = """
        Project Euler Problem 34:

            145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

            Find the sum of all numbers which are equal to the sum of the factorial
            of their digits.

            Note: As 1! = 1 and 2! = 2 are not sums they are not included.
    """.trimIndent()

    override val answer = """

        The sum of all numbers which are equal to the sum of the factorial of
        their digits is ${solve()}
    """.trimIndent()
}
