package com.gorauskas.euler.test.eleventotwenty

import com.gorauskas.euler.solutions.eleventotwenty.Euler19
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler19Test {
    @Test
    fun testSolve() {
        val e = Euler19()
        Assertions.assertEquals(171L, e.solve())
    }
}
