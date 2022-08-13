package com.gorauskas.euler.solutions

import com.gorauskas.euler.EULER23_MAX
import com.gorauskas.euler.extensions.sumOfDivisors
import com.gorauskas.euler.EulerSolution

class Euler23 : EulerSolution {

    /**
     * According to Wolfram Mathworld’s discussion on Abundant Numbers
     * [http://mathworld.wolfram.com/AbundantNumber.html]: "Every number
     * greater than 20161 can be expressed as a sum of two abundant numbers."
     * So our upper bound lowered to 20161 (+1) from 28123.
     */

    override fun solve(): Double =
        genSetOfSumOfTwoAbundants((1L..EULER23_MAX)
            .filter { x -> x.sumOfDivisors() > x })
            .let { sumOfTwoSet ->
                (1L..EULER23_MAX)
                    .filter { !sumOfTwoSet.contains(it) }
                    .sum()
                    .toDouble()
            }

    private fun genSetOfSumOfTwoAbundants(abundants: List<Long>): Set<Long> =
        (0..abundants.size - 2)
            .flatMap { x ->
                (x..abundants.size - 1)
                    .map { y -> abundants[x] + abundants[y] }
                    .filter { it <= EULER23_MAX }
            }.toSet()

    override val problem = """
        Project Euler Problem 23:

            A perfect number is a number for which the sum of its proper divisors is
            exactly equal to the number. For example, the sum of the proper divisors of
            28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect
            number.

            A number n is called `deficient` if the sum of its proper divisors is less
            than n and it is called `abundant` if this sum exceeds n.

            As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
            number that can be written as the sum of two a numbers is 24. By
            mathematical analysis, it can be shown that all integers greater than 28123
            can be written as the sum of two a numbers. However, this upper limit
            cannot be reduced any further by analysis even though it is known that the
            greatest number that cannot be expressed as the sum of two abundant numbers
            is less than this limit.

            Find the sum of all the positive integers which cannot be written as the
            sum of two abundant numbers.
    """.trimIndent()

    override val answer = """
        The sum of all the positive integers which cannot be written as the sum of
        two abundant numbers is ${solve()}
    """.trimIndent()

}
