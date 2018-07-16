package com.scripts.businessLogic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.CandidateGridPL;
import com.scripts.pageObjectRepository.ManageJobOrderPL;

public class CandidateGridBL extends Driver {

	ManageJobOrderPL manageJOPage = PageFactory.initElements(driver,
			ManageJobOrderPL.class);
	CandidateGridPL candidateGridPage = PageFactory.initElements(driver,
			CandidateGridPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void viewCandidateGridDA() throws Exception {
		commonLib.logOnInfo("Candidate Grid", "Verifying Candidate Grid");
		commonLib.click(manageJOPage.getBtnMenuJobOrders(),
				"Job Order Menu tab");
		commonLib.click(manageJOPage.getMenuOptnDJO(),
				"District Job Order sub menu option");
		commonLib.waitForPageToLoad();

		commonLib.click(manageJOPage.getLinkCGIconDA().get(0), "CG icon DA");
		commonLib.waitForPageToLoad();
		String handle1 = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (handle != handle1) {
				driver.switchTo().window(handle);
			}
		}
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(candidateGridPage.getIconSearch(),
				"Search icon")) {
			commonLib.logOnSuccess("Candidate Grid",
					"Candidate Grid loaded successfully");
			driver.close();
			driver.switchTo().window(handle1);
		} else {
			commonLib.logOnError("Candidate Grid", "Candidate Grid not loaded");
		}
	}

//	public void viewCandidateGridTM() throws Exception {
//		commonLib.logOnInfo("Candidate Grid", "Verifying Candidate Grid");
//		commonLib.click(manageJOPage.getBtnMenuJobOrders(),
//				"Job Order Menu tab");
//		commonLib.click(manageJOPage.getMenuOptnDJO(),
//				"District Job Order sub menu");
//		commonLib.waitForPageToLoad();
//
//		commonLib.click(manageJOPage.getLinkCGIconTM().get(0), "CG icon TM");
//		commonLib.waitForPageToLoad();
//		String handle1 = driver.getWindowHandle();
//		for (String handle : driver.getWindowHandles()) {
//			if (handle != handle1) {
//				driver.switchTo().window(handle);
//			}
//		}
//		commonLib.waitForPageToLoad();
//		if (commonLib.isDisplayed(candidateGridPage.getIconSearch(),
//				"Search icon")) {
//			commonLib.logOnSuccess("Candidate Grid",
//					"Candidate Grid loaded successfully");
//			driver.close();
//			driver.switchTo().window(handle1);
//		} else {
//			commonLib.logOnError("Candidate Grid", "Candidate Grid not loaded");
//		}
//	}

//	public void viewCandidateGridSA() throws Exception {
//		commonLib.logOnInfo("Candidate Grid", "Verifying Candidate Grid");
//		commonLib.click(manageJOPage.getBtnMenuJobOrders(),
//				"Job Order Menu tab");
//		commonLib.click(manageJOPage.getMenuOptnSJO(),
//				"School Job Order sub menu option");
//		commonLib.waitForPageToLoad();
//		commonLib.click(manageJOPage.getLinkCGIconSA(), "CG icon");
//		commonLib.waitForPageToLoad();
//		String handle1 = driver.getWindowHandle();
//		for (String handle : driver.getWindowHandles()) {
//			if (handle != handle1) {
//				driver.switchTo().window(handle);
//			}
//		}
//		commonLib.waitForPageToLoad();
//		if (commonLib.isDisplayed(candidateGridPage.getIconSearch(),
//				"Search icon")) {
//			commonLib.logOnSuccess("Candidate Grid",
//					"Candidate Grid loaded successfully");
//			driver.close();
//			driver.switchTo().window(handle1);
//		} else {
//			commonLib.logOnError("Candidate Grid", "Candidate Grid not loaded");
//		}
//	}

	public void candidateProfileThroughCG(String jobTitle, String jobID,
			String firstName, String lastName, String email, String userType)
			throws Exception {
		commonLib.logOnInfo("Candidate Grid", "Viewing Candidate Grid");
		commonLib.waitForPageToLoadWithCond(manageJOPage.getBtnMenuJobOrders());
		commonLib.click(manageJOPage.getBtnMenuJobOrders(),"Job Order Menu tab");
		commonLib.click(manageJOPage.getMenuOptnDJO(),"District Job Order sub menu option");
		commonLib.waitForPageToLoadWithCond(manageJOPage.getTxtBoxKeywordSearch());
	commonLib.typeText(manageJOPage.getTxtBoxKeywordSearch(), jobTitle,"Keyword TxtBox");
		//commonLib.waitForPageToLoad();
		commonLib.typeText(manageJOPage.getTxtBoxJobID(), jobID,
				"Job Order Id TxtBox");
		commonLib.waitForPageToLoad();
		commonLib.click(manageJOPage.getBtnSearchJobs(), "Search buton");
		commonLib.waitForPageToLoad();
		
		commonLib.waitForPageToLoad();
		for (int i = 0; i < manageJOPage.getLinkJobTitle().size(); i++) {
			if (manageJOPage.getLinkJobTitle().get(i).getText()
					.contains(jobTitle)) {
			commonLib.click(manageJOPage.getLinkCGIconDA().get(i),
							"CG icon");
			}
		}
		Thread.sleep(5000);
		commonLib.waitForPageToLoadWithCond(manageJOPage.getFirstlinkCGIconDA());
		commonLib.click(manageJOPage.getFirstlinkCGIconDA(), "grid icon buton");
		commonLib.waitForPageToLoad();
		commonLib.waitForPageToLoad();
		String handle1 = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		commonLib.waitForPageToLoadWithCond(candidateGridPage.getIconSearch());
		commonLib.click(candidateGridPage.getIconSearch(), "Search icon");
		commonLib.waitForPageToLoadWithCond(candidateGridPage.getIconSearch());
		
		commonLib.typeText(candidateGridPage.getTxtBoxFirstName(), firstName,
				"First Name field");
		commonLib.typeText(candidateGridPage.getTxtBoxLastName(), lastName,
				"Last Name field");
		commonLib.typeText(candidateGridPage.getTxtBoxEmail(), email,
				"Email Address field");
		commonLib.click(candidateGridPage.getBtnSearchCG(), "Search button");
		
		commonLib.waitForPageToLoadWithCond(candidateGridPage.getStatusGrid());
		
		commonLib.click(candidateGridPage.getStatusGrid(), "Candidate SLC Status");
		commonLib.waitForPageToLoadWithCond(candidateGridPage.getHiredNode());
		if (commonLib.isDisplayed(candidateGridPage.getHiredNode(),
				"Hired Node")) {
			commonLib.logOnSuccess("SLC Popup",
					"SLC Popup loaded successfully");
			commonLib.click(candidateGridPage.getHiredNode(), "Hired Node ");
		} else {
			commonLib.logOnError("SLC Popup", "SLC Popup doesnot loaded successfully");
		}
		commonLib.waitForPageToLoad();
		commonLib.click(candidateGridPage.getFinalizeBtn(), "Finalize Button");
		commonLib.waitForPageToLoad();
		commonLib.click(candidateGridPage.getDoneBtn(), "Done button");
		commonLib.waitForPageToLoad();
		commonLib.logOnSuccess("Hired Node Finalised",
				"Candidate Hired successfully");
		
//		for (int i = 0; i < candidateGridPage.getLinkCandidateName().size(); i++) {
//			if (candidateGridPage.getLinkCandidateName().get(i).getText()
//					.contains(firstName + " " + lastName)) {
//				commonLib.click(
//						candidateGridPage.getLinkCandidateName().get(i),
//						"Candidate's name");
//		
//				break;
//			}
//		}
		
		
	/*	List<WebElement> columnJobTitle = applyForJobsPage.getColumnJobTitle();
		List<WebElement> jobActionIcons = applyForJobsPage.getJobActionIcons();
		for (int i = 0; i < columnJobTitle.size(); i++) {
			if (commonLib.getText(columnJobTitle.get(i)).equals(jobTitle)) 
		{ 
						System.out.println(driver.findElement(By.xpath("//*[@id='tblGridJoF']/tbody/tr[1]/td[1]/a")).getAttribute("href"));	
				commonLib.click(jobActionIcons.get(i), "Apply Icon");
				commonLib.waitForPageToLoad();
		break;
			}
		}*/
		
		
//		if (commonLib.isDisplayed(candidateGridPage.getBtnClosePD())) {
//		commonLib.logOnSuccess("Candidate Grid",
//					"PD report opened successfully");
//			commonLib.click(candidateGridPage.getBtnClosePD(),
//					"Close PD report option");
//		} else {
//			commonLib.logOnError("Candidate Grid", "PD report not opened");
//		}
//		commonLib.logOnInfo("Candidate Grid", "Verify Communication page");
//		commonLib.click(candidateGridPage.getBtnCommunication(),
//				"Communication option");
//		commonLib.waitForPageToLoad();
//		if (commonLib.isDisplayed(candidateGridPage.getBtnCloseCommunication())) {
//			commonLib.logOnSuccess("Candidate Grid",
//					"Communication page opened");
//			commonLib.click(candidateGridPage.getBtnCloseCommunication(),
//					"Close Communication Btn");
//		} else {
//			commonLib.logOnError("Candidate Grid",
//					"Communication page not loaded");
//		}
//		commonLib.click(candidateGridPage.getBtnPDReport(), "PD report icon");
	
//		if (commonLib.isDisplayed(candidateGridPage.getBtnClosePD())) {
//			commonLib.logOnSuccess("Candidate Grid",
//					"PD report opened successfully");
//			commonLib.click(candidateGridPage.getBtnClosePD(),
//					"Close PD report option");
//		} else {
//			commonLib.logOnError("Candidate Grid", "PD report not opened");
//		}
		driver.close();
		driver.switchTo().window(handle1);
		commonLib.waitForPageToLoad();
	}
	public void TMcandidateProfileThroughCG(String jobTitle, String jobID,
			String firstName, String lastName, String email, String userType)
			throws Exception {
		commonLib.logOnInfo("Candidate Grid", "Viewing Candidate Grid");
		commonLib.waitForPageToLoadWithCond(manageJOPage.getBtnMenuJobOrders());
		commonLib.click(manageJOPage.getBtnMenuJobOrders(),"Job Order Menu tab");
		commonLib.click(manageJOPage.getMenuOptnDJO(),"District Job Order sub menu option");
		commonLib.waitForPageToLoadWithCond(manageJOPage.getTxtBoxKeywordSearch());
		Thread.sleep(4000);
	commonLib.typeText(manageJOPage.getTxtBoxKeywordSearch(), jobTitle,"Keyword TxtBox");
		//commonLib.waitForPageToLoad();
		commonLib.typeText(manageJOPage.getTxtBoxJobID(), jobID,
				"Job Order Id TxtBox");
		commonLib.click(manageJOPage.getBtnSearchJobs(), "Search buton");
		commonLib.waitForPageToLoad();
		commonLib.waitForPageToLoad();
		commonLib.waitForPageToLoad();
		for (int i = 0; i < manageJOPage.getLinkJobTitle().size(); i++) {
			if (manageJOPage.getLinkJobTitle().get(i).getText()
					.contains(jobTitle)) {
			commonLib.click(manageJOPage.getLinkCGIconDA().get(i),
							"CG icon");
			}
		}
		Thread.sleep(5000);
		commonLib.waitForPageToLoadWithCond(manageJOPage.getFirstlinkCGIconDA());
		commonLib.click(manageJOPage.getFirstlinkCGIconDA(), "grid icon buton");
		commonLib.waitForPageToLoad();
		commonLib.waitForPageToLoad();
		String handle1 = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		commonLib.waitForPageToLoadWithCond(candidateGridPage.getIconSearch());
		commonLib.click(candidateGridPage.getIconSearch(), "Search icon");
		commonLib.waitForPageToLoadWithCond(candidateGridPage.getIconSearch());
		
		commonLib.typeText(candidateGridPage.getTxtBoxFirstName(), firstName,
				"First Name field");
		commonLib.typeText(candidateGridPage.getTxtBoxLastName(), lastName,
				"Last Name field");
		commonLib.typeText(candidateGridPage.getTxtBoxEmail(), email,
				"Email Address field");
		commonLib.click(candidateGridPage.getBtnSearchCG(), "Search button");
		
		//commonLib.waitForPageToLoadWithCond(candidateGridPage.getDoneBtn());
		Thread.sleep(4000);
		commonLib.click(candidateGridPage.getStatusGrid(), "Candidate SLC Status");
		Thread.sleep(5000);
		//commonLib.waitForPageToLoadWithCond(candidateGridPage.getHiredNode());
		if (commonLib.isDisplayed(candidateGridPage.getDoneBtn(),
				"Hired Node")) {
			commonLib.logOnSuccess("SLC Popup",
					"SLC Popup loaded successfully");
			//scommonLib.click(candidateGridPage.getHiredNode(), "Hired Node ");
		} else {
			commonLib.logOnError("SLC Popup", "SLC Popup doesnot loaded successfully");
		}
		commonLib.waitForPageToLoad();
		//commonLib.click(candidateGridPage.getFinalizeBtn(), "Finalize Button");
		//commonLib.waitForPageToLoad();
		commonLib.click(candidateGridPage.getDoneBtn(), "Done button");
		commonLib.waitForPageToLoad();
		commonLib.logOnSuccess("Hired Node Finalised",
				"Candidate Hired successfully");
		
//		for (int i = 0; i < candidateGridPage.getLinkCandidateName().size(); i++) {
//			if (candidateGridPage.getLinkCandidateName().get(i).getText()
//					.contains(firstName + " " + lastName)) {
//				commonLib.click(
//						candidateGridPage.getLinkCandidateName().get(i),
//						"Candidate's name");
//		
//				break;
//			}
//		}
		
		
	/*	List<WebElement> columnJobTitle = applyForJobsPage.getColumnJobTitle();
		List<WebElement> jobActionIcons = applyForJobsPage.getJobActionIcons();
		for (int i = 0; i < columnJobTitle.size(); i++) {
			if (commonLib.getText(columnJobTitle.get(i)).equals(jobTitle)) 
		{ 
						System.out.println(driver.findElement(By.xpath("//*[@id='tblGridJoF']/tbody/tr[1]/td[1]/a")).getAttribute("href"));	
				commonLib.click(jobActionIcons.get(i), "Apply Icon");
				commonLib.waitForPageToLoad();
		break;
			}
		}*/
		
		
//		if (commonLib.isDisplayed(candidateGridPage.getBtnClosePD())) {
//		commonLib.logOnSuccess("Candidate Grid",
//					"PD report opened successfully");
//			commonLib.click(candidateGridPage.getBtnClosePD(),
//					"Close PD report option");
//		} else {
//			commonLib.logOnError("Candidate Grid", "PD report not opened");
//		}
//		commonLib.logOnInfo("Candidate Grid", "Verify Communication page");
//		commonLib.click(candidateGridPage.getBtnCommunication(),
//				"Communication option");
//		commonLib.waitForPageToLoad();
//		if (commonLib.isDisplayed(candidateGridPage.getBtnCloseCommunication())) {
//			commonLib.logOnSuccess("Candidate Grid",
//					"Communication page opened");
//			commonLib.click(candidateGridPage.getBtnCloseCommunication(),
//					"Close Communication Btn");
//		} else {
//			commonLib.logOnError("Candidate Grid",
//					"Communication page not loaded");
//		}
//		commonLib.click(candidateGridPage.getBtnPDReport(), "PD report icon");
	
//		if (commonLib.isDisplayed(candidateGridPage.getBtnClosePD())) {
//			commonLib.logOnSuccess("Candidate Grid",
//					"PD report opened successfully");
//			commonLib.click(candidateGridPage.getBtnClosePD(),
//					"Close PD report option");
//		} else {
//			commonLib.logOnError("Candidate Grid", "PD report not opened");
//		}
		driver.close();
		driver.switchTo().window(handle1);
		commonLib.waitForPageToLoad();
	}
}
