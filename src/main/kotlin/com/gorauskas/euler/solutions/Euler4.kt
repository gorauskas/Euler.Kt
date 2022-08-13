package com.gorauskas.euler.solutions

import com.gorauskas.euler.extensions.isPalindrome
import com.gorauskas.euler.EulerSolution

class Euler4 : EulerSolution {

    override fun solve(): Long =
        (100..999L).flatMap { x ->
            (100..999L).map { y ->
                x * y
            }
        }.filter {
            it.isPalindrome()
        }.max()

    override val problem = """
    Project Euler Problem 4:

       A palindromic number reads the same both ways. The largest palindrome made
       from the product of two 2-digit numbers is 9009 = 91  99.

       Find the largest palindrome made from the product of two 3-digit numbers.
    """.trimIndent()

    override val answer = """

        The largest palindrome made of the product of two 3 digit numbers is ${solve()}
    """.trimIndent()
}
