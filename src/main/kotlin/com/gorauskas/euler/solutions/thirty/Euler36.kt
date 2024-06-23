package com.gorauskas.euler.solutions.thirty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.isPalindrome
import com.gorauskas.euler.functions.timer

class Euler36 : EulerSolution {
    override val problem = """
        Project Euler Problem 36:

            The decimal number, 585 = 1001001001↓2 (binary), is palindromic in both bases.

            Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

            (Please note that the palindromic number, in either base, may not include leading zeros.)
    """.trimIndent()

    override val answer = """

        The sum of all palindromic numbers in base 10 and 2 is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long = (1L..1_000_000L)
        .filter {
            it.isPalindrome() &&
                it.toString(2).equals(it.toString(2).reversed())
        }
        .sum()
}
