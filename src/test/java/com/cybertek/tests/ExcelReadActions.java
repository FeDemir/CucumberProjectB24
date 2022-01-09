package com.cybertek.tests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;

public class ExcelReadActions {
    String filePath= "Employees.xlsx";
            //System.getProperty("user.home")+"/Downloads/MOCK_DATA.xlsx";
    @Test
    public void readExcelSheetData() throws IOException {
        //open the workbook
        XSSFWorkbook workbook = new XSSFWorkbook(filePath);
        //go to work sheet
        XSSFSheet dataSheet =  workbook.getSheetAt(0);
        //print all cell on first row
        System.out.println("COLUMN HEADER NAMES:");
        System.out.println(dataSheet.getRow(0).getCell(0));
        System.out.println(dataSheet.getRow(0).getCell(1));
        System.out.println(dataSheet.getRow(0).getCell(2));
        //get index number of cell on first row
        System.out.println("dataSheet.getRow(0).getLastCellNum() = " + dataSheet.getRow(0).getLastCellNum());
        //get last row's index number
        System.out.println("dataSheet.getLastRowNum() = " + dataSheet.getLastRowNum());
        //get number of rows with data(length - doesn't start from 0 and doesn't add empty rows in between)
        System.out.println("dataSheet.getPhysicalNumberOfRows() = " + dataSheet.getPhysicalNumberOfRows());
        //print all cells on first row
        for (int i=0; i<dataSheet.getRow(0).getLastCellNum(); i++){
            System.out.println(dataSheet.getRow(0).getCell(i));
        }
        //Print all firstnames
        System.out.println("\nALL NAMES:");
        for (int i=1;i<=dataSheet.getLastRowNum();i++){
            try {
                System.out.println(dataSheet.getRow(i).getCell(0));
            } catch (NullPointerException e){
                continue;
            }
        }
        //loop and find "Fahima" in firstname column
        //print her firstname | lastname | job id then exit loop

        System.out.println("\nFahima Info:");
        for (int i = 1; i < dataSheet.getLastRowNum(); i++) {
            if (dataSheet.getRow(i).getCell(0)==null) continue;
            else if (dataSheet.getRow(i).getCell(0).toString().equals("Ferhat")){
                System.out.println(dataSheet.getRow(i).getCell(0)+
                            " | "+dataSheet.getRow(i).getCell(1)+
                            " | "+dataSheet.getRow(i).getCell(2));
                break;
            }
        }















//        Iterator<Row> rows = dataSheet.iterator();
//        while (rows.hasNext()){
//            Iterator<Cell> cell = rows.next().cellIterator();
//            while (cell.hasNext())
//            System.out.print(cell.next()+"\t");
//            System.out.println();
//        }

    }
}
