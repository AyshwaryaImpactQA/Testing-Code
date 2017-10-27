package com.scripts.businessLogic;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.CandidatePoolPL;
import com.scripts.pageObjectRepository.ManageDistPrivilegePL;

public class CandidatesPoolBL extends Driver {

	CandidatePoolPL candidatePoolPage = PageFactory.initElements(driver,
			CandidatePoolPL.class);
	ManageDistPrivilegePL mngDistPrivPage = PageFactory.initElements(driver,
			ManageDistPrivilegePL.class);
	CommonUtills commonLib = new CommonUtills();

	public void navigateToCandidatePoolPage() throws Exception {
		commonLib.click(candidatePoolPage.getUsersMenu(), "Users Menu");
		commonLib.click(candidatePoolPage.getCandidateSubMenu(),
				"Candidates Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void settingForDisplayedColumn() throws Exception {
		commonLib.logOnInfo("Privilege for Displayed Columns",
				"Setting district privilege for displayed columns");
		commonLib.click(mngDistPrivPage.getBtnEditDstrct(), "Edit Icon");
		commonLib.waitForPageToLoad();
		if (commonLib.getAttribute(
				candidatePoolPage.getAccordionCandidateGrid(), "class")
				.contains("collapsed")) {
			commonLib.click(candidatePoolPage.getAccordionCandidateGrid(),
					"Camdidate Grid Accordion");
			Thread.sleep(2000);
		}
		List<WebElement> chkBoxColumnsInCandidateGrid = candidatePoolPage
				.getChkBoxColumnsInCandidateGrid();
		for (WebElement temp : chkBoxColumnsInCandidateGrid) {
			if (!commonLib.isSelected(temp)) {
				commonLib.click(temp, "Column ChkBox");
			}
		}
		commonLib.logOnSuccess("Privilege for Displayed Columns",
				"District privilege for displayed columns setup done");
	}

	public void searchCandidate(String fname, String lname, String email,
			String district, String school) throws Exception {
		commonLib.logOnInfo("Search Candidate",
				"Searching candidate using filters");
		commonLib.typeText(candidatePoolPage.getTxtBoxFirstName(), fname,
				"First Name TxtBox");
		commonLib.typeText(candidatePoolPage.getTxtBoxLastName(), lname,
				"Last Name TxtBox");
		commonLib.typeText(candidatePoolPage.getTxtBoxEmail(), email,
				"Email TxtBox");
		commonLib.click(candidatePoolPage.getRadioBtnOther(),
				"Other Radio button");
		commonLib.click(candidatePoolPage.getLinkOpenAdvancedSearch(),
				"Open Advanced Search Link");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(candidatePoolPage.getTxtBoxDistrict())) {
			commonLib.typeText(candidatePoolPage.getTxtBoxDistrict(), district,
					"District TxtBox");
			Thread.sleep(2000);
			commonLib.click(candidatePoolPage.getFirstOptionDistrict(),
					"First Option District");
		}
		// if (commonLib.isDisplayed(candidatePoolPage.getTxtBoxSchool())) {
		// commonLib.typeText(candidatePoolPage.getTxtBoxSchool(), school,
		// "School TxtBox");
		// Thread.sleep(2000);
		// commonLib.click(candidatePoolPage.getFirstOptionSchool(),
		// "First Option School");
		// }
		commonLib.click(candidatePoolPage.getBtnSearchCandidates(),
				"Search Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(candidatePoolPage.getLinkEmailAddress())) {
			commonLib.logOnSuccess("Search Candidate",
					"Candidate using filters searched successfully");
		} else {
			commonLib.logOnError("Search Candidate", "Candidate not found");
		}
	}

	public void activateDeactivateCandidate() throws Exception {
		commonLib.logOnInfo("Deactivate Candidate", "Deactivating candidate");
		commonLib.click(candidatePoolPage.getLinkActivateDeactivate(),
				"Deactivate Link");
		commonLib.waitForPageToLoad();
		if (commonLib.getText(candidatePoolPage.getLinkActivateDeactivate())
				.equals("Activate")) {
			commonLib.logOnSuccess("Deactivate Candidate",
					"Candidate deactivated successfully");
			commonLib.logOnInfo("Activate Candidate", "Activating candidate");
			commonLib.click(candidatePoolPage.getLinkActivateDeactivate(),
					"Activate Link");
			commonLib.waitForPageToLoad();
			if (commonLib
					.getText(candidatePoolPage.getLinkActivateDeactivate())
					.equals("Deactivate")) {
				commonLib.logOnSuccess("Activate Candidate",
						"Candidate activated successfully");
			} else {
				commonLib.logOnError("Activate Candidate",
						"Candidate is not activated");
			}
		} else {
			commonLib.logOnError("Deactivate Candidate",
					"Candidate is not deactivated");
		}
	}

	public void engageActions() throws Exception {
		commonLib
				.logOnInfo("View EPI Accomodation", "Viewing EPI Accomodation");
		commonLib.click(candidatePoolPage.getIconEPIAccomodation(),
				"EPI Accomodation Icon");
		Thread.sleep(5000);
		if (commonLib.isDisplayed(candidatePoolPage.getPopupEPITime())) {
			commonLib.logOnSuccess("View EPI Accomodation",
					"EPI Accomodation loaded");
			commonLib.click(candidatePoolPage.getBtnCancelPopupEPITime(),
					"Cancel Btn");
			commonLib.waitForPageToLoad();
		} else {
			commonLib.logOnError("View EPI Accomodation",
					"EPI Accomodation not found");
		}
		commonLib.logOnInfo("View SP Accomodation",
				"Viewing Smart Policies Accomodation");
		commonLib.click(candidatePoolPage.getIconSmartPracticesAccommodation(),
				"Smart Practices Accomodation Icon");
		Thread.sleep(5000);
		if (commonLib.isDisplayed(candidatePoolPage
				.getPopupSmartPracticesAccomodation())) {
			commonLib.logOnSuccess("View SP Accomodation",
					"Smart Practices Accomodation loaded");
			commonLib.click(candidatePoolPage
					.getBtnClosePopupSmartPracticesAccomodation(), "Close Btn");
			commonLib.waitForPageToLoad();
		} else {
			commonLib.logOnError("View SP Accomodation",
					"Smart Practices Accomodation not found");
		}
		commonLib.logOnInfo("View Assessment Details",
				"Viewing Assessment Details");
		commonLib.click(candidatePoolPage.getIconAssessmentDetails(),
				"Assessment Details Icon");
		Thread.sleep(5000);
		if (commonLib
				.isDisplayed(candidatePoolPage.getPopupAssessmentDetails())) {
			commonLib.logOnSuccess("View Assessment Details",
					"Assessment Details loaded");
			commonLib.click(
					candidatePoolPage.getBtnClosePopupAssessmentDetails(),
					"Close Btn");
			commonLib.waitForPageToLoad();
		} else {
			commonLib.logOnError("View Assessment Details",
					"Assessment Details not found");
		}
	}

	public void viewJobs(String userType) throws Exception {
		commonLib.logOnInfo("View Jobs", "Viewing applied jobs");
		if (userType.equals("TM")) {
			commonLib.click(candidatePoolPage.getLinkViewJobsTM(),
					"Applied Jobs Link");
		} else {
			commonLib.click(candidatePoolPage.getLinkViewJobsDASA(),
					"Applied Jobs Link");
		}
		Thread.sleep(5000);
		if (commonLib.isDisplayed(candidatePoolPage.getPopupJobList())) {
			commonLib.logOnSuccess("View Jobs", "Applied jobs loaded");
			commonLib.click(candidatePoolPage.getBtnClosePopupJobList(),
					"Close Btn");
			commonLib.waitForPageToLoad();
		} else {
			commonLib.logOnError("View Jobs", "Applied jobs not found");
		}
	}

	public void addCandidateToOtherJob() throws Exception {
		commonLib.logOnInfo("Add Candidate to Other Job",
				"Adding candidate to other jobs");
		commonLib.click(candidatePoolPage.getIconAddCandidateToOtherJobs(),
				"Add Candidate to Other Jobs Icon");
		Thread.sleep(5000);
		commonLib.click(candidatePoolPage.getChkBoxJob(), "Job ChkBox");
		commonLib.click(candidatePoolPage.getBtnApplyToJob(),
				"Apply to Job Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(candidatePoolPage.getBtnOkJobApplied())) {
			commonLib.logOnSuccess("Add Candidate to Other Job",
					"Candidate is added to other jobs");
			commonLib.click(candidatePoolPage.getBtnOkJobApplied(), "Ok Btn");
			commonLib.waitForPageToLoad();
		} else {
			commonLib.logOnError("Add Candidate to Other Job",
					"Candidate is not added to other jobs");
		}
	}

	public void viewProfile() throws Exception {
		commonLib.logOnInfo("View Profile", "Viewing candidate profile");
		commonLib.click(candidatePoolPage.getLinkCandidateProfile(),
				"Profile Link");
		Thread.sleep(3000);
		if (commonLib.isDisplayed(candidatePoolPage
				.getHeaderCandidateProfilePopup())) {
			commonLib.logOnSuccess("View Profile",
					"Candidate profile loaded successfully");
			commonLib.click(
					candidatePoolPage.getBtnCloseCandidateProfilePopup(),
					"Close Btn");
			Thread.sleep(3000);
		} else {
			commonLib
					.logOnError("View Profile", "Candidate profile not loaded");
		}
	}

	public void applyActions() throws Exception {
		// Send Message
		commonLib.logOnInfo("Send Message", "Sending message to candidate");
		commonLib.click(candidatePoolPage.getChkBoxSelectAllCandidates(),
				"Select All Candidate ChkBox");
		commonLib
				.click(candidatePoolPage.getDrpDownAction(), "Action Dropdown");
		Thread.sleep(2000);
		commonLib.click(candidatePoolPage.getLinkSendMessage(),
				"Send Message Link");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(candidatePoolPage.getPopupSendMessage())) {
			commonLib
					.logOnSuccess("Send Message", "Send message form appeared");
			commonLib.click(candidatePoolPage.getBtnCancelPopupSendMessage(),
					"Cancel Btn");
			commonLib.waitForPageToLoad();
		} else {
			commonLib.logOnError("Send Message",
					"Send message form not appeared");
		}
		// Apply Tag
		commonLib
				.click(candidatePoolPage.getDrpDownAction(), "Action Dropdown");
		Thread.sleep(2000);
		commonLib.logOnInfo("Apply Tag", "Applying tags to candidate");
		commonLib.click(candidatePoolPage.getLinkApplyTag(), "Apply Tag Link");
		commonLib.waitForPageToLoad();
		commonLib.click(candidatePoolPage.getChkBoxTag(), "Tag Chkbox");
		commonLib.click(candidatePoolPage.getBtnApplyTags(), "Apply Tags Btn");
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
		if (commonLib.isDisplayed(candidatePoolPage.getImgTag())) {
			commonLib.logOnSuccess("Apply Tag", "Tag is applied successfully");
		} else {
			commonLib.logOnError("Apply Tag", "Tag is not applied");
		}
		// Print Resume
		commonLib
				.logOnInfo("Download Resume", "Downloading candidate's resume");
		commonLib.click(candidatePoolPage.getChkBoxSelectAllCandidates(),
				"Select All Candidate ChkBox");
		commonLib
				.click(candidatePoolPage.getDrpDownAction(), "Action Dropdown");
		Thread.sleep(2000);
		commonLib.click(candidatePoolPage.getLinkPrintResume(),
				"Print Resume Link");
		commonLib.waitForPageToLoad();
		commonLib.logOnSuccess("Download Resume",
				"Candidate's resume downloaded");
	}
}
