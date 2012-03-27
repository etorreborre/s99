package s99

import Solutions.???

trait LogicAndCodesSolutions { outer =>

  implicit def extendBoolean(a: Boolean): ExtendedBoolean = ExtendedBoolean(a)
  case class ExtendedBoolean(a: Boolean) {
    def and (b: =>Boolean): Boolean = outer.and (a, b)
    def or  (b: =>Boolean): Boolean = outer.or  (a, b) 
    def nand(b: =>Boolean): Boolean = outer.nand(a, b)
    def nor (b: =>Boolean): Boolean = outer.nor (a, b)
    def xor (b: =>Boolean): Boolean = outer.xor (a, b)
    def impl(b: =>Boolean): Boolean = outer.impl(a, b)
    def equ (b: =>Boolean): Boolean = outer.equ (a, b)

  }
  
  def and(a: Boolean,  b: =>Boolean): Boolean = a && b
  def or(a: Boolean,   b: =>Boolean): Boolean = a || b
  def nand(a: Boolean,  b: =>Boolean): Boolean = !and(a, b)
  def nor(a: Boolean,  b: =>Boolean): Boolean = !or(a, b)
  def xor(a: Boolean,  b: =>Boolean): Boolean = (a or b) && a != b
  def impl(a: Boolean,  b: =>Boolean): Boolean = !a or b
  def equ(a: Boolean,  b: =>Boolean): Boolean = (a impl b) && (b impl a)
  def not(a: Boolean) = !a
  
  def table2(f: (Boolean, Boolean) => Boolean): String = {
    def row(a: Boolean, b: Boolean) = Seq(a, b, f(a, b)).map(_.toString.padTo(6, ' ')).mkString
    Seq("A     B     result",
        row(true,  true),
        row(true,  false),
        row(false, true),
        row(false, false)).mkString("\n")
  }

  def gray(n: Int): List[String] = ???
  def huffman(list: List[(String,  Int)]): List[(String, String)] = ???

}
