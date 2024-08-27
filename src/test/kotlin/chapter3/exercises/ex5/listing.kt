package chapter3.exercises.ex5

import chapter3.Cons
import chapter3.List
import chapter3.Nil
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

// 3.5 마지막 원소 제외하는 새 List
fun <A> init(l: List<A>): List<A> = when (l) {
    is Cons -> if (l.tail == Nil) Nil else Cons(l.head, init(l.tail))
    is Nil -> throw IllegalStateException("throw an exception if no elements exist")
}

class Exercise5 : WordSpec({

    "list init" should {
        "return all but the last element" {
            init(List.of(1, 2, 3, 4, 5)) shouldBe
                    List.of(1, 2, 3, 4)
        }

        "return Nil if only one element exists" {
            init(List.of(1)) shouldBe Nil
        }

        "throw an exception if no elements exist" {
            shouldThrow<IllegalStateException> {
                init(List.empty<Int>())
            }
        }
    }
})
