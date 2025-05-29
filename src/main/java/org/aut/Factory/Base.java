package org.aut.Factory;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Base {
    
    private WebDriver driver;
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
    
    
    public WebDriver initdriver(){
        try{
             URL serverUrl = new URL("http://localhost:4444/");
          DesiredCapabilities capabilities = new DesiredCapabilities();
          capabilities.setBrowserName("chrome");
              driver=new RemoteWebDriver(serverUrl,capabilities);
        //driver = new ChromeDriver();
        threadLocal.set(driver);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        return driver;
    }catch (MalformedURLException e) {
          throw new RuntimeException(e);
      }

    }   
    
    
    public static WebDriver getDriver(){
        return threadLocal.get();
    }
}
