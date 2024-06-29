package com.gorauskas.euler.solutions.thirty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler31Test {
    @Test
    fun testSolve() {
        val e = Euler31()
        Assertions.assertEquals(73_682L, e.solve())
    }
}
