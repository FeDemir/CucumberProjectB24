package com.cybertek.tests;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class VYTrackLoginDDTTest {
    WebDriver driver;
    @Before
    public void setup(){
         driver=Driver.getDriver();
         driver.get(ConfigurationReader.getProperty("vytrack2.url"));
    }
    @After
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test ()
    public void loginDDTTest() throws IOException {
        FileInputStream inputStream = new FileInputStream("VyTrackQa2Users.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet dataSheet = workbook.getSheetAt(0);
        for (int i = 1; i <= dataSheet.getLastRowNum(); i++) {
            String username = dataSheet.getRow(i).getCell(0).toString();
            String password = dataSheet.getRow(i).getCell(1).toString();
            WebElement userInput = driver.findElement(By.id("prependedInput"));
            WebElement passInput = driver.findElement(By.id("prependedInput2"));
            userInput.clear();
            userInput.sendKeys(username);
            passInput.clear();
            passInput.sendKeys(password,Keys.ENTER);
            System.out.println("username = " + username);
            System.out.println("password = " + password);
            System.out.println("driver = " + driver.getTitle());
            if(driver.getTitle().equals("Dashboard")){
                //if(username.startsWith("storemanager")) BrowserUtils.sleep(3);
                WebDriverWait wait = new WebDriverWait(driver,10);
                dataSheet.getRow(i).createCell(4).setCellValue("Pass");
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader-mask shown']")));
                driver.findElement(By.xpath("//i[@class='fa-caret-down']")).click();
                driver.findElement(By.xpath("//a[.='Logout']")).click();
                System.out.println("driver = " + driver.getTitle());
            }  else {

                dataSheet.getRow(i).createCell(4).setCellValue("Fail");
            }

        }
        FileOutputStream outputStream = new FileOutputStream("VyTrackQa2Users.xlsx");
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        inputStream.close();

    }
}
