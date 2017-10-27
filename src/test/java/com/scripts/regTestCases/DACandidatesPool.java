package com.scripts.regTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.CandidatesPoolBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.lib.commonFunction.Driver;

public class DACandidatesPool extends Driver {

	LoginBL loginLib;
	ExcelLib excelData;
	CandidatesPoolBL candidatePoolLib;
	String username, password, userType, fname, lname, email, district, school;

	@BeforeClass
	public void configClass() throws Exception {
		loginLib = new LoginBL();
		excelData = new ExcelLib();
		candidatePoolLib = new CandidatesPoolBL();
		username = excelData.getExcelData("Login", 3, 1);
		password = excelData.getExcelData("Login", 3, 2);
		userType = excelData.getExcelData("Login", 3, 3);
		fname = excelData.getExcelData("AddUser", 4, 1);
		lname = excelData.getExcelData("AddUser", 4, 2);
		email = excelData.getExcelData("AddUser", 4, 3);
		district = excelData.getExcelData("SchoolJobOrder", 2, 4);
		school = excelData.getExcelData("SchoolJobOrder", 2, 5);
		reports.startTest("Candidate Pool through DA");
		loginLib.login(username, password, userType);
		candidatePoolLib.navigateToCandidatePoolPage();
	}

	//@Test(priority = 1)
	@Test
	public void searchCandidate() throws Exception {
		candidatePoolLib.searchCandidate(fname, lname, email, district, school);
		
		candidatePoolLib.viewJobs(userType);
	
		candidatePoolLib.addCandidateToOtherJob();

		candidatePoolLib.viewProfile();
		candidatePoolLib.applyActions();
	}

	/*@Test(priority = 2)
	public void viewJobs() throws Exception {
		candidatePoolLib.viewJobs(userType);
	}

	@Test(priority = 3)
	public void addCandidateToOtherJob() throws Exception {
		candidatePoolLib.addCandidateToOtherJob();
	}

	@Test(priority = 4)
	public void viewProfile() throws Exception {
		candidatePoolLib.viewProfile();
	}

	@Test(priority = 5)
	public void applyActions() throws Exception {
		candidatePoolLib.applyActions();
	}*/

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}
}
