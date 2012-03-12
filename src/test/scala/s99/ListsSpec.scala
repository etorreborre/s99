package s99

class ListsSpec extends ListsProblems { def is =

  "Find the last element of a list"                                                                                     ! P01^
  "Find the last but one element of a list"                                                                             ! P02^
  "Find the Kth element of a list. By convention, the first element in the list is element 0"                           ! P03^
  "Find the number of elements of a list"                                                                               ! P04^
  "Reverse a list"                                                                                                      ! P05^
  "Find out whether a list is a palindrome"                                                                             ! P06^
  "Flatten a nested list structure"                                                                                     ! P07^
  """
   Eliminate consecutive duplicates of list elements. If a list contains repeated elements they 
   should be replaced with a single copy of the element. The order of the elements should not be changed"""             ! P08^
  """
   Pack consecutive duplicates of list elements into sublists. If a list contains repeated elements
   they should be placed in separate sublists """                                                                       ! P09^
                                                                                                                        p^
  """
   Run-length encoding of a list. Use the result of problem P09 to implement the so-called run-length encoding
   data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number
   of duplicates of the element E"""                                                                                    ! P10^
  """
   Modified run-length encoding. Modify the result of problem P10 in such a way that if an element has
   no duplicates it is simply copied into the result list. Only elements with duplicates are transferred  
   as (N, E) terms"""                                                                                                   ! P11^
  """
    Decode a run-length encoded list. Given a run-length code list generated as specified in problem P10,
    construct its uncompressed version"""                                                                               ! P12^
  """Run-length encoding of a list (direct solution). Implement the so-called run-length encoding data compression
    "method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly"""        ! P13^
                                                                                                                        p^
  "Duplicate the elements of a list"                                                                                    ! P14^
  "Duplicate the elements of a list a given number of times"                                                            ! P15^
  "Drop every Nth element from a list"                                                                                  ! P16^
  "Split a list into two parts.  The length of the first part is given. Use a Tuple for your result"                    ! P17^
  """
   Extract a slice from a list. Given two indices, I and K, the slice is the list containing the elements
   from and including the Ith element up to but not including the Kth element of the original list. Start
   counting the elements with 0"""                                                                                      ! P18^
  "Rotate a list N places to the left"                                                                                  ! P19^
  """
    Remove the Kth element from a list. Return the list and the removed element in a Tuple.
    Elements are numbered from 0"""                                                                                     ! P20^
  "Insert an element at a given position into a list"                                                                   ! P21^
  "Create a list containing all integers within a given range"                                                          ! P22^
  "Extract a given number of randomly selected elements from a list. Hint: Use the solution to problem P20"             ! P23^
  "Lotto: Draw N different random numbers from the set 1..M"                                                            ! P24^
  "Generate a random permutation of the elements of a list. Hint: Use the solution of problem P23"                      ! P25^
                                                                                                                        p^
  """
   Generate the combinations of K distinct objects chosen from the N elements of a list. In how many ways
   can a committee of 3 be chosen from a group of 12 people? We all know that there are C(12,3) = 220 possibilities
   (C(N,K) denotes the well-known binomial coefficient). For pure mathematicians, this result may be great But
   we want to really generate all the possibilities"""                                                                  ! P26^
  """
   Group the elements of a set into disjoint subsets.
     a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons?
        Write a function that generates all the possibilities.
     b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate
        will return a list of groups.

   Note that we do not want permutations of the group members; i.e. ((Aldo, Beat), ...) is the same solution
   as ((Beat, Aldo), ...). However, we make a difference between ((Aldo, Beat), (Carla, David), ...) and
   ((Carla, David), (Aldo, Beat), ...).

   You may find more about this combinatorial problem in a good book on discrete mathematics under the term
   "multinomial coefficients"."""                                                                                       ! P27^
  """
  Sorting a list of lists according to length of sublists.
    a) We suppose that a list contains elements that are lists themselves. The objective is to sort the elements
       of the list according to their length. E.g. short lists first, longer lists later, or vice versa.
    b) Again, we suppose that a list contains elements that are lists themselves. But this time the objective is
       to sort the elements according to their length frequency; i.e. in the default, sorting is done ascendingly,
       lists with rare lengths are placed, others with a more frequent length come later"""                             ! P28^
                                                                                                                        end
}

