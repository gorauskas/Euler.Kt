package com.gorauskas.euler.solutions.fifty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.isPrime
import com.gorauskas.euler.functions.timer

class Euler58 : EulerSolution {
    override val problem = """
        Project Euler Problem 58

            Starting with 1 and spiralling anticlockwise in the following way, a square
            spiral with side length 7 is formed.

                37 36 35 34 33 32 31
                38 17 16 15 14 13 30
                39 18  5  4  3 12 29
                40 19  6  1  2 11 28
                41 20  7  8  9 10 27
                42 21 22 23 24 25 26
                43 44 45 46 47 48 49

            It is interesting to note that the odd squares lie along the bottom right
            diagonal, but what is more interesting is that 8 out of the 13 numbers
            lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.

            If one complete new layer is wrapped around the spiral above, a square
            spiral with side length 9 will be formed. If this process is continued,
            what is the side length of the square spiral for which the ratio of primes
            along both diagonals first falls below 10%?
    """.trimIndent()

    override val answer = """

        The side length of the square spiral is ${timer { solve() }}.
    """.trimIndent()

    override fun solve(): Long {
        var np = 0L  // primes
        var d = 1L   // diagonals
        var r = 1.0  // ratio
        var s = 2L   // side

        while (r >= 0.10) {
            np += (1L..3L).sumOf {
                if ((d + s * it).isPrime()) 1L else 0L
            }
            d += s * 4L
            s += 2L
            r = np / (2.0 * s)
        }

        return s - 1L
    }
}
