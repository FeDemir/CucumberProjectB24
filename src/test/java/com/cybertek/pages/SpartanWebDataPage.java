package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpartanWebDataPage extends BasePage{
    @FindBy(xpath = "//a[@href='/spartans/addNew']")
    public WebElement addSpartanBtn;
    @FindBy(id = "search")
    public WebElement searchBtn;
    @FindBy (id = "name")
    public WebElement nameInput;

    public boolean findData(String data){
        WebElement dataCell = Driver.getDriver().findElement(By.xpath("//td[.='"+data+"']"));
        return dataCell.isDisplayed();
    }
    
}
