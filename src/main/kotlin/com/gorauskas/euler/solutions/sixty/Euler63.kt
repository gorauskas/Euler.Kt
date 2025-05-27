package com.gorauskas.euler.solutions.sixty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer
import java.math.BigInteger

class Euler63 : EulerSolution {
    override val problem = """
        Project Euler Problem 63

            The 5-digit number, 16807=7^5, is also a fifth power.
            Similarly, the 9-digit number, 134217728=8^9, is a ninth power.

            How many n-digit positive integers exist which are also an nth power?
    """.trimIndent()

    override val answer = """

        There are ${timer { solve() }} such numbers.
    """.trimIndent()

    override fun solve(): Long {
        var count = 0L

        for (base in 1..9) {
            var exponent = 1
            while (true) {
                val result = BigInteger.valueOf(base.toLong()).pow(exponent)
                val digits = result.toString().length

                if (digits == exponent) {
                    count++
                } else if (digits < exponent) {
                    // Once digits < exponent, it will never match again for larger n
                    break
                }
                exponent++
            }
        }

        return count
    }
}
