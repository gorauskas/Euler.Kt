package com.gorauskas.euler.solutions.onetoten

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer

class Euler9 : EulerSolution {
    override val problem = """
    Project Euler Problem 9:

       A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

        a^2 + b^2 = c^2
        For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

       There exists exactly one Pythagorean triplet for which a + b + c = 1000.
       Find the product abc.
    """.trimIndent()

    override val answer = """

    The product of the pythagorean triple whose
    sum equals 1000 is: ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long =
        (1L..500L).flatMap { a ->
            (1L..500L).filter { b ->
                a + b + (1000L - a - b) == 1000L &&
                    a * a + b * b == (1000L - a - b) * (1000L - a - b)
            }.map { b -> a * b * (1000L - a - b) }
        }.first()
}
