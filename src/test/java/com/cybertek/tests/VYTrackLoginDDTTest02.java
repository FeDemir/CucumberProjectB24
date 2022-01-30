package com.cybertek.tests;

import com.cybertek.pages.VYTrackDashboardPage;
import com.cybertek.pages.VYTrackLoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VYTrackLoginDDTTest02 {
    @Before
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack2.url"));
    }
    @After
    public void tearDown(){
        Driver.closeDriver();
    }
    @Test()
    public void loginDDTTest() throws IOException {
        /**
         * open excel file
         * add page object
         * loop and read credentials from excel
         * write the result in excel file
         * save excel file
         */
        String path = "VyTrackQa2Users.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet dataSheet = workbook.getSheetAt(0);
        /**
         String userName = "user1";
         String password = "UserUser123";
         String firstName = "John";
         String lastName = "Doe";
         */
        for (int i=1;i<=dataSheet.getLastRowNum();i++) {
            String username = dataSheet.getRow(i).getCell(0).toString();
            String password = dataSheet.getRow(i).getCell(1).toString();;
            String firstName = dataSheet.getRow(i).getCell(2).toString();;
            String lastName = dataSheet.getRow(i).getCell(3).toString();;
            VYTrackLoginPage loginPage = new VYTrackLoginPage();
            loginPage.login(username, password);
            
            VYTrackDashboardPage dashboardPage = new VYTrackDashboardPage();
            System.out.println("Full name = " + dashboardPage.fullName.getText());
            String actualFullName = dashboardPage.fullName.getText();
            // Assert.assertTrue(actualFullName.contains(firstName) && actualFullName.contains(lastName));

            XSSFCell cell = dataSheet.getRow(i).createCell(4);
            if (actualFullName.contains(firstName) && actualFullName.contains(lastName)) {
                System.out.println("Pass");
                cell.setCellValue("Pass");

            }
            else {
                System.out.println("Fail");
                cell.setCellValue("Fail");

            }
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
            WebElement loaderMask = Driver.getDriver().findElement(By.xpath("//div[@class='loader-mask shown']"));
            System.out.println("Loader is visible = " + loaderMask.isDisplayed());
            //if (loaderMask.isDisplayed())
                wait.until(ExpectedConditions.invisibilityOf(loaderMask));
            dashboardPage.logout();

        }
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        fileInputStream.close();
        workbook.close();
    }
}
