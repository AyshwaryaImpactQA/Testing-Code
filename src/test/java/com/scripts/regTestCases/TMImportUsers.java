package com.scripts.regTestCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.CopySheet;
import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.ImportUserBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.lib.commonFunction.Driver;

public class TMImportUsers extends Driver {
	LoginBL loginLib;
	ExcelLib excelData;
	CopySheet copyData;
	Random random;
	ImportUserBL importUserBL;
	String file, username, password, userType, path, userFirstName,
			districtName, role, userLastName, userEmail;

	@BeforeClass
	public void configClass() throws Exception {
		loginLib = new LoginBL();
		random = new Random();
		excelData = new ExcelLib();
		copyData = new CopySheet();
		path = System.getProperty("user.dir") + "\\src\\test\\resources\\";
		System.out.print("The file path is : "+path);
		importUserBL = new ImportUserBL();
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 4);
		userType = excelData.getExcelData("Login", 1, 5);
		reports.startTest("Import User with TM Admin");
		loginLib.login(username, password, userType);
		userFirstName = "AutoFName" + random.nextInt(10000);
		excelData.setExcelData("TMUserImport", 1, 0, userFirstName);
		userLastName = "AutoLName" + random.nextInt(20000);
		excelData.setExcelData("TMUserImport", 1, 1, userLastName);
		userEmail = userFirstName + "@mailinator.com";
		excelData.setExcelData("TMUserImport", 1, 2, userEmail);
	}

	@Test
	public void importUsers() throws Exception {
		role = excelData.getDateExcelData("TMUserImport", 1, 3);
		districtName = excelData.getDateExcelData("TMUserImport", 1, 4);
		copyData.copySheet(path + "NCTestDataSheet.xls", path
				+ "Import\\ImportUsers.xls", "TMUserImport");
		file = path + "Import\\ImportUsers.xls";
		importUserBL.importUsers(file, districtName, userEmail);
	}

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}
}
