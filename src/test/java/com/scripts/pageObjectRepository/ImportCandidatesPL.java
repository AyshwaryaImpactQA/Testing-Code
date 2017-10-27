package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ImportCandidatesPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid6")
	private WebElement menuImport;

	@FindBy(id = "submenuid61")
	private WebElement subMenuCandidates;

	@FindBy(id = "districtName")
	private WebElement txtdistrictName;

	@FindBy(xpath = "//button[contains(text(),'Import')]")
	private WebElement btnImport;

	@FindBy(id = "teacherfile")
	private WebElement fileUpload;

	@FindBy(xpath = "//button[contains(text(),'Accept')]")
	private WebElement btnAccept;

	@FindBy(xpath = "//button[contains(text(),'Reject ')]")
	private WebElement btnReject;

	@FindBy(id = "errordiv")
	private WebElement errorMessage;

	@FindBy(xpath = "//*[@id='myModalMsg']//button[text()='Close']")
	private WebElement btnClose;

	public WebElement getTxtdistrictName() {
		if (commonLib.isDisplayed(txtdistrictName)) {
			return txtdistrictName;
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

	public WebElement getMenuImport() {
		if (commonLib.isDisplayed(menuImport)) {
			return menuImport;
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

	public WebElement getFileUpload() {
		if (commonLib.isDisplayed(fileUpload)) {
			return fileUpload;
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

	public WebElement getBtnClose() {
		if (commonLib.isDisplayed(btnClose)) {
			return btnClose;
		} else {
			return null;
		}
	}
}
