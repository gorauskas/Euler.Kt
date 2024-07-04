package com.gorauskas.euler.solutions.forty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler44Test {
    @Test
    fun testSolve() {
        val e = Euler44()
        Assertions.assertEquals(5_482_660L, e.solve())
    }
}
