package com.example.kotlininaction

internal class TestInternal(
    val number: Int
) {
    fun info() {
        println("TestInternal ${number}")
    }
}

class TestNotInternal(
    val number: Int
) {
    fun info() {
        println("TestNotInternal ${number}")
    }
}

class InternalMethodTest(
    val number: Int
) {
    internal fun info() {
        println("TestMethodInternal ${number}")
    }
}