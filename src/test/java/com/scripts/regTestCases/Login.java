package com.scripts.regTestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.LoginBL;
import com.scripts.lib.commonFunction.Driver;

public class Login extends Driver {
	String username, password, userType;

	ExcelLib excelData;
	LoginBL loginLib;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		excelData = new ExcelLib();
		loginLib = new LoginBL();
		reports.startTest("Login with TM Admin");
	}

	//@Test(priority = 1)
	@Test
	public void loginWithoutMandatoryFields() throws Exception {
		/*loginLib.loginWithoutMandatoryFields();
		username = excelData.getExcelData("Login", 1, 2);
		password = excelData.getExcelData("Login", 1, 4);
		userType = excelData.getExcelData("Login", 1, 5);
		loginLib.loginWithInvalidEmail(username, password, userType);
		
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 3);
		userType = excelData.getExcelData("Login", 1, 5);
		loginLib.loginWithInvalidPassword(username, password, userType);*/
		
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 4);
		userType = excelData.getExcelData("Login", 1, 5);
		loginLib.login(username, password, userType);

	}

	/*@Test(priority = 2)
	public void loginWithInvalidEmail() throws InterruptedException,
			InvalidFormatException, IOException {
		username = excelData.getExcelData("Login", 1, 2);
		password = excelData.getExcelData("Login", 1, 4);
		userType = excelData.getExcelData("Login", 1, 5);
		loginLib.loginWithInvalidEmail(username, password, userType);

	}

	@Test(priority = 3)
	public void loginWithInvalidPassword() throws InterruptedException,
			InvalidFormatException, IOException {
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 3);
		userType = excelData.getExcelData("Login", 1, 5);
		loginLib.loginWithInvalidPassword(username, password, userType);

	}

	@Test(priority = 4)
	public void login() throws Exception {
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 4);
		userType = excelData.getExcelData("Login", 1, 5);
		loginLib.login(username, password, userType);

	}*/

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}

}
