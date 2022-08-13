package com.gorauskas.euler.solutions

import com.gorauskas.euler.EulerSolution

class Euler1 : EulerSolution {

    override fun solve(): Long =
        (1L..999L).filter { it % 3L == 0L || it % 5L == 0L }.sum()

    override val problem = """
    Project Euler Problem 1:

       If we list all the natural numbers below 10 that are
       multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of
       these multiples is 23.

       Find the sum of all the multiples of 3 or 5 below 1000.
    """.trimIndent()

    override val answer = """

    The sum of all the multiples of 3 or 5 below 1000 is: ${solve()}
    """.trimIndent()

}
