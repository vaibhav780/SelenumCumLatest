package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.aut.Factory.Base;
import org.aut.Pages.InventoryPage;
import org.aut.Utils.EvtLogger;
import org.aut.Utils.Utilites;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class Inventorystep {
    private InventoryPage inventoryPage = new InventoryPage(Base.getDriver());
    private Utilites utilites = new Utilites(Base.getDriver());
    List<String> name_asc=Arrays.asList( "Sauce Labs Backpack",
            "Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt",
            "Sauce Labs Fleece Jacket","Sauce Labs Onesie",
            "Test.allTheThings() T-Shirt (Red)");
    List<String> price_asc = Arrays.asList("$29.99","$9.99","$15.99","$49.99","$7.99","$15.99");
    @When("user click on nav menu")
    public void user_click_on_nav_menu() {
        inventoryPage.clickmenu();
        utilites.Screenshot();
        EvtLogger.info("Screenshot Taken");
    }

    @Then("user prints product info")
    public void user_prints_product_info() {
        Assert.assertEquals(inventoryPage.getAllNames(),name_asc);
        EvtLogger.info(inventoryPage.getAllNames().toString());
    }

    @When("user sort by {string}")
    public void userSortBy(String arg0) {
        inventoryPage.selectDrop_dwn(arg0);
        utilites.Screenshot();
    }
}
