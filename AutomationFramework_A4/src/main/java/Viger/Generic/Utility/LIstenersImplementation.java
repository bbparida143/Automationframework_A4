package Viger.Generic.Utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LIstenersImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "..started..");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "..success..");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "..failed..");
		WebDriverUtility wutil = new WebDriverUtility(); //for screenshot and listeners
		JavaFileUtility jutil = new JavaFileUtility();  // for date and time
		//for listeners
	 String screenshotname = methodName+"-"+jutil.toGetSystemdate();
	    try {
			wutil.toTakeScreenshotOfWebPage(VtigerBaseClass.driver1, screenshotname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "..skipped..");
	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("..suite execution started..");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("...suite execution ended...");
	}

}
