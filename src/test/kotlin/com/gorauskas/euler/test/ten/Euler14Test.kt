package com.gorauskas.euler.test.ten

import com.gorauskas.euler.solutions.ten.Euler14
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler14Test {
    @Test
    fun testSolve() {
        val e = Euler14()
        Assertions.assertEquals(837_799L, e.solve())
    }
}
