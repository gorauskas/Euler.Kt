package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler20
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler20Test {

    @Test
    fun testSolve() {
        val e = Euler20()
        Assertions.assertEquals(648L, e.solve())
    }

}
