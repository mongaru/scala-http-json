package json

import spray.json.{DefaultJsonProtocol, JsonFormat}

/**
 * * This class represents the response JSON object of the GMap Geocode response.
 * * It has two properties the status and the results, this is the way to
 * * represent JSON objects with Spray.
 *
 * @param results - the list of entries
 * @param status - the status of the request, possibly "OK"
 * @tparam T - the type to which the result object must be mapped. This way we can reuse the GMapRequest object.
 */
case class GMapRequest[T](results: List[T], status: String)

/**
 * This is a Geo Location entry JSON format, it has other properties but we are showing these two.
 * @param formatted_address
 * @param address_components
 */
case class GeoLocation(formatted_address: String, address_components: List[AddressItem])

/**
 * The single entry for the address JSON format.
 * @param long_name
 * @param short_name
 */
case class AddressItem(long_name: String, short_name: String) {
  def toCSV(): String = {
    return long_name + "," + short_name
  }
}


/**
 * The GMapRequestJsonProtocol is the Spray JSON object that will implement
 * the parsing feature for the Google Maps GeoLocation Request.
 *
 * The request JSON format is the following:
 *
 * https://developers.google.com/maps/documentation/geocoding/intro?hl=es-419
 * {
 *   "results" : [
 *   {
 *      "address_components" : [
 *       {
 *          "long_name" : "1600",
 *          "short_name" : "1600",
 *          "types" : [ "street_number" ]
 *        }],
 *      "formatted_address" : "1600 Amphitheatre Parkway, Mountain View, CA 94043, USA"
 *   }],
 *   "status" : "OK"
 * }
 *
 */
object GMapRequestJsonProtocol extends DefaultJsonProtocol {

  // remember that the function jsonFormat2 depends on the amount of properties to read, in this case is 2
  implicit val addressItemFormat = jsonFormat2(AddressItem)
  implicit val geoLocationFormat = jsonFormat2(GeoLocation)
  implicit def gmapRequestFormat[T :JsonFormat] = jsonFormat2(GMapRequest.apply[T])
}