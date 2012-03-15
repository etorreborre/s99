package s99

import Solutions.???

trait ArithmeticSolutions {

  // add new functions to integers
  implicit def extendInt(n: Int): ExtendedInt = ExtendedInt(n)

  case class ExtendedInt(n: Int) {
    def isDivisor = (i: Int) => n % i == 0

    def isPrime: Boolean =
      n == 1 || n == 2 || !(2 to n/2).exists(isDivisor)

    def isCoprimeTo(other: Int): Boolean = gcd(n, other) == 1
    def totient: Int = (1 to n).filter(_.isCoprimeTo(n)).size
    def improvedTotient: Int = ???

    def primeFactors: List[Int] =
      if (n <= 1)      Nil
      else if (n <= 3) List(n)
      else
        (2 to n).filter(isDivisor).take(1).headOption match {
          case None    => List(n)
          case Some(p) => (p :: (n / p).primeFactors).sorted
        }

    def primeFactorMultiplicityMap: Map[Int, Int] =
      primeFactors.groupBy(identity).map { case (p, l) => (p, l.size) }

    def primeFactorMultiplicity: List[(Int, Int)] =
      primeFactorMultiplicityMap.toList.sorted

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
