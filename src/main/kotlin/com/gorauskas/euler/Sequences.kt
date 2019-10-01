package com.gorauskas.euler.sequences

import com.gorauskas.euler.extensions.isPrime

fun fibonacciSequence(): Sequence<Long> {

    return generateSequence(Pair(0, 1), {
        Pair(it.second, it.first + it.second)
    }).map {
        it.first.toLong()
    }

}

fun primeSequence(): Sequence<Long> {

    var i = 0L

    return generateSequence { i++ }
            .filter { n -> n.isPrime() }

}

fun primeSequence(max: Int): Sequence<Long> {
    return primeSequence().takeWhile { it < max }
}