package com.cybertek.tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {
    String path = "Employees.xlsx";
    @Test
    public void writeToExcelSheet() throws IOException {
        //Open the worksheet by FileInputStream
        FileInputStream inputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        //Go to the first sheet
        XSSFSheet dataSheet = workbook.getSheetAt(0);
        //Create a cell and enter value for the cell
        dataSheet.getRow(0).createCell(3).setCellValue("Salary");
        XSSFCell salaryCell1 = dataSheet.getRow(1).createCell(3);
        salaryCell1.setCellValue(123456);
        dataSheet.getRow(2).createCell(3).setCellValue(110000);
        dataSheet.getRow(3).createCell(3).setCellValue(120000);
        dataSheet.getRow(4).createCell(3).setCellValue(130000);
        dataSheet.getRow(5).createCell(3).setCellValue(140000);
        dataSheet.getRow(6).createCell(3).setCellValue(150000);
        dataSheet.getRow(7).createCell(3).setCellValue(160000);

        //open the file with output stream
        FileOutputStream outputStream = new FileOutputStream(path);
        //write edited excel to output stream
        workbook.write(outputStream);
        //close file
        outputStream.close();
        workbook.close();
        inputStream.close();
    }
}
