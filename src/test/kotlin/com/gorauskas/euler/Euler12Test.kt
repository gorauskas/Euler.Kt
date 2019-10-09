package com.gorauskas.euler

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import com.gorauskas.euler.solutions.Euler12

class Euler12Test {

    @Test
    fun testSolve() {
        val e = Euler12()
        Assertions.assertEquals(76576500.0, e.solve())
    }

}