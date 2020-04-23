
import json.GMapRequestJsonProtocol._
import org.scalatest.flatspec.AnyFlatSpec
import spray.json._
import com.typesafe.scalalogging.Logger
import json._

class GMapRequestTest extends AnyFlatSpec {
  val logger = Logger("Test")

  lazy val responseStr = """{
                           |  "results" : [
                           |   {
                           |       "address_components" : [
                           |       {
                           |           "long_name" : "1600",
                           |           "short_name" : "1600",
                           |           "types" : [ "street_number" ]
                           |       }],
                           |       "formatted_address" : "1600 Amphitheatre Parkway, Mountain View, CA 94043, USA"
                           |   }],
                           |   "status" : "OK"
                           |}""".stripMargin


  "GeoLocation Response Parser" should "parse data" in {

    val jsonAst = responseStr.parseJson
    val categories: GMapRequest[GeoLocation] = jsonAst.convertTo[GMapRequest[GeoLocation]]

    logger.info(responseStr)
    assert(categories.isInstanceOf[GMapRequest[GeoLocation]])
  }
}