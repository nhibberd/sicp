import sbt._
import Keys._

object build extends Build {
  type Sett = Project.Setting[_]

  val route = Project(
    id = "sicp"
  , base = file(".")
  , settings = Defaults.defaultSettings ++ Seq[Sett](
      name := "sicp"
    , version := "1.0-SNAPSHOT"
    , scalaVersion := "2.9.2"
    , scalacOptions := Seq(
        "-deprecation"
      , "-unchecked"
      )
    , libraryDependencies ++= Seq(
        ("org.scalaz" %% "scalaz-core" % "7.0.0-M7").cross(CrossVersion.full)
      , ("org.specs2" %% "specs2" % "1.12.2" % "test").cross(CrossVersion.full)
      , ("org.scalacheck" %% "scalacheck" % "1.10.0" % "test").cross(CrossVersion.full)
      )
    )
  )
}
