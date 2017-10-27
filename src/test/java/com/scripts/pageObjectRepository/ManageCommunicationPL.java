package com.scripts.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ManageCommunicationPL {
	CommonUtills commonLib = new CommonUtills();

	@FindBy(xpath = ".//*[@id='menuid3']")
	private WebElement menuManage;

	@FindBy(xpath = "//*[@id='submenuid312']")
	private WebElement subMenuCommunication;

	@FindBy(id = "districtName")
	private WebElement txtBxDistrictName;

	@FindBy(id = "templateType")
	private WebElement drpdnTmltType;

	@FindBy(xpath = ".//*[@id='eventsearchDiv']//button")
	private WebElement btnSearch;

	@FindBy(xpath = ".//*[@id='addLink']/a")
	private WebElement btnAddTemplate;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement rsltDrpDnDistrict;

	@FindBy(xpath = "//*[@id='templateTable']//tr[1]//a[@title='Edit']/i")
	private WebElement btnEdit;

	@FindBy(id = "eventtitle")
	private WebElement txtBxTemplateName;

	@FindBy(id = "subjectforParticipants")
	private WebElement txtBxSubject;

	@FindBy(xpath = ".//*[@id='messagetext']//div[@class='jqte_editor']")
	private WebElement txtBxTemplateBody;

	@FindBy(xpath = ".//*[@id='save']/strong[contains(text(),'Save')]")
	private WebElement btnSave;

	@FindBy(id = "save")
	private WebElement btnSaveNwTmplt;

	@FindBy(xpath = ".//*[@id='templateTable']//td[1]")
	private List<WebElement> rsltTmpltName;

	@FindBy(xpath = "//a[contains(text(),'Next')]")
	private WebElement btnNext;

	@FindBy(xpath = "//a[contains(text(),'Last')]")
	private WebElement btnLast;
	
	@FindBy(xpath = "//a[contains(text(),'First')]")
	private WebElement linkFirst;

	public WebElement getBtnAddTemplate() {
		if (commonLib.isDisplayed(btnAddTemplate)) {
			return btnAddTemplate;
		} else {
			return null;
		}
	}

	public WebElement getBtnNext() {
		if (commonLib.isDisplayed(btnNext)) {
			return btnNext;
		} else {
			return null;
		}
	}

	public WebElement getBtnLast() {
		if (commonLib.isDisplayed(btnLast)) {
			return btnLast;
		} else {
			return null;
		}
	}

	public List<WebElement> getRsltTmpltName() {
		if (commonLib.isDisplayed(rsltTmpltName)) {
			return rsltTmpltName;
		} else {
			return null;
		}
	}

	public WebElement getTxtBxSubject() {
		if (commonLib.isDisplayed(txtBxSubject)) {
			return txtBxSubject;
		} else {
			return null;
		}
	}

	public WebElement getBtnSaveNwTmplt() {
		if (commonLib.isDisplayed(btnSaveNwTmplt)) {
			return btnSaveNwTmplt;
		} else {
			return null;
		}
	}

	public WebElement getTxtBxTemplateBody() {
		if (commonLib.isDisplayed(txtBxTemplateBody)) {
			return txtBxTemplateBody;
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

	public WebElement getBtnEdit() {
		if (commonLib.isDisplayed(btnEdit)) {
			return btnEdit;
		} else {
			return null;
		}
	}

	public WebElement getTxtBxTemplateName() {
		if (commonLib.isDisplayed(txtBxTemplateName)) {
			return txtBxTemplateName;
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

	public WebElement getSubMenuCommunication() {
		if (commonLib.isDisplayed(subMenuCommunication)) {
			return subMenuCommunication;
		} else {
			return null;
		}
	}

	public WebElement getTxtBxDistrictName() {
		if (commonLib.isDisplayed(txtBxDistrictName)) {
			return txtBxDistrictName;
		} else {
			return null;
		}
	}

	public WebElement getDrpdnTmltType() {
		if (commonLib.isDisplayed(drpdnTmltType)) {
			return drpdnTmltType;
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

	public WebElement getRsltDrpDnDistrict() {
		if (commonLib.isDisplayed(rsltDrpDnDistrict)) {
			return rsltDrpDnDistrict;
		} else {
			return null;
		}
	}

	public WebElement getLinkFirst() {
		if (commonLib.isDisplayed(linkFirst)) {
			return linkFirst;
		} else {
			return null;
		}
	}

}
