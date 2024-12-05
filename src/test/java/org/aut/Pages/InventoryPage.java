package org.aut.Pages;

import io.cucumber.java.en.When;
import org.aut.Utils.EvtLogger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventoryPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='inventory_filter_container']/div")
    WebElement invetory_header;

    @FindBy(xpath = "//div[@class='bm-burger-button']")
    WebElement burger_menu;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    List<WebElement> allProductPrices;

    @FindBy(xpath = "//div[@class='inventory_item_label']/a")
    List<WebElement> allProductName;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement drop_down;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String checkInventory() {
        if (invetory_header.isDisplayed()) {
            return invetory_header.getText();
        } else {
            return "Null";
        }

    }

    public void clickmenu() {
        if (burger_menu.isDisplayed()) {
            burger_menu.click();
        } else {
            throw new StaleElementReferenceException("Element not displayed");
        }
    }


    public List<String> getAllPrices() {
        List<String> prices = new ArrayList<>();
        for (WebElement price : allProductPrices) {
            prices.add(price.getText());
        }
        return prices;

    }

    public void selectDrop_dwn(String value){
        Select dropdwn= new Select(drop_down);
        switch (value){
            case "desc":
                dropdwn.selectByValue("za");
                EvtLogger.info("selected ZA");
                break;
            case "lowtohigh":
                dropdwn.selectByValue("lohi");
                EvtLogger.info("selected Low to High");
                break;
            case "hightolow":
                dropdwn.selectByValue("hilo");
                EvtLogger.info("selected High to Low");
                break;
        }

    }
    public List<String> getAllNames() {
        List<String> Names = new ArrayList<>();
        for (WebElement names : allProductName) {
            Names.add(names.getText());
        }
        return Names;

    }

}
