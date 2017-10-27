package com.scripts.regTestCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.DistrictJobOrderBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.lib.commonFunction.Driver;

public class TMDistJobOrder extends Driver {
	String username, password, userType, districtName, schoolName, zone, jobTitle, jobType, jobCategory, expectedHire,
			jobDecription, requisitionNumber, redirectURL, sheetName, jobApprovalProcess, isHidden, refNo;
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
		sheetName = "DistricJobOrder";
		loginLib = new LoginBL();
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 4);
		userType = excelData.getExcelData("Login", 1, 5);
		reports.startTest("District Job Order with TM Admin");
		loginLib.login(username, password, userType);
	}

/*	@Test(priority = 1)
	public void downloadExcel() throws Exception {
		districtName = excelData.getExcelData(sheetName, 1, 4);
		dJobOrdersLib.dwldExcel(districtName);
	}
*/
	// public void downloadPDF() throws Exception {
	// sJobOrdersLib.dwnldPDF();
	// }

	//@Test(priority = 2)
	@Test
	public void createJobWithPostingEndDate() throws Exception {
		rowNum = 3;
		excelData.setExcelData(sheetName, rowNum, 7, "AutoGenTitle" + randomGenerator.nextInt(99999));
		excelData.setExcelData(sheetName, rowNum, 11, "AutoGenDescritpion" + randomGenerator.nextInt(99999));
		excelData.setExcelData(sheetName, rowNum, 17, "AutoRefNo" + randomGenerator.nextInt(99999));
		districtName = excelData.getExcelData(sheetName, rowNum, 4);
		schoolName = excelData.getExcelData(sheetName, rowNum, 5);
		zone = excelData.getExcelData(sheetName, rowNum, 6);
		jobTitle = excelData.getExcelData(sheetName, rowNum, 7);
		jobType = excelData.getExcelData(sheetName, rowNum, 8);
		jobCategory = excelData.getExcelData(sheetName, rowNum, 9);
		expectedHire = excelData.getExcelData(sheetName, rowNum, 10);
		jobDecription = excelData.getExcelData(sheetName, rowNum, 11);
		randomNumber = randomGenerator.nextInt(999999);
		requisitionNumber = "" + randomNumber;
		excelData.setExcelData(sheetName, rowNum, 13, requisitionNumber);
		redirectURL = excelData.getExcelData(sheetName, rowNum, 14);
		jobApprovalProcess = excelData.getExcelData(sheetName, rowNum, 15);
		isHidden = excelData.getExcelData(sheetName, rowNum, 16);
		refNo = excelData.getExcelData(sheetName, rowNum, 17);

		dJobOrdersLib.createJobWithEndDate(districtName, schoolName, zone, jobTitle, jobType, jobCategory, expectedHire,
				jobDecription, requisitionNumber, sheetName, redirectURL, jobApprovalProcess, isHidden, refNo, rowNum);
	}
/*
	@Test(priority = 3)
	public void createJobWithUntillFilled() throws Exception {
		rowNum = 4;
		excelData.setExcelData(sheetName, rowNum, 7, "AutoGenTitle" + randomGenerator.nextInt(99999));
		excelData.setExcelData(sheetName, rowNum, 11, "AutoGenDescritpion" + randomGenerator.nextInt(99999));
		excelData.setExcelData(sheetName, rowNum, 17, "AutoRefNo" + randomGenerator.nextInt(99999));
		districtName = excelData.getExcelData(sheetName, rowNum, 4);
		schoolName = excelData.getExcelData(sheetName, rowNum, 5);
		zone = excelData.getExcelData(sheetName, rowNum, 6);
		jobTitle = excelData.getExcelData(sheetName, rowNum, 7);
		jobType = excelData.getExcelData(sheetName, rowNum, 8);
		jobCategory = excelData.getExcelData(sheetName, rowNum, 9);
		expectedHire = excelData.getExcelData(sheetName, rowNum, 10);
		jobDecription = excelData.getExcelData(sheetName, rowNum, 11);
		randomNumber = randomGenerator.nextInt(999999);
		requisitionNumber = "" + randomNumber;
		excelData.setExcelData(sheetName, rowNum, 13, requisitionNumber);
		redirectURL = excelData.getExcelData(sheetName, rowNum, 14);
		jobApprovalProcess = excelData.getExcelData(sheetName, rowNum, 15);
		isHidden = excelData.getExcelData(sheetName, rowNum, 16);
		refNo = excelData.getExcelData(sheetName, rowNum, 17);

//		dJobOrdersLib.createJobWithUntillEnd(districtName, schoolName, zone, jobTitle, jobType, jobCategory,
//				expectedHire, jobDecription, requisitionNumber, sheetName, redirectURL, jobApprovalProcess, isHidden,
//				refNo, rowNum);
	}*/

//	@Test(priority = 4)
//	public void createJobWithAttachSchool() throws Exception {
//		rowNum = 7;
//		excelData.setExcelData(sheetName, rowNum, 7, "AutoGenTitle" + randomGenerator.nextInt(99999));
//		excelData.setExcelData(sheetName, rowNum, 11, "AutoGenDescritpion" + randomGenerator.nextInt(99999));
//		excelData.setExcelData(sheetName, rowNum, 17, "AutoRefNo" + randomGenerator.nextInt(99999));
//		districtName = excelData.getExcelData(sheetName, rowNum, 4);
//		schoolName = excelData.getExcelData(sheetName, rowNum, 5);
//		zone = excelData.getExcelData(sheetName, rowNum, 6);
//		jobTitle = excelData.getExcelData(sheetName, rowNum, 7);
//		jobType = excelData.getExcelData(sheetName, rowNum, 8);
//		jobCategory = excelData.getExcelData(sheetName, rowNum, 9);
//		expectedHire = excelData.getExcelData(sheetName, rowNum, 10);
//		jobDecription = excelData.getExcelData(sheetName, rowNum, 11);
//		randomNumber = randomGenerator.nextInt(999999);
//		requisitionNumber = "" + randomNumber;
//		excelData.setExcelData(sheetName, rowNum, 13, requisitionNumber);
//		redirectURL = excelData.getExcelData(sheetName, rowNum, 14);
//		jobApprovalProcess = excelData.getExcelData(sheetName, rowNum, 15);
//		refNo = excelData.getExcelData(sheetName, rowNum, 17);
//
//		dJobOrdersLib.createJobWithAttachSchool(districtName, schoolName, zone, jobTitle, jobType, jobCategory,
//				expectedHire, jobDecription, requisitionNumber, sheetName, redirectURL, jobApprovalProcess, refNo,
//				rowNum);
//	}

	@AfterClass
	public void logout() throws InterruptedException {
		loginLib.logout();
	}
}
