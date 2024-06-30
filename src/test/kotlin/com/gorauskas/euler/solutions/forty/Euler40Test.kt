package com.gorauskas.euler.solutions.forty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler40Test {
    @Test
    fun testSolve() {
        val e = Euler40()
        Assertions.assertEquals(210L, e.solve())
    }
}
