package com.gorauskas.euler.solutions.fifty

import com.gorauskas.euler.EULER051_LOWER_BOUND
import com.gorauskas.euler.EULER051_UPPER_BOUND
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.isPrime
import com.gorauskas.euler.functions.timer
import com.gorauskas.euler.sequences.primeSequence

/**
 * 1. We need look at only those primes that have exactly 3 repeating digits.
 * 2. The last (least significant) digit can’t be the repeating digit, because
 *    replacing it would allow composite numbers
 * 3. Since we are checking for an eight prime value family, we need only
 *    those primes that have their repeating digit 0, 1 or 2;
 *
 * this reduced the set to only 1,305 primes.
 */
class Euler51 : EulerSolution {
    override val problem = """
        Project Euler Problem 51

            By replacing the 1st digit of the 2-digit number *3, it turns out that six
            of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

            By replacing the 3rd and 4th digits of 56**3 with the same digit, this
            5-digit number is the first example having seven primes among the ten
            generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663,
            56773, and 56993. Consequently 56003, being the first member of this
            family, is the smallest prime with this property.

            Find the smallest prime which, by replacing part of the number (not
            necessarily adjacent digits) with the same digit, is part of an eight prime
            value family.
    """.trimIndent()

    override val answer = """

        The smallest prime which is part of an eight prime value family
        is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long {
        val primes = primeSequence(EULER051_LOWER_BOUND, EULER051_UPPER_BOUND).toList()

        for (prime in primes) {
            val s = prime.toString()

            for (x in s.indices) {
                val c = s.toCharArray()[x]
                var count = 0

                for (y in 0 until 10) {
                    val i = s.replace(c, y.toString()[0]).toInt()
                    if (i.toLong().isPrime() && i > EULER051_LOWER_BOUND) {
                        count++
                    }
                }

                if (count > 7) {
                    return s.toLong()
                }
            }
        }

        return 0
    }
}
