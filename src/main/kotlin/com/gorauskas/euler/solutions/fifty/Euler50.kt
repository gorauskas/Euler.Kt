package com.gorauskas.euler.solutions.fifty

import com.gorauskas.euler.EULER050_MAX_PRIME
import com.gorauskas.euler.EULER050_UPPER_BOUND
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.isPrime
import com.gorauskas.euler.functions.timer
import com.gorauskas.euler.sequences.primeSequence

class Euler50 : EulerSolution {
    override val problem = """
        Project Euler Problem 50

            The prime 41, can be written as the sum of six consecutive primes:

                41 = 2 + 3 + 5 + 7 + 11 + 13

            This is the longest sum of consecutive primes that adds to a prime below
            one-hundred.

            The longest sum of consecutive primes below one-thousand that adds to a
            prime, contains 21 terms, and is equal to 953.

            Which prime, below one-million, can be written as the sum of the most
            consecutive primes?
    """.trimIndent()

    override val answer = """

        The prime below one-million that can be written as the sum of the most
        consecutive primes is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long {
        val primes = primeSequence(EULER050_MAX_PRIME).toList()
        val bounds = (1..EULER050_UPPER_BOUND).toList().reversed()

        for (upperBound in bounds) {
            var lowerBound = 0
            var sum = primes.drop(lowerBound).take(lowerBound + upperBound).sum()

            while (sum < EULER050_MAX_PRIME) {
                if (sum.isPrime()) {
                    return sum
                }

                lowerBound++
                sum = primes.drop(lowerBound).take(lowerBound + upperBound).sum()
            }
        }

        return 0
    }
}
