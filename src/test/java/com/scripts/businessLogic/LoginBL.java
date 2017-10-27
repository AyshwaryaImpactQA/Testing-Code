package com.scripts.businessLogic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.LoginPL;

public class LoginBL extends Driver {

	LoginPL loginPage = PageFactory.initElements(driver, LoginPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void login(String username, String password, String userType)
			throws Exception {
		commonLib.logOnInfo("Login with " + userType, "Login with " + userType);
		//commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(loginPage.getDrpdownUserName())) {
			commonLib.click(loginPage.getDrpdownUserName(),
					"User Name Dropdown");
			commonLib.click(loginPage.getSubMenuSignOut(), "Sign Out Option");
			commonLib.waitForElement(loginPage.getLinkSignOut(),
					"Sign Out Link");
			commonLib.click(loginPage.getLinkSignOut(), "Sign Out Link");
			commonLib.waitForElement(loginPage.getTxtBoxUsername(),
					"User Name Text box");
			if (!commonLib.isDisplayed(loginPage.getTxtBoxUsername())) {
				commonLib.logOnError("Login with " + userType,
						"'User Name' textbox not appeared");
			} else {
				commonLib.typeText(loginPage.getTxtBoxUsername(), username,
						"UserName TxtBx");
				commonLib.typeText(loginPage.getTxtBoxPassword(), password,
						"Password TxtBx");
				commonLib.click(loginPage.getBtnLogin(), "Login Button");
				commonLib.waitForPageToLoad();
				if (commonLib.isDisplayed(loginPage.getDrpdownUserName())) {
					commonLib.logOnSuccess("Login with " + userType,
							"User logged In successfully");
				} else {
					commonLib.logOnError("Login with " + userType,
							"User is not logged in");

				}
			}
		} else {
			if (!commonLib.isDisplayed(loginPage.getTxtBoxUsername())) {
				commonLib.logOnError("Login with " + userType,
						"'User Name' textbox not appeared");
			} else {
				commonLib.typeText(loginPage.getTxtBoxUsername(), username,
						"UserName TxtBx");
				commonLib.typeText(loginPage.getTxtBoxPassword(), password,
						"Password TxtBx");
				commonLib.click(loginPage.getBtnLogin(), "Login Button");
				commonLib.waitForPageToLoad();
				if (commonLib.isDisplayed(loginPage.getDrpdownUserName())) {
					commonLib.logOnSuccess("Login with " + userType,
							"User logged In successfully");
				} else {
					commonLib.logOnError("Login with " + userType,
							"User is not logged in");
				}
			}
		}

	}

	public void loginWithoutMandatoryFields() throws InterruptedException {
		commonLib.logOnInfo("Verifying Login",
				"Verifying Login without entering Mandatory Fields");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(loginPage.getDrpdownUserName())) {
			commonLib.click(loginPage.getDrpdownUserName(),
					"User Name Dropdown");
			commonLib.click(loginPage.getSubMenuSignOut(), "Sign Out Option");
			commonLib.waitForElement(loginPage.getLinkSignOut(),
					"Sign Out Link");
			commonLib.click(loginPage.getLinkSignOut(), "Sign Out Link");
			commonLib.waitForElement(loginPage.getTxtBoxUsername(),
					"User Name Text box");
			if (!commonLib.isDisplayed(loginPage.getTxtBoxUsername())) {
				commonLib.logOnError("Verifying Login",
						"'User Name' textbox not appeared");
			} else {
				commonLib.click(loginPage.getBtnLogin(), "Login Button");
				commonLib.waitForPageToLoad();
				if (commonLib.isDisplayed(loginPage.getErrorBlank(),
						"Error Message")) {
					commonLib
							.logOnSuccess("Verifying Login",
									"User is not able to Login without mandatory fields");
				} else {
					commonLib.logOnError("Verifying Login",
							"User is able to Login without mandatory fields");
				}
			}
		} else {
			commonLib.click(loginPage.getBtnLogin(), "Login Button");
			commonLib.waitForPageToLoad();
			if (commonLib.isDisplayed(loginPage.getErrorBlank(),
					"Error Message")) {
				commonLib.logOnSuccess("Verifying Login",
						"User is not able to Login without mandatory fields");
			} else {
				commonLib.logOnError("Verifying Login",
						"User is able to Login without mandatory fields");
			}
		}

	}

	public void loginWithInvalidEmail(String username, String password,
			String userType) throws InterruptedException {
		commonLib.logOnInfo("Verifying Login with Invalid Email",
				"Login with Invalid Email");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(loginPage.getDrpdownUserName())) {
			commonLib.click(loginPage.getDrpdownUserName(),
					"User Name Dropdown");
			commonLib.click(loginPage.getSubMenuSignOut(), "Sign Out Option");
			commonLib.waitForElement(loginPage.getLinkSignOut(),
					"Sign Out Link");
			commonLib.click(loginPage.getLinkSignOut(), "Sign Out Link");
			commonLib.waitForElement(loginPage.getTxtBoxUsername(),
					"User Name Text box");
			if (!commonLib.isDisplayed(loginPage.getTxtBoxUsername())) {
				commonLib.logOnError("Login with Invalid Email",
						"'User Name' textbox not appeared");
			} else {
				commonLib.typeText(loginPage.getTxtBoxUsername(), username,
						"UserName TxtBx");
				commonLib.typeText(loginPage.getTxtBoxPassword(), password,
						"Password TxtBx");
				commonLib.click(loginPage.getBtnLogin(), "Login Button");
				commonLib.waitForPageToLoadWithCond(loginPage.getErrorMessage());
				if (commonLib.isDisplayed(loginPage.getErrorMessage())) {
					commonLib.logOnSuccess(
							"Verifying Login with Invalid Email",
							"User is not able to Login with Invalid Email");
				} else {
					commonLib.logOnError("Verifying Login with Invalid Email",
							"User is able to Login with Invalid Email");

				}
			}
		} else {
			if (!commonLib.isDisplayed(loginPage.getTxtBoxUsername())) {
				commonLib.logOnError("Login with Invalid Email",
						"'User Name' textbox not appeared");
			} else {
				commonLib.typeText(loginPage.getTxtBoxUsername(), username,
						"UserName TxtBx");
				commonLib.typeText(loginPage.getTxtBoxPassword(), password,
						"Password TxtBx");
				commonLib.click(loginPage.getBtnLogin(), "Login Button");
				commonLib.waitForPageToLoadWithCond(loginPage.getErrorMessage());
				if (commonLib.isDisplayed(loginPage.getErrorMessage())) {
					commonLib.logOnSuccess(
							"Verifying Login with Invalid Email",
							"User is not able to Login with Invalid Email");
				} else {
					commonLib.logOnError("Verifying Login with Invalid Email",
							"User is able to Login with Invalid Email");
				}
			}
		}

	}

	public void loginWithInvalidPassword(String username, String password,
			String userType) throws InterruptedException {
		commonLib.logOnInfo("Verifying Login with Invalid Password",
				"Login with Invalid Password");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(loginPage.getDrpdownUserName())) {
			commonLib.click(loginPage.getDrpdownUserName(),
					"User Name Dropdown");
			commonLib.click(loginPage.getSubMenuSignOut(), "Sign Out Option");
			commonLib.waitForElement(loginPage.getLinkSignOut(),
					"Sign Out Link");
			commonLib.click(loginPage.getLinkSignOut(), "Sign Out Link");
			commonLib.waitForPageToLoadWithCond(loginPage.getTxtBoxUsername());
			commonLib.waitForElement(loginPage.getTxtBoxUsername(),"User Name Text box");
			if (!commonLib.isDisplayed(loginPage.getTxtBoxUsername())) {
				commonLib.logOnError("Login with Invalid Passworde",
						"'User Name' textbox not appeared");
			} else {
				commonLib.typeText(loginPage.getTxtBoxUsername(), username,"UserName TxtBx");
				commonLib.typeText(loginPage.getTxtBoxPassword(), password,"Password TxtBx");
				commonLib.click(loginPage.getBtnLogin(), "Login Button");
				commonLib.waitForPageToLoadWithCond(loginPage.getErrorMessageInvalidPassword());
				if (commonLib.isDisplayed(loginPage.getErrorMessageInvalidPassword())) {
					commonLib.logOnSuccess("Verifying Login with Invalid Password","User is not able to Login with Invalid Password");
				} else {
					commonLib.logOnError("Verifying Login with Invalid Password","User is able to Login with Invalid Password");

				}
			}
		} else {
			if (!commonLib.isDisplayed(loginPage.getTxtBoxUsername())) {
				commonLib.logOnError("Login with Invalid Password","'User Name' textbox not appeared");
			} else {
				commonLib.typeText(loginPage.getTxtBoxUsername(), username,"UserName TxtBx");
				commonLib.typeText(loginPage.getTxtBoxPassword(), password,
						"Password TxtBx");
				commonLib.click(loginPage.getBtnLogin(), "Login Button");
				commonLib.waitForPageToLoadWithCond(loginPage.getErrorMessageInvalidPassword());
				if (commonLib.isDisplayed(loginPage.getErrorMessageInvalidPassword())) {
					commonLib.logOnSuccess(
							"Verifying Login with Invalid Password",
							"User is not able to Login with Invalid Password");
				} else {
					commonLib.logOnError(
							"Verifying Login with Invalid Password",
							"User is able to Login with Invalid Password");
				}
			}
		}

	}

	public void logout() throws InterruptedException {
		commonLib.logOnInfo("Logout", "Logging out");
		commonLib.waitForPageToLoad();
		
		try
		   {
		     WebDriverWait wait = new WebDriverWait(driver,10);
		     wait.until(ExpectedConditions.alertIsPresent());
		     Alert alert = driver.switchTo().alert();
		     alert.accept();
		   //  reportAlertPresent = true;
		   }
		
		catch (Exception e) {
	        System.out.println("No alert present");
	    }
		commonLib.waitForPageToLoadWithCond(loginPage.getDrpdownUserName());
		if (commonLib.isDisplayed(loginPage.getDrpdownUserName())) {
			commonLib.click(loginPage.getDrpdownUserName(),"User Name Dropdown");
			commonLib.click(loginPage.getSubMenuSignOut(), "Sign Out Option");
			commonLib.waitForElement(loginPage.getLinkSignOut(),
					"Sign Out Link");
			commonLib.waitForPageToLoadWithCond(loginPage.getLinkSignOut());
			commonLib.click(loginPage.getLinkSignOut(), "Sign Out Link");
			commonLib.waitForElement(loginPage.getTxtBoxUsername(),
					"User Name Text box");
			if (commonLib.isDisplayed(loginPage.getTxtBoxUsername())) {
				commonLib
						.logOnSuccess("Logout", "User Logged out successfully");
			} else {
				commonLib.logOnError("Logout", "User has not been Logged out");
			}
		} else {
			commonLib
					.logOnError("Logout",
							"User Name dropdown is not getting displayed for logging out");
		}
	}

	public void closeBrowser() {
		reports.startTest("Close Browser");
		driver.quit();
		commonLib.logOnInfo("Close Browser", "Browser is closed");
	}

}
