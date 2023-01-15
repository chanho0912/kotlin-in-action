package com.example.kotlininaction

import java.io.BufferedReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

fun max(a: Int, b: Int): Int {
    /**
     * if is an expression with a result value
     * block body example
     */
    return if (a > b) a else b
}

fun simplifyMax(a: Int, b: Int): Int = if (a > b) a else b

/**
 * expression body 인경우 return type 생략 가능 (type inference)
 * for expression-body functions,
 * the compiler can analyze the expression used as the body of the function and use its type as the function return type,
 * even when it’s not spelled out explicitly
 */
fun maxWithExpressionBody(a: Int, b: Int) = if (a > b) a else b

class Person(
    private val name: String,
    var age: Int,
    var isMarried: Boolean
) {
    /**
     * custom getter
     */
    val fullName: String
        get() = "Kim $name"

}

class TestGetterAndSetter(
    val field_1: String,
    var field_2: String
)

enum class Color(
    var r: Int,
    var g: Int,
    val b: Int,
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color): String {
    return when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }
}

/**
 * Unlike switch, which requires you to use constants (enum constants, strings, or number literals) as branch conditions,
 * when allows any object
 */

fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) {
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
    setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
    else -> throw Exception("Dirty Color")
}


fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr
/**
 * In Kotlin, you check whether a variable is of a certain type by using an "is" check.
 */

fun evaluate(e: Expr): Int {
    if (e is Num) {
        // smart cast using is keyword
        return e.value
    }

    if (e is Sum) {
        // smart cast using is keyword
        return evaluate(e.left) + evaluate(e.right)
    }

    throw IllegalArgumentException()
}

/**
 * In Kotlin, there is no ternary operator
 */

fun eval(e: Expr): Int = when (e) {
    is Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
    else -> throw IllegalArgumentException("Cannot parse Expr")
}

/**
 * The rule “the last expression in a block is the result” holds in all cases
 * where a block can be used and a result is expected.
 */

/**
 * Kotlin doesn’t differentiate between checked and unchecked exceptions
 */

fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    }

    println(number)
}

fun main(args: Array<String>) {
    println("Hello, world!!")
    println(max(2, 5))
    println("simplify max ${simplifyMax(2, 8)}")

    val name = if (args.size > 0) args[0] else "kotlin"
    println("name is ${name}")

    val person = Person(name = "aaa", age = 15, true)

    val testGetterAndSetter = TestGetterAndSetter("field1", "field2")
//    testGetterAndSetter.field_1 = "a" -> error
    testGetterAndSetter.field_2 = "bcde" // -> ok
    println("testGetterAndSetter1 = ${testGetterAndSetter.field_1}")
    println("testGetterAndSetter2 = ${testGetterAndSetter.field_2}")

//
//    println(person.name)
//    person.name = "asd"

    println(person.age)
    person.age = 5

    println(person.isMarried)
    println((person.fullName))
    println(Color.BLUE.rgb())
    println(getMnemonic(Color.RED))
    println(getWarmth(Color.BLUE))
    println(mix(Color.BLUE, Color.YELLOW))
    println(eval(Sum(Num(1), Num(2))))

    val oneToTen = 1..10
}

/**
 * even though a val reference is itself immutable and can’t be changed, the
 * object that it points to may be mutable
 */