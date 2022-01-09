package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PercentageCalculatorPage {
    public PercentageCalculatorPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//input)[1]")
    public WebElement percentInput;
    @FindBy(xpath = "(//input)[2]")
    public WebElement ofInput;
    @FindBy(xpath = "(//input)[3]")
    public WebElement calculateBtn;
    @FindBy(xpath = "(//input)[4]")
    public WebElement percentResult;
}
