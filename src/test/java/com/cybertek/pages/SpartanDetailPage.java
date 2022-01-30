package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpartanDetailPage extends BasePage{
    @FindBy (xpath = "//div[@role='alert']")
    public WebElement confirmMsg;

    @FindBy (xpath = "//a[@href='/spartans']")
    public WebElement backToListLink;
}
