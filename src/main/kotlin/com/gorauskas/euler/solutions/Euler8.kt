package com.gorauskas.euler.solutions

import com.gorauskas.euler.EULER8_NUMS
import com.gorauskas.euler.EulerSolution

class Euler8 : EulerSolution {

    override fun solve(): Long {
        val nums = getNums()
        var greatest = 0L
        var i = 0

        while (i + 13 <= nums.size) {
            val x = nums.drop(i).take(13).reduce { acc, l -> acc * l }.toLong()

            if (greatest < x) {
                greatest = x
            }

            i++
        }

        return greatest
    }

    override val problem = """
    Project Euler Problem 8:

        The four adjacent digits in the 1000-digit number that have the greatest
        product are 9 × 9 × 8 × 9 = 5832.

        $EULER8_NUMS

        Find the thirteen adjacent digits in the 1000-digit number that have
        the greatest product. What is the value of this product?
    """.trimIndent()

    override val answer = """

    The value of the product of 13 adjacent numbers with greatest
    product is ${solve().toLong()}
    """.trimIndent()

    private fun getNums(): LongArray =
        buildString { append(EULER8_NUMS) }
            .replace(" ", "")
            .replace("\n", "")
            .toCharArray()
            .map { it.code - 48L }
            .toLongArray()
}
