package s99

import org.specs2._
import matcher.ThrownExpectations


trait MultiwayTreesProblems  extends Specification with ThrownExpectations with MultiwayTreesSolutions {

  def P70C = MTree('a', List(MTree('f'))).nodeCount === 2

  def P70 = MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e'))))).show ===
            "afg^^c^bd^e^^^"

  def P71 = "afg^^c^bd^e^^^".internalPathLength === 9

  def P72 = "afg^^c^bd^e^^^".postorder === List('g', 'f', 'c', 'd', 'e', 'b', 'a')

  def P73 = MTree("a", List(MTree("b", List(MTree("c"))))).lispyTree === "(a (b c))"
}