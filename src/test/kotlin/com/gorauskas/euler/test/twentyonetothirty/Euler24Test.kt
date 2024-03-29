package com.gorauskas.euler.test.twentyonetothirty

import com.gorauskas.euler.solutions.twentyonetothirty.Euler24
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler24Test {
    @Test
    fun testSolve() {
        val e = Euler24()
        Assertions.assertEquals(2_783_915_460L, e.solve())
    }
}
