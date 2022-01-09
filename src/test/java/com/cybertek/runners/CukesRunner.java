package com.cybertek.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",//this will store failed scenarios into rerun.txt file
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "com/cybertek/step_definitions",
        dryRun = false
        //,tags = "@interview"
)
public class CukesRunner {
}
