package com.gorauskas.euler.solutions

import com.gorauskas.euler.EULER7_MAX
import com.gorauskas.euler.sequences.primeSequence
import com.gorauskas.euler.EulerSolution

class Euler7 : EulerSolution {
    override fun solve(): Long = primeSequence(EULER7_MAX).toList().get(10000)

    override val problem = """
    Project Euler Problem 7:

        By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
        we can see that the 6th prime is 13.

        What is the 10001st prime number?
    """.trimIndent()

    override val answer = """

    Prime 10001 is ${solve().toLong()}
    """.trimIndent()
}
