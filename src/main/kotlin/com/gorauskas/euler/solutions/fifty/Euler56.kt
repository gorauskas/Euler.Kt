package com.gorauskas.euler.solutions.fifty

import com.gorauskas.euler.EULER_CHAR_OFFSET_48_LONG
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer
import java.math.BigInteger

class Euler56 : EulerSolution {
    override val problem = """
        Project Euler Problem 56

            A googol (10^100) is a massive number: one followed by one-hundred zeros;
            100^100 is almost unimaginably large: one followed by two-hundred
            zeros. Despite their size, the sum of the digits in each number is only 1.

            Considering natural numbers of the form, a^b, where a, b < 100, what is the
            maximum digital sum?
    """.trimIndent()

    override val answer = """

        The max digital sum is ${timer { solve() }}.
    """.trimIndent()

    override fun solve(): Long {
        var ls = 0L

        for (x in 1L..100L) {
            for (y in 1L..100L) {
                val n = BigInteger(x.toString()).pow(y.toInt())
                val s = n.toString().chars().mapToLong { it - EULER_CHAR_OFFSET_48_LONG }.sum()
                if (s > ls) {
                    ls = s
                }
            }
        }

        return ls
    }
}
