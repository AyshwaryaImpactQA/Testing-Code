package com.scripts.businessLogic;

import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ImportUserPL;

public class ImportUserBL extends Driver {

	ImportUserPL importuserPage = PageFactory.initElements(driver,
			ImportUserPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void navigateToImportUsersPage() throws Exception {
		commonLib.click(importuserPage.getMenuImport(), "Import Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(importuserPage.getSubMenuUsers(), "User Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void importUsers(String file, String districtName, String userEmail)
			throws Exception {
		commonLib.logOnInfo("Import Users", "Importing User");
		navigateToImportUsersPage();
		commonLib.typeText(importuserPage.getTxtdistrictName(), districtName,
				"District TxtBox");
		
		
		
		commonLib.waitForElement(importuserPage.getFileUpload(), "File Upload");
		
		
		commonLib.typeText(importuserPage.getFileUpload(), file, "File Upload");
		
		
		commonLib.waitForElement(importuserPage.getBtnImport(), "Import Btn");
		commonLib.click(importuserPage.getBtnImport(), "Import Btn");
		
		if (commonLib.isDisplayed(importuserPage.getErrorMessage())) {
			commonLib.logOnError("Import Users", "User are not imported");
			return;
		}
		commonLib.waitForPageToLoadWithCond(importuserPage.getBtnAccept());
		if (commonLib.isEnabled(importuserPage.getBtnAccept())) {
			commonLib.click(importuserPage.getBtnAccept(), "Accept Btn");

		} else {
			commonLib.click(importuserPage.getBtnReject(), "Reject Btn");
			commonLib.logOnError("Import Users", "User data is duplicate");
			return;
		}
		commonLib.waitForPageToLoadWithCond(importuserPage.getConfirmJobMessage());
		if (commonLib.isDisplayed(importuserPage.getConfirmJobMessage())) {
			commonLib.logOnSuccess("Import Users", "User imported successfully");
			commonLib.click(importuserPage.getBtnClose(), "Close Btn");
			commonLib.waitForPageToLoad();
		}
		commonLib.logOnInfo("Search Imported User",
				"Searching newly imported user");
		commonLib.click(importuserPage.getUserMenu(), "User Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(importuserPage.getSubMenuAdminAnalyst(),
				"Admin/Analyst Sub Menu");
		commonLib.waitForPageToLoad();
		commonLib.selectDrpDownValue(importuserPage.getDrpDownEntityType(),
				"District", "Entity Type DrpDown");
		commonLib.waitForPageToLoad();
		commonLib.typeText(importuserPage.getTxtonlyDistrictName(),
				districtName, "District Name TxtBox");
		commonLib.typeText(importuserPage.getEmailConfirmAddress(), userEmail,
				"User Email Id TxtBox");
		commonLib.click(importuserPage.getEmailSeacrhBtn(), "Search Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(importuserPage.getMsgNoRecordFound())) {
			commonLib.logOnError("Search Imported User", "User is not found");
		} else {
			commonLib.logOnSuccess("Search Imported User",
					"User found successfully");
		}

	}

}
