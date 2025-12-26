package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	    private int retryCount = 0;
	    private final int maxRetry = 1; // retry once

	    @Override
	    public boolean retry(ITestResult result) {
	        if (retryCount < maxRetry) {
	            retryCount++;
	            return true;
	        }
	        return false;
	    }
	}


