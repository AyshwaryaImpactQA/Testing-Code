package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ImportJobsPL {
	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid6")
	private WebElement menuImport;

	@FindBy(id = "submenuid62")
	private WebElement subMenuJobs;

	@FindBy(css = "input[type=file]")
	private WebElement fileUpload;

	@FindBy(id = "districtName")
	private WebElement txtBoxDistrict;

	@FindBy(xpath = "//button[contains(text(),'Import ')]")
	private WebElement btnImport;

	@FindBy(id = "menuid4")
	private WebElement menuJobOder;

	@FindBy(id = "submenuid41")
	private WebElement subMenuDJO;

	@FindBy(id = "searchTerm")
	private WebElement txtBoxKeyword;

	@FindBy(id = "jeffcoButtonSearchHide")
	private WebElement btnSearch;

	@FindBy(xpath = "//div[contains(text(),'Job(s) has been added successfully')]")
	private WebElement confirmJobMessage;

	@FindBy(xpath = "//td[text()='No Record found']")
	private WebElement msgNoRecordFound;

	@FindBy(id = "errordiv")
	private WebElement errorMessage;

	@FindBy(id = "saveJobId")
	private WebElement btnAccept;
	
	@FindBy(xpath = "//button[contains(text(),'Reject ')]")
	private WebElement btnReject;

	@FindBy(xpath = "//*[@id='myModalMsg']//button[text()='Close']")
	private WebElement btnClose;

	public WebElement getMenuImport() {
		if (commonLib.isDisplayed(menuImport)) {
			return menuImport;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuJobs() {
		if (commonLib.isDisplayed(subMenuJobs)) {
			return subMenuJobs;
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

	public WebElement getTxtBoxDistrict() {
		if (commonLib.isDisplayed(txtBoxDistrict)) {
			return txtBoxDistrict;
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

	public WebElement getMenuJobOder() {
		if (commonLib.isDisplayed(menuJobOder)) {
			return menuJobOder;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuDJO() {
		if (commonLib.isDisplayed(subMenuDJO)) {
			return subMenuDJO;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxKeyword() {
		if (commonLib.isDisplayed(txtBoxKeyword)) {
			return txtBoxKeyword;
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

	public WebElement getConfirmJobMessage() {
		if (commonLib.isDisplayed(confirmJobMessage)) {
			return confirmJobMessage;
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

	public WebElement getErrorMessage() {
		if (commonLib.isDisplayed(errorMessage)) {
			return errorMessage;
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

	public WebElement getBtnClose() {
		if (commonLib.isDisplayed(btnClose)) {
			return btnClose;
		} else {
			return null;
		}
	}

}
