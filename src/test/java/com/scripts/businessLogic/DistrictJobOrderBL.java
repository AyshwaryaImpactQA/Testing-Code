package com.scripts.businessLogic;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.SJobOrdersPL;

import utils.report.template.LogStatus;
import utils.screenshot.Test_Utils;

public class DistrictJobOrderBL extends Driver {
	Test_Utils screenLib = new Test_Utils();
	SJobOrdersPL sJobOrder;
	CommonUtills commonLib = new CommonUtills();
	LoginBL loginBL = new LoginBL();
	String descriptionFilePath = null;
	public String jobOrderID = null;

	public void navigateToDistrictJobOrder() throws Exception {
		sJobOrder = PageFactory.initElements(driver, SJobOrdersPL.class);
		commonLib.waitForPageToLoadWithCond(sJobOrder.getBtnMenuJobOrders());
		commonLib.click(sJobOrder.getBtnMenuJobOrders(), "Job Order Menu");
		commonLib.waitForPageToLoadWithCond(sJobOrder.getMenuOptnDJO());
		commonLib.click(sJobOrder.getMenuOptnDJO(), "District Job Order");
		Thread.sleep(10000);
	}

	public void dwldExcel(String districtName) throws Exception {
		navigateToDistrictJobOrder();
		reports.log(LogStatus.INFO, "Download Excel", "Downloading Excel File");
		if (commonLib.isDisplayed(sJobOrder.getTxtBoxDistrict(),
				"District TxtBox")) {
			commonLib.typeText(sJobOrder.getTxtBoxDistrict(), districtName,
					"District TxtBox");
			commonLib.typeKeys(sJobOrder.getTxtBoxDistrict(), Keys.DOWN);
			commonLib.typeKeys(sJobOrder.getTxtBoxDistrict(), Keys.UP);
			commonLib.click(sJobOrder.getBtnSearchJobOrder(),
					"Search Job Order Btn");
			Thread.sleep(8000);
			commonLib.waitForPageToLoad();
		}
		commonLib.click(sJobOrder.getExpExcel(), "Download Excel");
		Thread.sleep(5000);
		commonLib.waitForPageToLoad();
		commonLib.logOnSuccess("Download Excel",
				"Excel has been downloaded successfully");
	}

	public void dwnldPDF() throws Exception {
		Robot robot = new Robot();
		commonLib.click(sJobOrder.getExpPDF(), "Download PDF");
		driver.switchTo().frame("ifrmCJS");
		commonLib.click(sJobOrder.getBtnPDFDwnld(), "Donwload PDF");
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
		commonLib.click(sJobOrder.getBtnClosePDFForm(), "Close PDF");
	}

	public void navigateToAddDistrictJobOrder() throws Exception {
		navigateToDistrictJobOrder();
		
		commonLib.waitForPageToLoadWithCond(sJobOrder.getBtnAddNewJob());
		
		commonLib.click(sJobOrder.getBtnAddNewJob(), "Add Job Order Link");
	}

	public void enterCommonDetails(String districtName, String schoolName,
			String zone, String jobTitle, String jobType, String jobCategory,
			String jobApprovalProcess, String refNo) throws Exception {
		commonLib.waitForPageToLoadWithCond(sJobOrder.getTxtBoxDistrict());
		
		if (commonLib.isDisplayed(sJobOrder.getTxtBoxDistrict(),"District TxtBox")) {
			commonLib.typeText(sJobOrder.getTxtBoxDistrict(), districtName,
					"District Name");
			commonLib.typeKeys(sJobOrder.getTxtBoxDistrict(), Keys.DOWN);
			commonLib.typeKeys(sJobOrder.getTxtBoxDistrict(), Keys.UP);
		}
		commonLib.waitForPageToLoadWithCond(sJobOrder.getTxtBoxJobTitle());
		commonLib
				.typeText(sJobOrder.getTxtBoxJobTitle(), jobTitle, "Job Title");
		System.out.println("Entered job title is: " +jobTitle);
		commonLib.click(sJobOrder.getTxtBoxPostingStartDate(),
				"Posting Start Date");
		commonLib.waitForPageToLoad();
		commonLib.click(sJobOrder.getCurrentDatePicker(), "Today's Date");
		// commonLib.selectDrpDownValue(sJobOrder.getDrpDownZone(), zone,
		// "Zone Dropdown");
		commonLib.selectDrpDownValue(sJobOrder.getDrpdownJobType(), jobType,
				"Job Type");
		if (!jobApprovalProcess.contains("Select")) {
			commonLib.selectDrpDownValue(
					sJobOrder.getDrpDownJobApprovalProcess(),
					jobApprovalProcess, "Job Approval Process");
		}
		commonLib.typeText(sJobOrder.getTxtBoxRefNo(), refNo, "Ref No TxtBox");
		commonLib.selectDrpDownValue(sJobOrder.getDrpDownJobCategory(),
				jobCategory, "Job Category");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(sJobOrder.getEPIOkButton(),
				"EPI Ok Button")) {
			
			commonLib.click(sJobOrder.getEPIOkButton(), "EPI Ok Button");
		}
		
	}
	public void enterDetailsForWithPostinEndDate(String districtName,
			String schoolName, String zone, String jobTitle, String jobType,
			String jobCategory, String expectedHire, String jobDecription,
			String requisitionNumber, String redirectURL,
			String jobApprovalProcess, String isHidden, String reNo)
			throws Exception {
		
		enterCommonDetails(districtName, schoolName, zone, jobTitle, jobType,
				jobCategory, jobApprovalProcess, reNo);
		commonLib.waitForPageToLoad();
		commonLib.click(sJobOrder.getTxtBoxPostingEndDate(), "Posting End date");
		commonLib.waitForPageToLoad();
		commonLib.click(sJobOrder.getPostEndDateBtnNextYr(), "Next Year Button");
		commonLib.waitForPageToLoad();
		commonLib.click(sJobOrder.getPostEndDateBtnNextDt(), "Next Year Date");
		commonLib.waitForPageToLoad();
		commonLib.selectDrpDownValue(sJobOrder.getDrpdownJobType(), jobType,
				"Job Type");
		commonLib.selectDrpDownValue(sJobOrder.getDrpDownJobCategory(),
				jobCategory, "Job Category");
		commonLib.waitForPageToLoad();
		commonLib.typeText(sJobOrder.getJobDescription(), jobDecription,
				"Job Description");
		if (!commonLib.isSelected(sJobOrder.getChkBoxMultipleHireSingleReqNo(),
				"Multiple Hires Chk Box")) {
			commonLib.click(sJobOrder.getChkBoxMultipleHireSingleReqNo(),
					"Multiple Hires Chk Box");
		}
		if (commonLib.isDisplayed(sJobOrder.getRadioBtnOnlyDistrictAdmins(),
				"Only District Admin Radio Btn")) {
			commonLib.click(sJobOrder.getRadioBtnOnlyDistrictAdmins(),
					"Only District Admin Radio Btn");
			commonLib.waitForPageToLoad();
			commonLib.click(sJobOrder.getBtnOkChangeMessageModal(),
					"Change Message Modal Ok btn");
			commonLib.typeText(sJobOrder.getTxtBoxNoOfHiresDistrict(),
					expectedHire, "Expected Hires TxtBox");
			Thread.sleep(2000);
			commonLib.click(sJobOrder.getRadioBtnRequisitionNumber(),
					"Enter Requisition Number Radio btn");
			commonLib.typeText(sJobOrder.getTxtBoxRequisitionNumber(),
					requisitionNumber, "Enter Requisition Number TxtBox");
		}
		if (commonLib.isDisplayed(sJobOrder.getChkBoxDistrictAdmin(),
				"District Admin Chk Box")) {
			if (!commonLib.isSelected(sJobOrder.getChkBoxDistrictAdmin(),
					"District Admin Chk Box")) {
				commonLib.click(sJobOrder.getChkBoxDistrictAdmin(),
						"District Admin Chk Box");
				commonLib.waitForPageToLoad();
			}
		}
		if (commonLib.isDisplayed(sJobOrder.getChkBoxAllAdminOfAttachSchool(),
				"All Admin of Attach School Chk Box")) {
			if (commonLib.isSelected(
					sJobOrder.getChkBoxAllAdminOfAttachSchool(),
					"All Admin of Attach School Chk Box")) {
				commonLib.click(sJobOrder.getChkBoxAllAdminOfAttachSchool(),
						"All Admin of Attach School Chk Box");
				commonLib.waitForPageToLoad();
			}
		}
		commonLib.click(sJobOrder.getRadioBtnNoJSI(),"Job Specific Inventory Radio Btn");
		commonLib.waitForPageToLoad();
		
		if (commonLib.isDisplayed(sJobOrder.getRadioBtnDefaultJSI())) {
		commonLib.click(sJobOrder.getRadioBtnDefaultJSI(),"Default Job Specific Inventory Radio Btn");			
		}
				
		if (commonLib.isDisplayed(sJobOrder.getChkBoxAssociatedSchools())) {
			if (commonLib.isSelected(sJobOrder.getChkBoxAssociatedSchools())) {
				commonLib.click(sJobOrder.getChkBoxAssociatedSchools(),
						"Associated Schools ChkBox");
			}
		}
		if (isHidden.equalsIgnoreCase("Yes")) {
			if (!commonLib.isSelected(sJobOrder.getChkBoxHiddenJob())) {
				commonLib.click(sJobOrder.getChkBoxHiddenJob(),
						"Hidden Job Check Box");
				Thread.sleep(2000);
				commonLib.click(sJobOrder.getRadioBtnHidJobInviteOnly(),
						"Invite Only Radio Btn");
			}
		} else {
			if (commonLib.isSelected(sJobOrder.getChkBoxHiddenJob())) {
				commonLib.click(sJobOrder.getChkBoxHiddenJob(),
						"Hidden Job Check Box");
			}
		}
		commonLib.typeText(sJobOrder.getReDirectUrl(), redirectURL,
				"Redirect URL TxtBox");

	}

	public void enterDetailsForWithUntillEnd(String districtName,
			String schoolName, String zone, String jobTitle, String jobType,
			String jobCategory, String expectedHire, String jobDecription,
			String requisitionNumber, String redirectURL,
			String jobApprovalProcess, String isHidden, String refNo)
			throws Exception {
		enterCommonDetails(districtName, schoolName, zone, jobTitle, jobType,
				jobCategory, jobApprovalProcess, refNo);
		commonLib.waitForPageToLoad();
		commonLib.click(sJobOrder.getRadioBtnUntilFilled(), "Untill Filled");
		commonLib.typeText(sJobOrder.getJobDescription(), jobDecription,
				"Job Description");
		if (!commonLib.isSelected(sJobOrder.getChkBoxMultipleHireSingleReqNo(),
				"Multiple Hires Chk Box")) {
			commonLib.click(sJobOrder.getChkBoxMultipleHireSingleReqNo(),
					"Multiple Hires Chk Box");
		}
		if (commonLib.isDisplayed(sJobOrder.getRadioBtnOnlyDistrictAdmins(),
				"Only District Admin Radio Btn")) {
			commonLib.click(sJobOrder.getRadioBtnOnlyDistrictAdmins(),
					"Only District Admin Radio Btn");
			commonLib.waitForPageToLoad();
			commonLib.click(sJobOrder.getBtnOkChangeMessageModal(),
					"Change Message Modal Ok btn");
			commonLib.typeText(sJobOrder.getTxtBoxNoOfHiresDistrict(),
					expectedHire, "Expected Hires TxtBox");
			Thread.sleep(2000);
			commonLib.click(sJobOrder.getRadioBtnRequisitionNumber(),
					"Enter Requisition Number Radio btn");
			commonLib.typeText(sJobOrder.getTxtBoxRequisitionNumber(),
					requisitionNumber, "Enter Requisition Number TxtBox");
		}
		if (commonLib.isDisplayed(sJobOrder.getChkBoxDistrictAdmin(),
				"District Admin Chk Box")) {
			if (!commonLib.isSelected(sJobOrder.getChkBoxDistrictAdmin(),
					"District Admin Chk Box")) {
				commonLib.click(sJobOrder.getChkBoxDistrictAdmin(),
						"District Admin Chk Box");
				commonLib.waitForPageToLoad();
			}
		}
		if (commonLib.isDisplayed(sJobOrder.getChkBoxAllAdminOfAttachSchool(),
				"All Admin of Attach School Chk Box")) {
			if (commonLib.isSelected(
					sJobOrder.getChkBoxAllAdminOfAttachSchool(),
					"All Admin of Attach School Chk Box")) {
				commonLib.click(sJobOrder.getChkBoxAllAdminOfAttachSchool(),
						"All Admin of Attach School Chk Box");
				commonLib.waitForPageToLoad();
			}
		}
		commonLib.click(sJobOrder.getRadioBtnJSINedded(),
				"Job Specific Inventory Radio Btn");
		commonLib.waitForPageToLoad();
		commonLib.click(sJobOrder.getRadioBtnDefaultJSI(),
				"Default Job Specific Inventory Radio Btn");
		if (commonLib.isDisplayed(sJobOrder.getChkBoxAssociatedSchools())) {
			if (commonLib.isSelected(sJobOrder.getChkBoxAssociatedSchools())) {
				commonLib.click(sJobOrder.getChkBoxAssociatedSchools(),
						"Associated Schools ChkBox");
			}
		}
		if (isHidden.equalsIgnoreCase("Yes")) {
			if (!commonLib.isSelected(sJobOrder.getChkBoxHiddenJob())) {
				commonLib.click(sJobOrder.getChkBoxHiddenJob(),
						"Hidden Job Check Box");
				Thread.sleep(2000);
				commonLib.click(sJobOrder.getRadioBtnHidJobInviteOnly(),
						"Invite Only Radio Btn");
			}
		} else {
			if (commonLib.isSelected(sJobOrder.getChkBoxHiddenJob())) {
				commonLib.click(sJobOrder.getChkBoxHiddenJob(),
						"Hidden Job Check Box");
			}
		}
		commonLib.typeText(sJobOrder.getReDirectUrl(), redirectURL,
				"Redirect URL TxtBox");
	}

	public void enterDetailsFoWithAttachSchool(String districtName,
			String schoolName, String zone, String jobTitle, String jobType,
			String jobCategory, String expectedHire, String jobDecription,
			String requisitionNumber, String redirectURL,
			String jobApprovalProcess, String refNo) throws Exception {
		enterCommonDetails(districtName, schoolName, zone, jobTitle, jobType,
				jobCategory, jobApprovalProcess, refNo);
		commonLib.waitForPageToLoad();
		commonLib.click(sJobOrder.getRadioBtnUntilFilled(), "Untill Filled");
		commonLib.typeText(sJobOrder.getJobDescription(), jobDecription,
				"Job Description");
		if (!commonLib.isSelected(sJobOrder.getChkBoxMultipleHireSingleReqNo(),
				"Multiple Hires Chk Box")) {
			commonLib.click(sJobOrder.getChkBoxMultipleHireSingleReqNo(),
					"Multiple Hires Chk Box");
		}
		if (commonLib.isDisplayed(sJobOrder
				.getRadioBtnAdminFromSelectedSchool())) {
			commonLib.click(sJobOrder.getRadioBtnAdminFromSelectedSchool(),
					"Admin from Selected School Radio Btn");
			commonLib.waitForPageToLoad();
			commonLib.click(
					sJobOrder.getBtnOkChangeMessageModalToSelectedSchool(),
					"Change Message Modal Ok btn");
			commonLib.click(sJobOrder.getLinkAddSchool(), "Add School Link");

			commonLib.typeText(sJobOrder.getTxtBoxSchoolDepartment(),
					schoolName, "School Name TxtBox");
			commonLib
					.typeKeys(sJobOrder.getTxtBoxSchoolDepartment(), Keys.DOWN);
			commonLib.typeKeys(sJobOrder.getTxtBoxSchoolDepartment(), Keys.UP);
			commonLib.typeText(sJobOrder.getTxtBoxNoOfHiresSchool(),
					expectedHire, "Expected Hires TxtBox");
			Thread.sleep(2000);
			commonLib.click(sJobOrder.getRadioBtnRequisitionNumberSchool(),
					"Enter Requisition Number Radio btn");
			commonLib.typeText(sJobOrder.getTxtBoxRequisitionNumberSchool(),
					requisitionNumber, "Requisition Number TxtBox");
			commonLib
					.click(sJobOrder.getLinkSaveSection(), "Save Section Link");
			commonLib.waitForPageToLoad();
		}
		commonLib.click(sJobOrder.getRadioBtnJSINedded(),
				"Job Specific Inventory Radio Btn");
		Thread.sleep(2000);
		commonLib.click(sJobOrder.getRadioBtnDefaultJSI(),
				"Default Job Specific Inventory Radio Btn");
		if (commonLib.isDisplayed(sJobOrder.getChkBoxAssociatedSchools())) {
			if (!commonLib.isSelected(sJobOrder.getChkBoxAssociatedSchools())) {
				commonLib.click(sJobOrder.getChkBoxAssociatedSchools(),
						"Associated School Chk Box");
				commonLib.waitForPageToLoad();
			}
		}
		commonLib.typeText(sJobOrder.getReDirectUrl(), redirectURL,
				"Redirect URL TxtBox");
	}
	
	public void saveJobAndVerifyNEW(String jobTitle, int rowNum, String sheetName)
			throws Exception {
		commonLib.click(sJobOrder.getSaveJobOrder(), "Save Job Order");
		commonLib.waitForPageToLoad();
		Thread.sleep(9000);
		 try  {
				if (commonLib.isDisplayed(sJobOrder.getBtnOkConfrmJobOrder(),
						"Ok button ")) {
					commonLib.click(sJobOrder.getBtnOkConfrmJobOrder(),"Ok button ");
					commonLib.waitForPageToLoad();
					commonLib.waitForPageToLoad();
				}
				
			     commonLib.logOnSuccess("District Job Order",
							"District Job Order Created Succesfully");		
			   }
			
			catch (Exception e) {
			
				commonLib.logOnError("District Job Order",
						"Newly created job not found");
		    }
		 }                      //BY KG
	public void saveJobAndVerifyLatest(String jobTitle, int rowNum, String sheetName)
			throws Exception {
		commonLib.click(sJobOrder.getSaveJobOrder(), "Save Job Order");
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
		String parentWin=driver.getWindowHandle();
		if (commonLib.isDisplayed(sJobOrder.getJobOrderUrl(),
				"Job order Url")) {
			commonLib.logOnSuccess("District Job Order",
					"District Job Order Created Succesfully");
			
			commonLib.click(sJobOrder.getJobOrderUrl(),
					"Job order Url");
			
		//	String parentWin=driver.getWindowHandle();
			 Set<String> handle= driver.getWindowHandles();          //Return a set of window handle
			 for (String handleWin : driver.getWindowHandles()) {
			    driver.switchTo().window(handleWin);
			    commonLib.waitForPageToLoad();
			    commonLib.waitForPageToLoad();
			    commonLib.waitForPageToLoad();
			    }
		
		}
		else {
			commonLib.logOnError("District Job Order",
					"District Job Order Can not be created");
		}
	
			
			commonLib.logOnSuccess("District Job Order",
					"District Job Order Created Succesfully");
			
			jobOrderID=	driver.getCurrentUrl().replaceAll("[^0-9]", "");
			excelData.setExcelData(sheetName, rowNum, 12, jobOrderID);
			driver.switchTo().window(parentWin);
			commonLib.click(sJobOrder.getBtnOkConfrmJobOrder(),
					"Confirm Job order");
			commonLib.waitForPageToLoad();
			Thread.sleep(10000);
			
			commonLib.logOnInfo("District Job Order",
					"Searching for newly created job");
			commonLib.typeText(sJobOrder.getTxtBxJobOrderId(), jobOrderID,
					"Job Order Id TxtBox");
			commonLib.click(sJobOrder.getBtnSearchJobOrder(),
					"Search Job order");
			Thread.sleep(15000);
			commonLib.waitForPageToLoad();
			Thread.sleep(5000);
			
			System.out.println("Newly created job title is: " +commonLib.getText(sJobOrder.getTitleFirstRow()));
			System.out.println("Entered job title is: " +jobTitle);
			
			if (commonLib.getText(sJobOrder.getTitleFirstRow(), "Title Label")
					.equals(jobTitle)) {
				System.out.println("Newly created job title is: " +commonLib.getText(sJobOrder.getTitleFirstRow()));
				System.out.println("Entered job title is: " +jobTitle);
				
				commonLib.logOnSuccess("District Job Order",
						"Newly created job found successfully");
			} else {
				commonLib.logOnError("District Job Order",
						"Newly created job not found");
			}
		}
	

	public void saveJobAndVerify(String jobTitle, int rowNum, String sheetName)
			throws Exception {
		commonLib.click(sJobOrder.getSaveJobOrder(), "Save Job Order");
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
		if (commonLib.isDisplayed(sJobOrder.getBtnOkDuplicateRequisition(),
				"Ok button duplicate requisition")) {
			commonLib.click(sJobOrder.getBtnOkDuplicateRequisition(),
					"Ok button duplicate requisition");
			commonLib.waitForPageToLoad();
		}
		if (!commonLib.isDisplayed(sJobOrder.getSuccessJobNotification())) {
			if (!commonLib.isDisplayed(sJobOrder.getValidationError(),
					"Validation Error")) {
				commonLib.logOnError("District Job Order",
						"District Job Order Can not be created");
			}
			commonLib.logOnError("District Job Order",
					"Mandatory fields are left blank");

		} else {
			commonLib.logOnSuccess("District Job Order",
					"District Job Order Created Succesfully");
			jobOrderID = commonLib.getText(sJobOrder.getJobOrderUrl(),
					"Job Order URl").replaceAll("[^0-9]", "");
			excelData.setExcelData(sheetName, rowNum, 12, jobOrderID);

			commonLib.click(sJobOrder.getBtnOkConfrmJobOrder(),
					"Confirm Job order");
			commonLib.waitForPageToLoad();
			commonLib.logOnInfo("District Job Order",
					"Searching for newly created job");
			commonLib.typeText(sJobOrder.getTxtBxJobOrderId(), jobOrderID,
					"Job Order Id TxtBox");
			commonLib.click(sJobOrder.getBtnSearchJobOrder(),
					"Search Job order");
			commonLib.waitForPageToLoad();
			Thread.sleep(5000);
			if (commonLib.getText(sJobOrder.getTitleFirstRow(), "Title Label")
					.equals(jobTitle)) {
				commonLib.logOnSuccess("District Job Order",
						"Newly created job found successfully");
			} else {
				commonLib.logOnError("District Job Order",
						"Newly created job not found");
			}
		}
	}

	public void createJobWithEndDate(String districtName, String schoolName,
			String zone, String jobTitle, String jobType, String jobCategory,
			String expectedHire, String jobDecription,
			String requisitionNumber, String sheetName, String redirectURL,
			String jobApprovalProcess, String isHidden, String refNo,
			int rowNumber) throws Exception {
		commonLib.logOnInfo("District Job Order",
				"Create District Job Order with End Date");
		navigateToAddDistrictJobOrder();
		enterDetailsForWithPostinEndDate(districtName, schoolName, zone,
				jobTitle, jobType, jobCategory, expectedHire, jobDecription,
				requisitionNumber, redirectURL, jobApprovalProcess, isHidden,
				refNo);
		/*saveJobAndVerify(jobTitle, rowNumber, sheetName);            // URL has been changed
		saveJobAndVerifyNEW(jobTitle, rowNumber, sheetName);*/
		saveJobAndVerifyLatest(jobTitle, rowNumber, sheetName);
	}

	public void createJobWithUntillEnd(String districtName, String schoolName,
			String zone, String jobTitle, String jobType, String jobCategory,
			String expectedHire, String jobDecription,
			String requisitionNumber, String sheetName, String redirectURL,
			String jobApprovalProcess, String isHidden, String refNo, int rowNum)
			throws Exception {
		commonLib.logOnInfo("District Job Order",
				"Create District Job Order with until filled");
		navigateToAddDistrictJobOrder();
		enterDetailsForWithUntillEnd(districtName, schoolName, zone, jobTitle,
				jobType, jobCategory, expectedHire, jobDecription,
				requisitionNumber, redirectURL, jobApprovalProcess, isHidden,
				refNo);
		saveJobAndVerify(jobTitle, rowNum, sheetName);
	}

	public void createJobWithAttachSchool(String districtName,
			String schoolName, String zone, String jobTitle, String jobType,
			String jobCategory, String expectedHire, String jobDecription,
			String requisitionNumber, String sheetName, String redirectURL,
			String jobApprovalProcess, String refNo, int rowNum)
			throws Exception {
		commonLib.logOnInfo("District Job Order",
				"Create District Job Order with attach school");
		navigateToAddDistrictJobOrder();
		enterDetailsFoWithAttachSchool(districtName, schoolName, zone,
				jobTitle, jobType, jobCategory, expectedHire, jobDecription,
				requisitionNumber, redirectURL, jobApprovalProcess, refNo);
		saveJobAndVerify(jobTitle, rowNum, sheetName);
	}

}
