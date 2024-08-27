package chapter3.exercises.ex13

import chapter3.List
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.WordSpec


// tag::init[]
fun <A> append(a1: List<A>, a2: List<A>): List<A> =

    TODO()
// end::init[]

fun <A> appendL(a1: List<A>, a2: List<A>): List<A> = TODO()

//TODO: Enable tests by removing `!` prefix
class Exercise13 : WordSpec({
    "!list append" should {
        "append two lists to each other using foldRight" {
            append(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)
        }
    }

    "!list appendL" should {
        "append two lists to each other using foldLeft" {
            appendL(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
            ) shouldBe List.of(1, 2, 3, 4, 5, 6)
        }
    }
})
