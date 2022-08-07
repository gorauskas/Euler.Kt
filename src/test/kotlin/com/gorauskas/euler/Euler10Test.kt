package com.gorauskas.euler

import com.gorauskas.euler.solutions.Euler10
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Euler10Test {

    @Test
    fun testSolve() {
        val e = Euler10()
        Assertions.assertEquals(142913828922.0, e.solve())
    }

}
