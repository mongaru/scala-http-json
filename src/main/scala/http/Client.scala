package http

import org.apache.http.client.methods.{HttpGet, HttpPost}
import org.apache.http.impl.client.HttpClients

/**
 * This is an example of a class that implements a GET and POST methods to
 * send a request to a given URL. The class uses the Apache HttpClient library
 * and also there is an example on how to use OAuth token and also body parameters.
 */
object Client {

  /**
   * Send a GET request to the given URL and return the response as a String.
   * @param url
   * @param authorization - optional OAuth header for Authorization.
   * @return - String as a result of the request
   */
  def getRequest(url: String, authorization: String): String = {

    val httpClient = HttpClients.createDefault
    val request: HttpGet = new HttpGet(url)

    if (authorization != None)
      request.addHeader("Authorization", authorization)

    val httpResponse = httpClient.execute(request)

    val inputStream = httpResponse.getEntity().getContent()
    val content = scala.io.Source.fromInputStream(inputStream).getLines.mkString
    inputStream.close

    return content
  }

  /**
   * Send a POST request to the given URL and return the response as a String.
   * @param url
   * @param authorization - optional OAuth Bearer token.
   * @return - String as a result of the request
   */
  def postRequest(url: String, authorization: String): String = {
    val httpClient = HttpClients.createDefault

    val post: HttpPost = new HttpPost(url)

    if (authorization != None)
      post.addHeader("Authorization", authorization)

    /**
     * Example on how to send parameters on the body. =)
     *
     * val urlParameters : ArrayList[BasicNameValuePair] = new ArrayList[BasicNameValuePair](1)
     * urlParameters.add(new BasicNameValuePair("grant_type", "client_credentials"))
     * post.setEntity(new UrlEncodedFormEntity(urlParameters))
     *
     */

    val httpResponse = httpClient.execute(post)
    val inputStream = httpResponse.getEntity().getContent()
    val content = scala.io.Source.fromInputStream(inputStream).getLines.mkString
    inputStream.close

    /**
     * Example on how to parse only a specific JSON property from the response.
     * In this case could by a "access_token" from a OAuth request.
     *
     * val jsonAst = JsonParser(content)
     * val token = jsonAst.asJsObject.fields.get("access_token").mkString.replaceAll("\"", "")
     *
     */

    return content
  }
}
