package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsySearchPage {
    public EtsySearchPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "search_query")
    public WebElement searchInput;
    @FindBy(xpath = "//button[@value='Search']")
    public WebElement searchBtn;
    public void searchFor(String keyword){
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(keyword);
        searchBtn.click();
    }
    @FindBy(xpath = "(//span[@class='wt-display-inline-flex-sm']/span)[1]")
    public WebElement resultCount;
}
