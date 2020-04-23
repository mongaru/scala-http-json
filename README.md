## Scala HTTP - Json
Scala simple HTTP client app with JSON parser and CSV writer.

## Goal
This repo is intended to provide an easy base example on how to implement a JSON parser in Scala using the Spray-Json library, since there are no many clear examples available I decided to write a very basic one.

## Technologies
Examples made with:

  - HTTP API Client
      - HTTP POST and GET requests [Apache HttpClient](https://hc.apache.org/httpcomponents-client-ga/) 
      - JSON response parsing to Scala objects [spray json](https://github.com/spray/spray-json)
      - CSV file generation [opencsv](http://opencsv.sourceforge.net/)
      - Tests with `org.scalatest` and `com.typesafe.scala-logging`.

## Run it!
1. Checkout repo.
2. Start sbt console `sbt`.
3. Run tests `test`.


**Note**: Currently the test cover the JSON parser, the client HTTP has its own class as the CSV parser.

