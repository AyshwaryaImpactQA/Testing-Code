package com.scripts.businessLogic;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ManageQualificationScreenPL;

public class ManageQualificationScreenBL extends Driver {

	ManageQualificationScreenPL mngQualificationScrPage = PageFactory
			.initElements(driver, ManageQualificationScreenPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void navigateToQualificationScreenTM() throws Exception {
		commonLib.click(mngQualificationScrPage.getMenuManage(), "Manage Menu");
		//commonLib.waitForPageToLoad();
		commonLib.click(mngQualificationScrPage.getSubMenuQualificationScreenTM(),"Qualification Screen Sub Menu");
		commonLib.waitForPageToLoad();
		Thread.sleep(8000);
	}

	public void navigateToQualificationScreenDA() throws Exception {
		commonLib.click(mngQualificationScrPage.getMenuManage(), "Manage Menu");
		//commonLib.waitForPageToLoad();
		commonLib.click(mngQualificationScrPage.getSubMenuQualificationScreenDA(),
				"Qualification Screen Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void addQuestionSet(String userType, String district,
			String questionSet, String status) throws Exception {
		commonLib.logOnInfo("Add Question Set", "Adding new question set");
		if (userType.equals("TM")) {
			navigateToQualificationScreenTM();
		} else {
			navigateToQualificationScreenDA();
		}
		commonLib.click(mngQualificationScrPage.getLinkAddQuestionSet(),
				"Add Question Set Link");
		Thread.sleep(4000);
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(mngQualificationScrPage.getTxtBoxAddQuestionSet())) {
			commonLib.logOnError("Add Question Set",
					"Add question set page not laoded");
			return;
		}
		commonLib.waitForPageToLoad();
		if (userType.equals("TM")) {
			commonLib.typeText(mngQualificationScrPage.getTxtBoxAddDistrict(),district, "District TxtBox");
			Thread.sleep(2000);			
			commonLib.click(mngQualificationScrPage.getFirstOptionAddDistrict(),
					"First Option District");
			commonLib.waitForPageToLoad();
		}
		commonLib.typeText(mngQualificationScrPage.getTxtBoxAddQuestionSet(),
				questionSet, "Question Set TxtBox");
		commonLib.waitForPageToLoad();
		if (status.equals("Inactive")) {
			commonLib.click(mngQualificationScrPage.getRadioQuestionSetInactive(),
					"Inactive Radio Btn");
		}
		commonLib.click(mngQualificationScrPage.getBtnSave(), "Save Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngQualificationScrPage.getErrorMessageQuestionSet())) {
			commonLib.logOnError("Add Question Set",
					"New question set not added");
		} else {
			commonLib.logOnSuccess("Add Question Set",
					"New question set added successfully");
		}
	}

	public void searchQuestionSet(String userType, String district,
			String questionSet, String status) throws Exception {
		commonLib.logOnInfo("Search Question Set",
				"Searching newly added question set");
		if (userType.equals("TM")) {
			commonLib.typeText(
					mngQualificationScrPage.getTxtBoxSearchDistrict(),
					district, "District TxtBox");
			Thread.sleep(2000);
			commonLib.click(
					mngQualificationScrPage.getFirstOptionSearchDistrict(),
					"First Option District");
		}
		commonLib.typeText(
				mngQualificationScrPage.getTxtBoxSearchQuestionSet(),
				questionSet, "Question Set TxtBox");
		commonLib.selectDrpDownValue(
				mngQualificationScrPage.getDrpDownStatus(), status,
				"Status DropDown");
		commonLib.click(mngQualificationScrPage.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		Thread.sleep(8000);
		List<WebElement> columnQuestionSet = mngQualificationScrPage
				.getColumnQuestionSet();
		for (WebElement temp : columnQuestionSet) {
			if (commonLib.getText(temp).equals(questionSet)) {
				commonLib.logOnSuccess("Search Question Set",
						"Newly created question set found");
				return;
			}
		}
		/*commonLib.logOnError("Search Question Set",
				"Newly created question set not found");*/
	}

	public void editQuestionSet(String questionSet) throws Exception {
		boolean flag = false;
		commonLib.logOnInfo("Edit Question Set",
				"Editing newly added question set");
		commonLib.waitForPageToLoad();
		Thread.sleep(6000);
		List<WebElement> columnQuestionSet = mngQualificationScrPage
				.getColumnQuestionSet();
		List<WebElement> columnEditIcon = mngQualificationScrPage
				.getColumnEditIcon();
		for (int i = 0; i < columnQuestionSet.size(); i++) {
			if (commonLib.getText(columnQuestionSet.get(i)).equals(questionSet)) {
				commonLib.click(columnEditIcon.get(i), "Edit Icon");
				commonLib.waitForPageToLoad();
				flag = true;
				System.out.println("Flag =  " +flag);
				break;
			}
		}
		System.out.println("Flag =  " +flag);
		if (!flag) {
			commonLib.logOnError("Edit Question Set",
					"Newly created question set not found");
			return;
		}
		if (!commonLib.isDisplayed(mngQualificationScrPage
				.getTxtBoxAddQuestionSet())) {
			commonLib.logOnError("Edit Question Set",
					"Edit question set page not laoded");
			return;
		}
		commonLib.click(mngQualificationScrPage.getBtnSave(), "Save Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngQualificationScrPage
				.getErrorMessageQuestionSet())) {
			commonLib.logOnError("Edit Question Set",
					"New question set is not edited");
		} else {
			commonLib.logOnSuccess("Edit Question Set",
					"New question set is edited successfully");
		}
	}
	public void editQuestionSetDA(String questionSet,String userType) throws Exception {
		boolean flag = false;
		commonLib.logOnInfo("Edit Question Set","Editing question set");
			if (userType.equals("TM")) {
				navigateToQualificationScreenTM();
			} else {
				navigateToQualificationScreenDA();
			}
		commonLib.waitForPageToLoad();
		commonLib.click(mngQualificationScrPage.getLinkEditQuestionDA(),"Edit Question Link");
				commonLib.waitForPageToLoad();
				flag = true;
				
	
		if (!flag) {
			commonLib.logOnError("Edit Question Set",
					"Newly created question set not found");
			return;
		}
		if (!commonLib.isDisplayed(mngQualificationScrPage.getTxtBoxAddQuestionSet())) {
			commonLib.logOnError("Edit Question Set",
					"Edit question set page not laoded");
			return;
		}
		commonLib.click(mngQualificationScrPage.getBtnSave(), "Save Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngQualificationScrPage
				.getErrorMessageQuestionSet())) {
			commonLib.logOnError("Edit Question Set",
					"New question set is not edited");
		} else {
			commonLib.logOnSuccess("Edit Question Set",
					"New question set is edited successfully");
		}
	
	}
	public void manageQuestions(String questionSet, String question,
			String questionType, String instruction) throws Exception {
		boolean flag = false;
		commonLib.logOnInfo("Add Question", "Adding new question");
		commonLib.waitForPageToLoad();
		List<WebElement> columnQuestionSet = mngQualificationScrPage
				.getColumnQuestionSet();
		List<WebElement> columnManageQuestion = mngQualificationScrPage
				.getColumnManageQuestion();
		for (int i = 0; i < columnQuestionSet.size(); i++) {
			if (commonLib.getText(columnQuestionSet.get(i)).equals(questionSet)) {
				commonLib.click(columnManageQuestion.get(i),
						"Manage Question Link");
				commonLib.waitForPageToLoad();
				flag = true;
				break;
			}
		}
		if (!flag) {
			commonLib.logOnError("Add Question",
					"Newly created question set not found");
			return;
		}
		if (!commonLib
				.isDisplayed(mngQualificationScrPage.getLinkAddQuestion())) {
			commonLib.logOnError("Add Question",
					"Add Question Link not displayed");
			return;
		}
		commonLib.click(mngQualificationScrPage.getLinkAddQuestion(),
				"Add Question Link");
		commonLib.waitForPageToLoad();
		commonLib.typeText(mngQualificationScrPage.getTxtBoxQuestion(),
				question, "Question TxtBox");
		commonLib.selectDrpDownValue(mngQualificationScrPage.getDrpDownQuestionType(), questionType,
				"Question Type Dropdown");
		commonLib.typeText(mngQualificationScrPage.getTxtBoxInstruction(),
				instruction, "Instruction TxtBox");
		commonLib.click(mngQualificationScrPage.getBtnSaveQuestion(),
				"Save Question Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngQualificationScrPage
				.getErrorMessageQuestion())) {
			commonLib.logOnError("Add Question", "New question not added");
			return;
		} else {
			commonLib.logOnSuccess("Add Question",
					"New question added successfully");
		}

		commonLib.logOnInfo("Edit Question", "Editing newly created question");
		commonLib.click(mngQualificationScrPage.getLinkEditQuestion(),
				"Edit Question Link");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(mngQualificationScrPage.getTxtBoxQuestion())) {
			commonLib.logOnError("Edit Question",
					"Edit question page is not loaded");
			return;
		}
		commonLib.click(mngQualificationScrPage.getBtnSaveQuestion(),
				"Save Question Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngQualificationScrPage
				.getErrorMessageQuestion())) {
			commonLib.logOnError("Edit Question", "New question not edited");
			return;
		} else {
			commonLib.logOnSuccess("Edit Question",
					"New question edited successfully");
		}

		commonLib.logOnInfo("Delete Question",
				"Deleting newly created question");
		commonLib.click(mngQualificationScrPage.getLinkRemoveQuestion(),
				"Remove Question Link");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngQualificationScrPage
				.getMessageNoQuestionFound())) {
			commonLib.logOnSuccess("Delete Question",
					"Newly created question deleted");
		} else {
			commonLib.logOnError("Delete Question",
					"Newly created question not deleted");
		}

		commonLib.logOnInfo("Add Question from pool",
				"Adding new question form pool");
		commonLib.click(mngQualificationScrPage.getLinkAddQuestionFromPool(), "Add Question (From Pool) link");
		commonLib.waitForPageToLoad();
		if(commonLib.isDisplayed(mngQualificationScrPage.getLinkRemoveQuestion())) {
			commonLib.logOnSuccess("Add Question from pool",
					"New question is added form pool");
		} else {
			commonLib.logOnError("Add Question from pool",
					"New question is not added form pool");
			return;
		}

		commonLib.logOnInfo("Delete Question",
				"Deleting newly added question");
		commonLib.click(mngQualificationScrPage.getLinkRemoveQuestion(),
				"Remove Question Link");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngQualificationScrPage
				.getMessageNoQuestionFound())) {
			commonLib.logOnSuccess("Delete Question",
					"Newly added question deleted");
		} else {
			commonLib.logOnError("Delete Question",
					"Newly added question not deleted");
		}
	}

	public void deactivateQuestionSet(String userType, String district,
			String questionSet, String status) throws Exception {
		commonLib.logOnInfo("Deactivate Question Set",
				"Deactivating newly added question set");
		if (userType.equals("TM")) {
			navigateToQualificationScreenTM();
			commonLib.typeText(
					mngQualificationScrPage.getTxtBoxSearchDistrict(),
					district, "District TxtBox");
			Thread.sleep(2000);
			commonLib.click(
					mngQualificationScrPage.getFirstOptionSearchDistrict(),
					"First Option District");
		} else {
			navigateToQualificationScreenDA();
		}
		commonLib.typeText(
				mngQualificationScrPage.getTxtBoxSearchQuestionSet(),
				questionSet, "Question Set TxtBox");
		commonLib.selectDrpDownValue(
				mngQualificationScrPage.getDrpDownStatus(), status,
				"Status DropDown");
		commonLib.click(mngQualificationScrPage.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		Thread.sleep(10000);
		List<WebElement> columnQuestionSet = mngQualificationScrPage
				.getColumnQuestionSet();
		List<WebElement> columnDeactivateIcon = mngQualificationScrPage
				.getColumnDeactivateIcon();
		for (int i = 0; i < columnQuestionSet.size(); i++) {
			if (commonLib.getText(columnQuestionSet.get(i)).equals(questionSet)) {
				commonLib.click(columnDeactivateIcon.get(i), "Deactivate Icon");
				commonLib.waitForPageToLoad();
				commonLib.logOnSuccess("Deactivate Question Set",
						"Newly added question set deactivated");
				return;
			}
		}
		commonLib.logOnError("Deactivate Question Set",
				"Newly added question set is not deactivated");
	}
	
	public void deactivateQuestionSetDA(String userType, String district,
			String questionSet, String status) throws Exception {
		commonLib.logOnInfo("Deactivate Question Set",
				"Deactivating question set");
		if (userType.equals("TM")) {
			navigateToQualificationScreenTM();
		} else {
			navigateToQualificationScreenDA();
		}
		
			if (commonLib.getText(mngQualificationScrPage.getActivateLinkDA()).equals("Activate")) {
				
				commonLib.logOnSuccess("Deactivate Question Set",
						"Activate link is available");
				return;
			}
		
		commonLib.logOnError("Deactivate Question Set",
						"Activate link is available");
	}

}
