package arrowKt.sandbox.io01

import arrow.fx.IO
import arrow.fx.IO.Companion.raiseError
import arrow.fx.extensions.fx

fun task01(): IO<String> = IO{ "01" }
fun task02(): IO<String> = IO{ "02" }
fun task03(): IO<String> = IO{ "03" }
fun task04(): IO<String> = raiseError(Throwable("oops"))
fun task05(): IO<String> = IO{ "05" }

fun main() {
    val task = IO.fx {
        val one = task01().bind()
        println(one)
        val two = task02().bind()
        println(two)
        val three = task03().bind()
        println(three)
        val four = task04().bind()
        println(four)
        val five = task05().bind()
        println(five)
    }
    task.redeem({ e -> println("failed: $e") }, { _ -> println("success!!") }).unsafeRunSync()
}