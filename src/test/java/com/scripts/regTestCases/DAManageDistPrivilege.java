package com.scripts.regTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageDistPrivilegeBL;
import com.scripts.lib.commonFunction.Driver;

public class DAManageDistPrivilege extends Driver {

	String tmUsername, tmPassword, tmUserType, district, daUsername,
			daPassword, daUserType, sheetName, jobCategory,
			setQQSetToJobCategory, jobCategoryForQQ, jobId, candidateMailId;
	int rowNum;
	ManageDistPrivilegeBL mngDistPrivLib;
	ExcelLib excelData;
	LoginBL loginLib;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		excelData = new ExcelLib();
		loginLib = new LoginBL();
		mngDistPrivLib = new ManageDistPrivilegeBL();
		tmUsername = excelData.getExcelData("Login", 1, 1);
		tmPassword = excelData.getExcelData("Login", 1, 2);
		tmUserType = excelData.getExcelData("Login", 1, 3);
		daUsername = excelData.getExcelData("Login", 3, 1);
		daPassword = excelData.getExcelData("Login", 3, 4);
		daUserType = excelData.getExcelData("Login", 3, 5);
		district = excelData.getExcelData("District", 2, 4);
		reports.startTest("Manage District Privilege with District Admin");
	}

	@Test(priority = 1)
	public void editDistrict() throws Exception {
		loginLib.login(daUsername, daPassword, daUserType);
		mngDistPrivLib.navigateToManageDistrictDA();
		mngDistPrivLib.editDistrict(district);
	}

	@Test(priority = 2)
	public void candidatePoolPermission() throws Exception {
		mngDistPrivLib.candidatePoolPermission(daUserType, district);
		loginLib.logout();
		loginLib.login(daUsername, daPassword, daUserType);
		mngDistPrivLib.verifyCandidatePoolPermission();
	}

	@Test(priority = 3)
	public void jobOrderViewPermissionAllDA() throws Exception {
		loginLib.login(daUsername, daPassword, daUserType);
		mngDistPrivLib.navigateToManageDistrictPrivilege(daUserType, district);
		mngDistPrivLib.jobOrderViewPermissionAllDA();
	}

	@Test(priority = 4)
	public void jobOrderViewPermissionAllDASA() throws Exception {
		loginLib.login(daUsername, daPassword, daUserType);
		sheetName = "DADJO";
		rowNum = 6;
		mngDistPrivLib.navigateToManageDistrictPrivilege(daUserType, district);
		mngDistPrivLib.jobOrderViewPermissionAllDASA(daUserType, sheetName,
				rowNum);
	}

	@Test(priority = 5)
	public void jobOrderViewPermissionToJADA() throws Exception {
		loginLib.login(daUsername, daPassword, daUserType);
		sheetName = "DADJO";
		rowNum = 7;
		mngDistPrivLib.navigateToManageDistrictPrivilege(daUsername, district);
		mngDistPrivLib.jobOrderViewPermissionToJADA(daUserType, sheetName,
				rowNum);
	}

	@Test(priority = 6)
	public void jobOrderViewPermissionToJADASA() throws Exception {
		loginLib.login(daUsername, daPassword, daUserType);
		sheetName = "DADJO";
		rowNum = 7;
		mngDistPrivLib.navigateToManageDistrictPrivilege(daUserType, district);
		mngDistPrivLib.jobOrderViewPermissionToJADASA(sheetName, rowNum);
	}

	@Test(priority = 7)
	public void eeocSupportPermissionTM() throws Exception {
		loginLib.login(daUsername, daPassword, daUserType);
		mngDistPrivLib.navigateToManageDistrictPrivilege(daUserType, district);
		mngDistPrivLib.eeocSupportPermission();
	}

	@Test(priority = 8)
	public void autoNotifyCandidatesForAttachJobPermission() throws Exception {
		loginLib.login(daUsername, daPassword, daUserType);
		mngDistPrivLib.navigateToManageDistrictPrivilege(daUserType, district);
		mngDistPrivLib.autoNotifyCandidatesForAttachJobPermission(daUserType);
	}

	@Test(priority = 9)
	public void zoneJobStartEndTimeJobCategoryOneSubMenuPermission()
			throws Exception {
		jobCategory = excelData.getExcelData("District", 2, 5);
		loginLib.login(daUsername, daPassword, daUserType);
		mngDistPrivLib.navigateToManageDistrictPrivilege(daUserType, district);
		mngDistPrivLib.zoneJobStartEndTimeJobCategoryOneSubMenuPermission(
				daUserType, district, jobCategory);
	}

	@Test(priority = 10)
	public void setQQSetToJobCategoryPermission() throws Exception {
		setQQSetToJobCategory = excelData.getExcelData("District", 1, 6);
		jobCategoryForQQ = excelData.getExcelData("District", 1, 7);
		loginLib.login(daUsername, daPassword, daUserType);
		mngDistPrivLib.navigateToManageDistrictPrivilege(daUserType, district);
		rowNum = 9;
		mngDistPrivLib.setQQSetToJobCategoryPermission(district,
				setQQSetToJobCategory, jobCategoryForQQ, rowNum);
	}

	@Test(priority = 11)
	public void setDPointBeforeStatusPrivilege() throws Exception {
		loginLib.login(daUsername, daPassword, daUserType);
		mngDistPrivLib.navigateToManageDistrictPrivilege(daUserType, district);
		jobId = excelData.getExcelData("DADJO", 4, 12);
		candidateMailId = excelData.getExcelData("AddUser", 4, 3);
		mngDistPrivLib.setDPointBeforeStatusPrivilege(daUserType, jobId,
				candidateMailId);
	}

	@Test(priority = 12)
	public void setDPointAfterStatusPrivilege() throws Exception {
		loginLib.login(daUsername, daPassword, daUserType);
		mngDistPrivLib.navigateToManageDistrictPrivilege(daUserType, district);
		jobId = excelData.getExcelData("DADJO", 4, 12);
		candidateMailId = excelData.getExcelData("AddUser", 4, 3);
		mngDistPrivLib.setDPointAfterStatusPrivilege(daUserType, jobId,
				candidateMailId);
	}

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}

}
