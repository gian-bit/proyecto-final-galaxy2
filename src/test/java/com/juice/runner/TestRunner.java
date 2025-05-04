package com.juice.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.juice.steps", "com.juice.utils"},
        plugin = {  "pretty",
                    "html:target/cucumber-reports/cucumber-pretty.html",
                    "json:target/cucumber-reports/CucumberTestReport.json"},
        monochrome = true,
        publish = true,
        dryRun = false,
        tags = "@registro"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
