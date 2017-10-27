package com.scripts.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ManageJobCategoryPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid3")
	private WebElement menuManage;

	@FindBy(id = "submenuid317")
	private WebElement subManuJobCategory;

	@FindBy(id = "entityType")
	private WebElement drpDownEntityType;

	@FindBy(id = "districtNameFilter")
	private WebElement txtBoxSearchDistrict;

	@FindBy(id = "divResultdivTxtShowDataFilter0")
	private WebElement firstOptionSearchDistrict;

	@FindBy(partialLinkText = "Add Job Category")
	private WebElement linkAddJobCategory;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement btnSearch;

	@FindBy(id = "districtName")
	private WebElement txtBoxAddDistrict;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement firstOptionAddDistrict;

	@FindBy(id = "jobcategory")
	private WebElement txtBoxJobCategory;

	@FindBy(xpath = "//button/strong[contains(text(),'Save')]")
	private WebElement btnSave;

	@FindBy(id = "errordiv")
	private WebElement errorMessage;

	@FindBy(id = "pageSize")
	private WebElement drpDownPageSize;

	@FindAll(@FindBy(xpath = "//table[@id='jobCategoryTable']//td[1]"))
	private List<WebElement> columnJobCategoryName;

	@FindAll(@FindBy(xpath = "//table[@id='jobCategoryTable']//td[7]/a[1]"))
	private List<WebElement> columnIconEdit;

	@FindAll(@FindBy(xpath = "//table[@id='jobCategoryTable']//td[7]/a[2]"))
	private List<WebElement> columnIconShowHistory;

	@FindAll(@FindBy(xpath = "//table[@id='jobCategoryTable']//td[7]/a[3]"))
	private List<WebElement> columnIconDeactivate;

	@FindBy(id = "jobCategoryHistoryModalId")
	private WebElement popupShowHistory;

	@FindBy(xpath = "//div[@id='jobCategoryHistoryModalId']//button[text()='Close']")
	private WebElement btnClosePopupShowHistory;

	public WebElement getMenuManage() {
		if (commonLib.isDisplayed(menuManage)) {
			return menuManage;
		} else {
			return null;
		}
	}

	public WebElement getSubManuJobCategory() {
		if (commonLib.isDisplayed(subManuJobCategory)) {
			return subManuJobCategory;
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

	public WebElement getTxtBoxSearchDistrict() {
		if (commonLib.isDisplayed(txtBoxSearchDistrict)) {
			return txtBoxSearchDistrict;
		} else {
			return null;
		}
	}

	public WebElement getFirstOptionSearchDistrict() {
		if (commonLib.isDisplayed(firstOptionSearchDistrict)) {
			return firstOptionSearchDistrict;
		} else {
			return null;
		}
	}

	public WebElement getLinkAddJobCategory() {
		if (commonLib.isDisplayed(linkAddJobCategory)) {
			return linkAddJobCategory;
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

	public WebElement getFirstOptionAddDistrict() {
		if (commonLib.isDisplayed(firstOptionAddDistrict)) {
			return firstOptionAddDistrict;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxJobCategory() {
		if (commonLib.isDisplayed(txtBoxJobCategory)) {
			return txtBoxJobCategory;
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

	public WebElement getErrorMessage() {
		if (commonLib.isDisplayed(errorMessage)) {
			return errorMessage;
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

	public List<WebElement> getColumnJobCategoryName() {
		if (commonLib.isDisplayed(columnJobCategoryName)) {
			return columnJobCategoryName;
		} else {
			return null;
		}
	}

	public List<WebElement> getColumnIconEdit() {
		if (commonLib.isDisplayed(columnIconEdit)) {
			return columnIconEdit;
		} else {
			return null;
		}
	}

	public List<WebElement> getColumnIconShowHistory() {
		if (commonLib.isDisplayed(columnIconShowHistory)) {
			return columnIconShowHistory;
		} else {
			return null;
		}
	}

	public List<WebElement> getColumnIconDeactivate() {
		if (commonLib.isDisplayed(columnIconDeactivate)) {
			return columnIconDeactivate;
		} else {
			return null;
		}
	}

	public WebElement getPopupShowHistory() {
		if (commonLib.isDisplayed(popupShowHistory)) {
			return popupShowHistory;
		} else {
			return null;
		}
	}

	public WebElement getBtnClosePopupShowHistory() {
		if (commonLib.isDisplayed(btnClosePopupShowHistory)) {
			return btnClosePopupShowHistory;
		} else {
			return null;
		}
	}

}
