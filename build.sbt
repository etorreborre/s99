/** Project */
name := "s99"

version := "1.0"

organization := "org.specs2"

scalaVersion := "2.10.0"

/** Dependencies */
resolvers ++= Seq(
  "snapshots-repo" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases-repo" at "http://oss.sonatype.org/content/repositories/releases")

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.10.0", 
  "org.scala-tools.testing" % "test-interface" % "0.5", 
  "org.specs2" %% "scalaz-core" % "7.0.0",
  "org.specs2" %% "specs2" % "1.13",
  "org.pegdown" % "pegdown" % "1.2.1"
)

scalacOptions ++= Seq("-deprecation", "-unchecked")

/** Console */
initialCommands in console := "import org.specs2._"

