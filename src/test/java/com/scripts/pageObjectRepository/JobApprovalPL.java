package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class JobApprovalPL {
	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid3")
	private WebElement menuManage;

	@FindBy(id = "submenuid33")
	private WebElement subMenuDistricts;

	@FindBy(id = "submenuid32")
	private WebElement subMenuDistrictsDA;

	@FindBy(id = "districtName")
	private WebElement txtBxDistName;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement btnDistSearch;

	@FindBy(xpath = ".//*[@id='tblGrid']//a[@title='Edit']")
	private WebElement btnEditDist;

	@FindBy(xpath = ".//*[@id='divResultdivTxtShowData0']")
	private WebElement drpDwnDistResult;

	@FindBy(xpath = ".//*[@id='tblGrid']//tr")
	private WebElement waitfrSeachDist;

	@FindBy(xpath = ".//*[@id='tblGrid']//a[@title='Edit']")
	private WebElement editDistBtn;

	@FindBy(xpath = ".//*[@id='accordion']//a[contains(text(),'General Information')]")
	private WebElement AccordGenInfo;

	@FindBy(xpath = ".//*[@id='accordion']//a[contains(text(),'Privilege For District')]")
	private WebElement AccordDistPrivilege;

	@FindBy(id = "skipApprovalProcess")
	private WebElement jobApprovalProcess;

	@FindBy(id = "approvalBeforeGoLive1")
	private WebElement chkBxApprovalPriorToLive;

	@FindBy(id = "noOfApprovalNeeded")
	private WebElement drpDownNoOfApproval;

	@FindBy(id = "buildApprovalGroups")
	private WebElement chkBxBuildApprovalGrps;

	@FindBy(xpath = "//button/strong[contains(text(),'Save District')]")
	private WebElement btnSaveDistrict;

	@FindBy(xpath = ".//*[@id='duplicateTalentEDConfirmation']//button[contains(text(),'Yes')]")
	private WebElement btnYesConfirmBox;

	@FindBy(xpath = "//div[@id='myModalUpdateMsg']//button[text()='Close']")
	private WebElement btnCloseConfirmPopup;

	public WebElement getBtnCloseConfirmPopup() {
		if (commonLib.isDisplayed(btnCloseConfirmPopup)) {
			return btnCloseConfirmPopup;
		} else {
			return null;
		}
	}

	public WebElement getBtnYesConfirmBox() {
		if (commonLib.isDisplayed(btnYesConfirmBox)) {
			return btnYesConfirmBox;
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

	public WebElement getJobApprovalProcess() {
		if (commonLib.isDisplayed(jobApprovalProcess)) {
			return jobApprovalProcess;
		} else {
			return null;
		}
	}

	public WebElement getChkBxApprovalPriorToLive() {
		if (commonLib.isDisplayed(chkBxApprovalPriorToLive)) {
			return chkBxApprovalPriorToLive;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownNoOfApproval() {
		if (commonLib.isDisplayed(drpDownNoOfApproval)) {
			return drpDownNoOfApproval;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuDistrictsDA() {
		if (commonLib.isDisplayed(subMenuDistrictsDA)) {
			return subMenuDistrictsDA;
		} else {
			return null;
		}
	}

	public WebElement getChkBxBuildApprovalGrps() {
		if (commonLib.isDisplayed(chkBxBuildApprovalGrps)) {
			return chkBxBuildApprovalGrps;
		} else {
			return null;
		}
	}

	public WebElement getAccordDistPrivilege() {
		if (commonLib.isDisplayed(AccordDistPrivilege)) {
			return AccordDistPrivilege;
		} else {
			return null;
		}
	}

	public WebElement getAccordGenInfo() {
		if (commonLib.isDisplayed(AccordGenInfo)) {
			return AccordGenInfo;
		} else {
			return null;
		}
	}

	public WebElement getEditDistBtn() {
		if (commonLib.isDisplayed(editDistBtn)) {
			return editDistBtn;
		} else {
			return null;
		}
	}

	public WebElement getWaitfrSeachDist() {
		if (commonLib.isDisplayed(waitfrSeachDist)) {
			return waitfrSeachDist;
		} else {
			return null;
		}
	}

	public WebElement getDrpDwnDistResult() {
		if (commonLib.isDisplayed(drpDwnDistResult)) {
			return drpDwnDistResult;
		} else {
			return null;
		}
	}

	public WebElement getMenuManage() {
		if (commonLib.isDisplayed(menuManage)) {
			return menuManage;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuDistricts() {
		if (commonLib.isDisplayed(subMenuDistricts)) {
			return subMenuDistricts;
		} else {
			return null;
		}
	}

	public WebElement getTxtBxDistName() {
		if (commonLib.isDisplayed(txtBxDistName)) {
			return txtBxDistName;
		} else {
			return null;
		}
	}

	public WebElement getBtnDistSearch() {
		if (commonLib.isDisplayed(btnDistSearch)) {
			return btnDistSearch;
		} else {
			return null;
		}
	}

	public WebElement getBtnEditDist() {
		if (commonLib.isDisplayed(btnEditDist)) {
			return btnEditDist;
		} else {
			return null;
		}
	}
}
