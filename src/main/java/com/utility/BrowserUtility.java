package com.utility;

import com.constants.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BrowserUtility {

    private WebDriver driver;
    private WebDriverWait wait=null;

    public WebDriver getDriver() { //use to pass the driver session from one class or page to another
        return driver;
    }

    public BrowserUtility(WebDriver driver)
    {
        super(); // call parent class constructor from child class
        this.driver = driver; //initialize instance variable driver
    }
    public BrowserUtility(String browser)
    {
        if(browser.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else
        {
            System.out.println("Browser Not Found");
        }
    }

    public BrowserUtility(Browser browserName)
    {
        if(browserName==Browser.CHROME)
        {
            driver = new ChromeDriver();
        }
        else if(browserName==Browser.FIREFOX)
        {
            driver = new FirefoxDriver();
        }
        else
        {
            System.out.println("Browser Not Found");
        }
    }


    public void goToWebsite(String url)
    {
        driver.get(url);
    }
    public void clickOn(By locator)
    {
        WebElement element = driver.findElement(locator);
        element.click();
    }

        public void enterText(By locator, String text)
    {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public String getVisibleText(By locator)
    {

        WebElement element = driver.findElement(locator);
        return element.getText();
    }
}
//will just pass the driver during ojecct  via constructor  creation here to call the methods of this class
//object must be created in multiple ways

//findElement() accepts By as an argument and return WebElement
//this method is not sync, wont wait for element to appear so better use Webdriver wait
//driver.manage().window().maximize() -> use on AL type of browsers not specific to any 1  & used after the browser is launched