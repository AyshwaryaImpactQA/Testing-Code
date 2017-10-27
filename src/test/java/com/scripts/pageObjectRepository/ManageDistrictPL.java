package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ManageDistrictPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(partialLinkText = "Messages and Notes")
	private WebElement accordionMessagesAndNotes;

	@FindBy(partialLinkText = "Account Information")
	private WebElement accordionAccountInformation;

	@FindBy(partialLinkText = "Privilege For School")
	private WebElement accordionPrivilegeForSchool;

	@FindBy(partialLinkText = "Privilege For Candidate")
	private WebElement accordionPrivilegeForCandidate;

	@FindBy(id = "communicationsAccess1")
	private WebElement radioBtnSchoolOnlyMessage;

	@FindBy(id = "communicationsAccess2")
	private WebElement radioBtnOtherSchoolMessage;

	@FindBy(id = "communicationsAccess3")
	private WebElement radioBtnDistrictMessage;

	@FindBy(id = "sACreateDistJOb")
	private WebElement chkBoxSACreateDistrictJob;

	@FindBy(id = "sAEditUpdateJob")
	private WebElement chkBoxSAEditJob;

	@FindBy(linkText = "http://bit.ly/1VXPPrd")
	private WebElement linkJobBoardURL;

	@FindBy(id = "includeState")
	private WebElement chkBoxIncludeState;

	@FindBy(id = "includeZipCode")
	private WebElement chkBoxIncludeZipCode;

	@FindBy(id = "includeZone")
	private WebElement chkBoxIncludeZone;

	@FindBy(id = "zipCode")
	private WebElement txtBoxZipCode;

	@FindBy(id = "stateId")
	private WebElement DrpDownState;

	@FindBy(id = "zone")
	private WebElement DrpDownZone;

	@FindBy(id = "checkAllCandidate")
	private WebElement chkBoxAllCandidates;

	@FindBy(xpath = "//span[contains(@class,'icon-collapse')]")
	private WebElement drpDownActions;

	@FindBy(linkText = "Not External")
	private WebElement linkNotExternal;

	@FindBy(xpath = "//div[@id='internalDiv']//button[text()='OK']")
	private WebElement btnOkConfirmInternalCandidate;
	
	@FindBy(id = "offerPortfolioNeeded2")
	private WebElement chkBoxOfferPortfolio;
	
	@FindBy(id = "offerQualificationItems2")
	private WebElement chkBoxOfferQQ;
	
	@FindBy(id = "offerEPI2")
	private WebElement chkBoxOfferEPI;

	public WebElement getAccordionMessagesAndNotes() {
		if (commonLib.isDisplayed(accordionMessagesAndNotes)) {
			return accordionMessagesAndNotes;
		} else {
			return null;
		}
	}

	public WebElement getAccordionAccountInformation() {
		if (commonLib.isDisplayed(accordionAccountInformation)) {
			return accordionAccountInformation;
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

	public WebElement getAccordionPrivilegeForCandidate() {
		if (commonLib.isDisplayed(accordionPrivilegeForCandidate)) {
			return accordionPrivilegeForCandidate;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnSchoolOnlyMessage() {
		if (commonLib.isDisplayed(radioBtnSchoolOnlyMessage)) {
			return radioBtnSchoolOnlyMessage;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnOtherSchoolMessage() {
		if (commonLib.isDisplayed(radioBtnOtherSchoolMessage)) {
			return radioBtnOtherSchoolMessage;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnDistrictMessage() {
		if (commonLib.isDisplayed(radioBtnDistrictMessage)) {
			return radioBtnDistrictMessage;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxSACreateDistrictJob() {
		if (commonLib.isDisplayed(chkBoxSACreateDistrictJob)) {
			return chkBoxSACreateDistrictJob;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxSAEditJob() {
		if (commonLib.isDisplayed(chkBoxSAEditJob)) {
			return chkBoxSAEditJob;
		} else {
			return null;
		}
	}

	public WebElement getLinkJobBoardURL() {
		if (commonLib.isDisplayed(linkJobBoardURL)) {
			return linkJobBoardURL;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxIncludeState() {
		if (commonLib.isDisplayed(chkBoxIncludeState)) {
			return chkBoxIncludeState;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxIncludeZipCode() {
		if (commonLib.isDisplayed(chkBoxIncludeZipCode)) {
			return chkBoxIncludeZipCode;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxIncludeZone() {
		if (commonLib.isDisplayed(chkBoxIncludeZone)) {
			return chkBoxIncludeZone;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxZipCode() {
		if (commonLib.isDisplayed(txtBoxZipCode)) {
			return txtBoxZipCode;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownState() {
		if (commonLib.isDisplayed(DrpDownState)) {
			return DrpDownState;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownZone() {
		if (commonLib.isDisplayed(DrpDownZone)) {
			return DrpDownZone;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxAllCandidates() {
		if (commonLib.isDisplayed(chkBoxAllCandidates)) {
			return chkBoxAllCandidates;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownActions() {
		if (commonLib.isDisplayed(drpDownActions)) {
			return drpDownActions;
		} else {
			return null;
		}
	}

	public WebElement getLinkNotExternal() {
		if (commonLib.isDisplayed(linkNotExternal)) {
			return linkNotExternal;
		} else {
			return null;
		}
	}

	public WebElement getBtnOkConfirmInternalCandidate() {
		if (commonLib.isDisplayed(btnOkConfirmInternalCandidate)) {
			return btnOkConfirmInternalCandidate;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxOfferPortfolio() {
		if (commonLib.isDisplayed(chkBoxOfferPortfolio)) {
			return chkBoxOfferPortfolio;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxOfferQQ() {
		if (commonLib.isDisplayed(chkBoxOfferQQ)) {
			return chkBoxOfferQQ;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxOfferEPI() {
		if (commonLib.isDisplayed(chkBoxOfferEPI)) {
			return chkBoxOfferEPI;
		} else {
			return null;
		}
	}

}
