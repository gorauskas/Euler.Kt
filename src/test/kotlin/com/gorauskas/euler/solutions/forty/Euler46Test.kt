package com.gorauskas.euler.solutions.forty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler46Test {
    @Test
    fun testSolve() {
        val e = Euler46()
        Assertions.assertEquals(5_777L, e.solve())
    }
}
