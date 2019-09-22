package com.gorauskas.euler.sequences

fun fibonacciSequence(): Sequence<Long> {

    return generateSequence(Pair(0, 1), {
        Pair(it.second, it.first + it.second)
    }).map {
        it.first.toLong()
    }

}
