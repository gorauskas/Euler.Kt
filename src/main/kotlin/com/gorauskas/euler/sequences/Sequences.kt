package com.gorauskas.euler.sequences

import com.gorauskas.euler.extensions.isPrime

fun fibonacciSequence(): Sequence<Long> =
    sequence {
        generateSequence(
            Pair(0L, 1L),
            { Pair(it.second, it.first + it.second) }
        ).forEach { p ->
            yield(p.first)
        }
    }

fun primeSequence(): Sequence<Long> {
    var i = 0L
    return sequence {
        this.yieldAll(generateSequence { i++ }.filter { n -> n.isPrime() })
    }
}

fun primeSequence(max: Int): Sequence<Long> {
    return primeSequence().takeWhile { it < max }
}

fun triangleSequence(): Sequence<Long> =
    sequence {
        generateSequence(1L, { it + 1 })
            .forEach { n ->
                yield((n * n + n) / 2)
            }
    }

fun triangleSequence(max: Int): Sequence<Long> {
    return triangleSequence().takeWhile { it < max }
}

fun collatzSequence(n: Long): Sequence<Long> =
    sequence {
        yieldAll(
            generateSequence(n) {
                when {
                    it == 1L -> null
                    it % 2L == 0L -> it / 2L
                    else -> 3L * it + 1L
                }
            }
        )
    }
