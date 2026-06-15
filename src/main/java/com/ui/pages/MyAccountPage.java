package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BrowserUtility {

    private static final By USER_NAME= By.xpath("//a[@title='View my customer account']//span");

    public MyAccountPage(WebDriver browser)
    {
        super(browser);
    }

    public String findUsername()
    {
        return getVisibleText(USER_NAME);
    }



}
