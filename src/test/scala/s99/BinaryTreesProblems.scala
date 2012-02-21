package s99

import org.specs2._
import matcher._

trait BinaryTreesProblems extends Specification with ThrownExpectations with BinaryTreesSolutions {

  def P55 = Tree.cBalanced(4, "x") must contain ("T(x T(x . .) T(x . T(x . .)))", "T(x T(x . .) T(x T(x . .) .))")
  def P56 = Node('a', Node('b'), Node('c')).isSymmetric must beTrue
  def P57  = {
    End.addValue(2).toString === "T(2 . .)"
    End.addValue(2).addValue(3).toString === "T(2 . T(3 . .))"
    End.addValue(2).addValue(3).addValue(0).toString === "T(2 T(0 . .) T(3 . .))"

    Tree.fromList(List(3, 2, 5, 7, 1)).toString === "T(3 T(2 T(1 . .) .) T(5 . T(7 . .)))"
    Tree.fromList(List(5, 3, 18, 1, 4, 12, 21)).isSymmetric must beTrue
    Tree.fromList(List(3, 2, 5, 7, 4)).isSymmetric must beFalse
  }

  def P58 = Tree.symmetricBalancedTrees(5, "x").toString ===
            "List(T(x T(x . T(x . .)) T(x T(x . .) .)), T(x T(x T(x . .) .) T(x . T(x . .))))"

  def P59 = Tree.hbalTrees(3, "x").map(_.toString) must contain("T(x T(x T(x . .) T(x . .)) T(x T(x . .) T(x . .)))",
                                                                "T(x T(x T(x . .) T(x . .)) T(x T(x . .) .))")

  def P60 = {
    Tree.minHbalNodes(3) === 4
    Tree.maxHbalHeight(4) === 3
    Tree.hbalTreesWithNodes(4, "x").map(_.toString) must contain ("T(x T(x T(x . .) .) T(x . .))", "T(x T(x . T(x . .)) T(x . .))")
  }

  def P61 = Node('x', Node('x'), End).leafCount === 1

  def P61A = Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList === List('b', 'd', 'e')

  def P62 = Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList === List('a', 'c')

  def P62B = Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2) === List('b', 'c')

  def P63 =  Tree.completeBinaryTree(6, "x").toString === "T(x T(x T(x . .) T(x . .)) T(x T(x . .) .))"

  def P64 = Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree.toString ===
            "T[3,1](a T[1,2](b . T[2,3](c . .)) T[4,2](d . .))"

  def P65 = Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree2.toString ===
            "T[3,1]('a T[1,2]('b . T[2,3]('c . .)) T[5,2]('d . .))"

  def P66 = Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree3.toString ===
            "T[2,1]('a T[1,2]('b . T[2,3]('c . .)) T[3,2]('d . .))"

  def P67 = {
    Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End))).show ===
    "a(b(d,e),c(,f(g,)))"

    Tree.fromString("a(b(d,e),c(,f(g,)))").show === "a(b(d,e),c(,f(g,)))"
  }

  def P68 = {
    Tree.string2Tree("a(b(d,e),c(,f(g,)))").preOrder === List('a', 'b', 'd', 'e', 'c', 'f', 'g')

    Tree.string2Tree("a(b(d,e),c(,f(g,)))").inOrder === List('d', 'b', 'e', 'a', 'c', 'g', 'f')

    Tree.preInTree(List('a', 'b', 'd', 'e', 'c', 'f', 'g'), List('d', 'b', 'e', 'a', 'c', 'g', 'f')).show ===
     "a(b(d,e),c(,f(g,)))"
  }

  def P69 = {
    Tree.string2Tree("a(b(d,e),c(,f(g,)))").toDotString === "abd..e..c.fg..."

    Tree.fromDotString("abd..e..c.fg...").show === "a(b(d,e),c(,f(g,)))"
  }
}

