package com.gorauskas.euler.solutions.sixty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer

class Euler62 : EulerSolution {
    override val problem = """
        Project Euler Problem 62

            The cube, 41063625 (p1), can be permuted to produce two other cubes: 56623104 (p2) and 66430125 (p3).
            In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are
            also cube.

            Find the smallest cube for which exactly five permutations of its digits are cube.
    """.trimIndent()

    override val answer = """

        The smallest cube for which exactly five permutations of its digits are cube
        is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long {
        val cubeMap = mutableMapOf<String, MutableList<Long>>()
        var n = 1L

        while (true) {
            val cube = n * n * n
            val signature = cube.toString().toCharArray().sorted().joinToString("")
            val cubeList = cubeMap.getOrPut(signature) { mutableListOf() }

            cubeList.add(cube)
            if (cubeList.size == 5) return cubeList.min()

            n++
        }
    }
}
