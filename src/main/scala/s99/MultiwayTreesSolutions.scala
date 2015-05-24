package s99

import Solutions._

trait MultiwayTreesSolutions {

  case class MTree[+T](value: T, children: List[MTree[T]] = Nil) {
    def nodeCount: Int = ???
    def show: String = ???
    def internalPathLength: Int = ???
    def postOrder: List[T] = ???

    def lispyTree: String = ???

    override def toString = s"M($value ${children.mkString(",")})"
  }

  object MTree {
    def fromLispyTree(string: String): MTree[Char] = ???
  }

  implicit def string2MTree(s: String): MTree[Char] = ???
}
