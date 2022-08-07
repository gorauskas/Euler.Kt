package com.gorauskas.euler.sequences

import com.gorauskas.euler.extensions.isPrime

fun fibonacciSequence(): Sequence<Long> =
    sequence {
        var seed = Pair(0L, 1L)
        while (true) {
            yield(seed.first)
            seed = Pair(seed.second, seed.first + seed.second)
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

fun triangleSequence(): Sequence<Long> {
    val i = 1L;
    return sequence {
        generateSequence(i, { it + 1 })
            .forEach { n ->
                yield((n * n + n) / 2)
            }
    }
}

fun triangleSequence(max: Int): Sequence<Long> {
    return triangleSequence().takeWhile { it < max }
}
