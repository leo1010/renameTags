
name := "renameTags"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.8"

mainClass in assembly := Some("renameTags.Main")

mergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) =>
    (xs map {_.toLowerCase}) match {
      case ("manifest.mf" :: Nil) | ("index.list" :: Nil) | ("dependencies" :: Nil) => MergeStrategy.discard
      case _ => MergeStrategy.discard
    }
  case _ => MergeStrategy.first
}
