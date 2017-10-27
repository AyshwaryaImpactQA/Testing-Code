package com.scripts.regTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.DistrictJobOrderBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageDistrictAccountInformationBL;
import com.scripts.lib.commonFunction.Driver;

public class TMManageDistrictAccountInformation extends Driver {

	String daUsername, daPassword, daUserType, district;
	ManageDistrictAccountInformationBL mngDistPrivLib;
	DistrictJobOrderBL districtJobOrder;
	ExcelLib excelData;
	LoginBL loginLib;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		excelData = new ExcelLib();
		loginLib = new LoginBL();
		districtJobOrder = new DistrictJobOrderBL();
		mngDistPrivLib = new ManageDistrictAccountInformationBL();

	}

	//@Test(priority = 1)
	@Test
	public void login() throws Exception {
		daUsername = excelData.getExcelData("Login", 1, 1);
		daPassword = excelData.getExcelData("Login", 1, 4);
		daUserType = excelData.getExcelData("Login", 1, 5);
		district = excelData.getExcelData("District", 4, 4);
		reports.startTest("Manage Districts with TM");
		loginLib.login(daUsername, daPassword, daUserType);
		
		mngDistPrivLib.navigateToManageDistrictTM();
		mngDistPrivLib.searchDistrict(district);
		mngDistPrivLib.editDistrict(district);
		mngDistPrivLib.selectHRIntegrated();
		loginLib.logout();
		daUsername = excelData.getExcelData("Login", 8, 1);
		daPassword = excelData.getExcelData("Login", 8, 4);
		daUserType = excelData.getExcelData("Login", 8, 5);
		district = excelData.getExcelData("District", 3, 4);
		loginLib.login(daUsername, daPassword, daUserType);
		districtJobOrder.navigateToDistrictJobOrder();
		mngDistPrivLib.verifyHRIntegratedCheck();
		loginLib.logout();
		
		daUsername = excelData.getExcelData("Login", 1, 1);
		daPassword = excelData.getExcelData("Login", 1, 4);
		daUserType = excelData.getExcelData("Login", 1, 5);
		district = excelData.getExcelData("District", 4, 4);
		loginLib.login(daUsername, daPassword, daUserType);
		mngDistPrivLib.navigateToManageDistrictTM();
		mngDistPrivLib.searchDistrict(district);
		mngDistPrivLib.editDistrict(district);
		mngDistPrivLib.selectLINQIntegrated();
		loginLib.logout();
		daUsername = excelData.getExcelData("Login", 8, 1);
		daPassword = excelData.getExcelData("Login", 8, 4);
		daUserType = excelData.getExcelData("Login", 8, 5);
		district = excelData.getExcelData("District", 3, 4);
		loginLib.login(daUsername, daPassword, daUserType);
		districtJobOrder.navigateToDistrictJobOrder();
		mngDistPrivLib.verifyHRIntegratedUnCheck();
	}

	/*@Test(priority = 2)
	public void verifyHRIntegratedCheck() throws Exception {
		mngDistPrivLib.navigateToManageDistrictTM();
		mngDistPrivLib.searchDistrict(district);
		mngDistPrivLib.editDistrict(district);
		mngDistPrivLib.selectHRIntegrated();
		loginLib.logout();
		daUsername = excelData.getExcelData("Login", 8, 1);
		daPassword = excelData.getExcelData("Login", 8, 4);
		daUserType = excelData.getExcelData("Login", 8, 5);
		district = excelData.getExcelData("District", 3, 4);
		loginLib.login(daUsername, daPassword, daUserType);
		districtJobOrder.navigateToDistrictJobOrder();
		mngDistPrivLib.verifyHRIntegratedCheck();
		loginLib.logout();
	}

	@Test(priority = 3)
	public void verifyHRIntegratedUnCheck() throws Exception {
		daUsername = excelData.getExcelData("Login", 1, 1);
		daPassword = excelData.getExcelData("Login", 1, 4);
		daUserType = excelData.getExcelData("Login", 1, 5);
		district = excelData.getExcelData("District", 4, 4);
		loginLib.login(daUsername, daPassword, daUserType);
		mngDistPrivLib.navigateToManageDistrictTM();
		mngDistPrivLib.searchDistrict(district);
		mngDistPrivLib.editDistrict(district);
		mngDistPrivLib.selectLINQIntegrated();
		loginLib.logout();
		daUsername = excelData.getExcelData("Login", 8, 1);
		daPassword = excelData.getExcelData("Login", 8, 4);
		daUserType = excelData.getExcelData("Login", 8, 5);
		district = excelData.getExcelData("District", 3, 4);
		loginLib.login(daUsername, daPassword, daUserType);
		districtJobOrder.navigateToDistrictJobOrder();
		mngDistPrivLib.verifyHRIntegratedUnCheck();
	}*/

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}

}
