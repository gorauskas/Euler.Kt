package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler17
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler17Test {

    @Test
    fun testSolve() {
        val e = Euler17()
        Assertions.assertEquals(21124.0, e.solve())
    }

}
