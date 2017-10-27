package com.scripts.businessLogic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ManageEventsPL;
import com.scripts.pageObjectRepository.ManageUsersPL;

public class ManageEventsBL extends Driver {
	ManageEventsPL mngEvent = PageFactory.initElements(driver,
			ManageEventsPL.class);
	ManageUsersPL mngUserPage = PageFactory.initElements(driver,
			ManageUsersPL.class);
	CommonUtills commonLib = new CommonUtills();
	String currentUrl;

	// Navigated to Manage Events page through TM
	public void navigateToEventsTM() throws Exception {
		
		commonLib.waitForPageToLoadWithCond(mngEvent.getTabManage());
		commonLib.click(mngEvent.getTabManage(), "Manage Menu");
		commonLib.waitForPageToLoadWithCond(mngEvent.getSubMenuEventsTM());
		commonLib.click(mngEvent.getSubMenuEventsTM(), "Events Sub Menu");
		commonLib.waitForPageToLoad();
	}

	// Navigate to Manage Events page through DA
	public void navigateToEventsDA() throws Exception {
		commonLib.click(mngEvent.getTabManage(), "Manage Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(mngEvent.getSubMenuEventsDA(), "Events Sub Menu");
		commonLib.waitForPageToLoad();
	}

	// Navigate to Manage Events page through SA
	public void navigateToEventsSA() throws Exception {
		commonLib.click(mngEvent.getTabManage(), "Manage Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(mngEvent.getSubMenuEventsSA(), "Events Sub Menu");
		commonLib.waitForPageToLoad();
	}

	// District Settings
	public void manageEventsSettingSA(String districtName) throws Exception {
		commonLib.logOnInfo("District Settings",
				"Navigated to District Settings");
		commonLib.click(mngEvent.getTabManage(), "Manage Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(mngEvent.getSubMenuDistrictTM(), "District Sub Menu");
		commonLib.waitForPageToLoad();
		commonLib.typeText(mngEvent.getTxtBoxDistrictNameDistrict(),
				districtName, "District TxtBox");
		Thread.sleep(2000);
		commonLib.click(mngEvent.getFirstOptionManageDistrict(),
				"First from list");
		commonLib.click(mngEvent.getBtnSearchDistrict(), "Search Btn");
		commonLib.waitForPageToLoad();
		commonLib.click(mngEvent.getIconEditDistrict(),
				"Edit District Settings");
		commonLib.waitForPageToLoad();
		commonLib.click(mngEvent.getAccordionPrivilegeForSchool(),
				"Privilege For School accordion");
		if (!commonLib.isSelected(mngEvent.getChkBoxCreateEventsSA())) {
			commonLib.click(mngEvent.getChkBoxCreateEventsSA(),
					"School Admins may create and/or edit Events Checkbox");
		}
		commonLib.click(mngEvent.getBtnSaveDistrict(), "Save Button");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngEvent.getPopupConfirmationDistrict())) {
			commonLib.click(mngEvent.getBtnConfirmationDistrict(),
					"Confirmation Save button");
		}
		commonLib.logOnSuccess("District Settings",
				"District Settings saved successfully");
		commonLib.click(mngEvent.getBtnCloseManageDistrict(), "Close Button");

	}

	// Verify Events page Mandatory details
	public void verifyMandatoryFields() throws Exception {
		commonLib.logOnInfo("Verify Mandatory Details",
				"Validating Mandatory fields while adding Events");
		commonLib.click(mngEvent.getLinkAddEvent(), "Add Event Link");
		commonLib.waitForPageToLoad();
		
		commonLib.click(mngEvent.getBtnNext(), "Next Button");
		commonLib.click(mngEvent.getBtnNext(), "Next Button");
		commonLib.waitForPageToLoad();
		//Thread.sleep(2000);
		if (!commonLib.isDisplayed(mngEvent.getErrorMessageEvents())) {
			commonLib.logOnError("Verify Mandatory Details",
					"Events without entering mandatory details added");
			return;
		}
		commonLib.logOnSuccess("Verify Mandatory Details",
				"Mandatory fields verified successfully while adding Events");
		commonLib.click(mngEvent.getBtnCancel(), "Cancel Button");
	}

	// To Create Events
	public void addEvents(String userType, String districtName,
			String eventName, String eventType, String selectDescription,
			String candidateDescription, String facilitatorDescription,
			String timeZone, String strtTme,String endtime, String drpdwnFacilitatorEvents,
			String drpdwnCandidatesEvents) throws Exception {
		commonLib.logOnInfo("Create new Event", "Creating New Events");
		
		commonLib.waitForPageToLoadWithCond(mngEvent.getLinkAddEvent());
		commonLib.click(mngEvent.getLinkAddEvent(), "Add Event Link");
		commonLib.waitForPageToLoad();
		if (userType.equalsIgnoreCase("TM")) {
			
			commonLib.waitForPageToLoadWithCond(mngEvent.getTxtBoxDistrictName());
			commonLib.typeText(mngEvent.getTxtBoxDistrictName(), districtName,
					"District Name textfield");
			Thread.sleep(2000);
			commonLib.click(mngEvent.getDrpDownResultDistrictName(),
					"First from list");
		}
		commonLib.waitForPageToLoadWithCond(mngEvent.getTxtBoxEventName());
		commonLib.typeText(mngEvent.getTxtBoxEventName(), eventName,
				"Event Name textfield");
		commonLib.selectDrpDownValue(mngEvent.getDrpDownEventType(), eventType,
				"Event Type dropdown");
		String path = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Event_Logo.png";
		commonLib.typeText(mngEvent.getBtnLogo(), path, "LOGO");

		commonLib.selectDrpDownValue(mngEvent.getDrpDownDescription(),
				selectDescription, "Description dropdown");
		commonLib.selectDrpDownValue(mngEvent.getDrpDownCandidateDescription(),
				candidateDescription, "Candidate(s) dropdown");
		commonLib.selectDrpDownValue(
				mngEvent.getDrpDownFacilitatorDescription(),
				facilitatorDescription, "Facilitator(s) dropdown");
		commonLib.waitForPageToLoad();

		if (!commonLib.isDisplayed(mngEvent.getRadioBtnscheduleType())) {
			commonLib.logOnError("Create new Event",
					"Radio Button is not getting Displayed");
			return;
		}
		commonLib.click(mngEvent.getRadioBtnscheduleType(),
				"Schhedule Type radio button");
		commonLib.click(mngEvent.getBtnNext(), "Next Button");
         commonLib.waitForPageToLoadWithCond(mngEvent.getDrpDownTimeZone());

		if (!commonLib.isDisplayed(mngEvent.getDrpDownTimeZone())) {
			commonLib.logOnError("Create new Event", "Page is not loaded.");
			return;
		}
		commonLib.selectDrpDownValue(mngEvent.getDrpDownTimeZone(), timeZone,
				"Time Zone dropdown");
		commonLib.click(mngEvent.getDrpDownStartDate(), "Start Date Text Field");
		Thread.sleep(2000);
		commonLib.click(mngEvent.getDrpDownCurrentDate(), "Current Date");
		Thread.sleep(2000);
		commonLib.selectDrpDownValue(mngEvent.getDrpDownStrtTme(), strtTme,
				"Start Time dropdown");
		commonLib.selectDrpDownValue(mngEvent.getDrpDownEndTime(), endtime,
				"End Time dropdown");
		Thread.sleep(2000);
		commonLib.click(mngEvent.getSchedulebtnNext(), "Next button");
		commonLib.waitForPageToLoad();
		commonLib.waitForPageToLoadWithCond(mngEvent.getDrpDownFacilitatorName());
		
		if (!commonLib.isDisplayed(mngEvent.getDrpDownFacilitatorName())) {
			commonLib.logOnError("Events Facilitator", "Page is not loaded.");
			return;
		}
		//	if (userType.equalsIgnoreCase("TM")) {


		commonLib.typeText(mngEvent.getDrpDownFacilitatorName(),
				drpdwnFacilitatorEvents, "Facilitator Name Text Field");
		Thread.sleep(3000);
		commonLib.click(mngEvent.getBtnAddFacilitator(), "Add Buton");
		//Thread.sleep(5000);
	//	commonLib.click(mngEvent.getSubOptionFacilitatorName(),"Facilitator Name");
		Thread.sleep(5000);
		//commonLib.click(mngEvent.getBtnAddFacilitator(), "Add Buton");
	//	Thread.sleep(2000);
		//	}
commonLib.waitForPageToLoadWithCond(mngEvent.getBtnNext());
		commonLib.click(mngEvent.getBtnNext(), "Next button");
		Thread.sleep(5000);
		commonLib.waitForPageToLoadWithCond(mngEvent.getDrpDownCandidateName());
		if (!commonLib.isDisplayed(mngEvent.getDrpDownCandidateName())) {
			commonLib.logOnError("Events Candidates", "Page is not loaded.");
			return;

		}
		commonLib.typeText(mngEvent.getDrpDownCandidateName(),
				drpdwnCandidatesEvents, "Candidate Name Text Field");
		//Thread.sleep(2000);
		commonLib.click(mngEvent.getSubOptionCandidateName(), "Candidate Name");
		Thread.sleep(2000);
		commonLib.click(mngEvent.getBtnAddCandidateName(), "Add button");
		commonLib.waitForPageToLoadWithCond(mngEvent.getBtnSendInvite());
		
		commonLib.click(mngEvent.getBtnSendInvite(), "Send Invite Button");
		commonLib.waitForPageToLoad();
		Thread.sleep(2000);
		if (commonLib.isDisplayed(mngEvent.getBtnClosePopup())) {
			commonLib.logOnSuccess("Create new Event",
					"Events added Successfully");
		}
		commonLib.click(mngEvent.getBtnClosePopup(), "Close Button");
		commonLib.waitForPageToLoad();

	}

	// To Search Events with Logs

	public void searchEventsWithLogs(String userType, String districtName,
			String eventName, String eventType, String drpdwnCandidatesEvents,
			String candidateSubject) throws Exception {
		commonLib.logOnInfo("Search Events", "Searching newly created Events");
		commonLib.waitForPageToLoad();
		if (userType.equalsIgnoreCase("TM")) {
			
			commonLib.waitForPageToLoadWithCond(mngEvent.getTxtBoxSearchDistrict());
			commonLib.typeText(mngEvent.getTxtBoxSearchDistrict(),
					districtName, "District Name TxtBox");

			commonLib.typeKeys(mngEvent.getTxtBoxSearchDistrict(), Keys.DOWN);
			commonLib.typeKeys(mngEvent.getTxtBoxSearchDistrict(), Keys.UP);
			commonLib.click(mngEvent.getFirstOptionManageDistrictInEvent(), "District Namet entered");
		}
		commonLib.typeText(mngEvent.getTxtBoxSearchEventsName(), eventName,
				"Events Name TxtBox");
		commonLib.selectDrpDownValue(mngEvent.getDrpDownSearchEventsType(),
				eventType, "Event Type dropdown");
		commonLib.click(mngEvent.getBtnSearch(), "Search Button");
		commonLib.waitForPageToLoad();
		commonLib.waitForPageToLoadWithCond(mngEvent.getGridResultEvents());
		if (commonLib.getText(mngEvent.getGridResultEvents()).equals(eventName)) {
			commonLib.logOnSuccess("Search Events", "Events '" + eventName
					+ "' found Successfully");
		} else {
			commonLib.logOnError("Search Events", "Events '" + eventName
					+ "' not found");
			return;
		}
		commonLib.waitForPageToLoad();
		currentUrl = driver.getCurrentUrl();
		mailInvitationVerification(drpdwnCandidatesEvents, candidateSubject);
	}

	// To Search Events without Logs

	public void searchEvents(String userType, String districtName,
			String eventName, String eventType) throws Exception {
		if (userType.equalsIgnoreCase("TM")) {
			commonLib.waitForPageToLoadWithCond(mngEvent.getTxtBoxSearchDistrict());
			
			commonLib.typeText(mngEvent.getTxtBoxSearchDistrict(),
					districtName, "District Name TxtBox");
			Thread.sleep(2000);
			commonLib.click(mngEvent.getSubOptionSeachDistrictName(),
					"First from list");
		}
		commonLib.typeText(mngEvent.getTxtBoxSearchEventsName(), eventName,
				"Events Name TxtBox");
		commonLib.selectDrpDownValue(mngEvent.getDrpDownSearchEventsType(),
				eventType, "Event Type dropdown");
		commonLib.click(mngEvent.getBtnSearch(), "Search Button");
		commonLib.waitForPageToLoad();
	}

	// To open Schedule Page
	public void viewSchedulePage(String userType, String districtName,
			String eventName, String eventType) throws Exception {
		driver.get(currentUrl);
		commonLib.waitForPageToLoad();
		commonLib.logOnInfo("Schedule Page",
				"Opening Schedule Page of newly created Events");
		searchEvents(userType, districtName, eventName, eventType);
		commonLib.click(mngEvent.getIconSchedule(), "Schedule Icon");
		commonLib.waitForPageToLoad();
		if (commonLib.getText(mngEvent.getTextSchedulePage()).equals(
				"Event Schedule")) {
			commonLib.logOnSuccess("Schedule Page",
					"Schedule Page loaded successfully");
		} else {
			commonLib.logOnError("Schedule Page", "Schedule Page not loaded");
		}
		commonLib.click(mngEvent.getBtnCancelSchedulePage(), "Cancel Btn");

	}

	// To open Facilitator Page
	public void viewFacilitatorPage(String userType, String districtName,
			String eventName, String eventType) throws Exception {

		commonLib.logOnInfo("Facilitator Page",
				"Opening Facilitator Page of newly created Events");

		searchEvents(userType, districtName, eventName, eventType);
		commonLib.click(mngEvent.getIconFacilitator(), "Facilitator Icon");
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
		if (commonLib.getText(mngEvent.getTextFacilitatorPage()).equals(
				"Invite Facilitator")) {
			commonLib.logOnSuccess("Facilitator Page",
					"Facilitator Page loaded Successfully");
		} else {
			commonLib.logOnError("Facilitator Page",
					"Facilitator Page not loaded");
		}
		commonLib.click(mngEvent.getBtnCancelFacilitatorPage(),
				"Exit from Facilitator page");
	}

	// To open Candidates Page
	public void viewCandidatePage(String userType, String districtName,
			String eventName, String eventType) throws Exception {
		commonLib.logOnInfo("Candidate Page",
				"Opening Candidate Page of newly created document");
		searchEvents(userType, districtName, eventName, eventType);
		commonLib.click(mngEvent.getIconCandidate(), "Candidate Icon");
		commonLib.waitForPageToLoad();
		if (commonLib.getText(mngEvent.getTextCandidatePage()).equals(
				"Invite Candidate/Prospects")) {
			commonLib.logOnSuccess("Candidate Page",
					"Candidate Page loaded successfully");
		} else {
			commonLib.logOnError("Candidate Page", "Candidate Page not loaded");
		}
		commonLib.click(mngEvent.getBtnCancelCandidatesPage(), "Cancel Btn");
	}

	// To Edit Events
	public void editEvents(String userType, String districtName,
			String oldEventName, String eventType, String newEventName)
					throws Exception {
		commonLib.logOnInfo("Update Events", "Editing newly created Events");
		searchEvents(userType, districtName, oldEventName, eventType);
		commonLib.waitForPageToLoadWithCond(mngEvent.getIconEdit());
		commonLib.click(mngEvent.getIconEdit(), "Edit Icon");
		commonLib.waitForPageToLoadWithCond(mngEvent.getTextManageEventspage());
		
		if (!commonLib.getText(mngEvent.getTextManageEventspage()).equals(
				"Manage Events")) {
			commonLib.logOnError("Update Events", "Page is not loaded");
			return;
		}
		commonLib.typeText(mngEvent.getTxtBoxEventName(), newEventName,
				"Event Name TxtBox");
		commonLib.click(mngEvent.getBtnSaveManageEventsPage(),
				"Save and Exit Btn");
		commonLib.waitForPageToLoad();
		
		searchEvents(userType, districtName, newEventName, eventType);
		commonLib.waitForPageToLoad();
commonLib.waitForPageToLoadWithCond(mngEvent.getGridResultEvents());
		if (commonLib.getText(mngEvent.getGridResultEvents()).equals(
				newEventName)) {
			commonLib.logOnSuccess("Update Event", "Events '" + newEventName
					+ "' is updated successfully");
		} else {
			commonLib.logOnError("Update Events", "Events '" + newEventName
					+ "' is not updated");
			return;
		}
	}

	// To Print Event Single Records
	public void printEventSingleRecord() throws Exception {
		commonLib.logOnInfo("Print Events", "Printing newly created Events");
		commonLib.click(mngEvent.getIconPrintSingleRecords(), "Print Icon");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngEvent.getBtnPrintSingleRecords())) {
			commonLib
			.logOnSuccess("Print Events",
					"Print Preview Screen of newly created Event loaded successfully");
		} else {
			commonLib.logOnError("Print Events",
					"Print Preview Screen of newly created Event not loaded");
			return;
		}
		commonLib.click(mngEvent.getBtnCancelPrintSingleRecord(),
				"Cancel Print");
		commonLib.waitForPageToLoad();

	}

	// To Deactivate Events
	public void deactivateEvents() throws Exception {
		commonLib.logOnInfo("Deactivate Event",
				"Deactivating newly created Event");
		commonLib
		.click(mngEvent.getIconDeactivateEvent(), "Deactivating Event");
		commonLib.waitForPageToLoad();
		commonLib.click(mngEvent.getBtnDeleteEvents(), "Deleting Event");
		commonLib.waitForPageToLoad();
		if (commonLib.getText(mngEvent.getTxtCancelledEvent()).contains(
				"cancelled")) {
			commonLib.logOnSuccess("Deactivate Event",
					"Event deactivated successfully");
		} else {
			commonLib
			.logOnError("Deactivate Event", "Event is not deactivated");
		}

	}

	// To Export Events in Excel
	public void dwldExcel(String userType, String districtName,
			String drpdwnCandidatesEvents, String candidateDescription)
					throws Exception {
		commonLib.logOnInfo("Export Events in Excel",
				"Exporting Events in Excel format");
		if (userType.equalsIgnoreCase("TM")) {
			commonLib.typeText(mngEvent.getTxtBoxSearchDistrict(),
					districtName, "District Name TxtBox");
			Thread.sleep(2000);
			commonLib.typeKeys(mngEvent.getTxtBoxSearchDistrict(), Keys.DOWN);
			commonLib.typeKeys(mngEvent.getTxtBoxSearchDistrict(), Keys.UP);
		}
		commonLib.clear(mngEvent.getTxtBoxSearchEventsName(),
				"Event Name TxtBox");
		commonLib.click(mngEvent.getBtnSearch(), "Search Button");
		commonLib.waitForPageToLoad();
		commonLib.click(mngEvent.getIconExptrToExcelEvents(), "Download Excel");
		commonLib.waitForPageToLoad();
		commonLib.logOnSuccess("Export Events in Excel",
				"Events exported in Excel format");
		commonLib.waitForPageToLoad();
		currentUrl = driver.getCurrentUrl();
		mailCancellationVerification(drpdwnCandidatesEvents,
				candidateDescription);
	}

	// To Print Events All Records
	public void printEventMultipleRecord(String userType, String districtName)
			throws Exception {
		driver.get(currentUrl);
		commonLib.waitForPageToLoad();
		commonLib.logOnInfo("Print Events", "Printing Events");
		if (userType.equalsIgnoreCase("TM")) {
			commonLib.typeText(mngEvent.getTxtBoxSearchDistrict(),
					districtName, "District Name textfield");
			Thread.sleep(2000);
			commonLib.typeKeys(mngEvent.getTxtBoxSearchDistrict(), Keys.DOWN);
			commonLib.typeKeys(mngEvent.getTxtBoxSearchDistrict(), Keys.UP);
		}
		commonLib.clear(mngEvent.getTxtBoxSearchEventsName(),
				"Event Name Text Field");
		commonLib.click(mngEvent.getBtnSearch(), "Search Button");
		commonLib.waitForPageToLoad();
		commonLib.click(mngEvent.getIconPrintMultipleRecords(), "Print Icon");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngEvent.getBtnPrintMultipleRecords())) {
			commonLib.logOnSuccess("Print Events",
					"Print Preview Screen loaded successfully");
		} else {
			commonLib.logOnError("Print Events",
					"Print Preview Screen not loaded");
			return;
		}
		commonLib.waitForPageToLoad();
		commonLib.click(mngEvent.getBtnCancelPrintMultipleRecord(),
				"Cancel Print");
		commonLib.waitForPageToLoad();

	}

	// To Verify Invitation Mail
	public void mailInvitationVerification(String drpdwnCandidatesEvents,
			String candidateSubject) throws Exception {
		commonLib.logOnInfo("Events Invitation Mail",
				"Verifying Event Invitation Mail");
		int timeLimit = 10;
		boolean flag = false;
		if (drpdwnCandidatesEvents.contains("mailinator")) {
			driver.get("https://www.mailinator.com/");
			commonLib.waitForElement(mngUserPage.getLoginMailinator(),
					"Mailinator Login Btn");
			commonLib.typeText(mngUserPage.getLoginMailinator(),
					drpdwnCandidatesEvents, "Malinator mailId text box");
			commonLib.click(mngUserPage.getBtnGoMailinator(),
					"Mailinator Login");
			commonLib.waitForPageToLoad();
			commonLib.click(mngUserPage.getBtnRefresh(), "Refresh Btn");
			for (int i = 0; i < timeLimit; i++) {
				if (commonLib.isDisplayed(mngEvent
						.getMailMailinatorInviteEvent())) {
					commonLib.click(mngEvent.getMailMailinatorInviteEvent(),
							"Event Invitation Mail");
					driver.switchTo().frame("publicshowmaildivcontent");
					String mailContent = commonLib.getText(
							mngEvent.getMailContentMailinator(), "Email ID");
					if (mailContent.contains(candidateSubject)) {
						commonLib.logOnSuccess("Event Invitation Mail",
								"Desired Mail received successfully");
					} else {
						commonLib.logOnError("Event Invitation Mail",
								"Desired Mail not received");
					}
					driver.switchTo().defaultContent();
					flag = true;
					break;
				} else {
					Thread.sleep(5000);
					commonLib.click(mngUserPage.getBtnRefresh(), "Refresh Btn");
				}
			}
			if (!flag) {
				commonLib.logOnError("Event Invitation Mail",
						"Event Invitation Mail not sent");
			}
		}
		if (drpdwnCandidatesEvents.contains("yopmail")) {
			driver.get("yopmail.com");
			commonLib.waitForPageToLoad();
			commonLib.typeText(mngUserPage.getLoginYopmail(),
					drpdwnCandidatesEvents, "Enter Mail ID in Yopmail");
			commonLib.click(mngUserPage.getBtnChkInboxYopmail(),
					"Check Inbox Btn");
			commonLib.waitForPageToLoad();
			driver.switchTo().frame("ifinbox");
			for (int i = 0; i < timeLimit; i++) {
				if (commonLib.isDisplayed(mngEvent.getMailYopmailInviteEvent())) {
					commonLib.click(mngEvent.getMailYopmailInviteEvent(),
							"Event Invitation Mail");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("ifmail");
					String mailContent = commonLib.getText(
							mngEvent.getMailContentYopmail(), "Email ID");
					if (mailContent.contains(candidateSubject)) {
						commonLib.logOnSuccess("Event Invitation Mail",
								"Desired Mail received successfully");
						driver.switchTo().defaultContent();
						commonLib.click(mngUserPage.getIconDeleteMailYopmail(),
								"Delete Icon");
						Thread.sleep(2000);
						flag = true;
						break;
					}
				}
				Thread.sleep(5000);
				commonLib.click(mngEvent.getBtnRefreshYopmail(), "Refresh Btn");
			}
			if (!flag) {
				commonLib.logOnError("Event Invitation Mail",
						"Event Invitation Mail not sent");
			}
		}
	}

	// To verify Cancel Mail
	public void mailCancellationVerification(String drpdwnCandidatesEvents,
			String candidateDescription) throws Exception {
		commonLib.logOnInfo("Event Cancellation Mail",
				"Verifying Event Cancellation Mail");
		int timeLimit = 10;
		boolean flag = false;
		if (drpdwnCandidatesEvents.contains("mailinator")) {
			driver.get("https://www.mailinator.com/");
			commonLib.waitForElement(mngUserPage.getLoginMailinator(),
					"Mailinator Login Btn");
			commonLib.typeText(mngUserPage.getLoginMailinator(),
					drpdwnCandidatesEvents, "Malinator mailId text box");
			commonLib.click(mngUserPage.getBtnGoMailinator(),
					"Mailinator Login");
			commonLib.waitForPageToLoad();
			commonLib.click(mngUserPage.getBtnRefresh(), "Refresh Btn");
			for (int i = 0; i < timeLimit; i++) {
				if (commonLib.isDisplayed(mngEvent
						.getMailMailinatorInviteEvent())) {
					commonLib.click(mngEvent.getMailMailinatorInviteEvent(),
							"Event Cancellation Mail");
					driver.switchTo().frame("publicshowmaildivcontent");
					String mailContent = commonLib.getText(
							mngEvent.getMailContentMailinator(), "Email ID");
					if (mailContent.contains("Cancel Event")) {
						commonLib.logOnSuccess("Event Cancellation Mail",
								"Desired Mail received Received");
						driver.switchTo().defaultContent();
						flag = true;
						break;
					}
				}
				Thread.sleep(5000);
				commonLib.click(mngUserPage.getBtnRefresh(), "Refresh Btn");
			}
			if (!flag) {
				commonLib.logOnError("Event Cancellation Mail",
						"Event Cancellation Mail not sent successfully");
			}
		}
		if (drpdwnCandidatesEvents.contains("yopmail")) {
			driver.get("yopmail.com");
			commonLib.waitForPageToLoad();
			commonLib.typeText(mngUserPage.getLoginYopmail(),
					drpdwnCandidatesEvents, "Enter Email ID");
			commonLib.click(mngUserPage.getBtnChkInboxYopmail(),
					"Check Inbox Btn");
			commonLib.waitForPageToLoad();
			driver.switchTo().frame("ifinbox");
			for (int i = 0; i < timeLimit; i++) {
				if (commonLib.isDisplayed(mngEvent.getMailYopmailInviteEvent())) {
					commonLib.click(mngEvent.getMailYopmailInviteEvent(),
							"Event Cancellation Mail");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("ifmail");
					String mailContent = commonLib.getText(
							mngEvent.getMailContentYopmail(), "Email ID");
					if (mailContent.equals("Cancel Event")) {
						commonLib.logOnSuccess("Event Cancellation Mail",
								"Desired Mail Received");
						driver.switchTo().defaultContent();
						commonLib.click(mngUserPage.getIconDeleteMailYopmail(),
								"Delete Icon");
						Thread.sleep(2000);
					} else {
						commonLib.logOnError("Event Cancellation Mail",
								"Desired Mail not Received");
					}
					flag = true;
					break;
				} else {
					Thread.sleep(5000);
					commonLib.click(mngUserPage.getBtnRefresh(), "Refresh Btn");
				}
			}
			if (!flag) {
				commonLib.logOnError("Event Invitation Mail",
						"Event Invitation Mail not sent");
			}
		}
	}
}
