@file:Suppress("MaxLineLength")

package com.gorauskas.euler.solutions.twentyonetothirty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer
import kotlin.math.ceil
import kotlin.math.log10
import kotlin.math.sqrt

class Euler25 : EulerSolution {
    /**
     * Solving this problem simply comes down to knowing Binet’s formula for finding the nth Fibonacci
     * term and using logs to determine its magnitude.
     *
     * Wikipedia shows us that the nth Fibonacci number is  F_n = [\frac{\varphi^n}{\sqrt{5}}], n\ge0 ,
     * so we define an inequality that we will use to solve for n for the first Fibonacci number that
     * exceeds d digits. In the case of 1000 digits it would be 10999 or 1 followed by 999 zeros; a
     * thousand digits
     *
     * @see <a href="http://mathworld.wolfram.com/BinetsFibonacciNumberFormula.html">http://mathworld.wolfram.com/BinetsFibonacciNumberFormula.html</a>
     * @see <a href="https://en.wikipedia.org/wiki/Fibonacci_number#Computation_by_rounding">https://en.wikipedia.org/wiki/Fibonacci_number#Computation_by_rounding</a>
     */
    override val problem = """
        Project Euler Problem 25:

            The Fibonacci sequence is defined by the recurrence relation:

            Fn = Fn1 + Fn2, where F1 = 1 and F2 = 1.

            Hence the first 12 terms will be:

                F1 = 1
                F2 = 1
                F3 = 2
                F4 = 3
                F5 = 5
                F6 = 8
                F7 = 13
                F8 = 21
                F9 = 34
                F10 = 55
                F11 = 89
                F12 = 144

            The 12th term, F12, is the first term to contain three digits.

            What is the first term in the Fibonacci sequence to contain 1000 digits?
    """.trimIndent()

    override val answer = """
        The first number in the Fibonacci sequence to contain 1000 digits is: ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long = ceil((log10(5.0) / 2L + 999L) / log10((1L + sqrt(5.0)) / 2L)).toLong()
}
