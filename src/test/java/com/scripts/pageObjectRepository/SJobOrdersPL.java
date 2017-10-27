package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class SJobOrdersPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid4")
	private WebElement btnMenuJobOrders;

	@FindBy(id = "submenuid41")
	private WebElement menuOptnDJO;

	@FindBy(id = "submenuid42")
	private WebElement menuOptnSJO;

	@FindBy(xpath = "//a[contains(@onclick, 'addnewJob')]")
	private WebElement btnAddNewJob;

	@FindBy(id = "districtORSchoolName")
	private WebElement txtBoxDistrict;

	@FindBy(id = "schoolName")
	private WebElement txtBoxSchoolDepartment;

	@FindBy(id = "divResultdivTxtShowData20")
	private WebElement firstOptionSchoolDepartment;

	@FindBy(xpath = "//input[@id='schoolName'][not(contains(@onblur,'lockGeozone(1)'))]")
	private WebElement txtBoxSchool;

	@FindBy(id = "zone")
	private WebElement drpDownZone;

	@FindBy(id = "jobTitle")
	private WebElement txtBoxJobTitle;

	@FindBy(id = "rdReqNoSource1")
	private WebElement radioBtnRequisitionNumber;

	@FindBy(id = "rdReqNoSourceSchool1")
	private WebElement radioBtnRequisitionNumberSchool;

	@FindBy(xpath = "//*[@id='tblGrid']/tbody/tr[1]/td[3]")
	private WebElement titleFirstRow;

	@FindBy(id = "newTextRequisitionNumbers")
	private WebElement txtBoxRequisitionNumber;

	@FindBy(id = "newTextRequisitionNumbersSchool")
	private WebElement txtBoxRequisitionNumberSchool;

	@FindBy(xpath = "//*[@id='addSchoolDiv']//a[text()='Save Section']")
	private WebElement linkSaveSection;

	@FindBy(id = "jobApprovalProcessId")
	private WebElement drpDownJobApprovalProcess;

	@FindBy(xpath = "//*[@id='tblGrid']//a[contains(text(),'Approval Request')]")
	private WebElement approvalRequest;

	@FindBy(xpath = "//div[@id='footerbtn1k']/button[text()='Approve']")
	private WebElement btnApprove;

	@FindBy(xpath = "//div[@id='myModal2']//button[contains(text(),'Ok')]")
	private WebElement btnOk;

	@FindBy(id = "allschooladministratorId")
	private WebElement chkBoxAllAdminOfAttachSchool;

	public WebElement getChkBoxAllAdminOfAttachSchool() {
		if (commonLib.isDisplayed(chkBoxAllAdminOfAttachSchool)) {
			return chkBoxAllAdminOfAttachSchool;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownJobApprovalProcess() {
		if (commonLib.isDisplayed(drpDownJobApprovalProcess)) {
			return drpDownJobApprovalProcess;
		} else {
			return null;
		}
	}

	public WebElement getTitleFirstRow() {
		if (commonLib.isDisplayed(titleFirstRow)) {
			return titleFirstRow;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnRequisitionNumber() {
		if (commonLib.isDisplayed(radioBtnRequisitionNumber)) {
			return radioBtnRequisitionNumber;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnRequisitionNumberSchool() {
		if (commonLib.isDisplayed(radioBtnRequisitionNumberSchool)) {
			return radioBtnRequisitionNumberSchool;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxRequisitionNumber() {
		if (commonLib.isDisplayed(txtBoxRequisitionNumber)) {
			return txtBoxRequisitionNumber;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxRequisitionNumberSchool() {
		if (commonLib.isDisplayed(txtBoxRequisitionNumberSchool)) {
			return txtBoxRequisitionNumberSchool;
		} else {
			return null;
		}
	}

	public WebElement getLinkSaveSection() {
		if (commonLib.isDisplayed(linkSaveSection)) {
			return linkSaveSection;
		} else {
			return null;
		}
	}

	@FindBy(id = "jobStartDate")
	private WebElement txtBoxPostingStartDate;

	@FindBy(xpath = "//div[contains(@class,'day-today')]")
	private WebElement currentDatePicker;

	@FindBy(id = "jobStartTime")
	private WebElement drpDownStartTime;

	@FindBy(id = "endDateRadio1")
	private WebElement radioBtnPostingEndDate;

	@FindBy(id = "jobEndDate")
	private WebElement txtBoxPostingEndDate;

	@FindBy(xpath = "//table[@class='DynarchCalendar-topCont'][2]//div[@dyc-btn='+Y']/div")
	private WebElement postEndDateBtnNextYr;

	@FindBy(xpath = "//table[@class='DynarchCalendar-topCont'][2]")
	private WebElement postCalender;

	@FindBy(xpath = "//*[@id='tblGrid']//td[2]")
	private WebElement jobTitle;

	@FindBy(id = "refno")
	private WebElement txtBoxRefNo;

	@FindBy(id = "status")
	private WebElement drpDownStatus;

	@FindBy(xpath = "//table[@id='tblGrid']//tr[1]//a[@title='Edit']")
	private WebElement iconEdit;

	@FindBy(xpath = "//table[@id='tblGrid']//tr[1]//a[@title='Clone']")
	private WebElement iconClone;

	@FindBy(xpath = "//table[@id='tblGrid']//tr[1]//a[@title='History']")
	private WebElement iconHistory;

	@FindBy(xpath = "//table[@id='tblGrid']//tr[1]//a[4]")
	private WebElement iconActivateDeactivate;
	
	@FindBy(xpath = "//table[@id='tblGrid']//tr[1]//a[text()='View']")
	private WebElement linkViewJob;

	public WebElement getJobTitle() {
		if (commonLib.isDisplayed(jobTitle)) {
			return jobTitle;
		} else {
			return null;
		}
	}

	/**
	 * @return the postCalender
	 */
	public WebElement getPostCalender() {
		if (commonLib.isDisplayed(postCalender)) {
			return postCalender;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//table[@class='DynarchCalendar-topCont'][2]//tr[contains(@class,'first-row')]//div[text()='1']")
	private WebElement postEndDateBtnNextDt;

	@FindBy(id = "endDateRadio2")
	private WebElement radioBtnUntilFilled;

	@FindBy(id = "jobEndTime")
	private WebElement drpDownEndTime;

	@FindBy(id = "jobType")
	private WebElement drpdownJobType;

	@FindBy(xpath = "//a[@onclick='addCertification();']")
	private WebElement linkAddCertification;

	@FindBy(id = "stateMaster")
	private WebElement drpDownStateCertification;

	@FindBy(id = "certType")
	private WebElement txtBoxCertificationName;

	@FindBy(xpath = "//a[@Onclick='validateAddCertification();']")
	private WebElement btnSaveCertification;

	@FindBy(id = "jobCategoryId")
	private WebElement drpDownJobCategory;

	@FindBy(xpath = "//div[contains(text(),'You have successfully created a job order.')]")
	private WebElement btnOkDuplicateRequisition;

	@FindBy(xpath = "//div[@id='jobOrderSend']//button[text()='Ok ']")
	private WebElement btnOkConfrmJobOrder;

	@FindBy(xpath = "//div[@id='jDescription']/div/div[@class='jqte_editor']")
	private WebElement txtBoxDescription;

	/**
	 * @return the btnOkConfrmJobOrder
	 */
	public WebElement getBtnOkConfrmJobOrder() {
		if (commonLib.isDisplayed(btnOkConfrmJobOrder)) {
			return btnOkConfrmJobOrder;
		} else {
			return null;
		}
	}

	/**
	 * @return the btnOkDuplicateRequisition
	 */
	public WebElement getBtnOkDuplicateRequisition() {
		if (commonLib.isDisplayed(btnOkDuplicateRequisition)) {
			return btnOkDuplicateRequisition;
		} else {
			return null;
		}
	}

	@FindBy(id = "jobDescriptionDoc")
	private WebElement uplaodDesscription;

	@FindBy(xpath = "//div[@id='jQualification']/div/div[@class='jqte_editor']")
	private WebElement txtBoxSpecialComments;

	@FindBy(id = "subjectId")
	private WebElement drpDownSubject;

	@FindBy(id = "noOfExpHiresSchool")
	private WebElement txtBoxNoOfHires;

	@FindBy(id = "isExpHireNotEqualToReqNo")
	private WebElement chkBoxMultipleHireSingleReqNo;

	@FindBy(id = "districtadministratorId")
	private WebElement chkBoxDistrictAdmin;

	@FindBy(id = "noOfExpHires")
	private WebElement txtBoxNoOfHiresDistrict;

	@FindBy(id = "noOfSchoolExpHires")
	private WebElement txtBoxNoOfHiresSchool;

	@FindBy(xpath = ".//*[@id='tblGrid']//tr[1]/td[1]")
	private WebElement tblJobID;

	@FindBy(id = "isJobAssessment1")
	private WebElement radioBtnNoJSI;

	@FindBy(id = "attachJobAssessment3")
	private WebElement radioBtnAttachJSI;

	@FindBy(id = "isJobAssessment2")
	private WebElement radioBtnJSINedded;

	@FindBy(id = "attachJobAssessment4")
	private WebElement radioBtnDefaultJSI;

	@FindBy(id = "writePrivilegeToSchool")
	private WebElement chkBoxAssociatedSchools;

	@FindBy(id = "isInviteOnly")
	private WebElement chkBoxHiddenJob;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement rsltDrpDnDistrict;

	@FindBy(xpath = "//div[contains(@onmouseover,'schoolName')]/div[@class='over']")
	private WebElement rsltDrpDwnSchool;

	@FindBy(css = "input[type=file][id=assessmentDocument]")
	private WebElement fileUploadAttachJSI;

	public WebElement getFileUploadAttachJSI() {
		if (commonLib.isDisplayed(fileUploadAttachJSI)) {
			return fileUploadAttachJSI;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnAttachJSI() {
		if (commonLib.isDisplayed(radioBtnAttachJSI)) {
			return radioBtnAttachJSI;
		} else {
			return null;
		}
	}

	public WebElement getTblJobID() {
		if (commonLib.isDisplayed(tblJobID)) {
			return tblJobID;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//label/input[@id='allSchoolGradeDistrict']")
	private WebElement radioBtnOnlyDistrictAdmins;

	@FindBy(xpath = ".//*[@id='allSchoolGradeDistrict'][@value='2']")
	private WebElement radioBtnAdminFromSelectedSchool;
	
	@FindBy(xpath = "//*[@id='EPIMessage']/div/div/div[3]/button")
	private WebElement EPIOkButton;

	public WebElement getEPIOkButton() {
		if (commonLib.isDisplayed(EPIOkButton)) {
			return EPIOkButton;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnOnlyDistrictAdmins() {
		if (commonLib.isDisplayed(radioBtnOnlyDistrictAdmins)) {
			return radioBtnOnlyDistrictAdmins;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnAdminFromSelectedSchool() {
		if (commonLib.isDisplayed(radioBtnAdminFromSelectedSchool)) {
			return radioBtnAdminFromSelectedSchool;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxMultipleHireSingleReqNo() {
		if (commonLib.isDisplayed(chkBoxMultipleHireSingleReqNo)) {
			return chkBoxMultipleHireSingleReqNo;
		} else {
			return null;
		}
	}

	public WebElement getRsltDrpDwnSchool() {
		if (commonLib.isDisplayed(rsltDrpDwnSchool)) {
			return rsltDrpDwnSchool;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxNoOfHiresDistrict() {
		if (commonLib.isDisplayed(txtBoxNoOfHiresDistrict)) {
			return txtBoxNoOfHiresDistrict;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxNoOfHiresSchool() {
		if (commonLib.isDisplayed(txtBoxNoOfHiresSchool)) {
			return txtBoxNoOfHiresSchool;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxDistrictAdmin() {
		if (commonLib.isDisplayed(chkBoxDistrictAdmin)) {
			return chkBoxDistrictAdmin;
		} else {
			return null;
		}
	}

	public WebElement getRsltDrpDnDistrict() {
		if (commonLib.isDisplayed(rsltDrpDnDistrict)) {
			return rsltDrpDnDistrict;
		} else {
			return null;
		}
	}

	@FindBy(id = "hiddenJob2")
	private WebElement radioBtnHidJobUrl;

	@FindBy(css = "input[type=file][id=jobDescriptionDoc]")
	private WebElement browseInputFile;

	@FindBy(id = "hiddenJob1")
	private WebElement radioBtnHidJobInviteOnly;

	@FindBy(xpath = "//*[@id='jDescription']//div[@class='jqte_editor']")
	private WebElement jobDescription;

	@FindBy(xpath = "//*[@id='hideSave']/button")
	private WebElement saveJobOrder;
	
	@FindBy(xpath = "//*[@id='hideSave']/a")
	private WebElement linkCancel;

	@FindBy(id = "exitURL")
	private WebElement reDirectUrl;

	@FindBy(xpath = "//*[@id='jobOrderText']/div[text()='You have successfully created a job order.']")
	private WebElement successJobNotification;

	@FindBy(xpath = "//*[@id='jobOrderUrl']/a")
	private WebElement jobOrderUrl;

	@FindBy(xpath = "//button[contains(text(),'Ok')][@onclick='actionForward();']")
	private WebElement btnOKSuccessNotification;

	@FindBy(id = "offerJSIRadioOptional")
	private WebElement radBtnJSIOptional;

	@FindBy(partialLinkText = "Add School")
	private WebElement linkAddSchool;

	@FindBy(xpath = "//div/input[@id='allSchoolGradeDistrict']")
	private WebElement radBtnAdministratorsFromSelectedSchool;

	@FindBy(xpath = "//div[@id='textDSChangeMessageModal2']//button[text()='Ok ']")
	private WebElement btnOkChangeMessageModal;

	@FindBy(xpath = "//div[@id='textDSChangeMessageModal']//button[text()='Ok ']")
	private WebElement btnOkChangeMessageModalToSelectedSchool;

	@FindBy(xpath = "//h3[text()='Job Order History']")
	private WebElement headerJobHistoryPopup;

	@FindBy(xpath = "//div[@id='jobOrderHistoryModalId']//button[text()='Close']")
	private WebElement btnCloseHistoryPopup;

	public WebElement getBtnOkChangeMessageModal() {
		if (commonLib.isDisplayed(btnOkChangeMessageModal)) {
			return btnOkChangeMessageModal;
		} else {
			return null;
		}
	}

	public WebElement getBtnOkChangeMessageModalToSelectedSchool() {
		if (commonLib.isDisplayed(btnOkChangeMessageModalToSelectedSchool)) {
			return btnOkChangeMessageModalToSelectedSchool;
		} else {
			return null;
		}
	}

	public WebElement getRadBtnAdministratorsFromSelectedSchool() {
		if (commonLib.isDisplayed(radBtnAdministratorsFromSelectedSchool)) {
			return radBtnAdministratorsFromSelectedSchool;
		} else {
			return null;
		}
	}

	public WebElement getLinkAddSchool() {
		if (commonLib.isDisplayed(linkAddSchool)) {
			return linkAddSchool;
		} else {
			return null;
		}
	}

	public WebElement getRadBtnJSIOptional() {
		if (commonLib.isDisplayed(radBtnJSIOptional)) {
			return radBtnJSIOptional;
		} else {
			return null;
		}
	}

	public WebElement getBtnOKSuccessNotification() {
		if (commonLib.isDisplayed(btnOKSuccessNotification)) {
			return btnOKSuccessNotification;
		} else {
			return null;
		}
	}

	public void setBtnOKSuccessNotification(WebElement btnOKSuccessNotification) {
		this.btnOKSuccessNotification = btnOKSuccessNotification;
	}

	@FindBy(id = "errordiv")
	private WebElement validationError;

	@FindBy(id = "jobOrderId")
	private WebElement txtBxJobOrderId;

	@FindBy(id = "//*[@id='tblGrid']//td[2]")
	private WebElement txtTitle;

	@FindBy(xpath = "//*[@id='exlId']/span")
	private WebElement expExcel;

	@FindBy(xpath = "//*[@id='pdfId']/span")
	private WebElement expPDF;

	@FindBy(xpath = "//div[@id='modalDownloadJobOrder']//button[text()='Close']")
	private WebElement btnClosePDFForm;

	@FindBy(id = "download")
	private WebElement btnPDFDwnld;

	public WebElement getBtnPDFDwnld() {
		if (commonLib.isDisplayed(btnPDFDwnld)) {
			return btnPDFDwnld;
		} else {
			return null;
		}
	}

	public WebElement getBtnClosePDFForm() {
		if (commonLib.isDisplayed(btnClosePDFForm)) {
			return btnClosePDFForm;
		} else {
			return null;
		}
	}

	public WebElement getExpPDF() {
		if (commonLib.isDisplayed(expPDF)) {
			return expPDF;
		} else {
			return null;
		}
	}

	public WebElement getTxtTitle() {
		if (commonLib.isDisplayed(txtTitle)) {
			return txtTitle;
		} else {
			return null;
		}
	}

	public WebElement getExpExcel() {
		if (commonLib.isDisplayed(expExcel)) {
			return expExcel;
		} else {
			return null;
		}
	}

	public WebElement getTxtBxJobOrderId() {
		if (commonLib.isDisplayed(txtBxJobOrderId)) {
			return txtBxJobOrderId;
		} else {
			return null;
		}
	}

	@FindBy(id = "jeffcoButtonSearchHide")
	private WebElement btnSearchJobOrder;

	@FindBy(id = "searchTerm")
	private WebElement keywordSearch;

	@FindBy(id = "cgn1")
	private WebElement iconCandiateGrid;

	@FindBy(xpath = "//td[text()='No Record found']")
	private WebElement messageNoRecordFound;

	public WebElement getBtnSearchJobOrder() {
		if (commonLib.isDisplayed(btnSearchJobOrder)) {
			return btnSearchJobOrder;
		} else {
			return null;
		}
	}

	public WebElement getKeywordSearch() {
		if (commonLib.isDisplayed(keywordSearch)) {
			return keywordSearch;
		} else {
			return null;
		}
	}

	public WebElement getIconCandiateGrid() {
		if (commonLib.isDisplayed(iconCandiateGrid)) {
			return iconCandiateGrid;
		} else {
			return null;
		}
	}

	public WebElement getJobOrderUrl() {
		if (commonLib.isDisplayed(jobOrderUrl)) {
			return jobOrderUrl;
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

	public WebElement getBtnApprove() {
		if (commonLib.isDisplayed(btnApprove)) {
			return btnApprove;
		} else {
			return null;
		}
	}

	public WebElement getBtnOk() {
		if (commonLib.isDisplayed(btnOk)) {
			return btnOk;
		} else {
			return null;
		}
	}

	public WebElement getApprovalRequest() {
		if (commonLib.isDisplayed(approvalRequest)) {
			return approvalRequest;
		} else {
			return null;
		}
	}

	public WebElement getValidationError() {
		if (commonLib.isDisplayed(validationError)) {
			return validationError;
		} else {
			return null;
		}
	}

	public WebElement getSuccessJobNotification() {
		if (commonLib.isDisplayed(successJobNotification)) {
			return successJobNotification;
		} else {
			return null;
		}
	}

	public WebElement getReDirectUrl() {
		if (commonLib.isDisplayed(reDirectUrl)) {
			return reDirectUrl;
		} else {
			return null;
		}
	}

	public WebElement getSaveJobOrder() {
		if (commonLib.isDisplayed(saveJobOrder)) {
			return saveJobOrder;
		} else {
			return null;
		}
	}

	public WebElement getJobDescription() {
		if (commonLib.isDisplayed(jobDescription)) {
			return jobDescription;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnHidJobInviteOnly() {
		if (commonLib.isDisplayed(radioBtnHidJobInviteOnly)) {
			return radioBtnHidJobInviteOnly;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnHidJobUrl() {
		if (commonLib.isDisplayed(radioBtnHidJobUrl)) {
			return radioBtnHidJobUrl;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxHiddenJob() {
		if (commonLib.isDisplayed(chkBoxHiddenJob)) {
			return chkBoxHiddenJob;
		} else {
			return null;
		}
	}

	public WebElement getBrowseInputFile() {
		if (commonLib.isDisplayed(browseInputFile)) {
			return browseInputFile;
		} else {
			return null;
		}
	}

	public WebElement getBtnMenuJobOrders() {
		if (commonLib.isDisplayed(btnMenuJobOrders)) {
			return btnMenuJobOrders;
		} else {
			return null;
		}
	}

	public WebElement getMenuOptnDJO() {
		if (commonLib.isDisplayed(menuOptnDJO)) {
			return menuOptnDJO;
		} else {
			return null;
		}
	}

	public WebElement getMenuOptnSJO() {
		if (commonLib.isDisplayed(menuOptnSJO)) {
			return menuOptnSJO;
		} else {
			return null;
		}
	}

	public WebElement getBtnAddNewJob() {
		if (commonLib.isDisplayed(btnAddNewJob)) {
			return btnAddNewJob;
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

	public WebElement getTxtBoxSchoolDepartment() {
		if (commonLib.isDisplayed(txtBoxSchoolDepartment)) {
			return txtBoxSchoolDepartment;
		} else {
			return null;
		}
	}

	public WebElement getFirstOptionSchoolDepartment() {
		if (commonLib.isDisplayed(firstOptionSchoolDepartment)) {
			return firstOptionSchoolDepartment;
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

	public WebElement getDrpDownZone() {
		if (commonLib.isDisplayed(drpDownZone)) {
			return drpDownZone;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxJobTitle() {
		if (commonLib.isDisplayed(txtBoxJobTitle)) {
			return txtBoxJobTitle;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxPostingStartDate() {
		if (commonLib.isDisplayed(txtBoxPostingStartDate)) {
			return txtBoxPostingStartDate;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownStartTime() {
		if (commonLib.isDisplayed(drpDownStartTime)) {
			return drpDownStartTime;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnPostingEndDate() {
		if (commonLib.isDisplayed(radioBtnPostingEndDate)) {
			return radioBtnPostingEndDate;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxPostingEndDate() {
		if (commonLib.isDisplayed(txtBoxPostingEndDate)) {
			return txtBoxPostingEndDate;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnUntilFilled() {
		if (commonLib.isDisplayed(radioBtnUntilFilled)) {
			return radioBtnUntilFilled;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownEndTime() {
		if (commonLib.isDisplayed(drpDownEndTime)) {
			return drpDownEndTime;
		} else {
			return null;
		}
	}

	public WebElement getDrpdownJobType() {
		if (commonLib.isDisplayed(drpdownJobType)) {
			return drpdownJobType;
		} else {
			return null;
		}
	}

	public WebElement getLinkAddCertification() {
		if (commonLib.isDisplayed(linkAddCertification)) {
			return linkAddCertification;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownStateCertification() {
		if (commonLib.isDisplayed(drpDownStateCertification)) {
			return drpDownStateCertification;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxCertificationName() {
		if (commonLib.isDisplayed(txtBoxCertificationName)) {
			return txtBoxCertificationName;
		} else {
			return null;
		}
	}

	public WebElement getBtnSaveCertification() {
		if (commonLib.isDisplayed(btnSaveCertification)) {
			return btnSaveCertification;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownJobCategory() {
		if (commonLib.isDisplayed(drpDownJobCategory)) {
			return drpDownJobCategory;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxDescription() {
		if (commonLib.isDisplayed(txtBoxDescription)) {
			return txtBoxDescription;
		} else {
			return null;
		}
	}

	public WebElement getUplaodDesscription() {
		if (commonLib.isDisplayed(uplaodDesscription)) {
			return uplaodDesscription;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxSpecialComments() {
		if (commonLib.isDisplayed(txtBoxSpecialComments)) {
			return txtBoxSpecialComments;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownSubject() {
		if (commonLib.isDisplayed(drpDownSubject)) {
			return drpDownSubject;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxNoOfHires() {
		if (commonLib.isDisplayed(txtBoxNoOfHires)) {
			return txtBoxNoOfHires;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnNoJSI() {
		if (commonLib.isDisplayed(radioBtnNoJSI)) {
			return radioBtnNoJSI;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnJSINedded() {
		if (commonLib.isDisplayed(radioBtnJSINedded)) {
			return radioBtnJSINedded;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnDefaultJSI() {
		if (commonLib.isDisplayed(radioBtnDefaultJSI)) {
			return radioBtnDefaultJSI;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxAssociatedSchools() {
		if (commonLib.isDisplayed(chkBoxAssociatedSchools)) {
			return chkBoxAssociatedSchools;
		} else {
			return null;
		}
	}

	public WebElement getCurrentDatePicker() {
		if (commonLib.isDisplayed(currentDatePicker)) {
			return currentDatePicker;
		} else {
			return null;
		}
	}

	public WebElement getPostEndDateBtnNextDt() {
		if (commonLib.isDisplayed(postEndDateBtnNextDt)) {
			return postEndDateBtnNextDt;
		} else {
			return null;
		}
	}

	public WebElement getPostEndDateBtnNextYr() {
		if (commonLib.isDisplayed(postEndDateBtnNextYr)) {
			return postEndDateBtnNextYr;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxRefNo() {
		if (commonLib.isDisplayed(txtBoxRefNo)) {
			return txtBoxRefNo;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownStatus() {
		if (commonLib.isDisplayed(drpDownStatus)) {
			return drpDownStatus;
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

	public WebElement getIconClone() {
		if (commonLib.isDisplayed(iconClone)) {
			return iconClone;
		} else {
			return null;
		}
	}

	public WebElement getIconHistory() {
		if (commonLib.isDisplayed(iconHistory)) {
			return iconHistory;
		} else {
			return null;
		}
	}

	public WebElement getIconActivateDeactivate() {
		if (commonLib.isDisplayed(iconActivateDeactivate)) {
			return iconActivateDeactivate;
		} else {
			return null;
		}
	}

	public WebElement getHeaderJobHistoryPopup() {
		if (commonLib.isDisplayed(headerJobHistoryPopup)) {
			return headerJobHistoryPopup;
		} else {
			return null;
		}
	}

	public WebElement getBtnCloseHistoryPopup() {
		if (commonLib.isDisplayed(btnCloseHistoryPopup)) {
			return btnCloseHistoryPopup;
		} else {
			return null;
		}
	}

	public WebElement getLinkViewJob() {
		if (commonLib.isDisplayed(linkViewJob)) {
			return linkViewJob;
		} else {
			return null;
		}
	}

	public WebElement getLinkCancel() {
		if (commonLib.isDisplayed(linkCancel)) {
			return linkCancel;
		} else {
			return null;
		}
	}

}