package helpers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter<AnyType> {


  public void exportTimesToCSV(List<AnyType> dataList, String fileName) {
    try (FileWriter csvWriter = new FileWriter(fileName)) {
      for (AnyType data : dataList) {
        csvWriter.append(data.toString());
        csvWriter.append("\n");
      }
      System.out.println("CSV file '" + fileName + "' has been created.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
