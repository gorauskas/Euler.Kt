package com.gorauskas.euler.solutions.ten

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler12Test {
    @Test
    fun testSolve() {
        val e = Euler12()
        Assertions.assertEquals(76_576_500L, e.solve())
    }
}
