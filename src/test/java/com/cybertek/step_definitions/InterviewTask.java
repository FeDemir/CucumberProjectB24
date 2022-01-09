package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InterviewTask {
    WebDriver driver= Driver.getDriver();
    @Test
    public void Interview_Nadir(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        selectState(driver,"Texas");
    }
    public static void selectState(WebDriver driver, String stateName){
        
        Select states = new Select(driver.findElement(By.id("state")));
        for (WebElement state:states.getOptions()){
            System.out.println("State Name = " + state.getText());
        }
        states.selectByVisibleText(stateName);
    }
}
