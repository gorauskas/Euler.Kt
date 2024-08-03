package com.gorauskas.euler.solutions.fifty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler57Test {
    @Test
    fun testSolve() {
        val e = Euler57()
        Assertions.assertEquals(153L, e.solve())
    }
}
