package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {
    public CalculatorPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public void clickOn(String buttonText){

        for (char ch:buttonText.toCharArray()){
            WebElement elm = Driver.getDriver().findElement(By.xpath("//span[.='"+ch+"']"));
            elm.click();
        }


    }
    @FindBy(id = "sciOutPut")
    public WebElement result;
}
