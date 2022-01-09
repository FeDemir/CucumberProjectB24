package com.cybertek.step_definitions;

import com.cybertek.pages.CalculatorPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class Calculator_StepDefinitions {
    WebDriver driver = Driver.getDriver();
    CalculatorPage page = new CalculatorPage();
    @Given("User is on calculator page")
    public void user_is_on_calculator_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get(ConfigurationReader.getProperty("calculator.url"));
    }
    @Given("User clicks on {string} on calculator")
    public void user_clicks_on_on_calculator(String string) {
        // Write code here that turns the phrase above into concrete actions
        page.clickOn(string);
    }
    @Then("result {string} should be displayed")
    public void result_should_be_displayed(String expectedResult) {
        // Write code here that turns the phrase above into concrete actions
        String actualResult = page.result.getText().replaceAll(" ","");
        Assert.assertEquals("Result doesn't match!",expectedResult,actualResult);
        
    }

}
