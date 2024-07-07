package com.gorauskas.euler.solutions.forty

import com.gorauskas.euler.EULER049_INCREASE_BY
import com.gorauskas.euler.EULER049_UPPER_BOUND
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.isPrime
import com.gorauskas.euler.extensions.sorted
import com.gorauskas.euler.functions.timer
import com.gorauskas.euler.sequences.primeSequence

class Euler49 : EulerSolution {
    override val problem = """
        Project Euler Problem 49

            The arithmetic sequence, 1487, 4817, 8147, in which each of the terms
            increases by 3330, is unusual in two ways: (i) each of the three terms are
            prime, and, (ii) each of the 4-digit numbers are permutations of one
            another.

            There are no arithmetic sequences made up of three 1-, 2-, or 3-digit
            primes, exhibiting this property, but there is one other 4-digit increasing
            sequence.

            What 12-digit number do you form by concatenating the three terms in this
            sequence?
    """.trimIndent()

    override val answer = """

        The 12-digit number is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long {
        var result: Long = 0

        primeSequence(1000, EULER049_UPPER_BOUND).forEach { x ->
            val y = x + EULER049_INCREASE_BY
            val z = y + EULER049_INCREASE_BY

            if (x.isPrime() && y.isPrime() && z.isPrime()) {
                if (y.toString().sorted() == x.toString().sorted() && z.toString().sorted() == x.toString().sorted()) {
                    result = (x.toString() + y.toString() + z.toString()).toLong()
                }
            }
        }

        return result
    }
}
