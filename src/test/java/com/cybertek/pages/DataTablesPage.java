package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataTablesPage {
    public DataTablesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@class='dt-button buttons-create']")
    public WebElement newBtn;
    @FindBy(id = "DTE_Field_first_name")
    public WebElement firstnameInput;
    @FindBy(id = "DTE_Field_last_name")
    public WebElement lastnameInput;
    @FindBy(id = "DTE_Field_position")
    public WebElement positionInput;
    @FindBy(id = "DTE_Field_salary")
    public WebElement salaryInput;
    @FindBy(xpath = "//button[@class='btn']")
    public WebElement createBtn;

    public void checkRecord(String name) {
        WebElement searchInput = Driver.getDriver().findElement(By.xpath("//input[@type='search']"));
        searchInput.sendKeys(name);
        WebElement record = Driver.getDriver().findElement(By.xpath("//td[.='" + name + "']"));
        Assert.assertTrue("Record is not found. Try Firstname Lastname!", record.isDisplayed());
        System.out.println("Record for " + name + " has found!");
    }

    public void isCurrentPage(){
        Assert.assertEquals("Page is not confirmed","Editor | Editing for DataTables",Driver.getDriver().getTitle());

    }
}
