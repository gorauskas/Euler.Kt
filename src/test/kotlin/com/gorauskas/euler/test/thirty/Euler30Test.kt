package com.gorauskas.euler.test.twentyonetothirty

import com.gorauskas.euler.solutions.thirty.Euler30
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler30Test {
    @Test
    fun testSolve() {
        val e = Euler30()
        Assertions.assertEquals(443_839L, e.solve())
    }
}
