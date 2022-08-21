package com.gorauskas.euler

interface EulerSolution {
    val problem: String
    val answer: String
    fun solve(): Long
}

typealias IEuler = EulerSolution
