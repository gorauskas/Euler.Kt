package com.gorauskas.euler.solutions.forty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer
import com.gorauskas.euler.sequences.permutations

/**
 * 1. there are only 3,628,800 (10!) 0 to 9 pandigital numbers, so there's no need
 *    to examine all 10 billion 10-digit numbers.
 * 2. consider only numbers whose last 3 digits divide by 17
 * 3. now only check the permutations of the 7 remaining digits
 * 4. this can be reduced further by considering the division by 13 and so on
 */
class Euler43 : EulerSolution {
    private val primes = listOf(0, 2, 3, 5, 7, 11, 13, 17)

    override val problem = """
        Project Euler Problem 43

            The number, 1406357289, is a 0 to 9 pandigital number because it is made up of
            each of the digits 0 to 9 in some order, but it also has a rather interesting
            sub-string divisibility property.

            Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note
            the following:

            - d2d3d4=406 is divisible by 2
            - d3d4d5=063 is divisible by 3
            - d4d5d6=635 is divisible by 5
            - d5d6d7=357 is divisible by 7
            - d6d7d8=572 is divisible by 11
            - d7d8d9=728 is divisible by 13
            - d8d9d10=289 is divisible by 17

            Find the sum of all 0 to 9 pandigital numbers with this property.
    """.trimIndent()

    override val answer = """

        The sum of all 0 to 9 pandigital numbers with this property
        is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long = permutations('0'..'9').filter { perm ->
        perm.first() in "14" &&
            perm.last() in "79" &&
            perm[3].digitToInt() % 2 == 0 &&
            perm[5] == '5' &&
            perm.slice(2..4).sumOf(Char::digitToInt) % 3 == 0
    }.sumOf { perm ->
        var num = perm.joinToString("")
        for (i in 2..7) {
            if (num.substring(i..i + 2).toInt() % primes[i] != 0) {
                num = "0"
                break
            }
        }
        num.toLong()
    }
}
