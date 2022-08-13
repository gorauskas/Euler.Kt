package com.gorauskas.euler.solutions

import com.gorauskas.euler.EulerSolution

class Euler9 : EulerSolution {
    override fun solve(): Long =
        (100L..1000L).flatMap { a ->
            (100L..1000L).flatMap { b ->
                (100L..1000L).filter { c ->
                    a + b + c == 1000L && ((a * a) + (b * b) == (c * c))
                }.map { c -> a * b * c }
            }
        }.first()

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
    sum equals 1000 is: ${solve().toLong()}
    """.trimIndent()
}
