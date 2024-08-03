package com.gorauskas.euler.solutions.fifty

import com.gorauskas.euler.EULER057_UPPER_BOUND
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer
import java.math.BigInteger

class Euler57 : EulerSolution {
    override val problem = """
        Project Euler Problem 57

            It is possible to show that the square root of two can be expressed as an
            infinite continued fraction.

              √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...

            By expanding this for the first four iterations, we get:

              1 + 1/2 = 3/2 = 1.5
              1 + 1/(2 + 1/2) = 7/5 = 1.4
              1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
              1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...

            The next three expansions are 99/70, 239/169, and 577/408, but the eighth
            expansion, 1393/985, is the first example where the number of digits in the
            numerator exceeds the number of digits in the denominator.

            In the first one-thousand expansions, how many fractions contain a
            numerator with more digits than denominator?
    """.trimIndent()

    override val answer = """

        There are ${timer { solve() }} fractions whose numerators have more digits
        than the denominator.
    """.trimIndent()

    override fun solve(): Long {
        var result = 0L
        var t: BigInteger

        (2..EULER057_UPPER_BOUND).forEach { x ->
            var n = BigInteger.ONE
            var d = BigInteger.TWO

            (1..x).forEach { _ ->
                n = BigInteger.TWO.multiply(d).add(n)

                t = d
                d = n
                n = t
            }

            n = n.add(d)

            if (n.toString().length > d.toString().length) {
                result++
            }
        }

        return result
    }
}
