package com.scripts.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ManageRequisitionNumberPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid3")
	private WebElement menuManage;

	@FindBy(id = "submenuid32")
	private WebElement subMenuRequisitionNumberTM;

	@FindBy(id = "submenuid32")
	private WebElement subMenuRequisitionNumberDA;

	@FindBy(id = "districtNameFilter")
	private WebElement txtBoxDistrictName;

	@FindBy(id = "requisitionNoId")
	private WebElement txtBoxReqNo;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement btnSearch;

	@FindBy(id = "divResultdivTxtShowDataFilter0")
	private WebElement firstOptionDistrict;

	@FindBy(xpath = "//a[text()='+Add Requisition No']")
	private WebElement linkAddRequisitionNo;

	@FindBy(id = "districtName")
	private WebElement txtBoxAddDistrict;

	@FindBy(id = "reqno")
	private WebElement txtBoxAddRequisitionNo;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement firstOptionAddDistrict;

	@FindBy(id = "posType")
	private WebElement drpDownPositionType;

	@FindBy(id = "location")
	private WebElement txtBoxLocation;

	@FindBy(id = "jobTitle")
	private WebElement txtBoxPositionTitle;

	@FindBy(id = "errordiv")
	private WebElement errorMessage;

	@FindBy(xpath = "//*[@id='reqNoDiv']//button")
	private WebElement btnSaveRequisitionNo;

	@FindBy(xpath = "//td[text()='No Requisition No. found']")
	private WebElement noRecordFoundMessage;

	@FindAll(@FindBy(xpath = "//*[@id='reqNoTable']//td[2]"))
	private List<WebElement> columnReqNo;

	@FindAll(@FindBy(xpath = "//*[@id='reqNoTable']//td[7]/a[1]"))
	private List<WebElement> columnEditIcon;

	@FindAll(@FindBy(xpath = "//*[@id='reqNoTable']//td[7]/a[2]"))
	private List<WebElement> columnDeleteIcon;

	public WebElement getMenuManage() {
		if (commonLib.isDisplayed(menuManage)) {
			return menuManage;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuRequisitionNumberTM() {
		if (commonLib.isDisplayed(subMenuRequisitionNumberTM)) {
			return subMenuRequisitionNumberTM;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuRequisitionNumberDA() {
		if (commonLib.isDisplayed(subMenuRequisitionNumberDA)) {
			return subMenuRequisitionNumberDA;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxDistrictName() {
		if (commonLib.isDisplayed(txtBoxDistrictName)) {
			return txtBoxDistrictName;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxReqNo() {
		if (commonLib.isDisplayed(txtBoxReqNo)) {
			return txtBoxReqNo;
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

	public WebElement getFirstOptionDistrict() {
		if (commonLib.isDisplayed(firstOptionDistrict)) {
			return firstOptionDistrict;
		} else {
			return null;
		}
	}

	public WebElement getLinkAddRequisitionNo() {
		if (commonLib.isDisplayed(linkAddRequisitionNo)) {
			return linkAddRequisitionNo;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxAddDistrict() {
		if (commonLib.isDisplayed(txtBoxAddDistrict)) {
			return txtBoxAddDistrict;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxAddRequisitionNo() {
		if (commonLib.isDisplayed(txtBoxAddRequisitionNo)) {
			return txtBoxAddRequisitionNo;
		} else {
			return null;
		}
	}

	public WebElement getFirstOptionAddDistrict() {
		if (commonLib.isDisplayed(firstOptionAddDistrict)) {
			return firstOptionAddDistrict;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownPositionType() {
		if (commonLib.isDisplayed(drpDownPositionType)) {
			return drpDownPositionType;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxLocation() {
		if (commonLib.isDisplayed(txtBoxLocation)) {
			return txtBoxLocation;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxPositionTitle() {
		if (commonLib.isDisplayed(txtBoxPositionTitle)) {
			return txtBoxPositionTitle;
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

	public WebElement getBtnSaveRequisitionNo() {
		if (commonLib.isDisplayed(btnSaveRequisitionNo)) {
			return btnSaveRequisitionNo;
		} else {
			return null;
		}
	}

	public WebElement getNoRecordFoundMessage() {
		if (commonLib.isDisplayed(noRecordFoundMessage)) {
			return noRecordFoundMessage;
		} else {
			return null;
		}
	}

	public List<WebElement> getColumnReqNo() {
		if (commonLib.isDisplayed(columnReqNo)) {
			return columnReqNo;
		} else {
			return null;
		}
	}

	public List<WebElement> getColumnEditIcon() {
		if (commonLib.isDisplayed(columnEditIcon)) {
			return columnEditIcon;
		} else {
			return null;
		}
	}

	public List<WebElement> getColumnDeleteIcon() {
		if (commonLib.isDisplayed(columnDeleteIcon)) {
			return columnDeleteIcon;
		} else {
			return null;
		}
	}

}
