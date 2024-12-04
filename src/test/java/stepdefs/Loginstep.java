package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.aut.Factory.Base;
import org.aut.Pages.InventoryPage;
import org.aut.Pages.LoginPage;
import org.junit.Assert;

public class Loginstep extends Base {
    private LoginPage loginPage = new LoginPage(Base.getDriver());
    private InventoryPage inventoryPage = new InventoryPage(Base.getDriver());
    @Given("user on Login page")
    public void user_on_login_page() {
        Assert.assertTrue(loginPage.checkLoginpage());
    }
    @When("user enter {string} and {string}")
    public void user_enter_and(String string, String string2) {
        loginPage.enterEmail_password(string,string2);
    }
    @When("user clicks on login")
    public void user_clicks_on_login() {
        loginPage.clickLogin();
    }
    @Then("user navigate to inventory page header {string}")
    public void user_navigate_to_inventory_page_header(String string) {
        Assert.assertEquals(string,inventoryPage.checkInventory());
    }

    @Then("user got error {string}")
    public void user_got_error(String string) {
       boolean flag =false;
        if(loginPage.checkerrormsg().contains(string)){
            flag = true;
       }else {
            flag =false;
        }
        Assert.assertTrue(flag);
    }

    }

