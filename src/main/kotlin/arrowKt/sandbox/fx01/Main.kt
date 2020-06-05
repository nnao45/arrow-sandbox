package arrowKt.sandbox.fx01

import arrow.typeclasses.*
import arrow.core.extensions.*
import arrow.*
import arrow.core.*
import arrow.typeclasses.*
import arrow.core.extensions.*
import arrow.core.extensions.fx
fun takeFoodFromRefrigerator(): Option<Lettuce> = None
fun getKnife(): Option<Knife> = None
fun prepare(tool: Knife, ingredient: Lettuce): Option<Salad> = Some(Salad)

object Lettuce
object Knife
object Salad

fun prepareLunchOption(): Option<Salad> =
    Option.fx {
        val lettuce = takeFoodFromRefrigerator().bind()
        val knife = getKnife().bind()
        val salad = prepare(knife, lettuce).bind()
        salad
    }

fun main() {
    println(prepareLunchOption())
}