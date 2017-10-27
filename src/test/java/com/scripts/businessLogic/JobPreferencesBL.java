package com.scripts.businessLogic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utils.screenshot.Test_Utils;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.JobPreferencesPL;

public class JobPreferencesBL extends Driver {

	Test_Utils screenLib = new Test_Utils();
	JobPreferencesPL jobPreferencePage = PageFactory.initElements(driver,
			JobPreferencesPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void setJobPreferences() throws InterruptedException {
		commonLib.logOnInfo("Setting Job Preferences for Candidate",
				"Setting Job Preferences for Candidate");
		commonLib.click(jobPreferencePage.getJobPrefrences(),
				"Job Preference Menu");
		commonLib.waitForPageToLoad();
		for (WebElement el : jobPreferencePage.getCheckBoxPrefrences()) {
			if(!commonLib.isSelected(el, "Preference chkBox")){
				commonLib.click(el, "Preference chkBox");
			}
		}
		for (WebElement el1 : jobPreferencePage.getChkBxRegions()) {
			if(!commonLib.isSelected(el1, "Regions chkBox")){
				commonLib.click(el1, "Regions chkBox");
			}
		}
		
		for (WebElement e2 : jobPreferencePage.getRadioBtnProfileSharing()) {
			if(!commonLib.isSelected(e2, "Profile sharing")){
				commonLib.click(e2, "Profile sharing");
			}
		}
		
		commonLib.waitForElement(jobPreferencePage.getBtnSavePreferences(),
				"Save Preferences");
		commonLib.click(jobPreferencePage.getBtnSavePreferences(),
				"Save Preferences");
		if (commonLib.isDisplayed(jobPreferencePage.getSetPrefPopUp(),
				"Set Preference PopUp")) {
			commonLib.click(jobPreferencePage.getSetPrefPopUpClose(),
					"Close Pop Up");
			commonLib.click(jobPreferencePage.getBtnSavePreferences(),
					"Save Preferences Btn");
		}
		//commonLib.waitForPageToLoad();
		Thread.sleep(5000);
		if (commonLib.getText(jobPreferencePage.getJobPreferenceStatus(),
				"Status job preference").equals("Completed")) {
			commonLib.logOnSuccess("Setting Job Preferences for Candidate",
					"Job Preferences successfully set for the Candidate");
		} else {
			commonLib.logOnError("Setting Job Preferences for Candidate",
					"Job Preferences for the Candidate is Incomplete");
		}
	}

}
