package com.gorauskas.euler.solutions.one

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Euler4Test {
    @Test
    fun testSolve() {
        val e = Euler4()
        assertEquals(906_609L, e.solve())
    }
}
