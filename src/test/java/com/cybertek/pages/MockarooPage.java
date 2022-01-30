package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MockarooPage extends BasePage {

    @FindBy (xpath = "(//span[.='Download Data'])")
    public WebElement downloadDataBtn;

    @FindBy (name = "num_rows")
    public WebElement numberOfRowsInput;
    @FindBy (id = "mui-component-select-file_format")
    public WebElement formatDropdown;
    @FindBy (xpath = "//li[.='Excel']")
    public WebElement excelOption;
    @FindBy (xpath = "//span[.='Preview']")
    public WebElement previewBtn;
    @FindBy (xpath = "//th")
    public List<WebElement> tableHeaders;
    @FindBy (xpath = "//tbody/tr")
    public List<WebElement> numberOfRows;



    public void selectExcel() {
        formatDropdown.click();
        excelOption.click();
    }
}
