package com.gorauskas.euler.solutions

import com.gorauskas.euler.sequences.primeSequence
import com.gorauskas.euler.EulerInterface as IEuler

class Euler7 : IEuler {

    override fun solve(): Double {
        return primeSequence(105000).toList().get(10000).toDouble()
    }

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
