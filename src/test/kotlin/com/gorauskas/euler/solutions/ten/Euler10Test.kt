package com.gorauskas.euler.solutions.ten

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler10Test {
    @Test
    fun testSolve() {
        val e = Euler10()
        Assertions.assertEquals(142_913_828_922L, e.solve())
    }
}
