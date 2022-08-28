package com.gorauskas.euler.test.onetoten

import com.gorauskas.euler.solutions.onetoten.Euler1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Euler1Test {
    @Test
    fun testSolve() {
        val e = Euler1()
        assertEquals(233_168L, e.solve())
    }
}
