package com.listeners;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import MavenDemo.BizgazeMaven.SetupClass;

public class Listeners extends SetupClass implements ITestListener
{
	WebDriver driver=null;

	public void onFinish(ITestContext arg0)
	{
		System.out.println("test finished");
	}
	public void onStart(ITestContext arg0)
	{
		System.out.println("test started");
	}
	public void onTestFailedButWithSuccessPercentage(ITestResult arg0)
	{
		System.out.println("test failed with some success percentage");
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("error"+result.getName()+"test has failed");
		screenshot();

	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

}
