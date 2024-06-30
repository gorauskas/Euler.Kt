package com.gorauskas.euler.solutions.twenty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler28Test {
    @Test
    fun testSolve() {
        val e = Euler28()
        Assertions.assertEquals(669_171_001L, e.solve())
    }
}
