package com.gorauskas.euler.test.onetoten

import com.gorauskas.euler.solutions.one.Euler8
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler8Test {
    @Test
    fun testSolve() {
        val e = Euler8()
        Assertions.assertEquals(23_514_624_000L, e.solve())
    }
}
