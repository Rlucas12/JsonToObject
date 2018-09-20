name := "JsonToObject"

version := "0.1"

scalaVersion := "2.12.6"

val circeVersion = "0.9.3"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,

  "com.github.tototoshi" %% "scala-csv" % "1.3.5"
)