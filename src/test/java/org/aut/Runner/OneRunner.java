package org.aut.Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/Features/Login.feature"},
        glue = {"stepdefs"},
        plugin = {"pretty", "html:cucumber-reports/reports.html", "json:cucumber-reports/cucumberReport.json"},
        monochrome = true,
        publish = true)
public class OneRunner extends AbstractTestNGCucumberTests {
}
