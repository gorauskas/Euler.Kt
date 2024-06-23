package com.gorauskas.euler.test.twentyonetothirty

import com.gorauskas.euler.solutions.twenty.Euler27
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler27Test {
    @Test
    fun testSolve() {
        val e = Euler27()
        Assertions.assertEquals(-59_231L, e.solve())
    }
}
