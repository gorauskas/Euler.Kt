package com.gorauskas.euler.solutions

import com.gorauskas.euler.extensions.gcd
import com.gorauskas.euler.EulerInterface as IEuler

class Euler5 : IEuler {

    /**
     * Solve a simpler version of the problem. The lowest common multiple (LCM) of
     * two numbers x and y, usually denoted as lcm(x, y), is the smallest positive
     * number that is divisible by both x and y. You can do this by using the greatest
     * common divisor (GCD) function per the following formula:
     *
     *                |x . y|
     *   lcm(x, y) = ---------
     *               gcd(x, y)
     *
     * Above we transform the problem of computing the LCM into the problem of
     * computing the GCD. Next, observe that lcm(x,y,z) = lcm(lcm(x,y),z), thus
     * we can use reduce to apply LCM to the number from 1 to 20 and get to our
     * result.
     *
     * @return double
     */
    override fun solve(): Double {
        return (1..20L).reduce { x, y -> x * y / x.gcd(y) }.toDouble()
    }

    override val problem = """
    Project Euler Problem 5:

       2520 is the smallest number that can be divided by each of the
       numbers from 1 to 10 without any remainder.

       What is the smallest positive number that is evenly divisible
       by all of the numbers from 1 to 20?
    """.trimIndent()

    override val answer = """

    The smallest positive number that is evenly divisible
    by all of the numbers from 1 to 20 is: ${solve().toLong()}
    """.trimIndent()
}
