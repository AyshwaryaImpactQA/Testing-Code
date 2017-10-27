package com.scripts.regTestCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageDocumentsBL;
import com.scripts.lib.commonFunction.Driver;

public class DAManageDocuments extends Driver {

	ManageDocumentsBL docLib;
	LoginBL loginLib;
	ExcelLib excelData;
	Random randomGenerator;
	String username, password, userType, district, school, docName;

	@BeforeClass
	public void configClass() throws Exception {
		docLib = new ManageDocumentsBL();
		loginLib = new LoginBL();
		excelData = new ExcelLib();
		randomGenerator = new Random();
		excelData.setExcelData("Documents", 2, 6, "AutoDocument"
				+ randomGenerator.nextInt(99999));
		username = excelData.getExcelData("Login", 3, 1);
		password = excelData.getExcelData("Login", 3, 4);
		userType = excelData.getExcelData("Login", 3, 5);
		reports.startTest("Manage Documents with District Admin");
		loginLib.login(username, password, userType);
	}

	@Test(priority = 1)
	public void verifyMandatoryFields() throws Exception {
		docLib.verifyMandatoryFields(userType);
	}

	@Test(priority = 2)
	public void addDocument() throws Exception {
		district = excelData.getExcelData("Documents", 2, 4);
		school = excelData.getExcelData("Documents", 2, 5);
		docName = excelData.getExcelData("Documents", 2, 6);
		docLib.addDocument(userType, district, school, docName);
	}

	@Test(priority = 3)
	public void searchDocument() throws Exception {
		docName = excelData.getExcelData("Documents", 2, 6);
		docLib.searchDocument(docName);
	}

	@Test(priority = 4)
	public void ViewAttachment() throws Exception {
		docLib.viewAttachment();
	}

	@Test(priority = 5)
	public void editDocument() throws Exception {
		docLib.editDocument();
	}

	@Test(priority = 6)
	public void deActivateDocument() throws Exception {
		docLib.deActivateDocument();
	}

	@Test(priority = 7)
	public void deleteDocument() throws Exception {
		docLib.deleteDocument();
	}

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}
}
