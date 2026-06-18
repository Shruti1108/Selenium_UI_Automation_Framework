package com.utility;

import com.constants.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BrowserUtility {

    private static WebDriver driver;
    //private WebDriverWait wait=null;

    public static WebDriver getDriver() { //use to pass the driver session from one class or page to another
        return DriverManager.getDriver();
    }

    public BrowserUtility(WebDriver driver) {
        super(); // call parent class constructor from child class
        this.driver = DriverManager.getDriver(); //initialize instance variable driver
    }

    public BrowserUtility(Browser browserName, boolean isHeadless) {
        if (browserName == Browser.CHROME) {
            if (isHeadless) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");}
            else
                driver = new ChromeDriver();

            } else if (browserName == Browser.FIREFOX) {

            if (isHeadless) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=old");
                edgeOptions.addArguments("disable-gpu");}
            else
                driver = new FirefoxDriver();
            } else {
                System.out.println("Browser Not Found");
            }
        }


        public void goToWebsite (String url)
        {
            driver.get(url);
        }
        public void clickOn (By locator)
        {
            WebElement element = DriverManager.getDriver().findElement(locator);
            element.click();
        }

        public void enterText (By locator, String text)
        {
            WebElement element = DriverManager.getDriver().findElement(locator);
            element.sendKeys(text);
        }

        public String getVisibleText (By locator)
        {

            WebElement element = DriverManager.getDriver().findElement(locator);
            return element.getText();
        }
    }
//will just pass the driver during object creation via constructor  creation here to call the methods of this class
//object must be created in multiple ways

//findElement() accepts By as an argument and return WebElement
//this method is not sync, wont wait for element to appear so better use Webdriver wait
//driver.manage().window().maximize() -> use on AL type of browsers not specific to any 1  & used after the browser is launched