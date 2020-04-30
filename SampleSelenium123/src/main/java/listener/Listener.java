package listener;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.common.eventbus.AllowConcurrentEvents;

public class Listener implements ITestListener {

	@Override 
	public void onTestStart(ITestResult result) {
    	System.out.println(getmethodename(result)+": test case started");
		Reporter.log(getmethodename(result)+": test case started");
	}

	@Override 
	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase passed is: "+getmethodename(result));
		Reporter.log("The name of the testcase passed is: "+getmethodename(result));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is: "+getmethodename(result));
		Reporter.log("The name of the testcase failed is: "+getmethodename(result));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase skipped is: "+getmethodename(result));
		Reporter.log("The name of the testcase skipped is: "+getmethodename(result));
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
		// TODO Auto-generated method stub
		
	}
	private static String getmethodename(ITestResult result) {
		return result.getMethod().getConstructorOrMethod().getName();
	}

}
