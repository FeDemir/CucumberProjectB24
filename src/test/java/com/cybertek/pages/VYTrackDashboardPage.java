package com.cybertek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VYTrackDashboardPage extends BasePage{

    @FindBy (xpath = "//li[@id='user-menu']/a")
    public WebElement  fullName;
    @FindBy(linkText = "Logout")
    public WebElement logoutLink;

    @FindBy(xpath = "//div[@class='loader-mask shown']")
    public WebElement loaderMask;

    public void logout() {
        fullName.click();
        logoutLink.click();
    }
}
