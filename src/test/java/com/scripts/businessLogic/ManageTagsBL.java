package com.scripts.businessLogic;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ManageDistPrivilegePL;
import com.scripts.pageObjectRepository.ManageTagsPL;

public class ManageTagsBL extends Driver {

	ManageTagsPL mngTagsPage = PageFactory.initElements(driver,
			ManageTagsPL.class);
	ManageDistPrivilegePL mngDistPrivPage = PageFactory.initElements(driver,
			ManageDistPrivilegePL.class);
	CommonUtills commonLib = new CommonUtills();

	public void navigateToManageTagsTM() throws Exception {
		commonLib.click(mngTagsPage.getMenuManage(), "Manage Menu");
		Thread.sleep(1000);
		commonLib.click(mngTagsPage.getSubMenuTagsTM(), "Tags Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void navigateToManageTagsDA() throws Exception {
		commonLib.click(mngTagsPage.getMenuManage(), "Manage Menu");
		Thread.sleep(2000);
		commonLib.click(mngTagsPage.getSubMenuTagsDA(), "Tags Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void navigateToManageTagsSA() throws Exception {
		commonLib.click(mngTagsPage.getMenuManage(), "Manage Menu");
		Thread.sleep(2000);
		commonLib.click(mngTagsPage.getSubMenuTagsSA(), "Tags Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void verifyMandatoryFields(String userType) throws Exception {
		commonLib.logOnInfo("Verify Mandatory Fields",
				"Adding new tag without filling mandatory fields");
		if (userType.equals("TM")) {
			navigateToManageTagsTM();
		} else if (userType.equals("DA")) {
			navigateToManageTagsDA();
		} else if (userType.equals("SA")) {
			navigateToManageTagsSA();
		}
		commonLib.click(mngTagsPage.getLinkAddTag(), "Add Tag Link");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(mngTagsPage.getTxtBoxTagName())) {
			commonLib.logOnError("Verify Mandatory Fields",
					"Add tag page is not appeared");
			return;
		}
		commonLib.click(mngTagsPage.getBtnSave(), "Save Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngTagsPage.getErrorMessage())) {
			commonLib.logOnSuccess("Verify Mandatory Fields",
					"Tag can not be added without filling mandatory fields");
		} else {
			commonLib.logOnError("Verify Mandatory Fields",
					"Tag added successfully without filling mandatory fields");
		}
	}

	public void addTag(String district, String tagName) throws Exception {
		commonLib.logOnInfo("Add Tag", "Adding new tag");
		commonLib.click(mngTagsPage.getLinkAddTag(), "Add Tag Link");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(mngTagsPage.getTxtBoxTagName())) {
			commonLib.logOnError("Verify Mandatory Fields",
					"Add tag page is not appeared");
			return;
		}
		if (commonLib.isDisplayed(mngTagsPage.getTxtBoxAddDistrict())) {
			commonLib.typeText(mngTagsPage.getTxtBoxAddDistrict(), district,
					"District TxtBox");
			commonLib.typeKeys(mngTagsPage.getTxtBoxAddDistrict(), Keys.DOWN);
			commonLib.typeKeys(mngTagsPage.getTxtBoxAddDistrict(), Keys.UP);
		}
		commonLib.typeText(mngTagsPage.getTxtBoxTagName(), tagName,
				"Tag Name TxtBox");
		osName = System.getProperty("os.name");
		if (osName.contains("Windows")) {
			commonLib.typeText(mngTagsPage.getFileTagIcon(),
					System.getProperty("user.dir")
							+ "\\src\\test\\resources\\Event_Logo.png",
					"Upload Tag Icon");
		} else {
			commonLib.typeText(mngTagsPage.getFileTagIcon(),
					System.getProperty("user.dir")
							+ "/src/test/resources/Event_Logo.png",
					"Upload Tag Icon");
		}
		commonLib.waitForPageToLoad();
		commonLib.click(mngTagsPage.getBtnSave(), "Save Btn");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(mngTagsPage.getErrorMessage())) {
			commonLib.logOnSuccess("Add Tag", "Tag is added successfully");
		} else {
			commonLib.logOnError("Add Tag", "Tag is not added");
		}
	}

	public void searchTag(String district, String tagName) throws Exception {
		commonLib.logOnInfo("Search Tag", "Searching newly created tag");
		if (commonLib.isDisplayed(mngTagsPage.getDrpDownEntityType())) {
			commonLib.selectDrpDownValue(mngTagsPage.getDrpDownEntityType(),
					"District", "Entity Drpdown");
			commonLib.typeText(mngTagsPage.getTxtBoxSearchDistrict(), district,
					"District TxtBox");
			commonLib
					.typeKeys(mngTagsPage.getTxtBoxSearchDistrict(), Keys.DOWN);
			commonLib.typeKeys(mngTagsPage.getTxtBoxSearchDistrict(), Keys.UP);
			commonLib.click(mngTagsPage.getBtnSearch(), "Search Btn");
			commonLib.waitForPageToLoad();
		}
		List<WebElement> columnTagName = mngTagsPage.getColumnTagName();
		boolean flag = true;
		while (flag) {
			flag = commonLib.isDisplayed(mngTagsPage.getLinkNext());
			for (WebElement temp : columnTagName) {
				if (commonLib.getText(temp).equals(tagName)) {
					commonLib.click(temp, "Tag Name");
					commonLib.logOnSuccess("Search Tag",
							"Newly created tag found");
					return;
				}
			}
			if (commonLib.isDisplayed(mngTagsPage.getLinkNext())) {
				commonLib.click(mngTagsPage.getLinkNext(), "Next Link");
				commonLib.waitForPageToLoad();
			}
			columnTagName = mngTagsPage.getColumnTagName();
		}
		commonLib.logOnError("Search Tag", "Newly created tag not found");
	}

	public void editTag(String district, String tagName, String newTagName)
			throws Exception {
		commonLib.logOnInfo("Edit Tag", "Editing newly created tag");
		if (commonLib.isDisplayed(mngTagsPage.getDrpDownEntityType())) {
			commonLib.selectDrpDownValue(mngTagsPage.getDrpDownEntityType(),
					"District", "Entity Drpdown");
			commonLib.typeText(mngTagsPage.getTxtBoxSearchDistrict(), district,
					"District TxtBox");
			commonLib
					.typeKeys(mngTagsPage.getTxtBoxSearchDistrict(), Keys.DOWN);
			commonLib.typeKeys(mngTagsPage.getTxtBoxSearchDistrict(), Keys.UP);
			commonLib.click(mngTagsPage.getBtnSearch(), "Search Btn");
			commonLib.waitForPageToLoad();
		}
		List<WebElement> columnTagName = mngTagsPage.getColumnTagName();
		List<WebElement> columnEditIcon = mngTagsPage.getColumnEditIcon();
		boolean flag = true;
		while (flag) {
			flag = commonLib.isDisplayed(mngTagsPage.getLinkNext());
			for (int i = 0; i < columnTagName.size(); i++) {
				if (commonLib.getText(columnTagName.get(i)).equals(tagName)) {
					commonLib.click(columnEditIcon.get(i), "Edit Icon");
					commonLib.waitForPageToLoad();
					commonLib.typeText(mngTagsPage.getTxtBoxTagName(),
							newTagName, "Tag Name TxtBox");
					commonLib.click(mngTagsPage.getBtnSave(), "Save Btn");
					commonLib.waitForPageToLoad();
					if (!commonLib.isDisplayed(mngTagsPage.getErrorMessage())) {
						commonLib.logOnSuccess("Edit Tag",
								"Tag is edited successfully");
					} else {
						commonLib.logOnError("Edit Tag", "Tag is not edited");
					}
					return;
				}
			}
			if (commonLib.isDisplayed(mngTagsPage.getLinkNext())) {
				commonLib.click(mngTagsPage.getLinkNext(), "Next Link");
				commonLib.waitForPageToLoad();
			}
			columnTagName = mngTagsPage.getColumnTagName();
			columnEditIcon = mngTagsPage.getColumnEditIcon();
		}
		commonLib.logOnError("Edit Tag", "Newly created tag not found");
	}

	public void viewAttachment(String district, String tagName)
			throws Exception {
		commonLib.logOnInfo("View Attachment",
				"Viewing attahed file with the tag");
		if (commonLib.isDisplayed(mngTagsPage.getDrpDownEntityType())) {
			commonLib.selectDrpDownValue(mngTagsPage.getDrpDownEntityType(),
					"District", "Entity Drpdown");
			commonLib.typeText(mngTagsPage.getTxtBoxSearchDistrict(), district,
					"District TxtBox");
			commonLib
					.typeKeys(mngTagsPage.getTxtBoxSearchDistrict(), Keys.DOWN);
			commonLib.typeKeys(mngTagsPage.getTxtBoxSearchDistrict(), Keys.UP);
			commonLib.click(mngTagsPage.getBtnSearch(), "Search Btn");
			commonLib.waitForPageToLoad();
		}
		List<WebElement> columnTagName = mngTagsPage.getColumnTagName();
		List<WebElement> columnTagIcon = mngTagsPage.getColumnTagIcon();
		boolean flag = true;
		boolean flag1 = false;
		String parentWindow;
		while (flag) {
			flag = commonLib.isDisplayed(mngTagsPage.getLinkNext());
			for (int i = 0; i < columnTagName.size(); i++) {
				if (commonLib.getText(columnTagName.get(i)).equals(tagName)) {
					parentWindow = driver.getWindowHandle();
					commonLib.click(columnTagIcon.get(i), "Attachment Link");
					commonLib.waitForPageToLoad();
					Set<String> windowHandles = driver.getWindowHandles();
					for (String handle : windowHandles) {
						if (!handle.equals(parentWindow)) {
							driver.switchTo().window(handle);
							commonLib.waitForPageToLoad();
							flag1 = true;
							break;
						}
					}
					if (flag1) {
						commonLib.logOnSuccess("View Attachment",
								"Attahed file is opened successfully");
						driver.close();
						driver.switchTo().window(parentWindow);
					} else {
						commonLib.logOnError("View Attachment",
								"Attahed file is not opened");
					}
					return;
				}
			}
			if (commonLib.isDisplayed(mngTagsPage.getLinkNext())) {
				commonLib.click(mngTagsPage.getLinkNext(), "Next Link");
				commonLib.waitForPageToLoad();
			}
			columnTagName = mngTagsPage.getColumnTagName();
			columnTagIcon = mngTagsPage.getColumnTagIcon();
		}
		commonLib.logOnError("View Attachment", "Newly created tag not found");
	}

	public void deactivateTag(String district, String tagName) throws Exception {
		commonLib.logOnInfo("Deactivate Tag", "Deactivating newly created tag");
		if (commonLib.isDisplayed(mngTagsPage.getDrpDownEntityType())) {
			commonLib.selectDrpDownValue(mngTagsPage.getDrpDownEntityType(),
					"District", "Entity Drpdown");
			commonLib.typeText(mngTagsPage.getTxtBoxSearchDistrict(), district,
					"District TxtBox");
			commonLib
					.typeKeys(mngTagsPage.getTxtBoxSearchDistrict(), Keys.DOWN);
			commonLib.typeKeys(mngTagsPage.getTxtBoxSearchDistrict(), Keys.UP);
			commonLib.click(mngTagsPage.getBtnSearch(), "Search Btn");
			commonLib.waitForPageToLoad();
		}
		List<WebElement> columnTagName = mngTagsPage.getColumnTagName();
		List<WebElement> columnDeactivateIcon = mngTagsPage
				.getColumnActivateDeactivateIcon();
		boolean flag = true;
		while (flag) {
			flag = commonLib.isDisplayed(mngTagsPage.getLinkNext());
			for (int i = 0; i < columnTagName.size(); i++) {
				if (commonLib.getText(columnTagName.get(i)).equals(tagName)) {
					commonLib.click(columnDeactivateIcon.get(i),
							"Deactivate Icon");
					commonLib.waitForPageToLoad();
					Thread.sleep(3000);
					if (commonLib.getAttribute(columnDeactivateIcon.get(i),
							"title").equals("Activate")) {
						commonLib.logOnSuccess("Deactivate Tag",
								"Tag is deactivated successfully");
					} else {
						commonLib.logOnError("Deactivate Tag",
								"Tag is not deactivated");
					}
					return;
				}
			}
			if (commonLib.isDisplayed(mngTagsPage.getLinkNext())) {
				commonLib.click(mngTagsPage.getLinkNext(), "Next Link");
				commonLib.waitForPageToLoad();
			}
			columnTagName = mngTagsPage.getColumnTagName();
			columnDeactivateIcon = mngTagsPage
					.getColumnActivateDeactivateIcon();
		}
		commonLib.logOnError("Deactivate Tag", "Newly created tag not found");
	}

	public void navigateToManageDistrictTM() throws Exception {
		commonLib.click(mngDistPrivPage.getMenuManage(), "Manage Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(mngDistPrivPage.getSubMenuDistrictTM(),
				"District Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void navigateToManageSchoolPrivilege(String district)
			throws Exception {
		navigateToManageDistrictTM();
		commonLib.typeText(mngDistPrivPage.getTxtBxDstrctName(), district,
				"District TxtBox");
		commonLib.typeKeys(mngDistPrivPage.getTxtBxDstrctName(), Keys.DOWN);
		commonLib.typeKeys(mngDistPrivPage.getTxtBxDstrctName(), Keys.UP);
		commonLib.click(mngDistPrivPage.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		commonLib.click(mngDistPrivPage.getBtnEditDstrct(), "Edit Icon");
		commonLib.waitForPageToLoad();
		if (commonLib.getAttribute(
				mngTagsPage.getAccordionPrivilegeForSchool(), "class")
				.contains("plus")) {
			commonLib.click(mngTagsPage.getAccordionPrivilegeForSchool(),
					"Privilege For District Accordion");
			commonLib.waitForPageToLoad();
		}
	}

	public void saveDistrict() throws Exception {
		commonLib.click(mngDistPrivPage.getBtnSaveDistrict(),
				"Save District Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngDistPrivPage.getBtnYes())) {
			commonLib.click(mngDistPrivPage.getBtnYes(), "Yes Btn");
			commonLib.waitForPageToLoad();
		}
		commonLib.click(mngDistPrivPage.getBtnClose(), "Close Btn");
	}

	public void manageTagsSettingsSA(String district) throws Exception {
		commonLib.logOnInfo("Set School Privilege for Tags",
				"Setting school privileges for tags");
		navigateToManageSchoolPrivilege(district);
		boolean flag1, flag2, flag3;
		flag1 = flag2 = flag3 = false;
		if (!commonLib.isSelected(mngTagsPage.getChkBoxCreateTag())) {
			commonLib.click(mngTagsPage.getChkBoxCreateTag(),
					"Create Tag Chk Box");
			flag1 = true;
		}
		if (!commonLib.isSelected(mngTagsPage.getChkBoxEditTag())) {
			commonLib.click(mngTagsPage.getChkBoxEditTag(), "Edit Tag Chk Box");
			flag2 = true;
		}
		if (!commonLib.isSelected(mngTagsPage.getChkBoxActivateDeactivateTag())) {
			commonLib.click(mngTagsPage.getChkBoxActivateDeactivateTag(),
					"Activate/Deactivate Tag Chk Box");
			flag3 = true;
		}
		if (flag1 || flag2 || flag3) {
			saveDistrict();
		}
		commonLib.logOnSuccess("Set School Privilege for Tags",
				"School privileges setup for tags done");
	}
}
