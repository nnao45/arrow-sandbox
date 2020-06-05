package arrowKt.sandbox.helloworld

import arrow.fx.*

fun main() {
    val task = IO { "Hello" }
        .flatMap { IO { it + "," } }
        .map { it + " World!!" }
    println(task.unsafeRunSync())
}