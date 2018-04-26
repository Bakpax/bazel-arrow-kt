package com.bakpax.bazel_arrow_kt

import arrow.core.Either

fun main(args: Array<String>) {
    val a = Either.Left("left")
    val b = Either.Right(5)
    println(a)
    println(b)

    val c = Either.Left("one").fold({
        println("Converting $it to two")
        "two"
    }, {
        "not used"
    })
    println(c)
}
