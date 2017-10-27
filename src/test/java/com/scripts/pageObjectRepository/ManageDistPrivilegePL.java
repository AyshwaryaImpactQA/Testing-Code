package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.scripts.lib.commonFunction.CommonUtills;

public class ManageDistPrivilegePL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid3")
	private WebElement menuManage;

	@FindBy(id = "submenuid33")
	private WebElement subMenuDistrictTM;

	@FindBy(id = "submenuid31")
	private WebElement subMenuDistrictDA;

	@FindBy(id = "districtName")
	private WebElement txtBxDstrctName;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement firstOptionDistrict;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement btnSearch;

	@FindBy(xpath = "(//a[@title='Edit']/i)[1]")
	private WebElement btnEditDstrct;

	@FindBy(xpath = "//a[contains(@title,'tivate')]")
	private WebElement btnDeactivateDstrct;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnConfirmDeacitvate;

	@FindBy(xpath = "//td[text()='No Record found']")
	private WebElement messageNoRecordFound;

	@FindBy(xpath = "//div[text()='Edit District']")
	private WebElement headingEditDistrict;

	@FindBy(partialLinkText = "Privilege For District")
	private WebElement accordionPrivilegeForDistrict;

	@FindBy(id = "isTeacherPoolOnLoad1")
	private WebElement chkBoxShowCandidatesOnPageLoad;

	@FindBy(id = "isVisibleQQThumbOnCandidatePool")
	private WebElement chkBoxDisplayQQAInCandPool;

	@FindBy(xpath = "//button/strong[contains(text(),'Save District')]")
	private WebElement btnSaveDistrict;

	@FindBy(xpath = "//button[contains(text(),'Yes ')]")
	private WebElement btnYes;

	@FindBy(xpath = "//div[@id='myModalUpdateMsg']//button[contains(text(),'Close')]")
	private WebElement btnClose;

	@FindBy(xpath = "//div[@id='showApprovalGropus']/div[1]//input")
	private WebElement radioBtnDisplayLinkToAllDA;

	@FindBy(xpath = "//div[@id='showApprovalGropus']/div[2]//input")
	private WebElement radioBtnDisplayLinkToAllDASA;

	@FindBy(xpath = "//div[@id='showApprovalGropus']/div[3]//input")
	private WebElement radioBtnDisplayLinkToAllJobApproverDA;

	@FindBy(xpath = "//div[@id='showApprovalGropus']/div[4]//input")
	private WebElement radioBtnDisplayLinkToAllJobApproverDASA;

	@FindBy(partialLinkText = "Job Approval Details")
	private WebElement linkJobApprovalDetails;

	@FindBy(xpath = "//h3[contains(text(),'Job Approval Details')]")
	private WebElement headerJobApprovalDetails;

	@FindBy(xpath = "//div[h3[contains(text(),'Job Approval Details')]]//button")
	private WebElement iconCloseJobApprovalPopup;

	@FindBy(id = "isReqNoRequired1")
	private WebElement chkBoxReqNoIsRequiredForJobs;

	@FindBy(id = "eeocRequired")
	private WebElement chkBoxEEOCSupportNeeded;

	@FindBy(id = "autoNotifyCandidateOnAttachingWithJob1")
	private WebElement chkBoxAutoNotifyCandidatesOnAttachingJob;

	@FindBy(id = "tpJobApplied1")
	private WebElement iconAddCandidateToOtherJobs;

	@FindBy(id = "sendNotification")
	private WebElement chkBoxSendNotification;

	@FindBy(xpath = "//table[@id='jobTableLst']//tr[1]//input")
	private WebElement chkBoxOtherJobToCandidate;

	@FindBy(xpath = "//button[contains(text(),'Apply to Job(s)')]")
	private WebElement btnApplyToJob;

	@FindBy(id = "hidePrompt")
	private WebElement btnOkJobApplied;

	@FindBy(xpath = "//tr[2]/td")
	private WebElement attachJobMailContentMailinator;

	@FindBy(id = "isZoneRequired1")
	private WebElement chkBoxZoneRequired;

	@FindBy(id = "districtdefault")
	private WebElement radioBtnDistrictDefaultJobCategory;

	@FindBy(id = "postingStartTime")
	private WebElement drpDownPostingStartTime;

	@FindBy(id = "postingEndTime")
	private WebElement drpDownPostingEndTime;

	@FindBy(id = "qqAvlDistList")
	private WebElement drpDownSetQQToJobCategory;

	@FindBy(id = "displaySiteName")
	private WebElement chkBoxDisplaySchoolName;

	@FindBy(id = "displaySubmenuAsaParentMenu1")
	private WebElement chkBoxDisplaySubMenuAsParentMenu;

	@FindBy(id = "menuid6")
	private WebElement menuImport;

	@FindBy(id = "statusNotes1")
	private WebElement chkBoxNoteIsRequiredForStatuses;

	@FindBy(id = "beforeDpoint")
	private WebElement radioBtnSetDPointBeforeStatus;

	@FindBy(id = "afterDpoint")
	private WebElement radioBtnSetDPointAfterStatus;

	@FindBy(id = "isReqNoForHiring1")
	private WebElement chkBoxRequisitionNoIsRequiredForHiring;

	@FindBy(xpath = "//div[@id='dPointsSceStatus']/label[1]/input[@id='chkDStatusMaster']")
	private WebElement chkBoxScreeningComplete;

	@FindBy(xpath = "//div[@id='dPointsSceStatus']/label[2]/input[@id='chkDStatusMaster']")
	private WebElement chkBoxEvaluationComplete;

	@FindBy(xpath = "//div[@id='dPointsSceStatus']/label[3]/input[@id='chkDStatusMaster']")
	private WebElement chkBoxVettingComplete;

	@FindBy(id = "publicJobOrderEmailFlag")
	private WebElement chkBoxPublicJobOrderEmails;

	@FindBy(id = "hiddenJobOrderEmailFlag")
	private WebElement chkBoxHiddenJobOrderEmails;

	public WebElement getMenuManage() {
		if (commonLib.isDisplayed(menuManage)) {
			return menuManage;
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

	public WebElement getSubMenuDistrictDA() {
		if (commonLib.isDisplayed(subMenuDistrictDA)) {
			return subMenuDistrictDA;
		} else {
			return null;
		}
	}

	public WebElement getTxtBxDstrctName() {
		if (commonLib.isDisplayed(txtBxDstrctName)) {
			return txtBxDstrctName;
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

	public WebElement getBtnSearch() {
		if (commonLib.isDisplayed(btnSearch)) {
			return btnSearch;
		} else {
			return null;
		}
	}

	public WebElement getBtnEditDstrct() {
		if (commonLib.isDisplayed(btnEditDstrct)) {
			return btnEditDstrct;
		} else {
			return null;
		}
	}

	public WebElement getBtnDeactivateDstrct() {
		if (commonLib.isDisplayed(btnDeactivateDstrct)) {
			return btnDeactivateDstrct;
		} else {
			return null;
		}
	}

	public WebElement getMessageNoRecordFound() {
		if (commonLib.isDisplayed(messageNoRecordFound)) {
			return messageNoRecordFound;
		} else {
			return null;
		}
	}

	public WebElement getBtnConfirmDeacitvate() {
		if (commonLib.isDisplayed(btnConfirmDeacitvate)) {
			return btnConfirmDeacitvate;
		} else {
			return null;
		}
	}

	public WebElement getHeadingEditDistrict() {
		if (commonLib.isDisplayed(headingEditDistrict)) {
			return headingEditDistrict;
		} else {
			return null;
		}
	}

	public WebElement getAccordionPrivilegeForDistrict() {
		if (commonLib.isDisplayed(accordionPrivilegeForDistrict)) {
			return accordionPrivilegeForDistrict;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxShowCandidatesOnPageLoad() {
		if (commonLib.isDisplayed(chkBoxShowCandidatesOnPageLoad)) {
			return chkBoxShowCandidatesOnPageLoad;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxDisplayQQAInCandPool() {
		if (commonLib.isDisplayed(chkBoxDisplayQQAInCandPool)) {
			return chkBoxDisplayQQAInCandPool;
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

	public WebElement getBtnYes() {
		if (commonLib.isDisplayed(btnYes)) {
			return btnYes;
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

	public WebElement getRadioBtnDisplayLinkToAllDA() {
		if (commonLib.isDisplayed(radioBtnDisplayLinkToAllDA)) {
			return radioBtnDisplayLinkToAllDA;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnDisplayLinkToAllDASA() {
		if (commonLib.isDisplayed(radioBtnDisplayLinkToAllDASA)) {
			return radioBtnDisplayLinkToAllDASA;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnDisplayLinkToAllJobApproverDA() {
		if (commonLib.isDisplayed(radioBtnDisplayLinkToAllJobApproverDA)) {
			return radioBtnDisplayLinkToAllJobApproverDA;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnDisplayLinkToAllJobApproverDASA() {
		if (commonLib.isDisplayed(radioBtnDisplayLinkToAllJobApproverDASA)) {
			return radioBtnDisplayLinkToAllJobApproverDASA;
		} else {
			return null;
		}
	}

	public WebElement getLinkJobApprovalDetails() {
		if (commonLib.isDisplayed(linkJobApprovalDetails)) {
			return linkJobApprovalDetails;
		} else {
			return null;
		}
	}

	public WebElement getHeaderJobApprovalDetails() {
		if (commonLib.isDisplayed(headerJobApprovalDetails)) {
			return headerJobApprovalDetails;
		} else {
			return null;
		}
	}

	public WebElement getIconCloseJobApprovalPopup() {
		if (commonLib.isDisplayed(iconCloseJobApprovalPopup)) {
			return iconCloseJobApprovalPopup;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxReqNoIsRequiredForJobs() {
		if (commonLib.isDisplayed(chkBoxReqNoIsRequiredForJobs)) {
			return chkBoxReqNoIsRequiredForJobs;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxEEOCSupportNeeded() {
		if (commonLib.isDisplayed(chkBoxEEOCSupportNeeded)) {
			return chkBoxEEOCSupportNeeded;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxAutoNotifyCandidatesOnAttachingJob() {
		if (commonLib.isDisplayed(chkBoxAutoNotifyCandidatesOnAttachingJob)) {
			return chkBoxAutoNotifyCandidatesOnAttachingJob;
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

	public WebElement getChkBoxSendNotification() {
		if (commonLib.isDisplayed(chkBoxSendNotification)) {
			return chkBoxSendNotification;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxOtherJobToCandidate() {
		if (commonLib.isDisplayed(chkBoxOtherJobToCandidate)) {
			return chkBoxOtherJobToCandidate;
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

	public WebElement getAttachJobMailContentMailinator() {
		if (commonLib.isDisplayed(attachJobMailContentMailinator)) {
			return attachJobMailContentMailinator;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxZoneRequired() {
		if (commonLib.isDisplayed(chkBoxZoneRequired)) {
			return chkBoxZoneRequired;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnDistrictDefaultJobCategory() {
		if (commonLib.isDisplayed(radioBtnDistrictDefaultJobCategory)) {
			return radioBtnDistrictDefaultJobCategory;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownPostingStartTime() {
		if (commonLib.isDisplayed(drpDownPostingStartTime)) {
			return drpDownPostingStartTime;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownPostingEndTime() {
		if (commonLib.isDisplayed(drpDownPostingEndTime)) {
			return drpDownPostingEndTime;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownSetQQToJobCategory() {
		if (commonLib.isDisplayed(drpDownSetQQToJobCategory)) {
			return drpDownSetQQToJobCategory;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxDisplaySchoolName() {
		if (commonLib.isDisplayed(chkBoxDisplaySchoolName)) {
			return chkBoxDisplaySchoolName;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxDisplaySubMenuAsParentMenu() {
		if (commonLib.isDisplayed(chkBoxDisplaySubMenuAsParentMenu)) {
			return chkBoxDisplaySubMenuAsParentMenu;
		} else {
			return null;
		}
	}

	public WebElement getMenuImport() {
		if (commonLib.isDisplayed(menuImport)) {
			return menuImport;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxNoteIsRequiredForStatuses() {
		if (commonLib.isDisplayed(chkBoxNoteIsRequiredForStatuses)) {
			return chkBoxNoteIsRequiredForStatuses;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnSetDPointBeforeStatus() {
		if (commonLib.isDisplayed(radioBtnSetDPointBeforeStatus)) {
			return radioBtnSetDPointBeforeStatus;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnSetDPointAfterStatus() {
		if (commonLib.isDisplayed(radioBtnSetDPointAfterStatus)) {
			return radioBtnSetDPointAfterStatus;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxRequisitionNoIsRequiredForHiring() {
		if (commonLib.isDisplayed(chkBoxRequisitionNoIsRequiredForHiring)) {
			return chkBoxRequisitionNoIsRequiredForHiring;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxScreeningComplete() {
		if (commonLib.isDisplayed(chkBoxScreeningComplete)) {
			return chkBoxScreeningComplete;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxEvaluationComplete() {
		if (commonLib.isDisplayed(chkBoxEvaluationComplete)) {
			return chkBoxEvaluationComplete;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxVettingComplete() {
		if (commonLib.isDisplayed(chkBoxVettingComplete)) {
			return chkBoxVettingComplete;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxPublicJobOrderEmails() {
		if (commonLib.isDisplayed(chkBoxPublicJobOrderEmails)) {
			return chkBoxPublicJobOrderEmails;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxHiddenJobOrderEmails() {
		if (commonLib.isDisplayed(chkBoxHiddenJobOrderEmails)) {
			return chkBoxHiddenJobOrderEmails;
		} else {
			return null;
		}
	}

}
