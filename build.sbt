name := "s99"

version := "0.1-SNAPSHOT"

organization := "net.ruippeixotog"

scalaVersion := "2.11.6"

libraryDependencies += "org.specs2" %% "specs2-core" % "3.6"

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-language:implicitConversions")
