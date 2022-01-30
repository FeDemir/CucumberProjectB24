package com.cybertek.step_definitions;

import com.cybertek.pages.AddSpartanPage;
import com.cybertek.pages.SpartanDetailPage;
import com.cybertek.pages.SpartanHomePage;
import com.cybertek.pages.SpartanWebDataPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class Spartan_StepDefinitions {
    WebDriver driver = Driver.getDriver();
    SpartanWebDataPage dataPage = new SpartanWebDataPage();
    Map<String,String> addDataDetails;
    @Given("User is on spartan home page")
    public void user_is_on_spartan_home_page() {
        driver.get(ConfigurationReader.getProperty("spartan.url"));
    }
    @When("User goes to Web Data page")
    public void user_goes_to_web_data_page() {
        SpartanHomePage homePage = new SpartanHomePage();
        homePage.webDataLink.click();
    }
    @When("clicks on add spartan")
    public void clicks_on_add_spartan() {
        dataPage.addSpartanBtn.click();
    }
    @When("enters following data and submits:")
    public void enters_following_data_and_submits(Map<String,String> data) {
        addDataDetails=data;
        AddSpartanPage addPage = new AddSpartanPage();
        addPage.nameInput.sendKeys(data.get("name"));
        addPage.phoneInput.sendKeys(data.get("phone"));
        addPage.selectGender(data.get("gender"));
        addPage.submitBtn.click();
    }
    @Then("success message should be displayed")
    public void success_message_should_be_displayed() {
        SpartanDetailPage detailPage = new SpartanDetailPage();
        Assert.assertTrue("Data adding confirmation message is not displayed", detailPage.confirmMsg.isDisplayed());
        detailPage.backToListLink.click();
    }
    @Then("data on confirmation page must be same")
    public void data_on_confirmation_page_must_be_same() {
        SpartanWebDataPage dataPage = new SpartanWebDataPage();
        dataPage.nameInput.sendKeys(addDataDetails.get("name"));
        dataPage.searchBtn.click();
        //BrowserUtils.sleep(5);
        Assert.assertTrue(dataPage.findData(addDataDetails.get("name")));
        Assert.assertTrue(dataPage.findData(addDataDetails.get("phone")));
        Assert.assertTrue(dataPage.findData(addDataDetails.get("gender")));
    }

}
