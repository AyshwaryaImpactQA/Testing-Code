package com.scripts.regTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.CandidatesPoolBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageDistPrivilegeBL;
import com.scripts.lib.commonFunction.Driver;

public class TMCandidatesPool extends Driver {

	LoginBL loginLib;
	ExcelLib excelData;
	CandidatesPoolBL candidatePoolLib;
	ManageDistPrivilegeBL mngDistPrivLib;
	String username, password, userType, fname, lname, email, district, school;

	@BeforeClass
	public void configClass() throws Exception {
		loginLib = new LoginBL();
		excelData = new ExcelLib();
		mngDistPrivLib = new ManageDistPrivilegeBL();
		candidatePoolLib = new CandidatesPoolBL();
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 4);     
		userType = excelData.getExcelData("Login", 1, 5);
		fname = excelData.getExcelData("AddUser", 1, 1);
		lname = excelData.getExcelData("AddUser", 1, 2);
		email = excelData.getExcelData("AddUser", 1, 3);
		district = excelData.getExcelData("SchoolJobOrder", 1, 4);
		school = excelData.getExcelData("SchoolJobOrder", 1, 5);
		reports.startTest("Candidate Pool through TM");
		loginLib.login(username, password, userType);
	}



	//@Test(priority = 2)
	
	@Test
	public void searchCandidate() throws Exception {
		candidatePoolLib.navigateToCandidatePoolPage();
		candidatePoolLib.searchCandidate(fname, lname, email, district, school);
		
			candidatePoolLib.activateDeactivateCandidate();
			
				candidatePoolLib.viewJobs(userType);
				
					candidatePoolLib.viewProfile();
	}
	/*	@Test(priority = 1)
	public void settingForDisplayedColumn() throws Exception {
		mngDistPrivLib.navigateToManageDistrictTM();
		 mngDistPrivLib.searchDistrict(district);
		 candidatePoolLib.settingForDisplayedColumn();
		 mngDistPrivLib.saveDistrict(); 
	}*/                                                      //Commented for sanity
	/*@Test(priority = 3)
	public void activateDeactivateCandidate() throws Exception {
		candidatePoolLib.activateDeactivateCandidate();
	}

	@Test(priority = 4)
	public void engageActions() throws Exception {
		candidatePoolLib.engageActions();
	}
                                  //Commented for sanity
	@Test(priority = 5)
	public void viewJobs() throws Exception {
		candidatePoolLib.viewJobs(userType);
	}

	@Test(priority = 6)
	public void viewProfile() throws Exception {
		candidatePoolLib.viewProfile();
	}*/

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}

}
