package com.gorauskas.euler.solutions.thirtyonetoforty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.isPanDigital
import com.gorauskas.euler.functions.timer

class Euler38 : EulerSolution {
    override val problem = """
        Project Euler Problem 38:

            Take the number 192 and multiply it by each of 1, 2, and 3:

            192 × 1 = 192
            192 × 2 = 384
            192 × 3 = 576

            By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the
            concatenated product of 192 and (1,2,3)

            The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital,
            918273645, which is the concatenated product of 9 and (1,2,3,4,5).

            What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of
            an integer with (1,2, ... , n) where n > 1?
    """.trimIndent()

    override val answer = """

        The largest 1 to 9 pandigital 9-digit multiple is ${timer { solve() }}
    """.trimIndent()

    /**
     * Given the constraints of the problem, we know the largest number has to start
     * with the digit 9 - this allows us to significantly narrow the search range
     */
    override fun solve(): Long = (9_487L downTo 9_213L)
        .first { ((it * 1L).toString() + (it * 2L).toString()).toLong().isPanDigital() }
        .let { ((it * 1L).toString() + (it * 2L).toString()).toLong() }
}
