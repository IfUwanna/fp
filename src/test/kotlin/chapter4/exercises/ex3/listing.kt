package chapter4.exercises.ex3

import chapter4.None
import chapter4.Option
import chapter4.Some
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe


// 4.3 두 Option 값을 이항함수를 통해 조합하는 제네릭함수 map2 작성 - a,b중 하나라도 None이면 None
fun <A, B, C> map2(a: Option<A>, b: Option<B>, f: (A, B) -> C): Option<C> =
    a.flatMap { a -> // 3.  [2] 결과를 flatmap 으로 최종 Option<C>로 반환   >> flatMap을 사용했기에 Option<Option<C>> 아님
        b.map {     // 2. [1]의 결과를 Option 으로 반환 Some(f(a,b)) : Option<C>
            b -> f(a, b)  // 1. fun f(a: Option<A>, b:Option<B>): C
        }
    }

class Exercise3 : WordSpec({

    "map2" should {

        val a = Some(5)
        val b = Some(20)
        val none = Option.empty<Int>()

        "combine two option values using a binary function" {
            map2(a, b) { aa, bb -> aa * bb } shouldBe Some(100)
        }

        "return none if either option is not defined" {
            map2(a, none) { aa, bb -> aa * bb } shouldBe None
            map2(none, b) { aa, bb -> aa * bb } shouldBe None
        }
    }
})
