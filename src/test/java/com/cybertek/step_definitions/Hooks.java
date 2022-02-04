package com.cybertek.step_definitions;

import com.cybertek.utilities.DB_Util;
import com.cybertek.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {
    /**
     * Similar to TestBase.java in TestNG framework
     * It starts the driver and quits the driver
     */
    @Before 
    public void setUpScenario(){
        System.out.println("Before - setup method is running before the each scenario");


    }

    @Before("@db")
    public void setUpDb() throws Exception {
        DB_Util.createConnection();
    }

    @After("@db")
    public void tearDownDb() throws Exception {
        DB_Util.destroy();
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        System.out.println("AFTER - tearDown method is running after the scenario:" + scenario.getName());
        if (scenario.isFailed()) {
            byte[] shot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(shot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
