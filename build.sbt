name := "git-mongaru-scala-http"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.4.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
  "org.scalatest" %% "scalatest" % "3.2.0-M4" % Test,

  "org.apache.httpcomponents" % "httpclient" % "4.5.12",
  "io.spray" %%  "spray-json" % "1.3.5",
  "au.com.bytecode" % "opencsv" % "2.4",
)
