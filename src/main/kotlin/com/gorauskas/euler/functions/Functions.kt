package com.gorauskas.euler.functions

/**
 * Executes the given [fn] and displays elapsed time in milliseconds.
 */
inline fun <T> timer(display: Boolean? = true, fn: () -> T): T {
    val start = System.currentTimeMillis()
    val result: T = fn.invoke()
    val end = System.currentTimeMillis()
    if (display == true) println("Executed in ${end - start} milliseconds")
    return result
}

inline fun Boolean?.ifTrue(fn: Boolean.() -> Unit): Boolean? {
    if (this == true) {
        fn()
    }
    return this
}

inline fun Boolean?.ifFalse(fn: Boolean?.() -> Unit): Boolean? {
    if (null == this || !this) {
        fn()
    }
    return this
}

@Suppress("MagicNumber")
fun resolvePackage(problem: Int): String? = when (problem) {
    in 1..9 -> "one."
    in 10..19 -> "ten."
    in 20..29 -> "twenty."
    in 30..39 -> "thirty."
    in 40..49 -> "forty."
    else -> null
}
