package com.gorauskas.euler.test.thirtyonetoforty

import com.gorauskas.euler.solutions.thirtyonetoforty.Euler35
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler35Test {
    @Test
    fun testSolve() {
        val e = Euler35()
        Assertions.assertEquals(55L, e.solve())
    }
}
