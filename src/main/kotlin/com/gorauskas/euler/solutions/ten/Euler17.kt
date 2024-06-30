package com.gorauskas.euler.solutions.ten

import com.gorauskas.euler.EULER017_CHAR_OFFSET
import com.gorauskas.euler.EULER017_START_INDEX
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.extensions.longLength
import com.gorauskas.euler.functions.ifFalse
import com.gorauskas.euler.functions.ifTrue
import com.gorauskas.euler.functions.timer

@Suppress("MagicNumber")
class Euler17 : EulerSolution {
    private val lookupTable = mapOf(
        Pair(1L, "one"),
        Pair(2L, "two"),
        Pair(3L, "three"),
        Pair(4L, "four"),
        Pair(5L, "five"),
        Pair(6L, "six"),
        Pair(7L, "seven"),
        Pair(8L, "eight"),
        Pair(9L, "nine"),
        Pair(10L, "ten"),
        Pair(11L, "eleven"),
        Pair(12L, "twelve"),
        Pair(13L, "thirteen"),
        Pair(14L, "fourteen"),
        Pair(15L, "fifteen"),
        Pair(16L, "sixteen"),
        Pair(17L, "seventeen"),
        Pair(18L, "eighteen"),
        Pair(19L, "nineteen"),
        Pair(20L, "twenty"),
        Pair(30L, "thirty"),
        Pair(40L, "forty"),
        Pair(50L, "fifty"),
        Pair(60L, "sixty"),
        Pair(70L, "seventy"),
        Pair(80L, "eighty"),
        Pair(90L, "ninety"),
        Pair(100L, "hundred"),
        Pair(1000L, "thousand"),
    )

    override val problem = """
        Project Euler Problem 17:

            If the numbers 1 to 5 are written out in words: one, two, three, four,
            five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

            If all the numbers from 1 to 1000 (one thousand) inclusive were written
            out in words, how many letters would be used?

            NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
            forty-two) contains 23 letters and 115 (one hundred and fifteen) contains
            20 letters. The use of 'and' when writing out numbers is in compliance
            with British usage.
    """.trimIndent()

    override val answer = """

        The numbers from 1 to 1000, when written out in words,
        have ${timer { solve() }} letters.
    """.trimIndent()

    override fun solve(): Long = buildString {
        for (idx in 1L..1000L) {
            append((spellNumber(idx)))
        }
    }.longLength()

    @Suppress("ComplexMethod")
    private fun spellNumber(num: Long): String {
        return buildString {
            var ltIndex = EULER017_START_INDEX
            val nums = num.toString().reversed().toCharArray()
                .map { it.code - EULER017_CHAR_OFFSET }
            (nums.size == 4 && nums[3] != 0L).ifTrue {
                append(lookupTable[nums[3]] + " thousand")
            }
            (nums.size >= 3 && nums[2] != 0L).ifTrue {
                append(lookupTable[nums[2]] + " hundred")

                if (nums.size >= 2 && nums[1] != 0L) {
                    append(" and")
                } else if (nums.size >= 1 && nums[0] != 0L) {
                    append(" and")
                }
            }
            (nums.size >= 2 && nums[1] != 0L).ifTrue {
                ltIndex = nums[1] * 10L + nums[0]

                (ltIndex <= 20L).ifTrue {
                    append(" " + lookupTable[ltIndex])
                }.ifFalse {
                    append(" " + lookupTable[nums[1] * 10])
                }
            }
            (nums.size >= 1 && nums[0] != 0L && ltIndex > 20L).ifTrue {
                append(" " + lookupTable[nums[0]])
            }
        }.replace(" ", "")
    }
}
