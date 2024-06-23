package com.gorauskas.euler.test.eleventotwenty

import com.gorauskas.euler.solutions.ten.Euler13
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler13Test {
    @Test
    fun testSolve() {
        val e = Euler13()
        Assertions.assertEquals(5_537_376_230L, e.solve())
    }
}
