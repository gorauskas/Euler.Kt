package com.gorauskas.euler.solutions

import com.gorauskas.euler.extensions.sumOfDivisors
import com.gorauskas.euler.EulerInterface as IEuler

class Euler21 : IEuler {

    override fun solve(): Double =
        (0L..10000L).filter {
            it.sumOfDivisors().sumOfDivisors() == it && it != it.sumOfDivisors()
        }.sum().toDouble()

    override val problem = """
        Project Euler Problem 21:
        
            Let d(n) be defined as the sum of proper divisors of n (numbers less than n
            which divide evenly into n).
            
            If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and
            each of a and b are called amicable numbers.
            
            For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
            55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
            71 and 142; so d(284) = 220.
            
            Evaluate the sum of all the amicable numbers under 10000.
    """.trimIndent()

    override val answer = """
        
        The sum of all the amicable numbers under 10000 is: ${solve()}
    """.trimIndent()

}