package com.gorauskas.euler.solutions.twentyonetothirty

import com.gorauskas.euler.extensions.isPrime
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.ifFalse
import com.gorauskas.euler.functions.ifTrue
import com.gorauskas.euler.functions.timer

class Euler27 : EulerSolution {
    override val problem = """
        Project Euler Problem 27:

            Euler published the remarkable quadratic formula:

            n² + n + 41

            It turns out that the formula will produce 40 primes for the consecutive
            values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is
            divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly
            divisible by 41.

            Using computers, the incredible formula  n² - 79n + 1601 was discovered,
            which produces 80 primes for the consecutive values n = 0 to 79. The
            product of the coefficients, -79 and 1601, is -126479.

            Considering quadratics of the form:

            n² + an + b, where |a| < 1000 and |b| < 1000

            where |n| is the modulus/absolute value of n
            e.g. |11| = 11 and |-4| = 4

            Find the product of the coefficients, a and b, for the quadratic
            expression that produces the maximum number of primes for consecutive
            values of n, starting with n = 0.
    """.trimIndent()

    override val answer = """

        The product of the coefficients, a and b, for the quadratic expression that produces
        the maximum number of primes for consecutive values of n is ${timer { solve() }}
    """.trimIndent()

    override fun solve(): Long {
        var max = 0L
        var res = 0L

        for (x in -999L..999L) {
            for (y in -999L..999L) {
                var done = false
                var count = 0L

                while (!done) {
                    val num = count * count + x * count + y

                    (num > 0 && num.isPrime()).ifTrue {
                        count++
                    }.ifFalse {
                        done = true
                    }

                    (count > max).ifTrue {
                        max = count
                        res = x * y
                    }
                }
            }
        }

        return res
    }
}
