package com.gorauskas.euler.solutions.thirtyonetoforty

import com.gorauskas.euler.EULER40_CHAR_OFFSET
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer

class Euler40 : EulerSolution {
    override val problem = """
        Project Euler Problem 40:

            An irrational decimal fraction is created by concatenating the positive integers:

              0.123456789101112131415161718192021...

            It can be seen that the 12th digit of the fractional part is 1.

            If dn represents the nth digit of the fractional part, find the value of the following expression.

              d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
    """.trimIndent()

    override val answer = """

        The value is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long {
        val ls = (0L..1000000L).joinToString("")
        var result = (ls.get(1).code - EULER40_CHAR_OFFSET).toLong()
        result *= (ls.get(10).code - EULER40_CHAR_OFFSET).toLong()
        result *= (ls.get(100).code - EULER40_CHAR_OFFSET).toLong()
        result *= (ls.get(1000).code - EULER40_CHAR_OFFSET).toLong()
        result *= (ls.get(10000).code - EULER40_CHAR_OFFSET).toLong()
        result *= (ls.get(100000).code - EULER40_CHAR_OFFSET).toLong()
        result *= (ls.get(1000000).code - EULER40_CHAR_OFFSET).toLong()
        return result
    }
}
