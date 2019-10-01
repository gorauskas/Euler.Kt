package com.gorauskas.euler.solutions

import com.gorauskas.euler.EulerInterface as IEuler

class Euler6 :IEuler {

    override fun solve(): Double {
        val sumOfSqr = Math.pow((1..100L).sum().toDouble(), 2.0)
        val sqrOfSum = (1..100L).map {
            Math.pow(it.toDouble(), 2.0)
        }.sum()
        return sumOfSqr - sqrOfSum
    }

    override val problem = """
    Project Euler Problem 6:
    
        The sum of the squares of the first ten natural numbers is,
     
        12 + 22 + ... + 102 = 385
     
        The square of the sum of the first ten natural numbers is,
     
        (1 + 2 + ... + 10)2 = 552 = 3025
     
        Hence the difference between the sum of the squares of the 
        first ten natural numbers and the square of the sum is 
        3025  385 = 2640. 
     
        Find the difference between the sum of the squares of the 
        first one hundred natural numbers and the square of the sum.
    """.trimIndent()

    override val answer = """
    
    The difference between the sum of the squares
    and the square of the sum of the first 100 numbers
    is: ${solve().toLong()}
    """.trimIndent()

}