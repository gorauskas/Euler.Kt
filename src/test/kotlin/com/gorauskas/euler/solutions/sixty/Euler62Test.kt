package com.gorauskas.euler.solutions.sixty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler62Test {
    @Test
    fun testSolve() {
        val e = Euler62()
        Assertions.assertEquals(127_035_954_683L, e.solve())
    }
}
