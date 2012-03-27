package s99

import org.specs2.mutable.Specification
import org.specs2.matcher.DataTables
import org.specs2.execute.Result


class LogicAndCodesSpec extends Specification with LogicAndCodesSolutions with DataTables {
  """ Truth tables for logical expressions

  Define functions and, or, nand, nor, xor, impl, and equ for logical equivalence) which return true or false
  according to the result of their respective operations; e.g. and(A, B) is true if and only if both A and B are true

  scala> and(true, true)
  res0: Boolean = true

  scala> xor(true. true)
  res1: Boolean = false
  A logical expression in two variables can then be written as an function of two variables, e.g:
  (a: Boolean, b: Boolean) => and(or(a, b), nand(a, b))

  Now, write a function called table2 which prints the truth table of a given logical expression in two variables.

  scala> table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
  A     B     result
  true  true  true
  true  false true
  false true  false
  false false false""" >>
  { "a" | "b" | "and(a, b)" |>
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
     F  ! F   ! T            | { impl(_, _) === _ }

    "a" | "b" | "equ(a, b)" |>
     T  ! T   ! T           |
     T  ! F   ! F           |
     F  ! T   ! F           |
     F  ! F   ! T           | { equ(_, _) === _ }

    table2((a: Boolean, b: Boolean) => and(a, or(a, b))) ===
      Seq("A     B     result",
          "true  true  true  ",
          "true  false true  ",
          "false true  false ",
          "false false false ").mkString("\n") }

  """ Truth tables for logical expressions (2)

  Continue problem P46 by redefining and, or, etc as operators. (i.e. make them methods of a new class with an
  implicit conversion from Boolean.) not will have to be left as a object method.

  scala> table2((a: Boolean, b: Boolean) => a and (a or not(b)))
  A     B     result
  true  true  true
  true  false true
  false true  false
  false false false
  """ >>
  { table2((a: Boolean, b: Boolean) => a and (a or not(b))) ===
    Seq("A     B     result",
        "true  true  true  ",
        "true  false true  ",
        "false true  false ",
        "false false false ").mkString("\n") }

  """ Truth tables for logical expressions (3). Omitted for now""" >>
  { pending }

  """ Gray code

  An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,

  n = 1: C(1) = ("0", "1").
  n = 2: C(2) = ("00", "01", "11", "10").
  n = 3: C(3) = ("000", "001", "011", "010", "110", "111", "101", "100").

  Find out the construction rules and write a function to generate Gray codes.

    scala> gray(3)
    res0 List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)

    See if you can use memoization to make the function more efficient""" >>
  { gray(3) === List("000", "001", "011", "010", "110", "111", "101", "100") }

  """ Huffman code

  First of all, consult a good book on discrete mathematics or algorithms for a detailed description of Huffman
  codes! We suppose a set of symbols with their frequencies, given as a list of (S, F) Tuples.
  E.g. (("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)). Our objective is to construct a
  list of (S, C) Tuples, where C is the Huffman code word for the symbol S""" >>
  { huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))) ===
         List(("a", 0), ("b", 101), ("c", 100), ("d", 111), ("e", 1101), ("f", 1100)) }

  val T = true; val F = false
  // this specs2 implicit method is deactivated to allow the local definition of Boolean operators
  override def toResult(b: Boolean): Result = super.toResult(b)
}

