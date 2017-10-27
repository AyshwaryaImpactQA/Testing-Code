package com.scripts.testCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageRequisitionNumberBL;
import com.scripts.lib.commonFunction.Driver;

public class TMManageRequisitionNumber extends Driver {

	LoginBL loginLib;
	ManageRequisitionNumberBL mngReqNoLib;
	ExcelLib excelData;
	Random randomGenerator;
	String username, password, userType, district, reqNo, positionType,
			location, positionTitle;

	@BeforeClass
	public void configClass() throws Exception {
		loginLib = new LoginBL();
		mngReqNoLib = new ManageRequisitionNumberBL();
		excelData = new ExcelLib();
		randomGenerator = new Random();
		excelData.setExcelData("RequisitionNo", 1, 5, "AutoReqNo"
				+ randomGenerator.nextInt(99999));
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 2);
		userType = excelData.getExcelData("Login", 1, 3);
		reports.startTest("Manage Requisition No with TM Admin");
		loginLib.login(username, password, userType);
	}

	@Test(priority = 1)
	public void verifyMandatoryFields() throws Exception {
		userType = excelData.getExcelData("Login", 1, 3);
		mngReqNoLib.verifyMandatoryFields(userType);
	}

	@Test(priority = 2)
	public void addRequisitionNo() throws Exception {
		userType = excelData.getExcelData("Login", 1, 3);
		district = excelData.getExcelData("RequisitionNo", 1, 4);
		reqNo = excelData.getExcelData("RequisitionNo", 1, 5);
		positionType = excelData.getExcelData("RequisitionNo", 1, 6);
		location = excelData.getExcelData("RequisitionNo", 1, 7);
		positionTitle = excelData.getExcelData("RequisitionNo", 1, 8);
		mngReqNoLib.addRequisitionNo(userType, district, reqNo, positionType,
				location, positionTitle);
	}

	@Test(priority = 3)
	public void searchRequisitionNo() throws Exception {
		userType = excelData.getExcelData("Login", 1, 3);
		district = excelData.getExcelData("RequisitionNo", 1, 4);
		reqNo = excelData.getExcelData("RequisitionNo", 1, 5);
		mngReqNoLib.searchRequisitionNo(userType, district, reqNo);
	}

	@Test(priority = 4)
	public void editRequisitionNo() throws Exception {
		reqNo = excelData.getExcelData("RequisitionNo", 1, 5);
		mngReqNoLib.editRequisitionNo(reqNo);
	}

	@Test(priority = 5)
	public void deleteRequisitionNo() throws Exception {
		reqNo = excelData.getExcelData("RequisitionNo", 1, 5);
		mngReqNoLib.deleteRequisitionNo(reqNo);
	}

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}

}
