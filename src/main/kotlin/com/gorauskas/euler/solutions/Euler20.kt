package com.gorauskas.euler.solutions

import com.gorauskas.euler.extensions.factorial
import java.math.BigInteger
import com.gorauskas.euler.EulerInterface as IEuler

class Euler20 : IEuler {
    override fun solve(): Double =
        BigInteger.valueOf(100).factorial()
            .toString().chars()
            .map { it - 48 }
            .sum().toDouble()

    override val problem = """
        Project Euler Problem 20:

            n! means n * (n - 1) * ... * 3 * 2 * 1

            For example, 10! = 10 * 9 * ... * 3 * 2 * 1 = 3628800, and the
            sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

            Find the sum of the digits in the number 100!
    """.trimIndent()

    override val answer = """

        The sum of the digits in the number 100! is: ${solve()}
    """.trimIndent()

}
