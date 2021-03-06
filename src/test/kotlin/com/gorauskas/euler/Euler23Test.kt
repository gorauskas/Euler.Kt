package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler23
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler23Test {

    @Test
    fun testSolve() {
        val e = Euler23()
        Assertions.assertEquals(4179871.0, e.solve())
    }

}