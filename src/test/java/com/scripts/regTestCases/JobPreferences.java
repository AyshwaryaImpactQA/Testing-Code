package com.scripts.regTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.JobPreferencesBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.lib.commonFunction.Driver;

public class JobPreferences extends Driver{

	JobPreferencesBL jobPerferenceLib;
	String userName, password, userType, gender;
	ExcelLib excelData;
	LoginBL loginLib;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		// object initialization
		jobPerferenceLib = new JobPreferencesBL();
		loginLib = new LoginBL();
		excelData = new ExcelLib();
		userName = excelData.getExcelData("AddUser", 4, 3);
		password = excelData.getExcelData("AddUser", 4, 4);
		userType = excelData.getExcelData("AddUser", 4, 5);
		reports.startTest("Job Preference for Candidate");
		loginLib.login(userName, password, userType);
	}

	//@Test(priority = 1)
	@Test
	public void setJobPreferences() throws Exception {
		jobPerferenceLib.setJobPreferences();
	}

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}

}
