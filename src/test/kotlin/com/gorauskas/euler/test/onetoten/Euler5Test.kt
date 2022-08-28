package com.gorauskas.euler.test.onetoten

import com.gorauskas.euler.solutions.onetoten.Euler5
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler5Test {
    @Test
    fun testSolve() {
        val e = Euler5()
        Assertions.assertEquals(232_792_560L, e.solve())
    }
}
