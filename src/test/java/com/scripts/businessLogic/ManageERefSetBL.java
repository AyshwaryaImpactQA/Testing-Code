package com.scripts.businessLogic;

import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ManageERefSetPL;

public class ManageERefSetBL extends Driver {

	ManageERefSetPL mngERefSetPage = PageFactory.initElements(driver,
			ManageERefSetPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void navigateToERefSetPageTM() throws Exception {
		commonLib.click(mngERefSetPage.getMenuManage(), "Manage Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(mngERefSetPage.getSubMenuERefSetTM(),
				"Sub Menu E-Reference Set");
		commonLib.waitForPageToLoad();
	}

	public void navigateToERefSetPageDA() throws Exception {
		commonLib.click(mngERefSetPage.getMenuManage(), "Manage Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(mngERefSetPage.getSubMenuERefSetDA(),
				"Sub Menu E-Reference Set");
		commonLib.waitForPageToLoad();
	}

	public void verifyMandatoryFields() throws Exception {
		commonLib.logOnInfo("Verify Mandatory Fields",
				"Adding new question set without filling mandatory fields");
		commonLib.waitForPageToLoad();
		commonLib.waitForPageToLoad();
		commonLib.waitForPageToLoad();
		commonLib.click(mngERefSetPage.getLinkAddQuestionSet(),
				"Add Question Set Link");
		commonLib.waitForPageToLoad();
		commonLib.click(mngERefSetPage.getBtnSave(), "Save Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngERefSetPage.getErrorMessage())) {
			commonLib.logOnSuccess("Verify Mandatory Fields",
					"New question set without mandatory fields is not added");
		} else {
			commonLib.logOnError("Verify Mandatory Fields",
					"New question set without mandatory fields is added");
		}
	}

	public void addQuestionSet(String userType, String district,
			String questionSet, String status) throws Exception {
		commonLib.logOnInfo("Add Question Set", "Adding new question Set");
		commonLib.click(mngERefSetPage.getLinkAddQuestionSet(),
				"Add Question Set Link");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(mngERefSetPage.getTxtBoxAddQuestionSet())) {
			commonLib.logOnError("Add Question Set",
					"Add question Set page is not loaded");
			return;
		}
		if (userType.equals("TM")) {
			commonLib.typeText(mngERefSetPage.getTxtBoxAddDistrict(), district,
					"District TxtBox");
			Thread.sleep(2000);
			commonLib.click(mngERefSetPage.getFirstOptionAddDistrict(),
					"First Option District");
		}
		commonLib.typeText(mngERefSetPage.getTxtBoxAddQuestionSet(),
				questionSet, "Question Set TxtBox");
		if (status.equals("Inactive")) {
			commonLib.click(mngERefSetPage.getRadioBtnInactive(),
					"Inactive Radio Btn");
		}
		commonLib.click(mngERefSetPage.getBtnSave(), "Save Btn");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(mngERefSetPage.getErrorMessage())) {
			commonLib.logOnSuccess("Add Question Set",
					"New question Set added successfully");
		} else {
			commonLib.logOnError("Add Question Set",
					"New question Set is not added");
		}
	}

	public void searchQuestionSet(String userType, String district,
			String questionSet) throws Exception {
		commonLib.logOnInfo("Search Question Set",
				"Searching newly added question Set");
		if (userType.equals("TM")) {
			commonLib.typeText(mngERefSetPage.getTxtBoxSearchDistrict(),
					district, "District TxtBox");
			Thread.sleep(2000);
			commonLib.click(mngERefSetPage.getFirstOptionSearchDistrict(),
					"First Option District");
		}
		commonLib.typeText(mngERefSetPage.getTxtBoxSearchQuestionSet(),
				questionSet, "Question Set TxtBox");
		commonLib.click(mngERefSetPage.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		Thread.sleep(20000);
		System.out.println("The newly added que. set is " +questionSet);
		
		if (commonLib.getText(mngERefSetPage.getColumnQuestionSetNameOption())
				.equals(questionSet)) {
			commonLib.logOnSuccess("Search Question Set",
					"Newly added question Set found");
		} else {
			commonLib.logOnError("Search Question Set",
					"Newly added question Set not found");
		}
	}

	public void editQuestionSet(String questionSet, String newQuestionSet)
			throws Exception {
		commonLib.logOnInfo("Edit Question Set",
				"Editing newly added question Set");
		
		if (commonLib.isDisplayed(mngERefSetPage.getColumnQuestionSetName())) {
			commonLib.click(mngERefSetPage.getColumnEditIcon(), "Edit Icon");
			commonLib.waitForPageToLoad();
		}
		if (!commonLib.isDisplayed(mngERefSetPage.getTxtBoxAddQuestionSet())) {
			commonLib.logOnError("Edit Question Set",
					"Edit question Set page is not loaded");
			return;
		}
		commonLib.typeText(mngERefSetPage.getTxtBoxAddQuestionSet(),
				newQuestionSet, "Question Set TxtBox");
		commonLib.click(mngERefSetPage.getBtnSave(), "Save Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngERefSetPage.getErrorMessage())) {
			commonLib.logOnError("Edit Question Set",
					"New question Set is not edited");
			return;
		}
		commonLib.typeText(mngERefSetPage.getTxtBoxSearchQuestionSet(),
				newQuestionSet, "Question Set TxtBox");
		commonLib.click(mngERefSetPage.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngERefSetPage.getColumnQuestionSetName())
				) {
			commonLib.logOnSuccess("Edit Question Set",
					"Newly added question Set edited");
		} else {
			commonLib.logOnError("Edit Question Set",
					"Newly added question Set not found");
		}
	}

	public void manageQuestions(String newQuestionSet, String question,
			String questionType, String questionMaxScore, String instruction)
			throws Exception {
		commonLib.logOnInfo("Add Question", "Adding question in the Set");
		if (!commonLib.getText(mngERefSetPage.getColumnQuestionSetName())
				.equals(newQuestionSet)) {
			commonLib.logOnError("Add Question", "Question Set not found");
			return;
		}
		commonLib.click(mngERefSetPage.getColumnLinkManageQuestions(),
				"Manage Questions Link");
		commonLib.waitForPageToLoad();
		commonLib.click(mngERefSetPage.getLinkAddQuestion(),
				"Add Question Link");
		commonLib.waitForPageToLoad();
		commonLib.typeText(mngERefSetPage.getTxtBoxQuestion(), question,
				"Question TxtBox");
		commonLib.selectDrpDownValue(mngERefSetPage.getDrpDownQuestionType(),
				questionType, "Question Type DrpDown");
		commonLib.typeText(mngERefSetPage.getTxtBoxQuestionMaxScore(),
				questionMaxScore, "Question Max Score TxtBox");
		commonLib.typeText(mngERefSetPage.getTxtBoxInstruction(), instruction,
				"Instruction TxtBox");
		commonLib.click(mngERefSetPage.getBtnSaveQuestion(), "Save Btn");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(mngERefSetPage.getErrorMessageAddQuestion())) {
			commonLib.logOnSuccess("Add Question",
					"New question added successfully");
		} else {
			commonLib.logOnError("Add Question", "New question is not added");
			return;
		}

		commonLib
				.logOnInfo("Remove Question", "Removing question from the Set");
		commonLib.click(mngERefSetPage.getLinkRemoveQuestion(), "Remove Link");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngERefSetPage.getMessageNoQuestionFound())) {
			commonLib.logOnSuccess("Remove Question",
					"Question is removed from the Set");
		} else {
			commonLib.logOnError("Remove Question",
					"Question is not removed from the Set");
			return;
		}

		commonLib.logOnInfo("Add Question from Panel",
				"Adding question from the panel");
		commonLib.click(mngERefSetPage.getLinkAddQuestionFromPanel(),
				"Add Question Link");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngERefSetPage.getLinkRemoveQuestion())) {
			commonLib.logOnSuccess("Add Question from Panel",
					"New question added from panel successfully");
		} else {
			commonLib.logOnError("Add Question from Panel",
					"New question from Panel is not added");
			return;
		}

		commonLib.logOnInfo("Remove Question added from Panel",
				"Removing question added from the panel from the Set");
		commonLib.click(mngERefSetPage.getLinkRemoveQuestion(), "Remove Link");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngERefSetPage.getMessageNoQuestionFound())) {
			commonLib.logOnSuccess("Remove Question from Panel",
					"Question is removed from the Set");
		} else {
			commonLib.logOnError("Remove Question from Panel",
					"Question is not removed from the Set");
			return;
		}
	}

	public void deactivateQuestionSet(String userType, String district,
			String newQuestionSet) throws Exception {
		commonLib.logOnInfo("Deactivate Question Set",
				"Deactivating newly added question set");
		
		if (commonLib.isDisplayed(mngERefSetPage.getLinkCancel())){
		commonLib.click(mngERefSetPage.getLinkCancel(), "Cancel Link");
		commonLib.waitForPageToLoad();
		
		}
		if (userType.equals("TM")) {
			commonLib.typeText(mngERefSetPage.getTxtBoxSearchDistrict(),
					district, "District TxtBox");
			Thread.sleep(2000);
			commonLib.click(mngERefSetPage.getFirstOptionSearchDistrict(),
					"First Option District");
		}
		commonLib.typeText(mngERefSetPage.getTxtBoxSearchQuestionSet(),
				newQuestionSet, "Question Set TxtBox");
		commonLib.click(mngERefSetPage.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		commonLib.waitForPageToLoad();
		commonLib.waitForPageToLoad();
		if (commonLib.getText(mngERefSetPage.getColumnQuestionSetNameOption())
				.equals(newQuestionSet)) {
			commonLib.click(mngERefSetPage.getColumnDeactivateIcon(), "Deactivate Icon");
			commonLib.waitForPageToLoad();
			Thread.sleep(10000);
		} else {
			commonLib.logOnError("Deactivate Question Set",
					"Newly added question Set not found");
			return;
		}
		if(commonLib.getText(mngERefSetPage.getColumnDeactivateIcon()).equals("Activate")) {
			commonLib.logOnSuccess("Deactivate Question Set",
					"Newly added question Set deactivated");
		} else {
			commonLib.logOnError("Deactivate Question Set",
					"Newly added question Set is not deactivated");
		}
	}

}
