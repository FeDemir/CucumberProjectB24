package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Google_StepDefinitions {

    @Given("User is on Google home page")
    public void user_is_on_google_home_page() {

        Driver.getDriver().get("https://www.google.com");


    }


    @When("User searches for apple")
    public void user_searches_for_apple() {

        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.searchBar.sendKeys("apple" + Keys.ENTER);

    }

    @Then("User should see apple in the title")
    public void user_should_see_apple_in_the_title() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = "apple";

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }


    @Then("User should be able to search for following:")
    public void userShouldBeAbleToSearchForFollowing(List<String> keywords) {
        System.out.println("keywords = " + keywords);
        GoogleSearchPage page = new GoogleSearchPage();

        for (String keyword:keywords) {
            page.searchBar.click();
            page.searchBar.clear();
            page.searchBar.sendKeys(keyword);
            page.searchBar.submit();
            String actualTitle = Driver.getDriver().getTitle();
            String expectedInTitle = keyword;
            System.out.println("actualTitle = " + actualTitle);
            Assert.assertTrue(actualTitle.contains(expectedInTitle));
        }
    }
    @When("User searches for {string} capital")
    public void user_searches_for_capital(String countryName) {
        // Write code here that turns the phrase above into concrete actions
        GoogleSearchPage page = new GoogleSearchPage();
        page.searchBar.sendKeys("what is capital city of " + countryName + Keys.ENTER);
    }
    @Then("User should see {string} in the result")
    public void user_should_see_in_the_result(String capitalCity) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Expected Capital City name: " + capitalCity);
        GoogleSearchPage page = new GoogleSearchPage();
        System.out.println("page.capitolTitle.getText() = " + page.capitolTitle.getText());
        Assert.assertEquals("Result is not confirmed",capitalCity,page.capitolTitle.getText());
    }
}
