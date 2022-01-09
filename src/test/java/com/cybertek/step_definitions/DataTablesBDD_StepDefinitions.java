package com.cybertek.step_definitions;

import com.cybertek.pages.DataTablesPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class DataTablesBDD_StepDefinitions {
    WebDriver driver = Driver.getDriver();
    DataTablesPage page = new DataTablesPage();
    String fullname;
    @Given("User is on cloudtables homepage")
    public void user_is_on_cloudtables_homepage() {
        // Write code here that turns the phrase above into concrete actions
        driver.get(ConfigurationReader.getProperty("dataTables.url"));
        page.isCurrentPage();
    }
    @When("User enters {string} to firstname field")
    public void user_enters_to_firstname_field(String firstName) {
        // Write code here that turns the phrase above into concrete actions
        page.newBtn.click();
        page.firstnameInput.sendKeys(firstName);
        fullname=firstName;
    }
    @When("User enters {string} to lastname field")
    public void user_enters_to_lastname_field(String lastName) {
        // Write code here that turns the phrase above into concrete actions
        page.lastnameInput.sendKeys(lastName);
        fullname+=" "+lastName;
    }
    @When("User enters {string} to position field")
    public void user_enters_to_position_field(String position) {
        // Write code here that turns the phrase above into concrete actions
        page.positionInput.sendKeys(position);
    }
    @When("User enters {string} to salary field")
    public void user_enters_to_salary_field(String salary) {
        // Write code here that turns the phrase above into concrete actions
        page.salaryInput.sendKeys(salary);
    }
    @When("User clicks on create button")
    public void user_clicks_on_create_button() {
        // Write code here that turns the phrase above into concrete actions
        page.createBtn.click();
        page.checkRecord(fullname);
    }
}
