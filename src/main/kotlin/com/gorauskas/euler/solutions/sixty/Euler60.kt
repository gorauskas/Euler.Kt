package com.gorauskas.euler.solutions.sixty

import com.gorauskas.euler.EULER060_SET_SIZE
import com.gorauskas.euler.EULER060_UPPER_BOUND
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.isPrime
import com.gorauskas.euler.functions.timer
import com.gorauskas.euler.sequences.primeSequence

class Euler60 : EulerSolution {
    override val problem = """
        Project Euler Problem 60

            The primes 3, 7, 109, and 673, are quite remarkable. By taking any two
            primes and concatenating them in any order the result will always be
            prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The sum
            of these four primes, 792, represents the lowest sum for a set of four
            primes with this property.

            Find the lowest sum for a set of five primes for which any two primes
            concatenate to produce another prime.
    """.trimIndent()

    override val answer = """

        The lowest sum for a set of five prime pairs is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long = findPrimePairSet(
        primeSequence(EULER060_UPPER_BOUND).toList(),
        emptyList(),
        EULER060_SET_SIZE,
    )!!.sum()

    /**
     * Recursive function to find sets of primes that are all prime pairs
     */
    private fun findPrimePairSet(primes: List<Long>, current: List<Long>, size: Int): List<Long>? {
        if (current.size == size) return current
        val start = if (current.isEmpty()) 0 else primes.indexOf(current.last()) + 1
        for (idx in start until primes.size) {
            val prime = primes[idx]
            if (current.all { isPrimePair(it, prime) }) {
                val new = findPrimePairSet(primes, current + prime, size)
                if (new != null) return new
            }
        }
        return null
    }

    /**
     * A prime pair is any two primes that concatenate in any order
     * to produce another prime
     */
    private fun isPrimePair(x: Long, y: Long): Boolean = "$x$y".toLong().isPrime() && "$y$x".toLong().isPrime()
}
