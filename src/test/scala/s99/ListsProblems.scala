package s99

import org.specs2._
import matcher._

trait ListsProblems extends Specification with ThrownExpectations with ListsSolutions {

  def P01 = last(List(1, 1, 2, 3, 5, 8)) === 8
  def P02 = penultimate(List(1, 1, 2, 3, 5, 8)) === 5
  def P03 = nth(2, List(1, 1, 2, 3, 5, 8)) === 2
  def P04 = length(List(1, 1, 2, 3, 5, 8)) === 6
  def P05 = reverse(List(1, 1, 2, 3, 5, 8)) === List(8, 5, 3, 2, 1, 1)
  def P06 = isPalindrome(List(1, 2, 3, 2, 1)) must beTrue
  def P07 = flatten(List(List(1, 1), 2, List(3, List(5, 8)))) === List(1, 1, 2, 3, 5, 8)
  def P08 = compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === List('a, 'b, 'c, 'a, 'd, 'e)
  def P09 = pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
            List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  def P10 = encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
            List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

  def P11 = encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
            List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  def P12 = decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) ===
            List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  def P13 = encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
            List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  def P14 = duplicate(List('a, 'b, 'c, 'c, 'd)) === List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  def P15 = duplicateN(3, List('a, 'b, 'c, 'c, 'd)) === List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
  def P16 = drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  def P17 = split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  def P18 = slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('d, 'e, 'f, 'g)
  def P19 = {
    rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
    rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
  }
  
  def P20 = removeAt(1, List('a, 'b, 'c, 'd)) === (List('a, 'c, 'd),'b)
  def P21 = insertAt('new, 1, List('a, 'b, 'c, 'd)) === List('a, 'new, 'b, 'c, 'd)
  def P22 = range(4, 9) === List(4, 5, 6, 7, 8, 9)
  def P23 = randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)) === List('e, 'd, 'a)
  def P24 = lotto(6, 49) === List(23, 1, 17, 33, 21, 37)
  def P25 = randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)) === List('b, 'a, 'd, 'c, 'e, 'f)
  def P26 = combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)) must contain(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e))
  def P27 = {
    group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")) must contain (
      List(List("Aldo", "Beat"), List("Carla", "David", "Evi"), List("Flip", "Gary", "Hugo", "Ida")))

    group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")) must contain(
      List(List("Aldo", "Beat"), List("Carla", "David"), List("Evi", "Flip", "Gary", "Hugo", "Ida")))
  }
  def P28 = {
    lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) ===
    List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
    
    // Note that in this example, the first two lists in the result have length 4 and 1 and both lengths appear just once.
    // The third and fourth lists have length 3 and there are two list of this length. Finally, the last three lists have 
    // length 2. This is the most frequent length.
    lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) ===
    List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))
  }

}
