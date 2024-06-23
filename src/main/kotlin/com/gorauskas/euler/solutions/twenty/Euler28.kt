package com.gorauskas.euler.solutions.twenty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer
import kotlin.math.pow

class Euler28 : EulerSolution {
    /**
     * You don't have to actually construct the spiral to solve this problem.
     * This is a simple summation problem and therefore the result can be expressed
     * by a formula which is presented below
     */
    override val problem = """
        Project Euler Problem 28:

            Starting with the number 1 and moving to the right in a clockwise direction
            a 5 by 5 spiral is formed as follows:

                21 22 23 24 25
                20  7  8  9 10
                19  6  1  2 11
                18  5  4  3 12
                17 16 15 14 13

            It can be verified that the sum of the numbers on the diagonals is 101.

            What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
            formed in the same way?
    """.trimIndent()

    override val answer = """

        The sum of the numbers on the diagonals in a 1001 by 1001
        spiral is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long = 500.0.let { n -> (16L * n.pow(3.0) + 26L * 500L) / 3 + 10 * n.pow(2.0) + 1 }.toLong()
}
