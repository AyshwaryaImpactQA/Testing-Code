package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ManageEventsPL {
	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid3")
	private WebElement tabManage;

	@FindBy(id = "submenuid39")
	private WebElement subMenuEventsTM;

	@FindBy(id = "submenuid38")
	private WebElement subMenuEventsDA;

	@FindBy(id = "submenuid32")
	private WebElement subMenuEventsSA;

	@FindBy(xpath = "//a[contains(text(),'+Add Event')]")
	private WebElement linkAddEvent;

	@FindBy(xpath = "//div[@id='errordiv']")
	private WebElement errorMessageEvents;

	@FindBy(xpath = "//button[@class='btn btn-dangerevents']")
	private WebElement btnCancel;

	@FindBy(id = "districtName")
	private WebElement txtBoxDistrictName;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement drpDownResultDistrictName;

	@FindBy(id = "eventtitle")
	private WebElement txtBoxEventName;

	@FindBy(xpath = "//*[@id='descriptiontext']/div/div[3]")
	private WebElement drpDownDescriptionSubject;

	@FindBy(id = "description")
	private WebElement drpDownDescription;

	@FindBy(id = "messagetoprinciple")
	private WebElement drpDownCandidateDescription;

	@FindBy(id = "msgtofacilitators")
	private WebElement drpDownFacilitatorDescription;

	@FindBy(id = "logo")
	private WebElement btnLogo;

	@FindBy(id = "interactionType")
	private WebElement drpDownEventType;

	@FindBy(xpath = ".//*[@id='intschedule']/label[1]")
	private WebElement radioBtnscheduleType;

	@FindBy(xpath = "//button[@id='save' and @class='btn btn-primary']")
	private WebElement btnNext;
	
	@FindBy(xpath = "(//button[@id='save' and @class='btn btn-primary'])[2]")
	private WebElement SchedulebtnNext;

	public WebElement getSchedulebtnNext() {
		if (commonLib.isDisplayed(SchedulebtnNext)) {
			return SchedulebtnNext;
		} else {
			return null;
		}
	}

	@FindBy(id = "timezoneforevent")
	private WebElement drpDownTimeZone;

	@FindBy(id = "starthr")
	private WebElement drpDownStrtTme;
	
	@FindBy(id = "endhr")
	private WebElement drpDownEndTime;
	
	public WebElement getDrpDownEndTime() {
		if (commonLib.isDisplayed(drpDownEndTime)) {
			return drpDownEndTime;
		} else {
			return null;
		}
	}

	@FindBy(id = "districtNameForSearch")
	private WebElement txtBoxSearchDistrict;

	@FindBy(xpath = "//input[@id='eventName']")
	private WebElement txtBoxSearchEventsName;

	@FindBy(id = "interactionTypeForSearch")
	private WebElement drpDownSearchEventsType;

	@FindBy(xpath = "//button[contains(@onclick , 'searchEventByButton()')]")
	private WebElement btnSearch;

	@FindBy(id = "eventStartDate")
	private WebElement drpDownStartDate;

	@FindBy(xpath = "//div[contains(@class, 'DynarchCalendar-day-today')]")
	private WebElement drpDownCurrentDate;

	@FindBy(id = "btnNext")
	private WebElement btnNextScheduleEvent;

	@FindBy(id = "facilatatorName")
	private WebElement drpDownFacilitatorName;

	@FindBy(xpath = "//button[contains(@onclick , 'addFacilatatorByAutoSujjest()')]")
	private WebElement btnAddFacilitator;

	@FindBy(xpath = "//button[contains(@onclick, 'moveParticipant()')]")
	private WebElement btnNextFacilitator;

	@FindBy(id = "searchTxt")
	private WebElement drpDownCandidateName;

	@FindBy(xpath = "//button[contains(@onclick, 'saveCandidate(0)')]")
	private WebElement btnAddCandidateName;

	@FindBy(xpath = "//button[contains(@onclick, 'sendEmails()')]")
	private WebElement btnSendInvite;

	@FindBy(id = "divResultdivTxtShowData20")
	private WebElement subOptionFacilitatorName;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement subOptionCandidateName;

	@FindBy(xpath = "//*[@id='sendEmailtoParticipants']//button[text()= 'Close']")
	private WebElement btnClosePopup;

	@FindBy(xpath = "//*[@id='eventTable']//tr[1]//td[1]")
	private WebElement gridResultEvents;

	@FindBy(xpath = "(//a[text()='Edit'])[1]")
	private WebElement iconEdit;

	@FindBy(xpath = "//*[@id='eventTable']//tr[1]/td[11]/a[2]")
	private WebElement iconDeactivate;

	@FindBy(xpath = "//*[@id='cancelEventpopupId']//button[@onclick='deleteEvent()']")
	private WebElement cnfrmationCancelEvents;

	@FindBy(xpath = "//*[@id='eventTable']/tbody/tr/td[3]/a/span")
	private WebElement iconSchedule;

	@FindBy(xpath = "//*[@id='eventTable']/tbody/tr/td[4]/a/span")
	private WebElement iconFacilitator;

	@FindBy(xpath = "//*[@id='eventTable']/tbody/tr/td[5]/a/span")
	private WebElement iconCandidate;

	@FindBy(xpath = "//div[contains(text(), 'Event Schedule')]")
	private WebElement textSchedulePage;

	@FindBy(xpath = "//div[contains(text(), 'Invite Facilitator')]")
	private WebElement textFacilitatorPage;

	@FindBy(xpath = "//div[contains(text(), 'Invite Candidate/Prospects')]")
	private WebElement textCandidatePage;

	@FindBy(id = "save")
	private WebElement btnCancelSchedulePage;

	@FindBy(xpath = "//button[@onclick = 'exitFacilitator()']")
	private WebElement btnCancelFacilitatorPage;

	@FindBy(xpath = "//button[@class = 'btn btn-dangerevents']")
	private WebElement btnCancelCandidatesPage;

	@FindBy(xpath = "//div[contains(text(), 'Manage Events')]")
	private WebElement textManageEventspage;

	@FindBy(xpath = "(//*[@id='save']/strong)[1]")
	private WebElement btnSaveManageEventsPage;

	@FindBy(id = "divResultdivTxtShowDataDistrict0")
	private WebElement subOptionSeachDistrictName;

	@FindBy(xpath = "//*[@id='eventTable']//td[11]/a[2]/i")
	private WebElement iconDeactivateEvent;

	@FindBy(xpath = "//*[@id='eventTable']//td[11]")
	private WebElement txtCancelledEvent;

	@FindBy(xpath = "//*[@id='xportdataPdfExlPrint']//td[1]//span")
	private WebElement iconExptrToExcelEvents;

	@FindBy(xpath = "//button[@onclick = 'deleteEvent()']")
	private WebElement btnDeleteEvents;

	@FindBy(id = "submenuid33")
	private WebElement subMenuDistrictTM;

	@FindBy(id = "districtName")
	private WebElement txtBoxDistrictNameDistrict;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement firstOptionManageDistrict;
	
	@FindBy(id = "divResultdivTxtShowDataDistrict0")
	private WebElement firstOptionManageDistrictInEvent;

	public WebElement getFirstOptionManageDistrictInEvent() {
		if (commonLib.isDisplayed(firstOptionManageDistrictInEvent)) {
			return firstOptionManageDistrictInEvent;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//button[@onclick = 'searchDistrict();']")
	private WebElement btnSearchDistrict;

	@FindBy(xpath = "//*[@id='tblGrid']//td[9]/a[1]/i")
	private WebElement iconEditDistrict;

	@FindBy(partialLinkText = "Privilege For School")
	private WebElement accordionPrivilegeForSchool;

	@FindBy(id = "sACreateEvent")
	private WebElement chkBoxCreateEventsSA;

	@FindBy(xpath = "//*[@id='accordion']//button[@class = 'btn btn-large btn-primary']")
	private WebElement btnSaveDistrict;

	@FindBy(xpath = "//button[@onclick = 'submitDuplicateTalentEd();']")
	private WebElement btnConfirmationDistrict;

	@FindBy(xpath = "//*[@id='duplicateTalentEDConfirmation']//div[@class = 'modal-body']")
	private WebElement popupConfirmationDistrict;

	@FindBy(xpath = "//*[@id='myModalUpdateMsg']//button[text() = 'Close']")
	private WebElement btnCloseManageDistrict;

	@FindBy(xpath = "//div[@id='m1']//span[contains(text(),'noreply@teachermatch.net')]")
	private WebElement mailYopmailInviteEvent;

	@FindBy(xpath = "//*[@id='mailhaut']/div[1]")
	private WebElement mailContentYopmail;

	@FindBy(xpath = "//div[@id='public_maildirdiv']//div[contains(@id,'row_public')][1]//div[contains(text(),'noreply@teachermatch.net')]")
	private WebElement mailMailinatorInviteEvent;

	@FindBy(xpath = "//*[@id='publicShowMailCtrl']//tr[4]/td[2]")
	private WebElement mailContentMailinator;

	@FindBy(id = "lrefr")
	public WebElement btnRefreshYopmail;

	@FindBy(xpath = "//*[@id='xportdataPdfExlPrint']//td[3]/a[1]")
	private WebElement iconPrintMultipleRecords;

	@FindBy(xpath = "//*[@id='printId']")
	private WebElement iconPrintSingleRecords;

	@FindBy(xpath = "//button[@onclick = 'printManageEventsDATA();']")
	private WebElement btnPrintMultipleRecords;

	@FindBy(xpath = "//button[@onclick = 'printEventDetails();']")
	private WebElement btnPrintSingleRecords;

	@FindBy(xpath = "//*[@id='printEventDiv']//td[2]/button")
	private WebElement btnCancelPrintSingleRecord;

	@FindBy(xpath = "//*[@id='printHiredApplicantsDiv']//td[2]/button")
	private WebElement btnCancelPrintMultipleRecord;

	public WebElement getTabManage() {
		if (commonLib.isDisplayed(tabManage)) {
			return tabManage;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuEventsTM() {
		if (commonLib.isDisplayed(subMenuEventsTM)) {
			return subMenuEventsTM;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuEventsDA() {
		if (commonLib.isDisplayed(subMenuEventsDA)) {
			return subMenuEventsDA;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuEventsSA() {
		if (commonLib.isDisplayed(subMenuEventsSA)) {
			return subMenuEventsSA;
		} else {
			return null;
		}
	}

	public WebElement getLinkAddEvent() {
		if (commonLib.isDisplayed(linkAddEvent)) {
			return linkAddEvent;
		} else {
			return null;
		}
	}

	public WebElement getErrorMessageEvents() {
		if (commonLib.isDisplayed(errorMessageEvents)) {
			return errorMessageEvents;
		} else {
			return null;
		}
	}

	public WebElement getBtnCancel() {
		if (commonLib.isDisplayed(btnCancel)) {
			return btnCancel;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxDistrictName() {
		if (commonLib.isDisplayed(txtBoxDistrictName)) {
			return txtBoxDistrictName;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownResultDistrictName() {
		if (commonLib.isDisplayed(drpDownResultDistrictName)) {
			return drpDownResultDistrictName;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxEventName() {
		if (commonLib.isDisplayed(txtBoxEventName)) {
			return txtBoxEventName;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownDescriptionSubject() {
		if (commonLib.isDisplayed(drpDownDescriptionSubject)) {
			return drpDownDescriptionSubject;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownDescription() {
		if (commonLib.isDisplayed(drpDownDescription)) {
			return drpDownDescription;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownCandidateDescription() {
		if (commonLib.isDisplayed(drpDownCandidateDescription)) {
			return drpDownCandidateDescription;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownFacilitatorDescription() {
		if (commonLib.isDisplayed(drpDownFacilitatorDescription)) {
			return drpDownFacilitatorDescription;
		} else {
			return null;
		}
	}

	public WebElement getBtnLogo() {
		if (commonLib.isDisplayed(btnLogo)) {
			return btnLogo;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownEventType() {
		if (commonLib.isDisplayed(drpDownEventType)) {
			return drpDownEventType;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnscheduleType() {
		if (commonLib.isDisplayed(radioBtnscheduleType)) {
			return radioBtnscheduleType;
		} else {
			return null;
		}
	}

	public WebElement getBtnNext() {
		if (commonLib.isDisplayed(btnNext)) {
			return btnNext;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownTimeZone() {
		if (commonLib.isDisplayed(drpDownTimeZone)) {
			return drpDownTimeZone;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownStrtTme() {
		if (commonLib.isDisplayed(drpDownStrtTme)) {
			return drpDownStrtTme;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxSearchDistrict() {
		if (commonLib.isDisplayed(txtBoxSearchDistrict)) {
			return txtBoxSearchDistrict;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxSearchEventsName() {
		if (commonLib.isDisplayed(txtBoxSearchEventsName)) {
			return txtBoxSearchEventsName;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownSearchEventsType() {
		if (commonLib.isDisplayed(drpDownSearchEventsType)) {
			return drpDownSearchEventsType;
		} else {
			return null;
		}
	}

	public WebElement getBtnSearch() {
		if (commonLib.isDisplayed(btnSearch)) {
			return btnSearch;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownStartDate() {
		if (commonLib.isDisplayed(drpDownStartDate)) {
			return drpDownStartDate;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownCurrentDate() {
		if (commonLib.isDisplayed(drpDownCurrentDate)) {
			return drpDownCurrentDate;
		} else {
			return null;
		}
	}

	public WebElement getBtnNextScheduleEvent() {
		if (commonLib.isDisplayed(btnNextScheduleEvent)) {
			return btnNextScheduleEvent;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownFacilitatorName() {
		if (commonLib.isDisplayed(drpDownFacilitatorName)) {
			return drpDownFacilitatorName;
		} else {
			return null;
		}
	}

	public WebElement getBtnAddFacilitator() {
		if (commonLib.isDisplayed(btnAddFacilitator)) {
			return btnAddFacilitator;
		} else {
			return null;
		}
	}

	public WebElement getBtnNextFacilitator() {
		if (commonLib.isDisplayed(btnNextFacilitator)) {
			return btnNextFacilitator;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownCandidateName() {
		if (commonLib.isDisplayed(drpDownCandidateName)) {
			return drpDownCandidateName;
		} else {
			return null;
		}
	}

	public WebElement getBtnAddCandidateName() {
		if (commonLib.isDisplayed(btnAddCandidateName)) {
			return btnAddCandidateName;
		} else {
			return null;
		}
	}

	public WebElement getBtnSendInvite() {
		if (commonLib.isDisplayed(btnSendInvite)) {
			return btnSendInvite;
		} else {
			return null;
		}
	}

	public WebElement getSubOptionFacilitatorName() {
		if (commonLib.isDisplayed(subOptionFacilitatorName)) {
			return subOptionFacilitatorName;
		} else {
			return null;
		}
	}

	public WebElement getSubOptionCandidateName() {
		if (commonLib.isDisplayed(subOptionCandidateName)) {
			return subOptionCandidateName;
		} else {
			return null;
		}
	}

	public WebElement getBtnClosePopup() {
		if (commonLib.isDisplayed(btnClosePopup)) {
			return btnClosePopup;
		} else {
			return null;
		}
	}

	public WebElement getGridResultEvents() {
		if (commonLib.isDisplayed(gridResultEvents)) {
			return gridResultEvents;
		} else {
			return null;
		}
	}

	public WebElement getIconEdit() {
		if (commonLib.isDisplayed(iconEdit)) {
			return iconEdit;
		} else {
			return null;
		}
	}

	public WebElement getIconDeactivate() {
		if (commonLib.isDisplayed(iconDeactivate)) {
			return iconDeactivate;
		} else {
			return null;
		}
	}

	public WebElement getCnfrmationCancelEvents() {
		if (commonLib.isDisplayed(cnfrmationCancelEvents)) {
			return cnfrmationCancelEvents;
		} else {
			return null;
		}
	}

	public WebElement getIconSchedule() {
		if (commonLib.isDisplayed(iconSchedule)) {
			return iconSchedule;
		} else {
			return null;
		}
	}

	public WebElement getIconFacilitator() {
		if (commonLib.isDisplayed(iconFacilitator)) {
			return iconFacilitator;
		} else {
			return null;
		}
	}

	public WebElement getIconCandidate() {
		if (commonLib.isDisplayed(iconCandidate)) {
			return iconCandidate;
		} else {
			return null;
		}
	}

	public WebElement getTextSchedulePage() {
		if (commonLib.isDisplayed(textSchedulePage)) {
			return textSchedulePage;
		} else {
			return null;
		}
	}

	public WebElement getTextFacilitatorPage() {
		if (commonLib.isDisplayed(textFacilitatorPage)) {
			return textFacilitatorPage;
		} else {
			return null;
		}
	}

	public WebElement getTextCandidatePage() {
		if (commonLib.isDisplayed(textCandidatePage)) {
			return textCandidatePage;
		} else {
			return null;
		}
	}

	public WebElement getBtnCancelSchedulePage() {
		if (commonLib.isDisplayed(btnCancelSchedulePage)) {
			return btnCancelSchedulePage;
		} else {
			return null;
		}
	}

	public WebElement getBtnCancelFacilitatorPage() {
		if (commonLib.isDisplayed(btnCancelFacilitatorPage)) {
			return btnCancelFacilitatorPage;
		} else {
			return null;
		}
	}

	public WebElement getBtnCancelCandidatesPage() {
		if (commonLib.isDisplayed(btnCancelCandidatesPage)) {
			return btnCancelCandidatesPage;
		} else {
			return null;
		}
	}

	public WebElement getTextManageEventspage() {
		if (commonLib.isDisplayed(textManageEventspage)) {
			return textManageEventspage;
		} else {
			return null;
		}
	}

	public WebElement getBtnSaveManageEventsPage() {
		if (commonLib.isDisplayed(btnSaveManageEventsPage)) {
			return btnSaveManageEventsPage;
		} else {
			return null;
		}
	}

	public WebElement getSubOptionSeachDistrictName() {
		if (commonLib.isDisplayed(subOptionSeachDistrictName)) {
			return subOptionSeachDistrictName;
		} else {
			return null;
		}
	}

	public WebElement getIconDeactivateEvent() {
		if (commonLib.isDisplayed(iconDeactivateEvent)) {
			return iconDeactivateEvent;
		} else {
			return null;
		}
	}

	public WebElement getTxtCancelledEvent() {
		if (commonLib.isDisplayed(txtCancelledEvent)) {
			return txtCancelledEvent;
		} else {
			return null;
		}
	}

	public WebElement getIconExptrToExcelEvents() {
		if (commonLib.isDisplayed(iconExptrToExcelEvents)) {
			return iconExptrToExcelEvents;
		} else {
			return null;
		}
	}

	public WebElement getBtnDeleteEvents() {
		if (commonLib.isDisplayed(btnDeleteEvents)) {
			return btnDeleteEvents;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuDistrictTM() {
		if (commonLib.isDisplayed(subMenuDistrictTM)) {
			return subMenuDistrictTM;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxDistrictNameDistrict() {
		if (commonLib.isDisplayed(txtBoxDistrictNameDistrict)) {
			return txtBoxDistrictNameDistrict;
		} else {
			return null;
		}
	}

	public WebElement getFirstOptionManageDistrict() {
		if (commonLib.isDisplayed(firstOptionManageDistrict)) {
			return firstOptionManageDistrict;
		} else {
			return null;
		}
	}

	public WebElement getBtnSearchDistrict() {
		if (commonLib.isDisplayed(btnSearchDistrict)) {
			return btnSearchDistrict;
		} else {
			return null;
		}
	}

	public WebElement getIconEditDistrict() {
		if (commonLib.isDisplayed(iconEditDistrict)) {
			return iconEditDistrict;
		} else {
			return null;
		}
	}

	public WebElement getAccordionPrivilegeForSchool() {
		if (commonLib.isDisplayed(accordionPrivilegeForSchool)) {
			return accordionPrivilegeForSchool;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxCreateEventsSA() {
		if (commonLib.isDisplayed(chkBoxCreateEventsSA)) {
			return chkBoxCreateEventsSA;
		} else {
			return null;
		}
	}

	public WebElement getBtnSaveDistrict() {
		if (commonLib.isDisplayed(btnSaveDistrict)) {
			return btnSaveDistrict;
		} else {
			return null;
		}
	}

	public WebElement getBtnConfirmationDistrict() {
		if (commonLib.isDisplayed(btnConfirmationDistrict)) {
			return btnConfirmationDistrict;
		} else {
			return null;
		}
	}

	public WebElement getPopupConfirmationDistrict() {
		if (commonLib.isDisplayed(popupConfirmationDistrict)) {
			return popupConfirmationDistrict;
		} else {
			return null;
		}
	}

	public WebElement getBtnCloseManageDistrict() {
		if (commonLib.isDisplayed(btnCloseManageDistrict)) {
			return btnCloseManageDistrict;
		} else {
			return null;
		}
	}

	public WebElement getMailYopmailInviteEvent() {
		if (commonLib.isDisplayed(mailYopmailInviteEvent)) {
			return mailYopmailInviteEvent;
		} else {
			return null;
		}
	}

	public WebElement getMailContentYopmail() {
		if (commonLib.isDisplayed(mailContentYopmail)) {
			return mailContentYopmail;
		} else {
			return null;
		}
	}

	public WebElement getMailMailinatorInviteEvent() {
		if (commonLib.isDisplayed(mailMailinatorInviteEvent)) {
			return mailMailinatorInviteEvent;
		} else {
			return null;
		}
	}

	public WebElement getMailContentMailinator() {
		if (commonLib.isDisplayed(mailContentMailinator)) {
			return mailContentMailinator;
		} else {
			return null;
		}
	}

	public WebElement getBtnRefreshYopmail() {
		if (commonLib.isDisplayed(btnRefreshYopmail)) {
			return btnRefreshYopmail;
		} else {
			return null;
		}
	}

	public WebElement getIconPrintMultipleRecords() {
		if (commonLib.isDisplayed(iconPrintMultipleRecords)) {
			return iconPrintMultipleRecords;
		} else {
			return null;
		}
	}

	public WebElement getIconPrintSingleRecords() {
		if (commonLib.isDisplayed(iconPrintSingleRecords)) {
			return iconPrintSingleRecords;
		} else {
			return null;
		}
	}

	public WebElement getBtnPrintMultipleRecords() {
		if (commonLib.isDisplayed(btnPrintMultipleRecords)) {
			return btnPrintMultipleRecords;
		} else {
			return null;
		}
	}

	public WebElement getBtnPrintSingleRecords() {
		if (commonLib.isDisplayed(btnPrintSingleRecords)) {
			return btnPrintSingleRecords;
		} else {
			return null;
		}
	}

	public WebElement getBtnCancelPrintSingleRecord() {
		if (commonLib.isDisplayed(btnCancelPrintSingleRecord)) {
			return btnCancelPrintSingleRecord;
		} else {
			return null;
		}
	}

	public WebElement getBtnCancelPrintMultipleRecord() {
		if (commonLib.isDisplayed(btnCancelPrintMultipleRecord)) {
			return btnCancelPrintMultipleRecord;
		} else {
			return null;
		}
	}

}
