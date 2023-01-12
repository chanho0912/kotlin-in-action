package com.example.kotlininaction

data class Person(
    val name: String,
    val age: Int? = null // null by default
)

fun main(args: Array<String>) {
    val persons = listOf(
        Person("Alice"),
        Person("Bob", age = 29)
    )

    val oldest = persons.maxByOrNull { it.age ?: 0 } // use it as the default name of that parameter
    println("The oldest is: $oldest")
}

/**
 * Just like Java, Kotlin is a statically typed programming language.
 * This means the type of every expression in a program is known at compile time
 */

/**
 * benefits of static typing
 *
 * Performance:
 * Calling methods is faster because there’s no need to figure out at runtime which method needs to be called.
 *
 * Reliability:
 * The compiler verifies the correctness of the program, so there are fewer chances for crashes at runtime.
 *
 * Maintainability:
 * Working with unfamiliar code is easier because you can see what kind of objects the code is working with.
 *
 * Tool support:
 * Static typing enables reliable refactorings, precise code completion, and other IDE features
 */

/**
 * functional concepts
 *
 * First-class functions:
 * You work with functions (pieces of behavior) as values.
 * You can store them in variables, pass them as parameters, or return them from other functions.
 *
 * Immutability:
 * You work with immutable objects, which guarantees that their state can’t change after their creation.
 *
 * No side effects:
 * You use pure functions that return the same result given the same inputs and
 * don’t modify the state of other objects or interact with the outside world.
 */


// fun findAlice() = findPerson { it.name == "Alice" }
// fun findBob() = findPerson { it.name == "Bob" }

/**
 * The philosophy of Kotlin
 *
 * Pragmatic
 * Kotlin is a practical language designed to solve real-world problems.
 *
 * Kotlin also is not a research language.
 * We aren’t trying to advance the state of the art in programming language design and
 * explore innovative ideas in computer science.
 *
 * Concise
 * The simpler and more concise the code is, the faster you’ll understand what’s going on
 *
 * Safe
 * when we speak of a programming language as safe, we mean its design prevents certain kinds of errors in a program.
 *
 * ClassCastException
 * the check and the cast are combined into a single operation:
 * once you’ve checked the type, you can refer to members of that type without any additional casts.
 */

