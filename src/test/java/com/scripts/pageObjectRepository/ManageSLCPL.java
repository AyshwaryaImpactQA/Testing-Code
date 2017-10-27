package com.scripts.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ManageSLCPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid3")
	private WebElement menuManage;

	@FindBy(id = "submenuid314")
	private WebElement subMenuStatusLifeCycle;

	@FindBy(id = "districtName")
	private WebElement txtBoxDistrict;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement firstOptionDistrict;

	@FindBy(id = "jobCategory")
	private WebElement drpDownJobCategory;

	@FindBy(xpath = "//button/strong[contains(text(),'Go')]")
	private WebElement btnGo;

	@FindBy(xpath = "//*[@id='tree']//a[text()='Screen']")
	private WebElement nodeScreen;

	@FindBy(xpath = "//*[@id='tree']//a[text()='Evaluate']")
	private WebElement nodeEvaluate;

	@FindBy(xpath = "//*[@id='tree']//a[text()='Vet']")
	private WebElement nodeVet;

	@FindAll(@FindBy(xpath = "//li[span[a[text()='Screen']]]/ul//a"))
	private List<WebElement> subNodesScreen;

	@FindAll(@FindBy(xpath = "//li[span[a[text()='Evaluate']]]/ul//a"))
	private List<WebElement> subNodesEvaluate;

	@FindAll(@FindBy(xpath = "//li[span[a[text()='Vet']]]/ul//a"))
	private List<WebElement> subNodesVet;

	@FindBy(id = "createIcon")
	private WebElement iconCreate;

	@FindBy(id = "renameIcon")
	private WebElement iconRename;

	@FindBy(id = "cutIcon")
	private WebElement iconCut;

	@FindBy(id = "copyIcon")
	private WebElement iconCopy;

	@FindBy(id = "pasteIcon")
	private WebElement iconPaste;

	@FindBy(id = "deleteIcon")
	private WebElement iconDelete;

	@FindBy(id = "questionIcon")
	private WebElement iconAttributes;

	@FindBy(id = "editNode")
	private WebElement txtBoxNode;

	@FindBy(id = "myModalLabelForQuestion")
	private WebElement attributePage;

	@FindBy(xpath = "//*[@id='myModalQuestionList']//button[text()='Cancel']")
	private WebElement btnCancel;
	
	public WebElement getBtnAttCancel() {
		if (commonLib.isDisplayed(btnAttCancel)) {
			return btnAttCancel;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//*[@id='allAttributebtn']/button")
	private WebElement btnAttCancel;
	
	@FindBy(xpath = "//*[@id='deleteFolder']//button[contains(text(),'Ok')]")
	private WebElement btnConfirmDelete;

	public WebElement getMenuManage() {
		if (commonLib.isDisplayed(menuManage)) {
			return menuManage;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuStatusLifeCycle() {
		if (commonLib.isDisplayed(subMenuStatusLifeCycle)) {
			return subMenuStatusLifeCycle;
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

	public WebElement getFirstOptionDistrict() {
		if (commonLib.isDisplayed(firstOptionDistrict)) {
			return firstOptionDistrict;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownJobCategory() {
		if (commonLib.isDisplayed(drpDownJobCategory)) {
			return drpDownJobCategory;
		} else {
			return null;
		}
	}

	public WebElement getBtnGo() {
		if (commonLib.isDisplayed(btnGo)) {
			return btnGo;
		} else {
			return null;
		}
	}

	public WebElement getNodeScreen() {
		if (commonLib.isDisplayed(nodeScreen)) {
			return nodeScreen;
		} else {
			return null;
		}
	}

	public WebElement getNodeEvaluate() {
		if (commonLib.isDisplayed(nodeEvaluate)) {
			return nodeEvaluate;
		} else {
			return null;
		}
	}

	public WebElement getNodeVet() {
		if (commonLib.isDisplayed(nodeVet)) {
			return nodeVet;
		} else {
			return null;
		}
	}

	public List<WebElement> getSubNodesScreen() {
		if (commonLib.isDisplayed(subNodesScreen)) {
			return subNodesScreen;
		} else {
			return null;
		}
	}

	public List<WebElement> getSubNodesEvaluate() {
		if (commonLib.isDisplayed(subNodesEvaluate)) {
			return subNodesEvaluate;
		} else {
			return null;
		}
	}

	public List<WebElement> getSubNodesVet() {
		if (commonLib.isDisplayed(subNodesVet)) {
			return subNodesVet;
		} else {
			return null;
		}
	}

	public WebElement getIconCreate() {
		if (commonLib.isDisplayed(iconCreate)) {
			return iconCreate;
		} else {
			return null;
		}
	}

	public WebElement getIconRename() {
		if (commonLib.isDisplayed(iconRename)) {
			return iconRename;
		} else {
			return null;
		}
	}

	public WebElement getIconCut() {
		if (commonLib.isDisplayed(iconCut)) {
			return iconCut;
		} else {
			return null;
		}
	}

	public WebElement getIconCopy() {
		if (commonLib.isDisplayed(iconCopy)) {
			return iconCopy;
		} else {
			return null;
		}
	}

	public WebElement getIconPaste() {
		if (commonLib.isDisplayed(iconPaste)) {
			return iconPaste;
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

	public WebElement getIconAttributes() {
		if (commonLib.isDisplayed(iconAttributes)) {
			return iconAttributes;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxNode() {
		if (commonLib.isDisplayed(txtBoxNode)) {
			return txtBoxNode;
		} else {
			return null;
		}
	}

	public WebElement getAttributePage() {
		if (commonLib.isDisplayed(attributePage)) {
			return attributePage;
		} else {
			return null;
		}
	}

	public WebElement getBtnCancel() {
		if (commonLib.isDisplayed(btnCancel)) {
			return btnCancel;
		} else {
			return null;
		}
	}

	public WebElement getBtnConfirmDelete() {
		if (commonLib.isDisplayed(btnConfirmDelete)) {
			return btnConfirmDelete;
		} else {
			return null;
		}
	}

}
