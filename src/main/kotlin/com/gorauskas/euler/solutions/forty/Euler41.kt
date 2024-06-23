package com.gorauskas.euler.solutions.fortyonetofifty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.isPanDigital
import com.gorauskas.euler.extensions.isPrime
import com.gorauskas.euler.functions.timer

/**
 * Pandigital prime
 *
 * Why is N equal to 7654321 to start with? So let’s eliminate some values of n by using
 * the divisibility rule that any integer is divisible by 3 whose sum of digits is divisible
 * by 3; therefore composite and not prime.
 *
 * 9+8+7+6+5+4+3+2+1 = 45,
 * 8+7+6+5+4+3+2+1 = 36,
 * 6+5+4+3+2+1 = 21, and
 * 5+4+3+2+1 = 15,
 *
 * ... all of which are divisible by 3 and therefore could not yield a 1 to {5, 6, 8, 9}
 * pandigital prime. So that leaves 4 and 7 digit prime numbers less than 4321 and 7654321
 * respectively. Since we want the largest pandigital prime we’ll check the 7 digit group
 * first.
 */
class Euler41 : EulerSolution {
    override val problem = """
        Project Euler Problem 41:

            We shall say that an n-digit number is pandigital if it makes use of all the
            digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is
            also prime.

            What is the largest n-digit pandigital prime that exists?
    """.trimIndent()

    override val answer = """

        The largest n-digit pandigital prime that exists is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long {
        var n = 7_654_321L
        while (!(n.isPrime() && n.isPanDigital(7))) {
            n -= 2L
        }
        return n
    }
}
