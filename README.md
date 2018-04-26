Bazel + Arrow Failure Case
==========================

This repo is a small test case that demonstrates `kt_jvm_import` failing to work with the
[Arrow](http://arrow-kt.io/) error handling library.

It specifically demonstrates using [`Either`](http://arrow-kt.io/docs/datatypes/either/).

Running
-------

There are two projects, `MainWorks` and `MainFails`.  Each use Arrow in a trivial way.

```console
$ bazel run //:MainWorks
...
Left(a=left)
Right(b=5)
Converting one to two
two
```

```console
$ bazel run //:MainFails
...
ERROR: /.../bazel-arrow-kt/BUILD:38:1: Compiling 1 Kotlin source files to MainFails.jar failed (Exit 1)
MainFails.kt:7:15: error: unresolved reference. None of the following candidates is applicable because of receiver type mismatch:
public inline fun <T, R> Array<out ???>.flatMap(transform: (???) -> Iterable<???>): List<???> defined in kotlin.collections
public inline fun <R> BooleanArray.flatMap(transform: (Boolean) -> Iterable<???>): List<???> defined in kotlin.collections
public inline fun <R> ByteArray.flatMap(transform: (Byte) -> Iterable<???>): List<???> defined in kotlin.collections
public inline fun <R> CharArray.flatMap(transform: (Char) -> Iterable<???>): List<???> defined in kotlin.collections
public inline fun <R> CharSequence.flatMap(transform: (Char) -> Iterable<???>): List<???> defined in kotlin.text
public inline fun <R> DoubleArray.flatMap(transform: (Double) -> Iterable<???>): List<???> defined in kotlin.collections
public inline fun <R> FloatArray.flatMap(transform: (Float) -> Iterable<???>): List<???> defined in kotlin.collections
public inline fun <R> IntArray.flatMap(transform: (Int) -> Iterable<???>): List<???> defined in kotlin.collections
public inline fun <R> LongArray.flatMap(transform: (Long) -> Iterable<???>): List<???> defined in kotlin.collections
public inline fun <R> ShortArray.flatMap(transform: (Short) -> Iterable<???>): List<???> defined in kotlin.collections
public inline fun <T, R> Iterable<???>.flatMap(transform: (???) -> Iterable<???>): List<???> defined in kotlin.collections
public inline fun <K, V, R> Map<out ???, ???>.flatMap(transform: (Map.Entry<???, ???>) -> Iterable<???>): List<???> defined in kotlin.collections
public fun <T, R> Sequence<???>.flatMap(transform: (???) -> Sequence<???>): Sequence<???> defined in kotlin.sequences
    val b = a.flatMap { Either.Right(it + 1) }
              ^
MainFails.kt:7:38: error: unresolved reference: it
    val b = a.flatMap { Either.Right(it + 1) }
...
```

MainWorks
---------

```Kotlin
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
```

This code uses `Either.Left`, `Either.Right`, and `Either.fold`, all which work and compile without
issue.

MainFails
---------

```Kotlin
val a = Either.Right(5)
val b = a.flatMap { Either.Right(it + 1) }
println(a)
println(b)
```

This code uses `Either.flatMap`, which is defined [here](https://github.com/arrow-kt/arrow/blob/0.7.1/modules/core/arrow-core/src/main/kotlin/arrow/core/Either.kt#L225),
and documented [here](http://arrow-kt.io/docs/datatypes/either/#either-vs-validated).

The compiler fails to find the method.
