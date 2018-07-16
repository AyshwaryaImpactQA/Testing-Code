package com.scripts.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class CandidatePortfolioPL {

	CommonUtills commonLib = new CommonUtills();

	// Personal info page
	@FindBy(xpath = ".//*[@id='menuid2']")
	private WebElement portfolioMenu;

	@FindBy(id = "rdcontacted1")
	private WebElement radioBtnDirectContact;

	@FindBy(css = "input[type=file]")
	private WebElement fileUpload;
	
	@FindBy(partialLinkText = "Add Video Links")
	private WebElement linkAddVideoLinks;

	@FindBy(css = "input[type=file][id=pathOfReferenceFile]")
	private WebElement fileUploadReference;

	public WebElement getFileUploadReference() {
		if (commonLib.isDisplayed(fileUploadReference)) {
			return fileUploadReference;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnDirectContact() {
		if (commonLib.isDisplayed(radioBtnDirectContact)) {
			return radioBtnDirectContact;
		} else {
			return null;
		}
	}

	public WebElement getFileUpload() {
		if (commonLib.isDisplayed(fileUpload)) {
			return fileUpload;
		} else {
			return null;
		}
	}

	public WebElement getLinkAddVideoLinks() {
		if (commonLib.isDisplayed(linkAddVideoLinks)) {
			return linkAddVideoLinks;
		} else {
			return null;
		}
	}

	@FindBy(id = "hrefPersonaInfo")
	private WebElement btnPersonalInfo;

	@FindBy(id = "salutation")
	private WebElement dropDownSalutation;

	@FindBy(xpath = "//input[@id = 'genderId' and @value='1']")
	private WebElement radioBtnGenderFemale;

	@FindBy(id = "divResultdivTxtCertTypeData0")
	private WebElement firstElementCertType;;

	public WebElement getFirstElementCertType() {
		if (commonLib.isDisplayed(firstElementCertType)) {
			return firstElementCertType;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//input[@id = 'genderId' and @value='2']")
	private WebElement radioBtnGenderMale;

	@FindBy(xpath = "//input[@id = 'genderId' and @value='3']")
	private WebElement radioBtnGenderDeclined;

	@FindBy(id = "firstName")
	private WebElement txtBoxFirstName;

	@FindBy(id = "lastName")
	private WebElement txtBoxLastName;

	@FindBy(id = "zipCode")
	private WebElement txtBoxZip;

	@FindBy(id = "stateId")
	private WebElement drpDownState;

	@FindBy(id = "cityId")
	private WebElement drpDownCity;

	@FindBy(id = "countryId")
	private WebElement drpDownCountry;

	@FindBy(id = "addressLine1")
	private WebElement txtBoxAddress;

	@FindBy(id = "phoneNumber1")
	private WebElement txtBoxPhone1;

	@FindAll(@FindBy(id = "raceId"))
	private List<WebElement> chkBoxesRace;

	@FindBy(id = "phoneNumber2")
	private WebElement txtBoxPhone2;

	@FindBy(id = "phoneNumber3")
	private WebElement txtBoxPhone3;

	@FindBy(xpath = "//button[contains(text(), 'Save & Continue')]")
	private WebElement btnSaveAndContinue;

	@FindBy(xpath = "//div[@class='subheading'][contains(text(),'Experiences')]")
	private WebElement subHeadingExperiences;

	public WebElement getSubHeadingExperiences() {
		if (commonLib.isDisplayed(subHeadingExperiences)) {
			return subHeadingExperiences;
		} else {
			return null;
		}
	}

	public List<WebElement> getChkBoxesRace() {
		if (commonLib.isDisplayed(chkBoxesRace)) {
			return chkBoxesRace;
		} else {
			return null;
		}
	}

	public WebElement getPortfolioMenu() {
		if (commonLib.isDisplayed(portfolioMenu)) {
			return portfolioMenu;
		} else {
			return null;
		}
	}

	public WebElement getBtnPersonalInfo() {
		if (commonLib.isDisplayed(btnPersonalInfo)) {
			return btnPersonalInfo;
		} else {
			return null;
		}
	}

	public WebElement getDropDownSalutation() {
		if (commonLib.isDisplayed(dropDownSalutation)) {
			return dropDownSalutation;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnGenderFemale() {
		if (commonLib.isDisplayed(radioBtnGenderFemale)) {
			return radioBtnGenderFemale;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnGenderMale() {
		if (commonLib.isDisplayed(radioBtnGenderMale)) {
			return radioBtnGenderMale;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnGenderDeclined() {
		if (commonLib.isDisplayed(radioBtnGenderDeclined)) {
			return radioBtnGenderDeclined;
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

	public WebElement getTxtBoxZip() {
		if (commonLib.isDisplayed(txtBoxZip)) {
			return txtBoxZip;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownState() {
		if (commonLib.isDisplayed(drpDownState)) {
			return drpDownState;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownCity() {
		if (commonLib.isDisplayed(drpDownCity)) {
			return drpDownCity;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownCountry() {
		if (commonLib.isDisplayed(drpDownCountry)) {
			return drpDownCountry;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxAddress() {
		if (commonLib.isDisplayed(txtBoxAddress)) {
			return txtBoxAddress;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxPhone1() {
		if (commonLib.isDisplayed(txtBoxPhone1)) {
			return txtBoxPhone1;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxPhone2() {
		if (commonLib.isDisplayed(txtBoxPhone2)) {
			return txtBoxPhone2;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxPhone3() {
		if (commonLib.isDisplayed(txtBoxPhone3)) {
			return txtBoxPhone3;
		} else {
			return null;
		}
	}

	public WebElement getBtnSaveAndContinue() {
		if (commonLib.isDisplayed(btnSaveAndContinue)) {
			return btnSaveAndContinue;
		} else {
			return null;
		}
	}

	// Academics page
	@FindBy(xpath = "//span[text()='Academics']")
	private WebElement linkAcademics;

	@FindBy(xpath = "//span[text()='Credentials']")
	private WebElement linkCredentials;

	@FindBy(xpath = "//a[text()='+ Add a School ']")
	private WebElement linkAddaSchool;

	@FindBy(xpath = "//input[@id='degreeName']")
	private WebElement boxDegree;

	@FindBy(xpath = "//input[@id='universityName']")
	private WebElement boxSchool;

	@FindBy(xpath = "//a[text()='My School is Not Listed']")
	private WebElement linkSchoolNotListed;

	@FindBy(xpath = "//a[text()='My Field is Not Listed']")
	private WebElement linkFieldNotListed;

	@FindBy(id = "fieldName")
	private WebElement txtBoxOtherField;
	
	@FindBy(id = "divResultdivTxtFieldofStudyData0")
	private WebElement firstOptionFieldOfStudy;

	@FindBy(id = "certificationTypeDiv")
	private WebElement accordionCertification;

	@FindBy(id = "electronicReferencesDiv")
	private WebElement accordionReferences;

	@FindBy(id = "videoLinksDiv")
	private WebElement accordionPortfolioVideo;

	@FindBy(id = "additionalDocumentDiv")
	private WebElement accordionAdditionalDocument;

	@FindBy(xpath = "//a[text()='+ Add Certification/Licensure']")
	private WebElement linkAddCertification;

	@FindBy(partialLinkText = "Add Employment")
	private WebElement linkAddEmployment;

	@FindBy(partialLinkText = "Add Involvement")
	private WebElement linkAddInvolvementt;

	@FindBy(xpath = "//strong[contains(text(),'If required, would you be willing to serve as  a substitute/part-time teacher?')]")
	private WebElement txtOpenToSubstitute;

	@FindBy(xpath = "//a[text()='+ Add Reference']")
	private WebElement linkAddReference;

	@FindBy(xpath = "//input[@id='degreeName']/following-sibling::div/div")
	private WebElement optionDegree;

	@FindBy(xpath =  "//*[@id='divMainForm']/div/button[1]")
	private WebElement linkSaveSectionCert;

	@FindBy(xpath = "//*[@id='divElectronicReferences']/div[7]/div/button[1]")
	private WebElement linkSaveSectionReference;

	@FindBy(xpath = "//input[@id='universityName']/following-sibling::div/div")
	private WebElement optionSchool;

	@FindBy(xpath = "//select[@id='attendedInYear']")
	private WebElement drpDownAttendinYear;

	@FindBy(xpath = "//select[@id='certificationStatusMaster']")
	private WebElement drpDownCertificationStatus;
	
	@FindBy(xpath = "//*[@id='tblGridCertifications']/tbody/tr/td[6]/a[1]")
	private WebElement EditCertificationStatus;

	public WebElement getEditCertificationStatus() {
		if (commonLib.isDisplayed(EditCertificationStatus)) {
			return EditCertificationStatus;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//select[@id='certificationtypeMaster']")
	private WebElement drpDownCertificationType;

	@FindBy(id = "salutation")
	private WebElement drpDownSalutation;

	@FindBy(xpath = "//input[@id='firstName']")
	private WebElement boxFirstName;

	@FindBy(xpath = "//input[@id='lastName']")
	private WebElement boxLastName;

	@FindBy(xpath = "//input[@id='contactnumber']")
	private WebElement boxContactNumber;
	
	@FindBy(id = "designation")
	private WebElement boxTitle;
	
	@FindBy(id = "organization")
	private WebElement boxOrganization;

	public WebElement getBoxTitle() {
		if (commonLib.isDisplayed(boxTitle)) {
			return boxTitle;
		} else {
			return null;
		}
	}

	public WebElement getBoxOrganization() {
		if (commonLib.isDisplayed(boxOrganization)) {
			return boxOrganization;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement boxEmail;

	@FindBy(xpath = "//select[@id='stateMaster']")
	private WebElement drpDownCertificationState;

	@FindBy(xpath = "//select[@id='yearReceived']")
	private WebElement drpDownYearReceived;

	@FindBy(xpath = "//input[@id='certType']")
	private WebElement boxCertificationName;

	@FindBy(xpath = "//select[@id='leftInYear']")
	private WebElement drpDownLeftinYear;

	@FindBy(xpath = "//select[@id='tfaAffiliate']")
	private WebElement drpDownTfaAffiliate;

	@FindBy(xpath = "//div[@class='subheading'][contains(text(),'Credentials')]")
	private WebElement subHeadingCredentials;

	public WebElement getSubHeadingCredentials() {
		if (commonLib.isDisplayed(subHeadingCredentials)) {
			return subHeadingCredentials;
		} else {
			return null;
		}
	}

	@FindBy(id = "nationalBoardCertYear")
	private WebElement drpDownNBCYear;

	@FindBy(xpath = "//select[@id='corpsYear']")
	private WebElement drpDownCorpsYear;

	@FindBy(xpath = "//select[@id='tfaRegion']")
	private WebElement drpDownTfaRegion;
	
	@FindBy(id = "referenceType")
	private WebElement drpDownReferenceType;

	public WebElement getDrpDownReferenceType() {
		if (commonLib.isDisplayed(drpDownReferenceType)) {
			return drpDownReferenceType;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//input[@id='gpaCumulative']")
	private WebElement boxCumulativeGPA;

	@FindBy(xpath = "//div[text()='Credentials']")
	private WebElement verifyCredentialsPage;

	@FindAll(@FindBy(xpath = "//a[text()='Delete']"))
	private List<WebElement> linkDelete;

	@FindBy(xpath = "//a[text()='Edit']")
	private WebElement linkEdit;

	@FindAll(@FindBy(xpath = "//table[@id='academicGrid']/tbody/tr/td[3]"))
	private List<WebElement> academicDegree;

	@FindAll(@FindBy(xpath = "//table[@id='tblGridCertifications']/tbody//tr/td[1]"))
	private List<WebElement> verifyCertificationDetails;

	@FindBy(xpath = "//div[@id='errordiv']")
	private WebElement divError;
	
	

	@FindBy(id = "tfaAffiliate")
	private WebElement drpDownTFA;

	@FindBy(id = "corpsYear")
	private WebElement drpDownCorpYear;

	@FindBy(id = "tfaRegion")
	private WebElement drpDownRegion;

	@FindBy(xpath = "//button[@onclick='return saveAndContinueCertifications()']")
	private WebElement btnSaveCreds;

	@FindBy(xpath = "//tr[1]//a[text()='Edit']")
	private WebElement linkEditAcademic;

	public WebElement getLinkAcademics() {
		if (commonLib.isDisplayed(linkAcademics)) {
			return linkAcademics;
		} else {
			return null;
		}
	}

	public WebElement getLinkCredentials() {
		if (commonLib.isDisplayed(linkCredentials)) {
			return linkCredentials;
		} else {
			return null;
		}
	}

	public WebElement getLinkAddaSchool() {
		if (commonLib.isDisplayed(linkAddaSchool)) {
			return linkAddaSchool;
		} else {
			return null;
		}
	}

	public WebElement getBoxDegree() {
		if (commonLib.isDisplayed(boxDegree)) {
			return boxDegree;
		} else {
			return null;
		}
	}

	public WebElement getBoxSchool() {
		if (commonLib.isDisplayed(boxSchool)) {
			return boxSchool;
		} else {
			return null;
		}
	}

	public WebElement getLinkSchoolNotListed() {
		if (commonLib.isDisplayed(linkSchoolNotListed)) {
			return linkSchoolNotListed;
		} else {
			return null;
		}
	}

	public WebElement getLinkFieldNotListed() {
		if (commonLib.isDisplayed(linkFieldNotListed)) {
			return linkFieldNotListed;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxOtherField() {
		if (commonLib.isDisplayed(txtBoxOtherField)) {
			return txtBoxOtherField;
		} else {
			return null;
		}
	}

	public WebElement getAccordionCertification() {
		if (commonLib.isDisplayed(accordionCertification)) {
			return accordionCertification;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownNBCYear() {
		if (commonLib.isDisplayed(drpDownNBCYear)) {
			return drpDownNBCYear;
		} else {
			return null;
		}
	}

	public WebElement getAccordionReferences() {
		if (commonLib.isDisplayed(accordionReferences)) {
			return accordionReferences;
		} else {
			return null;
		}
	}

	public WebElement getAccordionPortfolioVideo() {
		if (commonLib.isDisplayed(accordionPortfolioVideo)) {
			return accordionPortfolioVideo;
		} else {
			return null;
		}
	}

	public WebElement getAccordionAdditionalDocument() {
		if (commonLib.isDisplayed(accordionAdditionalDocument)) {
			return accordionAdditionalDocument;
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

	public WebElement getLinkAddEmployment() {
		if (commonLib.isDisplayed(linkAddEmployment)) {
			return linkAddEmployment;
		} else {
			return null;
		}
	}

	public WebElement getLinkAddInvolvementt() {
		if (commonLib.isDisplayed(linkAddInvolvementt)) {
			return linkAddInvolvementt;
		} else {
			return null;
		}
	}

	public WebElement getTxtOpenToSubstitute() {
		if (commonLib.isDisplayed(txtOpenToSubstitute)) {
			return txtOpenToSubstitute;
		} else {
			return null;
		}
	}

	public WebElement getLinkAddReference() {
		if (commonLib.isDisplayed(linkAddReference)) {
			return linkAddReference;
		} else {
			return null;
		}
	}

	public WebElement getOptionDegree() {
		if (commonLib.isDisplayed(optionDegree)) {
			return optionDegree;
		} else {
			return null;
		}
	}

	public WebElement getLinkSaveSectionCert() {
		if (commonLib.isDisplayed(linkSaveSectionCert)) {
			return linkSaveSectionCert;
		} else {
			return null;
		}
	}

	public WebElement getLinkSaveSectionReference() {
		if (commonLib.isDisplayed(linkSaveSectionReference)) {
			return linkSaveSectionReference;
		} else {
			return null;
		}
	}

	public WebElement getOptionSchool() {
		if (commonLib.isDisplayed(optionSchool)) {
			return optionSchool;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownAttendinYear() {
		if (commonLib.isDisplayed(drpDownAttendinYear)) {
			return drpDownAttendinYear;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownCertificationStatus() {
		if (commonLib.isDisplayed(drpDownCertificationStatus)) {
			return drpDownCertificationStatus;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownCertificationType() {
		if (commonLib.isDisplayed(drpDownCertificationType)) {
			return drpDownCertificationType;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownSalutation() {
		if (commonLib.isDisplayed(drpDownSalutation)) {
			return drpDownSalutation;
		} else {
			return null;
		}
	}

	public WebElement getBoxFirstName() {
		if (commonLib.isDisplayed(boxFirstName)) {
			return boxFirstName;
		} else {
			return null;
		}
	}

	public WebElement getBoxLastName() {
		if (commonLib.isDisplayed(boxLastName)) {
			return boxLastName;
		} else {
			return null;
		}
	}

	public WebElement getBoxContactNumber() {
		if (commonLib.isDisplayed(boxContactNumber)) {
			return boxContactNumber;
		} else {
			return null;
		}
	}

	public WebElement getBoxEmail() {
		if (commonLib.isDisplayed(boxEmail)) {
			return boxEmail;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownCertificationState() {
		if (commonLib.isDisplayed(drpDownCertificationState)) {
			return drpDownCertificationState;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownYearReceived() {
		if (commonLib.isDisplayed(drpDownYearReceived)) {
			return drpDownYearReceived;
		} else {
			return null;
		}
	}

	public WebElement getBoxCertificationName() {
		if (commonLib.isDisplayed(boxCertificationName)) {
			return boxCertificationName;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownLeftinYear() {
		if (commonLib.isDisplayed(drpDownLeftinYear)) {
			return drpDownLeftinYear;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownTfaAffiliate() {
		if (commonLib.isDisplayed(drpDownTfaAffiliate)) {
			return drpDownTfaAffiliate;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownCorpsYear() {
		if (commonLib.isDisplayed(drpDownCorpsYear)) {
			return drpDownCorpsYear;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownTfaRegion() {
		if (commonLib.isDisplayed(drpDownTfaRegion)) {
			return drpDownTfaRegion;
		} else {
			return null;
		}
	}

	public WebElement getBoxCumulativeGPA() {
		if (commonLib.isDisplayed(boxCumulativeGPA)) {
			return boxCumulativeGPA;
		} else {
			return null;
		}
	}

	public WebElement getVerifyCredentialsPage() {
		if (commonLib.isDisplayed(verifyCredentialsPage)) {
			return verifyCredentialsPage;
		} else {
			return null;
		}
	}

	public List<WebElement> getLinkDelete() {
		if (commonLib.isDisplayed(linkDelete)) {
			return linkDelete;
		} else {
			return null;
		}
	}

	public WebElement getLinkEdit() {
		if (commonLib.isDisplayed(linkEdit)) {
			return linkEdit;
		} else {
			return null;
		}
	}

	public List<WebElement> getAcademicDegree() {
		if (commonLib.isDisplayed(academicDegree)) {
			return academicDegree;
		} else {
			return null;
		}
	}

	public List<WebElement> getVerifyCertificationDetails() {
		if (commonLib.isDisplayed(verifyCertificationDetails)) {
			return verifyCertificationDetails;
		} else {
			return null;
		}
	}

	public WebElement getDivError() {
		if (commonLib.isDisplayed(divError)) {
			return divError;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownTFA() {
		if (commonLib.isDisplayed(drpDownTFA)) {
			return drpDownTFA;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownCorpYear() {
		if (commonLib.isDisplayed(drpDownCorpYear)) {
			return drpDownCorpYear;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownRegion() {
		if (commonLib.isDisplayed(drpDownRegion)) {
			return drpDownRegion;
		} else {
			return null;
		}
	}

	public WebElement getBtnSaveCreds() {
		if (commonLib.isDisplayed(btnSaveCreds)) {
			return btnSaveCreds;
		} else {
			return null;
		}
	}

	public WebElement getLinkEditAcademic() {
		if (commonLib.isDisplayed(linkEditAcademic)) {
			return linkEditAcademic;
		} else {
			return null;
		}
	}

	// Experiences page
	@FindBy(id = "hrefExperiences")
	private WebElement btnExperiences;

	@FindBy(id = "resumeDiv")
	private WebElement accordionResume;

	@FindBy(xpath = "//a[@onclick='return showEmploymentForm()']")
	private WebElement btnAddEmployment;

	@FindBy(id = "resume")
	private WebElement btnResume;

	@FindBy(id = "employmentDiv")
	private WebElement tabEmpHistory;

	@FindBy(id = "empPosition")
	private WebElement drpDownPosition;

	@FindBy(id = "role")
	private WebElement txtBoxRole;

	@FindBy(id = "fieldId")
	private WebElement drpDownField;

	@FindBy(id = "empOrg")
	private WebElement txtBoxOrg;

	@FindBy(id = "cityEmp")
	private WebElement txtBoxCity;

	@FindBy(id = "stateOfOrg")
	private WebElement txtBoxState;

	@FindBy(id = "roleStartMonth")
	private WebElement drpDownStartMonth;

	@FindBy(id = "roleStartYear")
	private WebElement drpDownStartYear;

	@FindBy(id = "roleEndMonth")
	private WebElement drpDownEndMonth;

	@FindBy(id = "roleEndYear")
	private WebElement drpDownEndYear;

	@FindBy(xpath = "//input[@name='empRoleTypeId'][@value='1']")
	private WebElement radioBtnGenMember;

	@FindBy(xpath =  ".//*[@id='frmEmployment']/div[12]/div/button[1]") 
	private WebElement btnSaveSchool;

	@FindBy(id = "divDataEmployment")
	private WebElement employmentTable;

	@FindBy(xpath = "//*[@id='reasonForLeadiv']/div[@class='jqte']/div[@class='jqte_editor']")
	private WebElement txtBoxReason;

	@FindBy(xpath = "//button[@onclick='saveAndContinueExperiences()']")
	private WebElement btnSaveExp;

	@FindBy(xpath = "//button[text()='Ok']")
	private WebElement btnOk;

	public WebElement getAccordionResume() {
		if (commonLib.isDisplayed(accordionResume)) {
			return accordionResume;
		} else {
			return null;
		}
	}

	public WebElement getBtnExperiences() {
		if (commonLib.isDisplayed(btnExperiences)) {
			return btnExperiences;
		} else {
			return null;
		}
	}

	public WebElement getBtnAddEmployment() {
		if (commonLib.isDisplayed(btnAddEmployment)) {
			return btnAddEmployment;
		} else {
			return null;
		}
	}

	public WebElement getBtnResume() {
		if (commonLib.isDisplayed(btnResume)) {
			return btnResume;
		} else {
			return null;
		}
	}

	public WebElement getTabEmpHistory() {
		if (commonLib.isDisplayed(tabEmpHistory)) {
			return tabEmpHistory;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownPosition() {
		if (commonLib.isDisplayed(drpDownPosition)) {
			return drpDownPosition;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxRole() {
		if (commonLib.isDisplayed(txtBoxRole)) {
			return txtBoxRole;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownField() {
		if (commonLib.isDisplayed(drpDownField)) {
			return drpDownField;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxOrg() {
		if (commonLib.isDisplayed(txtBoxOrg)) {
			return txtBoxOrg;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxCity() {
		if (commonLib.isDisplayed(txtBoxCity)) {
			return txtBoxCity;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxState() {
		if (commonLib.isDisplayed(txtBoxState)) {
			return txtBoxState;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownStartMonth() {
		if (commonLib.isDisplayed(drpDownStartMonth)) {
			return drpDownStartMonth;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownStartYear() {
		if (commonLib.isDisplayed(drpDownStartYear)) {
			return drpDownStartYear;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownEndMonth() {
		if (commonLib.isDisplayed(drpDownEndMonth)) {
			return drpDownEndMonth;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownEndYear() {
		if (commonLib.isDisplayed(drpDownEndYear)) {
			return drpDownEndYear;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnGenMember() {
		if (commonLib.isDisplayed(radioBtnGenMember)) {
			return radioBtnGenMember;
		} else {
			return null;
		}
	}

	public WebElement getBtnSaveSchool() {
		if (commonLib.isDisplayed(btnSaveSchool)) {
			return btnSaveSchool;
		} else {
			return null;
		}
	}

	public WebElement getEmploymentTable() {
		if (commonLib.isDisplayed(employmentTable)) {
			return employmentTable;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxReason() {
		if (commonLib.isDisplayed(txtBoxReason)) {
			return txtBoxReason;
		} else {
			return null;
		}
	}

	public WebElement getBtnSaveExp() {
		if (commonLib.isDisplayed(btnSaveExp)) {
			return btnSaveExp;
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

	// Affidavit page
	@FindBy(xpath = "//span[contains(text(), 'TeacherMatch.com Candidate Portal')]")
	private WebElement txtAffidavitHeading;

	@FindBy(id = "isDone1")
	private WebElement checkBoxAccept;

	@FindBy(xpath = "//*[@id='teacherAffidavit']/div[4]/div/div[3]/button")
	private WebElement btnComplete;

	@FindBy(id = "hrefAffidavit")
	private WebElement btnAffidavit;

	@FindBy(xpath = "//tr[td[text()='Portfolio ']]//strong")
	private WebElement statusPortfolio;

	public WebElement getTxtAffidavitHeading() {
		if (commonLib.isDisplayed(txtAffidavitHeading)) {
			return txtAffidavitHeading;
		} else {
			return null;
		}
	}

	public WebElement getCheckBoxAccept() {
		if (commonLib.isDisplayed(checkBoxAccept)) {
			return checkBoxAccept;
		} else {
			return null;
		}
	}

	public WebElement getBtnComplete() {
		if (commonLib.isDisplayed(btnComplete)) {
			return btnComplete;
		} else {
			return null;
		}
	}

	public WebElement getBtnAffidavit() {
		if (commonLib.isDisplayed(btnAffidavit)) {
			return btnAffidavit;
		} else {
			return null;
		}
	}

	public WebElement getStatusPortfolio() {
		if (commonLib.isDisplayed(statusPortfolio)) {
			return statusPortfolio;
		} else {
			return null;
		}
	}

	public WebElement getFirstOptionFieldOfStudy() {
		if (commonLib.isDisplayed(firstOptionFieldOfStudy)) {
			return firstOptionFieldOfStudy;
		} else {
			return null;
		}
	}

}
