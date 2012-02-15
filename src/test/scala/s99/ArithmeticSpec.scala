package s99

import org.specs2.Specification

class ArithmeticSpec extends ArithmeticProblems { def is =

  "Determine whether a given integer number is prime"                                                                   ! P31^
  "Determine the greatest common divisor of two positive integer numbers. Use Euclid's algorithm"                       ! P32^
  """
   Determine whether two positive integer numbers are coprime. Two numbers are coprime if their greatest common
    divisor equals 1"""                                                                                                 ! P33^
  """
   Calculate Euler's totient function phi(m). Euler's so-called totient function phi(m) is defined as the number
   of positive integers r (1 <= r <= m) that are coprime to m"""                                                        ! P34^
  """
   Determine the prime factors of a given positive integer. Construct a flat list containing the prime factors
   in ascending order"""                                                                                                ! P35^
  """
   Determine the prime factors of a given positive integer (2). Construct a list containing the prime factors and
   their multiplicity. Alternately, use a Map for the result"""                                                         ! P36^
  """
   Calculate Euler's totient function phi(m) (improved).  See problem P34 for the definition of Euler's totient
   function. If the list of the prime factors of a number m is known in the form of problem P36 then the
   function phi(m>) can be efficiently calculated as follows: Let [[p1, m1], [p2, m2], [p3, m3], ...]
   be the list of prime factors (and their multiplicities) of a given number m. Then phi(m) can be calculated
   with the following formula:

      phi(m) = (p1-1)*p1(m1-1) * (p2-1)*p2(m2-1) * (p3-1)*p3(m3-1) * ...

   Note that ab stands for the bth power of a."""                                                                       ! P37^
  """
   Compare the two methods of calculating Euler's totient function. Use the solutions of problems
   P34 and P37 to compare the algorithms. Try to calculate phi(10090) as an example"""                                  ! P38^
  """
   A list of prime numbers. Given a range of integers by its lower and upper limit, construct a list of all
   prime numbers in that range"""                                                                                       ! P39^
  """
   Goldbach's conjecture. Goldbach's conjecture says that every positive even number greater than 2 is the
   sum of two prime numbers. E.g. 28 = 5 + 23. It is one of the most famous facts in number theory that has not
   been proved to be correct in the general case. It has been numerically confirmed up to very large numbers
   (much larger than Scala's Int can represent). Write a function to find the two prime numbers that sum up to a
   given even integer"""                                                                                                ! P40^
  """
   A list of Goldbach compositions. Given a range of integers by its lower and upper limit, print a list of all
   even numbers and their Goldbach composition
   In most cases, if an even number is written as the sum of two prime numbers, one of them is very small.
   Very rarely, the primes are both bigger than, say, 50. Try to find out how many such cases there are in the
   range 2..3000"""                                                                                                     ! P41^
                                                                                                                        end

}
