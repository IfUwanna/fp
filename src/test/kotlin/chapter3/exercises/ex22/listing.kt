package chapter3.exercises.ex22

import chapter3.List
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.WordSpec


// tag::init[]
fun <A> zipWith(xa: List<A>, xb: List<A>, f: (A, A) -> A): List<A> =

    TODO()
// end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise22 : WordSpec({
    "list zipWith" should {
        "!apply a function to elements of two corresponding lists" {
            zipWith(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
            ) { x, y -> x + y } shouldBe List.of(5, 7, 9)
        }
    }
})
