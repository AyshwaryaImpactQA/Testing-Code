package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ManageERefSetPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid3")
	private WebElement menuManage;

	@FindBy(id = "submenuid311")
	private WebElement subMenuERefSetTM;

	@FindBy(id = "submenuid311")
	private WebElement subMenuERefSetDA;
	
	@FindBy(id = "districtNameFilter")
	private WebElement txtBoxSearchDistrict;

	@FindBy(id = "divResultdivTxtShowDataFilter0")
	private WebElement firstOptionSearchDistrict;

	@FindBy(id = "quesSetSearchText")
	private WebElement txtBoxSearchQuestionSet;

	@FindBy(id = "refChkSetStatus")
	private WebElement drpDownSearchStatus;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement btnSearch;

	@FindBy(xpath = "//a[contains(text(),'+Add Question Set')]")
	private WebElement linkAddQuestionSet;

	@FindBy(id = "districtName")
	private WebElement txtBoxAddDistrict;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement firstOptionAddDistrict;

	@FindBy(id = "quesSetName")
	private WebElement txtBoxAddQuestionSet;

	@FindBy(id = "quesSetActive")
	private WebElement radioBtnActive;

	@FindBy(id = "quesSetInactive")
	private WebElement radioBtnInactive;

	@FindBy(xpath = "//button/strong[contains(text(),'Save')]")
	private WebElement btnSave;

	@FindBy(id = "errQuesSetdiv")
	private WebElement errorMessage;

	@FindBy(xpath = "//td[contains(text(),'Question Set')]")
	private WebElement columnQuestionSetName;
	
	public WebElement getColumnQuestionSetNameOption() {
		if (commonLib.isDisplayed(columnQuestionSetNameOption)) {
			return columnQuestionSetNameOption;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//*[@id='refChkQuesTable']/tbody/tr/td[1]")
	private WebElement columnQuestionSetNameOption;

	@FindBy(xpath = "(//*[@id='refChkQuesTable']//td[4]/a[1])[1]")
	private WebElement columnEditIcon;

	@FindBy(xpath = "(//a[contains(text(),'Deactivate')])[1]")
	private WebElement columnDeactivateIcon;

	@FindBy(xpath = "//*[@id='refChkQuesTable']//td[4]/a[3]")
	private WebElement columnLinkManageQuestions;

	@FindBy(xpath = "//a[@onclick='return addNewQues()']")
	private WebElement linkAddQuestion;

	@FindBy(xpath = "//*[@id='assQuestion']/div/div[3]")
	private WebElement txtBoxQuestion;

	@FindBy(id = "questionTypeMaster")
	private WebElement drpDownQuestionType;

	@FindBy(id = "questionMaxScore")
	private WebElement txtBoxQuestionMaxScore;

	@FindBy(xpath = "//*[@id='assInstruction']/div/div[3]")
	private WebElement txtBoxInstruction;

	@FindBy(id = "saveQues")
	private WebElement btnSaveQuestion;

	@FindBy(id = "errordiv")
	private WebElement errorMessageAddQuestion;
	
	@FindBy(linkText = "Remove")
	private WebElement linkRemoveQuestion;
	
	@FindBy(xpath = "//td[text()='No Question found']")
	private WebElement messageNoQuestionFound;
	
	@FindBy(xpath = "//*[@id='refChkQuesTable']//tr[1]//a[1]")
	private WebElement linkAddQuestionFromPanel;
	
	@FindBy(xpath = "//div[@class='mt10']/a[text()='Cancel']")
	private WebElement linkCancel;

	public WebElement getMenuManage() {
		if (commonLib.isDisplayed(menuManage)) {
			return menuManage;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuERefSetTM() {
		if (commonLib.isDisplayed(subMenuERefSetTM)) {
			return subMenuERefSetTM;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuERefSetDA() {
		if (commonLib.isDisplayed(subMenuERefSetDA)) {
			return subMenuERefSetDA;
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

	public WebElement getTxtBoxSearchQuestionSet() {
		if (commonLib.isDisplayed(txtBoxSearchQuestionSet)) {
			return txtBoxSearchQuestionSet;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownSearchStatus() {
		if (commonLib.isDisplayed(drpDownSearchStatus)) {
			return drpDownSearchStatus;
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

	public WebElement getLinkAddQuestionSet() {
		if (commonLib.isDisplayed(linkAddQuestionSet)) {
			return linkAddQuestionSet;
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

	public WebElement getTxtBoxAddQuestionSet() {
		if (commonLib.isDisplayed(txtBoxAddQuestionSet)) {
			return txtBoxAddQuestionSet;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnActive() {
		if (commonLib.isDisplayed(radioBtnActive)) {
			return radioBtnActive;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnInactive() {
		if (commonLib.isDisplayed(radioBtnInactive)) {
			return radioBtnInactive;
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

	public WebElement getFirstOptionSearchDistrict() {
		if (commonLib.isDisplayed(firstOptionSearchDistrict)) {
			return firstOptionSearchDistrict;
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

	public WebElement getColumnQuestionSetName() {
		if (commonLib.isDisplayed(columnQuestionSetName)) {
			return columnQuestionSetName;
		} else {
			return null;
		}
	}

	public WebElement getColumnEditIcon() {
		if (commonLib.isDisplayed(columnEditIcon)) {
			return columnEditIcon;
		} else {
			return null;
		}
	}

	public WebElement getColumnDeactivateIcon() {
		if (commonLib.isDisplayed(columnDeactivateIcon)) {
			return columnDeactivateIcon;
		} else {
			return null;
		}
	}

	public WebElement getColumnLinkManageQuestions() {
		if (commonLib.isDisplayed(columnLinkManageQuestions)) {
			return columnLinkManageQuestions;
		} else {
			return null;
		}
	}

	public WebElement getLinkAddQuestion() {
		if (commonLib.isDisplayed(linkAddQuestion)) {
			return linkAddQuestion;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxQuestion() {
		if (commonLib.isDisplayed(txtBoxQuestion)) {
			return txtBoxQuestion;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownQuestionType() {
		if (commonLib.isDisplayed(drpDownQuestionType)) {
			return drpDownQuestionType;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxQuestionMaxScore() {
		if (commonLib.isDisplayed(txtBoxQuestionMaxScore)) {
			return txtBoxQuestionMaxScore;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxInstruction() {
		if (commonLib.isDisplayed(txtBoxInstruction)) {
			return txtBoxInstruction;
		} else {
			return null;
		}
	}

	public WebElement getBtnSaveQuestion() {
		if (commonLib.isDisplayed(btnSaveQuestion)) {
			return btnSaveQuestion;
		} else {
			return null;
		}
	}

	public WebElement getErrorMessageAddQuestion() {
		if (commonLib.isDisplayed(errorMessageAddQuestion)) {
			return errorMessageAddQuestion;
		} else {
			return null;
		}
	}

	public WebElement getLinkRemoveQuestion() {
		if (commonLib.isDisplayed(linkRemoveQuestion)) {
			return linkRemoveQuestion;
		} else {
			return null;
		}
	}

	public WebElement getMessageNoQuestionFound() {
		if (commonLib.isDisplayed(messageNoQuestionFound)) {
			return messageNoQuestionFound;
		} else {
			return null;
		}
	}

	public WebElement getLinkAddQuestionFromPanel() {
		if (commonLib.isDisplayed(linkAddQuestionFromPanel)) {
			return linkAddQuestionFromPanel;
		} else {
			return null;
		}
	}

	public WebElement getLinkCancel() {
		if (commonLib.isDisplayed(linkCancel)) {
			return linkCancel;
		} else {
			return null;
		}
	}

}
