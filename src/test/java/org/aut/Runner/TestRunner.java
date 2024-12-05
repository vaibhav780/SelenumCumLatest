package org.aut.Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/resources/Features/Login.feature"},
        glue = {"stepdefs"},
plugin = {"pretty", "html:target/cucumber-reports/reports.html","json:target/cucumber-reports/cucumberReport.json"},
monochrome = true,
publish = true,
tags = "@logout")
public class TestRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
