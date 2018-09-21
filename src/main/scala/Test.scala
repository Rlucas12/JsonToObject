import java.io.File

import com.github.tototoshi.csv._
import io.circe.generic.semiauto.deriveEncoder
import io.circe.Encoder
import io.circe.syntax._

object Test extends App {

  case class PhoneInformation(name: String, values: Seq[String])
  implicit val phoneInformationEncoder: Encoder[PhoneInformation] = deriveEncoder[PhoneInformation]

  val reader = CSVReader.open(new File("values.csv"))
  val values: CSVReader = reader

  val pisValues: Seq[(String, Seq[String])] = values.all.map(v => (v.head, v.tail))
  val correctValues: Seq[PhoneInformation] = pisValues.groupBy(_._1).map(a => PhoneInformation(a._1, a._2.flatMap(_._2))).toSeq

  val finalValues: Map[String, Seq[String]] = pisValues.groupBy(_._1).flatMap { case(key, v) => Map(key -> v.flatMap(_._2))}
  println(finalValues.asJson)

}

