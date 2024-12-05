package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.aut.Factory.Base;
import org.aut.Utils.EvtLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AppHooks {

    private Base base;
    private WebDriver driver;

    @Before
    public void setup(){
        base = new Base();
        driver=base.initdriver();
        driver.get("https://www.saucedemo.com/v1/");
        EvtLogger.info("Driver Started");
    }

    @After
    public void teardown(Scenario scenario){
        try {
            String screenshotName = scenario.getName();
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        if(driver!=null){
            driver.quit();
            EvtLogger.info("Driver closed");
        }
    }
}
