package com.scripts.businessLogic;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.HomePagePL;
import com.scripts.pageObjectRepository.ManageUsersPL;

public class ManageUsersBL extends Driver {
	HomePagePL homePage = PageFactory.initElements(driver, HomePagePL.class);
	ManageUsersPL manageUsers = PageFactory.initElements(driver,
			ManageUsersPL.class);
	CommonUtills commonLib = new CommonUtills();

	String currentUrl;
	String verificationLink;

	// Navigated to Administrator/Analyst page through TM
	public void navigateToAdministratorPage() throws Exception {

		commonLib.click(homePage.getUsersMenu(), "Users Menu");
		commonLib.click(homePage.getAdministratorAnalystMenu(),
				"Administrator Analyst Menu");
		commonLib.waitForPageToLoad();
	}

	
	// Add User settings for DA
	public void keyContactRoleDA(String username, String entityType,
			String district, String school, String userType, String keyContact)
			throws Exception {
		boolean flag = false;
		commonLib.logOnInfo("Key Contact Role", "Adding Key Contact Role");
		if (userType.equalsIgnoreCase("DA")) {
			if (entityType.equals("TM")) {
				Select dropdownEntity = new Select(
						manageUsers.getDrpdownEntityType());
				dropdownEntity.selectByVisibleText(entityType);
			} else if (entityType.equals("District")) {
				commonLib.selectDrpDownValue(
						manageUsers.getDrpdownEntityType(), entityType,
						"Entity Type Drpdown");
				commonLib.waitForPageToLoad();
				commonLib.typeText(manageUsers.getTxtBoxDistrict(), district,
						"District TxtBox");
				
//				commonLib.typeKeys(manageUsers.getTxtBoxDistrict(), Keys.TAB);
//				commonLib.typeKeys(manageUsers.getTxtBoxDistrict(), Keys.TAB);
//				commonLib.typeKeys(manageUsers.getTxtBoxDistrict(), Keys.TAB);
				/*commonLib.typeKeys(manageUsers.getTxtBoxDistrict(), Keys.DOWN);
				commonLib.typeKeys(manageUsers.getTxtBoxDistrict(), Keys.UP);
				commonLib.typeKeys(manageUsers.getTxtBoxDistrict(), Keys.);*/
				
				
				
			}
			
		}
		commonLib.typeText(manageUsers.getTxtBoxEmailAdd(), username,
				"Email TxtBox");
		commonLib.click(manageUsers.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		commonLib.click(manageUsers.getBtnEditUser(), "Edit User Btn");
		commonLib.waitForPageToLoad();
		commonLib.click(manageUsers.getBtnOkay(), "Ok Btn");
		commonLib.waitForPageToLoad();
			commonLib.click(manageUsers.getBtnSaveUser(), "Save User Btn");
			commonLib.waitForPageToLoad();
				commonLib.logOnSuccess("Key Contact Role",
						"Key Contact Role added successfully");
				 commonLib.click(manageUsers.getBtnCloseSuccessMsg(),
					"Close Success Msg Btn");
			commonLib.waitForPageToLoad();

		}

	

	// Add User without entering mandatory details
	public void verifyMandatoryFields() throws Exception {
		commonLib.logOnInfo("Admin_Analyst creation",
				"Verifying Mandatory Fields");
		commonLib.click(manageUsers.getBtnAddUser(), "Add User Btn");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(manageUsers.getTxtBoxEmailAdd())) {
			commonLib.logOnError("Admin_Analyst creation",
					"'Add_Edit User' page is not loaded");
		} else {
			commonLib.click(manageUsers.getBtnSaveUser(), "Save button");
			commonLib.waitForPageToLoad();
			if (!commonLib.isDisplayed(manageUsers.getErrorMsgUser())) {
				commonLib.logOnError("Admin_Analyst creation",
						"User is created without Entering Mandatory Fields");
			} else {
				commonLib
						.logOnSuccess("Admin_Analyst creation",
								"Mandatory fields verified successfully while adding User");
			}
		}

	}

	// Add User using Mandatory Details

	public void addUser(String userType, String username, String firstName,
			String lastName, String entityType, String userRole,
			String district, String school, String currentUrl) throws Exception {
		commonLib.logOnInfo("Admin_Analyst creation", "Creating Admin_Analyst");
		if (userType.equalsIgnoreCase("DA")) {
			if (entityType.equals("TM")) {
				commonLib.selectDrpDownValue(
						manageUsers.getDrpdwnEntityTypeAddUser(), entityType,
						"Entity Type");
			} else if (entityType.equals("District")) {
				commonLib.selectDrpDownValue(
						manageUsers.getDrpdwnEntityTypeAddUser(), entityType,
						"Entity Type");
				if (commonLib.isDisplayed(manageUsers.getTxtBoxDistrict(),
						"District TxtBox")) {
					commonLib.typeText(manageUsers.getTxtBoxDistrict(),
							district, "District TxtBox");
					commonLib.typeKeys(manageUsers.getTxtBoxDistrict(),
							Keys.DOWN);
					commonLib
							.typeKeys(manageUsers.getTxtBoxDistrict(), Keys.UP);
				}
			} else if (entityType.equals("Schools")) {
				commonLib.selectDrpDownValue(
						manageUsers.getDrpdwnEntityTypeAddUser(), entityType,
						"Entity Type");
				if (manageUsers.getTxtBoxDistrict().isDisplayed()) {
					commonLib.typeText(manageUsers.getTxtBoxDistrict(),
							district, "District TxtBx");
					commonLib.click(manageUsers.getFirstDistrictItem(),
							"First District Item");
					commonLib.waitForPageToLoad();
					commonLib.typeText(manageUsers.getTxtBoxSchool(), school,
							"School/Department Name TxtBx");
					commonLib
							.typeKeys(manageUsers.getTxtBoxSchool(), Keys.DOWN);
					commonLib.typeKeys(manageUsers.getTxtBoxSchool(), Keys.UP);
				}
			}
		}
		Thread.sleep(2000);
		commonLib.typeText(manageUsers.getTxtBoxFirstName(), firstName,
				"First Name TxtBx");
		commonLib.typeText(manageUsers.getTxtBoxLastName(), lastName,
				"Last Name TxtBx");
		commonLib.typeText(manageUsers.getTxtBoxEmailAdd(), username,
				"User Name TxtBx");
		commonLib.selectDrpDownValue(manageUsers.getDrpdownRole(), userRole,
				"User Role");
		commonLib.click(manageUsers.getBtnSaveUser(), "Save button");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(manageUsers.getBtnCloseSuccessMsg())) {
			commonLib.logOnError("Admin_Analyst creation", "User not created");
		} else {
			commonLib.logOnSuccess("Admin_Analyst creation",
					"User created successfully");
		}

		commonLib.click(manageUsers.getBtnCloseSuccessMsg(),
				"Close Success Msg Btn");
		commonLib.waitForPageToLoad();

	}

	// User Deactivate/Activate

	public void userDeActivate(String username, String entityType,
			String district, String school, String userType) throws Exception {
		commonLib.logOnInfo("Admin_Analyst Activation_Deactivation",
				" Activating_Deactivating User");
		if (userType.equalsIgnoreCase("TM")) {
			if (entityType.equals("TM")) {
				Select dropdownEntity = new Select(
						manageUsers.getDrpdownEntityType());
				dropdownEntity.selectByVisibleText(entityType);
			} else if (entityType.equals("District")) {
				commonLib.selectDrpDownValue(
						manageUsers.getDrpdownEntityType(), entityType,
						"�ntity Type Drpdown");
				commonLib.waitForPageToLoad();
				commonLib.typeText(manageUsers.getTxtBoxDistrict(), district,
						"District TxtBox");
				commonLib.typeKeys(manageUsers.getTxtBoxDistrict(), Keys.DOWN);
				commonLib.typeKeys(manageUsers.getTxtBoxDistrict(), Keys.UP);
			} else if (entityType.equals("Schools")) {
				Select dropdownEntity = new Select(
						manageUsers.getDrpdownEntityType());
				dropdownEntity.selectByVisibleText("School");
				commonLib.waitForPageToLoad();
				commonLib.typeText(manageUsers.getTxtBoxDistrict(), district,
						"District TxtBox");
				commonLib.typeText(manageUsers.getTxtBoxSchool(), school,
						"School TxtBox");
			}
		}
		commonLib.typeText(manageUsers.getTxtBoxEmailAdd(), username,
				"Email TxtBox");
		commonLib.click(manageUsers.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.getAttribute(manageUsers.getProfileStatus(), "title")
				.equals("Active User/Location. Click here to deactivate")) {
			commonLib.click(manageUsers.getBtnDeActivate(), "Deactivate Btn");
			commonLib.waitForPageToLoad();
			commonLib.logOnSuccess("Admin_Analyst Activation_Deactivation",
					entityType + " admin/analyst user profile is deactivated");
		} else if (commonLib.getAttribute(manageUsers.getProfileStatus(),
				"title").equals(
				"Inactive User/Location. Click here to activate")) {
			commonLib.click(manageUsers.getBtnActivate(), "Activate Btn");
			commonLib.waitForPageToLoad();
			commonLib.logOnSuccess("Admin_Analyst Activation_Deactivation",
					"User activated/deactivated successfully");
		} else {
			commonLib.logOnError("Admin_Analyst Activation_Deactivation",
					"User is not activated/deactivated");
		}
	}

	// Search Admin/Analyst without using Mandatory Field
	public void userSearchWithoutMandatoryFields() throws Exception {
		commonLib.logOnInfo("Admin_Analyst Search",
				"Admin/Analyst Search Without Entering Mandatory Fields");
		Select dropdownEntity = new Select(manageUsers.getDrpdownEntityType());
		dropdownEntity.selectByVisibleText("School");
		commonLib.waitForPageToLoad();
		commonLib.click(manageUsers.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(manageUsers.getErrorMsgSearchAdmin(),
				"Error Message")) {
			commonLib
					.logOnSuccess("Admin_Analyst Search",
							"Admin/Analyst are not getting searched without adding Mandatory Details");
		} else {
			commonLib
					.logOnSuccess("Admin_Analyst Search",
							"Admin/Analyst are getting searched without adding Mandatory Details");
		}

	}

	// Edit User
	public void userEdit(String username, String entityType, String district,
			String school, String userType) throws InterruptedException {
		commonLib.logOnInfo("Edit User", " Editing User Profile");
		if (userType.equalsIgnoreCase("DA")) {
			if (entityType.equals("District")) {
				Select dropdownEntity = new Select(
						manageUsers.getDrpdownEntityType());
				dropdownEntity.selectByVisibleText(entityType);
			} else if (entityType.equals("District")) {
				commonLib.selectDrpDownValue(
						manageUsers.getDrpdownEntityType(), entityType,
						"�ntity Type Drpdown");
				commonLib.waitForPageToLoad();
				commonLib.typeText(manageUsers.getTxtBoxDistrict(), district,
						"District TxtBox");
				commonLib.typeKeys(manageUsers.getTxtBoxDistrict(), Keys.DOWN);
				commonLib.typeKeys(manageUsers.getTxtBoxDistrict(), Keys.UP);
			} else if (entityType.equals("Schools")) {
				Select dropdownEntity = new Select(
						manageUsers.getDrpdownEntityType());
				dropdownEntity.selectByVisibleText("School");
				commonLib.waitForPageToLoad();
				commonLib.typeText(manageUsers.getTxtBoxDistrict(), district,
						"District TxtBox");
				commonLib.typeText(manageUsers.getTxtBoxSchool(), school,
						"School TxtBox");
			}
		}

		commonLib.typeText(manageUsers.getTxtBoxEmailAdd(), username,
				"Email TxtBox");
		commonLib.waitForPageToLoad();
		commonLib.click(manageUsers.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		commonLib.waitForPageToLoad();
		commonLib.click(manageUsers.getBtnEditUser(), "Edit User Btn");
		commonLib.click(manageUsers.getBtnOkay(), "Ok Btn");
		commonLib.waitForPageToLoad();
		Thread.sleep(3000);
		commonLib.typeText(manageUsers.getTxtBoxLastName(), "new name1",
				"Last Name TxtBox");
		commonLib.click(manageUsers.getBtnSaveUser(), "Save User Btn");
		commonLib.waitForPageToLoad();
		commonLib.click(manageUsers.getBtnClose(), "Close Btn");
		commonLib.waitForPageToLoad();

		if (userType.equalsIgnoreCase("TM")) {
			if (entityType.equals("TM")) {
				Select dropdownEntity = new Select(
						manageUsers.getDrpdownEntityType());
				dropdownEntity.selectByVisibleText(entityType);
			} else if (entityType.equals("District")) {
				commonLib.selectDrpDownValue(
						manageUsers.getDrpdownEntityType(), entityType,
						"�ntity Type Drpdown");
				commonLib.waitForPageToLoad();
				commonLib.typeText(manageUsers.getTxtBoxDistrict(), district,
						"District TxtBox");
				commonLib.typeKeys(manageUsers.getTxtBoxDistrict(), Keys.DOWN);
				commonLib.typeKeys(manageUsers.getTxtBoxDistrict(), Keys.UP);
			} else if (entityType.equals("Schools")) {
				Select dropdownEntity = new Select(
						manageUsers.getDrpdownEntityType());
				dropdownEntity.selectByVisibleText("School");
				commonLib.waitForPageToLoad();
				commonLib.typeText(manageUsers.getTxtBoxDistrict(), district,
						"District TxtBox");
				commonLib.typeText(manageUsers.getTxtBoxSchool(), school,
						"School TxtBox");
			}
		}
		commonLib.typeText(manageUsers.getTxtBoxEmailAdd(), username,
				"Email TxtBox");
		commonLib.click(manageUsers.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		String NewName = commonLib.getText(manageUsers.getTextName());

		if (NewName.equals("new name1")) {
			commonLib.logOnSuccess("Edit User", "User edited successfully");
		} else {
			commonLib.logOnError("Edit User", "User not edited");
		}

	}

	// User Send New Password link

	public void userSndNewPaswrdLnk(String username, String entityType,
			String district, String school, String userType, String currentUrl)
			throws InterruptedException {
		commonLib.logOnInfo("Send New Password Link ",
				"Sending New Password link to User");
		if (userType.equalsIgnoreCase("TM")) {
			if (entityType.equals("TM")) {
				Select dropdownEntity = new Select(
						manageUsers.getDrpdownEntityType());
				dropdownEntity.selectByVisibleText(entityType);
			} else if (entityType.equals("District")) {
				commonLib.selectDrpDownValue(
						manageUsers.getDrpdownEntityType(), entityType,
						"�ntity Type Drpdown");
				commonLib.waitForPageToLoad();
				commonLib.typeText(manageUsers.getTxtBoxDistrict(), district,
						"District TxtBox");
				commonLib.typeKeys(manageUsers.getTxtBoxDistrict(), Keys.DOWN);
				commonLib.typeKeys(manageUsers.getTxtBoxDistrict(), Keys.UP);
			} else if (entityType.equals("Schools")) {
				Select dropdownEntity = new Select(
						manageUsers.getDrpdownEntityType());
				dropdownEntity.selectByVisibleText("School");
				commonLib.waitForPageToLoad();
				commonLib.typeText(manageUsers.getTxtBoxDistrict(), district,
						"District TxtBox");
				commonLib.typeText(manageUsers.getTxtBoxSchool(), school,
						"School TxtBox");
			}
		}

		commonLib.typeText(manageUsers.getTxtBoxEmailAdd(), username,
				"Email TxtBox");
		commonLib.waitForPageToLoad();
		commonLib.click(manageUsers.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		commonLib.waitForPageToLoad();
		commonLib.click(manageUsers.getBtnEditUser(), "Edit User Btn");
		commonLib.click(manageUsers.getBtnOkay(), "Ok Btn");
		commonLib.waitForPageToLoad();
		commonLib.click(manageUsers.getSndNewPaswrdLnk(),
				"Send New Password Link");
		commonLib.waitForPageToLoad();
		if (!commonLib
				.isDisplayed(manageUsers.getMsgCnfrmationSndNewPassword())) {
			commonLib.logOnError("Send New Password Link",
					"New Password Link has not been sent");
		} else {
			commonLib.logOnSuccess("Send New Password Link",
					"New Password Link has been sent successfully");
		}

		commonLib.click(manageUsers.getBtnCancelEditUser(), "Cancel Button");
		commonLib.waitForPageToLoad();
	}

	// Account Verification
	public void accountVerification(String userName, String password)
			throws Exception {
		commonLib.logOnInfo("Admin_Analyst account verification",
				"Setting password and account verification");
		mailVerification(userName);
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(manageUsers.getTxtBoxPwd(),
				"Password TxtBox")) {
			commonLib
					.logOnError("Admin_Analyst account verification",
							"Set password and account verification page is not displayed");
			return;
		}
		commonLib.typeText(manageUsers.getTxtBoxPwd(), password,
				"Password TxtBox");
		commonLib.typeText(manageUsers.getTxtBoxRePwd(), password,
				"Re-enter Password TxtBox");
		commonLib.click(manageUsers.getBtnLogin(), "Btn Login");
		commonLib.click(manageUsers.getBtnOkResetPwd(), "Btn Ok Reset Pwd");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(homePage.getUsersMenu(), "Users Menu")) {
			commonLib
					.logOnSuccess("Admin_Analyst account verification",
							"Password set and user logged in successfully after account verification");
		}
	}

	// Mail Verification
	public void mailVerification(String userName) throws Exception {
		int timeLimit = 10;
		boolean flag = false;
		currentUrl = driver.getCurrentUrl();
		if (userName.contains("mailinator")) {
			driver.get("https://www.mailinator.com/");
			commonLib.waitForPageToLoad();
			commonLib.typeText(manageUsers.getLoginMailinator(), userName,
					"Malinator mailId text box");
			commonLib.click(manageUsers.getBtnGoMailinator(),
					"Mailinator Login");
			commonLib.waitForPageToLoad();
			commonLib.click(manageUsers.getBtnRefresh(), "Refresh Btn");
			for (int i = 0; i < timeLimit; i++) {
				if (commonLib.isDisplayed(manageUsers.getAddUserMail())) {
					commonLib.click(manageUsers.getAddUserMail(),
							"Add User Mail");
					Thread.sleep(2000);
					driver.switchTo().frame("publicshowmaildivcontent");
					verificationLink = commonLib.getText(
							manageUsers.getLinkVerification(),
							"Verification Link");
					driver.switchTo().defaultContent();
					driver.get(verificationLink);
					commonLib.waitForPageToLoad();
					flag = true;
					break;
				} else if (commonLib.isDisplayed(manageUsers.getMailWelcome(),
						"Welcome Mail")) {
					commonLib.click(manageUsers.getMailWelcome(),
							"Welcome Mail");
					driver.switchTo().frame("publicshowmaildivcontent");
					verificationLink = commonLib.getText(
							manageUsers.getLinkVerification(),
							"Verification Link");
					driver.switchTo().defaultContent();
					driver.get(verificationLink);
					commonLib.waitForPageToLoad();
					flag = true;

					break;
				} else {
					Thread.sleep(5000);
					commonLib.click(manageUsers.getBtnRefresh(), "Refresh Btn");
				}

			}
			if (!flag) {
				commonLib.logOnError("Mail Verification",
						"Add User Mail not received");
				driver.get(currentUrl);
				commonLib.click(manageUsers.getBtnCloseSuccessMsg(),
						"Close Success Msg Btn");
				commonLib.waitForPageToLoad();
			}
		}
		if (userName.contains("yopmail")) {
			driver.get("http://www.yopmail.com/en/");
			commonLib.waitForPageToLoad();
			commonLib.typeText(manageUsers.getLoginYopmail(), userName,
					"Enter Mail ID in Yopmail");
			commonLib.click(manageUsers.getBtnChkInboxYopmail(),
					"Check Inbox Btn");
			commonLib.waitForPageToLoad();
			commonLib.click(manageUsers.getBtnRefreshYopmail(), "Refresh Btn");

			for (int i = 0; i < timeLimit; i++) {
				driver.switchTo().frame("ifinbox");
				if (commonLib.isDisplayed(manageUsers.getMailYopmailAddUser())) {
					commonLib.click(manageUsers.getMailYopmailAddUser(),
							"Add User Mail");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("ifmail");
					verificationLink = commonLib.getText(
							manageUsers.getLinkVerification(),
							"Verification Link");
					driver.switchTo().defaultContent();
					driver.get(verificationLink);
					commonLib.waitForPageToLoad();
					flag = true;
					break;
				}

				Thread.sleep(5000);
				driver.switchTo().defaultContent();
				commonLib.click(manageUsers.getBtnRefreshYopmail(),
						"Refresh Btn");
			}
			if (!flag) {
				commonLib
						.logOnError("Mail Verification",
								"Add User Mail not received, Account Verification failed");
				driver.get(currentUrl);
				commonLib.click(manageUsers.getBtnCloseSuccessMsg(),
						"Close Success Msg Btn");
				commonLib.waitForPageToLoad();
			}
		}
	}

	// Send New Password link
	public void sndNewPaswrdLnkVerification(String userName) throws Exception {
		commonLib.logOnInfo("Send New Password mail",
				"Send New Password Mail verification");
		int timeLimit = 10;
		boolean flag = false;
		currentUrl = driver.getCurrentUrl();
		if (userName.contains("mailinator")) {
			driver.get("https://www.mailinator.com/");
			commonLib.waitForElement(manageUsers.getLoginMailinator(),
					"Mailinator Login Btn");
			commonLib.typeText(manageUsers.getLoginMailinator(), userName,
					"Malinator mailId text box");
			commonLib.click(manageUsers.getBtnGoMailinator(),
					"Mailinator Login");
			commonLib
					.waitForElement(manageUsers.getBtnRefresh(), "Refresh Btn");
			commonLib.click(manageUsers.getBtnRefresh(), "Refresh Btn");
			for (int i = 0; i < timeLimit; i++) {
				if (commonLib.isDisplayed(manageUsers.getSndNewPaswrdMail())) {
					commonLib.click(manageUsers.getSndNewPaswrdMail(),
							"Send New Password Mail");
					Thread.sleep(2000);
					driver.switchTo().frame("publicshowmaildivcontent");
					verificationLink = commonLib.getText(
							manageUsers.getLinkVerification(),
							"Verification Link");
					driver.switchTo().defaultContent();
					driver.get(verificationLink);
					flag = true;
					commonLib.logOnSuccess(
							"Send New Password Mail Verification",
							"Send New Password Mail received successfully");
					break;
				}
			}
			if (!flag) {
				commonLib.logOnError("Send New Password Mail Verification",
						"Send New Password Mail not received");
			}

		}
		System.out.println("userName  "+userName);
		if (userName.contains("yopmail")) {
			driver.get("http://www.yopmail.com/en/");
			commonLib.waitForPageToLoad();
			commonLib.typeText(manageUsers.getLoginYopmail(), userName,
					"Enter Mail ID in Yopmail");
			commonLib.click(manageUsers.getBtnChkInboxYopmail(),
					"Check Inbox Btn");
			commonLib.waitForPageToLoad();
			commonLib.click(manageUsers.getBtnRefreshYopmail(), "Refresh Btn");

			for (int i = 0; i < timeLimit; i++) {
				driver.switchTo().frame("ifinbox");
				if (commonLib.isDisplayed(manageUsers
						.getMailLnkSendNewPasswrdYopmail())) {
					commonLib.click(manageUsers.getMailLnkSendNewPasswrdYopmail(),
							"Send New Password Mail");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("ifmail");
					verificationLink = commonLib.getText(
							manageUsers.getLinkVerification(),
							"Verification Link");
					driver.switchTo().defaultContent();
					driver.get(verificationLink);
					flag = true;
					commonLib.logOnSuccess(
							"Send New Password Mail Verification",
							"Send New Password Mail received successfully");
					break;
				}

				Thread.sleep(5000);
				driver.switchTo().defaultContent();
				commonLib.click(manageUsers.getBtnRefreshYopmail(),
						"Refresh Btn");
			}
			if (!flag) {
				commonLib.logOnError("Send New Password Mail Verification",
						"Send New Password Mail not received");
			}
		}
		driver.get(currentUrl);
	}

}
