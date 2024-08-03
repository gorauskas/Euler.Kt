package com.gorauskas.euler.solutions.fifty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler54Test {
    @Test
    fun testSolve() {
        val e = Euler54()
        Assertions.assertEquals(376L, e.solve())
    }
}
