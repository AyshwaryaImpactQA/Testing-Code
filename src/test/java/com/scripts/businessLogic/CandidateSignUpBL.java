package com.scripts.businessLogic;

import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.LoginPL;
import com.scripts.pageObjectRepository.ManageUsersPL;

public class CandidateSignUpBL extends Driver {

	LoginPL loginPage = PageFactory.initElements(driver, LoginPL.class);
	ManageUsersPL mngUserPage = PageFactory.initElements(driver,
			ManageUsersPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void candidateSignUp(String firstName, String lastName,
			String userName, String password) throws InterruptedException,
			Exception {
		commonLib.waitForPageToLoad();
		commonLib.waitForElement(loginPage.getBtnSignUp(), "SignUP Btn");
		commonLib.logOnInfo("Candidate Sign Up", "Verifying the login page");
		if (!commonLib.isDisplayed(loginPage.getBtnSignUp())) {
			commonLib.logOnError("Candidate Sign Up",
					"'Sign up' button not displayed");
			return;
		}
		commonLib.click(loginPage.getBtnSignUp(), "SignUp button");
		commonLib.waitForPageToLoad();
		commonLib.typeText(mngUserPage.getTxtBoxFirstName(), firstName,
				"First Name text box");
		commonLib.typeText(mngUserPage.getTxtBoxLastName(), lastName,
				"Last Name text box");
		commonLib.typeText(loginPage.getTxtBoxUsername(), userName,
				"User Name text box");
		commonLib.typeText(loginPage.getTxtBoxPassword(), password,
				"Password text box");
		commonLib.waitForElement(loginPage.getBtnSignUp(), "SignUp Btn");
		commonLib.click(loginPage.getBtnSignUp(), "SignUp Btn");
		if (commonLib.isDisplayed(mngUserPage.getErrAlreadyExist(),
			"Already Exist User Error")) {
			String updatedUserName = "AutoGenUser"
					+ randomGenerator.nextInt(999999);
			commonLib.typeText(loginPage.getTxtBoxUsername(), updatedUserName,
					"Email Text Box");
			excelData.setExcelData("AddUser", 2, 3, updatedUserName);
			commonLib.click(loginPage.getBtnSignUp(), "SignUp button");
		}
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngUserPage.getTextConfirmSignup(),
				"Confirm SignUp Button")) {
			commonLib.logOnSuccess("Candidate Sign Up",
					"Candidate registered successfully");
		} else {
			
			commonLib.logOnError("Candidate Sign Up",
					"Candidate not registered");
		}
	}

}
