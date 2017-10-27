package com.scripts.regTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.CandidateDashboardBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.lib.commonFunction.Driver;

public class CandidateDashboard extends Driver {

	String userName, password, userType;
	ExcelLib excelData;
	LoginBL loginLib;
	CandidateDashboardBL candidateDashboardLib;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		// object initialization
		loginLib = new LoginBL();
		excelData = new ExcelLib();
		candidateDashboardLib = new CandidateDashboardBL();
		userName = excelData.getExcelData("AddUser", 4, 3);
		password = excelData.getExcelData("AddUser", 4, 4);
		userType = excelData.getExcelData("AddUser", 4, 5);
		reports.startTest("Dashboard Page from Candidate");
		loginLib.login(userName, password, userType);
	}

	@Test
	public void verifyPersonalPlanningRedirections() throws Exception {
		candidateDashboardLib.verifyPersonalPlanningSection();
		candidateDashboardLib.verifyCommunicationSection();
		candidateDashboardLib.verifyJobsOfInterestSection();
		candidateDashboardLib.verifyJobApplicationSection();
	}

	/*@Test(priority = 2)
	public void verifyCommunicationSection() throws Exception {
		candidateDashboardLib.verifyCommunicationSection();
	}

	@Test(priority = 3)
	public void verifyJobsOfInterestSection() throws Exception {
		candidateDashboardLib.verifyJobsOfInterestSection();
	}

	@Test(priority = 4)
	public void verifyJobApplicationSection() throws Exception {
		candidateDashboardLib.verifyJobApplicationSection();
	}*/
	

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}

}
