package s99

import Solutions._

trait MultiwayTreesSolutions {

  case class MTree[+T](value: T, children: List[MTree[T]] = List()) {

    override def toString = "M(" + value.toString + " {" + children.map(_.toString).mkString(",") + "})"

    def nodeCount: Int = ???
    def show: String = ???
    def internalPathLength: Int = ???
    def postOrder: List[T] = ???

    def lispyTree: String = ???
  }

  object MTree {
    def fromLispyTree(string: String): MTree[Char] = ???
  }

  implicit def string2MTree(s: String): MTree[Char] = ???
}