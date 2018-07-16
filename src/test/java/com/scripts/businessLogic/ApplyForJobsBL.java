package com.scripts.businessLogic;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utils.screenshot.Test_Utils;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ApplyForJobsPL;

public class ApplyForJobsBL extends Driver {

	Test_Utils screenLib = new Test_Utils();
	ApplyForJobsPL applyForJobsPage = PageFactory.initElements(driver,
			ApplyForJobsPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void applyByJobOpps(String district) throws Exception {
		commonLib.logOnInfo("Apply for Job", "Applying job through Job Opps");
		commonLib.waitForPageToLoad();
		commonLib.click(applyForJobsPage.getJobOpps(), "Menu Job Opps");
		commonLib.waitForPageToLoad();
		commonLib.typeText(applyForJobsPage.getTxtBoxDistrict(), district,
				"District TxtBox");
		commonLib.click(applyForJobsPage.getFirstElementInList(),
				"First Element");
		commonLib.click(applyForJobsPage.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		List<WebElement> columnButtonApplyJob = applyForJobsPage
				.getColumnButtonApplyJob();
		commonLib.click(columnButtonApplyJob.get(0), "Apply Icon");
		commonLib.waitForPageToLoad();
		commonLib.click(applyForJobsPage.getBtnApplyforJob(), "Apply Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(
				applyForJobsPage.getRadioButtonNoCoverLetter(),
				"Cover Letter TxtBox")) {
			commonLib.logOnSuccess("Apply for Job",
					"Job Application Flow started");
		} else {
			commonLib.logOnError("Apply for Job", "Job not applied");
		}
	}

	public void applyJobByTitle(String district, String jobTitle)
			throws Exception {
		System.out.println(jobTitle);
		commonLib.logOnInfo("Apply for Job", "Applying job through Job Opps");
		commonLib.waitForPageToLoad();
		commonLib.click(applyForJobsPage.getJobOpps(), "Menu Job Opps");
		//commonLib.waitForPageToLoad();
		//Thread.sleep(2000);
		
		commonLib.waitForPageToLoadWithCond(applyForJobsPage.getTxtBoxDistrict());
		
		commonLib.typeText(applyForJobsPage.getTxtBoxDistrict(), district,
				"District TxtBox");
		//Thread.sleep(2000);
		//commonLib.click(applyForJobsPage.getFirstElementInList(),"First Element");
		Thread.sleep(2000);
		commonLib.click(applyForJobsPage.getBtnSearch(), "Search Btn");
		
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
		commonLib.waitForPageToLoadWithCond(driver.findElement(By.xpath("//*[@id='tblGridJoF']/tbody/tr[1]/td[1]/a")));
		
		List<WebElement> columnJobTitle = applyForJobsPage.getColumnJobTitle();
		List<WebElement> jobActionIcons = applyForJobsPage.getJobActionIcons();
		for (int i = 0; i < columnJobTitle.size(); i++) {
			if (commonLib.getText(columnJobTitle.get(i)).equals(jobTitle)) 
			{ 
						System.out.println(driver.findElement(By.xpath("//*[@id='tblGridJoF']/tbody/tr[1]/td[1]/a")).getAttribute("href"));	
				commonLib.click(jobActionIcons.get(i), "Apply Icon");
				commonLib.waitForPageToLoad();
				break;
			}
		}   
		
		
		commonLib.waitForPageToLoadWithCond(applyForJobsPage.getBtnApplyforJob());
		commonLib.click(applyForJobsPage.getBtnApplyforJob(), "Apply Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(applyForJobsPage.getRadioButtonNoCoverLetter(),
				"Cover Letter TxtBox")) {
			commonLib.logOnSuccess("Apply for Job",
					"Job application flow started");
		} else {
			commonLib.logOnError("Apply for Job", "Job not applied");
		}
	}

	public void fillCoverLetter(String coverLetterTxt)
			throws InterruptedException {
		commonLib.logOnInfo("Filling Cover Letter",
				"Filling Cover Letter for job application");
		commonLib.waitForPageToLoadWithCond(applyForJobsPage.getRadioButtonNoCoverLetter());
		commonLib.click(applyForJobsPage.getRadioButtonNoCoverLetter(),
				"No Cover Letter Radio Btn");
		Thread.sleep(3000);
		commonLib.waitForPageToLoadWithCond(applyForJobsPage.getBtnSaveCoverLetter());
		Thread.sleep(3000);
		commonLib.click(applyForJobsPage.getBtnSaveCoverLetter(),
				"Save Cover Letter Btn");
	//	commonLib.waitForPageToLoadWithCond(applyForJobsPage.getBtnSaveDSPQ());
		commonLib.waitForPageToLoad();
		Thread.sleep(2000);
		if(commonLib.isDisplayed(applyForJobsPage.getButtonContinueMandatory(),"Mandatory Decleration")) {
			if(commonLib.isDisplayed(applyForJobsPage.getBtnradio1(),"True Radio Button")) {
				commonLib.click(applyForJobsPage.getBtnradio1(),"Radio Button");
			} 
			if(commonLib.isDisplayed(applyForJobsPage.getBtnradio2(),"Radio Button")) {
				commonLib.click(applyForJobsPage.getBtnradio2(),"Radio Button");
			}
			commonLib.click(applyForJobsPage.getButtonContinueMandatory(),"Continue Button");
		}
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(applyForJobsPage.getBtnSaveDSPQ(),
				"Save DSPQ Btn")) {
			commonLib.logOnSuccess("Filling Cover Letter",
					"Cover letter completed successfully");
		} else {
			commonLib.logOnError("Filling Cover Letter",
					"Cover letter not completed");
		}
	}

	public void fillDSPQ() throws InterruptedException {
		commonLib.logOnInfo("Filling DSPQ", "Filling DSPQ for job application");
		commonLib.waitForPageToLoadWithCond(applyForJobsPage.getBtnSaveDSPQ());
		commonLib.click(applyForJobsPage.getBtnSaveDSPQ(), "Btn Save DSPQ");
		commonLib.waitForPageToLoadWithCond(applyForJobsPage.getBtnSaveQQ());
		
		if (commonLib.isDisplayed(applyForJobsPage.getBtnSaveQQ(),
				"Save QQ Btn")) {
			commonLib.logOnSuccess("Filling DSPQ",
					"DSPQ completed successfully");
		} else {
			commonLib.logOnError("Filling DSPQ", "DSPQ not completed");
		}
		
	}

	public void fillQQ() throws Exception {
		commonLib.logOnInfo("Filling QQ", "Filling QQ for job application");
		Thread.sleep(8000);
		if (commonLib.isDisplayed(applyForJobsPage.getTxtBoxQQ())) {
			commonLib.typeText(applyForJobsPage.getTxtBoxQQ(), "Test",
					"QQ TextBox");
		}

		List<WebElement> qq = applyForJobsPage.getRadioBtnQQ();
		for (WebElement el : qq) {
			if (!commonLib.isSelected(el, "QQ Question")) {
				commonLib.click(el, "QQ Question");
				commonLib.typeText(applyForJobsPage.getTxtBoxQQ1(), "Test",
						"QQ TextBox");
			}
		}
		commonLib.click(applyForJobsPage.getBtnSaveQQ(), "Save QQ Btn");
		commonLib.waitForPageToLoadWithCond(applyForJobsPage.getCheckAffidavit());
		if (commonLib.isDisplayed(applyForJobsPage.getCheckAffidavit(),
				"Moved to Affidavit page")) {
			
		commonLib.logOnSuccess("Filling QQ", "QQ completed successfully");
	} else {
		commonLib.logOnError("Filling QQ", "QQ not completed successfully");
	}
	}
	
	
//		if (commonLib.isDisplayed(applyForJobsPage.getBtnStartEPI(),
//				"Start EPI Btn")
//				|| commonLib.isDisplayed(
//						applyForJobsPage.getBtnOkJobApplication(), "Btn Ok")) {
//			commonLib.logOnSuccess("Filling QQ", "QQ completed successfully");
//		} else {
//			commonLib.logOnSuccess("Filling QQ", "QQ completed successfully");
//		}
	

//	public void fillEPIandJSI(String answer) throws Exception {
//		commonLib.logOnInfo("Filling EPI", "Filling EPI for job application");
//		if (commonLib.isDisplayed(applyForJobsPage.getBtnStartEPI())) {
//			commonLib.click(applyForJobsPage.getBtnStartEPI(), "Start EPI Btn");
//			commonLib.waitForPageToLoad();
//			if (commonLib.isDisplayed(applyForJobsPage.getBtnContinueEPI())) {
//				commonLib.click(applyForJobsPage.getBtnContinueEPI(),
//						"Continue EPI Btn");
//				commonLib.waitForPageToLoad();
//				if (commonLib.isDisplayed(applyForJobsPage
//						.getBtnOkEPIInstruction())) {
//					commonLib.click(applyForJobsPage.getBtnOkEPIInstruction(),
//							"Ok EPI Instruction Btn");
//				}
//				if (commonLib.isDisplayed(applyForJobsPage
//						.getBtnStartEPIInstruction())) {
//					commonLib.click(
//							applyForJobsPage.getBtnStartEPIInstruction(),
//							"Ok EPI Instruction Btn");
//				}
//				commonLib.click(applyForJobsPage.getBtnSubmitInstructions(),
//						"Submit Instruction Btn");
//				boolean flag = true;
//				while (flag) {
//					if (commonLib.isDisplayed(applyForJobsPage
//							.getBtnCompleteEPI())) {
//						break;
//					}
//					commonLib.click(applyForJobsPage.getRadioBtnEPI(),
//							"Answer Radio Btn");
//					commonLib.click(
//							applyForJobsPage.getBtnSubmitInstructions(),
//							"Submit Question Btn");
//					if (commonLib.isDisplayed(applyForJobsPage
//							.getHeadingInstructions())) {
//						commonLib.click(
//								applyForJobsPage.getBtnSubmitInstructions(),
//								"Submit Question Btn");
//					}
//					flag = commonLib.isDisplayed(applyForJobsPage
//							.getHeadingEPIPage());
//				}
//				if (commonLib.isDisplayed(applyForJobsPage.getBtnCompleteEPI())) {
//					commonLib.logOnSuccess("Filling EPI",
//							"EPI completed successfully");
//				} else {
//					commonLib.logOnError("Filling EPI", "EPI not completed");
//				}
//				commonLib.click(applyForJobsPage.getBtnCompleteEPI(),
//						"Complete EPI Btn");
//				commonLib.waitForPageToLoad();
//
//				commonLib.logOnInfo("Filling JSI",
//						"Filling JSI for job application");
//				if (commonLib.isDisplayed(applyForJobsPage.getBtnCompleteEPI(),
//						"Complete JSI Btn")) {
//					commonLib.logOnSuccess("Filling JSI",
//							"JSI is optional so job application completed");
//				} else {
//					commonLib.click(applyForJobsPage.getBtnStartEPI(),
//							"Start EPI Btn");
//					commonLib.waitForPageToLoad();
//					commonLib.click(
//							applyForJobsPage.getBtnStartJSIInstruction(),
//							"Start JSI Btn");
//					commonLib.waitForPageToLoad();
//					commonLib.click(
//							applyForJobsPage.getBtnSubmitInstructions(),
//							"Submit Instruction Btn");
//					commonLib.waitForPageToLoad();
//					commonLib.typeText(applyForJobsPage.getTxtBoxJsi(), answer,
//							"JSI TxtBox");
//					commonLib.click(
//							applyForJobsPage.getBtnSubmitInstructions(),
//							"Submit Instruction Btn");
//					commonLib.waitForPageToLoad();
//					if (commonLib.isDisplayed(applyForJobsPage
//							.getPopupJobComplete())) {
//						commonLib.logOnSuccess("Filling JSI",
//								"Job Application completed");
//					} else {
//						commonLib.logOnError("Filling JSI",
//								"Job Application not completed");
//					}
//				}
//				String parentWindow = driver.getWindowHandle();
//				commonLib.click(applyForJobsPage.getPopupJobComplete(),
//						"Ok Job Application Btn");
//				commonLib.waitForPageToLoad();
//				Set<String> windows = driver.getWindowHandles();
//				for (String window : windows) {
//					if (!window.equals(parentWindow)) {
//						driver.switchTo().window(window);
//						break;
//					}
//				}
//				driver.close();
//				driver.switchTo().window(parentWindow);
//				commonLib.waitForPageToLoad();
//			} else {
//				commonLib.logOnInfo("Filling JSI",
//						"Filling JSI for job application");
//				if (commonLib.isDisplayed(applyForJobsPage.getBtnCompleteEPI(),
//						"Complete JSI Btn")) {
//					commonLib.logOnSuccess("Filling JSI",
//							"JSI is optional so job application completed");
//				} else {
//					if (commonLib.isDisplayed(applyForJobsPage
//							.getBtnStartJSIInstruction())) {
//						commonLib.click(
//								applyForJobsPage.getBtnStartJSIInstruction(),
//								"Start JSI Btn");
//						commonLib.waitForPageToLoad();
//						commonLib.click(
//								applyForJobsPage.getBtnSubmitInstructions(),
//								"Submit Instruction Btn");
//						commonLib.waitForPageToLoad();
//						commonLib.typeText(applyForJobsPage.getTxtBoxJsi(),
//								answer, "JSI TxtBox");
//						commonLib.click(
//								applyForJobsPage.getBtnSubmitInstructions(),
//								"Submit Instruction Btn");
//						commonLib.waitForPageToLoad();
//						if (commonLib.isDisplayed(applyForJobsPage
//								.getPopupJobComplete())) {
//							commonLib.logOnSuccess("Filling JSI",
//									"Job Application completed");
//						} else {
//							commonLib.logOnError("Filling JSI",
//									"Job Application not completed");
//						}
//					} else {
//						commonLib
//								.logOnError("Filling JSI",
//										"JSI Instruction button is not getting displayed");
//					}
//				}
//				String parentWindow = driver.getWindowHandle();
//				commonLib.click(applyForJobsPage.getPopupJobComplete(),
//						"Ok Job Application Btn");
//				commonLib.waitForPageToLoad();
//				Set<String> windows = driver.getWindowHandles();
//				for (String window : windows) {
//					if (!window.equals(parentWindow)) {
//						driver.switchTo().window(window);
//						break;
//					}
//				}
//				driver.close();
//				driver.switchTo().window(parentWindow);
//				commonLib.waitForPageToLoad();
//
//			}
//
//		} else {
//			commonLib.logOnError("Filling EPI and JSI",
//					"Start EPI and JSI button is not visible");
//		}

//	}
	
	public void affidavit() throws InterruptedException {
		commonLib.logOnInfo("Accepting affidavit information", "Filling the affidavit");
		commonLib.click(applyForJobsPage.getCheckAffidavit(), "Affidavit Btn");
		commonLib.waitForPageToLoad();
		commonLib.click(applyForJobsPage.getContinueBtn(), "Click on Continue Btn");
		commonLib.waitForPageToLoad();
}

	public void completeJobApplication() throws InterruptedException {
		commonLib.logOnInfo("Completing Job Application",
				"Completing job application");
		if (commonLib.isDisplayed(applyForJobsPage.getBtnStartJSI(),
				"Start JSI Button")) {
			commonLib.logOnError("Completing Job Application",
					"Job Application not completed");
			return;
		}
		commonLib.click(applyForJobsPage.getBtnOkJobApplication(), "Btn Ok");
		commonLib.waitForPageToLoad();
		commonLib.logOnSuccess("Completing Job Application",
				"Job Application completed");
	}

}
