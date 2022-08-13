package com.gorauskas.euler.solutions

import com.gorauskas.euler.sequences.primeSequence
import com.gorauskas.euler.EulerSolution

class Euler10 : EulerSolution {

    override fun solve(): Double {
        return primeSequence(2000000).sum().toDouble()
    }

    override val problem = """
    Project Euler Problem 10:

       The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

       Find the sum of all the primes below two million.
    """.trimIndent()

    override val answer = """

    The sum of all the primes below two million is: ${solve().toLong()}
    """.trimIndent()

}
