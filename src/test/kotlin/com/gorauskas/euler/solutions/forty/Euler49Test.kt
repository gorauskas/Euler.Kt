package com.gorauskas.euler.solutions.forty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler49Test {
    @Test
    fun testSolve() {
        val e = Euler49()
        Assertions.assertEquals(296_962_999_629L, e.solve())
    }
}
