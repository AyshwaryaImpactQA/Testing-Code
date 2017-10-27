/**
 * Created by : Mayank Bansal
 * TMManageRequisitionNumberPL.java
 * Aug 18, 2017
 * Purpose : Description details
 */
package com.scripts.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import com.scripts.lib.commonFunction.CommonUtills;

public class TMManageRequisitionNumberPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid3")
	private WebElement menuManage;

	public WebElement getMenuManage() {
		if (commonLib.isDisplayed(menuManage)) {
			return menuManage;
		} else {
			return null;
		}
	}

	public WebElement getSubManageRequisitionNumberTM() {
		if (commonLib.isDisplayed(subManageRequisitionNumberTM)) {
			return subManageRequisitionNumberTM;
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

	public WebElement getDropDownPositionType() {
		if (commonLib.isDisplayed(dropDownPositionType)) {
			return dropDownPositionType;
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

	@FindBy(id = "submenuid32")
	private WebElement subManageRequisitionNumberTM;

	@FindBy(id = "submenuid312")
	private WebElement subMenuRequisitionNumberDA;

	public WebElement getSubMenuRequisitionNumberDA() {
		if (commonLib.isDisplayed(subMenuRequisitionNumberDA)) {
			return subMenuRequisitionNumberDA;
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

	@FindBy(partialLinkText = "Add Requisition No")
	private WebElement linkAddRequisitionNo;

	@FindBy(id = "districtNameFilter")
	private WebElement txtBoxDistrictName;

	@FindBy(id = "requisitionNoId")
	private WebElement txtBoxReqNo;

	@FindBy(xpath = "//button[@onclick = 'searchReqNoList()']")
	private WebElement btnSearch;

	@FindBy(id = "districtName")
	private WebElement txtBoxAddDistrict;

	@FindBy(id = "reqno")
	private WebElement txtBoxAddRequisitionNo;

	@FindBy(id = "posType")
	private WebElement dropDownPositionType;

	@FindBy(id = "pageSize")
	private WebElement drpDownPageSize;

	@FindBy(id = "errordiv")
	private WebElement errorMessage;

	@FindBy(xpath = "//*[@id='reqNoDiv']//button")
	private WebElement btnSaveRequisitionNo;

	@FindBy(xpath = "//td[text()='No Requisition No. found']")
	private WebElement noRecordFoundMessage;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement firstOptionDistrict;

	@FindAll(@FindBy(xpath = "//*[@id='reqNoTable']//td[2]"))
	private List<WebElement> columnReqNo;

	public WebElement getFirstOptionDistrict() {
		if (commonLib.isDisplayed(firstOptionDistrict)) {
			return firstOptionDistrict;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownPageSize() {
		if (commonLib.isDisplayed(drpDownPageSize)) {
			return drpDownPageSize;
		} else {
			return null;
		}
	}

}
