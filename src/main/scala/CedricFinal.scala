import java.io.{File, PrintWriter}

import com.github.tototoshi.csv._
import io.circe.syntax._

object CedricFinal extends App {

  val reader = CSVReader.open(new File("values.csv"))
  val writer = new PrintWriter(new File("finalvalues.json"))
  val values: CSVReader = reader

  val pisValues: Seq[(String, Seq[String])] = values.all.map(v => (v.head, v.tail))
  val finalValues: Map[String, Seq[String]] = pisValues.groupBy(_._1).flatMap { case(key, v) => Map(key -> v.flatMap(_._2))}
  writer.write(finalValues.asJson.toString)
  writer.close()

}
