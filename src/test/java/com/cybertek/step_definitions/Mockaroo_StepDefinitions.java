package com.cybertek.step_definitions;

import com.cybertek.pages.MockarooPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mockaroo_StepDefinitions {
    MockarooPage page = new MockarooPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    @Given("User is on mockaroo homepage")
    public void user_is_on_mockaroo_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("mockaroo.url"));
    }
    @Given("Number of rows is {int}")
    public void number_of_rows_is(int rowsCount) {
        BrowserUtils.scrollDown(500);
        page.numberOfRowsInput.sendKeys(Keys.DELETE, rowsCount+"");
    }
    @Given("Format is Excel")
    public void format_is_excel() {
        page.selectExcel();
    }
    @When("User clicks on preview")
    public void user_clicks_on_preview() {
        page.previewBtn.click();
    }
    @Then("following columns should be displayed:")
    public void following_columns_should_be_displayed(List<String> expectedColumns) {
        //System.out.println("expectedColumns = " + expectedColumns);
        List<String> tableHeaders = new ArrayList<>();
        page.tableHeaders.forEach(i->tableHeaders.add(i.getText()));
        Assert.assertEquals("Headers don't match",expectedColumns,tableHeaders);
        List<String> actualTableHeaders = BrowserUtils.getElementsText(page.tableHeaders);
        Assert.assertEquals("Headers don't match",expectedColumns,actualTableHeaders);
    }
    @Then("{int} rows of data should be displayed")
    public void rows_of_data_should_be_displayed(int numberOfRows) {
        System.out.println("numberOfRows = " + numberOfRows);
        System.out.println("page.numberOfRows.size() = " + page.numberOfRows.size());
        Assert.assertEquals(numberOfRows,page.numberOfRows.size());
    }

    @When("User clicks on download")
    public void user_clicks_on_download() {
        page.downloadDataBtn.click();
        //BrowserUtils.sleep(5);
    }
    int numberOfRowsInExcel;
    String excelPath = System.getProperty("user.home")+"/Downloads/MOCK_DATA.xlsx";
    @Then("following columns should be displayed in excel file:")
    public void following_columns_should_be_displayed_in_excel_file(List<String> excelHeaders) throws IOException {
        //open downloaded excel file

        ExcelUtil excel = new ExcelUtil(excelPath,"data");
        System.out.println("excel.rowCount() = " + excel.rowCount());
        System.out.println("excel.columnCount() = " + excel.columnCount());
        System.out.println("excel.getColumnsNames() = " + excel.getColumnsNames());
        //System.out.println("excel.getDataList() = " + excel.getDataList());
        Assert.assertEquals(excelHeaders,excel.getColumnsNames());
        numberOfRowsInExcel = excel.rowCount()-1;
        
//        System.out.println("excelPath = " + excelPath);
//        FileInputStream fis = new FileInputStream(excelPath);
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        XSSFSheet worksheet = workbook.getSheetAt(0);
//        //get number of cell at first row iin excel
//        int excelHeaderCount = worksheet.getRow(0).getPhysicalNumberOfCells();
//
//        //We will find number of rows here and use it on next method
//        numberOfRowsInExcel = worksheet.getLastRowNum();
//        //create a new list and all cells at the excel header to the list
//        List<String> actualColumns = new ArrayList<>();
//        for (int i = 0; i < excelHeaderCount; i++) {
//            actualColumns.add(worksheet.getRow(0).getCell(i).toString());
//        }
//        System.out.println("actualColumns = " + actualColumns);
//        Assert.assertEquals("Headers are not matching in excel file",excelHeaders,actualColumns);
    }
    @Then("{int} rows of data should be displayed in excel file")
    public void rows_of_data_should_be_displayed_in_excel_file(int numberOfRows) {
        System.out.println("numberOfRows = " + numberOfRows);
        System.out.println("numberOfRows = " + numberOfRowsInExcel);
        Assert.assertEquals(numberOfRowsInExcel,numberOfRows);
    }

    @And("data should be present in excel file")
    public void dataShouldBePresentInExcelFile() {
        ExcelUtil excel = new ExcelUtil(excelPath,0);
        System.out.println("excel = " + excel.getDataList());
    }
}
