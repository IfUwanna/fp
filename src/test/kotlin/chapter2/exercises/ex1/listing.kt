package chapter2.exercises.ex1

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.WordSpec

//TODO: Enable tests by removing `!` prefix
class Exercise1 : WordSpec({
    //tag::init[]
    fun fib(i: Int): Int =

        TODO()
    //end::init[]

    "fib" should {
        "!return the nth fibonacci number" {
            mapOf(
                1 to 1,
                2 to 1,
                3 to 2,
                4 to 3,
                5 to 5,
                6 to 8,
                7 to 13,
                8 to 21
            ).forEach { (n, num) ->
                fib(n) shouldBe num
            }
        }
    }
})
