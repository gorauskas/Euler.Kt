package com.gorauskas.euler.solutions.sixty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler65Test {
    @Test
    fun testSolve() {
        val e = Euler65()
        Assertions.assertEquals(272L, e.solve())
    }
}
