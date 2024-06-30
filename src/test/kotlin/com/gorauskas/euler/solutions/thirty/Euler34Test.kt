package com.gorauskas.euler.solutions.thirty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler34Test {
    @Test
    fun testSolve() {
        val e = Euler34()
        Assertions.assertEquals(40_730L, e.solve())
    }
}
