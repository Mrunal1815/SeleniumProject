package CommonUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	
	ExtentReports reports;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		System.out.println("Test Scrpit execution is started");
		
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName +" Test Scrpit execution is started",true);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
//		System.out.println("Test Scrpit execution is passed");
		
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+ " Test Scrpit execution is passed",true);
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
//		System.out.println("Test Scrpit execution is failed");
		
		String msg = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName +" Test Scrpit execution is failed "+msg,true);
		
		WebDriverUtil driverUtil = new WebDriverUtil();
		try {
			driverUtil.screenshot(null, "contact");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
//		System.out.println("Test Scrpit execution is skipped");
		
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName +" Test Scrpit execution is skipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
//		System.out.println("To start the execution");
//		Reporter.log("To start the execution");
		
//		to generate random number
		JavaUtil util = new JavaUtil();
		int num = util.getRandomNumber();
		
//		use ExtentSparkReporter class just to configure extentReport
		ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReport/Report"+num+".html");
		reporter.config().setDocumentTitle("VTigerCRM");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("Organization");
		
//		To generate extent report we are used ExtentReports
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
//		To set extra info call method setSystemInfo()
		reports.setSystemInfo("OS", "Window");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Chromeversion", "121");
		reports.setSystemInfo("Author", "Mrunal");
	}

	@Override
	public void onFinish(ITestContext context) {
//		System.out.println("To finish the execution");
//		Reporter.log("To finish the execution",true);
//		reports = new ExtentReports();
		reports.flush();
	}
	
}
