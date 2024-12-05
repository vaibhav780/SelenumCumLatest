package stepdefs;

import io.cucumber.java.en.When;
import org.aut.Factory.Base;
import org.aut.Pages.InventoryPage;
import org.aut.Utils.EvtLogger;
import org.aut.Utils.Utilites;

public class InventoryStep {
    private InventoryPage inventoryPage = new InventoryPage(Base.getDriver());
    private Utilites utilites = new Utilites(Base.getDriver());
    @When("user click on nav menu")
    public void user_click_on_nav_menu() {
        inventoryPage.clickmenu();
        utilites.Screenshot();
        EvtLogger.info("Screenshot Taken");
    }

}
