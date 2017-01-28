package s99

class GraphsSpec extends S99Specification with GraphsSolutions {

  /*
  A graph is defined as a set of nodes and a set of edges, where each edge is a pair of nodes.

  The class to represent a graph is mutable, which isn't in keeping with pure functional programming, but a pure
  functional data structure would make things much, much more complicated. [Pure functional graphs with cycles require
  laziness. I think Scala can handle it, but I think that would add too much of a barrier to the following questions]

  Our Graphs uses an incidence list internally. Each has a list of nodes and a list of edges. Each node also has a list
  of edges that connects it to other nodes. In a directed graph, nodes that are the target of arcs do not have
  references to those arcs in their adjacency list.

  There are a few ways to create a graph from primitives. The graph-term form lists the nodes and edges separately:

  Graph.term(List('b', 'c', 'd', 'f', 'g', 'h', 'k'),
             List(('b', 'c'), ('b', 'f'), ('c', 'f'), ('f', 'k'), ('g', 'h')))

  The adjacency-list form associates each node with its adjacent nodes. In an undirected graph, care must be taken to
  ensure that all links are symmetric--if b is adjacent to c, c must also be adjacent to b.

  Graph.adjacent(List(('b', List('c', 'f')), ('c', List('b', 'f')), ('d', Nil),
                      ('f', List('b', 'c', 'k')), ('g', List('h')), ('h', List('g')),
                      ('k', List('f'))))

  The representations we introduced so far are bound to our implementation and therefore well suited for automated
  processing, but their syntax is not very user-friendly. Typing the terms by hand is cumbersome and error-prone.
  We can define a more compact and 'human-friendly' notation as follows: A graph is represented by a string of terms
  of the type X or Y-Z separated by commas. The standalone terms stand for isolated nodes, the Y-Z terms describe
  edges. If an X appears as an endpoint of an edge, it is automatically defined as a node. Our example could be
  written as:

  [b-c, f-c, g-h, d, f-b, k-f, h-g]

  We call this the human-friendly form. As the example shows, the list does not have to be sorted and may even contain
  the same edge multiple times. Notice the isolated node d.

  When the edges of a graph are directed, we call them arcs. These are represented by ordered pairs. Such a graph is
  called directed graph. To represent a directed graph, the forms discussed above are slightly modified. The example
  graph opposite is represented as follows:

  - graph-term form:

  Digraph.term(List('r', 's', 't', 'u', 'v'),
               List(('s', 'r'), ('s', 'u'), ('u', 'r'), ('u', 's'), ('v', 'u')))

  - adjacency-list form:

  Digraph.adjacent(List(('r', Nil), ('s', List('r', 'u')), ('t', Nil),
                        ('u', List('r', 's')), ('v', List('u'))))
  (Note that the adjacency-list form is the same for graphs and digraphs.)

  - human-friendly form:

  [s>r, t, u>r, s>u, u>s, v>u]

  Finally, graphs and digraphs may have additional information attached to nodes and edges (arcs). For the nodes, this
  is no problem, as we can put any type into them. On the other hand, for edges we have to extend our notation. Graphs
  with additional information attached to edges are called labeled graphs.

  graph-term form:

  Digraph.termLabel(List('k', 'm', 'p', 'q'),
                    List(('m', 'q', 7), ('p', 'm', 5), ('p', 'q', 9)))
  adjacency-list form:

  Digraph.adjacentLabel(
    List(('k', Nil), ('m', List(('q', 7))), ('p', List(('m', 5), ('q', 9))),
         ('q', Nil)))
  human-friendly form:

  [p>q/9, m>q/7, k, p>m/5]

  The notation for labeled graphs can also be used for so-called multi-graphs, where more than one edge (or arc) is
  allowed between two given nodes
  */

  """ Conversions

  Write methods to generate the graph-term and adjacency-list forms from a Graph. Write another method to output the
  human-friendly form for a graph. Make it the toString method for Graph. Write more functions to create graphs from
  strings. Hint: You might need separate functions for labeled and unlabeled graphs""" >>
  { Graph.fromString("[b-c, f-c, g-h, d, f-b, k-f, h-g]").toTermForm ===
      List("d", "k", "h", "c", "f", "g", "b", List(("h", "g", ()), ("k", "f", ()), ("f", "b", ()), ("g", "h", ()), ("f", "c", ()), ("b", "c", ())))

    Digraph.fromStringLabel("[p>q/9, m>q/7, k, p>m/5]").toAdjacentForm ===
      List(("m", List(("q", 7))), ("p", List(("m", 5), ("q", 9))), ("k", List()), ("q", List())) }

  """ Path from one node to another one.

  Write a method named findPaths to find acyclic paths from one node to another in a graph. The method should return all paths""" >>
  { Digraph.fromStringLabel("[p>q/9, m>q/7, k, p>m/5]").findPaths("p", "q") ===
      List(List("p", "q"), List("p", "m", "q"))

    Digraph.fromStringLabel("[p>q/9, m>q/7, k, p>m/5]").findPaths("p", "k") === Nil }

  """ Cycle from a given node

  Write a method named findCycles to find closed paths (cycles) starting at a given node in a graph. The method should
  return all cycles""" >>
  { Graph.fromString("[b-c, f-c, g-h, d, f-b, k-f, h-g]").findCycles("f") ===
      List(List("f", "c", "b", "f"), List("f", "b", "c", "f")) }

  """ Construct all spanning trees

  Write a method spanningTrees to construct all spanning trees of a given graph. With this method, find out how many
  spanning trees there are for the graph depicted to the right. The data of this example graph can be found below.
  When you have a correct solution for the spanningTrees method, use it to define two other useful methods: isTree and
  isConnected. Both are five-minute tasks!""" >>
  { Graph.fromString("[a-b, b-c, a-c]").spanningTrees === List("[a-b, b-c]", "[a-c, b-c]", "[a-b, a-c]") }

  """ Construct the minimal spanning tree

  Write a method minimalSpanningTree to construct the minimal spanning tree of a given labeled graph. Hint: Use Prim's
  Algorithm. A small modification of the solution of P83 does the trick. The data of the example graph to the right can
  be found below""" >>
  { Graph.fromStringLabel("[a-b/1, b-c/2, a-c/3]").minimalSpanningTree === "[a-b/1, b-c/2]" }

  """ Graph isomorphism

  Two graphs G1(N1,E1) and G2(N2,E2) are isomorphic if there is a bijection f: N1 â†’ N2 such that for any nodes X,Y
  of N1, X and Y are adjacent if and only if f(X) and f(Y) are adjacent. Write a method that determines whether two
  graphs are isomorphic""" >>
  { Graph.fromString("[a-b]").isIsomorphicTo(Graph.fromString("[5-7]")) === true }

  """ Node degree and graph coloration

    a) Write a method Node.degree that determines the degree of a given node.
    b) Write a method that lists all nodes of a graph sorted according to decreasing degree.
    c) Use Welsh-Powell's algorithm to paint the nodes of a graph in such a way that adjacent nodes have different
       colors. Make a method colorNodes that returns a list of tuples, each of which contains a node and an integer
       representing its color""" >>
  { Graph.fromString("[a-b, b-c, a-c, a-d]").nodes("a").degree === 3
    Graph.fromString("[a-b, b-c, a-c, a-d]").nodesByDegree === List("Node(a)", "Node(c)", "Node(b)", "Node(d)")
    Graph.fromString("[a-b, b-c, a-c, a-d]").colorNodes === List(("Node(a)", 1), ("Node(b)", 2), ("Node(c)", 3), ("Node(d)", 2)) }

  """ Depth-first order graph traversal

  Write a method that generates a depth-first order graph traversal sequence. The starting point should be specified,
  and the output should be a list of nodes that are reachable from this starting point (in depth-first order)""" >>
  { Graph.fromString("[a-b, b-c, e, a-c, a-d]").nodesByDepthFrom("d") === List("c", "b", "a", "d") }

  """ Connected components.
  Write a function that splits a graph into its connected components""" >>
  { Graph.fromString("[a-b, c]").splitGraph === List("[a-b]", "[c]") }

  """ Bipartite graphs.
  Write a function that determines whether a given graph is bipartite""" >>
  { Digraph.fromString("[a>b, c>a, d>b]").isBipartite === true
    Graph.fromString("[a-b, b-c, c-a]").isBipartite === false
    Graph.fromString("[a-b, b-c, d]").isBipartite === true
    Graph.fromString("[a-b, b-c, d, e-f, f-g, g-e, h]").isBipartite === false }

}