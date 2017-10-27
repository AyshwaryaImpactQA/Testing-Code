package com.scripts.regTestCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageUsersBL;
import com.scripts.lib.commonFunction.Driver;

public class DAManageUsers extends Driver {

	String username, password, userType, district, school, saUsername,
			entityType, saPassword, saUsertype, currentUrl, daUsername,
			daPassword, daUserType, firstName, lastName, userRole, keyContact,
			tmUsername, tmPassword, tmUserType;
	int rowCount;
	ManageUsersBL mngUsersLib;
	LoginBL loginLib;
	ExcelLib excelData;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		// object initialization
		mngUsersLib = new ManageUsersBL();
		loginLib = new LoginBL();
		excelData = new ExcelLib();
		tmUsername = excelData.getExcelData("Login", 1, 1);
		tmPassword = excelData.getExcelData("Login", 1, 2);
		tmUserType = excelData.getExcelData("Login", 1, 3);
		entityType = excelData.getExcelData("AddUser", 3, 5);
		district = excelData.getExcelData("AddUser", 3, 7);
		school = excelData.getExcelData("AddUser", 3, 8);
		daUsername = excelData.getExcelData("Login", 3, 1);
		daPassword = excelData.getExcelData("Login", 3, 2);
		daUserType = excelData.getExcelData("Login", 3, 3);
		userRole = excelData.getExcelData("AddUser", 3, 6);

		reports.startTest("User Creation through DA");
	}

	@Test(priority = 1)
	public void keyContactRoleDA() throws Exception {

		loginLib.login(tmUsername, tmPassword, tmUserType);
		userType = excelData.getExcelData("Login", 1, 3);
		keyContact = excelData.getExcelData("AddUser", 3, 10);
		mngUsersLib.navigateToAdministratorPage();
		mngUsersLib.keyContactRoleDA(daUsername, entityType, district, school,
				tmUserType, keyContact);
		loginLib.logout();

	}

	@Test(priority = 2)
	public void verifyMandatoryFields() throws Exception {

		loginLib.login(daUsername, daPassword, daUserType);
		mngUsersLib.navigateToAdministratorPage();
		mngUsersLib.verifyMandatoryFields();
	}

	@Test(priority = 3)
	public void addUser() throws Exception {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(9999);
		firstName = "fname_aut" + randomInt;
		lastName = "lname_aut" + randomInt;
		username = firstName + "@yopmail.com";
		excelData.setExcelData("AddUser", 3, 1, firstName);
		excelData.setExcelData("AddUser", 3, 2, lastName);
		excelData.setExcelData("AddUser", 3, 3, username);
		username = excelData.getExcelData("AddUser", 3, 3);
		mngUsersLib.addUser(userType, username, firstName, lastName,
				entityType, userRole, district, school, currentUrl);
	}

	@Test(priority = 4)
	public void accountVerification() throws Exception {

		password = excelData.getExcelData("AddUser", 3, 4);
		mngUsersLib.accountVerification(username, password);
		loginLib.logout();
	}

	@Test(priority = 5)
	public void userEdit() throws Exception {
		userType = excelData.getExcelData("Login", 3, 3);

		loginLib.login(daUsername, daPassword, daUserType);
		mngUsersLib.navigateToAdministratorPage();
		mngUsersLib.userEdit(username, entityType, district, school,
				userType);
	}

	@Test(priority = 6)
	public void userSearchWithoutMandatoryFields() throws Exception {
		mngUsersLib.userSearchWithoutMandatoryFields();
		mngUsersLib.navigateToAdministratorPage();
	}

	@Test(priority = 7)
	public void userSndNewPaswrdLnk() throws Exception {
		userType = excelData.getExcelData("Login", 3, 3);

		mngUsersLib.userSndNewPaswrdLnk(username, entityType, district,
				school, userType, currentUrl);
	}

	@Test(priority = 8)
	public void userDeActivate() throws Exception {
		userType = excelData.getExcelData("Login", 3, 3);

		mngUsersLib.userDeActivate(username, entityType, district, school,
				userType);
	}

	@Test(priority = 9)
	public void sndNewPaswrdLnkVerification() throws Exception {
		username = excelData.getExcelData("AddUser", 3, 3);
		mngUsersLib.sndNewPaswrdLnkVerification(username);
	}

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}

}
