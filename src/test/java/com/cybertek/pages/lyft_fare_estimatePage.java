package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class lyft_fare_estimatePage {
    public lyft_fare_estimatePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name = "fare-start")
    public WebElement pickUpInput;
    @FindBy(name = "fare-end")
    public WebElement dropOffInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement getEstimateBtn;
    @FindBy(xpath = "(//td[starts-with(text(), '$')])[1]")
    public WebElement fareEstimateResult;
    @FindBy(xpath = "//h3[.='RIDE TYPES']")
    public WebElement rideTypesHeader;

    @FindBy(xpath = "//table/tbody/tr[1]/td[3]")
    public WebElement liftPrice;
    @FindBy(xpath = "//div[@role=\"combobox\"]")
    public WebElement errorMsg;
}
