package com.gorauskas.euler.sequences

import com.gorauskas.euler.extensions.isPrime

suspend fun fibonacciSequence(): Sequence<Long> = sequence {
    yieldAll(generateSequence(Pair(0L, 1L)) { Pair(it.second, it.first + it.second) }.map { p -> p.first })
}

suspend fun fibonacciSequence(max: Long) = fibonacciSequence().takeWhile { it < max }

suspend fun primeSequence(): Sequence<Long> = sequence {
    yieldAll(generateSequence(0L) { it + 1 }.filter { n -> n.isPrime() })
}

suspend fun primeSequence(max: Int) = primeSequence().takeWhile { it < max }

suspend fun primeSequence(min: Int, max: Int) = primeSequence().dropWhile { it < min }.takeWhile { it < max }

suspend fun triangleSequence(): Sequence<Long> = sequence {
    yieldAll(generateSequence(1L) { it + 1 }.map { n -> (n * n + n) / 2 })
}

suspend fun triangleSequence(max: Int) = triangleSequence().takeWhile { it < max }

suspend fun collatzSequence(n: Long): Sequence<Long> = sequence {
    yieldAll(
        generateSequence(n) {
            when {
                it == 1L -> null
                it % 2L == 0L -> it / 2L
                else -> 3L * it + 1L
            }
        },
    )
}
