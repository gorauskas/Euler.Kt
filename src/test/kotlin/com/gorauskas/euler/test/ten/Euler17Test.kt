package com.gorauskas.euler.test.ten

import com.gorauskas.euler.solutions.ten.Euler17
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler17Test {
    @Test
    fun testSolve() {
        val e = Euler17()
        Assertions.assertEquals(21_124L, e.solve())
    }
}
