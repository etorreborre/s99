package s99

import Solutions.???

trait BinaryTreesSolutions {

  sealed abstract class Tree[+T] {
    def isSymmetric: Boolean = ???
    def addValue[S >: T <% Ordered[S]](s: S): Tree[S] = ???

    def leafCount: Int = ???
    def leafList: List[T] = ???
    def internalList: List[T] = ???
    def atLevel(n: Int): List[T] = ???

    def layoutBinaryTree: Tree[T] = ???
    def layoutBinaryTree2: Tree[T] = ???
    def layoutBinaryTree3: Tree[T] = ???

    def show: String = ???
    def preOrder: List[T] = ???
    def inOrder: List[T] = ???
    def toDotString: String = ???
  }

  case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
    override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
  }

  case object End extends Tree[Nothing] {
    override def toString = "."
  }

  object Node {
    def apply[T](value: T): Node[T] = Node(value, End, End)
  }

  object Tree {

    def cBalanced[T](n: Int, e: T): List[Tree[T]] = ???
    def fromList[T <% Ordered[T]](list: List[T]): Tree[T] = ???
    def symmetricBalancedTrees[T](n: Int, e: T): List[Tree[T]] = ???
    def hbalTrees[T](h: Int, e: T): List[Tree[T]] = ???

    def minHbalNodes(h: Int): Int = ???
    def maxHbalHeight(n: Int): Int = ???
    def hbalTreesWithNodes[T](n: Int, e: T): List[Tree[T]] = ???
    def completeBinaryTree[T](n: Int, e: T): Tree[T] = ???

    def fromString(string: String): Tree[Char] = ???
    def preInTree[T](pre: List[T], in: List[T]): Tree[T] = ???
    def fromDotString(string: String): Tree[Char] = ???
  }

  class PositionedNode[+T](override val value: T,
                           override val left: Tree[T],
                           override val right: Tree[T],
                           val x: Int,
                           val y: Int) extends Node[T](value, left, right) {
    override def toString = "T[" + x.toString + "," + y.toString + "](" +
      value.toString + " " + left.toString + " " + right.toString + ")"
  }

  object PositionedNode {
    def apply[T](value: T, left: Tree[T], right: Tree[T], x: Int, y: Int) =
      new PositionedNode[T](value, left, right, x, y)
    def unapply[T](p: PositionedNode[T]) =
      Some((p.value, p.left, p.right, p.x, p.y))
  }
}
