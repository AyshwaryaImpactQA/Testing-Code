package com.scripts.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ManageTagsPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid3")
	private WebElement menuManage;

	@FindBy(id = "submenuid318")
	private WebElement subMenuTagsTM;

	@FindBy(id = "submenuid316")
	private WebElement subMenuTagsDA;

	@FindBy(id = "submenuid34")
	private WebElement subMenuTagsSA;

	@FindBy(partialLinkText = "Add Tag")
	private WebElement linkAddTag;

	@FindBy(id = "districtName")
	private WebElement txtBoxAddDistrict;

	@FindBy(id = "tags")
	private WebElement txtBoxTagName;

	@FindBy(css = "input[type=file]")
	private WebElement fileTagIcon;

	@FindBy(xpath = "//button/strong[contains(text(),'Save')]")
	private WebElement btnSave;

	@FindBy(id = "errordiv")
	private WebElement errorMessage;

	@FindBy(id = "entityType")
	private WebElement drpDownEntityType;

	@FindBy(id = "districtNameFilter")
	private WebElement txtBoxSearchDistrict;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement btnSearch;

	@FindBy(partialLinkText = "Next")
	private WebElement linkNext;

	@FindAll(@FindBy(xpath = "//*[@id='tagsTable']//td[1]"))
	private List<WebElement> columnTagName;

	@FindAll(@FindBy(xpath = "//*[@id='tagsTable']//td[4]"))
	private List<WebElement> columnTagIcon;

	@FindAll(@FindBy(xpath = "//*[@id='tagsTable']//td[5]/a[1]"))
	private List<WebElement> columnEditIcon;

	@FindAll(@FindBy(xpath = "//*[@id='tagsTable']//td[5]/a[2]"))
	private List<WebElement> columnActivateDeactivateIcon;
	
	@FindBy(partialLinkText = "Privilege For School")
	private WebElement accordionPrivilegeForSchool;
	
	@FindBy(id = "isCreateTags1")
	private WebElement chkBoxCreateTag;
	
	@FindBy(id = "isEditTags1")
	private WebElement chkBoxEditTag;
	
	@FindBy(id = "isRemoveTags1")
	private WebElement chkBoxActivateDeactivateTag;

	public WebElement getMenuManage() {
		if (commonLib.isDisplayed(menuManage)) {
			return menuManage;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuTagsTM() {
		if (commonLib.isDisplayed(subMenuTagsTM)) {
			return subMenuTagsTM;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuTagsDA() {
		if (commonLib.isDisplayed(subMenuTagsDA)) {
			return subMenuTagsDA;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuTagsSA() {
		if (commonLib.isDisplayed(subMenuTagsSA)) {
			return subMenuTagsSA;
		} else {
			return null;
		}
	}

	public WebElement getLinkAddTag() {
		if (commonLib.isDisplayed(linkAddTag)) {
			return linkAddTag;
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

	public WebElement getTxtBoxTagName() {
		if (commonLib.isDisplayed(txtBoxTagName)) {
			return txtBoxTagName;
		} else {
			return null;
		}
	}

	public WebElement getFileTagIcon() {
		if (commonLib.isDisplayed(fileTagIcon)) {
			return fileTagIcon;
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

	public WebElement getBtnSearch() {
		if (commonLib.isDisplayed(btnSearch)) {
			return btnSearch;
		} else {
			return null;
		}
	}

	public WebElement getLinkNext() {
		if (commonLib.isDisplayed(linkNext)) {
			return linkNext;
		} else {
			return null;
		}
	}

	public List<WebElement> getColumnTagName() {
		if (commonLib.isDisplayed(columnTagName)) {
			return columnTagName;
		} else {
			return null;
		}
	}

	public List<WebElement> getColumnTagIcon() {
		if (commonLib.isDisplayed(columnTagIcon)) {
			return columnTagIcon;
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

	public List<WebElement> getColumnActivateDeactivateIcon() {
		if (commonLib.isDisplayed(columnActivateDeactivateIcon)) {
			return columnActivateDeactivateIcon;
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

	public WebElement getChkBoxCreateTag() {
		if (commonLib.isDisplayed(chkBoxCreateTag)) {
			return chkBoxCreateTag;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxEditTag() {
		if (commonLib.isDisplayed(chkBoxEditTag)) {
			return chkBoxEditTag;
		} else {
			return null;
		}
	}

	public WebElement getChkBoxActivateDeactivateTag() {
		if (commonLib.isDisplayed(chkBoxActivateDeactivateTag)) {
			return chkBoxActivateDeactivateTag;
		} else {
			return null;
		}
	}

}
