package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler8
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler8Test {
    @Test
    fun testSolve() {
        val e = Euler8()
        Assertions.assertEquals(23_514_624_000L, e.solve())
    }
}
