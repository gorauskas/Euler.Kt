package com.gorauskas.euler.solutions.ten

import com.gorauskas.euler.EULER015_DIRS
import com.gorauskas.euler.EULER015_MOVES
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.factorial
import com.gorauskas.euler.functions.timer

class Euler15 : EulerSolution {
    /**
     * This is a combinations problem. on a 20x20 grid to get from top-left to
     * bottom-right there are 40 moves (20 down and 20 right). The problem can be
     * solved by applying the formula for the central binomial coefficient
     * (http://en.wikipedia.org/wiki/Central_binomial_coefficient):
     *
     *                x!
     *   C(x,y) = -----------
     *            y! * (x-y)!
     *
     * @return double
     */
    override val problem = """
        Project Euler Problem 15:

            Starting in the top left corner of a 2x2 grid, there are 6 routes
            (without backtracking) to the bottom right corner.

            How many routes are there through a 20x20 grid?
    """.trimIndent()

    override val answer = """

        There are ${timer { solve() }} routes through a 20x20 grid
    """.trimIndent()

    override fun solve(): Long {
        val centralBinomialCoefficient =
            40.0.factorial() /
                ((EULER015_MOVES - EULER015_DIRS).factorial() * EULER015_DIRS.factorial())
        return centralBinomialCoefficient.toLong()
    }
}
