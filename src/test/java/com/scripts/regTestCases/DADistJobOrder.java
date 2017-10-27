package com.scripts.regTestCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.DistrictJobOrderBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.lib.commonFunction.Driver;

public class DADistJobOrder extends Driver {
	String username, password, userType, districtName, schoolName, zone,
			jobTitle, jobType, jobCategory, expectedHire, jobDecription,
			requisitionNumber, redirectURL, sheetName, jobApprovalProcess,
			isHidden, refNo;
	
	int rowNum, randomNumber;
	DistrictJobOrderBL dJobOrdersLib;
	LoginBL loginLib;
	ExcelLib excelData;
	Random randomGenerator;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		// object initialization
		dJobOrdersLib = new DistrictJobOrderBL();
		excelData = new ExcelLib();
		randomGenerator = new Random();
		sheetName = "DADJO";
		loginLib = new LoginBL();
		username = excelData.getExcelData("Login", 3, 1);
		password = excelData.getExcelData("Login", 3, 4);
		userType = excelData.getExcelData("Login", 3, 5);
		reports.startTest("District Job Order with District Admin");
		loginLib.login(username, password, userType);

	}

	//@Test(priority = 1)
	@Test
	public void downloadEXCEL() throws Exception {
		districtName = excelData.getExcelData(sheetName, 1, 4);
		 dJobOrdersLib.dwldExcel(districtName);
		 
		 rowNum = 1;
			excelData.setExcelData(sheetName, rowNum, 7, "AutoGenTitle"
					+ randomGenerator.nextInt(99999));
			excelData.setExcelData(sheetName, rowNum, 11, "AutoGenDescritpion"
					+ randomGenerator.nextInt(99999));
			excelData.setExcelData(sheetName, rowNum, 17, "AutoRefNo"
					+ randomGenerator.nextInt(99999));
			districtName = excelData.getExcelData(sheetName, 1, 4);
			schoolName = excelData.getExcelData(sheetName, 1, 5);
			zone = excelData.getExcelData(sheetName, 1, 6);
			jobTitle = excelData.getExcelData(sheetName, 1, 7);
			jobType = excelData.getExcelData(sheetName, 1, 8);
			jobCategory = excelData.getExcelData(sheetName, 1, 9);
			expectedHire = excelData.getExcelData(sheetName, 1, 10);
			jobDecription = excelData.getExcelData(sheetName, 1, 11);
			randomNumber = randomGenerator.nextInt(999999);
			requisitionNumber = "" + randomNumber;
			excelData.setExcelData(sheetName, rowNum, 13, requisitionNumber);
			redirectURL = excelData.getExcelData(sheetName, rowNum, 14);
			jobApprovalProcess = excelData.getExcelData(sheetName, rowNum, 15);
			isHidden = excelData.getExcelData(sheetName, rowNum, 16);
			refNo = excelData.getExcelData(sheetName, rowNum, 17);
	        dJobOrdersLib.createJobWithEndDate(districtName, schoolName, zone,
					jobTitle, jobType, jobCategory, expectedHire, jobDecription,
					requisitionNumber, sheetName, redirectURL, jobApprovalProcess,
					isHidden, refNo, rowNum);
	}

	// public void downloadPDF() throws Exception {
	// dJobOrdersLib.dwnldPDF();
	// }

	/*@Test(priority = 2)
	//Updated rowNum from 3 to 1
	public void createSchoolJobWithPostingEndDate() throws Exception {
		rowNum = 1;
		excelData.setExcelData(sheetName, rowNum, 7, "AutoGenTitle"
				+ randomGenerator.nextInt(99999));
		excelData.setExcelData(sheetName, rowNum, 11, "AutoGenDescritpion"
				+ randomGenerator.nextInt(99999));
		excelData.setExcelData(sheetName, rowNum, 17, "AutoRefNo"
				+ randomGenerator.nextInt(99999));
		districtName = excelData.getExcelData(sheetName, 1, 4);
		schoolName = excelData.getExcelData(sheetName, 1, 5);
		zone = excelData.getExcelData(sheetName, 1, 6);
		jobTitle = excelData.getExcelData(sheetName, 1, 7);
		jobType = excelData.getExcelData(sheetName, 1, 8);
		jobCategory = excelData.getExcelData(sheetName, 1, 9);
		expectedHire = excelData.getExcelData(sheetName, 1, 10);
		jobDecription = excelData.getExcelData(sheetName, 1, 11);
		randomNumber = randomGenerator.nextInt(999999);
		requisitionNumber = "" + randomNumber;
		excelData.setExcelData(sheetName, rowNum, 13, requisitionNumber);
		redirectURL = excelData.getExcelData(sheetName, rowNum, 14);
		jobApprovalProcess = excelData.getExcelData(sheetName, rowNum, 15);
		isHidden = excelData.getExcelData(sheetName, rowNum, 16);
		refNo = excelData.getExcelData(sheetName, rowNum, 17);
        dJobOrdersLib.createJobWithEndDate(districtName, schoolName, zone,
				jobTitle, jobType, jobCategory, expectedHire, jobDecription,
				requisitionNumber, sheetName, redirectURL, jobApprovalProcess,
				isHidden, refNo, rowNum);
	}*/

//	@Test(priority = 3)
//	public void createSchoolJobWithUntillFilled() throws Exception {
//		// Changing rowNum 4 to 2
//		rowNum = 2;
//		excelData.setExcelData(sheetName, rowNum, 7, "AutoGenTitle"
//				+ randomGenerator.nextInt(99999));
//		excelData.setExcelData(sheetName, rowNum, 11, "AutoGenDescritpion"
//				+ randomGenerator.nextInt(99999));
//		excelData.setExcelData(sheetName, rowNum, 17, "AutoRefNo"
//				+ randomGenerator.nextInt(99999));
//		districtName = excelData.getExcelData(sheetName, 2, 4);
//		schoolName = excelData.getExcelData(sheetName, 2, 5);
//		zone = excelData.getExcelData(sheetName, 2, 6);
//		jobTitle = excelData.getExcelData(sheetName, 2, 7);
//		jobType = excelData.getExcelData(sheetName, 2, 8);
//		jobCategory = excelData.getExcelData(sheetName, 2, 9);
//		expectedHire = excelData.getExcelData(sheetName, 2, 10);
//		jobDecription = excelData.getExcelData(sheetName, 2, 11);
//		randomNumber = randomGenerator.nextInt(999999);
//		requisitionNumber = "" + randomNumber;
//		excelData.setExcelData(sheetName, 2, 13, requisitionNumber);
//		redirectURL = excelData.getExcelData(sheetName, 2, 14);
//		jobApprovalProcess = excelData.getExcelData(sheetName, 2, 15);
//		isHidden = excelData.getExcelData(sheetName, 2, 16);
//		refNo = excelData.getExcelData(sheetName, 2, 17);
		/*dJobOrdersLib.createJobWithUntillEnd(districtName, schoolName, zone,
				jobTitle, jobType, jobCategory, expectedHire, jobDecription,
				requisitionNumber, sheetName, redirectURL, jobApprovalProcess,
				isHidden, refNo, rowNum);*/
//	}

	@AfterClass
	public void logout() throws InterruptedException {
		loginLib.logout();
	}
}
