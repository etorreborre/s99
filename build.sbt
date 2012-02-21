/** Project */
name := "s99"

version := "1.0"

organization := "org.specs2"

scalaVersion := "2.9.1"

/** Dependencies */
resolvers ++= Seq("snapshots-repo" at "http://oss.sonatype.org/content/repositories/snapshots")

libraryDependencies ++= Seq(
  "org.scala-tools.testing" %% "scalacheck" % "1.9", 
  "org.scala-tools.testing" % "test-interface" % "0.5", 
  "org.specs2" %% "specs2-scalaz-core" % "6.0.1",
  "org.specs2" %% "specs2" % "1.9-SNAPSHOT",
  "org.pegdown" % "pegdown" % "1.0.2"
)

scalacOptions ++= Seq("-deprecation", "-unchecked")

/** Console */
initialCommands in console := "import org.specs2._"

