package com.gorauskas.euler.test.eleventotwenty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import com.gorauskas.euler.solutions.eleventotwenty.Euler12

class Euler12Test {
    @Test
    fun testSolve() {
        val e = Euler12()
        Assertions.assertEquals(76_576_500L, e.solve())
    }
}
