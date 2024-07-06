package com.gorauskas.euler.solutions.forty

import com.gorauskas.euler.EULER047_LOWER_BOUND
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.primeFactors
import com.gorauskas.euler.functions.timer

class Euler47 : EulerSolution {
    override val problem = """
        Project Euler Problem 47

            The first two consecutive numbers to have two distinct prime factors are:

            14 = 2 × 7
            15 = 3 × 5

            The first three consecutive numbers to have three distinct prime factors
            are:

            644 = 2² × 7 × 23
            645 = 3 × 5 × 43
            646 = 2 × 17 × 19.

            Find the first four consecutive integers to have four distinct prime
            factors. What is the first of these numbers?
    """.trimIndent()

    override val answer = """

        The first of 4 consecutive numbers to have 4 unique prime factors
        is ${timer { solve() }}
    """.trimIndent()

    /**
     * The minimum representation with 4 distinct prime factors is:
     *
     * 2 * 3 * 5 * 7 = 210
     */
    override fun solve(): Long {
        var x = EULER047_LOWER_BOUND
        var y = 1
        val nums = mutableListOf<Long>()

        while (y != 4) {
            x++
            if (x.primeFactors().count() == 4) {
                nums.add(x)
                y++
            } else {
                nums.clear()
                y = 0
            }
        }

        return nums[0]
    }
}
