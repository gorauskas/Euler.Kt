package com.gorauskas.euler.solutions

import com.gorauskas.euler.extensions.isPrime
import com.gorauskas.euler.EulerSolution

class Euler3 : EulerSolution {

    override fun solve(): Double {
        val n = 600851475143L
        return (2..775164L)
            .filter { n % it == 0L && it.isPrime() }
            .maxOrNull()
            ?.toDouble()!!
    }

    override val problem = """
    Project Euler Problem 3:

      The prime factors of 13195 are 5, 7, 13 and 29.

      What is the largest prime factor of the number 600851475143 ?
    """.trimIndent()

    override val answer = """

    The largest prime factor of the number 600851475143 is: ${solve()}
    """.trimIndent()

}
