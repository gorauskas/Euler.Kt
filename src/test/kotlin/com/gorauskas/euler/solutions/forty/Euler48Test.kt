package com.gorauskas.euler.solutions.forty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler48Test {
    @Test
    fun testSolve() {
        val e = Euler48()
        Assertions.assertEquals(9_110_846_700L, e.solve())
    }
}
