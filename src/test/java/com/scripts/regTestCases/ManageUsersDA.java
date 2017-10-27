package com.scripts.regTestCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageUsersBL;
import com.scripts.lib.commonFunction.Driver;

public class ManageUsersDA extends Driver {

	String username, password, userType, district, school, saUsername,
			entityType, saPassword, saUsertype, currentUrl, daUsername,
			daPassword, daUserType, firstName, lastName, userRole, keyContact,
			tmUsername, tmPassword, tmUserType;
	int rowCount;
	ManageUsersBL manageUsersLib;
	LoginBL loginLib;
	ExcelLib excelData;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		// object initialization
		manageUsersLib = new ManageUsersBL();
		loginLib = new LoginBL();
		excelData = new ExcelLib();
		tmUsername = excelData.getExcelData("Login", 1, 1);
		tmPassword = excelData.getExcelData("Login", 1, 4);
		tmUserType = excelData.getExcelData("Login", 1, 5);
		entityType = excelData.getExcelData("AddUser", 1, 5);
		district = excelData.getExcelData("AddUser", 1, 7);
		school = excelData.getExcelData("AddUser", 1, 8);
		daUsername = excelData.getExcelData("Login", 3, 1);
		daPassword = excelData.getExcelData("Login", 3, 4);
		daUserType = excelData.getExcelData("Login", 3, 5);
		userRole = excelData.getExcelData("AddUser", 1, 6);
		reports.startTest("User Creation through DA");
		loginLib.login(daUsername, daPassword, daUserType);
	}


	//@Test(priority = 1 )
	@Test
	public void verifyMandatoryFields() throws Exception {

		
		manageUsersLib.navigateToAdministratorPage();
		manageUsersLib.verifyMandatoryFields();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(9999);
		firstName = "fname_aut" + randomInt;
		lastName = "lname_aut" + randomInt;
		username = firstName + "@yopmail.com";
		excelData.setExcelData("AddUser", 3, 1, firstName);
		excelData.setExcelData("AddUser", 3, 2, lastName);
		excelData.setExcelData("AddUser", 3, 3, username);
		username = excelData.getExcelData("AddUser", 3, 3);
		userType = excelData.getExcelData("Login", 3, 5);
		manageUsersLib.addUser(userType, username, firstName, lastName,
				entityType, userRole, district, school, currentUrl);
		password = excelData.getExcelData("AddUser", 3, 4);
		manageUsersLib.accountVerification(username, password);
		loginLib.logout();
		userType = excelData.getExcelData("Login", 3, 5);
		loginLib.login(daUsername, daPassword, daUserType);
		manageUsersLib.navigateToAdministratorPage();
		manageUsersLib.userEdit(username, entityType, district, school,
				userType);
		userType = excelData.getExcelData("Login", 3, 5);

		manageUsersLib.userDeActivate(username, entityType, district, school,
				userType);
	}

	/*@Test(priority = 2)
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
		userType = excelData.getExcelData("Login", 3, 5);
		manageUsersLib.addUser(userType, username, firstName, lastName,
				entityType, userRole, district, school, currentUrl);
	}

	@Test(priority = 3)
	public void accountVerification() throws Exception {

		password = excelData.getExcelData("AddUser", 3, 4);
		manageUsersLib.accountVerification(username, password);
		loginLib.logout();
	}

	@Test(priority = 4)
	public void userEdit() throws Exception {
		userType = excelData.getExcelData("Login", 3, 5);
		loginLib.login(daUsername, daPassword, daUserType);
		manageUsersLib.navigateToAdministratorPage();
		manageUsersLib.userEdit(username, entityType, district, school,
				userType);
	}

	@Test(priority = 5)
	public void userDeActivate() throws Exception {
		userType = excelData.getExcelData("Login", 3, 5);

		manageUsersLib.userDeActivate(username, entityType, district, school,
				userType);
	}*/
	/*	@Test(priority = 7)
	public void keyContactRoleDA() throws Exception {

		loginLib.login(daUsername, daPassword, daUserType);
		userType = excelData.getExcelData("Login", 1, 5);
	 excelData.getExcelData("AddUser", 3, 10);
		manageUsersLib.navigateToAdministratorPage();
		manageUsersLib.keyContactRoleDA(daUsername, entityType, district, school,
				tmUserType, keyContact);
		loginLib.logout();

	}
*/

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}

}
