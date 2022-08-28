package com.gorauskas.euler.test.thirtyonetoforty

import com.gorauskas.euler.solutions.thirtyonetoforty.Euler34
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler34Test {
    @Test
    fun testSolve() {
        val e = Euler34()
        Assertions.assertEquals(40_730L, e.solve())
    }
}
