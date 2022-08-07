package com.gorauskas.euler.solutions

import java.math.BigInteger
import com.gorauskas.euler.EulerInterface as IEuler

class Euler16 : IEuler {
    override fun solve(): Double {
        return BigInteger.ONE.shiftLeft(1000)
            .toString().chars()
            .map { it - 48 }.sum()
            .toDouble()
    }

    override val problem = """
        Project Euler Problem 16:

            2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

            What is the sum of the digits of the number 2^1000?
    """.trimIndent()

    override val answer = """

        The sum of the digits of the number 2^1000 is: ${solve()}
    """.trimIndent()
}
