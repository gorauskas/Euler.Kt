package com.gorauskas.euler.solutions.twenty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler24Test {
    @Test
    fun testSolve() {
        val e = Euler24()
        Assertions.assertEquals(2_783_915_460L, e.solve())
    }
}
