package renameTags

import scala.io.StdIn

object Main extends App {

  val subs = (for ( sub <- args; Array(k,v,_*) = sub.split(":") ) yield (k,v)).toMap
  val domain = subs.keySet

  Iterator.continually(StdIn.readLine()).takeWhile(_ != null).foreach { line => 
    if (line.startsWith("##INFO")) {
      val Array(_, _, _, tag, _*) = line.split("\\W+")
      val newLine = if (domain(tag)) line.replaceAll(s"""##INFO=<ID=${tag}""", s"""##INFO=<ID=${subs(tag)}""") else line
      println(newLine)
    }
    else if (line.startsWith("#")) println(line)
    else {
      val rec = line.split("\t")
      val info = rec(7)
      val tags = info.split(";")
      val renamed = tags.map { tagval => 
        tagval.split("=") match {
          case Array(tag, tval) => if (domain(tag)) s"${subs(tag)}=$tval" else s"$tag=$tval"
          case Array(tag)       => if (domain(tag)) subs(tag) else tag
        }
      }.mkString(";")
      rec(7) = renamed
      println(rec.mkString("\t"))
    }
  }
}
