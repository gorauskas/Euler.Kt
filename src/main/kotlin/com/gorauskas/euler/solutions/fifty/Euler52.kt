package com.gorauskas.euler.solutions.fifty

import com.gorauskas.euler.EULER052_LOWER_BOUND
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.sorted
import com.gorauskas.euler.functions.timer

class Euler52 : EulerSolution {
    override val problem = """
        Project Euler Problem 52

            It can be seen that the number, 125874, and its double, 251748, contain
            exactly the same digits, but in a different order.

            Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,
            contain the same digits.
    """.trimIndent()

    override val answer = """

        The smallest positive integer is ${timer { solve() }}
    """.trimIndent()

    @Suppress("ComplexCondition")
    override fun solve(): Long {
        var n = EULER052_LOWER_BOUND

        while (!(
                n.sorted().equals((n * 2L).sorted()) &&
                    n.sorted().equals((n * 3L).sorted()) &&
                    n.sorted().equals((n * 4L).sorted()) &&
                    n.sorted().equals((n * 5L).sorted()) &&
                    n.sorted().equals((n * 6L).sorted())
                )
        ) {
            n += 9L
        }

        return n
    }
}
