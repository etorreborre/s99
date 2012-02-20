package s99

import org.specs2._
import execute._
import matcher._

trait LogicAndCodesProblems extends Specification with DataTables with ThrownExpectations with LogicAndCodesSolutions {
  // this specs2 implicit method is deactivated to allow the local definition of Boolean operators
  override def toResult(b: Boolean): Result = super.toResult(b)

  def P46 = {
    val T = true; val F = false
    
    "a" | "b" | "and(a, b)" |>
     T  ! T   ! T           |
     T  ! F   ! F           |
     F  ! T   ! F           |
     F  ! F   ! F           | { and(_, _) === _ }

    "a" | "b" | "or(a, b)"  |>
     T  ! T   ! T           |
     T  ! F   ! T           |
     F  ! T   ! T           |
     F  ! F   ! F           | { or(_, _) === _ }

    "a" | "b" | "nand(a, b)" |>
     T  ! T   ! F            |
     T  ! F   ! T            |
     F  ! T   ! T            |
     F  ! F   ! T            | { nand(_, _) === _ }

    "a" | "b" | "nor(a, b)" |>
     T  ! T   ! F           |
     T  ! F   ! F           |
     F  ! T   ! F           |
     F  ! F   ! T           | { nor(_, _) === _ }

    "a" | "b" | "xor(a, b)" |>
     T  ! T   ! F           |
     T  ! F   ! T           |
     F  ! T   ! T           |
     F  ! F   ! F           | { xor(_, _) === _ }

    "a" | "b" | "impl(a, b)" |>
     T  ! T   ! T            |
     T  ! F   ! F            |
     F  ! T   ! T            |
     F  ! F   ! F            | { impl(_, _) === _ }

    "a" | "b" | "equ(a, b)" |>
     T  ! T   ! T           |
     T  ! F   ! F           |
     F  ! T   ! F           |
     F  ! F   ! T           | { equ(_, _) === _ }

    table2((a: Boolean, b: Boolean) => and(a, or(a, b))) ===
      """
      |A     B     result
      |true  true  true
      |true  false true
      |false true  false
      |false false false""".stripMargin('|')

  }

  def P47 = {
    table2((a: Boolean, b: Boolean) => a and (a or not(b))) ===
      """
      |A     B     result
      |true  true  true
      |true  false true
      |false true  false
      |false false false""".stripMargin('|')
  }

  def P48 = pending
  def P49 = gray(3) === List("000", "001", "011", "010", "110", "111", "101", "100")
  def P50 = huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))) ===
            List(("a", 0), ("b", 101), ("c", 100), ("d", 111), ("e", 1101), ("f", 1100))
}
