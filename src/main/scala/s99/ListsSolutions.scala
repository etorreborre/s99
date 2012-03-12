package s99

import Solutions._

trait ListsSolutions {

  def last[T](list: List[T]): T = list match {
    case Nil       => sys.error("empty list")
    case a :: Nil  => a
    case a :: rest => last(rest)
  }

  def penultimate[T](list: List[T]): T = list match {
    case Nil            => sys.error("empty list")
    case a :: Nil       => sys.error("list with one element only")
    case a :: b :: Nil  => a
    case a :: rest      => penultimate(rest)
  }

  def nth[T](n: Int, list: List[T]): T =
    if (list.size == n + 1) last(list)
    else nth(n, list.dropRight(1))

  def length[T](list: List[T]): Int =
    list match {
      case Nil       => 0
      case a :: rest => 1 + length(rest)
    }

  def reverse[T](list: List[T]): List[T] = list match {
    case Nil       => list
    case a :: Nil  => list
    case a :: rest => reverse(rest) :+ a
  }

  def isPalindrome[T](list: List[T]): Boolean = list == reverse(list)

  def flatten(list: List[Any]): List[Any] =
    list match {
      case Nil                  => list
      case (a :: rest) :: other => a :: flatten(rest) ::: flatten(other)
      case a :: rest            => a :: flatten(rest)
    }

  def compress[T](list: List[T]): T = ???
  def pack[T](list: List[T]): T = ???
  def encode[T](list: List[T]): List[(Int, T)] = ???
  def encodeModified[T](list: List[T]): List[(Int, T)] = ???
  def decode[T](list: List[(Int, T)]): List[T] = ???
  def encodeDirect[T](list: List[T]): List[(Int, T)] = ???
  def duplicate[T](list: List[T]): List[T] = ???
  def duplicateN[T](n: Int, list: List[T]): List[T] = ???
  def drop[T](n: Int, list: List[T]): List[T] = ???
  def split[T](n: Int, list: List[T]): (List[T], List[T]) = ???
  def slice[T](i: Int, j: Int, list: List[T]): List[T] = ???
  def rotate[T](n: Int, list: List[T]): List[T] = ???
  def removeAt[T](i: Int, list: List[T]): List[T] = ???
  def insertAt[T](t: T, i: Int, list: List[T]): List[T] = ???
  def range[T](i: Int, j: Int): List[Int] = ???
  def randomSelect[T](n: Int, list: List[T]): List[T] = ???
  def lotto[T](i: Int, j: Int): List[Int] = ???
  def randomPermute[T](list: List[T]): List[T] = ???
  def combinations[T](n: Int, list: List[T]): List[List[T]] = ???
  def group3[T](list: List[T]): List[List[List[T]]] = ???
  def group[T](ns: List[Int], list: List[T]): List[List[List[T]]] = ???
  def lsort[T](list: List[List[T]]): List[List[T]] = ???
  def lsortFreq[T](list: List[List[T]]): List[List[T]] = ???

}

