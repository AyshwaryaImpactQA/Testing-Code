package com.scripts.regTestCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scripts.businessLogic.DistrictJobOrderBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.SJobOrdersBL;
import com.scripts.lib.commonFunction.Driver;

public class TMManageDJO extends Driver {

	String username, password, userType, jobId, sheetName, jobDesc, jobTitle;
	DistrictJobOrderBL dJobOrdersLib;
	SJobOrdersBL sJobOrdersLib;
	LoginBL loginLib;
	Random randomGenerator;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		// object initialization
		dJobOrdersLib = new DistrictJobOrderBL();
		sJobOrdersLib = new SJobOrdersBL();
		loginLib = new LoginBL();
		randomGenerator = new Random();
		sheetName = "DistricJobOrder";
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 4);
		userType = excelData.getExcelData("Login", 1, 5);
		jobTitle = excelData.getExcelData(sheetName, 4, 7);
		jobId = excelData.getExcelData(sheetName, 4, 12);
		reports.startTest("Manage DJO with TM Admin");
		loginLib.login(username, password, userType);
		dJobOrdersLib.navigateToDistrictJobOrder();
	}

	@Test(priority = 1)
	public void editJob() throws Exception {
		jobDesc = "AutoGenDescritpion" + randomGenerator.nextInt(99999);
		sJobOrdersLib.editJob(jobId, jobDesc);
		excelData.setExcelData(sheetName, 4, 11, jobDesc);
	}

	@Test(priority = 2)
	public void cloneJob() throws Exception {
		sJobOrdersLib.cloneJob(jobId, sheetName, 6, jobTitle);
	}

	@Test(priority = 3)
	public void viewHistoryJob() throws Exception {
		sJobOrdersLib.viewHistoryJob(jobId);
	}

	@Test(priority = 4)
	public void deactivateJob() throws Exception {
		jobId = excelData.getExcelData(sheetName, 6, 12);
		sJobOrdersLib.deactivateJob(jobId);
	}

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}
}
