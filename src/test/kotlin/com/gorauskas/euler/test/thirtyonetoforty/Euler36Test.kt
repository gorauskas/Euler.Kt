package com.gorauskas.euler.test.thirtyonetoforty

import com.gorauskas.euler.solutions.thirtyonetoforty.Euler36
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler36Test {
    @Test
    fun testSolve() {
        val e = Euler36()
        Assertions.assertEquals(872_187L, e.solve())
    }
}
