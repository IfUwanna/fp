package chapter3.exercises.ex5

import chapter3.List
import chapter3.Nil
import io.kotest.matchers.shouldBe
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.WordSpec


// tag::init[]
fun <A> init(l: List<A>): List<A> =

    TODO()
// end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise5 : WordSpec({

    "list init" should {
        "!return all but the last element" {
            init(List.of(1, 2, 3, 4, 5)) shouldBe
                List.of(1, 2, 3, 4)
        }

        "!return Nil if only one element exists" {
            init(List.of(1)) shouldBe Nil
        }

        "!throw an exception if no elements exist" {
            shouldThrow<IllegalStateException> {
                init(List.empty<Int>())
            }
        }
    }
})
