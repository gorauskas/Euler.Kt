package com.gorauskas.euler.solutions.fifty

import com.gorauskas.euler.EULER055_UPPER_BOUND
import com.gorauskas.euler.EULER_NUM_TENK_LONG
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.isPalindrome
import com.gorauskas.euler.functions.timer

class Euler55 : EulerSolution {
    override val problem = """
        Project Euler Problem 55

            If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.

            Not all numbers produce palindromes so quickly. For example,

                349 + 943 = 1292,
                1292 + 2921 = 4213
                4213 + 3124 = 7337

            That is, 349 took three iterations to arrive at a palindrome.

            Although no one has proved it yet, it is thought that some numbers, like
            196, never produce a palindrome. A number that never forms a palindrome
            through the reverse and add process is called a Lychrel number. Due to the
            theoretical nature of these numbers, and for the purpose of this problem,
            we shall assume that a number is Lychrel until proven otherwise. In
            addition you are given that for every number below ten-thousand, it will
            either (i) become a palindrome in less than fifty iterations, or, (ii) no
            one, with all the computing power that exists, has managed so far to map it
            to a palindrome. In fact, 10677 is the first number to be shown to require
            over fifty iterations before producing a palindrome:
            4668731596684224866951378664 (53 iterations, 28-digits).

            Surprisingly, there are palindromic numbers that are themselves Lychrel
            numbers; the first example is 4994.

            How many Lychrel numbers are there below ten-thousand?
    """.trimIndent()

    override val answer = """

        There are ${timer { solve() }} Lychrel numbers below ten thousand.
    """.trimIndent()

    override fun solve(): Long = (1L..EULER_NUM_TENK_LONG).count { it.isLychrel() }.toLong()

    private fun Long.isLychrel(): Boolean {
        var num = this
        var res: Long

        (0..EULER055_UPPER_BOUND).forEach {
            res = num.reversed()
            num += res

            if (num.isPalindrome()) {
                return false
            }
        }

        return true
    }

    private fun Long.reversed(): Long {
        if (this < 0L) return this

        var (num, res) = this to 0L

        while (num != 0L) {
            res = res * 10L + num % 10L
            num /= 10L
        }

        return res
    }
}
