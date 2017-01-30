package s99

trait GraphsSolutions {

  object Graph {
    def fromString(s: String): Graph[String, String] = ???
    def termLabel(s: String): Graph[String, String] = ???
    def fromStringLabel(s: String): Graph[String, String] = ???
  }

  object Digraph {
    def fromString(s: String): Digraph[String, String] = ???
    def fromStringLabel(s: String): Digraph[String, String] = ???
  }

  class Graph[T, U] extends GraphBase[T, U] {

    override def equals(o: Any) = o match {
      case g: Graph[_,_] => super.equals(g)
      case _ => false
    }

    def edgeTarget(e: Edge, n: Node): Option[Node] =
      if (e.n1 == n) Some(e.n2)
      else if (e.n2 == n) Some(e.n1)
      else None

    def addEdge(n1: T, n2: T, value: U) = {
      val e = new Edge(nodes(n1), nodes(n2), value)
      edges = e :: edges
      nodes(n1).adj = e :: nodes(n1).adj
      nodes(n2).adj = e :: nodes(n2).adj
    }
  }

  class Digraph[T, U] extends GraphBase[T, U] {
    def findPaths(n: T*): List[List[T]] = ???

    override def equals(o: Any) = o match {
      case g: Digraph[_,_] => super.equals(g)
      case _ => false
    }

    def edgeTarget(e: Edge, n: Node): Option[Node] =
      if (e.n1 == n) Some(e.n2)
      else None

    def addArc(source: T, dest: T, value: U) = {
      val e = new Edge(nodes(source), nodes(dest), value)
      edges = e :: edges
      nodes(source).adj = e :: nodes(source).adj
    }
  }

  abstract class GraphBase[T, U] {

    def toTermForm: (List[String], List[(String, String, Unit)]) = ???
    def toAdjacentForm: List[(String, List[(String, Int)])] = ???

    def findCycles(t: T): String = ???
    def spanningTrees: String = ???
    def minimalSpanningTree: String = ???
    def isIsomorphicTo(other: Graph[T, U]): Boolean = ???
    def nodesByDegree: List[Node] = ???
    def colorNodes: List[(Node, Int)] = ???
    def nodesByDepthFrom(t: T): List[T] = ???
    def splitGraph: List[String] = ???
    def isBipartite: Boolean = ???

    case class Edge(n1: Node, n2: Node, value: U) {
      def toTuple = (n1.value, n2.value, value)
    }
    case class Node(value: T) {
      var adj: List[Edge] = Nil
      def neighbors: List[Node] = adj.map(edgeTarget(_, this).get)

      def degree: Int = ???
    }

    var nodes: Map[T, Node] = Map()
    var edges: List[Edge] = Nil

    // If the edge E connects N to another node, returns the other node,
    // otherwise returns None.
    def edgeTarget(e: Edge, n: Node): Option[Node]

    override def equals(o: Any) = o match {
      case g: GraphBase[_,_] => (nodes.keys.toList.filterNot(g.nodes.keys.toList.contains) == Nil &&
                                 edges.map(_.toTuple).filterNot(g.edges.map(_.toTuple).contains) == Nil)
      case _ => false
    }

    def addNode(value: T) = {
      val n = new Node(value)
      nodes = Map(value -> n) ++ nodes
      n
    }
  }

}