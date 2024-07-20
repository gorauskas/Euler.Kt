package com.gorauskas.euler.solutions.fifty

import com.gorauskas.euler.EULER053_UPPER_BOUND
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.factorial
import com.gorauskas.euler.functions.timer
import java.math.BigInteger

class Euler53 : EulerSolution {
    override val problem = """
        Project Euler Problem 53

            There are exactly ten ways of selecting three from five, 12345:

                123, 124, 125, 134, 135, 145, 234, 235, 245, and 345

                                                   5
            In combinatorics, we use the notation,  C = 10.
                                                     3

            In general,

                n         n!
                 C  = ----------   where r <= n, n! = n*(n−1)*...*3*2*1, and 0! = 1.
                  r    r!(n−r)!

                                                                      23
            It is not until n = 23, that a value exceeds one-million:   C   = 1144066.
                                                                         10

                                                          n
            How many, not necessarily distinct, values of  C , for 1 <= n <= 100,
                                                            r
            are greater than one-million?
    """.trimIndent()

    override val answer = """

        There are ${timer { solve() }} values greater than one million.
    """.trimIndent()

    override fun solve(): Long {
        var x = 0L

        for (i in 1L..100L) {
            for (j in 1L..i) {
                if (BigInteger.valueOf(EULER053_UPPER_BOUND).compareTo(combinatorics(i, j)) < 0) {
                    x++
                }
            }
        }

        return x
    }

    private fun combinatorics(i: Long, j: Long): BigInteger {
        val bigI = BigInteger.valueOf(i)
        val bigJ = BigInteger.valueOf(j)

        return if (j <= i) {
            bigI.factorial().divide(bigJ.factorial().multiply(bigI.subtract(bigJ).factorial()))
        } else {
            BigInteger.ZERO
        }
    }
}
