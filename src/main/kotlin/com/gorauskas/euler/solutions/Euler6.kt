package com.gorauskas.euler.solutions

import com.gorauskas.euler.EulerSolution

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
    is: ${solve().toLong()}
    """.trimIndent()

    @Suppress("MaxLineLength")
    override fun solve(): Long =
        (Math.pow((1..100).map { it.toDouble() }.sum(), 2.0) - (1..100).map { Math.pow(it.toDouble(), 2.0) }.sum()).toLong()
}
