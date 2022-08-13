package com.gorauskas.euler.solutions

import com.gorauskas.euler.EULER31_TARGET
import com.gorauskas.euler.EulerSolution

class Euler31 : EulerSolution {
    override fun solve(): Double {
        val coins = listOf(1, 2, 5, 10, 20, 50, 100, 200)
        val ways = (mutableListOf(1) + MutableList(EULER31_TARGET) { 0 }).toMutableList()

        coins.forEach { coin ->
            (coin..EULER31_TARGET).forEach { i ->
                ways[i] += ways[i - coin]
            }
        }

        return ways[EULER31_TARGET].toDouble()
    }

    override val problem = """
        Project Euler Problem 31

            In the United Kingdom the currency is made up of pound (£) and pence (p).
            There are eight coins in general circulation:

                1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).

            It is possible to make £2 in the following way:

                1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p

            How many different ways can £2 be made using any number of coins?
    """.trimIndent()

    override val answer = """

        There are ${solve()} different ways to get £2 using any number of coins.
    """.trimIndent()
}
