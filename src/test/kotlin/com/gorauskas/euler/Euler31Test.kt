package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler31
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler31Test {

    @Test
    fun testSolve() {
        val e = Euler31()
        Assertions.assertEquals(73682.0, e.solve())
    }

}
