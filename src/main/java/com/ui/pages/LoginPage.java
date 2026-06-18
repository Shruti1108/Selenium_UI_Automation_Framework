package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BrowserUtility {

    private final static By EMAIL = By.id("email");
    private final static By PASSWORD = By.id("passwd");
    private final static By SUBMIT_LOGIN = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    public MyAccountPage doLogin(String email, String password)
    {
        enterText(EMAIL,email);
        enterText(PASSWORD,password);
        clickOn(SUBMIT_LOGIN);

        MyAccountPage myAccountpage = new MyAccountPage(getDriver());
        return myAccountpage;
    }



}
