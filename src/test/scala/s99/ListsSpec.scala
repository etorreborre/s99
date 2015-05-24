package s99

import org.specs2.matcher.Matcher
import org.specs2.mutable._

class ListsSpec extends Specification with ListsSolutions {

  "P01 Find the last element of a list" >> {
    last(List(1, 1, 2, 3, 5, 8)) === 8
  }

  "P02 Find the last but one element of a list" >> {
    penultimate(List(1, 1, 2, 3, 5, 8)) === 5
  }

  "P03 Find the nth element of a list. By convention, the first element in the list is element 0" >> {
    nth(2, List(1, 1, 2, 3, 5, 8)) === 2
  }

  "P04 Find the number of elements of a list" >> {
    length(List(1, 1, 2, 3, 5, 8)) === 6
  }

  "P05 Reverse a list" >> {
    reverse(List(1, 1, 2, 3, 5, 8)) === List(8, 5, 3, 2, 1, 1)
  }

  "P06 Find out whether a list is a palindrome" >> {
    isPalindrome(List(1, 2, 3, 2, 1)) must beTrue
    isPalindrome(List(1, 3, 3, 2, 1)) must beFalse
    isPalindrome(Nil) must beTrue
    isPalindrome(List(1)) must beTrue
    isPalindrome(List(5, 5)) must beTrue
  }

  "P07 Flatten a nested list structure" >> {
    flatten(List(List(1, 1), 2, List(3, List(5, 8)))) === List(1, 1, 2, 3, 5, 8)
    flatten(Nil) === Nil
    flatten(List(List('a, List('b, List('c))))) === List('a, 'b, 'c)
  }

  """P08 Eliminate consecutive duplicates of list elements
  If a list contains repeated elements they
  should be replaced with a single copy of the element. The order of the elements should not be changed""" >> {
    compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === List('a, 'b, 'c, 'a, 'd, 'e)
    compress(Nil) === compress(Nil)
  }

  """P09 Pack consecutive duplicates of list elements into sublists
  If a list contains repeated elements they should be placed in separate sublists""" >> {
    pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
    pack(Nil) === Nil
    pack(List(1)) === List(List(1))
  }

  """P10 Run-length encoding of a list
  Use the result of problem P09 to implement the so-called run-length encoding data compression method.
  Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number
  of duplicates of the element E""" >> {
    encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))

    encode(Nil) === Nil
    encode(List(1)) === List((1, 1))
  }

  """P11 Modified run-length encoding
  Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the
  result list. Only elements with duplicates are transferred as (N, E) terms""" >> {
    encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e))

    encodeModified(List(1)) === List(1)
    encodeModified(Nil) === Nil
    encodeModified(List('a', 'b', 'b', 'c')) === List('a', (2, 'b'), 'c')
  }

  """P12 Decode a run-length encoded list
  Given a run-length code list generated as specified in problem P10, construct its uncompressed version""" >> {
    decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) ===
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

    decode(Nil) === Nil
    decode(List((1, 1), (2, 2), (3, 3))) === List(1, 2, 2, 3, 3, 3)
  }

  """P13 Run-length encoding of a list (direct solution)
  Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've
  written (like P09's pack); do all the work directly""" >> {
    encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))

    encodeDirect(Nil) === Nil
    encodeDirect(List(1)) === List((1, 1))
  }

  "P14 Duplicate the elements of a list" >> {
    duplicate(List('a, 'b, 'c, 'c, 'd)) === List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
    duplicate(Nil) === Nil
    duplicate(List(1)) === List(1, 1)
  }

  "P15 Duplicate the elements of a list a given number of times" >> {
    duplicateN(3, List('a, 'b, 'c, 'c, 'd)) === List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
    duplicateN(3, Nil) === Nil
    duplicateN(1, Nil) === Nil
    duplicateN(1, List(1, 2, 3)) === List(1, 2, 3)
    duplicateN(0, List(1, 2, 3)) === Nil
  }

  "P16 Drop every Nth element from a list" >> {
    drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
    drop(3, List(1, 2)) === List(1, 2)
    drop(1, List(4, 5, 6, 7)) === Nil
    drop(3, Nil) === Nil
  }

  "P17 Split a list into two parts. The length of the first part is given. Use a Tuple for your result" >> {
    split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ===(List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    split(1, List(1, 2, 3)) === (List(1), List(2, 3))
    split(0, List('a, 'b)) === (Nil, List('a, 'b))
    split(0, Nil) === (Nil, Nil)
  }

  """P18 Extract a slice from a list
  Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to
  but not including the Kth element of the original list. Start counting the elements with 0""" >> {
    slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('d, 'e, 'f, 'g)
    slice(0, 1, List(1, 2, 3, 4)) === List(1)
    slice(1, 1, List(1, 2, 3, 4)) === Nil
    slice(0, 3, List('a, 'b, 'c)) === List('a, 'b, 'c)
  }

  "P19 Rotate a list N places to the left" >> {
    rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
    rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
    rotate(0, List(2, 3, 4, 5)) === List(2, 3, 4, 5)
    rotate(4, List(2, 3, 4, 5)) === List(2, 3, 4, 5)
    rotate(-4, List(2, 3, 4, 5)) === List(2, 3, 4, 5)
    rotate(0, Nil) === Nil

    // depending on the interpretation of the problem, these examples may or may not be valid
    rotate(3, Nil) === Nil
    rotate(7, List(2, 3, 4, 5)) === List(5, 2, 3, 4)
    rotate(-7, List(2, 3, 4, 5)) === List(3, 4, 5, 2)
    rotate(10, List(0, 1)) === List(0, 1)
    rotate(11, List(0, 1)) === List(1, 0)
  }

  """P20 Remove the Kth element from a list
  Return the list and the removed element in a Tuple. Elements are numbered from 0""" >> {
    removeAt(1, List('a, 'b, 'c, 'd)) === (List('a, 'c, 'd), 'b)
    removeAt(0, List(1)) === (Nil, 1)
    removeAt(2, List(1, 2, 3)) === (List(1, 2), 3)
  }

  "P21 Insert an element at a given position into a list" >> {
    insertAt('new, 1, List('a, 'b, 'c, 'd)) === List('a, 'new, 'b, 'c, 'd)
    insertAt(1, 0, Nil) === List(1)
    insertAt(3, 2, List(1, 2)) === List(1, 2, 3)
  }

  "P22 Create a list containing all integers within a given range" >> {
    range(4, 9) === List(4, 5, 6, 7, 8, 9)
    range(0, 0) === List(0)
    range(2, 1) === Nil
  }

  "P23 Extract a given number of randomly selected elements from a list. Hint: Use the solution to problem P20" >> {
    randomSelect(0, List(1, 2, 3)) === Nil

    for(_ <- 1 to 100) {
      val selected = randomSelect(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h))
      selected.size === 3
      selected.distinct.size === selected.size
      List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h) must containAllOf(selected)
    }

    // with true randomness, this example has 10 * (1/10) ^ 100 = 1e-99 probability of
    // yielding a false negative. Comment this if you don't want even the small chance
    // of a test failing when the code is correct
    (1 to 100).map { _ => randomSelect(1, (1 to 10).toList).head }.toSet.size !== 1
  }

  "P24 Lotto: Draw N different random numbers from the set 1..M" >> {
    for(_ <- 1 to 100) {
      val selected = lotto(6, 49)
      selected.size === 6
      ((_: Int) must beBetween(1, 49)).forall(selected)
    }

    // with true randomness, this example has 10 * (1/10) ^ 100 = 1e-99 probability of
    // yielding a false negative. Comment this if you don't want even the small chance
    // of a test failing when the code is correct
    (1 to 100).map { _ => lotto(1, 10).head }.toSet.size !== 1
  }

  "P25 Generate a random permutation of the elements of a list. Hint: Use the solution of problem P23" >> {
    for(_ <- 1 to 100) {
      val permute = randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
      permute.size === 6
      permute.distinct.size === permute.size
      List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h) must containAllOf(permute)
    }

    // with true randomness, this example has 6 * (1/6) ^ 100 = 9.18e-78 probability of
    // yielding a false negative. Comment this if you don't want even the small chance
    // of a test failing when the code is correct
    (1 to 100).map { _ => randomPermute(List(1, 2, 3)) }.toSet.size !== 1
  }

  """P26 Generate the combinations of K distinct objects chosen from the N elements of a list
  In how many ways can a committee of 3 be chosen from a group of 12 people? We all know that there are
  C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficient). For pure mathematicians, this
  result may be great. But we want to really generate all the possibilities""" >> {
    combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)).map(_.toSet) must
      containElements(Set('a, 'b, 'c), Set('a, 'b, 'd), Set('a, 'b, 'e))

    combinations(0, List(1, 2, 3)) === List(Nil)
    combinations(1, List(1, 2, 3)).map(_.toSet).toSet === Set(Set(1), Set(2), Set(3))
    combinations(2, List(1, 2, 3)).map(_.toSet).toSet === Set(Set(1, 2), Set(1, 3), Set(2, 3))
    combinations(3, List(1, 2, 3)).map(_.toSet).toSet === Set(Set(1, 2, 3))
    combinations(4, List(1, 2, 3)) === Nil
  }

  """P27 Group the elements of a set into disjoint subsets
   a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons?
      Write a function that generates all the possibilities.
   b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate
      will return a list of groups.

   Note that we do not want permutations of the group members; i.e. ((Aldo, Beat), ...) is the same solution
   as ((Beat, Aldo), ...). However, we make a difference between ((Aldo, Beat), (Carla, David), ...) and
   ((Carla, David), (Aldo, Beat), ...).

  You may find more about this combinatorial problem in a good book on discrete mathematics under the term
  "multinomial coefficients" """ >> {
    group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")).map(_.map(_.toSet)) must
      contain(List(Set("Aldo", "Beat"), Set("Carla", "David", "Evi"), Set("Flip", "Gary", "Hugo", "Ida")))

    groups(List(1, 1), List("Aldo", "Beat")).toSet === Set(
      List(List("Aldo"), List("Beat")),
      List(List("Beat"), List("Aldo"))
    )

    groups(List(2, 3, 4), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")).map(_.map(_.toSet)) must
      contain(List(Set("Aldo", "Beat"), Set("Carla", "David", "Evi"), Set("Flip", "Gary", "Hugo", "Ida")))

    groups(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")).map(_.map(_.toSet)) must
      contain(List(Set("Aldo", "Beat"), Set("Carla", "David"), Set("Evi", "Flip", "Gary", "Hugo", "Ida")))

    groups(List(3), List(1, 2, 3)).map(_.map(_.toSet)) === List(List(Set(1, 2, 3)))
    groups(List(0), Nil) === List(List(Nil))
    groups(Nil, Nil) === List(Nil)
  }

  """P28 Sorting a list of lists according to length of sublists
    a) We suppose that a list contains elements that are lists themselves. The objective is to sort the elements
       of the list according to their length. E.g. short lists first, longer lists later, or vice versa.
    b) Again, we suppose that a list contains elements that are lists themselves. But this time the objective is
       to sort the elements according to their length frequency; i.e. in the default, sorting is done ascendingly,
       lists with rare lengths are placed, others with a more frequent length come later""" >> {
    val sorted = lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e),
      List('i, 'j, 'k, 'l), List('m, 'n), List('o)))

    sorted(0) === List('o)
    sorted.slice(1, 4).toSet === Set(List('d, 'e), List('d, 'e), List('m, 'n))
    sorted.slice(4, 6).toSet === Set(List('a, 'b, 'c), List('f, 'g, 'h))
    sorted(6) === List('i, 'j, 'k, 'l)

    lsort(Nil) === Nil
    lsort(List(Nil)) === List(Nil)
    lsort(List(List(1, 2, 3), List(1), Nil, List(1, 2))) ===
      List(Nil, List(1), List(1, 2), List(1, 2, 3))

    // Note that in this example, the first two lists in the result have length 4 and 1 and both lengths appear just once.
    // The third and fourth lists have length 3 and there are two list of this length. Finally, the last three lists have
    // length 2. This is the most frequent length.
    val sortedFreq = lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e),
      List('i, 'j, 'k, 'l), List('m, 'n), List('o)))

    sortedFreq.slice(0, 2).toSet === Set(List('i, 'j, 'k, 'l), List('o))
    sortedFreq.slice(2, 4).toSet === Set(List('a, 'b, 'c), List('f, 'g, 'h))
    sortedFreq.slice(4, 7).toSet === Set(List('d, 'e), List('d, 'e), List('m, 'n))

    lsortFreq(Nil) === Nil
    lsortFreq(List(Nil)) === List(Nil)
    lsortFreq(List(Nil, List(1), List(1, 1), Nil, List(1), List(1, 1, 1), Nil, List(1, 1), List(1), Nil)) ===
      List(List(1, 1, 1), List(1, 1), List(1, 1), List(1), List(1), List(1), Nil, Nil, Nil, Nil)
  }

  def containElements[A](elems: A*): Matcher[Traversable[A]] = { (_: Traversable[A]) must contain(allOf(elems: _*)) }
}
