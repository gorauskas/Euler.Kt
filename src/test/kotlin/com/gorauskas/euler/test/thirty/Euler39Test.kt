package com.gorauskas.euler.test.thirty

import com.gorauskas.euler.solutions.thirty.Euler39
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler39Test {
    @Test
    fun testSolve() {
        val e = Euler39()
        Assertions.assertEquals(840L, e.solve())
    }
}
