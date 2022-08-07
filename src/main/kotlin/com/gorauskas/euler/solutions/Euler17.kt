package com.gorauskas.euler.solutions

import com.gorauskas.euler.INT_EIGHT
import com.gorauskas.euler.INT_FORTY
import com.gorauskas.euler.INT_FOUR
import com.gorauskas.euler.INT_ONE
import com.gorauskas.euler.INT_TEN
import com.gorauskas.euler.INT_THREE
import com.gorauskas.euler.INT_TWO
import com.gorauskas.euler.INT_ZERO
import com.gorauskas.euler.LONG_EIGHT
import com.gorauskas.euler.LONG_EIGHTTEEN
import com.gorauskas.euler.LONG_EIGHTY
import com.gorauskas.euler.LONG_ELEVEN
import com.gorauskas.euler.LONG_FIFTEEN
import com.gorauskas.euler.LONG_FIFTY
import com.gorauskas.euler.LONG_FIVE
import com.gorauskas.euler.LONG_FORTY
import com.gorauskas.euler.LONG_FOUR
import com.gorauskas.euler.LONG_FOURTEEN
import com.gorauskas.euler.LONG_NINE
import com.gorauskas.euler.LONG_NINETEEN
import com.gorauskas.euler.LONG_NINETY
import com.gorauskas.euler.LONG_ONE
import com.gorauskas.euler.LONG_ONE_HUNDRED
import com.gorauskas.euler.LONG_ONE_THOUSAND
import com.gorauskas.euler.LONG_SEVEN
import com.gorauskas.euler.LONG_SEVENTEEN
import com.gorauskas.euler.LONG_SEVENTY
import com.gorauskas.euler.LONG_SIX
import com.gorauskas.euler.LONG_SIXTEEN
import com.gorauskas.euler.LONG_SIXTY
import com.gorauskas.euler.LONG_TEN
import com.gorauskas.euler.LONG_THIRTEEN
import com.gorauskas.euler.LONG_THIRTY
import com.gorauskas.euler.LONG_THREE
import com.gorauskas.euler.LONG_TWELVE
import com.gorauskas.euler.LONG_TWENTY
import com.gorauskas.euler.LONG_TWO
import com.gorauskas.euler.LONG_ZERO
import kotlin.streams.toList
import com.gorauskas.euler.EulerInterface as IEuler

class Euler17 : IEuler {

    private val lookupTable = mapOf(
        Pair(LONG_ONE, "one"),
        Pair(LONG_TWO, "two"),
        Pair(LONG_THREE, "three"),
        Pair(LONG_FOUR, "four"),
        Pair(LONG_FIVE, "five"),
        Pair(LONG_SIX, "six"),
        Pair(LONG_SEVEN, "seven"),
        Pair(LONG_EIGHT, "eight"),
        Pair(LONG_NINE, "nine"),
        Pair(LONG_TEN, "ten"),
        Pair(LONG_ELEVEN, "eleven"),
        Pair(LONG_TWELVE, "twelve"),
        Pair(LONG_THIRTEEN, "thirteen"),
        Pair(LONG_FOURTEEN, "fourteen"),
        Pair(LONG_FIFTEEN, "fifteen"),
        Pair(LONG_SIXTEEN, "sixteen"),
        Pair(LONG_SEVENTEEN, "seventeen"),
        Pair(LONG_EIGHTTEEN, "eighteen"),
        Pair(LONG_NINETEEN, "nineteen"),
        Pair(LONG_TWENTY, "twenty"),
        Pair(LONG_THIRTY, "thirty"),
        Pair(LONG_FORTY, "forty"),
        Pair(LONG_FIFTY, "fifty"),
        Pair(LONG_SIXTY, "sixty"),
        Pair(LONG_SEVENTY, "seventy"),
        Pair(LONG_EIGHTY, "eighty"),
        Pair(LONG_NINETY, "ninety"),
        Pair(LONG_ONE_HUNDRED, "hundred"),
        Pair(LONG_ONE_THOUSAND, "thousand")
    )

    override fun solve(): Double {
        return buildString {
            (LONG_ONE..LONG_ONE_THOUSAND).forEach {
                append(spellNumber(it))
            }
        }.length.toDouble()
    }

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
        have ${solve()} letters.
    """.trimIndent()

    private fun spellNumber(num: Long): String {
        return buildString {
            var decPostVal = LONG_NINETY + LONG_NINE
            val nums = num.toString().reversed().chars()
                .map { (it - (INT_FORTY + INT_EIGHT)) }
                .mapToLong { it.toLong() }
                .toList()
            if (nums.size == INT_FOUR && nums[INT_THREE] != LONG_ZERO) {
                append(lookupTable[nums[INT_THREE]] + " thousand")
            }
            if (nums.size >= INT_THREE && nums[INT_TWO] != LONG_ZERO) {
                append(lookupTable[nums[INT_TWO]] + " hundred")

                if (nums.size >= INT_TWO && nums[INT_ONE] != LONG_ZERO) {
                    append(" and")
                } else if (nums.size >= INT_ONE && nums[INT_ZERO] != LONG_ZERO) {
                    append(" and")
                }
            }
            if (nums.size >= INT_TWO && nums[INT_ONE] != LONG_ZERO) {
                decPostVal = nums[INT_ONE] * LONG_TEN + nums[INT_ZERO]

                if (decPostVal <= LONG_TWENTY) {
                    append(" " + lookupTable[decPostVal])
                } else {
                    append(" " + lookupTable[nums[INT_ONE] * INT_TEN])
                }
            }
            if (nums.size >= INT_ONE && nums[INT_ZERO] != LONG_ZERO && decPostVal > LONG_TWENTY) {
                append(" " + lookupTable[nums[INT_ZERO]])
            }
        }.replace(" ", "")
    }
}
