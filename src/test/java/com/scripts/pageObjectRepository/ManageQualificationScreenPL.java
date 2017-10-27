package com.scripts.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ManageQualificationScreenPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid3")
	private WebElement menuManage;

	@FindBy(xpath = "//a[@id='submenuid35']")
	private WebElement subMenuQualificationScreenTM;

	@FindBy(id = "submenuid34")
	private WebElement subMenuQualificationScreenDA;

	@FindBy(xpath = "//a[text()='+Add Question Set']")
	private WebElement linkAddQuestionSet;

	@FindBy(id = "districtName")
	private WebElement txtBoxAddDistrict;

	@FindBy(id = "districtNameFilter")
	private WebElement txtBoxSearchDistrict;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement firstOptionAddDistrict;

	@FindBy(id = "divResultdivTxtShowDataFilter0")
	private WebElement firstOptionSearchDistrict;

	@FindBy(xpath = "//input[@id='quesSetName']")
	private WebElement txtBoxAddQuestionSet;

	@FindBy(id = "quesSetSearchText")
	private WebElement txtBoxSearchQuestionSet;

	@FindBy(id = "refChkSetStatus")
	private WebElement drpDownStatus;

	@FindBy(id = "quesSetActive")
	private WebElement radioQuestionSetActive;

	@FindBy(id = "quesSetInactive")
	private WebElement radioQuestionSetInactive;

	@FindBy(xpath = "//button/strong[contains(text(),'Save')]")
	private WebElement btnSave;

	@FindBy(id = "errQuesSetdiv")
	private WebElement errorMessageQuestionSet;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement btnSearch;
	
	@FindBy(xpath = "(//a[contains(text(),'Activate')])[1]")
	private WebElement ActivateLinkDA;

	

	public WebElement getActivateLinkDA() {
		if (commonLib.isDisplayed(ActivateLinkDA)) {
			return ActivateLinkDA;
		} else {
			return null;
		}
	}

	@FindAll(@FindBy(xpath = "//*[@id='refChkQuesTable']//td[1]"))
	private List<WebElement> columnQuestionSet;

	@FindAll(@FindBy(xpath = "//*[@id='refChkQuesTable']//td[4]/a[1]"))
	private List<WebElement> columnEditIcon;

	@FindAll(@FindBy(xpath = "//*[@id='refChkQuesTable']//td[4]/a[2]"))
	private List<WebElement> columnDeactivateIcon;

	@FindAll(@FindBy(xpath = "//*[@id='refChkQuesTable']//td[4]/a[3]"))
	private List<WebElement> columnManageQuestion;

	@FindBy(xpath = "//a[@onclick='return addNewQues()']")
	private WebElement linkAddQuestion;

	@FindBy(xpath = "//*[@id='assQuestion']/div/div[3]")
	private WebElement txtBoxQuestion;

	@FindBy(id = "questionTypeMaster")
	private WebElement drpDownQuestionType;

	@FindBy(xpath = "//*[@id='assInstruction']/div/div[3]")
	private WebElement txtBoxInstruction;

	@FindBy(id = "saveQues")
	private WebElement btnSaveQuestion;

	@FindBy(id = "errordiv")
	private WebElement errorMessageQuestion;
	
	
	@FindBy(xpath = "//*[@id='refChkQuesSetQuesTable']//a[text()='Edit']")
	private WebElement linkEditQuestion;
	
	public WebElement getLinkEditQuestionDA() {
		if (commonLib.isDisplayed(linkEditQuestionDA)) {
			return linkEditQuestionDA;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "(//a[contains(text(),'Edit')])[1]")
	private WebElement linkEditQuestionDA;
	
	@FindBy(linkText = "Remove")
	private WebElement linkRemoveQuestion;

	@FindBy(xpath = "//td[text()='No Question found']")
	private WebElement messageNoQuestionFound;
	
	@FindBy(xpath = "//*[@id='refChkQuesTable']//tr[1]//a[1]")
	private WebElement linkAddQuestionFromPool;

	public WebElement getMenuManage() {
		if (commonLib.isDisplayed(menuManage)) {
			return menuManage;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuQualificationScreenTM() {
		if (commonLib.isDisplayed(subMenuQualificationScreenTM)) {
			return subMenuQualificationScreenTM;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuQualificationScreenDA() {
		if (commonLib.isDisplayed(subMenuQualificationScreenDA)) {
			return subMenuQualificationScreenDA;
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

	public WebElement getFirstOptionAddDistrict() {
		if (commonLib.isDisplayed(firstOptionAddDistrict)) {
			return firstOptionAddDistrict;
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

	public WebElement getRadioQuestionSetActive() {
		if (commonLib.isDisplayed(radioQuestionSetActive)) {
			return radioQuestionSetActive;
		} else {
			return null;
		}
	}

	public WebElement getRadioQuestionSetInactive() {
		if (commonLib.isDisplayed(radioQuestionSetInactive)) {
			return radioQuestionSetInactive;
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

	public WebElement getErrorMessageQuestionSet() {
		if (commonLib.isDisplayed(errorMessageQuestionSet)) {
			return errorMessageQuestionSet;
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

	public WebElement getTxtBoxSearchQuestionSet() {
		if (commonLib.isDisplayed(txtBoxSearchQuestionSet)) {
			return txtBoxSearchQuestionSet;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownStatus() {
		if (commonLib.isDisplayed(drpDownStatus)) {
			return drpDownStatus;
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

	public List<WebElement> getColumnQuestionSet() {
		if (commonLib.isDisplayed(columnQuestionSet)) {
			return columnQuestionSet;
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

	public List<WebElement> getColumnDeactivateIcon() {
		if (commonLib.isDisplayed(columnDeactivateIcon)) {
			return columnDeactivateIcon;
		} else {
			return null;
		}
	}

	public List<WebElement> getColumnManageQuestion() {
		if (commonLib.isDisplayed(columnManageQuestion)) {
			return columnManageQuestion;
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

	public WebElement getErrorMessageQuestion() {
		if (commonLib.isDisplayed(errorMessageQuestion)) {
			return errorMessageQuestion;
		} else {
			return null;
		}
	}

	public WebElement getLinkEditQuestion() {
		if (commonLib.isDisplayed(linkEditQuestion)) {
			return linkEditQuestion;
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

	public WebElement getLinkAddQuestionFromPool() {
		if (commonLib.isDisplayed(linkAddQuestionFromPool)) {
			return linkAddQuestionFromPool;
		} else {
			return null;
		}
	}

}
