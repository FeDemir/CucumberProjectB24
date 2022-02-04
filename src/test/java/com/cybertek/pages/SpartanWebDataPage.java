package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpartanWebDataPage extends BasePage{
    @FindBy(xpath = "//a[@href='/spartans/addNew']")
    public WebElement addSpartanBtn;
    @FindBy(id = "search")
    public WebElement searchBtn;
    @FindBy (id = "name")
    public WebElement nameInput;

    public boolean verifyData(String name, String phone, String gender){
        System.out.println("Verifying "+name+" - "+phone+" - "+gender);
        nameInput.sendKeys(name);
        searchBtn.click();
        BrowserUtils.sleep(2);
        WebElement nameElm = Driver.getDriver().findElement(By.xpath("//td[.='"+name+"']"));
        WebElement phoneElm = Driver.getDriver().findElement(By.xpath("//td[.='"+name+"']/following-sibling::td[1]"));
        WebElement genderElm = Driver.getDriver().findElement(By.xpath("//td[.='"+name+"']/following-sibling::td[2]"));
        System.out.println("nameElm.isDisplayed() = " + nameElm.isDisplayed());
        System.out.println("phoneElm.isDisplayed() = " + phoneElm.isDisplayed());
        System.out.println("genderElm.isDisplayed() = " + genderElm.isDisplayed());
        if (!nameElm.getText().equals(name)) System.out.println("Name didn't matched");
        if (!phoneElm.getText().equals(phone)) System.out.println("Phone didn't matched");
        if (!genderElm.getText().equals(gender)) System.out.println("Gender didn't matched");

        return nameElm.getText().equals(name)
                &&phoneElm.getText().equals(phone)
                &&genderElm.getText().equals(gender);
    }
    
}
