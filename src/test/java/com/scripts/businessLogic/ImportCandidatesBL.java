package com.scripts.businessLogic;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ImportCandidatesPL;
import com.scripts.pageObjectRepository.ManageJobOrderPL;


public class ImportCandidatesBL extends Driver {

	ImportCandidatesPL importCandidatesPage = PageFactory.initElements(driver, ImportCandidatesPL.class);
	ManageJobOrderPL manageJOPage = PageFactory.initElements(driver, ManageJobOrderPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void navigateToImportCandidatePage() throws Exception {
		commonLib.click(importCandidatesPage.getMenuImport(), "Import Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(importCandidatesPage.getSubMenuCandidates(), "Candidates Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void importCandidates(String file, String JobId, String district, String email) throws Exception {

		commonLib.logOnInfo("Import Candidates", "Importing Candidate for job");
		navigateToImportCandidatePage();
		commonLib.typeText(importCandidatesPage.getTxtdistrictName(), district, "District TxtBox");
		
		//commonLib.click(importCandidatesPage.getTxtdistrictName(), "Click on District edit field");
		
		commonLib.typeText(importCandidatesPage.getFileUpload(), file, "File Upload");
		
		commonLib.click(importCandidatesPage.getBtnImport(), "Import Btn");
		commonLib.waitForElement(importCandidatesPage.getBtnAccept(), "Accept Btn");
		if (commonLib.isDisplayed(importCandidatesPage.getErrorMessage())) {
			commonLib.logOnError("Import Candidates", "Candidate are not imported");
			return;
		}
		if (commonLib.isEnabled(importCandidatesPage.getBtnAccept())) {
			commonLib.click(importCandidatesPage.getBtnAccept(), "Accept Btn");

		} else {
			commonLib.click(importCandidatesPage.getBtnReject(), "Reject Btn");
			commonLib.logOnError("Import Candidates", "Candidate data is duplicate");
			return;
		}
		Thread.sleep(5000);
		if (commonLib.isDisplayed(importCandidatesPage.getBtnClose())) {
			commonLib.logOnSuccess("Import Candidates", "Candidate imported successfully for job");
			commonLib.click(importCandidatesPage.getBtnClose(), "Close Btn");
			commonLib.waitForPageToLoad();
			Thread.sleep(5000);
		}

		commonLib.logOnInfo("Search Import Candidate", "Searching newly imported Candidate");
		commonLib.click(manageJOPage.getBtnMenuJobOrders(), "Job Order Menu tab");
		commonLib.click(manageJOPage.getMenuOptnDJO(), "District Job Order sub menu option");
		commonLib.waitForPageToLoad();
		commonLib.typeText(manageJOPage.getTxtBoxJobID(), JobId, "Job Order Title TxtBox");
		commonLib.click(manageJOPage.getBtnSearchJobs(), "Search buton");
		commonLib.waitForPageToLoad();
		for (int i = 0; i < manageJOPage.getLinkJobId().size(); i++) {
			if (manageJOPage.getLinkJobId().get(i).getText().contains(JobId)) {
				commonLib.click(manageJOPage.getLinkCGIconDA().get(i), "CG icon");
			}
		}
		commonLib.waitForPageToLoad();
		String handle1 = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		commonLib.waitForPageToLoad();
		commonLib.click(manageJOPage.getExpandCandidatesGrid(), "Expand Candidates Grid");
		commonLib.waitForPageToLoad();
		System.out.println(manageJOPage.getCandidatesEmails().size());
		for (int i = 0; i < manageJOPage.getCandidatesEmails().size(); i++) {
			if (manageJOPage.getCandidatesEmails().get(i).getText().contains(email)) {
				commonLib.logOnSuccess("Search Import Candidate", "Candidate found successfully");
				return;
			}
		}
		commonLib.logOnError("Search Import Candidate", "Candidate not found");

	}

}
