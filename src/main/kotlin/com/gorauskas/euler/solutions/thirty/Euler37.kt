package com.gorauskas.euler.solutions.thirtyonetoforty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.isPrime
import com.gorauskas.euler.functions.timer
import com.gorauskas.euler.sequences.primeSequence
import kotlinx.coroutines.runBlocking

class Euler37 : EulerSolution {
    override val problem = """
        Project Euler Problem 37:

            The number 3797 has an interesting property. Being prime itself, it is possible to continuously
            remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly
            we can work from right to left: 3797, 379, 37, and 3.

            Find the sum of the only eleven primes that are both truncatable from left to right and right to
            left.

            NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
    """.trimIndent()

    override val answer = """

        The sum of the only eleven primes that are both truncatable left and right is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long = runBlocking { primeSequence(10, 740_000).filter { isTruncatable(it) }.sum() }

    private fun isTruncatable(n: Long): Boolean = (1 until n.toString().length).filter { d ->
        n.toString().drop(d).toLong().isPrime() &&
            n.toString().dropLast(d).toLong().isPrime()
    }.count() == n.toString().length - 1
}
