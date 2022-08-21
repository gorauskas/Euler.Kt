package com.gorauskas.euler.solutions

import com.gorauskas.euler.sequences.primeSequence
import com.gorauskas.euler.EulerSolution
import kotlinx.coroutines.runBlocking

/**
 * Repeating decimal Totient Rule = https://en.wikipedia.org/wiki/Repeating_decimal#Totient_rule
 * Primitive root modulo n = https://en.wikipedia.org/wiki/Primitive_root_modulo_n
 * Euler's totient function = https://en.wikipedia.org/wiki/Euler%27s_totient_function
 * Full reptend prime = https://en.wikipedia.org/wiki/Full_reptend_prime
 */
class Euler26 : EulerSolution {
    override fun solve(): Long {
        val ps = runBlocking { primeSequence(1000).toList().reversed() }
        var seqlen = 0

        for (p in ps) {
            if (seqlen >= p) break

            val rems = IntArray(p.toInt())
            var value = 1
            var position = 0

            while (rems[value] == 0 && value != 0) {
                rems[value] = position
                value *= 10
                value %= p.toInt()
                position++
            }

            if (position - rems[value] > seqlen) {
                seqlen = position - rems[value]
            }
        }

        return seqlen + 1L
    }

    override val problem = """
        Project Euler Problem 26:

            A unit fraction contains 1 in the numerator. The decimal representation of
            the unit fractions with denominators 2 to 10 are given:

            1/2 =  0.5
            1/3 =  0.(3)
            1/4 =  0.25
            1/5 =  0.2
            1/6 =  0.1(6)
            1/7 =  0.(142857)
            1/8 =  0.125
            1/9 =  0.(1)
            1/10 =  0.1

            Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can
            be seen that 1/7 has a 6-digit recurring cycle.

            Find the value of d < 1000 for which 1/d contains the longest recurring
            cycle in its decimal fraction part.
    """.trimIndent()

    override val answer = """

        The value of d < 1000 for which 1/d contains the longest
        recurring cycle in its decimal fraction part is: ${solve()}
    """.trimIndent()
}
