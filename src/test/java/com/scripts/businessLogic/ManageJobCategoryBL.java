package com.scripts.businessLogic;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ManageJobCategoryPL;

public class ManageJobCategoryBL extends Driver {

	ManageJobCategoryPL mngJobCategoryPage = PageFactory.initElements(driver,
			ManageJobCategoryPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void navigateToManageJobCategoryPage() throws Exception {
		commonLib.click(mngJobCategoryPage.getMenuManage(), "Manage Menu");
		Thread.sleep(2000);
		commonLib.click(mngJobCategoryPage.getSubManuJobCategory(),
				"Job Category Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void addJobCategory(String district, String jobCategoryName)
			throws Exception {
		commonLib.logOnInfo("Add Job Category", "Adding new job category");
		commonLib.click(mngJobCategoryPage.getLinkAddJobCategory(),
				"Add Job Category Link");
		Thread.sleep(3000);
		commonLib.typeText(mngJobCategoryPage.getTxtBoxAddDistrict(), district,
				"District TxtBox");
		Thread.sleep(2000);
		commonLib.click(mngJobCategoryPage.getFirstOptionAddDistrict(),
				"First Option District");
		
		
		
		
		commonLib.typeText(mngJobCategoryPage.getTxtBoxJobCategory(),
				jobCategoryName, "Job Category TxtBox");
		commonLib.click(mngJobCategoryPage.getBtnSave(), "Save Btn");
		Thread.sleep(2000);
		if (commonLib.isDisplayed(mngJobCategoryPage.getErrorMessage())) {
			commonLib.logOnError("Add Job Category",
					"New job category is not added");
		} else {
			commonLib.logOnSuccess("Add Job Category",
					"New job category added successfully");
		}
	}

	public void editJobCategory(String district, String entityType,
			String jobCategoryName, String newJobCategoryName) throws Exception {
		boolean flag = false;
		commonLib.logOnInfo("Edit Job Category",
				"Searching newly added job category");
		commonLib.selectDrpDownValue(mngJobCategoryPage.getDrpDownEntityType(),
				entityType, "Entity Type Drpdown");
		commonLib.typeText(mngJobCategoryPage.getTxtBoxSearchDistrict(),
				district, "District TxtBox");
		//Thread.sleep(2000);
		commonLib.click(mngJobCategoryPage.getFirstOptionSearchDistrict(),
				"First Option District");

		commonLib.click(mngJobCategoryPage.getBtnSearch(), "Search Btn");
		Thread.sleep(5000);
		commonLib.selectDrpDownValue(mngJobCategoryPage.getDrpDownPageSize(),
				"100", "Page Size Drpdown");
		Thread.sleep(2000);
		List<WebElement> columnJobCategoryName = mngJobCategoryPage
				.getColumnJobCategoryName();
		List<WebElement> columnIconEdit = mngJobCategoryPage
				.getColumnIconEdit();
		for (int i = 0; i < columnJobCategoryName.size(); i++) {
			if (commonLib.getText(columnJobCategoryName.get(i)).equals(
					jobCategoryName)) {
				commonLib.click(columnIconEdit.get(i), "Edit Icon");
				flag = true;
				commonLib.waitForPageToLoad();
				Thread.sleep(3000);
				break;
			}
		}
		if (!flag) {
			commonLib.logOnError("Edit Job Category", "Job Category not found");
			return;
		}
		commonLib.typeText(mngJobCategoryPage.getTxtBoxJobCategory(),
				newJobCategoryName, "Job Category TxtBox");
		commonLib.click(mngJobCategoryPage.getBtnSave(), "Save Btn");
		Thread.sleep(5000);
		if (commonLib.isDisplayed(mngJobCategoryPage.getErrorMessage())) {
			commonLib.logOnError("Edit Job Category",
					"New job category is not edited");
		} else {
			commonLib.logOnSuccess("Edit Job Category",
					"New job category edited successfully");
		}
	}

	public void showHistoryForJobCategory(String jobCategoryName)
			throws Exception {
		boolean flag = false;
		commonLib.logOnInfo("Show History for Job Category",
				"Showing history of job category");
		List<WebElement> columnJobCategoryName = mngJobCategoryPage
				.getColumnJobCategoryName();
		List<WebElement> columnIconShowHistory = mngJobCategoryPage
				.getColumnIconShowHistory();
		for (int i = 0; i < columnJobCategoryName.size(); i++) {
			if (commonLib.getText(columnJobCategoryName.get(i)).equals(
					jobCategoryName)) {
				commonLib.click(columnIconShowHistory.get(i),
						"Show History Icon");
				flag = true;
				Thread.sleep(3000);
				break;
			}
		}
		if (!flag) {
			commonLib.logOnError("Show History for Job Category",
					"Job Category not found");
			return;
		}
		if (commonLib.isDisplayed(mngJobCategoryPage.getPopupShowHistory())) {
			commonLib.logOnSuccess("Show History for Job Category",
					"History popup for job category loaded");
			commonLib.click(mngJobCategoryPage.getBtnClosePopupShowHistory(),
					"Close Btn");
			Thread.sleep(2000);
		} else {
			commonLib.logOnError("Show History for Job Category",
					"History popup for job category not loaded");
		}
	}

	public void deactivateJobCategory(String jobCategoryName) throws Exception {
		boolean flag = false;
		int i = 0;
		commonLib.logOnInfo("Deactivate Job Category",
				"Deactivating newly added job category");
		List<WebElement> columnJobCategoryName = mngJobCategoryPage
				.getColumnJobCategoryName();
		List<WebElement> columnIconDeactivate = mngJobCategoryPage
				.getColumnIconDeactivate();
		for (i = 0; i < columnJobCategoryName.size(); i++) {
			if (commonLib.getText(columnJobCategoryName.get(i)).equals(
					jobCategoryName)) {
				commonLib.click(columnIconDeactivate.get(i), "Deactivate Icon");
				flag = true;
				Thread.sleep(5000);
				break;
			}
		}
		if (!flag) {
			commonLib.logOnError("Deactivate Job Category",
					"Job Category not found");
			return;
		}
		if (commonLib.getAttribute(columnIconDeactivate.get(i), "title")
				.equals("Activate")) {
			commonLib.logOnSuccess("Deactivate Job Category",
					"Newly added job category deactivated");
		} else {
			commonLib.logOnError("Deactivate Job Category",
					"Newly added job category not deactivated");
		}
	}
}
