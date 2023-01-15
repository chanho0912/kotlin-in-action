package com.example.kotlininaction.strings

/*
fun String.firstChar(): Char? {
    val ret = try {
        this[0]
    } catch (e: StringIndexOutOfBoundsException) {
        null
    }

    return ret
}
*/

fun String.firstChar(): Char? = if (isNotEmpty()) this[0] else null