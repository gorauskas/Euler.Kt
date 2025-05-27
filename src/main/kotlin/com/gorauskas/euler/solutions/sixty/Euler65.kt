package com.gorauskas.euler.solutions.sixty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer
import java.math.BigInteger

class Euler65 : EulerSolution {
    override val problem = """
        Project Euler Problem 65

            The square root of 2 can be written as an infinite continued fraction.

              √2 = 1 + (1/2) + (1/(2+1/2)) + (1/(2+1/(2+1/2))) + ...

            The infinite continued fraction can be written, √2 = [1; (2)], (2) indicates that
            repeats ad infinitum. In a similar way, √23 = [4; (1,3,1,8)].

            It turns out that the sequence of partial values of continued fractions for square
            roots provide the best rational approximations. The sequence of the first ten
            convergents for √2 are:

              1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...

            What is most surprising is that the important mathematical constant,

              e = [2;1,2,1,1,4,1,1,6,1,...,1,2k,1,...]

            The first ten terms in the sequence of convergents for e are:

              2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...

            The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.

            Find the sum of digits in the numerator of the 100th convergent of the continued
            fraction for e.
    """.trimIndent()

    override val answer = """

        The sum of the digits in the numerator of the Nth convergent of the continued
        fraction of Euler's number is ${timer { solve() }}.
    """.trimIndent()

    override fun solve(): Long {
        val target = 100
        val coefficients = mutableListOf<BigInteger>()
        coefficients.add(BigInteger.TWO)
        for (i in 1 until target) {
            val value = when {
                i % 3 == 2 -> BigInteger.valueOf((2 * (i / 3 + 1)).toLong())
                else -> BigInteger.ONE
            }
            coefficients.add(value)
        }

        var numerator = BigInteger.ONE
        var denominator = BigInteger.ZERO
        for (i in (target - 1) downTo 0) {
            val temp = numerator
            numerator = coefficients[i] * numerator + denominator
            denominator = temp
        }

        return numerator.toString().map { it.digitToInt() }.sum().toLong()
    }
}
