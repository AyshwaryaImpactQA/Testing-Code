package com.scripts.regTestCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.AccountVerificationBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageUsersBL;
import com.scripts.lib.commonFunction.Driver;

public class TMManageUsers extends Driver {

	String username, password, userType, district, school, tmUsername,
			entityType, tmPassword, tmUsertype, currentUrl, firstName,
			lastName, userRole;
	int rowCount;
	ManageUsersBL mngUsersLib;
	LoginBL loginLib;
	AccountVerificationBL accountVerificationLib;
	ExcelLib excelData;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		// object initialization
		mngUsersLib = new ManageUsersBL();
		loginLib = new LoginBL();
		excelData = new ExcelLib();
		tmUsername = excelData.getExcelData("Login", 1, 1);
		tmPassword = excelData.getExcelData("Login", 1, 4);
		tmUsertype = excelData.getExcelData("Login", 1, 5);
		userType = excelData.getExcelData("Login", 1, 5);
		entityType = excelData.getExcelData("AddUser", 3, 5);
		userRole = excelData.getExcelData("AddUser", 3, 6);
		district = excelData.getExcelData("AddUser", 1, 7);
		school = excelData.getExcelData("AddUser", 1, 8);
		reports.startTest("User Creation through TM Admin");
		loginLib.login(tmUsername, tmPassword, tmUsertype);
		mngUsersLib.navigateToAdministratorPage();
	}

//	@Test(priority = 1)
	@Test
	public void verifyMandatoryFields() throws Exception {
		mngUsersLib.verifyMandatoryFields();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(9999);

		firstName = "fname_aut" + randomInt;
		lastName = "lname_aut" + randomInt;
		username = firstName + "@yopmail.com";
		excelData.setExcelData("AddUser", 1, 1, firstName);
		excelData.setExcelData("AddUser", 1, 2, lastName);
		excelData.setExcelData("AddUser", 1, 3, username);
		username = excelData.getExcelData("AddUser", 1, 3);
		mngUsersLib.addUser(userType, username, firstName, lastName,
				entityType, userRole, district, school, currentUrl);
		password = excelData.getExcelData("AddUser", 1, 4);
		mngUsersLib.accountVerification(username, password);
		loginLib.logout();
		loginLib.login(tmUsername, tmPassword, tmUsertype);
		mngUsersLib.navigateToAdministratorPage();
		mngUsersLib.userEdit(username, entityType, district, school,
				userType);
		mngUsersLib.userSearchWithoutMandatoryFields();
		mngUsersLib.navigateToAdministratorPage();
		mngUsersLib.userSndNewPaswrdLnk(username, entityType, district,
				school, userType, currentUrl);
		mngUsersLib.sndNewPaswrdLnkVerification(username);
	}

	/*@Test(priority = 2)
	public void addUser() throws Exception {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(9999);

		firstName = "fname_aut" + randomInt;
		lastName = "lname_aut" + randomInt;
		username = firstName + "@yopmail.com";
		excelData.setExcelData("AddUser", 1, 1, firstName);
		excelData.setExcelData("AddUser", 1, 2, lastName);
		excelData.setExcelData("AddUser", 1, 3, username);
		username = excelData.getExcelData("AddUser", 1, 3);
		mngUsersLib.addUser(userType, username, firstName, lastName,
				entityType, userRole, district, school, currentUrl);
	}

	@Test(priority = 3)
	public void accountVerification() throws Exception {
		password = excelData.getExcelData("AddUser", 1, 4);
		mngUsersLib.accountVerification(username, password);
		loginLib.logout();
	}

	@Test(priority = 4)
	public void userEdit() throws Exception {

		loginLib.login(tmUsername, tmPassword, tmUsertype);
		mngUsersLib.navigateToAdministratorPage();
		mngUsersLib.userEdit(username, entityType, district, school,
				userType);
	}

	@Test(priority = 5)
	public void userSearchWithoutMandatoryFields() throws Exception {
		mngUsersLib.userSearchWithoutMandatoryFields();
		mngUsersLib.navigateToAdministratorPage();
	}

	@Test(priority = 6)
	public void userSndNewPaswrdLnk() throws Exception {
		mngUsersLib.userSndNewPaswrdLnk(username, entityType, district,
				school, userType, currentUrl);
	}

	@Test(priority = 7)
	public void userDeActivate() throws Exception {
		mngUsersLib.userDeActivate(username, entityType, district, school,
				userType);
	}   // not for sanity

	@Test(priority = 8)
	public void sndNewPaswrdLnkVerification() throws Exception {
		mngUsersLib.sndNewPaswrdLnkVerification(username);
	}*/

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}

}
