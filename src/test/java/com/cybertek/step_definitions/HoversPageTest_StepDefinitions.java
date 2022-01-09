package com.cybertek.step_definitions;

import com.cybertek.pages.HoverPracticePage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HoversPageTest_StepDefinitions {
    WebDriver driver=Driver.getDriver();
    Actions actions=new Actions(driver);
    HoverPracticePage practicePage = new HoverPracticePage();
    @Given("User is on hovers page")
    public void user_is_on_hovers_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get(ConfigurationReader.getProperty("hovers.url"));

    }
    @When("User hovers mouse on img1")
    public void user_hovers_mouse_on_img1() {
        // Write code here that turns the phrase above into concrete actions

        actions.moveToElement(practicePage.img1).perform();
    }
    @Then("User1 should displayed")
    public void user1_should_displayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("User is not found",practicePage.user1.isDisplayed());    }
    @When("User hovers mouse on img2")
    public void user_hovers_mouse_on_img2() {
        // Write code here that turns the phrase above into concrete actions
        actions.moveToElement(practicePage.img2).perform();
    }
    @Then("User2 should displayed")
    public void user2_should_displayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("User is not found",practicePage.user2.isDisplayed());
    }

    @When("User hovers mouse on img3")
    public void user_hovers_mouse_on_img3() {
        // Write code here that turns the phrase above into concrete actions
        actions.moveToElement(practicePage.img3).perform();
    }
    @Then("User3 should displayed")
    public void user3_should_displayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("User is not found",practicePage.user3.isDisplayed());    
    }


}
