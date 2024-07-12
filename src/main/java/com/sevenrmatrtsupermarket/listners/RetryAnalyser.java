package com.sevenrmatrtsupermarket.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 2;

	@Override//used for test case retry
	public boolean retry(ITestResult result) {

		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}
}
