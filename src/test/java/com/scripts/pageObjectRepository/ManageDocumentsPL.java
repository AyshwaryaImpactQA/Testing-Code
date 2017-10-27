package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ManageDocumentsPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid3")
	private WebElement menuManage;

	@FindBy(id = "submenuid315")
	private WebElement subMenuDocumentsTM;

	@FindBy(id = "submenuid312")
	private WebElement subMenuDocumentsDA;

	@FindBy(id = "MU_EntityType")
	private WebElement drpDownEntityType;

	@FindBy(id = "docname")
	private WebElement txtBoxDocumentName;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement btnSearch;

	@FindBy(linkText = "+Add Documents")
	private WebElement linkAddDocument;

	@FindBy(id = "districtName")
	private WebElement txtBoxDistrict;
	
	@FindBy(id = "allSchool")
	private WebElement radioBtnAllSchools;

	@FindBy(id = "docName")
	private WebElement txtBoxAddDocName;

	@FindBy(id = "errornotediv")
	private WebElement errorMessage;

	@FindBy(id = "save")
	private WebElement btnSave;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement firstOptionDistrict;

	@FindBy(id = "update")
	private WebElement btnUpdate;

	@FindBy(css = "input[type=file]")
	private WebElement fileUpload;

	@FindBy(xpath = "//table[@id='distAttachmentTable']//td[3]")
	private WebElement rowDocument;

	@FindBy(xpath = "//table[@id='distAttachmentTable']//td[6]/a[1]")
	private WebElement iconEdit;

	@FindBy(xpath = "//*[@id='distAttachmentTable']/tbody/tr[1]/td[6]/a[2]/i") 
	private WebElement iconDelete;

	@FindBy(xpath = "//table[@id='distAttachmentTable']//td[6]/a[3]")
	private WebElement iconActivateDeactivate;

	@FindBy(xpath = "//*[@id='distAttachmentTable']//td[4]//i")
	private WebElement iconAttachment;

	@FindBy(xpath = "//*[@id='successModal']//button[contains(text(),'Ok')]")
	private WebElement btnSuccess;

	@FindBy(xpath = "//td[text()='No record found.']")
	private WebElement msgNoRecordFound;

	@FindBy(xpath = "//*[@id='successEditModal']//button[contains(text(),'Ok')]")
	private WebElement btnEditSuccess;

	@FindBy(xpath = ".//*[@id='distAttachmentShowDiv']//button[text()='Close']")
	private WebElement btnClose;
	
	//@FindBy(xpath = "//*[@id='removeDocumentsConfirmation']//button[contains(text(),'Ok')]")
	//private WebElement btnConfirmDelete;

	public WebElement getMenuManage() {
		if (commonLib.isDisplayed(menuManage)) {
			return menuManage;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuDocumentsTM() {
		if (commonLib.isDisplayed(subMenuDocumentsTM)) {
			return subMenuDocumentsTM;
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

	public WebElement getTxtBoxDocumentName() {
		if (commonLib.isDisplayed(txtBoxDocumentName)) {
			return txtBoxDocumentName;
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

	public WebElement getLinkAddDocument() {
		if (commonLib.isDisplayed(linkAddDocument)) {
			return linkAddDocument;
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

	public WebElement getRadioBtnAllSchools() {
		if (commonLib.isDisplayed(radioBtnAllSchools)) {
			return radioBtnAllSchools;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxAddDocName() {
		if (commonLib.isDisplayed(txtBoxAddDocName)) {
			return txtBoxAddDocName;
		} else {
			return null;
		}
	}

	public WebElement getBtnSave() {
		if (commonLib.isDisplayed(btnSave)) {
			return btnSave;
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

	public WebElement getErrorMessage() {
		if (commonLib.isDisplayed(errorMessage)) {
			return errorMessage;
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

	public WebElement getSubMenuDocumentsDA() {
		if (commonLib.isDisplayed(subMenuDocumentsDA)) {
			return subMenuDocumentsDA;
		} else {
			return null;
		}
	}


	public WebElement getRowDocument() {
		if (commonLib.isDisplayed(rowDocument)) {
			return rowDocument;
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

	public WebElement getIconDelete() {
		if (commonLib.isDisplayed(iconDelete)) {
			return iconDelete;
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

	public WebElement getBtnSuccess() {
		if (commonLib.isDisplayed(btnSuccess)) {
			return btnSuccess;
		} else {
			return null;
		}
	}

	public WebElement getBtnUpdate() {
		if (commonLib.isDisplayed(btnUpdate)) {
			return btnUpdate;
		} else {
			return null;
		}
	}

	public WebElement getBtnEditSuccess() {
		if (commonLib.isDisplayed(btnEditSuccess)) {
			return btnEditSuccess;
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

	public WebElement getIconAttachment() {
		if (commonLib.isDisplayed(iconAttachment)) {
			return iconAttachment;
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

//	public WebElement getBtnConfirmDelete() {
//		if (commonLib.isDisplayed(btnConfirmDelete)) {
//			return btnConfirmDelete;
//		} else {
//			return null;
//		}
	//}

}
