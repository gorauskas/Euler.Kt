package com.gorauskas.euler.sequences

import com.gorauskas.euler.extensions.isPrime

fun fibonacciSequence() = sequence {
    yieldAll(generateSequence(Pair(0L, 1L)) { Pair(it.second, it.first + it.second) }.map { p -> p.first })
}

fun fibonacciSequence(max: Long) = fibonacciSequence().takeWhile { it < max }

fun primeSequence() = sequence {
    yieldAll(generateSequence(0L) { it + 1 }.filter { n -> n.isPrime() })
}

fun primeSequence(max: Int) = primeSequence().takeWhile { it < max }

fun primeSequence(min: Int, max: Int) = primeSequence().dropWhile { it < min }.takeWhile { it < max }

fun triangleSequence() = sequence {
    yieldAll(generateSequence(1L) { it + 1 }.map { n -> (n * n + n) / 2 })
}

fun triangleSequence(max: Int) = triangleSequence().takeWhile { it < max }

fun collatzSequence(n: Long): Sequence<Long> = sequence {
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

fun pentagonalSequence() = sequence {
    yieldAll(generateSequence(1L) { it + 1L }.map { x -> x * (3L * x - 1L) / 2L })
}

fun pentagonalSequence(maxValue: Long) = pentagonalSequence().takeWhile { it <= maxValue }

fun pentagonalSequence(maxSize: Int) = pentagonalSequence().take(maxSize)

fun hexagonalSequence() = sequence {
    yieldAll(generateSequence(1L) { it + 1L }.map { x -> x * (2L * x - 1L) })
}

fun hexagonalSequence(maxValue: Long) = hexagonalSequence().takeWhile { it <= maxValue }

fun hexagonalSequence(maxSize: Int) = hexagonalSequence().take(maxSize)

/**
 * Mimics [Python itertools module function](https://docs.python.org/3/library/itertools.html#itertools.permutations)
 * and returns successive [len]-length permutations of
 * [input].
 *
 * If [input] is sorted, permutations will be yielded in lexicographic order.
 *
 * If [input] contains only unique values, there will be no repeat values in each permutation. e.g.:
 *
 *     elements = "ABCD", len = 2 -> AB AC AD BA BC BD CA CB CD DA DB DC
 *
 * The number of yielded permutations, if `n` = the amount of elements, is:
 *
 *     n!/(n - len)!
 */
fun <T : Any> permutations(input: Iterable<T>, len: Int = -1) = sequence {
    val pool = input.toList()
    val n = pool.size
    val k = if (len == -1) n else len
    if (k == 0 || k > n) {
        return@sequence
    }
    var indices = (0 until n).toMutableList()
    val cycles = (n downTo n - k + 1).toMutableList()
    yield(List(k) { pool[indices[it]] })
    while (true) {
        var i = k - 1
        while (i >= 0) {
            if (--cycles[i] == 0) {
                indices = (indices.take(i) + indices.slice(i + 1..indices.lastIndex) + indices[i]).toMutableList()
                cycles[i] = n - i
                if (i-- == 0) return@sequence
            } else {
                val j = cycles[i]
                indices[n - j] = indices[i].also { indices[i] = indices[n - j] }
                yield(List(k) { pool[indices[it]] })
                break
            }
        }
    }
}
