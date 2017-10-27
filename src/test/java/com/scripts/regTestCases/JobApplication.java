package com.scripts.regTestCases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.ApplyForJobsBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.lib.commonFunction.Driver;

public class JobApplication extends Driver {

	String district, coverLetterTxt, answer, userName, password, userType,
			jobTitle;
	ApplyForJobsBL applyForJobsLib;
	ExcelLib excelData;
	LoginBL loginLib;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		// object initialization
		excelData = new ExcelLib();
		applyForJobsLib = new ApplyForJobsBL();
		loginLib = new LoginBL();
		userName = excelData.getExcelData("AddUser", 4, 3);
		password = excelData.getExcelData("AddUser", 4, 4);
		userType = excelData.getExcelData("AddUser", 4, 5);
		reports.startTest("Apply for Job as Candidate");
		loginLib.login(userName, password, userType);
	}

	//@Test(priority = 1)
	@Test
	public void applyForJobOpps() throws InvalidFormatException, Exception {
		district = excelData.getExcelData("JobApplication", 1, 1);
		jobTitle = excelData.getExcelData("DADJO", 1, 7);
		applyForJobsLib.applyJobByTitle(district, jobTitle);
		
		coverLetterTxt = excelData.getExcelData("JobApplication", 2, 2);
		applyForJobsLib.fillCoverLetter(coverLetterTxt);
		
		applyForJobsLib.fillDSPQ();
		
		applyForJobsLib.fillQQ();
		
		applyForJobsLib.affidavit();
	}

	/*@Test(priority = 2)
	public void fillCoverLetter() throws InvalidFormatException, Exception {
		coverLetterTxt = excelData.getExcelData("JobApplication", 2, 2);
		applyForJobsLib.fillCoverLetter(coverLetterTxt);
	}

	@Test(priority = 3)
	public void fillDSPQ() throws InvalidFormatException, Exception {
		applyForJobsLib.fillDSPQ();
	}

	@Test(priority = 4)
	public void fillQQ() throws Exception {
		applyForJobsLib.fillQQ();
	}

	@Test(priority = 5)
	public void affidavit() throws InterruptedException {
		applyForJobsLib.affidavit();
	}*/

	@AfterClass
	public void logout() throws InterruptedException {
		loginLib.logout();
	}
}
