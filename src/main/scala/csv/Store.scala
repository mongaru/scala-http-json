package csv

import java.io.{BufferedWriter, FileWriter, IOException}
import java.util.ArrayList

import au.com.bytecode.opencsv.CSVWriter

/**
 * This class implements examples on how to use the OpenCSV library to
 * write CSV files in Scala.
 */
object Store {

  @throws(classOf[IOException])
  def writeContent(path: String, headers: List[String], lines: List[List[String]], scapeStrings: Boolean) = {

//    writer = new CSVWriter(new FileWriter("yourfile.csv"), ',',
//      CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER);

//    try {
      //val result: ArrayList[CategoryItem] = new ArrayList[CategoryItem]()

      val outputFile = new BufferedWriter(new FileWriter(path))
      val csvWriter = new CSVWriter(outputFile)

      var listOfRecords = new ArrayList[Array[String]]()

      // add headers
      listOfRecords.add(headers.toArray)
      //listOfRecords.add(Array("id", "name", "href"))
      // add all the entries
      lines.foreach(a => {
        listOfRecords.add(a.toArray)
      })

      csvWriter.writeAll(listOfRecords)
      outputFile.close()

//    } catch {
//      case : Throwable => {}
//    }
  }

}
