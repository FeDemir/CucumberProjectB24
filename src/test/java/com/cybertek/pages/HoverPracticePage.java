package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoverPracticePage {
    public HoverPracticePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//img)[1]")
    public WebElement img1;

    @FindBy(xpath = "(//img)[2]")
    public WebElement img2;

    @FindBy(xpath = "(//img)[3]")
    public WebElement img3;

    @FindBy(xpath = "(//h5)[1]")
    public WebElement user1;
    @FindBy(xpath = "(//h5)[2]")
    public WebElement user2;
    @FindBy(xpath = "(//h5)[3]")
    public WebElement user3;
}
