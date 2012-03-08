package s99

import org.specs2._
import matcher.ThrownExpectations

trait GraphsProblems extends Specification with ThrownExpectations with GraphsSolutions {

  def P80 ={
    Graph.fromString("[b-c, f-c, g-h, d, f-b, k-f, h-g]").toTermForm ===
    List("d", "k", "h", "c", "f", "g", "b", List(("h", "g", ()), ("k", "f", ()), ("f", "b", ()), ("g", "h", ()), ("f", "c", ()), ("b", "c", ())))

    Digraph.fromStringLabel("[p>q/9, m>q/7, k, p>m/5]").toAdjacentForm ===
    List(("m", List(("q", 7))), ("p", List(("m", 5), ("q", 9))), ("k", List()), ("q", List()))
  }

  def P81 = {
    Digraph.fromStringLabel("[p>q/9, m>q/7, k, p>m/5]").findPaths("p", "q") ===
    List(List("p", "q"), List("p", "m", "q"))

    Digraph.fromStringLabel("[p>q/9, m>q/7, k, p>m/5]").findPaths("p", "k") === List()
  }

  def P82 = {
    Graph.fromString("[b-c, f-c, g-h, d, f-b, k-f, h-g]").findCycles("f") ===
    List(List("f", "c", "b", "f"), List("f", "b", "c", "f"))
  }

  def P83 = {
    Graph.fromString("[a-b, b-c, a-c]").spanningTrees === List("[a-b, b-c]", "[a-c, b-c]", "[a-b, a-c]")
  }

  def P84 = {
    Graph.fromStringLabel("[a-b/1, b-c/2, a-c/3]").minimalSpanningTree === "[a-b/1, b-c/2]"
  }

  def P85 = {
    Graph.fromString("[a-b]").isIsomorphicTo(Graph.fromString("[5-7]")) === true
  }

  def P86 = {
    Graph.fromString("[a-b, b-c, a-c, a-d]").nodes("a").degree === 3
    Graph.fromString("[a-b, b-c, a-c, a-d]").nodesByDegree === List("Node(a)", "Node(c)", "Node(b)", "Node(d)")
    Graph.fromString("[a-b, b-c, a-c, a-d]").colorNodes === List(("Node(a)", 1), ("Node(b)", 2), ("Node(c)", 3), ("Node(d)", 2))
  }

  def P87 = {
    Graph.fromString("[a-b, b-c, e, a-c, a-d]").nodesByDepthFrom("d") === List("c", "b", "a", "d")
  }

  def  P88 = {
    Graph.fromString("[a-b, c]").splitGraph === List("[a-b]", "[c]")
  }

  def P89 = {
    Digraph.fromString("[a>b, c>a, d>b]").isBipartite === true
    Graph.fromString("[a-b, b-c, c-a]").isBipartite === false
    Graph.fromString("[a-b, b-c, d]").isBipartite === true
    Graph.fromString("[a-b, b-c, d, e-f, f-g, g-e, h]").isBipartite === false
  }

}