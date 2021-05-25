import sbt._

lazy val root = project
  .in(file("."))
  .settings(
    name := "scalapb-example",
    scalaVersion := "2.13.6",
    scalacOptions += "-deprecation"
  )

libraryDependencies ++= Seq(
  "com.thesamet.scalapb" %% "scalapb-runtime" % "0.10.11" % "protobuf",
  "com.thesamet.scalapb.common-protos" %% "proto-google-common-protos-scalapb_0.10" % "1.18.1-1",
  "com.thesamet.scalapb.common-protos" %% "proto-google-common-protos-scalapb_0.10" % "1.18.1-1" % "protobuf"
)

Compile / PB.targets := Seq(
  PB.gens.java -> (Compile / sourceManaged).value,
  scalapb.gen(javaConversions = true) -> (Compile / sourceManaged).value
)
