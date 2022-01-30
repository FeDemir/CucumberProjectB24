package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddSpartanPage extends BasePage{
    @FindBy(id = "name")
    public WebElement nameInput;

    @FindBy(id = "phone")
    public WebElement phoneInput;

    @FindBy(id = "genderSelect")
    public WebElement genderInput;

    @FindBy(id = "submit_btn")
    public WebElement submitBtn;

    
    public void selectGender(String gender)  {
        Select genderDropDown = new Select(genderInput);
        genderDropDown.selectByVisibleText(gender);
    }
    public String getGender()  {
        Select genderDropDown = new Select(genderInput);
        return genderDropDown.getFirstSelectedOption().getText();
    }
}
