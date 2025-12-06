package org.aut.Factory;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.time.Duration;

public class Base {
    
    private WebDriver driver;
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
    
    
    public WebDriver initdriver(){
        //             URL serverUrl = new URL("http://172.18.0.4:4444/");
//          DesiredCapabilities capabilities = new DesiredCapabilities();
//          capabilities.setBrowserName("chrome");
//              driver=new RemoteWebDriver(serverUrl,capabilities);

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);
       driver = new ChromeDriver(options);
  
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        return driver;
   
    }   
    
    
    public static WebDriver getDriver(){
        return threadLocal.get();
    }
}
