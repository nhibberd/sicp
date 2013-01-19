import sbt._
import Keys._

object ReplSettings {
  type Sett = Project.Setting[_]

  lazy val all = Seq[Sett](
    initialCommands := """
                         |import sicp._
                         |import scalaz._
                         |import Scalaz._
                       """.stripMargin
  )
}
