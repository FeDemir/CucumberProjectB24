package com.cybertek.step_definitions;

import com.cybertek.pages.lyft_fare_estimatePage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class lyft_fare_estimate_StepDefinitions {
    WebDriver driver= Driver.getDriver();
    lyft_fare_estimatePage page = new lyft_fare_estimatePage();
    @Given("User is on lyft fare estimate page")
    public void user_is_on_lyft_fare_estimate_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get(ConfigurationReader.getProperty("lyft.fare.estimate.url"));
        String expectedTitle = "Get Fare Estimates for Your City - Lyft Price Estimate | Lyft";
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Title is not verified!",expectedTitle,actualTitle);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }
    @When("User enters {string} to pickup address")
    public void user_enters_to_pickup_address(String string) {
        // Write code here that turns the phrase above into concrete actions
        page.pickUpInput.sendKeys(string);
    }
    @When("User enters {string} to drop address")
    public void user_enters_to_drop_address(String string) {
        // Write code here that turns the phrase above into concrete actions
        page.dropOffInput.sendKeys(string);
    }
    @When("User clicks on get estimate button")
    public void user_clicks_on_get_estimate_button() {
        // Write code here that turns the phrase above into concrete actions
        page.getEstimateBtn.click();
        page.getEstimateBtn.click();
        page.getEstimateBtn.click();
        page.getEstimateBtn.click();

    }
    @Then("User should see estimated prices")
    public void user_should_see_estimated_prices() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("No Rides found",page.fareEstimateResult.isDisplayed());
        String result = page.fareEstimateResult.getText();
        System.out.println("Ride Fare Estimation for Lyft = "+result.substring(0,result.indexOf('|')));
        System.out.println("Ride Time Estimation for Lyft = "+result.substring(result.indexOf('|')+2));

    }
    @Then("User should see error message")
    public void user_should_see_error_message() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Error message is not displayed",page.errorMsg.isDisplayed());
    }

}
