package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ImportUserPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid6")
	private WebElement menuImport;

	@FindBy(id = "submenuid63")
	private WebElement subMenuUsers;

	@FindBy(id = "districtName")
	private WebElement txtdistrictName;

	@FindBy(xpath = "//button[contains(text(),'Import')]")
	private WebElement btnImport;

	@FindBy(css = "input[type=file]")
	private WebElement fileUpload;

	@FindBy(xpath = "//button[contains(text(),'Accept')]")
	private WebElement btnAccept;

	@FindBy(xpath = "//button[contains(text(),'Reject ')]")
	private WebElement btnReject;

	@FindBy(id = "errordiv")
	private WebElement errorMessage;

	@FindBy(id = "menuid2")
	private WebElement userMenu;

	@FindBy(id = "submenuid21")
	private WebElement subMenuAdminAnalyst;
	
	@FindBy(id = "MU_EntityType")
	private WebElement drpDownEntityType;

	@FindBy(id = "emailAddress")
	private WebElement emailConfirmAddress;

	@FindBy(id = "MU_EntityType")
	private WebElement txtEntityType;

	@FindBy(id = "onlyDistrictName")
	private WebElement txtonlyDistrictName;

	@FindBy(xpath = "//div[contains(text(),'User details have been imported successfully')]")
	private WebElement confirmJobMessage;

	@FindBy(xpath = "//*[@id='myModalMsg']//button[text()='Close']")
	private WebElement btnClose;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement emailSeacrhBtn;
	
	@FindBy(xpath = "//td[text()='No Record found']")
	private WebElement msgNoRecordFound;

	public WebElement getMenuImport() {
		if (commonLib.isDisplayed(menuImport)) {
			return menuImport;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuUsers() {
		if (commonLib.isDisplayed(subMenuUsers)) {
			return subMenuUsers;
		} else {
			return null;
		}
	}

	public WebElement getTxtdistrictName() {
		if (commonLib.isDisplayed(txtdistrictName)) {
			return txtdistrictName;
		} else {
			return null;
		}
	}

	public WebElement getBtnImport() {
		if (commonLib.isDisplayed(btnImport)) {
			return btnImport;
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
	 
		
		
		


	public WebElement getBtnAccept() {
		if (commonLib.isDisplayed(btnAccept)) {
			return btnAccept;
		} else {
			return null;
		}
	}

	public WebElement getBtnReject() {
		if (commonLib.isDisplayed(btnReject)) {
			return btnReject;
		} else {
			return null;
		}
	}

	public WebElement getErrorMessage() {
		if (commonLib.isDisplayed(errorMessage)) {
			return errorMessage;
		} else {
			return null;
		}
	}

	public WebElement getUserMenu() {
		if (commonLib.isDisplayed(userMenu)) {
			return userMenu;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuAdminAnalyst() {
		if (commonLib.isDisplayed(subMenuAdminAnalyst)) {
			return subMenuAdminAnalyst;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownEntityType() {
		if (commonLib.isDisplayed(drpDownEntityType)) {
			return drpDownEntityType;
		} else {
			return null;
		}
	}

	public WebElement getEmailConfirmAddress() {
		if (commonLib.isDisplayed(emailConfirmAddress)) {
			return emailConfirmAddress;
		} else {
			return null;
		}
	}

	public WebElement getTxtEntityType() {
		if (commonLib.isDisplayed(txtEntityType)) {
			return txtEntityType;
		} else {
			return null;
		}
	}

	public WebElement getTxtonlyDistrictName() {
		if (commonLib.isDisplayed(txtonlyDistrictName)) {
			return txtonlyDistrictName;
		} else {
			return null;
		}
	}

	public WebElement getConfirmJobMessage() {
		if (commonLib.isDisplayed(confirmJobMessage)) {
			return confirmJobMessage;
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

	public WebElement getEmailSeacrhBtn() {
		if (commonLib.isDisplayed(emailSeacrhBtn)) {
			return emailSeacrhBtn;
		} else {
			return null;
		}
	}

	public WebElement getMsgNoRecordFound() {
		if (commonLib.isDisplayed(msgNoRecordFound)) {
			return msgNoRecordFound;
		} else {
			return null;
		}
	}

}
