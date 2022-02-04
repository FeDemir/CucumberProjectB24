package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LibraryLoginPage extends BasePage{
    @FindBy(id = "inputEmail")
    public WebElement emailBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(tagName = "button")
    public WebElement loginButton;


    public void login(String username, String password){
        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }
}
