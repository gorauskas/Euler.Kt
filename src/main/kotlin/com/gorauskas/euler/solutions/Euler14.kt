package com.gorauskas.euler.solutions

import com.gorauskas.euler.EulerInterface as IEuler

class Euler14 : IEuler {

    private var num = 0L
    private var len = 0

    override fun solve(): Double {
        val nums = (1L..999999L)

        nums.forEach {
            if (collatzList(it).count() > len) {
                val l = collatzList(it)
                len = l.count()
                num = it
            }
        }

        return num.toDouble()
    }

    override val problem = """
        Project Euler Problem 14:
            
            The following iterative sequence is defined for the n of positive
            integers:
            
              n -> n/2      (n is even)
              n -> 3n + 1   (n is odd)

            Using the rule above and starting with 13, we generate the following
            sequence:
            
              13  40  20  10  5  16  8  4  2  1
              
            It can be seen that this sequence (starting at 13 and finishing at 1)
            contains 10 terms. Although it has not been proved yet (Collatz Problem), 
            it is thought that all starting numbers finish at 1.
            
            Which starting number, under one million, produces the longest chain?
    """.trimIndent()

    override val answer = """
        
        The starting number, under one million, producing the longest chain is ${solve()}
    """.trimIndent()

    private fun collatzList(n: Long): ArrayList<Long> {
        var i = n
        var l = arrayListOf<Long>()

        while (i > 1) {
            if (i % 2L == 0L) {
                i = i / 2
            } else {
                i = (3 * i) + 1
            }

            l.add(i)
        }

        return l
    }
}

