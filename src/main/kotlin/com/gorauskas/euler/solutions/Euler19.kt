package com.gorauskas.euler.solutions

import com.gorauskas.euler.EulerSolution

class Euler19 : EulerSolution {

    override fun solve(): Double =
        (1901L..2000L).flatMap { y ->
            (1L..12L).filter { m ->
                dayOfWeek(y, m, 1L) == 0L
            }
        }.count().toDouble()

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

        There were ${solve()} Sundays falling on the first of the month in
        the twentieth century.
    """.trimIndent()

    /**
     * Zeller's congruence - https://en.wikipedia.org/wiki/Zeller%27s_congruence
     * @param year - The Year
     * @param month - The Month
     * @param day - The Day
     * @return A number from 0 to 6 representing the day of the week; 0 = Sunday
     */
    private fun dayOfWeek(year: Long, month: Long, day: Long): Long {
        var m = Math.floorMod(month - 3L, 48000L)
        val y = Math.floorMod(year + m / 12L, 400L)
        m %= 12L
        return ((y + y / 4L - y / 100L + (13L * m + 2L) / 5L + day + 2L) % 7L)
    }

}
