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

  def compress[T](list: List[T]): List[T] =
    list match {
      case Nil                      => Nil
      case a :: b :: rest if a == b => compress(a :: rest)
      case a :: rest                => a :: compress(rest)
    }

  def pack[T](list: List[T]): List[List[T]] =
    list match {
      case Nil       => Nil
      case a :: rest => (a :: rest.takeWhile(_ == a)) :: pack(rest.dropWhile(_ == a))
    }

  def encode[T](list: List[T]): List[(Int, T)] =
    pack(list).map(l => (l.size, l.head))

  def encodeModified[T](list: List[T]): List[Any] =
    pack(list).map(l => if (l.size == 1) l.head else (l.size, l.head))

  def decode[T](list: List[(Int, T)]): List[T] =
    list.flatMap { case (n, t) => List.fill(n)(t) }

  def encodeDirect[T](list: List[T]): List[(Int, T)] =
    list match {
      case Nil       => Nil
      case a :: rest => (list.takeWhile(_ == a).size, a) :: encodeDirect(rest.dropWhile(_ == a))
    }

  def duplicate[T](list: List[T]): List[T] =
    list match {
      case Nil       => Nil
      case a :: rest => a :: a :: duplicate(rest)
    }

  def duplicateN[T](n: Int, list: List[T]): List[T] =
    list match {
      case Nil       => Nil
      case a :: rest => List.fill(n)(a) ::: duplicateN(n, rest)
    }

  def drop[T](n: Int, list: List[T]): List[T] = 
    if (list.size <= n) list
    else {
      val (start, end) = (list.take(n - 1), list.drop(n))
      start ::: drop(n, end)
    }

  def split[T](n: Int, list: List[T]): (List[T], List[T]) = ???
  def slice[T](i: Int, j: Int, list: List[T]): List[T] = ???

  def rotate[T](n: Int, list: List[T]): List[T] =
    if (n < 0) reverse(rotate(-n, reverse(list)))
    else if (n == 0) list
    else list match {
      case Nil       => Nil
      case a :: rest => rotate(n - 1, rest :+ a)
    }

  def removeAt[T](i: Int, list: List[T]): (List[T], T) =
    if (i < 0) sys.error("i must not be negative "+i)
    else if (i >= list.size) sys.error("i must not be > list.size "+i+" list size is "+list.size)
    else list match {
      case Nil                 => sys.error("the list is empty")
      case a :: rest if i == 0 => (rest, a)
      case a :: rest           => val (remaining, removed) = removeAt(i - 1, rest); (a :: remaining, removed)
    }

  def insertAt[T](t: T, i: Int, list: List[T]): List[T] =
    if (i < 0) sys.error("i must not be negative "+i)
    else if (i >= list.size) sys.error("i must not be > list.size "+i+" list size is "+list.size)
    else list match {
      case Nil                 => t :: Nil
      case a :: rest if i == 0 => t :: a :: rest
      case a :: rest           => a :: insertAt(t, i - 1, rest)
    }

  def range[T](i: Int, j: Int): List[Int] =
    if (i > j) sys.error("i can not be > j "+ (i, j))
    else if (i == j) List(i)
    else List(i) ::: range(i + 1, j)

  def randomSelect[T](n: Int, list: List[T]): List[T] = ???
  def lotto[T](i: Int, j: Int): List[Int] = ???
  def randomPermute[T](list: List[T]): List[T] = ???
  def combinations[T](n: Int, list: List[T]): List[List[T]] = ???
  def group3[T](list: List[T]): List[List[List[T]]] = ???
  def group[T](ns: List[Int], list: List[T]): List[List[List[T]]] = ???
  def lsort[T](list: List[List[T]]): List[List[T]] = ???
  def lsortFreq[T](list: List[List[T]]): List[List[T]] = ???

}

