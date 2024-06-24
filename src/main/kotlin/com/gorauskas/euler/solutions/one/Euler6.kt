package com.gorauskas.euler.solutions.one

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer
import kotlin.math.pow

class Euler6 : EulerSolution {
    override val problem = """
    Project Euler Problem 6:

        The sum of the squares of the first ten natural numbers is,

        12 + 22 + ... + 102 = 385

        The square of the sum of the first ten natural numbers is,

        (1 + 2 + ... + 10)2 = 552 = 3025

        Hence the difference between the sum of the squares of the
        first ten natural numbers and the square of the sum is
        3025  385 = 2640.

        Find the difference between the sum of the squares of the
        first one hundred natural numbers and the square of the sum.
    """.trimIndent()

    override val answer = """

    The difference between the sum of the squares
    and the square of the sum of the first 100 numbers
    is: ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long {
        val difference = (1L..100L).sumOf { it.toDouble() }.pow(2.0) -
            (1L..100L).sumOf { it.toDouble().pow(2.0) }
        return difference.toLong()
    }
}
