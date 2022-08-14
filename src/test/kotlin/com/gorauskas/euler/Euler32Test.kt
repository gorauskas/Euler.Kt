package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler32
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler32Test {
    @Test
    fun testSolve() {
        val e = Euler32()
        Assertions.assertEquals(45228L, e.solve())
    }
}
