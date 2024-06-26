package com.gorauskas.euler.solutions.one

import com.gorauskas.euler.EULER007_MAX
import com.gorauskas.euler.EULER007_TARGET_INDEX
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer
import com.gorauskas.euler.sequences.primeSequence

class Euler7 : EulerSolution {
    override val problem = """
    Project Euler Problem 7:

        By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
        we can see that the 6th prime is 13.

        What is the 10001st prime number?
    """.trimIndent()

    override val answer = """

    Prime 10001 is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long = primeSequence(EULER007_MAX).toList()[EULER007_TARGET_INDEX]
}
