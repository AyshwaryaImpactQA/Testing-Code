package com.scripts.businessLogic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import utils.screenshot.Test_Utils;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.SJobOrdersPL;

public class SJobOrdersBL extends Driver {
	Test_Utils screenLib = new Test_Utils();
	SJobOrdersPL sJobOrder = PageFactory.initElements(driver,
			SJobOrdersPL.class);
	CommonUtills commonLib = new CommonUtills();
	LoginBL loginBL = new LoginBL();
	String descriptionFilePath = null;
	public String jobOrderID = null;

	public void navigateToSchoolJobOrder() throws Exception {
		commonLib.click(sJobOrder.getBtnMenuJobOrders(), "Job Order Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(sJobOrder.getMenuOptnSJO(), "School Job Order");
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
	}
	
	public void navigateToDistrictobOrder() throws Exception {
		commonLib.click(sJobOrder.getBtnMenuJobOrders(), "Job Order Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(sJobOrder.getMenuOptnDJO(), "District Job Order");
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
	}

	public void dwldExcel(String districtName) throws Exception {
		navigateToSchoolJobOrder();
		commonLib.logOnInfo("Download Excel", "Downloading Excel File");
		if (commonLib.isDisplayed(sJobOrder.getTxtBoxDistrict())) {
			commonLib.typeText(sJobOrder.getTxtBoxDistrict(), districtName,
					"District TxtBox");
			commonLib.typeKeys(sJobOrder.getTxtBoxDistrict(), Keys.DOWN);
			commonLib.typeKeys(sJobOrder.getTxtBoxDistrict(), Keys.UP);
			commonLib.click(sJobOrder.getBtnSearchJobOrder(),
					"Search Job Order Btn");
			commonLib.waitForPageToLoad();
		}
		commonLib.click(sJobOrder.getExpExcel(), "Download Excel");
		commonLib.waitForPageToLoad();
		commonLib.logOnSuccess("Download Excel",
				"Excel has been downloaded successfully");
	}

	public void dwnldPDF() throws Exception {
		commonLib.waitForPageToLoad();
		navigateToSchoolJobOrder();
		commonLib.logOnInfo("Download PDF", "Downloading PDF file");
		// commonLib.waitForElement(sJobOrder.getExpPDF(), "PDF Frame");
		commonLib.click(sJobOrder.getExpPDF(), "PDF Frame");
		commonLib.waitForPageToLoad();
		Thread.sleep(10000);
		// driver.switchTo().frame("ifrmCJS");
		// commonLib.click(sJobOrder.getBtnPDFDwnld(), "Donwload PDF");
		// commonLib.waitForPageToLoad();
		// driver.switchTo().defaultContent();
		// driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);

		// commonLib.click(sJobOrder.getBtnClosePDFForm(), "Close PDF");
		commonLib.pageRefresh();
		commonLib.waitForPageToLoad();
		commonLib.logOnSuccess("Download PDF",
				"PDF has been downloaded successfully");
	}

	public void navigateToAddSchlJobOrder() throws Exception {
		navigateToSchoolJobOrder();
		commonLib.click(sJobOrder.getBtnAddNewJob(), "Add Job Order");
		commonLib.waitForPageToLoad();
	}

	public void enterCommonDetails(String districtName, String schoolName,
			String zone, String jobTitle, String jobType, String jobCategory,
			String sheetName, String jobApprovalProcess, String refNo)
			throws Exception {
		if (commonLib.isDisplayed(sJobOrder.getTxtBoxDistrict())) {
			commonLib.typeText(sJobOrder.getTxtBoxDistrict(), districtName,
					"District Name");
			commonLib.typeKeys(sJobOrder.getTxtBoxDistrict(), Keys.DOWN);
			commonLib.typeKeys(sJobOrder.getTxtBoxDistrict(), Keys.UP);
			commonLib.waitForPageToLoad();
		}
		commonLib
				.typeText(sJobOrder.getTxtBoxJobTitle(), jobTitle, "Job Title");
		commonLib.click(sJobOrder.getTxtBoxPostingStartDate(),
				"Posting Start Date");
		commonLib.waitForPageToLoad();
		commonLib.click(sJobOrder.getCurrentDatePicker(), "Today's Date");
		commonLib.selectDrpDownValue(sJobOrder.getDrpdownJobType(), jobType,
				"Job Type");
		if (sheetName.equals("SchoolJobOrder")) {
			commonLib.typeText(sJobOrder.getTxtBoxSchool(), schoolName,
					"School/Department Name");
			commonLib.typeKeys(sJobOrder.getTxtBoxSchool(), Keys.DOWN);
			commonLib.typeKeys(sJobOrder.getTxtBoxSchool(), Keys.UP);
		}

		if (!jobApprovalProcess.contains("Select")) {
			commonLib.selectDrpDownValue(
					sJobOrder.getDrpDownJobApprovalProcess(),
					jobApprovalProcess, "Job Approval Process");
		}

		// commonLib.typeText(sJobOrder.getTxtBoxRefNo(), "", "Ref No TxtBox");
		commonLib.typeText(sJobOrder.getTxtBoxRefNo(), refNo, "Ref No TxtBox");
		// commonLib.selectDrpDownValue(sJobOrder.getDrpDownZone(), zone,
		// "Zone");
		commonLib.selectDrpDownValue(sJobOrder.getDrpDownJobCategory(),
				jobCategory, "Job Category");
		commonLib.waitForPageToLoad();
	}

	public void enterDetailsForWithPostinEndDate(String districtName,
			String schoolName, String zone, String jobTitle, String jobType,
			String jobCategory, String expectedHire, String jobDecription,
			String sheetName, String redirectURL, String jobApprovalProcess,
			String isHidden, String refNo) throws Exception {
		enterCommonDetails(districtName, schoolName, zone, jobTitle, jobType,
				jobCategory, sheetName, jobApprovalProcess, refNo);
		commonLib.waitForPageToLoad();
		commonLib
				.click(sJobOrder.getTxtBoxPostingEndDate(), "Posting End date");
		commonLib.waitForPageToLoad();
		commonLib
				.click(sJobOrder.getPostEndDateBtnNextYr(), "Next Year Button");
		commonLib.waitForPageToLoad();
		commonLib.click(sJobOrder.getPostEndDateBtnNextDt(), "Next Year Date");
		commonLib.waitForPageToLoad();
		commonLib.selectDrpDownValue(sJobOrder.getDrpdownJobType(), jobType,
				"Job Type");
		commonLib.selectDrpDownValue(sJobOrder.getDrpDownJobCategory(),
				jobCategory, "Job Category");
		commonLib.typeText(sJobOrder.getJobDescription(), jobDecription,
				"Job Description");
		commonLib.typeText(sJobOrder.getTxtBoxNoOfHires(), expectedHire,
				"Expected Hiree");
		if (commonLib.isDisplayed(sJobOrder.getChkBoxDistrictAdmin())) {
			if (!commonLib.isSelected(sJobOrder.getChkBoxDistrictAdmin())) {
				commonLib.click(sJobOrder.getChkBoxDistrictAdmin(),
						"District Admin Chk Box");
				commonLib.waitForPageToLoad();
			}
		}
		commonLib.click(sJobOrder.getRadioBtnJSINedded(),
				"Job Specific Inventory Radio Btn");
		commonLib.click(sJobOrder.getRadioBtnDefaultJSI(),
				"Default Job Specific Inventory Radio Btn");
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
			String sheetName, String redirectURL, String jobApprovalProcess,
			String isHidden, String refNo) throws Exception {
		enterCommonDetails(districtName, schoolName, zone, jobTitle, jobType,
				jobCategory, sheetName, jobApprovalProcess, refNo);
		commonLib.click(sJobOrder.getRadioBtnUntilFilled(), "Untill Filled");
		commonLib.selectDrpDownValue(sJobOrder.getDrpdownJobType(), jobType,
				"Job Type");
		commonLib.selectDrpDownValue(sJobOrder.getDrpDownJobCategory(),
				jobCategory, "Job Category");
		commonLib.typeText(sJobOrder.getTxtBoxNoOfHires(), expectedHire,
				"Expected Hiree");
		commonLib
				.click(sJobOrder.getRadioBtnJSINedded(), "JSI Needed RadioBtn");
		commonLib.click(sJobOrder.getRadBtnJSIOptional(), "JSI is Optional");
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

	public void saveJobAndVerify(String jobTitle, int rowNum, String sheetName)
			throws Exception {
		commonLib.click(sJobOrder.getSaveJobOrder(), "Save Btn");
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
		if (!commonLib.isDisplayed(sJobOrder.getSuccessJobNotification())) {
			if (!commonLib.isDisplayed(sJobOrder.getValidationError())) {
				commonLib.logOnError("School Job Order",
						"School Job Order Can not be created");
			}
			commonLib.logOnError("School Job Order",
					"Mandatory fields are left blank");
		} else {
			commonLib.logOnSuccess("School Job Order",
					"School Job Order Created Succesfully");
			jobOrderID = commonLib.getText(sJobOrder.getJobOrderUrl(),
					"Job Order URl").replaceAll("[\\D]", "");
			commonLib.click(sJobOrder.getBtnOKSuccessNotification(),
					"Success Popup Ok Btn ");
			commonLib.waitForPageToLoad();
			commonLib.logOnInfo("School Job Order",
					"Searching for newly created job");
			excelData.setExcelData(sheetName, rowNum, 12, jobOrderID);
			commonLib.typeText(sJobOrder.getTxtBxJobOrderId(), jobOrderID,
					"Job Order Id TxtBox");
			commonLib.click(sJobOrder.getBtnSearchJobOrder(),
					"Search Job order");
			Thread.sleep(5000);
			if (commonLib.getText(sJobOrder.getJobTitle(), "Title Cell")
					.equals(jobTitle)) {
				commonLib.logOnSuccess("School Job Order",
						"Job Title for new created Job has been verified.");
			} else {
				commonLib.logOnError("School Job Order",
						"Job Title does not matches.");
			}
		}
	}

	public void createJobWithEndDate(String districtName, String schoolName,
			String zone, String jobTitle, String jobType, String jobCategory,
			String expectedHire, String jobDecription, String sheetName,
			String redirectURL, String jobApprovalProcess, String isHidden,
			String refNo, int rowNum) throws Exception {
		commonLib.logOnInfo("School Job Order",
				"Create School Job Order with End Date");
		navigateToAddSchlJobOrder();
		enterDetailsForWithPostinEndDate(districtName, schoolName, zone,
				jobTitle, jobType, jobCategory, expectedHire, jobDecription,
				sheetName, redirectURL, jobApprovalProcess, isHidden, refNo);
		saveJobAndVerify(jobTitle, rowNum, sheetName);
	}

	public void createJobWithUntillEnd(String districtName, String schoolName,
			String zone, String jobTitle, String jobType, String jobCategory,
			String expectedHire, String jobDecription, String sheetName,
			String redirectURL, String jobApprovalProcess, String isHidden,
			String refNo, int rowNum) throws Exception {
		commonLib.logOnInfo("School Job Order",
				"Create School Job Order with Until Filled");
		navigateToAddSchlJobOrder();
		enterDetailsForWithUntillEnd(districtName, schoolName, zone, jobTitle,
				jobType, jobCategory, expectedHire, jobDecription, sheetName,
				redirectURL, jobApprovalProcess, isHidden, refNo);
		saveJobAndVerify(jobTitle, rowNum, sheetName);
	}

	public void createSchoolJobWithAttachJSI(String districtName,
			String schoolName, String zone, String jobTitle, String jobType,
			String jobCategory, String expectedHire, String jobDecription,
			String sheetName, String redirectURL, String jobApprovalProcess,
			String refNo, int rowNum) throws Exception {
		commonLib.logOnInfo("School Job Order",
				"Create School Job Order with attach JSI");
		navigateToAddSchlJobOrder();
		enterDetailsForJobWithAttachJSI(districtName, schoolName, zone,
				jobTitle, jobType, jobCategory, expectedHire, jobDecription,
				sheetName, redirectURL, jobApprovalProcess, refNo);
		saveJobAndVerify(jobTitle, rowNum, sheetName);
	}

	public void enterDetailsForJobWithAttachJSI(String districtName,
			String schoolName, String zone, String jobTitle, String jobType,
			String jobCategory, String expectedHire, String jobDecription,
			String sheetName, String redirectURL, String jobApprovalProcess,
			String refNo) throws Exception {
		enterCommonDetails(districtName, schoolName, zone, jobTitle, jobType,
				jobCategory, sheetName, jobApprovalProcess, refNo);
		commonLib.waitForPageToLoad();
		commonLib.click(sJobOrder.getRadioBtnUntilFilled(), "Untill Filled");
		commonLib.waitForPageToLoad();
		commonLib.typeText(sJobOrder.getJobDescription(), jobDecription,
				"Job Description");
		commonLib.typeText(sJobOrder.getTxtBoxNoOfHires(), expectedHire,
				"Expected Hiree");
		if (commonLib.isDisplayed(sJobOrder.getChkBoxDistrictAdmin())) {
			if (!commonLib.isSelected(sJobOrder.getChkBoxDistrictAdmin())) {
				commonLib.click(sJobOrder.getChkBoxDistrictAdmin(),
						"District Admin Chk Box");
				commonLib.waitForPageToLoad();
			}
		}
		commonLib.click(sJobOrder.getRadioBtnJSINedded(),
				"JSI Needed Radio Btn");
		commonLib.waitForPageToLoad();
		commonLib.click(sJobOrder.getRadioBtnAttachJSI(),
				"Attach JSI Radio Btn");
		commonLib.waitForPageToLoad();
		osName = System.getProperty("os.name");
		if (osName.contains("Windows")) {
			commonLib.typeText(sJobOrder.getFileUploadAttachJSI(),
					System.getProperty("user.dir")
							+ "\\src\\test\\resources\\Attach_JSI.doc",
					"Upload File");
		} else {
			commonLib.typeText(sJobOrder.getFileUploadAttachJSI(),
					System.getProperty("user.dir")
							+ "/src/test/resources/Attach_JSI.doc",
					"Upload File");
		}
		commonLib.waitForPageToLoad();
		commonLib.typeText(sJobOrder.getReDirectUrl(), redirectURL,
				"Redirect URL TxtBox");
	}

	public void searchJob(String jobId) throws Exception {
		commonLib.typeText(sJobOrder.getTxtBxJobOrderId(), jobId,
				"Job Id TxtBox");
		commonLib.selectDrpDownValue(sJobOrder.getDrpDownStatus(),
				"All Job Orders", "Status Drpdown");
		commonLib.click(sJobOrder.getBtnSearchJobOrder(), "Search Btn");
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
	}

	public void editJob(String jobId, String desc) throws Exception {
		commonLib.logOnInfo("Edit Job", "Editing existing job");
		searchJob(jobId);
		if (commonLib.isDisplayed(sJobOrder.getMessageNoRecordFound())) {
			commonLib.logOnError("Edit Job", "Job not found");
			return;
		}
		commonLib.click(sJobOrder.getIconEdit(), "Edit Icon");
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
		commonLib.typeText(sJobOrder.getJobDescription(), desc,
				"Job Description");
		commonLib.click(sJobOrder.getSaveJobOrder(), "Save Job Order");
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
		if (commonLib.isDisplayed(sJobOrder.getValidationError())) {
			commonLib.logOnError("Edit Job", "Job is not edited");
		} else {
			commonLib.logOnSuccess("Edit Job", "Job is edited successfully");
		}
	}

	public void cloneJob(String jobId, String sheetName, int rowNum,
			String jobTitle) throws Exception {
		commonLib.logOnInfo("Clone Job", "Cloning existing job");
		searchJob(jobId);
		if (commonLib.isDisplayed(sJobOrder.getMessageNoRecordFound())) {
			commonLib.logOnError("Clone Job", "Job not found");
			return;
		}
		commonLib.click(sJobOrder.getIconClone(), "Clone Icon");
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
		commonLib.click(sJobOrder.getTxtBoxPostingStartDate(),
				"Posting Start Date");
		commonLib.waitForPageToLoad();
		commonLib.click(sJobOrder.getCurrentDatePicker(), "Today's Date");
		commonLib.clear(sJobOrder.getTxtBoxRefNo(), "Ref No TxtBox");
		commonLib.click(sJobOrder.getSaveJobOrder(), "Save Job Order");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(sJobOrder.getSuccessJobNotification())) {
			if (!commonLib.isDisplayed(sJobOrder.getValidationError())) {
				commonLib.logOnError("Clone Job",
						"School Job Order Can not be cloned");
			}
			commonLib
					.logOnError("Clone Job", "Mandatory fields are left blank");
		} else {
			commonLib.logOnSuccess("Clone Job",
					"School Job Order cloned succesfully");
			jobOrderID = commonLib.getText(sJobOrder.getJobOrderUrl(),"Job Order URl").replaceAll("[\\D]", "");
			commonLib.click(sJobOrder.getBtnOKSuccessNotification(),"Success Popup Ok Btn ");
			commonLib.waitForPageToLoad();
			commonLib.logOnInfo("Clone Job", "Searching for newly cloned job");
			excelData.setExcelData(sheetName, rowNum, 12, jobOrderID);
			commonLib.typeText(sJobOrder.getTxtBxJobOrderId(), jobOrderID,
					"Job Order Id TxtBox");
			commonLib.click(sJobOrder.getBtnSearchJobOrder(),
					"Search Job order");
			if (commonLib.getText(sJobOrder.getJobTitle(), "Title Cell")
					.equals(jobTitle)) {
				commonLib
						.logOnSuccess("Clone Job", "Newly cloned job is found");
			} else {
				commonLib.logOnError("Clone Job",
						"Newly cloned job is not found");
			}
		}

	}

	public void viewHistoryJob(String jobId) throws Exception {
		commonLib.logOnInfo("View History", "Viewing history of the job");
		searchJob(jobId);
		if (commonLib.isDisplayed(sJobOrder.getMessageNoRecordFound())) {
			commonLib.logOnError("View History", "Job not found");
			return;
		}
		commonLib.click(sJobOrder.getIconHistory(), "View History Icon");
		Thread.sleep(5000);
		if (commonLib.isDisplayed(sJobOrder.getHeaderJobHistoryPopup())) {
			commonLib.logOnSuccess("View History",
					"History popup for the job is appeared");
			commonLib.click(sJobOrder.getBtnCloseHistoryPopup(),
					"Close Btn History Popup");
			Thread.sleep(3000);
		} else {
			commonLib.logOnError("View History",
					"History popup for the job is not appeared");
		}
	}

	public void deactivateJob(String jobId) throws Exception {
		commonLib.logOnInfo("Deactivate Job", "Deactivating newly cloned job");
		searchJob(jobId);
		if (commonLib.isDisplayed(sJobOrder.getMessageNoRecordFound())) {
			commonLib.logOnError("Deactivate Job", "Job not found");
			return;
		}
		commonLib.click(sJobOrder.getIconActivateDeactivate(),
				"Activate/Deactivate Icon");
		Thread.sleep(5000);
		if (commonLib.getAttribute(sJobOrder.getIconActivateDeactivate(),
				"title").equals("Activate")) {
			commonLib.logOnSuccess("Deactivate Job",
					"Job is deactivated successfully");
		} else {
			commonLib.logOnError("Deactivate Job", "Job is not deactivated");
		}
	}

	public void viewJob() throws Exception {
		commonLib.logOnInfo("View Job", "Viewing district job details");
		commonLib.click(sJobOrder.getLinkViewJob(), "View Job Link");
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
		if (commonLib.isDisplayed(sJobOrder.getTxtBoxJobTitle())) {
			commonLib.logOnSuccess("View Job", "Job details page opened");
			commonLib.click(sJobOrder.getLinkCancel(), "Cancel Link");
			commonLib.waitForPageToLoad();
			Thread.sleep(5000);
		} else {
			commonLib.logOnError("View Job", "Job details page not opened");
		}
	}
}
