package com.scripts.regTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.CandidateGridBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.lib.commonFunction.Driver;

public class TMCandidateGrid extends Driver {
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
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 4);
		userType = excelData.getExcelData("Login", 1, 5);
		reports.startTest("Candidate Profile Through Candidate Grid as TM Admin");
		loginLib.login(username, password, userType);
	}

	@Test
	public void candidateProfileThroughCG() throws Exception {
		jobTitle = excelData.getExcelData("DistricJobOrder", 7, 7);
		firstName = excelData.getExcelData("AddUser", 4, 1);
		lastName = excelData.getExcelData("AddUser", 4, 2);
		email = excelData.getExcelData("AddUser", 4, 3);
		jobID = excelData.getExcelData("DistricJobOrder", 7, 12);
		candidateGridLib.TMcandidateProfileThroughCG(jobTitle, jobID, firstName,
				lastName,  email, userType);
	}

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}
}
