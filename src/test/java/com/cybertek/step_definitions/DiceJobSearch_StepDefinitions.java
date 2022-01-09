package com.cybertek.step_definitions;

import com.cybertek.pages.DiceJobSearchPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class DiceJobSearch_StepDefinitions {
    @Given("User is on dice homepage")
    public void user_is_on_dice_homepage() {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get(ConfigurationReader.getProperty("dice.url"));
    }
    @When("User enters keyboard and zipcode")
    public void user_enters_keyboard_and_zipcode() {
        // Write code here that turns the phrase above into concrete actions
        DiceJobSearchPage dicePage = new DiceJobSearchPage();

        dicePage.jobTitle.sendKeys("QA Automation");
        dicePage.location.clear();
        dicePage.location.sendKeys("79762"+ Keys.ENTER);
        
    }
    @Then("User should see search results")
    public void user_should_see_search_results() {
        // Write code here that turns the phrase above into concrete actions
        DiceJobSearchPage dicePage = new DiceJobSearchPage();
        System.out.println("Result Count = " + dicePage.resultCount.getText());
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        String expectedInTitle = "Search Jobs | Dice.com";
        System.out.println("expectedInTitle = " + expectedInTitle);
        Assert.assertEquals("Search Page Title is not verified",expectedInTitle,actualTitle);
    }
}
