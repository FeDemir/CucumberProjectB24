package com.cybertek.tests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;

public class ExcelRead {
    @Test
    public void readingFromExcel() throws IOException {
        //Open excel workbook using XSSFWorkbooks class
        XSSFWorkbook workbook = new XSSFWorkbook("Employees.xlsx");
        //Go to the worksheet
        XSSFSheet worksheet = workbook.getSheet("Sheet1");
        //Print Mike (Row=1, column=0)
        System.out.println(worksheet.getRow(1).getCell(0));
        System.out.println(worksheet.getRow(3).getCell(1));
        //Print the whole sheet
        Iterator<Row> rows = worksheet.iterator();
        while (rows.hasNext()){
            Iterator<Cell> it=rows.next().iterator();
            while (it.hasNext()){
                System.out.print(it.next()+"\t");
            }
            System.out.println();
        }
        
    }
}
