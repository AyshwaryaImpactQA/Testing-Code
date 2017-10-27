package com.scripts.testCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageSLCBL;
import com.scripts.lib.commonFunction.Driver;

public class TMManageSLC extends Driver {

	LoginBL loginLib;
	ManageSLCBL mngSLCLib;
	ExcelLib excelData;
	Random randomGenerator;
	String username, password, userType, district, node, jobCategory, oldNode;

	@BeforeClass
	public void configClass() throws Exception {
		loginLib = new LoginBL();
		mngSLCLib = new ManageSLCBL();
		excelData = new ExcelLib();
		randomGenerator = new Random();
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 2);
		userType = excelData.getExcelData("Login", 1, 3);
		district = excelData.getExcelData("SLC", 1, 4);
		jobCategory = excelData.getExcelData("SLC", 1, 5);
		reports.startTest("Manage SLC with TM Admin");
		loginLib.login(username, password, userType);
		mngSLCLib.navigateToManageSLCPage();
		mngSLCLib.goToSLCForJobCategory(district, jobCategory);
	}

	@Test(priority = 1)
	public void createNode() throws Exception {
		excelData.setExcelData("SLC", 1, 6,
				"AutoNode" + randomGenerator.nextInt(999));
		node = excelData.getExcelData("SLC", 1, 6);
		mngSLCLib.createNode(node);
	}

	@Test(priority = 2)
	public void renameNode() throws Exception {
		oldNode = excelData.getExcelData("SLC", 1, 6);
		excelData.setExcelData("SLC", 1, 6,
				"AutoNode" + randomGenerator.nextInt(999));
		node = excelData.getExcelData("SLC", 1, 6);
		mngSLCLib.renameNode(oldNode, node);
	}

	@Test(priority = 3)
	public void cutPasteNode() throws Exception {
		node = excelData.getExcelData("SLC", 1, 6);
		mngSLCLib.cutPasteNode(node);
	}

	@Test(priority = 4)
	public void copyPasteNode() throws Exception {
		node = excelData.getExcelData("SLC", 1, 6);
		mngSLCLib.copyPasteNode(node);
	}
	
	@Test(priority = 5)
	public void setAttributes() throws Exception {
		node = excelData.getExcelData("SLC", 1, 6);
		mngSLCLib.setAttributes(node);
	}
	
	@Test(priority = 6)
	public void deleteNode() throws Exception {
		node = excelData.getExcelData("SLC", 1, 6);
		mngSLCLib.deleteNode(node);
	}

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}

}
