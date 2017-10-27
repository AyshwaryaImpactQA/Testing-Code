package com.scripts.businessLogic;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.load.dataSource.ExcelLib;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ApplyForJobsPL;
import com.scripts.pageObjectRepository.CandidateGridPL;
import com.scripts.pageObjectRepository.JobApprovalPL;
import com.scripts.pageObjectRepository.ManageDistPrivilegePL;
import com.scripts.pageObjectRepository.ManageEventsPL;
import com.scripts.pageObjectRepository.ManageUsersPL;
import com.scripts.pageObjectRepository.SJobOrdersPL;

public class ManageDistPrivilegeBL extends Driver {

	ManageDistPrivilegePL mngDistPrivPage = PageFactory.initElements(driver,
			ManageDistPrivilegePL.class);
	ManageUsersPL mngUsersPage = PageFactory.initElements(driver,
			ManageUsersPL.class);
	JobApprovalPL jobApprovalPage = PageFactory.initElements(driver,
			JobApprovalPL.class);
	ManageUsersPL mngUserPage = PageFactory.initElements(driver,
			ManageUsersPL.class);
	ManageEventsPL mngEvent = PageFactory.initElements(driver,
			ManageEventsPL.class);
	SJobOrdersPL sJobOrderPage = PageFactory.initElements(driver,
			SJobOrdersPL.class);
	ApplyForJobsPL applyForJobsPage = PageFactory.initElements(driver,
			ApplyForJobsPL.class);
	CandidateGridPL candidateGridPage = PageFactory.initElements(driver,
			CandidateGridPL.class);
	CommonUtills commonLib = new CommonUtills();
	LoginBL loginLib = new LoginBL();
	ExcelLib excelData = new ExcelLib();
	ApplyForJobsBL applyForJobsLib = new ApplyForJobsBL();
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	Random randomGenerator = new Random();
	DistrictJobOrderBL dJobOrdersLib = new DistrictJobOrderBL();
	SJobOrdersBL sJobOrdersLib = new SJobOrdersBL();
	String district, jobApproverUsername, jobApproverPassword,
			jobApproverUserType, schoolName, zone, jobTitle, jobType,
			jobCategory, expectedHire, jobDecription, requisitionNumber,
			redirectURL, jobApprovalProcess, isHidden, refNo, daUsername,
			daPassword, daUserType, jobId, sheetName, saUsername, saPassword,
			saUserType, candidateUsername, candidatePassword,
			candidateUserType;
	int id, rowNum;

	public void navigateToManageDistrictTM() throws Exception {
		commonLib.click(mngDistPrivPage.getMenuManage(), "Manage Menu");
		Thread.sleep(2000);
		commonLib.click(mngDistPrivPage.getSubMenuDistrictTM(),
				"District Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void navigateToManageDistrictDA() throws Exception {
		commonLib.click(mngDistPrivPage.getMenuManage(), "Manage Menu");
		Thread.sleep(2000);
		commonLib.click(mngDistPrivPage.getSubMenuDistrictDA(),
				"District Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void navigateToManageDistrictPrivilege(String userType,
			String district) throws Exception {
		if (userType.equals("TM")) {
			navigateToManageDistrictTM();
			commonLib.typeText(mngDistPrivPage.getTxtBxDstrctName(), district,
					"District TxtBox");
			commonLib.typeKeys(mngDistPrivPage.getTxtBxDstrctName(), Keys.DOWN);
			commonLib.typeKeys(mngDistPrivPage.getTxtBxDstrctName(), Keys.UP);
			commonLib.click(mngDistPrivPage.getBtnSearch(), "Search Btn");
			commonLib.waitForPageToLoad();
		} else {
			navigateToManageDistrictDA();
		}
		commonLib.click(mngDistPrivPage.getBtnEditDstrct(), "Edit Icon");
		commonLib.waitForPageToLoad();
		if (commonLib.getAttribute(
				mngDistPrivPage.getAccordionPrivilegeForDistrict(), "class")
				.contains("plus")) {
			commonLib.click(mngDistPrivPage.getAccordionPrivilegeForDistrict(),
					"Privilege For District Accordion");
			commonLib.waitForPageToLoad();
		}
	}

	public void searchDistrict(String district) throws Exception {
		commonLib.logOnInfo("Search District", "Searching distict with name '"
				+ district + "'");
		commonLib.typeText(mngDistPrivPage.getTxtBxDstrctName(), district,
				"District TxtBox");
		commonLib.typeKeys(mngDistPrivPage.getTxtBxDstrctName(), Keys.DOWN);
		commonLib.typeKeys(mngDistPrivPage.getTxtBxDstrctName(), Keys.UP);
		commonLib.click(mngDistPrivPage.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngDistPrivPage.getMessageNoRecordFound())) {
			commonLib.logOnError("Search District", "District with name '"
					+ district + "' not found");
		} else {
			commonLib.logOnSuccess("Search District", "District with name '"
					+ district + "' found");
		}
	}

	public void activateDeactivateDistrict(String district) throws Exception {
		commonLib.logOnInfo("Deactivate District",
				"Deactivating distict with name '" + district + "'");
		commonLib.click(mngDistPrivPage.getBtnDeactivateDstrct(),
				"Deactivate Icon");
		commonLib.waitForPageToLoad();
		commonLib.click(mngDistPrivPage.getBtnConfirmDeacitvate(),
				"Confirm Deactivate Icon");
		commonLib.waitForPageToLoad();
		if (commonLib.getAttribute(mngDistPrivPage.getBtnDeactivateDstrct(),
				"title").equals("Activate")) {
			commonLib.logOnSuccess("Deactivate District", "Distict with name '"
					+ district + "' deactivated successfully");
			commonLib.logOnInfo("Activate District",
					"Activating distict with name '" + district + "'");
			commonLib.click(mngDistPrivPage.getBtnDeactivateDstrct(),
					"Activate Icon");
			commonLib.waitForPageToLoad();
			if (commonLib.getAttribute(
					mngDistPrivPage.getBtnDeactivateDstrct(), "title").equals(
					"Deactivate")) {
				commonLib.logOnSuccess("Activate District",
						"Distict with name '" + district
								+ "' activated successfully");
			} else {
				commonLib.logOnError("Activate District", "Distict with name '"
						+ district + "' not activated");
			}
		} else {
			commonLib.logOnError("Deactivate District", "Distict with name '"
					+ district + "' not deactivated");
		}
	}

	public void editDistrict(String district) throws Exception {
		commonLib.logOnInfo("Edit District", "Editing distict with name '"
				+ district + "'");
		commonLib.click(mngDistPrivPage.getBtnEditDstrct(), "Edit Icon");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngDistPrivPage.getHeadingEditDistrict())) {
			commonLib.logOnSuccess("Edit District",
					"Edit district page is loaded successfully");
		} else {
			commonLib.logOnError("Edit District",
					"Edit district page is not loaded");
		}
	}

	public void saveDistrict() throws Exception {
		commonLib.click(mngDistPrivPage.getBtnSaveDistrict(),
				"Save District Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngDistPrivPage.getBtnYes())) {
			commonLib.click(mngDistPrivPage.getBtnYes(), "Yes Btn");
			commonLib.waitForPageToLoad();
		}
		commonLib.click(mngDistPrivPage.getBtnClose(), "Close Btn");
	}

	public void candidatePoolPermission(String userType, String district)
			throws Exception {
		boolean flag, flag1;
		flag = flag1 = false;
		commonLib.logOnInfo("Candidate Pool Permissions",
				"Setting candidate pool permissions");
		navigateToManageDistrictPrivilege(userType, district);
		if (!commonLib.isSelected(mngDistPrivPage
				.getChkBoxShowCandidatesOnPageLoad())) {
			commonLib.click(
					mngDistPrivPage.getChkBoxShowCandidatesOnPageLoad(),
					"Show candidates on page load ChkBox");
			flag = true;
		}
		if (!commonLib.isSelected(mngDistPrivPage
				.getChkBoxDisplayQQAInCandPool())) {
			commonLib.click(mngDistPrivPage.getChkBoxDisplayQQAInCandPool(),
					"Display QQA thumbs in Candidate Pool ChkBox");
			flag1 = true;
		}
		if (flag || flag1) {
			saveDistrict();
		}
		commonLib.logOnSuccess("Candidate Pool Permissions",
				"Candidate pool permissions setup done");
	}

	public void verifyCandidatePoolPermission() throws Exception {
		commonLib.logOnInfo("Candidate Pool Permissions",
				"Verifying grid appearance without clicking on Search button");
		commonLib.click(mngUsersPage.getMenuUsers(), "User Menu");
		Thread.sleep(2000);
		commonLib.click(mngUsersPage.getSubMenuCandidates(),
				"Candidates Sub Menu");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngUsersPage.getGridCandidates())) {
			commonLib.logOnSuccess("Candidate Pool Permissions",
					"Grid appeared without clicking on Search button");
		} else {
			commonLib.logOnError("Candidate Pool Permissions",
					"Grid not appeared without clicking on Search button");
		}
		commonLib.logOnInfo("Candidate Pool Permissions",
				"Verifying appearance of QQA thumbs");
		if (commonLib.isDisplayed(mngUsersPage.getIconThumbs())) {
			commonLib.logOnSuccess("Candidate Pool Permissions",
					"QQA thumbs appeared in the grid");
		} else {
			commonLib.logOnError("Candidate Pool Permissions",
					"QQA thumbs not appeared in the grid");
		}
		loginLib.logout();
	}

	public void jobApprovalSetup() throws Exception {
		if (!commonLib.isSelected(jobApprovalPage.getJobApprovalProcess())) {
			commonLib.click(jobApprovalPage.getJobApprovalProcess(),
					"Job Approval Process ChkBox");
		}
		if (!commonLib
				.isSelected(jobApprovalPage.getChkBxApprovalPriorToLive())) {
			commonLib.click(jobApprovalPage.getChkBxApprovalPriorToLive(),
					"Check Box to Live ChkBox");
			commonLib.waitForPageToLoad();
			commonLib.selectDrpDownValue(
					jobApprovalPage.getDrpDownNoOfApproval(), "1",
					"No of Approvers Dropdown");
		}
		if (!commonLib.isSelected(jobApprovalPage.getChkBxBuildApprovalGrps())) {
			commonLib.click(jobApprovalPage.getChkBxBuildApprovalGrps(),
					"Build Approval Groups ChkBox");
		}
	}

	public void verifyJobApprovalDetailsLink(String userType, String jobId,
			String sheetName) throws Exception {
		commonLib.logOnInfo("Job Order View Permissions",
				"Verifying Job Approval Details to " + userType);
		if (sheetName.equals("DADJO") || sheetName.equals("DistricJobOrder")) {
			dJobOrdersLib.navigateToDistrictJobOrder();
		} else if (sheetName.equals("SASJO")) {
			sJobOrdersLib.navigateToSchoolJobOrder();
		}
		if (commonLib.isDisplayed(mngDistPrivPage.getLinkJobApprovalDetails())) {
			commonLib.click(mngDistPrivPage.getLinkJobApprovalDetails(),
					"Job Approval Details");
			commonLib.waitForPageToLoad();
			commonLib.logOnSuccess("Job Order View Permissions",
					"Job Approval Details is visible to " + userType);
			commonLib.click(mngDistPrivPage.getIconCloseJobApprovalPopup(),
					"Close Icon");
			commonLib.waitForPageToLoad();
		} else {
			commonLib.logOnError("Job Order View Permissions",
					"Job Approval Details is not visible to " + userType);
		}
	}

	public void jobOrderViewPermissionAllDA() throws Exception {
		sheetName = "DADJO";
		commonLib.logOnInfo("Job Order View Permissions",
				"Setting job order view permissions to All DA");
		jobApprovalSetup();
		commonLib.click(mngDistPrivPage.getRadioBtnDisplayLinkToAllDA(),
				"Display Link to All DA Radio Btn");
		if (!commonLib.isSelected(mngDistPrivPage
				.getChkBoxReqNoIsRequiredForJobs())) {
			commonLib.click(mngDistPrivPage.getChkBoxReqNoIsRequiredForJobs(),
					"Req no is required for Job ChkBox");
		}
		commonLib.logOnSuccess("Job Order View Permissions",
				"Job Order View Permissions setup done");
		saveDistrict();
		loginLib.logout();
		jobApproverUsername = excelData.getExcelData("Login", 5, 1);
		jobApproverPassword = excelData.getExcelData("Login", 5, 2);
		jobApproverUserType = excelData.getExcelData("Login", 5, 3);
		loginLib.login(jobApproverUsername, jobApproverPassword,
				jobApproverUserType);
		id = randomGenerator.nextInt(999999);
		district = excelData.getExcelData(sheetName, 5, 4);
		schoolName = excelData.getExcelData(sheetName, 5, 5);
		zone = excelData.getExcelData(sheetName, 5, 6);
		jobTitle = "JobApproval" + id;
		jobType = excelData.getExcelData(sheetName, 5, 8);
		jobCategory = excelData.getExcelData(sheetName, 5, 9);
		expectedHire = excelData.getExcelData(sheetName, 5, 10);
		jobDecription = "JobApprovalDesc" + id;
		requisitionNumber = "";
		redirectURL = excelData.getExcelData(sheetName, 5, 14);
		jobApprovalProcess = excelData.getExcelData(sheetName, 5, 15);
		isHidden = excelData.getExcelData(sheetName, 5, 16);
		excelData.setExcelData(sheetName, 5, 17,
				"AutoRefNo" + randomGenerator.nextInt(99999));
		refNo = excelData.getExcelData(sheetName, 5, 17);
		dJobOrdersLib.createJobWithEndDate(district, schoolName, zone,
				jobTitle, jobType, jobCategory, expectedHire, jobDecription,
				requisitionNumber, sheetName, redirectURL, jobApprovalProcess,
				isHidden, refNo, 5);
		jobId = excelData.getExcelData(sheetName, 5, 12);
		excelData.setExcelData(sheetName, 5, 7, jobTitle);
		excelData.setExcelData(sheetName, 5, 11, jobDecription);
		excelData.setExcelData(sheetName, 5, 13, requisitionNumber);
		verifyJobApprovalDetailsLink(jobApproverUserType, jobId, sheetName);
		loginLib.logout();
		daUsername = excelData.getExcelData("Login", 3, 1);
		daPassword = excelData.getExcelData("Login", 3, 2);
		daUserType = excelData.getExcelData("Login", 3, 3);
		loginLib.login(daUsername, daPassword, daUserType);
		verifyJobApprovalDetailsLink(daUserType, jobId, sheetName);
		loginLib.logout();
	}

	public void jobOrderViewPermissionAllDASA(String userType,
			String sheetName, int rowNum) throws Exception {
		commonLib.logOnInfo("Job Order View Permissions",
				"Setting job order view permissions to All DA and SA");
		jobApprovalSetup();
		commonLib.click(mngDistPrivPage.getRadioBtnDisplayLinkToAllDASA(),
				"Display Link to All DA and SA Radio Btn");
		commonLib.logOnSuccess("Job Order View Permissions",
				"Job Order View Permissions setup done");
		saveDistrict();
		id = randomGenerator.nextInt(999999);
		district = excelData.getExcelData(sheetName, rowNum, 4);
		schoolName = excelData.getExcelData(sheetName, rowNum, 5);
		zone = excelData.getExcelData(sheetName, rowNum, 6);
		jobTitle = "JobApproval" + id;
		requisitionNumber = id + "";
		jobType = excelData.getExcelData(sheetName, rowNum, 8);
		jobCategory = excelData.getExcelData(sheetName, rowNum, 9);
		expectedHire = excelData.getExcelData(sheetName, rowNum, 10);
		jobDecription = "JobApprovalDesc" + id;
		redirectURL = excelData.getExcelData(sheetName, rowNum, 14);
		jobApprovalProcess = excelData.getExcelData(sheetName, rowNum, 15);
		excelData.setExcelData(sheetName, rowNum, 17, "AutoRefNo"
				+ randomGenerator.nextInt(99999));
		refNo = excelData.getExcelData(sheetName, rowNum, 17);
		dJobOrdersLib.createJobWithAttachSchool(district, schoolName, zone,
				jobTitle, jobType, jobCategory, expectedHire, jobDecription,
				requisitionNumber, sheetName, redirectURL, jobApprovalProcess,
				refNo, rowNum);
		jobId = excelData.getExcelData(sheetName, rowNum, 12);
		excelData.setExcelData(sheetName, rowNum, 7, jobTitle);
		excelData.setExcelData(sheetName, rowNum, 11, jobDecription);
		excelData.setExcelData(sheetName, rowNum, 13, requisitionNumber);
		if (!userType.equals("DA")) {
			loginLib.logout();
			daUsername = excelData.getExcelData("Login", 3, 1);
			daPassword = excelData.getExcelData("Login", 3, 2);
			daUserType = excelData.getExcelData("Login", 3, 3);
			loginLib.login(daUsername, daPassword, daUserType);
		}
		verifyJobApprovalDetailsLink(daUserType, jobId, sheetName);
		loginLib.logout();
		saUsername = excelData.getExcelData("Login", 6, 1);
		saPassword = excelData.getExcelData("Login", 6, 2);
		saUserType = excelData.getExcelData("Login", 6, 3);
		loginLib.login(saUsername, saPassword, saUserType);
		verifyJobApprovalDetailsLink(saUserType, jobId, sheetName);
		loginLib.logout();
	}

	public void jobOrderViewPermissionToJADA(String userType, String sheetName,
			int rowNum) throws Exception {
		commonLib.logOnInfo("Job Order View Permissions",
				"Setting job order view permissions to All Job Approver DA");
		jobApprovalSetup();
		commonLib.click(
				mngDistPrivPage.getRadioBtnDisplayLinkToAllJobApproverDA(),
				"Display Link to All Job Approver DA Radio Btn");
		commonLib.logOnSuccess("Job Order View Permissions",
				"Job Order View Permissions setup done");
		saveDistrict();
		loginLib.logout();
		jobApproverUsername = excelData.getExcelData("Login", 5, 1);
		jobApproverPassword = excelData.getExcelData("Login", 5, 2);
		jobApproverUserType = excelData.getExcelData("Login", 5, 3);
		loginLib.login(jobApproverUsername, jobApproverPassword,
				jobApproverUserType);
		if (userType.equals("TM")) {
			id = randomGenerator.nextInt(999999);
			district = excelData.getExcelData(sheetName, rowNum, 4);
			schoolName = excelData.getExcelData(sheetName, rowNum, 5);
			zone = excelData.getExcelData(sheetName, rowNum, 6);
			jobTitle = "JobApproval" + id;
			requisitionNumber = id + "";
			jobType = excelData.getExcelData(sheetName, rowNum, 8);
			jobCategory = excelData.getExcelData(sheetName, rowNum, 9);
			expectedHire = excelData.getExcelData(sheetName, rowNum, 10);
			jobDecription = "JobApprovalDesc" + id;
			redirectURL = excelData.getExcelData(sheetName, rowNum, 14);
			jobApprovalProcess = excelData.getExcelData(sheetName, rowNum, 15);
			isHidden = excelData.getExcelData(sheetName, rowNum, 16);
			excelData.setExcelData(sheetName, rowNum, 17, "AutoRefNo"
					+ randomGenerator.nextInt(99999));
			refNo = excelData.getExcelData(sheetName, rowNum, 17);
			dJobOrdersLib.createJobWithUntillEnd(district, schoolName, zone,
					jobTitle, jobType, jobCategory, expectedHire,
					jobDecription, requisitionNumber, sheetName, redirectURL,
					jobApprovalProcess, isHidden, refNo, rowNum);
			excelData.setExcelData(sheetName, rowNum, 7, jobTitle);
			excelData.setExcelData(sheetName, rowNum, 11, jobDecription);
			excelData.setExcelData(sheetName, rowNum, 13, requisitionNumber);
		}
		jobId = excelData.getExcelData(sheetName, rowNum, 12);
		verifyJobApprovalDetailsLink(jobApproverUserType, jobId, sheetName);
		loginLib.logout();
	}

	public void jobOrderViewPermissionToJADASA(String sheetName, int rowNum)
			throws Exception {
		commonLib
				.logOnInfo("Job Order View Permissions",
						"Setting job order view permissions to All Job Approver DA and SA");
		jobApprovalSetup();
		commonLib.click(
				mngDistPrivPage.getRadioBtnDisplayLinkToAllJobApproverDASA(),
				"Display Link to All Job Approver DA and SA Radio Btn");
		commonLib.logOnSuccess("Job Order View Permissions",
				"Job Order View Permissions setup done");
		saveDistrict();
		loginLib.logout();
		jobApproverUsername = excelData.getExcelData("Login", 5, 1);
		jobApproverPassword = excelData.getExcelData("Login", 5, 2);
		jobApproverUserType = excelData.getExcelData("Login", 5, 3);
		loginLib.login(jobApproverUsername, jobApproverPassword,
				jobApproverUserType);
		jobId = excelData.getExcelData(sheetName, rowNum, 12);
		verifyJobApprovalDetailsLink(jobApproverUserType, jobId, sheetName);
		loginLib.logout();
		saUsername = excelData.getExcelData("Login", 4, 1);
		saPassword = excelData.getExcelData("Login", 4, 2);
		saUserType = excelData.getExcelData("Login", 4, 3);
		loginLib.login(saUsername, saPassword, saUserType);
		verifyJobApprovalDetailsLink(saUserType, jobId, sheetName);
		loginLib.logout();
	}

	public boolean searchCandidate(String candidateEmail) throws Exception {
		commonLib.click(mngUserPage.getMenuUsers(), "Users Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(mngUserPage.getSubMenuCandidates(),
				"Candidates Sub Menu");
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
		commonLib.typeText(mngUserPage.getTxtBoxEmailAdd(), candidateEmail,
				"Email TxtBox");
		commonLib.click(mngUserPage.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(mngUserPage.getLinkTeacherFNameLName())) {
			commonLib.logOnError("Search Candidate", "Candidate not found");
			return false;
		}
		return true;
	}

	public void eeocSupportPermission() throws Exception {
		commonLib.logOnInfo("EEOC Support Permissions",
				"Setting EEOC Support permission");
		if (!commonLib.isSelected(mngDistPrivPage.getChkBoxEEOCSupportNeeded())) {
			commonLib.click(mngDistPrivPage.getChkBoxEEOCSupportNeeded(),
					"EEOC Support Needed ChkBox");
			saveDistrict();
		}
		commonLib.logOnSuccess("EEOC Support Permissions",
				"EEOC Support permission setup done");
		loginLib.logout();
		daUsername = excelData.getExcelData("Login", 3, 1);
		daPassword = excelData.getExcelData("Login", 3, 2);
		daUserType = excelData.getExcelData("Login", 3, 3);
		loginLib.login(daUsername, daPassword, daUserType);
		commonLib.logOnInfo("Verify EEOC Support Permissions",
				"Verifying EEOC Support details");
		String candidateEmail = excelData.getExcelData("AddUser", 4, 3);
		if (!searchCandidate(candidateEmail)) {
			return;
		}
		commonLib.click(mngUserPage.getLinkTeacherFNameLName(),
				"Teacher Name Link");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(mngUserPage.getLinkShowEEOCDetail())) {
			commonLib.logOnError("Verify EEOC Support Permissions",
					"EEOC Support link not found");
			return;
		}
		commonLib.click(mngUserPage.getLinkShowEEOCDetail(),
				"EEOC Support detail link");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(mngUserPage.getHeaderEEOCSupportPopup())) {
			commonLib.logOnError("Verify EEOC Support Permissions",
					"EEOC Support popup not appeared");
			return;
		}
		commonLib.logOnSuccess("Verify EEOC Support Permissions",
				"EEOC Support popup appeared");
		commonLib.click(mngUserPage.getBtnCloseEEOCSupportPopup(),
				"Close EEOC Popup Btn");
		commonLib.click(mngUserPage.getBtnCloseUserProfilePopup(),
				"Close User Profile Popup Btn");
		commonLib.waitForPageToLoad();
		loginLib.logout();
	}

	public void attachJobMailVerification(String candidateEmail)
			throws Exception {
		commonLib.logOnInfo("Job Attachment Mail",
				"Verifying Job Attachment Mail");
		int timeLimit = 10;
		boolean flag = false;
		if (candidateEmail.contains("mailinator")) {
			driver.get("https://www.mailinator.com/");
			commonLib.waitForElement(mngUserPage.getLoginMailinator(),
					"Mailinator Login Btn");
			commonLib.typeText(mngUserPage.getLoginMailinator(),
					candidateEmail, "Malinator Mail Id text box");
			commonLib.click(mngUserPage.getBtnGoMailinator(),
					"Mailinator Login");
			commonLib.waitForPageToLoad();
			commonLib
					.waitForElement(mngUserPage.getBtnRefresh(), "Refresh Btn");
			for (int i = 0; i < timeLimit; i++) {
				if (commonLib.isDisplayed(mngEvent
						.getMailMailinatorInviteEvent())) {
					commonLib.click(mngEvent.getMailMailinatorInviteEvent(),
							"Attach Job Mail");
					driver.switchTo().frame("publicshowmaildivcontent");
					String mailContent = commonLib.getText(mngDistPrivPage
							.getAttachJobMailContentMailinator());
					if (mailContent.contains("added you as an applicant")) {
						commonLib.logOnSuccess("Job Attachment Mail",
								"Job Attachment Mail received");
					} else {
						commonLib.logOnError("Job Attachment Mail",
								"Job Attachment Mail not received");
					}
					driver.switchTo().defaultContent();
					flag = true;
					break;
				} else {
					Thread.sleep(5000);
					driver.navigate().refresh();
				}
			}
			if (!flag) {
				commonLib.logOnError("Job Attachment Mail",
						"Job Attachment Mail not sent");
			}
		}
		if (candidateEmail.contains("yopmail")) {
			driver.get("yopmail.com");
			commonLib.waitForPageToLoad();
			commonLib.typeText(mngUserPage.getLoginYopmail(), candidateEmail
					+ Keys.ENTER, "Enter Mail ID in Yopmail");
			commonLib.waitForPageToLoad();
			commonLib.waitForElement(mngEvent.getBtnRefreshYopmail(),
					"Refresh Btn");
			commonLib.click(mngEvent.getBtnRefreshYopmail(), "Refresh Btn");
			driver.switchTo().frame("ifinbox");
			for (int i = 0; i < timeLimit; i++) {
				if (commonLib.isDisplayed(mngEvent.getMailYopmailInviteEvent(),
						"Job Attachment Mail")) {
					commonLib.click(mngEvent.getMailYopmailInviteEvent(),
							"Job Attachment Mail");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("ifmail");
					String mailContent = commonLib.getText(
							mngEvent.getMailContentYopmail(), "Email ID");
					if (mailContent.contains("added you as an applicant")) {
						commonLib.logOnSuccess("Job Attachment Mail",
								"Desired Mail received successfully");
					}
					driver.switchTo().defaultContent();
					flag = true;
					break;
				} else {
					Thread.sleep(5000);
					commonLib.click(mngEvent.getBtnRefreshYopmail(),
							"Refresh Btn");
				}
			}
			if (!flag) {
				commonLib.logOnError("Job Attachment Mail",
						"Job Attachment mail not sent");
			}
		}
	}

	public void autoNotifyCandidatesForAttachJobPermission(String userType)
			throws Exception {
		commonLib.logOnInfo("Auto Notify Candidate Permissions",
				"Setting Auto Notify Candidate for Attaching Job permission");
		if (!commonLib.isSelected(mngDistPrivPage
				.getChkBoxAutoNotifyCandidatesOnAttachingJob())) {
			commonLib.click(mngDistPrivPage
					.getChkBoxAutoNotifyCandidatesOnAttachingJob(),
					"Auto Notify Candidate for Attaching Job ChkBox");
			saveDistrict();
		}
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		commonLib
				.logOnSuccess("Auto Notify Candidate Permissions",
						"Auto Notify Candidate for Attaching Job permission setup done");
		if (userType.equals("TM")) {
			loginLib.logout();
			daUsername = excelData.getExcelData("Login", 3, 1);
			daPassword = excelData.getExcelData("Login", 3, 2);
			daUserType = excelData.getExcelData("Login", 3, 3);
			loginLib.login(daUsername, daPassword, daUserType);
		}
		commonLib.logOnInfo("Auto Notify Candidate Permissions",
				"Adding candidate to other job");
		String candidateEmail = excelData.getExcelData("AddUser", 4, 3);
		if (!searchCandidate(candidateEmail)) {
			return;
		}
		commonLib.click(mngDistPrivPage.getIconAddCandidateToOtherJobs(),
				"Add Candidate to other Jobs Icon");
		commonLib.waitForPageToLoad();
		commonLib.click(mngDistPrivPage.getChkBoxOtherJobToCandidate(),
				"Job ChkBox");
		if (!commonLib.isSelected(mngDistPrivPage.getChkBoxSendNotification())) {
			commonLib.click(mngDistPrivPage.getChkBoxSendNotification(),
					"Send Notification ChkBox");
		}
		commonLib.click(mngDistPrivPage.getBtnApplyToJob(), "Apply to Job Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngDistPrivPage.getBtnOkJobApplied())) {
			commonLib.logOnSuccess("Auto Notify Candidate Permissions",
					"Candidate added to other job");
		} else {
			commonLib.logOnError("Auto Notify Candidate Permissions",
					"Candidate not added to other job");
			commonLib.click(mngDistPrivPage.getBtnOkJobApplied(), "Ok Btn");
			return;
		}
		commonLib.click(mngDistPrivPage.getBtnOkJobApplied(), "Ok Btn");
		commonLib.waitForPageToLoad();
		String currentURL = driver.getCurrentUrl();
		attachJobMailVerification(candidateEmail);
		driver.get(currentURL);
		commonLib.waitForPageToLoad();
		loginLib.logout();
	}

	public void zoneJobStartEndTimeJobCategoryOneSubMenuPermission(
			String userType, String district, String jobCategory)
			throws Exception {
		String postingStartTime, postingEndTime, jobStartTime, jobEndTime;
		boolean flag, flag1, flag2;
		flag = flag1 = flag2 = false;
		commonLib.logOnInfo(
				"Zone Start End Time Job Category SubMenu Permissions",
				"Setting Zone/Start End Time/Job Category/SubMenu permission");
		Select drpDownPostingStartTime = new Select(
				mngDistPrivPage.getDrpDownPostingStartTime());
		postingStartTime = commonLib.getText(drpDownPostingStartTime
				.getFirstSelectedOption());
		Select drpDownPostingEndTime = new Select(
				mngDistPrivPage.getDrpDownPostingEndTime());
		postingEndTime = commonLib.getText(drpDownPostingEndTime
				.getFirstSelectedOption());
		if (!commonLib.isSelected(mngDistPrivPage.getChkBoxZoneRequired())) {
			commonLib.click(mngDistPrivPage.getChkBoxZoneRequired(),
					"Zone Required ChkBox");
			flag = true;
		}
		if (!commonLib.isSelected(mngDistPrivPage
				.getRadioBtnDistrictDefaultJobCategory())) {
			commonLib.click(
					mngDistPrivPage.getRadioBtnDistrictDefaultJobCategory(),
					"District Default Job Category Radio Btn");
			flag1 = true;
		}
		if (!commonLib.isSelected(mngDistPrivPage
				.getChkBoxDisplaySubMenuAsParentMenu())) {
			commonLib.click(
					mngDistPrivPage.getChkBoxDisplaySubMenuAsParentMenu(),
					"Display Sub Menu as Parent Menu ChkBox");
			flag2 = true;
		}
		if (flag || flag1 || flag2) {
			saveDistrict();
		}
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		commonLib
				.logOnSuccess(
						"Zone Start End Time Job Category SubMenu Permissions",
						"Zone/Start End Time/Job Category/SubMenu permission setup done");

		commonLib.logOnInfo("Zone Required Permissions",
				"Verifying Zone field while creating job");
		dJobOrdersLib.navigateToAddDistrictJobOrder();
		if (userType.equals("TM")) {
			commonLib.typeText(sJobOrderPage.getTxtBoxDistrict(), district,
					"District Name");
			commonLib.typeKeys(sJobOrderPage.getTxtBoxDistrict(), Keys.DOWN);
			commonLib.typeKeys(sJobOrderPage.getTxtBoxDistrict(), Keys.UP);
			commonLib.typeText(sJobOrderPage.getTxtBoxJobTitle(), "",
					"Job Title TxtBox");
		}
		if (commonLib.isDisplayed(sJobOrderPage.getDrpDownZone())) {
			commonLib.logOnSuccess("Zone Required Permissions",
					"Zone field appeared while creating job");
		} else {
			commonLib.logOnError("Zone Required Permissions",
					"Zone field not appeared while creating job");
		}
		commonLib.logOnInfo("Posting Start End Time Permissions",
				"Verifying job start/end time of job");
		Select drpDownJobStartTime = new Select(
				sJobOrderPage.getDrpDownStartTime());
		jobStartTime = commonLib.getText(drpDownJobStartTime
				.getFirstSelectedOption());
		Select drpDownJobEndTime = new Select(sJobOrderPage.getDrpDownEndTime());
		jobEndTime = commonLib.getText(drpDownJobEndTime
				.getFirstSelectedOption());
		if (postingStartTime.equals(jobStartTime)
				&& postingEndTime.equals(jobEndTime)) {
			commonLib.logOnSuccess("Posting Start End Time Permissions",
					"Job start/end time matched with posting start/end time");
		} else {
			commonLib
					.logOnError("Posting Start End Time Permissions",
							"Job start/end time not matched with posting start/end time");
		}
		commonLib.logOnInfo("Job Category Permissions",
				"Verifying Job Category while creating job");
		Select drpDownJobCategory = new Select(
				sJobOrderPage.getDrpDownJobCategory());
		boolean result = false;
		List<WebElement> jobCategoryOptions = drpDownJobCategory.getOptions();
		for (WebElement temp : jobCategoryOptions) {
			if (commonLib.getText(temp).equals(jobCategory)) {
				commonLib
						.logOnError("Job Category Permissions",
								"TeacherMatch Job Category item found in District Job Category");
				loginLib.logout();
				result = true;
				break;
			}
		}
		if (!result) {
			commonLib
					.logOnSuccess("Job Category Permissions",
							"Only District Job Category items found in Job Category dropdown");
		}
		if (userType.equals("TM")) {
			loginLib.logout();
			daUsername = excelData.getExcelData("Login", 3, 1);
			daPassword = excelData.getExcelData("Login", 3, 2);
			daUserType = excelData.getExcelData("Login", 3, 3);
			loginLib.login(daUsername, daPassword, daUserType);
		}
		commonLib.logOnInfo("Display Sub Menu as Parent Menu Permissions",
				"Verifying display sub menu as parent menu permission");
		if (!commonLib.isDisplayed(mngDistPrivPage.getMenuImport())) {
			commonLib.logOnSuccess(
					"Display Sub Menu as Parent Menu Permissions",
					"Sub menu is displayed as parent menu");
		} else {
			commonLib.logOnError("Display Sub Menu as Parent Menu Permissions",
					"Sub menu is not displayed as parent menu");
		}
		loginLib.logout();
	}

	public void setQQSetToJobCategoryPermission(String district,
			String setQQSetToJobCategory, String jobCategoryForQQ, int rowNum)
			throws Exception {
		commonLib
				.logOnInfo("Set QQ Set to Job Category Permission",
						"Setting 'Set Qualification Question Set to Job Category' permission");
		commonLib.selectDrpDownValue(
				mngDistPrivPage.getDrpDownSetQQToJobCategory(),
				setQQSetToJobCategory, "Set QQ Set to Job Category Drpdown");
		if (!commonLib.isSelected(mngDistPrivPage.getChkBoxDisplaySchoolName())) {
			commonLib.click(mngDistPrivPage.getChkBoxDisplaySchoolName(),
					"Display School Name ChkBox");
		}
		saveDistrict();
		commonLib.logOnSuccess("Set QQ Set to Job Category Permission",
				"Set QQ Set to Job Category permission setup done");
		sheetName = "DADJO";
		id = randomGenerator.nextInt(999999);
		district = excelData.getExcelData(sheetName, rowNum, 4);
		schoolName = excelData.getExcelData(sheetName, rowNum, 5);
		zone = excelData.getExcelData(sheetName, rowNum, 6);
		jobTitle = "AutoGenTitle" + id;
		requisitionNumber = id + "";
		jobType = excelData.getExcelData(sheetName, rowNum, 8);

		expectedHire = excelData.getExcelData(sheetName, rowNum, 10);
		jobDecription = "AutoGenDesc" + id;
		redirectURL = excelData.getExcelData(sheetName, rowNum, 14);
		jobApprovalProcess = excelData.getExcelData(sheetName, rowNum, 15);
		excelData.setExcelData(sheetName, rowNum, 17, "AutoRefNo"
				+ randomGenerator.nextInt(99999));
		refNo = excelData.getExcelData(sheetName, rowNum, 17);
		dJobOrdersLib.createJobWithAttachSchool(district, schoolName, zone,
				jobTitle, jobType, jobCategoryForQQ, expectedHire,
				jobDecription, requisitionNumber, sheetName, redirectURL,
				jobApprovalProcess, refNo, rowNum);
		jobId = excelData.getExcelData(sheetName, rowNum, 12);
		excelData.setExcelData(sheetName, rowNum, 7, jobTitle);
		excelData.setExcelData(sheetName, rowNum, 11, jobDecription);
		excelData.setExcelData(sheetName, rowNum, 13, requisitionNumber);

		loginLib.logout();
		candidateUsername = excelData.getExcelData("AddUser", 4, 3);
		candidatePassword = excelData.getExcelData("AddUser", 4, 4);
		candidateUserType = excelData.getExcelData("AddUser", 4, 5);
		loginLib.login(candidateUsername, candidatePassword, candidateUserType);
		applyForJobsLib.applyJobByTitle(district, jobTitle);
		String coverLetterTxt = excelData.getExcelData("JobApplication", 2, 2);
		applyForJobsLib.fillCoverLetter(coverLetterTxt);
		applyForJobsLib.fillDSPQ();
		commonLib.logOnInfo("Set QQ Set to Job Category Permission",
				"Verify QQ Set to Job Category Permission");
		if (commonLib.getText(applyForJobsPage.getQuestion1QQ()).equals(
				"Test 1")
				&& commonLib.getText(applyForJobsPage.getQuestion2QQ()).equals(
						"Test 2")) {
			commonLib.logOnSuccess("Set QQ Set to Job Category Permission",
					"Questions in QQ displayed correctly");
		} else {
			commonLib.logOnError("Set QQ Set to Job Category Permission",
					"Questions in QQ not displayed correctly");
		}
		driver.get("https://qa.teachermatch.org/jobsofinterest.do");
		commonLib.waitForPageToLoad();
		loginLib.logout();
	}

	public void setDPointBeforeStatusPrivilege(String userType, String jobId,
			String candidateMailId) throws Exception {
		commonLib.logOnInfo("Set D-Point Before Status Privilege",
				"Setting 'D-Point Before Status' privilege");
		if (!commonLib.isSelected(mngDistPrivPage
				.getChkBoxNoteIsRequiredForStatuses())) {
			commonLib.click(
					mngDistPrivPage.getChkBoxNoteIsRequiredForStatuses(),
					"Note is Required Chk Box");
		}
		if (!commonLib.isSelected(mngDistPrivPage
				.getChkBoxRequisitionNoIsRequiredForHiring())) {
			commonLib
					.click(mngDistPrivPage
							.getChkBoxRequisitionNoIsRequiredForHiring(),
							"Requisition no is required for hiring ChkBox");
		}
		commonLib.click(mngDistPrivPage.getRadioBtnSetDPointBeforeStatus(),
				"Set D-point Before Status Radio Btn");
		saveDistrict();
		commonLib.logOnSuccess("Set D-Point Before Status Privilege",
				"'D-Point Before Status' privilege setup done");
		if (userType.equals("TM")) {
			loginLib.logout();
			daUsername = excelData.getExcelData("Login", 3, 1);
			daPassword = excelData.getExcelData("Login", 3, 2);
			daUserType = excelData.getExcelData("Login", 3, 3);
			loginLib.login(daUsername, daPassword, daUserType);
		}
		commonLib.logOnInfo("Verify Note is Required for Status Privilege",
				"Verifying 'Note is required for Status' privilege");
		dJobOrdersLib.navigateToDistrictJobOrder();
		commonLib.typeText(sJobOrderPage.getTxtBxJobOrderId(), jobId,
				"Job Id TxtBox");
		commonLib.click(sJobOrderPage.getBtnSearchJobOrder(), "Search Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(sJobOrderPage.getMessageNoRecordFound())) {
			commonLib.logOnError("Verify D-Point Before Status Privilege",
					"Job with given id not found");
			return;
		}
		String parentWindow = driver.getWindowHandle();
		commonLib.click(sJobOrderPage.getIconCandiateGrid(),
				"Candidate Grid Icon");
		commonLib.waitForPageToLoad();
		Set<String> windows = driver.getWindowHandles();
		for (String temp : windows) {
			if (!temp.equals(parentWindow)) {
				driver.switchTo().window(temp);
				break;
			}
		}
		commonLib.click(candidateGridPage.getIconSearch(), "Search icon");
		commonLib.waitForPageToLoad();
		commonLib.typeText(candidateGridPage.getTxtBoxEmail(), candidateMailId,
				"Email Address field");
		commonLib.click(candidateGridPage.getBtnSearchCG(), "Search button");
		commonLib.waitForPageToLoad();
		commonLib.click(candidateGridPage.getLinkStatus(), "Status Link");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(candidateGridPage
				.getBtnOkIncompleteApplication())) {
			commonLib.click(candidateGridPage.getBtnOkIncompleteApplication(),
					"Ok Btn");
			commonLib.waitForPageToLoad();
		}
		commonLib.click(candidateGridPage.getNodePointScreeningComplete(),
				"Screening Complete Node");
		commonLib.waitForPageToLoad();

		commonLib.click(candidateGridPage.getBtnFinalize(), "Finalize Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(candidateGridPage.getBtnDontScore())) {
			commonLib.click(candidateGridPage.getBtnDontScore(),
					"Don't Score Btn");
			commonLib.waitForPageToLoad();
		}
		if (commonLib
				.isDisplayed(candidateGridPage.getErrorMessageStatusNote())) {
			commonLib.logOnSuccess(
					"Verify Note is Required for Status Privilege",
					"Note is required for finalizing the nodes");
		} else {
			commonLib.logOnError(
					"Verify Note is Required for Status Privilege",
					"Note is not required for finalizing the nodes");
		}
		commonLib.logOnInfo("Verify D-Point Before Status Privilege",
				"Verifying D-Point before status privilege");
		commonLib.click(candidateGridPage.getLinkAddNote(), "Add Note Link");
		Thread.sleep(2000);
		commonLib.typeText(candidateGridPage.getTxtBoxNote(), "Notes",
				"Note TxtBox");
		commonLib.click(candidateGridPage.getBtnFinalize(), "Finalize Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(candidateGridPage.getBtnDontScore())) {
			commonLib.click(candidateGridPage.getBtnDontScore(),
					"Don't Score Btn");
			commonLib.waitForPageToLoad();
		}
		Thread.sleep(10000);
		candidateGridPage = PageFactory.initElements(driver,
				CandidateGridPL.class);
		if (commonLib.getAttribute(
				candidateGridPage.getNodePointScreeningComplete(), "class")
				.equals("txtgreenbgroundstatus")) {
			commonLib.logOnSuccess("Verify D-Point Before Status Privilege",
					"D-Point is finalized before associated nodes");
		} else {
			commonLib.logOnError("Verify D-Point Before Status Privilege",
					"D-Point is not finalized before associated nodes");
		}
		commonLib.click(candidateGridPage.getBtnDone(), "Done Btn");
		commonLib.waitForPageToLoad();

		commonLib.logOnInfo("Verify Req. No. is Required for Hiring Privilege",
				"Verifying req. no. is required for hiring privilege");
		commonLib.click(candidateGridPage.getLinkStatus(), "Status Link");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(candidateGridPage
				.getBtnOkIncompleteApplication())) {
			commonLib.click(candidateGridPage.getBtnOkIncompleteApplication(),
					"Ok Btn");
			commonLib.waitForPageToLoad();
		}
		commonLib.click(candidateGridPage.getNodePointHired(), "Hired Node");
		commonLib.waitForPageToLoad();
		commonLib.click(candidateGridPage.getLinkAddNote(), "Add Note Link");
		Thread.sleep(2000);
		commonLib.typeText(candidateGridPage.getTxtBoxNote(), "Notes",
				"Note TxtBox");
		commonLib.click(candidateGridPage.getBtnFinalize(), "Finalize Btn");
		commonLib.waitForPageToLoad();
		if (commonLib
				.isDisplayed(candidateGridPage.getErrorMessageStatusNote())) {
			if (commonLib
					.getText(candidateGridPage.getErrorMessageStatusNote())
					.contains("Requisition/Position # is mandatory")) {
				commonLib.logOnSuccess(
						"Verify Req. No. is Required for Hiring Privilege",
						"Req. no. is required for hiring candidate");
			} else {
				commonLib.logOnSuccess(
						"Verify Req. No. is Required for Hiring Privilege",
						"Req. no. is not required for hiring candidate");
			}
		}
		commonLib.click(candidateGridPage.getBtnCancelReferenceChk(),
				"Cancel Btn");
		Thread.sleep(2000);
		commonLib.click(candidateGridPage.getBtnDone(), "Done Btn");
		commonLib.waitForPageToLoad();

		driver.close();
		driver.switchTo().window(parentWindow);
		commonLib.waitForPageToLoad();
		loginLib.logout();
	}

	public void setDPointAfterStatusPrivilege(String userType, String jobId,
			String candidateMailId) throws Exception {
		commonLib.logOnInfo("Set D-Point After Status Privilege",
				"Setting 'D-Point After Status' privilege");
		commonLib.click(mngDistPrivPage.getRadioBtnSetDPointAfterStatus(),
				"Set D-point After Status Radio Btn");
		Thread.sleep(2000);
		if (!commonLib.isSelected(mngDistPrivPage.getChkBoxScreeningComplete())) {
			commonLib.click(mngDistPrivPage.getChkBoxScreeningComplete(),
					"Screening Complete Chk Box");
		}
		if (!commonLib
				.isSelected(mngDistPrivPage.getChkBoxEvaluationComplete())) {
			commonLib.click(mngDistPrivPage.getChkBoxEvaluationComplete(),
					"Evaluation Complete Chk Box");
		}
		if (!commonLib.isSelected(mngDistPrivPage.getChkBoxVettingComplete())) {
			commonLib.click(mngDistPrivPage.getChkBoxVettingComplete(),
					"Vetting Complete Chk Box");
		}
		saveDistrict();
		commonLib.logOnSuccess("Set D-Point After Status Privilege",
				"'D-Point After Status' privilege setup done");
		if (userType.equals("TM")) {
			loginLib.logout();
			daUsername = excelData.getExcelData("Login", 3, 1);
			daPassword = excelData.getExcelData("Login", 3, 2);
			daUserType = excelData.getExcelData("Login", 3, 3);
			loginLib.login(daUsername, daPassword, daUserType);
		}
		commonLib.logOnInfo("Verify D-Point After Status Privilege",
				"Verifying 'D-Point After Status' privilege");
		dJobOrdersLib.navigateToDistrictJobOrder();
		commonLib.typeText(sJobOrderPage.getTxtBxJobOrderId(), jobId,
				"Job Id TxtBox");
		commonLib.click(sJobOrderPage.getBtnSearchJobOrder(), "Search Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(sJobOrderPage.getMessageNoRecordFound())) {
			commonLib.logOnError("Verify D-Point Before Status Privilege",
					"Job with given id not found");
			return;
		}
		String parentWindow = driver.getWindowHandle();
		commonLib.click(sJobOrderPage.getIconCandiateGrid(),
				"Candidate Grid Icon");
		commonLib.waitForPageToLoad();
		Set<String> windows = driver.getWindowHandles();
		for (String temp : windows) {
			if (!temp.equals(parentWindow)) {
				driver.switchTo().window(temp);
				break;
			}
		}
		commonLib.click(candidateGridPage.getIconSearch(), "Search icon");
		commonLib.waitForPageToLoad();
		commonLib.typeText(candidateGridPage.getTxtBoxEmail(), candidateMailId,
				"Email Address field");
		commonLib.click(candidateGridPage.getBtnSearchCG(), "Search button");
		commonLib.waitForPageToLoad();
		commonLib.click(candidateGridPage.getLinkStatus(), "Status Link");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(candidateGridPage
				.getBtnOkIncompleteApplication())) {
			commonLib.click(candidateGridPage.getBtnOkIncompleteApplication(),
					"Ok Btn");
			commonLib.waitForPageToLoad();
		}
		commonLib.click(candidateGridPage.getNodePointEvaluationComplete(),
				"Evaluation Complete Node");
		commonLib.waitForPageToLoad();
		commonLib.click(candidateGridPage.getLinkAddNote(), "Add Note Link");
		Thread.sleep(2000);
		commonLib.typeText(candidateGridPage.getTxtBoxNote(), "Notes",
				"Note TxtBox");
		commonLib.click(candidateGridPage.getBtnFinalize(), "Finalize Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(candidateGridPage.getBtnDontScore())) {
			commonLib.click(candidateGridPage.getBtnDontScore(),
					"Don't Score Btn");
			commonLib.waitForPageToLoad();
			// Thread.sleep(5000);
		}
		if (commonLib
				.isDisplayed(candidateGridPage.getErrorMessageStatusNote())) {
			commonLib.logOnSuccess("Verify D-Point After Status Privilege",
					"D-Point can be finalized only after associated nodes");
		} else {
			commonLib.logOnError("Verify D-Point After Status Privilege",
					"D-Point is finalized before associated nodes");
		}
		commonLib.click(candidateGridPage.getBtnCancelReferenceChk(),
				"Cancel Btn");
		commonLib.waitForPageToLoad();
		commonLib.click(candidateGridPage.getBtnDone(), "Done Btn");
		commonLib.waitForPageToLoad();
		driver.close();
		driver.switchTo().window(parentWindow);
		commonLib.waitForPageToLoad();
		loginLib.logout();
	}

}
