package com.gorauskas.euler.solutions.forty

import com.gorauskas.euler.EULER046_LOWER_BOUND
import com.gorauskas.euler.EULER046_MAX_PRIME
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.isPrime
import com.gorauskas.euler.functions.timer
import com.gorauskas.euler.sequences.primeSequence
import kotlin.math.sqrt

class Euler46 : EulerSolution {
    override val problem = """
        Project Euler Problem 46

            It was proposed by Christian Goldbach that every odd composite number can
            be written as the sum of a prime and twice a square.

            9 = 7 + 2×12
            15 = 7 + 2×22
            21 = 3 + 2×32
            25 = 7 + 2×32
            27 = 19 + 2×22
            33 = 31 + 2×12

            It turns out that the conjecture was false.

            What is the smallest odd composite that cannot be written as the sum of a
            prime and twice a square?
    """.trimIndent()

    override val answer = """

        The smallest odd composite that cannot be written as the sum of a prime
        and twice a square is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long {
        var min: Int
        var limit = EULER046_MAX_PRIME
        var primes = primeSequence(limit).toList()
        var composite = EULER046_LOWER_BOUND

        next@while (true) {
            composite += 2
            if (composite.isPrime()) continue@next
            for (prime in primes) {
                if (prime > composite) break@next
                if (sqrt((composite - prime) / 2.0) % 1.0 == 0.0) {
                    continue@next
                }
            }
            // if reached, not enough primes for composite
            min = limit
            limit += EULER046_MAX_PRIME
            primes = primeSequence(min, limit).drop(1).toList()
            composite -= 2
        }

        return composite
    }
}
