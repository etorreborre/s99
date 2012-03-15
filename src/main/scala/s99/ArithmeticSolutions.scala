package s99

import Solutions.???

trait ArithmeticSolutions {

  // add new functions to integers
  implicit def extendInt(n: Int): ExtendedInt = ExtendedInt(n)

  case class ExtendedInt(n: Int) {

    def isPrime: Boolean =
      n == 1 || n == 2 || (2 to n/2).forall(n % _ != 0)

    def isCoprimeTo(n: Int): Boolean = ???
    def totient: Int = ???
    def improvedTotient: Int = ???
    def primeFactors: List[Int] = ???
    def primeFactorMultiplicity: List[(Int, Int)] = ???
    def primeFactorMultiplicityMap: Map[Int, Int] = ???
    def listPrimesinRange(r: Range): List[Int] = ???
    def goldbach: (Int, Int) = ???

  }

  def gcd(m: Int, n: Int): Int =
    if (m < n) gcd(n, m)
    else if (m % n == 0) n
    else gcd(m - m / n * n, n)

  def primes: Stream[Int] = ???
  def listPrimesinRange(r: Range): List[Int] = ???
  def printGoldbachList(r: Range): List[String] = ???
  def printGoldbachListLimited(r: Range, limit: Int): List[String] = ???

}
