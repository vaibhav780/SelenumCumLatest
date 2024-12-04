package org.aut.Factory;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Base {
    
    private WebDriver driver;
    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
    
    
    public WebDriver initdriver(){
        driver = new ChromeDriver();
        threadLocal.set(driver);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        return driver;
    }
    
    
    public static WebDriver getDriver(){
        return threadLocal.get();
    }
}
