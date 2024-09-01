package chapter4.exercises.ex2

import chapter3.List
import chapter4.*
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe
import kotlin.math.pow


fun mean(xs: List<Double>): Option<Double> =
    if (xs.isEmpty()) None
    else Some(xs.sum() / xs.size())

// 4.2 flatMap을 사용해 분산(variance) 함수 구현 // 원소 (X-평균)제곱의 평균  (X-m).pow(2) / mean 함수 이용
fun variance(xs: List<Double>): Option<Double> =
    mean(xs) // 1. 리스트 평균 값 Option
        .flatMap { m ->  // 2. [1]이 Some 인 경우 처리 , m은 전체 평균값
            mean(          // 4. 해당 리스트의 평균값(분산)의 Option
                xs.map { x -> (x - m).pow(2) } // 3. 각 원소의 편차 제곱을 List<Double> 로 변환
            )
        }


class Exercise2 : WordSpec({

    "variance" should {
        "determine the variance of a list of numbers" {
            val ls =
                List.of(1.0, 1.1, 1.0, 3.0, 0.9, 0.4)
            variance(ls).getOrElse { 0.0 } shouldBe
                    (0.675).plusOrMinus(0.005)
        }
    }
})
