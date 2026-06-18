package com.listeners;
import com.utility.propertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import static com.constants.Environment.QA;

public class MyRetryAnalyzer implements IRetryAnalyzer{

        private static final int max_attempt = Integer.parseInt(propertiesUtil.readProperties(QA,"URL"));
        private static int current_attempt=1;

        public boolean retry (ITestResult result)
        {
                if(current_attempt<=max_attempt) //if it marks 1st time then again retry to run this TC
                {
                        current_attempt++;
                        return true;
                }
                return false;
        }
}

