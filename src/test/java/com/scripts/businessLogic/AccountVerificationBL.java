package com.scripts.businessLogic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.HomePagePL;
import com.scripts.pageObjectRepository.LoginPL;
import com.scripts.pageObjectRepository.ManageUsersPL;

public class AccountVerificationBL extends Driver {
//
	String verificationLink;
	String currentUrl;
	ManageUsersPL mngUserPage = PageFactory.initElements(driver,
			ManageUsersPL.class);
	HomePagePL homePage = PageFactory.initElements(driver, HomePagePL.class);
	LoginPL loginPage = PageFactory.initElements(driver, LoginPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void accountVerification(String userName, String password)
			throws Exception {
		commonLib.logOnInfo("Admin_Analyst account verification",
				"Setting password and account verification");
		mailVerification(userName);
		if (!commonLib.isDisplayed(mngUserPage.getTxtBoxPwd(),
				"Password TxtBox")) {
			commonLib
					.logOnError("Admin_Analyst account verification",
							"Set password and account verification page is not displayed");
			return;
		}
		commonLib.typeText(mngUserPage.getTxtBoxPwd(), password,
				"Password TxtBox");
		commonLib.typeText(mngUserPage.getTxtBoxRePwd(), password,
				"Re-enter Password TxtBox");
		commonLib.click(mngUserPage.getBtnLogin(), "Btn Login");
		commonLib.click(mngUserPage.getBtnOkResetPwd(), "Btn Ok Reset Pwd");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(homePage.getUsersMenu(), "Users Menu")) {
			commonLib.logOnError("Admin_Analyst account verification",
					"Account verification and login failed");
		} else {
			commonLib.logOnSuccess("Admin_Analyst account verification",
					"Password set and user logged in");
		}
	}
//
	public void accountVerificationCandidate(String userName) throws Exception {
		commonLib.logOnInfo("Candidate account verification",
				"Candidate account verification");
		mailVerification(userName);
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(loginPage.getBtnSignUp())) {
			commonLib.logOnSuccess("Candidate account verification",
					"Account verification succeed");
		} else {
			commonLib.logOnError("Candidate account verification",
					"Account verification failed");
		}
	}

	public void mailVerification(String userName) throws Exception {
		int timeLimit = 10;
		boolean flag = false;
		currentUrl = driver.getCurrentUrl();
		if (userName.contains("mailinator")) {
			driver.get("https://www.mailinator.com/");
			commonLib.waitForElement(mngUserPage.getLoginMailinator(),
					"Mailinator Login Btn");
			commonLib.typeText(mngUserPage.getLoginMailinator(), userName,
					"Malinator mailId text box");
			commonLib.click(mngUserPage.getBtnGoMailinator(),
					"Mailinator Login");
			commonLib
					.waitForElement(mngUserPage.getBtnRefresh(), "Refresh Btn");
			commonLib.click(mngUserPage.getBtnRefresh(), "Refresh Btn");
			for (int i = 0; i < timeLimit; i++) {
				if (commonLib.isDisplayed(mngUserPage.getAddUserMail(),
						"Add User Mail")) {
					commonLib.click(mngUserPage.getAddUserMail(),
							"Add User Mail");
					driver.switchTo().frame("publicshowmaildivcontent");
					verificationLink = commonLib.getText(
							mngUserPage.getLinkVerification(),
							"Verification Link");
					driver.switchTo().defaultContent();
					driver.get(verificationLink);
					flag = true;
					break;
				} else if (commonLib.isDisplayed(mngUserPage.getMailWelcome(),
						"Welcome Mail")) {
					commonLib.click(mngUserPage.getMailWelcome(),
							"Welcome Mail");
					driver.switchTo().frame("publicshowmaildivcontent");
					verificationLink = commonLib.getText(
							mngUserPage.getLinkVerification(),
							"Verification Link");
					driver.switchTo().defaultContent();
					driver.get(verificationLink);
					flag = true;
					break;
				} else {
					Thread.sleep(5000);
					commonLib.click(mngUserPage.getBtnRefresh(), "Refresh Btn");
				}
			}
			if (!flag) {
				commonLib.logOnError("Mail Verification",
						"Add User Mail not received");
			}
		}
		if (userName.contains("yopmail")) {
			driver.get("http://www.yopmail.com/en/");
			
			commonLib.waitForPageToLoad();
			commonLib.typeText(mngUserPage.getLoginYopmail(), userName,
					"Enter Mail ID in Yopmail");
			commonLib.screenshot("Mail Validation", "Mail Validation");
			commonLib.click(mngUserPage.getBtnChkInboxYopmail(),
					"Check Inbox Btn");
			commonLib.waitForPageToLoad();
			commonLib.click(mngUserPage.getBtnRefreshYopmail(), "Refresh Btn");
			for (int i = 0; i < timeLimit; i++) {
				driver.switchTo().frame("ifinbox");
				if (commonLib.isDisplayed(mngUserPage.getMailYopmailAddUser())) {
					commonLib.click(mngUserPage.getMailYopmailAddUser(),
							"Add User Mail");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("ifmail");
					verificationLink = commonLib.getText(
							mngUserPage.getLinkVerification(),
							"Verification Link");
					commonLib.screenshot("Mail Validation", "Received mail");
					driver.switchTo().defaultContent();
					driver.get(verificationLink);
					commonLib.waitForPageToLoad();
					flag = true;
					break;
				} else if (commonLib.isDisplayed(mngUserPage
						.getMailYopmailAddUser())) {
					commonLib.click(mngUserPage.getMailYopmailAddUser(),
							"Add Candidate Mail");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("ifmail");
					verificationLink = commonLib.getText(
							mngUserPage.getLinkVerification(),
							"Verification Link");
					driver.switchTo().defaultContent();
					driver.get(verificationLink);
					commonLib.waitForPageToLoad();
					flag = true;
					break;
				}

				Thread.sleep(5000);
				driver.switchTo().defaultContent();
				commonLib.click(mngUserPage.getBtnRefreshYopmail(),
						"Refresh Btn");
			}
			if (!flag) {
				commonLib
						.logOnError("Mail Verification",
								"Add User/Candidate Mail not received, Account Verification failed");
				driver.get(currentUrl);
				commonLib.click(mngUserPage.getBtnCloseSuccessMsg(),
						"Close Success Msg Btn");
				commonLib.waitForPageToLoad();
			}
		}
	}
}



