package com.cybertek.step_definitions;

import com.cybertek.pages.PercentageCalculatorPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class PercentageCalculator_StepDefinitions {
    WebDriver driver = Driver.getDriver();
    PercentageCalculatorPage page = new PercentageCalculatorPage();
    @Given("User is on percentage calculator page")
    public void user_is_on_percentage_calculator_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get(ConfigurationReader.getProperty("percentage.url"));
    }
    @Then("User should see the following calculations")
    public void user_should_see_the_following_calculations(Map<Integer,Integer> valuesMap) {
        System.out.println("valuesMap = " + valuesMap);
        for (int key: valuesMap.keySet()) {
            page.percentInput.clear();
            page.percentInput.sendKeys(valuesMap.get(key)+"");
            page.ofInput.clear();
            page.ofInput.sendKeys(key+"");
            page.calculateBtn.click();
            Assert.assertTrue("No percentage result",page.percentResult.isDisplayed());
            System.out.println(valuesMap.get(key) +" percent of " +key+" = " + page.percentResult.getAttribute("value"));
            Assert.assertEquals("Results are not matching",valuesMap.get(key)*key/100+"",page.percentResult.getAttribute("value"));

        }
    }

    @Then("user closed driver.")
    public void userClosedDriver() {
        driver.quit();
        driver=null;
    }
}
