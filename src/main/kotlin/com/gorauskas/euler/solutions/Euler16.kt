package com.gorauskas.euler.solutions

import com.gorauskas.euler.EULER16_CHAR_OFFSET
import java.math.BigInteger
import com.gorauskas.euler.EulerSolution

class Euler16 : EulerSolution {
    override fun solve(): Long =
        BigInteger.ONE
            .shiftLeft(1000)
            .toString()
            .toCharArray()
            .map { it.code - EULER16_CHAR_OFFSET }
            .sum()

    override val problem = """
        Project Euler Problem 16:

            2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

            What is the sum of the digits of the number 2^1000?
    """.trimIndent()

    override val answer = """

        The sum of the digits of the number 2^1000 is: ${solve()}
    """.trimIndent()
}
