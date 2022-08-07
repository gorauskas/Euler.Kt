package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler9
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler9Test {

    @Test
    fun testSolve() {
        val e = Euler9()
        Assertions.assertEquals(31875000.0, e.solve())
    }

}
