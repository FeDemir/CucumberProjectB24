package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpartanHomePage extends BasePage{
    @FindBy (xpath = "//a[@href='/spartans']")
    public WebElement webDataLink;

    @FindBy (xpath = "//a[@href='/swagger-ui/#/Spartan%20Controller']")
    public WebElement apiDocLink;

    @FindBy (xpath = "//a[@href='/images/Oracle_Connection_Info.jpg']")
    public WebElement databaseLink;
}
