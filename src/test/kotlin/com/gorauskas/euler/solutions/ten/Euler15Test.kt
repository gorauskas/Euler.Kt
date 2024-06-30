package com.gorauskas.euler.solutions.ten

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler15Test {
    @Test
    fun testSolve() {
        val e = Euler15()
        Assertions.assertEquals(137_846_528_820L, e.solve())
    }
}
