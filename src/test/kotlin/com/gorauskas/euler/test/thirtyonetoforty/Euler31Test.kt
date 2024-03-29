package com.gorauskas.euler.test.thirtyonetoforty

import com.gorauskas.euler.solutions.thirtyonetoforty.Euler31
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler31Test {
    @Test
    fun testSolve() {
        val e = Euler31()
        Assertions.assertEquals(73_682L, e.solve())
    }
}
