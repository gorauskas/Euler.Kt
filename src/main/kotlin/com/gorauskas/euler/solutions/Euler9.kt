package com.gorauskas.euler.solutions

import com.gorauskas.euler.EulerSolution

class Euler9 : EulerSolution {
    override fun solve(): Double {
        return (100..1000).flatMap { a ->
            (100..1000).flatMap { b ->
                (100..1000).filter { c ->
                    a + b + c == 1000 && ((a * a) + (b * b) == (c * c))
                }.map { c -> a * b * c }
            }
        }.first().toDouble()
    }

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
