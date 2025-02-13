package FrameWrokTesting.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import frameWrokTesting.globalComponents.ExtentReportsNG;
import frameWrokTesting.utilities.GenericMethods;


public class Listener  implements ITestListener  {
	WebDriver driver;
	

	ExtentTest test;
	ExtentReports extent = ExtentReportsNG.getReports();
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
//		File screenshot = (File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String filePath= System.getProperty("user.dir")+"//reports//"+result.getMethod().getMethodName()+".png";
//		try {
//			FileUtils.copyFile(screenshot, new File(filePath));
//			test.addScreenCaptureFromPath(filePath);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+" Test Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
