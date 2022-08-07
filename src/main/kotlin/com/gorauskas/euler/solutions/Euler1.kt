package com.gorauskas.euler.solutions

import com.gorauskas.euler.EulerInterface as IEuler

class Euler1 : IEuler {

    override fun solve(): Double {
        return (1..999).filter { it % 3 == 0 || it % 5 == 0 }.sum().toDouble()
    }

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
