package chapter3.exercises.ex27

import chapter3.Branch
import chapter3.Leaf
import chapter3.Tree
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.WordSpec


// tag::init[]
fun <A, B> map(tree: Tree<A>, f: (A) -> B): Tree<B> =

    TODO()
// end::init[]

//TODO: Enable tests by removing `!` prefix
class Exercise27 : WordSpec({
    "!tree map" should {
        "transform all leaves of a map" {
            val actual = Branch(
                Branch(Leaf(1), Leaf(2)),
                Branch(Leaf(3), Leaf(4))
            )
            val expected = Branch(
                Branch(Leaf(10), Leaf(20)),
                Branch(Leaf(30), Leaf(40))
            )
            map(actual) { it * 10 } shouldBe expected
        }
    }
})
