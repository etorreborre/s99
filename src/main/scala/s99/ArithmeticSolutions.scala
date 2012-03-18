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

    def improvedTotient: Int = primeFactorMultiplicity.foldLeft(1) { (res, cur) =>
      val (prime, number) = cur
      res * (prime - 1) * math.pow(prime, (number - 1)).toInt
    }

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

    def goldbachs: List[(Int, Int)] =
      for {
        a <- listPrimesinRange(1 to n)
        b <- 0 :: listPrimesinRange(1 to n)
        if a + b == n
      } yield (a, b)

    def goldbach: (Int, Int) = goldbachs.headOption.getOrElse((n, n))

  }

  def gcd(m: Int, n: Int): Int =
    if (m < n) gcd(n, m)
    else if (m % n == 0) n
    else gcd(m - m / n * n, n)

  def primes: Stream[Int] = Stream.from(1).filter(_.isPrime)

  def listPrimesinRange(r: Range): List[Int] = r.filter(_.isPrime).toList

  def goldbachList(r: Range): List[(Int, Int)] =
    r.map(_.goldbach).sortBy(p => p._1+p._2).toList

  def goldbachs(r: Range) =
    r.flatMap(_.goldbachs).sortBy(p => p._1+p._2)

  def printGoldbachList(r: Range): List[String] =
    goldbachList(r).map { case (a, b) => printSum(a, b) }

  def printGoldbachListLimited(r: Range, limit: Int): List[String] =
    goldbachs(r).map { case (a, b) if a >= limit && b >= limit => printSum(a, b)}.toList

  def printSum(a: Int, b: Int) = (a + b)+" = "+a+" + "+b
}
