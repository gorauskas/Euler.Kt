package com.gorauskas.euler.solutions.onetoten

import com.gorauskas.euler.sequences.fibonacciSequence
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer
import kotlinx.coroutines.runBlocking

class Euler2 : EulerSolution {
    override val problem = """
        Project Euler Problem 2:

            Each new term in the Fibonacci sequence is generated by adding the
            previous two terms. By starting with 1 and 2, the first 10 terms
            will be:

                1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

            By considering the terms in the Fibonacci sequence whose values do
            not exceed four million, find the sum of the even-valued terms.
    """.trimIndent()

    override val answer: String = """

        The sum of the even-valued terms in a Fibonacci sequence
        not exceeding 4 million is: ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long = runBlocking { fibonacciSequence(4_000_000L).filter { it % 2L == 0L }.sum() }
}
