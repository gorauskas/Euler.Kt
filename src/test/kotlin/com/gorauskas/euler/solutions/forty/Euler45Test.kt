package com.gorauskas.euler.solutions.forty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler45Test {
    @Test
    fun testSolve() {
        val e = Euler45()
        Assertions.assertEquals(1_533_776_805L, e.solve())
    }
}
