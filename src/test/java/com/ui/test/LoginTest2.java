package com.ui.test;
import static com.constants.Browser.*;

import com.dataProvider.LoginDataProvider;
import com.listeners.TestListener;
import com.ui.pages.HomePage;
import static org.testng.Assert.*;

import org.testng.ITestListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class LoginTest2 {

        HomePage homePage;

        @BeforeMethod(description="load home page")
        public void setup()
        {
            homePage = new HomePage(CHROME,false);
        }

        @Test(description="verify valid user login" , groups ={"sanity","e2e"}, dataProvider= "LoginTestCSVDataProvider",
                dataProviderClass = LoginDataProvider.class,
                retryAnalyzer = com.listeners.MyRetryAnalyzer.class)
        public void homePageTest()
        {
            String userName = homePage.goToLoginInPage().doLogin("daniel.maxwell@comcast.net", "password").findUsername();
            assertEquals(userName,"Shruti Gore");
        }


}

//clean code writting:::::::::::::::::
//Tets class::::::::::

//Test script must be small
// you can not have conditional statement, looping statement,or try-catch in test method
//reduce local variables
//at least 1 assertion
