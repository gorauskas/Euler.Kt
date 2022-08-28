package com.gorauskas.euler.solutions

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.getData
import com.gorauskas.euler.functions.timer
import java.math.BigInteger

class Euler13 : EulerSolution {
    private val nums: List<String> =
        javaClass.getResource("/p013_nums.txt")
            ?.toURI()
            ?.getData()
            ?.split("\n")!!

    override val problem = """
        Project Euler Problem 13:

            Work out the first ten digits of the sum of the following one-hundred
            50-digit numbers.

            ${nums.joinToString(separator = "\n            ")}
    """.trimIndent()

    override val answer = """

        The first ten digits of the sum of the large numbers is: ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long =
        nums.map { BigInteger(it) }.reduce { acc, b -> acc.add(b) }.toString().substring(0, 10).toLong()
}
