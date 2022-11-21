package com.hrm.hr.genericutility;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListenersImplementation implements ITestListener {
	ExtentReports htmlreport;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test = htmlreport.createTest(MethodName);
		Reporter.log(MethodName+"----TestScript Execution Started----");
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"----Executed Succesfully----");
		Reporter.log(MethodName);
		
		
		
	}

	public void onTestFailure(ITestResult result) {
		String Failedscript=result.getMethod().getMethodName();
		String date = Failedscript+new Java_Utility().getSystemDateAndTimeInFormat();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		File dest= new File(".\\screenshot\\"+date+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP,MethodName+"---> Skipped");
		test.log(Status.SKIP,result.getThrowable());
		Reporter.log(MethodName+"---Script Skipped---");
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter report = new ExtentSparkReporter(".\\ExtentReport\\report.html");
		report.config().setDocumentTitle("HRM Systems-Execution Report");
		report.config().setTheme(Theme.DARK);
		report.config().setReportName("HRM Execution Report");
		
		htmlreport=new ExtentReports();
		htmlreport.attachReporter(report);
		htmlreport.setSystemInfo("Base Browser", "Chrome");
		htmlreport.setSystemInfo("OS","Windows");
		htmlreport.setSystemInfo("Base_URL","http://rmgtestingserver/domain/HRM_System/");
		htmlreport.setSystemInfo("Reporter Name","Abhishekh B S");
		
		
		
	
	}

	public void onFinish(ITestContext context) {
		
		//consolidate all the parameter 
		htmlreport.flush();
		
	}
	
	

}
