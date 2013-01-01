package s99

import org.specs2.mutable.Specification
import org.specs2.matcher._

class ArithmeticSpec extends Specification with ArithmeticSolutions {

  "P31 Determine whether a given integer number is prime" >> {
    foreach(Seq(2, 3, 7, 13, 19)) { _ must bePrime }
    foreach(Seq(1, 4, 9, 25, 51)) { _ must not(bePrime) }
  }

  "P32 Determine the greatest common divisor of two positive integer numbers. Use Euclid's algorithm" >> {
    gcd(36, 63) === 9
    gcd(11, 1) === 1
    gcd(1, 11) === 1
    gcd(348, 3792) === 12
  }

  """P33 Determine whether two positive integer numbers are coprime
  Two numbers are coprime if their greatest common divisor equals 1""" >> {
    35 must beCoprimeTo(64)

    36 must not(beCoprimeTo(63))
    11 must beCoprimeTo(1)
    1 must beCoprimeTo(11)
    348 must not(beCoprimeTo(3792))
  }

  """P34 Calculate Euler's totient function phi(m)
  Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are
  coprime to m""" >> {
    10.totient === 4
    1.totient === 1
    3792.totient === 1248
  }

  """P35 Determine the prime factors of a given positive integer
  Construct a flat list containing the prime factors in ascending order""" >> {
    315.primeFactors === List(3, 3, 5, 7)
    1.primeFactors === Nil
    74.primeFactors === List(2, 37)
  }

  """P36 Determine the prime factors of a given positive integer (2)
  Construct a list containing the prime factors and their multiplicity. Alternately, use a Map for the result""" >> {
    315.primeFactorMultiplicityMap === Map(3 -> 2, 5 -> 1, 7 -> 1)
    315.primeFactorMultiplicity === List((3, 2), (5, 1), (7, 1))
    1.primeFactorMultiplicityMap === Map.empty
    1.primeFactorMultiplicity === Nil
    74.primeFactorMultiplicityMap === Map(2 -> 1, 37 -> 1)
    74.primeFactorMultiplicity === List((2, 1), (37, 1))
  }

  """P37 Calculate Euler's totient function phi(m) (improved)
  See problem P34 for the definition of Euler's totient function. If the list of the prime factors of a number m is
  known in the form of problem P36 then the function phi(m>1) can be efficiently calculated as follows:
  Let [[p1, m1], [p2, m2], [p3, m3], ...] be the list of prime factors (and their multiplicities) of a given number m.
  Then phi(m) can be calculated with the following formula:

    phi(m) = (p1-1) * p1^(m1-1) * (p2-1) * p2^(m2-1) * (p3-1) * p3^(m3-1) * ...

  Note that a^b stands for the bth power of a.""" >> {
    10.improvedTotient === 4
    10.improvedTotient === 4
    1.improvedTotient === 1
    3792.improvedTotient === 1248
  }

  """P38 Compare the two methods of calculating Euler's totient function
  Use the solutions of problems P34 and P37 to compare the algorithms. Try to calculate phi(10090) as an example""" >> {
    val (r1, t1) = withTimeRepeated(100)(10090.totient)
    val (r2, t2) = withTimeRepeated(100)(10090.improvedTotient)
    r1 === r2
    t1 must be_>(t2)
  }

  """P39 A list of prime numbers
  Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range""" >> {
    listPrimesinRange(7 to 31) === List(7, 11, 13, 17, 19, 23, 29, 31)
    listPrimesinRange(1 to 1) === Nil
    listPrimesinRange(3 to 2) === Nil
  }

  """P40 Goldbach's conjecture
  Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
  E.g. 28 = 5 + 23. It is one of the most famous facts in number theory that has not been proved to be correct in the
  general case. It has been numerically confirmed up to very large numbers (much larger than Scala's Int can represent).
  Write a function to find the two prime numbers that sum up to a given even integer""" >> {
    // Note: these tests consider that the function must return the Goldbach pair which contains the minimum element
    // (although more than one valid pair can exist). This restriction is enforced because the result of this function
    // strongly affects the expected results of P41 and it complies with the examples in the original problem statement.
    28.goldbach === (5, 23)
    74.goldbach === (3, 71)
    4.goldbach === (2, 2)
  }

  """P41 A list of Goldbach compositions
  Given a range of integers by its lower and upper limit, print a list of all even numbers and their Goldbach
  composition. In most cases, if an even number is written as the sum of two prime numbers, one of them is very small.
  Very rarely, the primes are both bigger than, say, 50. Try to find out how many such cases there are in the
  range 2..3000""" >> {
    printGoldbachList(9 to 20) === List(
      "10 = 3 + 7",
      "12 = 5 + 7",
      "14 = 3 + 11",
      "16 = 3 + 13",
      "18 = 5 + 13",
      "20 = 3 + 17")

    printGoldbachList(9 to 20 by 2) === Nil

    printGoldbachList(9 to 20 by 3) === List(
      "12 = 5 + 7",
      "18 = 5 + 13")

    printGoldbachList(3 to 3) === Nil

    printGoldbachListLimited(9 to 20, 1) === List(
      "10 = 3 + 7",
      "12 = 5 + 7",
      "14 = 3 + 11",
      "16 = 3 + 13",
      "18 = 5 + 13",
      "20 = 3 + 17")

    printGoldbachListLimited(9 to 20, 3) === List(
      "12 = 5 + 7",
      "18 = 5 + 13")

    printGoldbachListLimited(9 to 20, 5) === Nil

    printGoldbachListLimited(1 to 2000, 50) === List(
      "992 = 73 + 919",
      "1382 = 61 + 1321",
      "1856 = 67 + 1789",
      "1928 = 61 + 1867")
  }

  def bePrime: Matcher[Int] = (i: Int) => (i.isPrime, i + " is not prime")

  def beCoprimeTo(j: Int): Matcher[Int] = (i: Int) => (i.isCoprimeTo(j), i + " is not coprime to" + j)

  /**
   * @return the result of a computation with the time in millis to compute it
   */
  def withTime[T](t: => T): (T, Long) = {
    val start = System.currentTimeMillis()
    (t, System.currentTimeMillis() - start)
  }

  def withTimeRepeated[T](times: Int)(t: => T): (T, Long) = {
    val start = System.currentTimeMillis()
    ((1 to times).map(_ => t).head, System.currentTimeMillis() - start)
  }
}
