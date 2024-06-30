package com.gorauskas.euler.solutions.twenty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler27Test {
    @Test
    fun testSolve() {
        val e = Euler27()
        Assertions.assertEquals(-59_231L, e.solve())
    }
}
