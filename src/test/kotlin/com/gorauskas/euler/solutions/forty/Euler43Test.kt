package com.gorauskas.euler.solutions.forty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler43Test {
    @Test
    fun testSolve() {
        val e = Euler43()
        Assertions.assertEquals(16_695_334_890L, e.solve())
    }
}
