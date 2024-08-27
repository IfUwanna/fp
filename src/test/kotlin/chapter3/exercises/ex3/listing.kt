package chapter3.exercises.ex3

import chapter3.Cons
import chapter3.List
import chapter3.Nil
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

// 3.3 tail을 더 일반화 해서 Drop 함수 작성, 리스트 맨 앞부터 n개의 원소 제거
fun <A> drop(l: List<A>, n: Int): List<A> =
    when {
        n == 0 -> l
        l is Cons -> drop(l.tail, n - 1)
        else -> throw IllegalStateException("")
    }

class Exercise3 : WordSpec({
    "list drop" should {
        "drop a given number of elements within capacity" {
            drop(List.of(1, 2, 3, 4, 5), 3) shouldBe
                    List.of(4, 5)
        }

        "drop a given number of elements up to capacity" {
            drop(List.of(1, 2, 3, 4, 5), 5) shouldBe Nil
        }

        """throw an illegal state exception when dropped elements
            exceed capacity""" {
            shouldThrow<IllegalStateException> {
                drop(List.of(1, 2, 3, 4, 5), 6)
            }
        }
    }
})
