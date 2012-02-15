This project is the implementation of the [99 Scala problems](http://aperiodic.net/phil/scala/s-99/) as a set of [specs2](http://specs2.org) specifications, ready to implement and execute with [sbt](https://github.com/harrah/xsbt/).

Each Specification is divided into:

 - the description of the problem to solve (in `ListsSpec` for example)
 - the examples which should pass once the problem is solved (in `ListsProblems`)
 - the methods to implement (in `ListsSolutions`)

To run the specifications, install sbt (version > 0.11.2) and execute:

sbt>test

To see only the failed ones:

sbt>test-only -- xonly

