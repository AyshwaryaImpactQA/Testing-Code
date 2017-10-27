package com.scripts.testCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageTagsBL;
import com.scripts.lib.commonFunction.Driver;

public class TMManageTags extends Driver {

	LoginBL loginLib;
	ManageTagsBL mngTagLib;
	ExcelLib excelData;
	Random randomGenerator;
	String username, password, userType, district, tagName, newTagName;

	@BeforeClass
	public void configClass() throws Exception {
		loginLib = new LoginBL();
		mngTagLib = new ManageTagsBL();
		excelData = new ExcelLib();
		randomGenerator = new Random();
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 2);
		userType = excelData.getExcelData("Login", 1, 3);
		reports.startTest("Manage Tags with TM Admin");
		loginLib.login(username, password, userType);
	}

	@Test(priority = 1)
	public void verifyMandatoryFields() throws Exception {
		userType = excelData.getExcelData("Login", 1, 3);
		mngTagLib.verifyMandatoryFields(userType);
	}

	@Test(priority = 2)
	public void addTag() throws Exception {
		excelData.setExcelData("Tags", 1, 5, "AutoTag" + randomGenerator.nextInt(99999));
		district = excelData.getExcelData("Tags", 1, 4);
		tagName = excelData.getExcelData("Tags", 1, 5);
		mngTagLib.addTag(district, tagName);
	}
	
	@Test(priority = 3)
	public void searchTag() throws Exception {
		district = excelData.getExcelData("Tags", 1, 4);
		tagName = excelData.getExcelData("Tags", 1, 5);
		mngTagLib.searchTag(district, tagName);
	}
 
	@Test(priority = 4)
	public void editTag() throws Exception {
		district = excelData.getExcelData("Tags", 1, 4);
		tagName = excelData.getExcelData("Tags", 1, 5);
		excelData.setExcelData("Tags", 1, 5, "AutoTag" + randomGenerator.nextInt(99999));
		newTagName = excelData.getExcelData("Tags", 1, 5);
		mngTagLib.editTag(district, tagName, newTagName);
	}
	
	@Test(priority = 5)
	public void viewAttachment() throws Exception {
		district = excelData.getExcelData("Tags", 1, 4);
		tagName = excelData.getExcelData("Tags", 1, 5);
		mngTagLib.viewAttachment(district, tagName);
	}
	
	@Test(priority = 6)
	public void deactivateTag() throws Exception {
		district = excelData.getExcelData("Tags", 1, 4);
		tagName = excelData.getExcelData("Tags", 1, 5);
		mngTagLib.deactivateTag(district, tagName);
	}
	
	@AfterClass
	public void logout() throws InterruptedException {
		loginLib.logout();
	}
}
