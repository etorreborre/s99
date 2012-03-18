This project is the implementation of the [99 Scala problems](http://aperiodic.net/phil/scala/s-99/) as a set of [specs2](http://specs2.org) specifications, ready to implement and execute with [sbt](https://github.com/harrah/xsbt/).

Each Specification is divided into:

 - the description of the problem to solve (see [`ListsSpec`](https://github.com/etorreborre/s99/blob/master/src/test/scala/s99/ListsSpec.scala) for an example)
 - the methods to implement (see [`ListsSolutions`](https://github.com/etorreborre/s99/blob/master/src/main/scala/s99/ListsSolutions.scala) for an example)

To run the specifications, install sbt (version > 0.11.2) and execute:

sbt>test

To see only the failed ones:

sbt>test-only -- xonly

*WARNING* The specifications have not yet been all tested against a valid implementation, please report any bug!

