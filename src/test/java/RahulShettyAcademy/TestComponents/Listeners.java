package RahulShettyAcademy.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import RahulShettyAcademy.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();

	@Override
	public void onTestStart(ITestResult result)
	{
		test=extent.createTest(result.getMethod().getMethodName());	
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, "Test passed");
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
//		test.log(Status.FAIL, "Test failed");
		//or we can use test.fail coz we dont just want to see test is failed
		//we want to know the reason also
		test.fail(result.getThrowable());
		
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

		
		//take screenshot, then attach to report
		String filePath=null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		System.out.println("Test Failed: " +result.getMethod().getMethodName());

	}
	@Override
	public void onTestSkipped(ITestResult result)
	{
		
	}
	
	@Override
	public void onStart(ITestContext context)
	{
		
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}

}
