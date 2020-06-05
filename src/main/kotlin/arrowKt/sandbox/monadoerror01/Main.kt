package arrowKt.sandbox.monadoerror01

import arrow.Kind
import arrow.core.Either
import arrow.core.Left
import arrow.core.Right
import arrow.core.extensions.either.monadError.*
import arrow.core.extensions.fx
import arrow.typeclasses.MonadError

sealed class CookingException {
    object LettuceIsRotten: CookingException()
    object KnifeNeedsSharpening: CookingException()
    data class InsufficientAmount(val quantityInGrams : Int): CookingException()
}

object Lettuce
object Knife
object Salad
typealias NastyLettuce = CookingException.LettuceIsRotten
typealias KnifeIsDull = CookingException.KnifeNeedsSharpening
typealias InsufficientAmountOfLettuce = CookingException.InsufficientAmount
fun takeFoodFromRefrigerator(): Either<NastyLettuce, Lettuce> = Right(Lettuce)
fun getKnife(): Either<KnifeIsDull, Knife> = Right(Knife)
fun lunch(knife: Knife, food: Lettuce): Either<InsufficientAmountOfLettuce, Salad> = Left(InsufficientAmountOfLettuce(5))

fun <F> MonadError<F, CookingException>.takeFoodFromRefrigerator(): Kind<F, Lettuce> = just(Lettuce)
fun <F> MonadError<F, CookingException>.getKnife(): Kind<F, Knife> = just(Knife)
fun <F> MonadError<F, CookingException>.lunch(knife: Knife, food: Lettuce):
        Kind<F, Salad> = raiseError(InsufficientAmountOfLettuce(5))


fun main() {
    val cook = Either.fx<CookingException, Salad>  {
        val lettuce = takeFoodFromRefrigerator().bind()
        val knife = getKnife().bind()
        val salad = lunch(knife, lettuce).bind()
        salad
    }

    println(cook)
}