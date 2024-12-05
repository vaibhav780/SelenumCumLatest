package org.aut.Utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Utilites {
    private WebDriver driver;
    public Utilites(WebDriver driver) {
        this.driver = driver;
    }



    public void Screenshot(){
        File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDir= System.getProperty("user.dir");
        try {
            FileUtils.copyFile(sourceFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
