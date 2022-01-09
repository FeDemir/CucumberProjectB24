package com.cybertek.step_definitions;

import com.cybertek.pages.EtsyAllCategoriesPage;
import com.cybertek.pages.EtsySearchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EtsySearch_StepDefinitions {
    WebDriver driver = Driver.getDriver();
    EtsySearchPage page = new EtsySearchPage();
    EtsyAllCategoriesPage allCategoriesPage = new EtsyAllCategoriesPage();

    @Given("user is on etsy homepage")
    public void user_is_on_etsy_homepage() {
        // Write code here that turns the phrase above into concrete actions
        driver.get(ConfigurationReader.getProperty("etsy.url"));
    }
    @Then("Page title should be as expected")
    public void page_title_should_be_as_expected() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Title is not verified",driver.getTitle(),"Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");
    }
    @When("User searches for wooden spoon")
    public void user_searches_for_wooden_spoon() {
        // Write code here that turns the phrase above into concrete actions
        page.searchFor("Wooden spoon");
    }
    @Then("Page title should start with wooden spoon")
    public void page_title_should_start_with_wooden_spoon() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Search title is not verified","Wooden spoon | Etsy",driver.getTitle());
    }

    @When("User searches for empty value")
    public void userSearchesFor() {
        page.searchFor("");
        
    }

    @Then("All categories should displayed")
    public void pageTitleShouldStartWith() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.titleIs("All categories | Etsy"));
        Assert.assertTrue(allCategoriesPage.allCategoriesHeader.isDisplayed());
        Assert.assertEquals("Search title is not verified","All categories | Etsy",driver.getTitle());

    }



    @And("User searches for {string}")
    public void userSearchesFor(String itemName) {
        page.searchInput.sendKeys(itemName,Keys.ENTER);

    }

    @Then("User should find at least {string} items")
    public void userShouldFindAtLeastItems(String expectedResult) {
        Assert.assertTrue(Integer.parseInt(page.resultCount.getText().replaceAll("\\D",""))>Integer.parseInt(expectedResult));

    }
}
