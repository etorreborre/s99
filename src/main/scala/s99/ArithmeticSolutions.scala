package s99

import Solutions._

trait ArithmeticSolutions {

  // add new functions to integers
  implicit class ExtendedInt(n: Int) {
    def isPrime: Boolean = ???
    def isCoprimeTo(n: Int): Boolean = ???
    def totient: Int = ???
    def primeFactors: List[Int] = ???
    def primeFactorMultiplicity: List[(Int, Int)] = ???
    def primeFactorMultiplicityMap: Map[Int, Int] = ???
    def improvedTotient: Int = ???
    def listPrimesinRange(r: Range): List[Int] = ???
    def goldbach: (Int, Int) = ???
  }

  def gcd(m: Int, n: Int): Int = ???
  def listPrimesinRange(r: Range): List[Int] = ???
  def printGoldbachList(r: Range): List[String] = ???
  def printGoldbachListLimited(r: Range, limit: Int): List[String] = ???

  // Optional but possibly useful exercise: not in original s-99 problems
  def primes: Stream[Int] = ???
}
