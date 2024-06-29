package com.gorauskas.euler.solutions.twenty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler25Test {
    @Test
    fun testSolve() {
        val e = Euler25()
        Assertions.assertEquals(4_782L, e.solve())
    }
}
