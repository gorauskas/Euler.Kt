package com.gorauskas.euler.solutions.thirty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler30Test {
    @Test
    fun testSolve() {
        val e = Euler30()
        Assertions.assertEquals(443_839L, e.solve())
    }
}
