package com.gorauskas.euler.solutions.forty

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler47Test {
    @Test
    fun testSolve() {
        val e = Euler47()
        Assertions.assertEquals(134_043L, e.solve())
    }
}
