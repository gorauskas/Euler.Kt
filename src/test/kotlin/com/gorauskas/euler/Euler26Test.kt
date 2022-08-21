package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler26
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler26Test {
    @Test
    fun testSolve() {
        val e = Euler26()
        Assertions.assertEquals(983L, e.solve())
    }
}
