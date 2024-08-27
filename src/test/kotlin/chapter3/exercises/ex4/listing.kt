package chapter3.exercises.ex4

import chapter3.Cons
import chapter3.List
import chapter3.Nil
import chapter3.exercises.ex3.drop
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.WordSpec


// List 맨앞에서부터 주어진 술어를 만족하는 연속적인 원소를 삭제 (만족하는 접두사를 List에서 제거)
fun <A> dropWhile(l: List<A>, f: (A) -> Boolean): List<A> =
    when {
        l is Cons -> if(f(l.head)) dropWhile(l.tail, f) else l
        else -> l
    }

class Exercise4 : WordSpec({

    "list dropWhile" should {
        "drop elements until predicate is no longer satisfied" {
            dropWhile(List.of(1, 2, 3, 4, 5)) { it < 4 } shouldBe List.of(4, 5)
        }

        "drop no elements if predicate never satisfied" {
            dropWhile(
                List.of(1, 2, 3, 4, 5)
            ) { it == 100 } shouldBe List.of(1, 2, 3, 4, 5)
        }

        "drop all elements if predicate always satisfied" {
            dropWhile(
                List.of(1, 2, 3, 4, 5)
            ) { it < 100 } shouldBe List.of()
        }

        "return Nil if input is empty" {
            dropWhile(List.empty<Int>()) { it < 100 } shouldBe Nil
        }
    }
})
