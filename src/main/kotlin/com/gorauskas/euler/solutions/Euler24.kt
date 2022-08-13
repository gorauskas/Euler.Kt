package com.gorauskas.euler.solutions

import com.gorauskas.euler.extensions.factorial
import com.gorauskas.euler.EulerSolution

class Euler24 : EulerSolution  {
    /**
     * we want the 999999 permutation of 0123456789 (which is the millionth one using index 0)
     * there are n! permutations for n elements - which is the first digit of the millionth permutation?
     * The last nine digits can be ordered in 9! = 362880 ways; so the first 362880 start with the 0
     * digit. permutations from 362881 to 725760 start with a 1 and then the permutations from 725761
     * to 1088640 starts with a 2. it is now clear that the millionth permutation is in the third
     * interval, and thus must start with a 2... we take 2 as the first digit of the result out of
     * numbers and continue and so on and so forth for the 2nd, 3rd, etc digits.
     */
    override fun solve(): Double =
        mutableListOf<Long>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).let { numbers ->
            val digitCount = numbers.size.toLong()
            var remainingPermutations = 999999L
            var result = ""

            (1L until digitCount).forEach loop@{ currentDigit ->
                (remainingPermutations / (digitCount - currentDigit).factorial()).also { digitPosition ->
                    remainingPermutations %= (digitCount - currentDigit).factorial()
                    result += numbers[digitPosition.toInt()]
                    numbers.removeAt(digitPosition.toInt())
                    if (remainingPermutations == 0L) { return@loop } // return@loop = break
                }
            }

            result.plus(numbers[0]).toDouble()
        }


    override val problem = """
        Project Euler Problem 24

            A permutation is an ordered arrangement of objects. For example,
            3124 is one possible permutation of the digits 1, 2, 3 and 4. If
            all of the permutations are listed numerically or alphabetically,
            we call it lexicographic order. The lexicographic permutations of
            0, 1 and 2 are:

                012   021   102   120   201   210

            What is the millionth lexicographic permutation of the digits
            0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
    """.trimIndent()

    override val answer = """
        The millionth lexicographic permutation of the digits 0 through 9 is ${solve()}
    """.trimIndent()
}
