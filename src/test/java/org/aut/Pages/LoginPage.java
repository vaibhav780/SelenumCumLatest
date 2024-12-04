package org.aut.Pages;

import org.aut.Utils.EvtLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    private WebDriver driver;

    @FindBy(id="user-name")
    WebElement usernamefield;

    @FindBy(id="password")
    WebElement passwordfield;

    @FindBy(id="login-button")
    WebElement loginbtn;

    @FindBy(className="login_logo")
    WebElement login_logo;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement login_errormsg;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public Boolean checkLoginpage(){
        return login_logo.isDisplayed();
    }

    public void enterEmail_password(String unme,String pass){
        usernamefield.sendKeys(unme);
        passwordfield.sendKeys(pass);
        EvtLogger.info("Entered Username and Password");
    }

    public void clickLogin(){
        loginbtn.click();
        EvtLogger.info("Clicked Login");
    }

    public String checkerrormsg(){
        if(login_errormsg.isDisplayed()){
            return login_errormsg.getText();
        }else {
            return "NULL";
        }
    }

}
