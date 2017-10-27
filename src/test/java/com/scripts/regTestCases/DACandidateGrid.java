package com.scripts.regTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.CandidateGridBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.lib.commonFunction.Driver;

public class DACandidateGrid extends Driver {
	String jobTitle, jobID, firstName, lastName, email, username, password,
			userType;
	CandidateGridBL candidateGridLib;
	ExcelLib excelData;
	LoginBL loginLib;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		candidateGridLib = new CandidateGridBL();
		excelData = new ExcelLib();
		loginLib = new LoginBL();
		username = excelData.getExcelData("Login", 3, 1);
		password = excelData.getExcelData("Login", 3, 4);
		userType = excelData.getExcelData("Login", 3, 5);
		reports.startTest("Candidate Profile Through Candidate Grid as District Admin");
		loginLib.login(username, password, userType);
	}

	@Test
	public void candidateProfileThroughCG() throws Exception {
		jobTitle = excelData.getExcelData("DADJO", 1, 7);
		firstName = excelData.getExcelData("AddUser", 4, 1);
		lastName = excelData.getExcelData("AddUser", 4, 2);
		email = excelData.getExcelData("AddUser", 4, 3);
		jobID = excelData.getExcelData("DADJO", 1, 12);
		candidateGridLib.candidateProfileThroughCG(jobTitle, jobID, firstName,
				lastName, email, userType);
	}

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}
}
