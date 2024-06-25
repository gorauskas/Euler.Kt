package com.gorauskas.euler.solutions.forty

import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.getData
import com.gorauskas.euler.extensions.toScore
import com.gorauskas.euler.functions.timer
import com.gorauskas.euler.sequences.triangleSequence
import kotlinx.coroutines.runBlocking

class Euler42 : EulerSolution {
    override val problem = """
        Project Euler Problem 42

            The nth term of the sequence of triangle numbers is given by,
            tn = ½n(n+1); so the first ten triangle numbers are:

              1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

            By converting each letter in a word to a number corresponding to its
            alphabetical position and adding these values we form a word value. For
            example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word
            value is a triangle number then we shall call the word a triangle word.

            Using words.txt (right click and 'Save Link/Target As...'), a 16K text
            file containing nearly two-thousand common English words, how many are
            triangle words?
    """.trimIndent()

    override val answer = """

        There are ${timer { solve() }} triangle words in the file.
    """.trimIndent()

    override fun solve(): Long = runBlocking {
        javaClass.getResource("/p042_words.txt")!!
            .toURI()
            .getData()!!
            .split(",")
            .map { it.replace("\"", "") }
            .let { words ->
                with(triangleSequence(200)) {
                    words.count { contains(it.toScore()) }.toLong()
                }
            }
    }
}
