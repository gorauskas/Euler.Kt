package com.gorauskas.euler.solutions.thirtyonetoforty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.ifTrue
import com.gorauskas.euler.functions.timer

class Euler39 : EulerSolution {
    override val problem = """
        Project Euler Problem 39:

            If p is the perimeter of a right angle triangle with integral length sides, {a,b,c},
            there are exactly three solutions for p = 120.

            {20,48,52}, {24,45,51}, {30,40,50}

            For which value of p ≤ 1000, is the number of solutions maximised?
    """.trimIndent()

    override val answer = """

        The number of solutions is maximized for ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long {
        var result = 0L
        var resultSolutions = 0L

        for (p in 2L..1000L step 2) {
            var numberOfSolutions = 0L
            for (a in 2L..p / 3L) {
                if (p * (p - 2L * a) % (2L * (p - a)) == 0L) {
                    numberOfSolutions++
                }
            }
            if (numberOfSolutions > resultSolutions) {
                resultSolutions = numberOfSolutions
                result = p
            }
        }

        return result
    }
}
