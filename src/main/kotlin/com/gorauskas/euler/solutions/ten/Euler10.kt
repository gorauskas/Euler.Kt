package com.gorauskas.euler.solutions.ten

import com.gorauskas.euler.EULER010_MAX
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer
import com.gorauskas.euler.sequences.primeSequence

class Euler10 : EulerSolution {
    override val problem = """
    Project Euler Problem 10:

       The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

       Find the sum of all the primes below two million.
    """.trimIndent()

    override val answer = """

    The sum of all the primes below two million is: ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long = primeSequence(EULER010_MAX).sum()
}
