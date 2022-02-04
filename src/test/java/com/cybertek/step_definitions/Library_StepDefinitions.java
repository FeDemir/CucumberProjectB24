package com.cybertek.step_definitions;

import com.cybertek.pages.LibraryDashboardPage;
import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class Library_StepDefinitions {
    WebDriver driver = Driver.getDriver();
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get(ConfigurationReader.getProperty("library_url"));
    }
    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        LibraryLoginPage loginPage = new LibraryLoginPage();
        loginPage.login(ConfigurationReader.getProperty("librarian_username"),
                        ConfigurationReader.getProperty("library_password"));
    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        LibraryDashboardPage dashboardPage = new LibraryDashboardPage();
        Assert.assertTrue(dashboardPage.userAvatar.isDisplayed());
    }
    @When("I login as a student")
    public void i_login_as_a_student() {
        LibraryLoginPage loginPage = new LibraryLoginPage();
        loginPage.login(ConfigurationReader.getProperty("student_username"),
                ConfigurationReader.getProperty("library_password"));
    }

    @When("I login as a librarian with {string} and {string}")
    public void iLoginAsALibrarianWithAnd(String username, String password) {
        LibraryLoginPage loginPage = new LibraryLoginPage();
        loginPage.login(username,password);
    }
}
