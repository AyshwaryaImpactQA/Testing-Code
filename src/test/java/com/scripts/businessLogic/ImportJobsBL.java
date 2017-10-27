package com.scripts.businessLogic;

import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ImportJobsPL;

public class ImportJobsBL extends Driver {
	ImportJobsPL importjobsPage = PageFactory.initElements(driver,
			ImportJobsPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void navigateToImportPage() throws Exception {
		commonLib.click(importjobsPage.getMenuImport(), "Import Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(importjobsPage.getSubMenuJobs(), "Jobs Sub Menu");
		commonLib.waitForPageToLoad();

	}

	public void importJobs(String file, String districtName, String jobTitle)
			throws Exception {
		commonLib.logOnInfo("Import Jobs", "Importing jobs");
		navigateToImportPage();
		commonLib.typeText(importjobsPage.getTxtBoxDistrict(), districtName,
				"District TxtBox");
		commonLib.waitForPageToLoad();
		commonLib.typeText(importjobsPage.getFileUpload(), file, "File Upload");
		commonLib.waitForPageToLoad();
		commonLib.click(importjobsPage.getBtnImport(), "Import Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(importjobsPage.getErrorMessage())) {
			commonLib.logOnError("Import Jobs", "User are not imported");
			return;
		}
		if (commonLib.isEnabled(importjobsPage.getBtnAccept())) {
			commonLib.click(importjobsPage.getBtnAccept(), "Accept Btn");

		} else {
			commonLib.click(importjobsPage.getBtnReject(), "Reject Btn");
			commonLib.logOnError("Import Jobs", "Job data is not valid");
			return;
		}
		Thread.sleep(15000);
		if (commonLib.isDisplayed(importjobsPage.getConfirmJobMessage())) {
			commonLib.logOnSuccess("Import Jobs", "Jobs imported sucessfully");
			commonLib.click(importjobsPage.getBtnClose(), "Close Btn");
			commonLib.waitForPageToLoad();

		}
		commonLib
				.logOnInfo("Search Import Job", "Searching newly imported job");
		commonLib.click(importjobsPage.getMenuJobOder(), "Job Order Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(importjobsPage.getSubMenuDJO(),
				"District Job Order Sub Menu");
		commonLib.waitForPageToLoad();
		commonLib.typeText(importjobsPage.getTxtBoxKeyword(), jobTitle,
				"KeyWord Search TxtBox");
		commonLib.waitForPageToLoad();
		commonLib.click(importjobsPage.getBtnSearch(), "Search Btn");
		Thread.sleep(5000);
		if (!commonLib.isDisplayed(importjobsPage.getMsgNoRecordFound())) {
			commonLib.logOnSuccess("Search Import Job",
					"Job found successfully");
			return;
		}
		commonLib.logOnError("Search Import Job", "Job not found");

	}

}
