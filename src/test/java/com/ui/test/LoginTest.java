package com.ui.test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static com.constants.Browser.*;

public class LoginTest {

    public static void main(String[] args) {

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--incognoto");
        option.addArguments("--start-maximized");
        option.addArguments("--block-pop-up");

        WebDriver driver = new ChromeDriver(option); //real browser(object) session is created. With looses coupling
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        HomePage homePage = new HomePage(CHROME,false);
        homePage.goToLoginInPage();



    }
}

//findElement() accepts By as an argument and return WebElement
//this method is not sync, wont wait for element to appear so better use Webdriver wait
//driver.manage().window().maximize() -> use on AL type of browsers not specific to any 1  & used after the browser is launched

