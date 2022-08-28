package com.gorauskas.euler.solutions.thirtyonetoforty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.isPrime
import com.gorauskas.euler.functions.timer
import com.gorauskas.euler.sequences.primeSequence
import kotlinx.coroutines.runBlocking

@Suppress("CommentOverPrivateFunction")
class Euler35 : EulerSolution {
    override val problem = """
        Project Euler Problem 35:

            The number, 197, is called a circular prime because all rotations of the
            digits: 197, 971, and 719, are themselves prime.

            There are thirteen such primes below 100:

                2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

            How many circular primes are there below one million?
    """.trimIndent()

    override val answer = """

        There are ${timer { solve() }} circular primes below 1 million.
    """.trimIndent()

    override fun solve(): Long =
        runBlocking {
            primeSequence(1_000_000).filter { prime ->
                checkRotations(
                    prime.toString()
                        .splitToSequence("")
                        .filter { it.isNotEmpty() }
                        .map { it.toLong() },
                    prime
                )
            }.count().toLong()
        }

    /**
     * Checks the circular rotations of each prime number for primes.
     * True if all rotations are also prime, false otherwise
     *   digits = a list of digits that makes up the prime nunber `prime`
     *   prime = The prime number to check
     */
    private fun checkRotations(digits: Sequence<Long>, prime: Long): Boolean {
        var k = 0L
        var ml = digits.rotateLeft()
        while (prime != k) {
            k = ml.joinToString("").toLong()
            if (!k.isPrime()) return false
            ml = ml.rotateLeft()
        }
        return true
    }

    private fun Sequence<Long>.rotateLeft() = this.drop(1) + this.take(1)
}
