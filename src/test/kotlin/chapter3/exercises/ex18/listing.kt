package chapter3.exercises.ex18

import chapter3.List
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.WordSpec


// tag::init[]
fun <A> filter(xs: List<A>, f: (A) -> Boolean): List<A> =

    TODO()
// end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise18 : WordSpec({
    "list filter" should {
        "!filter out elements not compliant to predicate" {
            val xs = List.of(1, 2, 3, 4, 5)
            filter(xs) { it % 2 == 0 } shouldBe List.of(2, 4)
        }
    }
})
