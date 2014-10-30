package com.wonders.testplatform.dataset.schematron;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class ReadExcel {

  private String inputFile;

  public void setInputFile(String inputFile) {
    this.inputFile = inputFile;
  }

  public void read() throws IOException  {
    InputStream inputWorkbook = new FileInputStream(inputFile);
    Workbook w;
    try {
      WorkbookSettings settings = new WorkbookSettings ();  
      settings.setWriteAccess(null);  
      settings.setArrayGrowSize(10000);
      w = Workbook.getWorkbook(inputWorkbook,settings);

      // Get the first sheet
      Sheet sheet = w.getSheet(0);
      // Loop over first 10 column and lines

      for (int j = 0; j < sheet.getColumns(); j++) {
        for (int i = 0; i < sheet.getRows(); i++) {
          Cell cell = sheet.getCell(j, i);
          CellType type = cell.getType();
          if (type == CellType.LABEL) {
            System.out.println("I got a label "
                + cell.getContents());
          }

          if (type == CellType.NUMBER) {
            System.out.println("I got a number "
                + cell.getContents());
          }

        }
      }
    } catch (BiffException e) {
      e.printStackTrace();
    }
  }

  public void test(){
	  
  }
  public static void main(String[] args) throws IOException {
    ReadExcel test = new ReadExcel();
    test.setInputFile("城乡居民健康档案基本数据集.xls");
    test.read();
  }

} 