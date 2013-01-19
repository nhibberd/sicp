import sbt._
import Keys._
import com.typesafe.sbt.pgp.PgpKeys._
import Tools.onVersion

object build extends Build {
  type Sett = Project.Setting[_]

  val base = Defaults.defaultSettings ++ ScalaSettings.all ++ Seq[Sett](
      organization := "sicp"
    , version := "6.0-SNAPSHOT"
  )

  val scalaz = "org.scalaz" %% "scalaz-core" % "7.0.0-M7"
  val scalacheck = "org.scalacheck" %% "scalacheck" % "1.10.0" % "test" cross(CrossVersion.full)
  val specs2_1_12_3 = "org.specs2" %% "specs2" % "1.12.3" % "test"
  val specs2_1_13 = "org.specs2" %% "specs2" % "1.13" % "test"
  val caliper = "com.google.caliper" % "caliper" % "0.5-rc1"
  val liftjson = "net.liftweb" % "lift-json_2.9.2" % "2.5-M3"
  val jackson = "com.fasterxml.jackson.core" % "jackson-core" % "2.1.1"


  val sicp = Project(
    id = "sicp"
  , base = file(".")
  , settings = base ++ ReplSettings.all ++ PublishSettings.all ++ InfoSettings.all ++ Seq[Sett](
      name := "sicp"
    , libraryDependencies <++= onVersion(
        all = Seq(scalaz, scalacheck)
      , on292 = Seq(specs2_1_12_3)
      , on210 = Seq(specs2_1_13)
      )
    )
  )
}
