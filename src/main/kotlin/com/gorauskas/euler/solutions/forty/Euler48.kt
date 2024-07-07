package com.gorauskas.euler.solutions.forty

import com.gorauskas.euler.EULER_NUM_TEN_BILLION_INT
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer
import java.math.BigInteger

class Euler48 : EulerSolution {
    override val problem = """
        Project Euler Problem 48

            The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

            Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000
    """.trimIndent()

    override val answer = """

        The last 10 digits of the series is ${timer { solve() }}
    """.trimIndent()

    /**
     * There is a modular arithmetic rule that states:
     *
     *   `(x * y) % m == ((x % m) * (y % m)) % m`
     *
     * in our case, we are interested in a self power, therefore:
     *
     *   `(x^2) % m == (x % m)^2 % m`
     *
     * The carried over number for each new self-power is significantly reduced by
     * performing modulo at every step. BigInteger's built-in `modPow(exp, mod)`
     * implements this.
     */
    override fun solve(): Long =
        BigInteger.valueOf(EULER_NUM_TEN_BILLION_INT).let { bigmod ->
            (1L..1000L).fold(BigInteger.ZERO) { acc, i ->
                val power = BigInteger.valueOf(i)
                acc + power.modPow(power, bigmod)
            }.mod(bigmod).longValueExact()
        }
}
