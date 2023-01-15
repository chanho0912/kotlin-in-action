package com.example.kotlininaction

import com.example.kotlininaction.strings.firstChar
import java.lang.IllegalArgumentException

val set = hashSetOf(1, 7, 33)

val list = arrayListOf(1, 6, 53)

val map = hashMapOf(
    1 to "one",
    7 to "seven",
    53 to "fifty-three"
)

fun <T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String,
): String {

    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

/**
 * you can often avoid creating overloads
 * because you can specify default values for parameters in a function declaration
 *
 * Java에서 사용하려면
 * @JvmOverloads
 * 어노테이션을 활용해야 한다 -> 오버로딩된 메서드들을 생성하준다. (Java는 디폴트 파라미터라는 개념이 없기 떄문)
 */


/**
 * @file:JvmName("StringFunctions")
 * Java -> StringFunctions.someMethod()///
 *
 * 자바는 클래스가 반드시 존재해야 한다.
 * 따라서 코틀린에서 메서드만을 선언했을 경우, 생성되는 자바 클래스 이름을 명시할 수 있다.
 * 해당 클래스의 static 메서드로 변환된다.
 */

/**
 * String -> receiver type
 * this -> receiver object
 */
fun String.lastChar(): Char = this[this.lastIndex]

/**
 * Note that extension functions don’t allow you to break encapsulation.
 */

class Person(
    private val name: String,
    private val age: Int,
)

// fun Person.printName() = println(this.name) => compile error

/**
 * Java에서 Util class를 만들어 넣었던 관행이 kotlin에서는 필요없다.
 */
fun <T> Collection<T>.joinToStringCollectionExtension(
    separator: String,
    prefix: String,
    postfix: String,
): String {

    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    // commit
    return result.toString()
}

fun <T> Collection<T>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
) = joinToStringCollectionExtension(separator, prefix, postfix)

/**
 * The vararg keyword, which allows you to declare a function taking an arbitrary number of arguments
 * An infix notation that lets you call some one-argument functions without ceremony
 * Destructuring declarations that allow you to unpack a single composite value into multiple variables
 *
 * fun listOf<T>(vararg values: T): List<T> { ... }
 */

/**
 * kotlin에서 varargs를 통해 선언된 함수에 인자를 전달하려면 명시적으로 unpack해야 한다.
 */

fun varargsExample(
    vararg elements: String
) {
    elements.forEach { println(it) }
}

class User(
    val id: Int,
    val name: String,
    val address: String,
)


fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("")
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException("")
    }

    println("save user to database: ${user.name}")
}

// -> using extension function

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("$fieldName is empty")
        }
    }

    validate(this.name, "name")
    validate(this.address, "address")
}

fun getSum(vararg numbers: Int): Int {
    var sum = 0
    for (number in numbers) {
        sum += number
    }

    return sum
}

infix fun Int.greaterInt(other: Int): Int = if (this > other) this else other

fun main(args: Array<String>) {
    val array = intArrayOf(1, 2, 3, 4, 5)
    /* kotlin에서는 vararg 파라미터를 전달하기 위해 spread operator를 사용해야 한다. */
    println(getSum(*array))

    val x = 6
    val y = 3
    val greaterValue = x greaterInt y

    println(greaterValue)

    val map = mapOf(1 to "one", 2 to "two", 3 to "three")

    val extensionTest: String = "extension"
    val extensionTest2: String = ""

    println(extensionTest.firstChar())
    println(extensionTest2.firstChar() ?: "null returns")

    val list = listOf(1, 2, 3)
    println(
        joinToString(
            list,
            separator = ",",
            prefix = "(",
            postfix = ")")
    )

    val str = "testString"
    println(str.lastChar())

    list.joinToStringCollectionExtension(
        separator = ",",
        prefix = "(",
        postfix = ")"
    )

    val set = setOf(1, 2, 3)
    set.join()

    varargsExample("abc", "chan", "ho")

    /**
     * array여야 하네...
     */
    val testInput = arrayOf("abc", "chan", "ho")
    varargsExample(*testInput)

    val user = User(
        id = 1,
        name = "ccc",
        address = "ddd",
    )

    saveUser(user)

    // oh!
    user.validateBeforeSave()

    // 너무 nested 하게 function을 넣는것은 추천하지 않는다.
}

/**
 * Working with strings and regular expressions
 */