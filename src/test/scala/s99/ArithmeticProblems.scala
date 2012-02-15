package s99

import org.specs2._
import matcher._

trait ArithmeticProblems extends Specification with ThrownExpectations with ArithmeticSolutions {

  def P31 = 7.isPrime must beTrue
  def P32 = gcd(36, 63) === 9
  def P33 = 35.isCoprimeTo(64) must beTrue
  def P34 = 10.totient === 4
  def P35 = 315.primeFactors === List(3, 3, 5, 7)

  def P36 = {
    315.primeFactorMultiplicity === List((3,2), (5,1), (7,1))
    315.primeFactorMultiplicityMap === Map(3 -> 2, 5 -> 1, 7 -> 1)
  }
  def P37 = 10.improvedTotient === 4

  def P38 = 10090.totient === 4032

  def P39 = listPrimesinRange(7 to 31) === List(7, 11, 13, 17, 19, 23, 29, 31)
  def P40 = 28.goldbach === (5, 23)

  def P41 = {
    printGoldbachList(9 to 20) === List(
      "10 = 3 + 7",
      "12 = 5 + 7",
      "14 = 3 + 11",
      "16 = 3 + 13",
      "18 = 5 + 13",
      "20 = 3 + 17")

    printGoldbachListLimited(1 to 2000, 50) === List(
      "992 = 73 + 919",
      "1382 = 61 + 1321",
      "1856 = 67 + 1789",
      "1928 = 61 + 1867")
  }
}
