package com.gorauskas.euler.solutions.onetoten

import com.gorauskas.euler.EULER3_MAX
import com.gorauskas.euler.EULER3_PF_NUMBER
import com.gorauskas.euler.extensions.isPrime
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer

class Euler3 : EulerSolution {
    override val problem = """
    Project Euler Problem 3:

      The prime factors of 13195 are 5, 7, 13 and 29.

      What is the largest prime factor of the number 600851475143 ?
    """.trimIndent()

    override val answer = """

    The largest prime factor of the number 600851475143 is: ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long =
        (2..EULER3_MAX)
            .filter { EULER3_PF_NUMBER % it == 0L && it.isPrime() }
            .max()
}
