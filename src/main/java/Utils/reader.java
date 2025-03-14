package Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.ArrayList;

import java.util.List;

public class reader {
   static List<String> call=new ArrayList<>();
   public static void addData(String s){
      call.add(s);
      System.out.println(call.size());
      try {
      Workbook workbook = new XSSFWorkbook();
      Sheet sh = workbook.createSheet("data");
      String columnHead = "placeid";
      Row row = sh.createRow(0);
      Cell c = row.createCell(0);
      c.setCellValue(columnHead);
      List<String> call = GetArrayList();
      int rownum = 1;
      for (String i : call) {
         Row r = sh.createRow(rownum++);
         r.createCell(0).setCellValue(i);
      }
      FileOutputStream out = new FileOutputStream("./src/test/resources/Book1.xlsx");
      workbook.write(out);
      out.close();
      System.out.println("completed");
   } catch (Exception e) {
      throw new RuntimeException(e);
   }
}
    public static List<String> GetArrayList(){
        return call;

    }
}
