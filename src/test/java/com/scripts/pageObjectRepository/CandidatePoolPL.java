package com.scripts.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class CandidatePoolPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid2")
	private WebElement usersMenu;

	@FindBy(id = "submenuid22")
	private WebElement candidateSubMenu;

	@FindBy(id = "jb5")
	private WebElement radioBtnOther;

	@FindBy(id = "firstName")
	private WebElement txtBoxFirstName;

	@FindBy(id = "emailAddress")
	private WebElement txtBoxEmail;

	@FindBy(id = "lastName")
	private WebElement txtBoxLastName;

	@FindBy(id = "messageSubject")
	private WebElement txtBoxSubject;

	@FindBy(xpath = "//*[@id='messageSend']/div/div[3]")
	private WebElement txtBoxMessage;

	@FindBy(id = "teachrEmailAdderssP1")
	private WebElement linkEmailAddress;

	@FindBy(id = "districttemplate")
	private WebElement drpDownTemplate;

	@FindBy(id = "btnChangetemplatelink")
	private WebElement btnApplyTemplate;

	@FindBy(xpath = "//button[@onclick = 'validateMessageForAdmin()']")
	private WebElement btnSendMessage;

	@FindBy(partialLinkText = "Attach a File")
	private WebElement linkAttachAFile;

	@FindBy(id = "fileMessageAd2")
	private WebElement btnAttachFirstFile;

	@FindBy(partialLinkText = "Add More")
	private WebElement linkAddMoreFile;

	@FindBy(id = "fileMessageAd3")
	private WebElement btnAttachSecondFile;

	@FindBy(xpath = "//a[@onclick = 'removeMessagesFileAdmin(2)']/img[@title = 'remove']")
	private WebElement btnRemoveFirstFile;

	@FindBy(xpath = "//a[@onclick = 'removeMessagesFileAdmin(3);']/img[@title = 'remove']")
	private WebElement btnRemoveSecondFile;

	@FindBy(id = "errordiv2")
	private WebElement errorMsgFileAttach;

	@FindBy(xpath = "//button[@onclick = 'searchTeacher()']")
	private WebElement btnSearchCandidates;

	@FindBy(xpath = "//*[@id='myMsgShow']//*[@id='message2show']")
	private WebElement successMsg;

	@FindBy(xpath = "//*[@id='myMsgShow']//button[contains(text(), 'Ok')]")
	private WebElement btnOK;

	@FindBy(id = "errordivMessage")
	private WebElement errorMsgMandatoryDetails;

	@FindBy(xpath = "//*[@id='myModalMessage']//button[contains(text(),'Cancel')]")
	private WebElement btnCancel;

	@FindBy(xpath = ".//*[@id='m1']//span[contains(text(),'noreply@teachermatch.net')]")
	private WebElement mailYopmail;

	@FindBy(xpath = "//*[@id='mailhaut']/div[1]")
	private WebElement mailContentYopmail;

	@FindBy(xpath = "//div[@id='public_maildirdiv']//div[@class = 'innermail ng-binding'][contains(text(),'noreply@teachermatch.net')]")
	private WebElement mailMailinator;

	@FindBy(xpath = "//*[@id='publicShowMailCtrl']//tr[4]/td[2]")
	private WebElement mailContentMailinator;

	@FindBy(id = "public_delete_button")
	private WebElement deleteIconMailinator;

	@FindAll(@FindBy(xpath = "//span[@class='lms']"))
	private List<WebElement> mailSubjectListYopmail;

	@FindAll(@FindBy(xpath = "//div[@id='public_maildirdiv']//div[contains(@style,'blue')]"))
	private List<WebElement> mailSubjectListMailinator;

	@FindBy(id = "advsearch")
	private WebElement linkOpenAdvancedSearch;

	@FindBy(id = "districtName")
	private WebElement txtBoxDistrict;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement firstOptionDistrict;

	@FindBy(id = "schoolName")
	private WebElement txtBoxSchool;

	@FindBy(id = "divResultdivTxtShowData20")
	private WebElement firstOptionSchool;

	@FindBy(xpath = "//table[@id='teacherTable']//td[7]/a")
	private WebElement linkActivateDeactivate;

	@FindBy(id = "epiACC1")
	private WebElement iconEPIAccomodation;

	@FindBy(id = "spAcc1")
	private WebElement iconSmartPracticesAccommodation;

	@FindBy(id = "epiAndJsi1")
	private WebElement iconAssessmentDetails;

	@FindBy(id = "epiTimeModal")
	private WebElement popupEPITime;

	@FindBy(id = "spsAccomodation")
	private WebElement popupSmartPracticesAccomodation;

	@FindBy(id = "epiAndJsi")
	private WebElement popupAssessmentDetails;

	@FindBy(id = "myModalJobList")
	private WebElement popupJobList;

	@FindBy(xpath = "//div[@id='epiTimeModal']//button[contains(text(),'Cancel')]")
	private WebElement btnCancelPopupEPITime;

	@FindBy(xpath = "//div[@id='spsAccomodation']//button[contains(text(),'Close')]")
	private WebElement btnClosePopupSmartPracticesAccomodation;

	@FindBy(xpath = "//div[@id='epiAndJsi']//button[contains(text(),'Close')]")
	private WebElement btnClosePopupAssessmentDetails;

	@FindBy(xpath = "//div[@id='myModalJobList']//button[contains(text(),'Close')]")
	private WebElement btnClosePopupJobList;

	@FindBy(xpath = "//table[@id='teacherTable']//td[4]/a[contains(@onclick,'getJobList')]")
	private WebElement linkViewJobsTM;

	@FindBy(xpath = "//table[@id='teacherTable']//td[6]/a[contains(@onclick,'getJobList')]")
	private WebElement linkViewJobsDASA;

	@FindBy(id = "tpJobApplied1")
	private WebElement iconAddCandidateToOtherJobs;

	@FindBy(xpath = "//table[@id='jobTableLst']//tr[1]/td[1]/input")
	private WebElement chkBoxJob;

	@FindBy(xpath = "//button[contains(text(),'Apply to Job')]")
	private WebElement btnApplyToJob;

	@FindBy(xpath = "//div[@id='myModal2']//button[contains(text(),'Ok')]")
	private WebElement btnOkJobApplied;

	@FindBy(id = "teacherFnameAndLname1")
	private WebElement linkCandidateProfile;

	@FindBy(id = "teacherDiv")
	private WebElement headerCandidateProfilePopup;

	@FindBy(xpath = "//div[@id='draggableDiv']//button")
	private WebElement btnCloseCandidateProfilePopup;

	@FindAll(@FindBy(xpath = "//div[@id='collapseEight']//div[3][contains(@class,'row')]//input[@type='checkbox']"))
	private List<WebElement> chkBoxColumnsInCandidateGrid;

	@FindBy(partialLinkText = "Candidate Grid")
	private WebElement accordionCandidateGrid;

	@FindBy(id = "select_all_candidate")
	private WebElement chkBoxSelectAllCandidates;

	@FindBy(xpath = "//tr[td[contains(text(),'Actions')]]//span/a")
	private WebElement drpDownAction;

	@FindBy(linkText = "Send Message")
	private WebElement linkSendMessage;

	@FindBy(linkText = "Apply tag")
	private WebElement linkApplyTag;

	@FindBy(linkText = "Print Resume")
	private WebElement linkPrintResume;

	@FindBy(id = "myModalMessageMassTP")
	private WebElement popupSendMessage;

	@FindBy(xpath = "//div[@id='myModalMessageMassTP']//button[contains(text(),'Cancel')]")
	private WebElement btnCancelPopupSendMessage;

	@FindBy(xpath = "//div[@id='applyTagsId']//tr[1]//input")
	private WebElement chkBoxTag;

	@FindBy(xpath = "//button[contains(text(),'Apply Tags')]")
	private WebElement btnApplyTags;

	@FindBy(id = "tagPreview1")
	private WebElement imgTag;

	public WebElement getUsersMenu() {
		if (commonLib.isDisplayed(usersMenu)) {
			return usersMenu;
		} else {
			return null;
		}
	}

	public WebElement getCandidateSubMenu() {
		if (commonLib.isDisplayed(candidateSubMenu)) {
			return candidateSubMenu;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnOther() {
		if (commonLib.isDisplayed(radioBtnOther)) {
			return radioBtnOther;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxFirstName() {
		if (commonLib.isDisplayed(txtBoxFirstName)) {
			return txtBoxFirstName;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxEmail() {
		if (commonLib.isDisplayed(txtBoxEmail)) {
			return txtBoxEmail;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxLastName() {
		if (commonLib.isDisplayed(txtBoxLastName)) {
			return txtBoxLastName;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxSubject() {
		if (commonLib.isDisplayed(txtBoxSubject)) {
			return txtBoxSubject;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxMessage() {
		if (commonLib.isDisplayed(txtBoxMessage)) {
			return txtBoxMessage;
		} else {
			return null;
		}
	}

	public WebElement getLinkEmailAddress() {
		if (commonLib.isDisplayed(linkEmailAddress)) {
			return linkEmailAddress;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownTemplate() {
		if (commonLib.isDisplayed(drpDownTemplate)) {
			return drpDownTemplate;
		} else {
			return null;
		}
	}

	public WebElement getBtnApplyTemplate() {
		if (commonLib.isDisplayed(btnApplyTemplate)) {
			return btnApplyTemplate;
		} else {
			return null;
		}
	}

	public WebElement getBtnSendMessage() {
		if (commonLib.isDisplayed(btnSendMessage)) {
			return btnSendMessage;
		} else {
			return null;
		}
	}

	public WebElement getLinkAttachAFile() {
		if (commonLib.isDisplayed(linkAttachAFile)) {
			return linkAttachAFile;
		} else {
			return null;
		}
	}

	public WebElement getBtnAttachFirstFile() {
		if (commonLib.isDisplayed(btnAttachFirstFile)) {
			return btnAttachFirstFile;
		} else {
			return null;
		}
	}

	public WebElement getLinkAddMoreFile() {
		if (commonLib.isDisplayed(linkAddMoreFile)) {
			return linkAddMoreFile;
		} else {
			return null;
		}
	}

	public WebElement getBtnAttachSecondFile() {
		if (commonLib.isDisplayed(btnAttachSecondFile)) {
			return btnAttachSecondFile;
		} else {
			return null;
		}
	}

	public WebElement getBtnRemoveFirstFile() {
		if (commonLib.isDisplayed(btnRemoveFirstFile)) {
			return btnRemoveFirstFile;
		} else {
			return null;
		}
	}

	public WebElement getBtnRemoveSecondFile() {
		if (commonLib.isDisplayed(btnRemoveSecondFile)) {
			return btnRemoveSecondFile;
		} else {
			return null;
		}
	}

	public WebElement getErrorMsgFileAttach() {
		if (commonLib.isDisplayed(errorMsgFileAttach)) {
			return errorMsgFileAttach;
		} else {
			return null;
		}
	}

	public WebElement getBtnSearchCandidates() {
		if (commonLib.isDisplayed(btnSearchCandidates)) {
			return btnSearchCandidates;
		} else {
			return null;
		}
	}

	public WebElement getSuccessMsg() {
		if (commonLib.isDisplayed(successMsg)) {
			return successMsg;
		} else {
			return null;
		}
	}

	public WebElement getBtnOK() {
		if (commonLib.isDisplayed(btnOK)) {
			return btnOK;
		} else {
			return null;
		}
	}

	public WebElement getErrorMsgMandatoryDetails() {
		if (commonLib.isDisplayed(errorMsgMandatoryDetails)) {
			return errorMsgMandatoryDetails;
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

	public WebElement getMailYopmail() {
		if (commonLib.isDisplayed(mailYopmail)) {
			return mailYopmail;
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

	public WebElement getMailMailinator() {
		if (commonLib.isDisplayed(mailMailinator)) {
			return mailMailinator;
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

	public WebElement getDeleteIconMailinator() {
		if (commonLib.isDisplayed(deleteIconMailinator)) {
			return deleteIconMailinator;
		} else {
			return null;
		}
	}

	public List<WebElement> getMailSubjectListYopmail() {
		if (commonLib.isDisplayed(mailSubjectListYopmail)) {
			return mailSubjectListYopmail;
		} else {
			return null;
		}
	}

	public List<WebElement> getMailSubjectListMailinator() {
		if (commonLib.isDisplayed(mailSubjectListMailinator)) {
			return mailSubjectListMailinator;
		} else {
			return null;
		}
	}

	public WebElement getLinkOpenAdvancedSearch() {
		if (commonLib.isDisplayed(linkOpenAdvancedSearch)) {
			return linkOpenAdvancedSearch;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxDistrict() {
		if (commonLib.isDisplayed(txtBoxDistrict)) {
			return txtBoxDistrict;
		} else {
			return null;
		}
	}

	public WebElement getFirstOptionDistrict() {
		if (commonLib.isDisplayed(firstOptionDistrict)) {
			return firstOptionDistrict;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxSchool() {
		if (commonLib.isDisplayed(txtBoxSchool)) {
			return txtBoxSchool;
		} else {
			return null;
		}
	}

	public WebElement getFirstOptionSchool() {
		if (commonLib.isDisplayed(firstOptionSchool)) {
			return firstOptionSchool;
		} else {
			return null;
		}
	}

	public WebElement getLinkActivateDeactivate() {
		if (commonLib.isDisplayed(linkActivateDeactivate)) {
			return linkActivateDeactivate;
		} else {
			return null;
		}
	}

	public WebElement getIconEPIAccomodation() {
		if (commonLib.isDisplayed(iconEPIAccomodation)) {
			return iconEPIAccomodation;
		} else {
			return null;
		}
	}

	public WebElement getIconSmartPracticesAccommodation() {
		if (commonLib.isDisplayed(iconSmartPracticesAccommodation)) {
			return iconSmartPracticesAccommodation;
		} else {
			return null;
		}
	}

	public WebElement getIconAssessmentDetails() {
		if (commonLib.isDisplayed(iconAssessmentDetails)) {
			return iconAssessmentDetails;
		} else {
			return null;
		}
	}

	public WebElement getPopupEPITime() {
		if (commonLib.isDisplayed(popupEPITime)) {
			return popupEPITime;
		} else {
			return null;
		}
	}

	public WebElement getBtnCancelPopupEPITime() {
		if (commonLib.isDisplayed(btnCancelPopupEPITime)) {
			return btnCancelPopupEPITime;
		} else {
			return null;
		}
	}

	public WebElement getPopupSmartPracticesAccomodation() {
		if (commonLib.isDisplayed(popupSmartPracticesAccomodation)) {
			return popupSmartPracticesAccomodation;
		} else {
			return null;
		}
	}

	public WebElement getBtnClosePopupSmartPracticesAccomodation() {
		if (commonLib.isDisplayed(btnClosePopupSmartPracticesAccomodation)) {
			return btnClosePopupSmartPracticesAccomodation;
		} else {
			return null;
		}
	}

	public WebElement getPopupAssessmentDetails() {
		if (commonLib.isDisplayed(popupAssessmentDetails)) {
			return popupAssessmentDetails;
		} else {
			return null;
		}
	}

	public WebElement getBtnClosePopupAssessmentDetails() {
		if (commonLib.isDisplayed(btnClosePopupAssessmentDetails)) {
			return btnClosePopupAssessmentDetails;
		} else {
			return null;
		}
	}

	public WebElement getLinkViewJobsTM() {
		if (commonLib.isDisplayed(linkViewJobsTM)) {
			return linkViewJobsTM;
		} else {
			return null;
		}
	}

	public WebElement getPopupJobList() {
		if (commonLib.isDisplayed(popupJobList)) {
			return popupJobList;
		} else {
			return null;
		}
	}

	public WebElement getBtnClosePopupJobList() {
		if (commonLib.isDisplayed(btnClosePopupJobList)) {
			return btnClosePopupJobList;
		} else {
			return null;
		}
	}

	public WebElement getLinkViewJobsDASA() {
		if (commonLib.isDisplayed(linkViewJobsDASA)) {
			return linkViewJobsDASA;
		} else {
			return null;
		}
	}

	public WebElement getIconAddCandidateToOtherJobs() {
		if (commonLib.isDisplayed(iconAddCandidateToOtherJobs)) {
			return iconAddCandidateToOtherJobs;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxJob() {
		if (commonLib.isDisplayed(chkBoxJob)) {
			return chkBoxJob;
		} else {
			return null;
		}
	}

	public WebElement getBtnApplyToJob() {
		if (commonLib.isDisplayed(btnApplyToJob)) {
			return btnApplyToJob;
		} else {
			return null;
		}
	}

	public WebElement getBtnOkJobApplied() {
		if (commonLib.isDisplayed(btnOkJobApplied)) {
			return btnOkJobApplied;
		} else {
			return null;
		}
	}

	public WebElement getLinkCandidateProfile() {
		if (commonLib.isDisplayed(linkCandidateProfile)) {
			return linkCandidateProfile;
		} else {
			return null;
		}
	}

	public WebElement getHeaderCandidateProfilePopup() {
		if (commonLib.isDisplayed(headerCandidateProfilePopup)) {
			return headerCandidateProfilePopup;
		} else {
			return null;
		}
	}

	public WebElement getBtnCloseCandidateProfilePopup() {
		if (commonLib.isDisplayed(btnCloseCandidateProfilePopup)) {
			return btnCloseCandidateProfilePopup;
		} else {
			return null;
		}
	}

	public List<WebElement> getChkBoxColumnsInCandidateGrid() {
		if (commonLib.isDisplayed(chkBoxColumnsInCandidateGrid)) {
			return chkBoxColumnsInCandidateGrid;
		} else {
			return null;
		}
	}

	public WebElement getAccordionCandidateGrid() {
		if (commonLib.isDisplayed(accordionCandidateGrid)) {
			return accordionCandidateGrid;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxSelectAllCandidates() {
		if (commonLib.isDisplayed(chkBoxSelectAllCandidates)) {
			return chkBoxSelectAllCandidates;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownAction() {
		if (commonLib.isDisplayed(drpDownAction)) {
			return drpDownAction;
		} else {
			return null;
		}
	}

	public WebElement getLinkSendMessage() {
		if (commonLib.isDisplayed(linkSendMessage)) {
			return linkSendMessage;
		} else {
			return null;
		}
	}

	public WebElement getLinkApplyTag() {
		if (commonLib.isDisplayed(linkApplyTag)) {
			return linkApplyTag;
		} else {
			return null;
		}
	}

	public WebElement getLinkPrintResume() {
		if (commonLib.isDisplayed(linkPrintResume)) {
			return linkPrintResume;
		} else {
			return null;
		}
	}

	public WebElement getPopupSendMessage() {
		if (commonLib.isDisplayed(popupSendMessage)) {
			return popupSendMessage;
		} else {
			return null;
		}
	}

	public WebElement getBtnCancelPopupSendMessage() {
		if (commonLib.isDisplayed(btnCancelPopupSendMessage)) {
			return btnCancelPopupSendMessage;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxTag() {
		if (commonLib.isDisplayed(chkBoxTag)) {
			return chkBoxTag;
		} else {
			return null;
		}
	}

	public WebElement getBtnApplyTags() {
		if (commonLib.isDisplayed(btnApplyTags)) {
			return btnApplyTags;
		} else {
			return null;
		}
	}

	public WebElement getImgTag() {
		if (commonLib.isDisplayed(imgTag)) {
			return imgTag;
		} else {
			return null;
		}
	}

}
