package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler11
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler11Test {

    @Test
    fun testSolve() {
        val e = Euler11()
        Assertions.assertEquals(70600674.0, e.solve())
    }

}