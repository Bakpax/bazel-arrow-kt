package com.bakpax.bazel_arrow_kt

import arrow.core.Either
import arrow.core.flatMap

fun main(args: Array<String>) {
    val a = Either.Right(5)
    val b = a.flatMap { Either.Right(it + 1) }
    println(a)
    println(b)
}
