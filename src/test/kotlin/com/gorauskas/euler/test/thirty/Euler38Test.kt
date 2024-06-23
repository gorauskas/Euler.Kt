package com.gorauskas.euler.test.thirtyonetoforty

import com.gorauskas.euler.solutions.thirty.Euler38
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler38Test {
    @Test
    fun testSolve() {
        val e = Euler38()
        Assertions.assertEquals(932_718_654L, e.solve())
    }
}
