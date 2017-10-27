package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ManageUsersPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(xpath = "//a[text()='+Add User']")
	private WebElement btnAddUser;

	@FindBy(id = "districtORSchoolName")
	private WebElement txtBoxSchool;

	@FindBy(id = "onlyDistrictName")
	private WebElement txtBoxDistrict;

	@FindBy(id = "salutation")
	private WebElement drpdownSalutation;

	@FindBy(id = "divResultdivTxtDistrictData0")
	private WebElement firstDistrictItem;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement firstSchoolItem;

	@FindBy(id = "firstName")
	private WebElement txtBoxFirstName;

	@FindBy(id = "lastName")
	private WebElement txtBoxLastName;

	@FindBy(id = "AEU_RoleName")
	private WebElement drpdownRole;

	@FindBy(xpath = "//*[@id='hideSave']/button")
	private WebElement btnSaveUser;

	@FindBy(xpath = "//*[@id='myModalUserMsg']/div/div/div[3]/button")
	private WebElement btnCloseSuccessMsg;

	@FindBy(id = "login")
	private WebElement loginYopmail;

	@FindBy(xpath = "//input[@value='Check Inbox']")
	private WebElement btnChkInboxYopmail;

	@FindBy(id = "inboxfield")
	private WebElement loginMailinator;

	@FindBy(xpath = "//a[contains(@title,'Delete')]")
	private WebElement iconDeleteMailYopmail;

	@FindBy(id = "public_delete_button")
	private WebElement iconDeleteMailMailinator;

	@FindBy(xpath = "//span[text()='noreply@teachermatch.net']")
	private WebElement emailID;

	@FindBy(xpath = ".//*[@id='errordiv'][contains(text(),'A Member has already registered with the email address you provided')]")
	private WebElement errAlreadyExist;

	@FindBy(xpath = "//a[contains(text(),'resetpassword.do')]")
	private WebElement actLink;

	@FindBy(id = "txtPwd")
	private WebElement txtBoxPwd;

	@FindBy(id = "txtRePwd")
	private WebElement txtBoxRePwd;

	@FindBy(xpath = "//div[@id='teacherblockdiv']//button[contains(text(),'Ok')]")
	private WebElement btnOkResetPwd;

	@FindBy(xpath = "//div[contains(text(),'You have been successfully registered with TeacherMatch.')]")
	private WebElement textConfirmSignup;

	@FindBy(xpath = "//a[contains(text(),'verify.do?')]")
	private WebElement verifyAccLink;

	@FindBy(xpath = "//button[contains(text(),'Go!')]")
	private WebElement btnGoMailinator;

	@FindBy(xpath = ".//*[@id='publicInboxCtrl']//button[@title='Go!']")
	private WebElement btnRefresh;

	@FindBy(xpath = "//div[contains(text(),'Welcome to TeacherMatch, please confirm your account')]")
	private WebElement mailWelcome;

	@FindBy(xpath = "//div[@class='inner'][contains(text(),'Welcome to TeacherMatch')]")
	private WebElement mailWelcomeEdit;

	@FindBy(xpath = "//div[contains(text(),'I Have Added You As a User')]")
	private WebElement addUserMail;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btnLogin;

	@FindBy(id = "teacherFnameAndLname1")
	private WebElement linkTeacherFNameLName;

	@FindBy(xpath = "//div[@id='draggableDivMaster']//tr[td[contains(text(),'EEOC Support')]]//a")
	private WebElement linkShowEEOCDetail;

	@FindBy(xpath = "//h3[text()='EEOC Support']")
	private WebElement headerEEOCSupportPopup;

	@FindBy(xpath = ".//*[@id='eeocSupportModal']//button[contains(text(),'Close')]")
	private WebElement btnCloseEEOCSupportPopup;

	@FindBy(xpath = "//div[@id='draggableDivMaster']//div[@id='teacherDiv']/button")
	private WebElement btnCloseUserProfilePopup;

	public WebElement getMailWelcomeEdit() {
		if (commonLib.isDisplayed(mailWelcomeEdit)) {
			return mailWelcomeEdit;
		} else {
			return null;
		}
	}

	public WebElement getFirstDistrictItem() {
		if (commonLib.isDisplayed(firstDistrictItem)) {
			return firstDistrictItem;
		} else {
			return null;
		}
	}

	public WebElement getFirstSchoolItem() {
		if (commonLib.isDisplayed(firstSchoolItem)) {
			return firstSchoolItem;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//a[contains(text(),'teachermatch.org')]")
	private WebElement linkVerification;

	public WebElement getMailWelcome() {
		if (commonLib.isDisplayed(mailWelcome)) {
			return mailWelcome;
		} else {
			return null;
		}
	}

	public WebElement getLinkVerification() {
		if (commonLib.isDisplayed(linkVerification)) {
			return linkVerification;
		} else {
			return null;
		}
	}

	public WebElement getBtnGoMailinator() {
		if (commonLib.isDisplayed(btnGoMailinator)) {
			return btnGoMailinator;
		} else {
			return null;
		}
	}

	public WebElement getBtnAddUser() {
		if (commonLib.isDisplayed(btnAddUser)) {
			return btnAddUser;
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

	public WebElement getDrpdownSalutation() {
		if (commonLib.isDisplayed(drpdownSalutation)) {
			return drpdownSalutation;
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

	public WebElement getTxtBoxLastName() {
		if (commonLib.isDisplayed(txtBoxLastName)) {
			return txtBoxLastName;
		} else {
			return null;
		}
	}

	public WebElement getDrpdownRole() {
		if (commonLib.isDisplayed(drpdownRole)) {
			return drpdownRole;
		} else {
			return null;
		}
	}

	public WebElement getBtnSaveUser() {
		if (commonLib.isDisplayed(btnSaveUser)) {
			return btnSaveUser;
		} else {
			return null;
		}
	}

	public WebElement getBtnCloseSuccessMsg() {
		if (commonLib.isDisplayed(btnCloseSuccessMsg)) {
			return btnCloseSuccessMsg;
		} else {
			return null;
		}
	}

	public WebElement getLoginYopmail() {
		if (commonLib.isDisplayed(loginYopmail)) {
			return loginYopmail;
		} else {
			return null;
		}
	}

	public WebElement getEmailID() {
		if (commonLib.isDisplayed(emailID)) {
			return emailID;
		} else {
			return null;
		}
	}

	public WebElement getActLink() {
		if (commonLib.isDisplayed(actLink)) {
			return actLink;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxPwd() {
		if (commonLib.isDisplayed(txtBoxPwd)) {
			return txtBoxPwd;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxRePwd() {
		if (commonLib.isDisplayed(txtBoxRePwd)) {
			return txtBoxRePwd;
		} else {
			return null;
		}
	}

	public WebElement getBtnOkResetPwd() {
		if (commonLib.isDisplayed(btnOkResetPwd)) {
			return btnOkResetPwd;
		} else {
			return null;
		}
	}

	public WebElement getTextConfirmSignup() {
		if (commonLib.isDisplayed(textConfirmSignup)) {
			return textConfirmSignup;
		} else {
			return null;
		}
	}

	public WebElement getVerifyAccLink() {
		if (commonLib.isDisplayed(verifyAccLink)) {
			return verifyAccLink;
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

	public WebElement getLoginMailinator() {
		if (commonLib.isDisplayed(loginMailinator)) {
			return loginMailinator;
		} else {
			return null;
		}
	}

	public WebElement getErrAlreadyExist() {
		if (commonLib.isDisplayed(errAlreadyExist)) {
			return errAlreadyExist;
		} else {
			return null;
		}
	}

	public WebElement getBtnRefresh() {
		if (commonLib.isDisplayed(btnRefresh)) {
			return btnRefresh;
		} else {
			return null;
		}
	}

	public WebElement getAddUserMail() {
		if (commonLib.isDisplayed(addUserMail)) {
			return addUserMail;
		} else {
			return null;
		}
	}

	public WebElement getBtnLogin() {
		if (commonLib.isDisplayed(btnLogin)) {
			return btnLogin;
		} else {
			return null;
		}
	}

	public WebElement getLinkTeacherFNameLName() {
		if (commonLib.isDisplayed(linkTeacherFNameLName)) {
			return linkTeacherFNameLName;
		} else {
			return null;
		}
	}

	public WebElement getLinkShowEEOCDetail() {
		if (commonLib.isDisplayed(linkShowEEOCDetail)) {
			return linkShowEEOCDetail;
		} else {
			return null;
		}
	}

	public WebElement getHeaderEEOCSupportPopup() {
		if (commonLib.isDisplayed(headerEEOCSupportPopup)) {
			return headerEEOCSupportPopup;
		} else {
			return null;
		}
	}

	public WebElement getBtnCloseEEOCSupportPopup() {
		if (commonLib.isDisplayed(btnCloseEEOCSupportPopup)) {
			return btnCloseEEOCSupportPopup;
		} else {
			return null;
		}
	}

	public WebElement getBtnCloseUserProfilePopup() {
		if (commonLib.isDisplayed(btnCloseUserProfilePopup)) {
			return btnCloseUserProfilePopup;
		} else {
			return null;
		}
	}

	public WebElement getBtnChkInboxYopmail() {
		if (commonLib.isDisplayed(btnChkInboxYopmail)) {
			return btnChkInboxYopmail;
		} else {
			return null;
		}
	}

	public WebElement getIconDeleteMailYopmail() {
		if (commonLib.isDisplayed(iconDeleteMailYopmail)) {
			return iconDeleteMailYopmail;
		} else {
			return null;
		}
	}

	public WebElement getIconDeleteMailMailinator() {
		if (commonLib.isDisplayed(iconDeleteMailMailinator)) {
			return iconDeleteMailMailinator;
		} else {
			return null;
		}
	}

	@FindBy(id = "menuid3")
	private WebElement tabManage;

	@FindBy(id = "submenuid33")
	private WebElement subMenuDistrictTM;

	@FindBy(id = "districtName")
	private WebElement txtBoxDistrictNameDistrict;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement firstOptionManageDistrict;

	@FindBy(xpath = "//button[@onclick = 'searchDistrict();']")
	private WebElement btnSearchDistrict;

	@FindBy(xpath = "//*[@id='tblGrid']//td[9]/a[1]/i")
	private WebElement iconEditDistrict;

	@FindBy(partialLinkText = "Privilege For School")
	private WebElement accordionPrivilegeForSchool;

	public WebElement getTabManage() {
		if (commonLib.isDisplayed(tabManage)) {
			return tabManage;
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

	public WebElement getBtnSaveDistrict() {
		if (commonLib.isDisplayed(btnSaveDistrict)) {
			return btnSaveDistrict;
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

	public WebElement getBtnConfirmationDistrict() {
		if (commonLib.isDisplayed(btnConfirmationDistrict)) {
			return btnConfirmationDistrict;
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

	@FindBy(xpath = "//*[@id='accordion']//button[@class = 'btn btn-large btn-primary']")
	private WebElement btnSaveDistrict;

	@FindBy(xpath = "//*[@id='duplicateTalentEDConfirmation']//div[@class = 'modal-body']")
	private WebElement popupConfirmationDistrict;

	@FindBy(xpath = "//button[@onclick = 'submitDuplicateTalentEd();']")
	private WebElement btnConfirmationDistrict;

	@FindBy(xpath = "//*[@id='myModalUpdateMsg']//button[text() = 'Close']")
	private WebElement btnCloseManageDistrict;

	@FindBy(id = "saAddUser")
	private WebElement chkBoxAddUserSA;

	public WebElement getChkBoxAddUserSA() {
		if (commonLib.isDisplayed(chkBoxAddUserSA)) {
			return chkBoxAddUserSA;
		} else {
			return null;
		}
	}

	@FindBy(id = "errordiv")
	private WebElement errorMsgUser;

	public WebElement getErrorMsgUser() {
		if (commonLib.isDisplayed(errorMsgUser)) {
			return errorMsgUser;
		} else {
			return null;
		}
	}

	@FindBy(id = "MU_EntityType")
	private WebElement drpdownEntityType;

	@FindBy(id = "menuid2")
	private WebElement menuUsers;

	@FindBy(id = "submenuid22")
	private WebElement subMenuCandidates;

	@FindBy(id = "teacherTable")
	private WebElement gridCandidates;

	@FindBy(xpath = "//span[contains(@class,'thumbs')]")
	private WebElement iconThumbs;

	@FindBy(id = "emailAddress")
	private WebElement txtBoxEmailAdd;

	@FindBy(xpath = "//button[contains(text(), 'Search')]")
	private WebElement btnSearch;

	@FindBy(xpath = "//tr[1]//i[contains(@class, 'fa fa-times')]")
	private WebElement btnDeActivate;

	@FindBy(xpath = "//tr[1]//i[contains(@class, 'fa fa-check')]")
	private WebElement btnActivate;

	@FindBy(xpath = "//tr[1]//a[contains(@title, 'User/Location')]")
	private WebElement profileStatus;

	@FindBy(xpath = "//tr[1]//a[@title='Edit']")
	private WebElement btnEditUser;

	@FindBy(xpath = "//button[contains(text(),'Ok')][contains(@onclick,'editUser')]")
	private WebElement btnOkay;

	@FindBy(xpath = "//span[text()='User Details has been updated successfully']/ancestor::div[@class='modal-content']//button[text()='Close']")
	private WebElement btnClose;

	@FindBy(xpath = "//*[@id='tblGrid']/tbody/tr[1]/td[1]")
	private WebElement textName;

	@FindBy(id = "divResultdivTxtDistrictData0")
	private WebElement firstOptionDistrict;

	public WebElement getFirstOptionDistrict() {
		if (commonLib.isDisplayed(firstOptionDistrict)) {
			return firstOptionDistrict;
		} else {
			return null;
		}
	}

	public WebElement getDrpdownEntityType() {
		if (commonLib.isDisplayed(drpdownEntityType)) {
			return drpdownEntityType;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxEmailAdd() {
		if (commonLib.isDisplayed(txtBoxEmailAdd)) {
			return txtBoxEmailAdd;
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

	public WebElement getBtnDeActivate() {
		if (commonLib.isDisplayed(btnDeActivate)) {
			return btnDeActivate;
		} else {
			return null;
		}
	}

	public WebElement getBtnActivate() {
		if (commonLib.isDisplayed(btnActivate)) {
			return btnActivate;
		} else {
			return null;
		}
	}

	public WebElement getProfileStatus() {
		if (commonLib.isDisplayed(profileStatus)) {
			return profileStatus;
		} else {
			return null;
		}
	}

	public WebElement getBtnEditUser() {
		if (commonLib.isDisplayed(btnEditUser)) {
			return btnEditUser;
		} else {
			return null;
		}
	}

	public WebElement getBtnOkay() {
		if (commonLib.isDisplayed(btnOkay)) {
			return btnOkay;
		} else {
			return null;
		}
	}

	public WebElement getBtnClose() {
		if (commonLib.isDisplayed(btnClose)) {
			return btnClose;
		} else {
			return null;
		}
	}

	public WebElement getTextName() {
		if (commonLib.isDisplayed(textName)) {
			return textName;
		} else {
			return null;
		}
	}

	public WebElement getMenuUsers() {
		if (commonLib.isDisplayed(menuUsers)) {
			return menuUsers;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuCandidates() {
		if (commonLib.isDisplayed(subMenuCandidates)) {
			return subMenuCandidates;
		} else {
			return null;
		}
	}

	public WebElement getGridCandidates() {
		if (commonLib.isDisplayed(gridCandidates)) {
			return gridCandidates;
		} else {
			return null;
		}
	}

	public WebElement getIconThumbs() {
		if (commonLib.isDisplayed(iconThumbs)) {
			return iconThumbs;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[contains(text(),'Request for Resetting the Password')]")
	private WebElement sndNewPaswrdMail;

	public WebElement getSndNewPaswrdMail() {
		if (commonLib.isDisplayed(sndNewPaswrdMail)) {
			return sndNewPaswrdMail;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//a[contains(text(),'Send New Password')]")
	private WebElement sndNewPaswrdLnk;

	public WebElement getSndNewPaswrdLnk() {
		if (commonLib.isDisplayed(sndNewPaswrdLnk)) {
			return sndNewPaswrdLnk;
		} else {
			return null;
		}
	}

	@FindBy(id = "errordiv")
	private WebElement msgCnfrmationSndNewPassword;

	public WebElement getMsgCnfrmationSndNewPassword() {
		if (commonLib.isDisplayed(msgCnfrmationSndNewPassword)) {
			return msgCnfrmationSndNewPassword;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//span[text()='Request for Resetting the Password']")
	private WebElement sndNewPaswrdYopmail;

	public WebElement getSndNewPaswrdYopmail() {
		if (commonLib.isDisplayed(sndNewPaswrdYopmail)) {
			return sndNewPaswrdYopmail;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//a[@onclick = 'cancelUser();']")
	private WebElement btnCancelEditUser;

	public WebElement getBtnCancelEditUser() {
		if (commonLib.isDisplayed(btnCancelEditUser)) {
			return btnCancelEditUser;
		} else {
			return null;
		}
	}

	@FindBy(id = "AEU_EntityType")
	private WebElement drpdwnEntityTypeAddUser;

	public WebElement getDrpdwnEntityTypeAddUser() {
		if (commonLib.isDisplayed(drpdwnEntityTypeAddUser)) {
			return drpdwnEntityTypeAddUser;
		} else {
			return null;
		}
	}

	@FindBy(id = "attachContactTypeAdduser")
	private WebElement drpdwnAddedKeyCntctRole;

	@FindBy(id = "availableContactTypeAdduser")
	private WebElement drpdwnKeyCntctRole;

	@FindBy(id = "addkey")
	private WebElement btnFrwrdArrow;

	public WebElement getDrpdwnAddedKeyCntctRole() {
		if (commonLib.isDisplayed(drpdwnAddedKeyCntctRole)) {
			return drpdwnAddedKeyCntctRole;
		} else {
			return null;
		}
	}

	public WebElement getDrpdwnKeyCntctRole() {
		if (commonLib.isDisplayed(drpdwnKeyCntctRole)) {
			return drpdwnKeyCntctRole;
		} else {
			return null;
		}
	}

	public WebElement getBtnFrwrdArrow() {
		if (commonLib.isDisplayed(btnFrwrdArrow)) {
			return btnFrwrdArrow;
		} else {
			return null;
		}
	}

	@FindBy(id = "UserMsg")
	private WebElement popupUserCnfrmationMsg;

	public WebElement getPopupUserCnfrmationMsg() {
		if (commonLib.isDisplayed(popupUserCnfrmationMsg)) {
			return popupUserCnfrmationMsg;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//span[@class = 'mgif irefresh b']")
	private WebElement btnRefreshYopmail;

	public WebElement getBtnRefreshYopmail() {
		if (commonLib.isDisplayed(btnRefreshYopmail)) {
			return btnRefreshYopmail;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@id='m1']/div/a/span[2]")
	private WebElement mailYopmailAddUser;

	public WebElement getMailYopmailAddUser() {
		if (commonLib.isDisplayed(mailYopmailAddUser)) {
			return mailYopmailAddUser;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@id='m1']//span[contains(text(),'Request for Resetting the Password')]")
	private WebElement mailLnkSendNewPasswrdYopmail;

	public WebElement getMailLnkSendNewPasswrdYopmail() {
		if (commonLib.isDisplayed(mailLnkSendNewPasswrdYopmail)) {
			return mailLnkSendNewPasswrdYopmail;
		} else {
			return null;
		}
	}

	@FindBy(id = "errordiv")
	private WebElement errorMsgSearchAdmin;

	public WebElement getErrorMsgSearchAdmin() {
		if (commonLib.isDisplayed(errorMsgSearchAdmin)) {
			return errorMsgSearchAdmin;
		} else {
			return null;
		}
	}

}
