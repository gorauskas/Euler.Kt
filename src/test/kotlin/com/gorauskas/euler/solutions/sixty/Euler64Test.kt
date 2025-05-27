package com.gorauskas.euler.solutions.sixty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler64Test {
    @Test
    fun testSolve() {
        val e = Euler64()
        Assertions.assertEquals(1_322L, e.solve())
    }
}
