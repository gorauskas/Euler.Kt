package com.gorauskas.euler.solutions

import com.gorauskas.euler.sequences.fibonacciSequence

import com.gorauskas.euler.EulerSolution

class Euler2 : EulerSolution {
    override fun solve(): Double {

        return fibonacciSequence()
            .take(35)
            .filter { it < 4000000 }
            .filter { it % 2 == 0L }
            .sum()
            .toDouble()

        // return loopStrategy()
    }

    private fun loopStrategy(): Double {
        var x = 1
        var y = 1
        var t = 0
        var r = 0

        while (t < 4000000) {
            t = x + y
            y = x
            x = t

            if (t % 2 == 0) {
                r += t
            }
        }

        return r.toDouble()
    }

    override val problem = """
    Project Euler Problem 2:

      Each new term in the Fibonacci sequence is generated by adding the
      previous two terms. By starting with 1 and 2, the first 10 terms
      will be:

        1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

      By considering the terms in the Fibonacci sequence whose values do
      not exceed four million, find the sum of the even-valued terms.
    """.trimIndent()

    override val answer = """

    The sum of the even-valued terms in a Fibonacci sequence
    not exceeding 4 million is: ${solve()}
    """.trimIndent()
}
