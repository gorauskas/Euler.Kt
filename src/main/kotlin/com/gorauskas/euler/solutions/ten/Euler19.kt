package com.gorauskas.euler.solutions.ten

import com.gorauskas.euler.EULER019_CENTURY_END
import com.gorauskas.euler.EULER019_CENTURY_START
import com.gorauskas.euler.EULER019_LAST_MONTH
import com.gorauskas.euler.EulerSolution
import com.gorauskas.euler.functions.timer

@Suppress("CommentOverPrivateFunction")
class Euler19 : EulerSolution {
    override val problem = """
        Project Euler Problem 19:

            You are given the following information, but you may prefer to do some
            research for yourself.

            a. 1 Jan 1900 was a Monday.
            b. Thirty days has September,
               April, June and November.
               All the rest have thirty-one,
               Saving February alone,
               Which has twenty-eight, rain or shine.
               And on leap years, twenty-nine.
            c. A leap year occurs on any year evenly divisible by 4, but not on a
               century unless it is divisible by 400.

            How many Sundays fell on the first of the month during the twentieth
            century (1 Jan 1901 to 31 Dec 2000)?
    """.trimIndent()

    override val answer = """

        There were ${timer { solve() }} Sundays falling on the first of the month in
        the twentieth century.
    """.trimIndent()

    override fun solve(): Long = (EULER019_CENTURY_START..EULER019_CENTURY_END).flatMap { y ->
        (1L..EULER019_LAST_MONTH).filter { m ->
            dayOfWeek(y, m) == 0L
        }
    }.count().toLong()

    /**
     * Zeller's congruence - https://en.wikipedia.org/wiki/Zeller%27s_congruence
     * @param year - The Year
     * @param month - The Month
     * @return A number from 0 to 6 representing the day of the week; 0 = Sunday
     * The day in this case is always 1 for the first
     */
    @Suppress("MagicNumber")
    private fun dayOfWeek(year: Long, month: Long): Long = Math.floorMod(month - 3L, 48_000L)
        .let { m ->
            Math.floorMod(year + m / 12L, 400L)
                .let { y ->
                    (y + y / 4L - y / 100L + (13L * (m % 12L) + 2L) / 5L + 1L + 2L) % 7L
                }
        }
}
