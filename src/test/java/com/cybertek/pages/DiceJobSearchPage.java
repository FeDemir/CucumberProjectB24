package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiceJobSearchPage {
    public DiceJobSearchPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "typeaheadInput")
    public WebElement jobTitle;

    @FindBy(id = "google-location-search")
    public WebElement location;

    @FindBy(id = "totalJobCount")
    public WebElement resultCount;
}
