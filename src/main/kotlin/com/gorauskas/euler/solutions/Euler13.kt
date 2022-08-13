package com.gorauskas.euler.solutions

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.getData
import java.math.BigInteger

class Euler13 : EulerSolution {
    override fun solve(): Double =
        getNums().map { BigInteger(it) }
            .reduce { acc, b -> acc.add(b) }
            .toString()
            .substring(0, 10)
            .toDouble()

    override val problem = """
        Project Euler Problem 13:

            Work out the first ten digits of the sum of the following one-hundred
            50-digit numbers.

            ${getNums().joinToString(separator = "\n            ")}
    """.trimIndent()

    override val answer = """

        The first ten digits of the sum of the large numbers is: ${solve().toLong()}
    """.trimIndent()

    private fun getNums(): List<String> =
        javaClass.getResource("/p013_nums.txt")
            ?.toURI()
            ?.getData()
            ?.split("\n")!!
}
