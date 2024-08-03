package com.gorauskas.euler.solutions.one

import com.gorauskas.euler.EULER008_CHAR_OFFSET
import com.gorauskas.euler.EULER008_NUMS
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.ifTrue
import com.gorauskas.euler.functions.timer

class Euler8 : EulerSolution {
    override val problem = """
    Project Euler Problem 8:

        The four adjacent digits in the 1000-digit number that have the greatest
        product are 9 × 9 × 8 × 9 = 5832.

        $EULER008_NUMS

        Find the thirteen adjacent digits in the 1000-digit number that have
        the greatest product. What is the value of this product?
    """.trimIndent()

    override val answer = """

    The value of the product of 13 adjacent numbers with greatest
    product is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long {
        val nums = getNums()
        var greatest = 0L
        var i = 0

        while (i + 13 <= nums.size) {
            val x = nums.drop(i).take(13).reduce { acc, l -> acc * l }.toLong()

            (greatest < x).ifTrue {
                greatest = x
            }

            i++
        }

        return greatest
    }

    private fun getNums(): LongArray = buildString { append(EULER008_NUMS) }
        .replace(" ", "")
        .replace("\n", "")
        .toCharArray()
        .map { it.code - EULER008_CHAR_OFFSET }
        .toLongArray()
}
