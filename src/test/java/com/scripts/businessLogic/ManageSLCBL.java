package com.scripts.businessLogic;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ManageSLCPL;

public class ManageSLCBL extends Driver {

	ManageSLCPL mngSLCPage = PageFactory
			.initElements(driver, ManageSLCPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void navigateToManageSLCPage() throws Exception {
		commonLib.click(mngSLCPage.getMenuManage(), "Manage Menu");
		Thread.sleep(2000);
		commonLib.click(mngSLCPage.getSubMenuStatusLifeCycle(), "Sub Menu SLC");
		commonLib.waitForPageToLoad();
	}

	public void goToSLCForJobCategory(String district, String jobCategory)
			throws Exception {
		commonLib.typeText(mngSLCPage.getTxtBoxDistrict(), district,
				"District TxtBox");
		Thread.sleep(2000);
		commonLib.typeKeys(mngSLCPage.getTxtBoxDistrict(), Keys.DOWN);
		commonLib.typeKeys(mngSLCPage.getTxtBoxDistrict(), Keys.UP);
		commonLib.click(mngSLCPage.getFirstOptionDistrict(),
				"First Option District");
		Thread.sleep(5000);
		commonLib.selectDrpDownValue(mngSLCPage.getDrpDownJobCategory(),
				jobCategory, "Job Category Dropdown");
		commonLib.click(mngSLCPage.getBtnGo(), "Go Btn");
		commonLib.waitForPageToLoad();
	}

	public void createNode(String node) throws Exception {
		commonLib.logOnInfo("Create Node", "Creating new node");
		commonLib.click(mngSLCPage.getNodeScreen(), "Screen Node");
		commonLib.click(mngSLCPage.getIconCreate(), "Create Icon");
		commonLib.typeText(mngSLCPage.getTxtBoxNode(), node, "Node TxtBox");
		commonLib.typeKeys(mngSLCPage.getTxtBoxNode(), Keys.TAB);
		List<WebElement> subNodesScreen = mngSLCPage.getSubNodesScreen();
		for (WebElement temp : subNodesScreen) {
			if (commonLib.getText(temp).equals(node)) {
				commonLib.logOnSuccess("Create Node",
						"New node created successfully");
				return;
			}
		}
		commonLib.logOnError("Create Node", "New node not created");
	}

	public void renameNode(String oldNode, String node) throws Exception {
		commonLib.logOnInfo("Rename Node", "Renaming of new node");
		boolean flag = false;
		List<WebElement> subNodesScreen = mngSLCPage.getSubNodesScreen();
		for (WebElement temp : subNodesScreen) {
			if (commonLib.getText(temp).equals(oldNode)) {
				flag = true;
				commonLib.click(temp, "Node Link");
				commonLib.click(mngSLCPage.getIconRename(), "Rename Icon");
				commonLib.typeText(mngSLCPage.getTxtBoxNode(), node,
						"Node TxtBox");
				commonLib.typeKeys(mngSLCPage.getTxtBoxNode(), Keys.TAB);
				subNodesScreen = mngSLCPage.getSubNodesScreen();
				for (WebElement temp1 : subNodesScreen) {
					if (commonLib.getText(temp1).equals(node)) {
						commonLib.logOnSuccess("Rename Node",
								"Node is renamed successfully");
						return;
					}
				}
			}
		}
		if (!flag) {
			commonLib.logOnError("Rename Node", "Node not found");
		}
	}

	public void cutPasteNode(String node) throws Exception {
		commonLib.logOnInfo("Cut Node", "Moving the newly created node");
		boolean flag = false;
		List<WebElement> subNodesScreen = mngSLCPage.getSubNodesScreen();
		for (WebElement temp : subNodesScreen) {
			if (commonLib.getText(temp).equals(node)) {
				flag = true;
				commonLib.click(temp, "Node Link");
				commonLib.click(mngSLCPage.getIconCut(), "Cut Icon");
				commonLib.click(mngSLCPage.getNodeEvaluate(), "Evaluate Node");
				commonLib.click(mngSLCPage.getIconPaste(), "Paste Icon");
				List<WebElement> subNodesEvaluate = mngSLCPage
						.getSubNodesEvaluate();
				for (WebElement temp1 : subNodesEvaluate) {
					if (commonLib.getText(temp1).equals(node)) {
						commonLib.logOnSuccess("Cut Node",
								"Node is moved successfully");
						return;
					}
				}
				commonLib.logOnError("Cut Node", "Node is not moved");
			}
		}
		if (!flag) {
			commonLib.logOnError("Cut Node", "Node not found");
		}
	}

	public void copyPasteNode(String node) throws Exception {
		commonLib.logOnInfo("Copy Node", "Copying the newly created node");
		boolean flag = false;
		List<WebElement> subNodesEvaluate = mngSLCPage.getSubNodesEvaluate();
		for (WebElement temp : subNodesEvaluate) {
			if (commonLib.getText(temp).equals(node)) {
				flag = true;
				commonLib.click(temp, "Node Link");
				commonLib.click(mngSLCPage.getIconCopy(), "Copy Icon");
				commonLib.click(mngSLCPage.getNodeScreen(), "Screen Node");
				commonLib.click(mngSLCPage.getIconPaste(), "Paste Icon");
				commonLib.click(mngSLCPage.getNodeScreen(), "Screen Node");
				List<WebElement> subNodesScreen = mngSLCPage
						.getSubNodesScreen();
				for (WebElement temp1 : subNodesScreen) {
					if (commonLib.getText(temp1).equals("Copy of " + node)) {
						commonLib.logOnSuccess("Copy Node",
								"Node is copied successfully");
						return;
					}
				}
				commonLib.logOnError("Copy Node", "Node is not copied");
			}
		}
		if (!flag) {
			commonLib.logOnError("Copy Node", "Node not found");
		}
	}

	public void setAttributes(String node) throws Exception {
		commonLib.logOnInfo("Set Attributes",
				"Setting attributes for the newly created node");
		boolean flag = false;
		List<WebElement> subNodesScreen = mngSLCPage.getSubNodesScreen();
		for (WebElement temp : subNodesScreen) {
			if (commonLib.getText(temp).equals("Copy of " + node)) {
				flag = true;
				commonLib.click(temp, "Node Link");
				commonLib.click(mngSLCPage.getIconAttributes(),
						"Attributes Icon");
				break;
			}
		}
		if (!flag) {
			commonLib.logOnError("Set Attributes", "Node not found");
		} else {
			if (commonLib.isDisplayed(mngSLCPage.getAttributePage())) {
				commonLib.logOnSuccess("Set Attributes",
						"Setting attributes page appeared");
				commonLib.click(mngSLCPage.getBtnAttCancel(), "Cancel Btn");
			} else {
				commonLib.logOnError("Set Attributes",
						"Setting attributes page not appeared");
			}
		}
	}

	public void deleteNode(String node) throws Exception {
		commonLib.logOnInfo("Delete Node", "Deleting the newly created node");
		List<WebElement> subNodesScreen = mngSLCPage.getSubNodesScreen();
		for (WebElement temp : subNodesScreen) {
			if (commonLib.getText(temp).equals("Copy of " + node)) {
				commonLib.click(temp, "Node Link");
				commonLib.click(mngSLCPage.getIconDelete(), "Delete Icon");
				commonLib.waitForPageToLoad();
				commonLib.click(mngSLCPage.getBtnConfirmDelete(), "Ok Btn");
				commonLib.waitForPageToLoad();
				break;
			}
		}
		List<WebElement> subNodesEvaluate = mngSLCPage.getSubNodesEvaluate();
		for (WebElement temp : subNodesEvaluate) {
			if (commonLib.getText(temp).equals(node)) {
				commonLib.click(temp, "Node Link");
				commonLib.click(mngSLCPage.getIconDelete(), "Delete Icon");
				commonLib.waitForPageToLoad();
				commonLib.click(mngSLCPage.getBtnConfirmDelete(), "Ok Btn");
				commonLib.waitForPageToLoad();
				break;
			}
		}
		subNodesEvaluate = mngSLCPage.getSubNodesEvaluate();
		for (WebElement temp : subNodesEvaluate) {
			if (commonLib.getText(temp).equals(node)) {
				commonLib.logOnError("Delete Node", "Node is not deleted");
				return;
			}
		}
		commonLib.logOnSuccess("Delete Node", "Node is deleted successfully");
	}

}
