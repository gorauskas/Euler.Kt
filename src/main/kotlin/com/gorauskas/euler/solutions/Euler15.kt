package com.gorauskas.euler.solutions

import com.gorauskas.euler.extensions.factorial
import com.gorauskas.euler.EulerInterface as IEuler

class Euler15 : IEuler {

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
    override fun solve(): Double {
        val moves = 40.0
        val dirs = 20.0

        return moves.factorial() / ((moves - dirs).factorial() * dirs.factorial())
    }

    override val problem = """
        Project Euler Problem 15:
        
            Starting in the top left corner of a 2x2 grid, there are 6 routes
            (without backtracking) to the bottom right corner.
            
            How many routes are there through a 20x20 grid?
    """.trimIndent()

    override val answer = """
        
        There are ${solve().toLong()} routes through a 20x20 grid
    """.trimIndent()
}