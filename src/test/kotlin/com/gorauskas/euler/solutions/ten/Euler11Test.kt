package com.gorauskas.euler.solutions.ten

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler11Test {
    @Test
    fun testSolve() {
        val e = Euler11()
        Assertions.assertEquals(70_600_674L, e.solve())
    }
}
