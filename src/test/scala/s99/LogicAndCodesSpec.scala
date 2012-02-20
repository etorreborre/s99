package s99


class LogicAndCodesSpec extends LogicAndCodesProblems {  def is =
  """
   Truth tables for logical expressions. Define functions and, or, nand, nor, xor, impl, and equ
   (for logical equivalence) which return true or false according to the result of their respective operations;
    e.g. and(A, B) is true if and only if both A and B are true

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
    false false false"""                                                                                                ! P46^
  """
    Truth tables for logical expressions (2).
    Continue problem P46 by redefining and, or, etc as operators. (i.e. make them methods of a new class with an
    implicit conversion from Boolean.) not will have to be left as a object method.

    scala> table2((a: Boolean, b: Boolean) => a and (a or not(b)))
    A     B     result
    true  true  true
    true  false true
    false true  false
    false false false"""                                                                                                ! P47^
  """
    Truth tables for logical expressions (3).
    Omitted for now"""                                                                                                  ! P48^
  """
    Gray code. An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,
    n = 1: C(1) = ("0", "1").
    n = 2: C(2) = ("00", "01", "11", "10").
    n = 3: C(3) = ("000", "001", "011", "010", "110", "111", "101", "100").

    Find out the construction rules and write a function to generate Gray codes.

    scala> gray(3)
    res0 List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)

    See if you can use memoization to make the function more efficient"""                                               ! P49^
  """
    Huffman code.
    First of all, consult a good book on discrete mathematics or algorithms for a detailed description of Huffman
    codes! We suppose a set of symbols with their frequencies, given as a list of (S, F) Tuples.
    E.g. (("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)). Our objective is to construct a
    list of (S, C) Tuples, where C is the Huffman code word for the symbol S"""                                         ! P50^
                                                                                                                        end
}

