package com.ui.pages;

import com.constants.Browser;
import static com.constants.Environment.*;
import com.utility.BrowserUtility;
import com.utility.propertiesUtil;
import org.openqa.selenium.By;

public final class HomePage extends BrowserUtility {

    private final static By SignIn = By.className("login");;
    public HomePage(Browser browserName,boolean isHeadless)
    {
        super(browserName,isHeadless); //calling parent class(abstarct Browserutility) costructor form child class
        goToWebsite(propertiesUtil.readProperties(QA,"URL"));
    }

    public LoginPage goToLoginInPage()
    {
        clickOn(SignIn);
        LoginPage loginpage = new LoginPage(getDriver()); //create object of next page & pass the webdriver instance to that page with getDriver method
        return loginpage; //retun same
    }
}
//this page follows page object design pattern
//variables of this class are final i.e not change in nature i.e webelement or locator
//if variable is final then it should be static [class variable]
//all page classes extends broeserutility

//If parent class always mark as abstarct class.>>>>>>>>>>>>>
// hence all child class must be final >>>>>>>>>>>>>>
//Abstarct class can have constructor & when object of child class is created this constructor will be called with super keyword


//in POM design pattern void return type is not allowed
//for next navigating page we need to create object here only & return same page
// which accepts the parameter as webdriver