package com.cybertek.tests;

import com.cybertek.utilities.ExcelUtil;
import org.junit.Test;

public class ExcelUtilTest {
    @Test
    public void excelUtilTest01(){
        ExcelUtil excel = new ExcelUtil("Employees.xlsx","Sheet1");
        System.out.println("excel.rowCount() = " + excel.rowCount());
        System.out.println("excel.columnCount() = " + excel.columnCount());
        System.out.println("excel.getColumnsNames() = " + excel.getColumnsNames());
        System.out.println("excel.getDataList() = " + excel.getDataList());
    }
}
