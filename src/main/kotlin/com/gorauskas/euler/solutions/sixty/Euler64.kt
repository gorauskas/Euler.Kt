package com.gorauskas.euler.solutions.sixty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer
import kotlin.math.sqrt
import kotlin.math.truncate

class Euler64 : EulerSolution {
    override val problem = """
        Project Euler Problem 64

            All square roots are periodic when written as continued fractions and can be written in the form:

            √N = a₀ + 1 / (a₁ + 1 / (a₂ + 1 / (a₃ + ...)))

            For example, √23 = [4; (1, 3, 1, 8)], meaning that the periodic part has a length of 4.

            How many continued fractions for √N (for N ≤ 10000) have an odd period?
    """.trimIndent()

    override val answer = """

        There are ${timer { solve() }} fractions that have an odd period.
    """.trimIndent()

    override fun solve(): Long {
        return (2..10_000)
            .filter { !isPerfectSquare(it) }
            .count { continuedFractionPeriod(it) % 2 == 1 }
            .toLong()
    }

    private fun isPerfectSquare(number: Int): Boolean {
        val root = sqrt(1.0 * number).toInt()
        return root * root == number
    }

    private fun continuedFractionPeriod(number: Int): Int {
        val root = sqrt(1.0 * number)
        val a0 = truncate(root).toInt()

        var a = a0
        var n = 0
        var d = 1
        var period = 0

        do {
            n = d * a - n
            d = (number - n * n) / d
            a = (a0 + n) / d
            period++
        } while (a != 2 * a0)

        return period
    }
}
