package s99

trait LogicAndCodesSolutions { outer =>

  implicit class ExtendedBoolean(a: Boolean) {
    def and(b: => Boolean): Boolean = outer.and(a, b)
    def or(b: => Boolean): Boolean = outer.or(a, b)
    def nand(b: => Boolean): Boolean = outer.nand(a, b)
    def nor(b: => Boolean): Boolean = outer.nor(a, b)
    def xor(b: => Boolean): Boolean = outer.xor(a, b)
    def impl(b: => Boolean): Boolean = outer.impl(a, b)
    def equ(b: => Boolean): Boolean = outer.equ(a, b)
  }
  
  def and(a: Boolean, b: => Boolean): Boolean = ???
  def or(a: Boolean, b: => Boolean): Boolean = ???
  def nand(a: Boolean, b: => Boolean): Boolean = ???
  def nor(a: Boolean, b: => Boolean): Boolean = ???
  def xor(a: Boolean, b: => Boolean): Boolean = ???
  def impl(a: Boolean, b: => Boolean): Boolean = ???
  def equ(a: Boolean, b: => Boolean): Boolean = ???
  def not(a: Boolean): Boolean = ???

  def table2(f: (Boolean, Boolean) => Boolean): String = ???

  def gray(n: Int): List[String] = ???
  def huffman(list: List[(String,  Int)]): List[(String, String)] = ???
}
