package org.aut.Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/Features/Login.feature"},
        glue = {"stepdefs"},
        plugin = {"pretty", "html:target/cucumber-reports/reports.html", "json:target/cucumber-reports/cucumberReport.json"},
        monochrome = true,
        publish = true)
public class OneRunner extends AbstractTestNGCucumberTests {
}
