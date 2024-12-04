package org.aut.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='inventory_filter_container']/div")
    WebElement invetory_header;
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String checkInventory(){
       if (invetory_header.isDisplayed()){
           return invetory_header.getText();
       }else {
           return "Null";
       }

    }

}
