package com.gorauskas.euler.solutions.thirtyonetoforty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer

class Euler33 : EulerSolution {
    override val problem = """
        Project Euler Problem 33:

            The fraction 49/98 is a curious fraction, as an inexperienced mathematician
            in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which
            is correct, is obtained by cancelling the 9s.

            We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

            There are exactly four non-trivial examples of this type of fraction, less
            than one in value, and containing two digits in the numerator and denominator.

            If the product of these four fractions is given in its lowest common terms,
            find the value of the denominator.
    """.trimIndent()

    override val answer = """

        The value of the denominator is: ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long {
        var d = 1.0

        for (i in 1..9) {
            for (j in 1 until i) {
                for (k in 1 until j) {
                    val ki = k * 10 + i
                    val ij = (i * 10 + j).toDouble()
                    if (k * ij == (ki * j).toDouble()) {
                        d *= ij / ki
                    }
                }
            }
        }

        return d.toLong()
    }
}
