package com.example.kotlininaction

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!!")
}

open class RichButton : Clickable {
    /*
    final -> cannot override in subclass
     */
    final override fun click() {
        TODO("Not yet implemented")
    }

    fun disable() {}

    open fun animate() {}
}

abstract class Animated {
    /*
    must be override
     */
    abstract fun animate()
}

class Button : Clickable {
    override fun click() = println("I was clicked")
}

/**
 * Java -> fragile base class
 */

/*
internal -> visible in module
 */
fun main() {
    Button().click()
    Button().showOff()
}
