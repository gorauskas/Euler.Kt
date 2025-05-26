package com.gorauskas.euler.solutions.sixty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler61Test {
    @Test
    fun testSolve() {
        val e = Euler61()
        Assertions.assertEquals(28_684L, e.solve())
    }
}
