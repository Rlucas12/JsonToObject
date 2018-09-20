import io.circe.{Decoder, HCursor, Json}
import io.circe.parser._

import scala.io.Source

object JsonToObject extends App {

  case class PhoneInformation(id: String, values: Seq[String])
  implicit val phoneInformationDecoder: Decoder[PhoneInformation] = Decoder.instance[PhoneInformation] { (c: HCursor) =>
    for {
      id <- c.downField("id").as[String]
      values <- c.downField("values").as[Seq[String]]
    } yield PhoneInformation(id, values)
  }

  val filename = "convertcsv.json"
  val fileContents = Source.fromFile(filename).getLines.mkString

  val jsonContent = parse(fileContents).getOrElse(Json.Null)
  println(jsonContent)

}
