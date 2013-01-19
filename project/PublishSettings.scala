import sbt._
import Keys._
import com.typesafe.sbt.pgp.PgpKeys._

object PublishSettings {
  type Sett = Project.Setting[_]

  lazy val all = Seq[Sett](
    pom
  , publishMavenStyle := true
  , publishArtifact in Test := false
  , pomIncludeRepository := { _ => false }
  , licenses := Seq("BSD-3-Clause" -> url("http://www.opensource.org/licenses/BSD-3-Clause"))
  , useGpg := true
  )

  lazy val pom: Sett =
    pomExtra := (
      <developers>
        <developer>
          <id>nhibberd</id>
          <name>Nick Hibberd</name>
        </developer>
      </developers>
    )

}
