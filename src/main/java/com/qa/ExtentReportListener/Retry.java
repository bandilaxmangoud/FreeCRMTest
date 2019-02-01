package com.qa.ExtentReportListener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.crm.qa.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Retry implements IRetryAnalyzer {

	private int count = 0;
    private static int maxTry = 1; //Run the failed test 2 times
    
	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {                      //Check if test not succeed
            if (count < maxTry) {                            //Check if maxtry count is reached
                count++;                                     //Increase the maxTry count by 1
                result.setStatus(ITestResult.FAILURE);  //Mark test as failed
                extendReportsFailOperations(result);    //ExtentReports fail operations
                return true;                                 //Tells TestNG to re-run the test
            }
        } else {
        	result.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
	}

	private void extendReportsFailOperations(ITestResult result) {
		Object testClass = result.getInstance();
		WebDriver webDriver = ((TestBase) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		
	}

}
