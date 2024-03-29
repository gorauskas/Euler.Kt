package com.gorauskas.euler.test.twentyonetothirty

import com.gorauskas.euler.solutions.twentyonetothirty.Euler25
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler25Test {
    @Test
    fun testSolve() {
        val e = Euler25()
        Assertions.assertEquals(4_782L, e.solve())
    }
}
