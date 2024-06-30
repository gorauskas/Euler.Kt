package com.gorauskas.euler.solutions.ten

import com.gorauskas.euler.EULER016_CHAR_OFFSET
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer
import java.math.BigInteger

class Euler16 : EulerSolution {
    override val problem = """
        Project Euler Problem 16:

            2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

            What is the sum of the digits of the number 2^1000?
    """.trimIndent()

    override val answer = """

        The sum of the digits of the number 2^1000 is: ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long = BigInteger.ONE
        .shiftLeft(1000)
        .toString()
        .toCharArray()
        .map { it.code - EULER016_CHAR_OFFSET }
        .sum()
}
