package com.gorauskas.euler.solutions.thirty

import com.gorauskas.euler.EULER32_HIGH_START
import com.gorauskas.euler.EULER32_LOW_START
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.isPanDigital
import com.gorauskas.euler.functions.timer

class Euler32 : EulerSolution {
    override val problem = """
        Project Euler Problem 32:

            We shall say that an n-digit number is pandigital if it makes use of all
            the digits 1 to n exactly once; for example, the 5-digit number, 15234,
            is 1 through 5 pandigital.

            The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing
            multiplicand, multiplier, and product is 1 through 9 pandigital.

            Find the sum of all products whose multiplicand/multiplier/product identity
            can be written as a 1 through 9 pandigital.

            HINT: Some products can be obtained in more than one way so be sure to
            only include it once in your sum.
    """.trimIndent()

    override val answer = """

        The sum of all products whose multiplicand/multiplier/product identity can
        be written as a 1 through 9 pandigital is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long = (1L..101L).flatMap { i ->
        val start = if (i > 9L) {
            EULER32_LOW_START
        } else {
            EULER32_HIGH_START
        }
        (start..10_000L / i + 1L).map { j ->
            Triple(i, j, "$i$j${i * j}")
        }.filter {
            it.third.toLong().isPanDigital()
        }.map {
            it.first * it.second
        }
    }.toSet().sum()
}
