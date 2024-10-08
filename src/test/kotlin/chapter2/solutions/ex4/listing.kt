package chapter2.solutions.ex4

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.WordSpec

class Solution4 : WordSpec({
    // tag::init[]
    fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C =
        { a: A, b: B -> f(a)(b) }
    // end::init[]

    "uncurry" should {
        """take a function accepting two values and then apply that
            function to the components of the pair which is the
            second argument""" {

                val f: (Int, Int) -> String =
                    uncurry { a -> { b -> "$a:$b" } }
                f(1, 2) shouldBe "1:2"
                f(1, 3) shouldBe "1:3"
            }
    }
})
