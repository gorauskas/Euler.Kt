package com.gorauskas.euler.test.eleventotwenty

import com.gorauskas.euler.solutions.eleventotwenty.Euler18
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler18Test {
    @Test
    fun testSolve() {
        val e = Euler18()
        Assertions.assertEquals(1_074L, e.solve())
    }
}
