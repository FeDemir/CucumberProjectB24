package com.cybertek.step_definitions;

import com.cybertek.pages.ContextMenuPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu_StepDefinitions {
    WebDriver driver= Driver.getDriver();

    @When("user is on Context Menu Website")
    public void user_is_on_https_the_internet_herokuapp_com_context_menu() {
        // Write code here that turns the phrase above into concrete actions
        driver.get(ConfigurationReader.getProperty("contextMenu.url"));
    }
    @Then("user right clicks to the box.")
    public void user_right_clicks_to_the_box() {
        // Write code here that turns the phrase above into concrete actions
        ContextMenuPage page = new ContextMenuPage();
        Actions actions=new Actions(driver);
        actions.contextClick(page.hotSpot).build().perform();
        BrowserUtils.sleep(2);
    }


    @When("alert will open.")
    public void alert_will_open() {
        //System.out.println("Alert's Length = " + alert.getText().length());
    }
    @Then("user confirm alert text is {string}")
    public void user_confirm_alert_text_is(String alertText) {
        // Write code here that turns the phrase above into concrete actions
        Alert alert=driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());
        Assert.assertEquals(alertText,alert.getText());


    }
    @Then("user accepts alert")
    public void user_accepts_alert() {
        // Write code here that turns the phrase above into concrete actions
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }


}
