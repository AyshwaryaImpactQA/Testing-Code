package com.scripts.regTestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.scripts.lib.commonFunction.Driver;

public class HomePage extends Driver {

	@Test
	public void homeBase() throws Exception {
		preConfigure();
		configureBase();
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}
