package com.scripts.regTestCases;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scripts.businessLogic.AccountVerificationBL;
import com.scripts.businessLogic.CandidateSignUpBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.lib.commonFunction.Driver;

import utils.load.dataSource.ExcelLib;

public class CandidateSignUp extends Driver {

	String firstName, lastName, userName, password, userType;
	int rowCount;
	CandidateSignUpBL canSignUpLib;
	AccountVerificationBL accountVerificationLib;
	LoginBL loginLib;
	ExcelLib excelData;
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(9999);

	@BeforeClass
	public void configBeforeClass() throws InvalidFormatException, IOException {
		// object initialization
		canSignUpLib = new CandidateSignUpBL();
		accountVerificationLib = new AccountVerificationBL();
		loginLib = new LoginBL();
		excelData = new ExcelLib();
		rowCount = excelData.getRowCount("AddUser");
		firstName = "test" + randomInt;
		lastName = "candidate" + randomInt;
		userName = firstName + "@yopmail.com";
		excelData.setExcelData("AddUser", 4, 1, firstName);
		excelData.setExcelData("AddUser", 4, 2, lastName);
		excelData.setExcelData("AddUser", 4, 3, userName);
		reports.startTest("Candidate Sign Up");
	}

	@Test
	public void candidateSignUp() throws Exception {
		password = excelData.getExcelData("AddUser", 4, 4);
		canSignUpLib.candidateSignUp(firstName, lastName, userName, password);
/*	}

	@Test(priority = 2)
	public void candidateAccVerification() throws Exception {*/
		userName = excelData.getExcelData("AddUser", 4, 3);
		accountVerificationLib.accountVerificationCandidate(userName);
/*	}

	@Test(priority = 3)
	public void candiateLogin() throws Exception {*/
		userName = excelData.getExcelData("AddUser", 4, 3);
		password = excelData.getExcelData("AddUser", 4, 4);
		userType = excelData.getExcelData("AddUser", 4, 5);
		loginLib.login(userName, password, userType);
	}

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}

}
