package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.aut.Factory.Base;
import org.aut.Utils.EvtLogger;
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
    public void teardown(){
        if(driver!=null){
            driver.quit();
            EvtLogger.info("Driver closed");
        }
    }
}
