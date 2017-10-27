package com.scripts.businessLogic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ManageCommunicationPL;

import utils.screenshot.Test_Utils;

public class ManagaeCommunicationBL extends Driver {
	Test_Utils screenLib = new Test_Utils();
	ManageCommunicationPL mngCommunication = PageFactory.initElements(driver,
			ManageCommunicationPL.class);
	CommonUtills commonLib = new CommonUtills();
	LoginBL loginBL = new LoginBL();
	public String templateName = null;
	List<WebElement> templtNameList = null;
	public static ArrayList<String> toBeVerifiedTmpltNameList = new ArrayList<String>();
	boolean flag = true;

	public void navigateToCommunication() throws Exception {
		commonLib.click(mngCommunication.getMenuManage(), "Manage Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(mngCommunication.getSubMenuCommunication(),
				"Communication Menu");
	}

	public void searchTemplates(String userType, String districtName,
			String tmpltType) throws Exception {
		commonLib.logOnInfo("Search Template", "Search the " + tmpltType
				+ " template");
		if (userType.equalsIgnoreCase("TM")) {
			commonLib.typeText(mngCommunication.getTxtBxDistrictName(),
					districtName, "District Text Box");
			Thread.sleep(2000);
			commonLib.click(mngCommunication.getRsltDrpDnDistrict(),
					"First from list");
		}
		commonLib.selectDrpDownValue(mngCommunication.getDrpdnTmltType(),
				tmpltType, "Template Type");
		commonLib.click(mngCommunication.getBtnSearch(), "Search Button");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngCommunication.getBtnEdit(), "Edit button")) {
			commonLib.logOnSuccess("Search Template",
					"Template found with district " + districtName + " and "
							+ tmpltType);
		} else {
			commonLib.logOnError("Search Template",
					"Template not found with district " + districtName
							+ " and " + tmpltType);
		}
	}

	public void editCommunicationTemplate() throws Exception {
		commonLib.click(mngCommunication.getBtnEdit(), "Edit button");
		templateName = commonLib.getText(
				mngCommunication.getTxtBxTemplateName(), "Template Name");
	}

	public void addCommunicationTemplate(String tmpltName, String tmpltSubj,
			String tmpltBody) throws Exception {
		commonLib.logOnInfo("Add Template", "Adding new template");
		flag = true;
		commonLib.click(mngCommunication.getBtnAddTemplate(),
				"Add Template Link");
		commonLib.typeText(mngCommunication.getTxtBxTemplateName(), tmpltName,
				"Template Name text box");
		if (commonLib.isDisplayed(mngCommunication.getTxtBxSubject())) {
			commonLib.typeText(mngCommunication.getTxtBxSubject(), tmpltSubj,
					"Subject text box");
		}
		commonLib.typeText(mngCommunication.getTxtBxTemplateBody(), tmpltBody,
				"Template Body text box");
		commonLib.click(mngCommunication.getBtnSaveNwTmplt(),
				"Save Template button");
		commonLib.waitForPageToLoad();
		Thread.sleep(3000);

		while (flag) {
			mngCommunication = PageFactory.initElements(driver,
					ManageCommunicationPL.class);
			templtNameList = mngCommunication.getRsltTmpltName();
			for (WebElement tmpltNameRow : templtNameList) {
				if (tmpltNameRow.getText().equals(tmpltName)) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				break;
			} else {
				flag = commonLib.isDisplayed(mngCommunication.getBtnLast());
				if (flag) {
					commonLib.click(mngCommunication.getBtnNext(), "Next Btn");
					commonLib.waitForPageToLoad();
				}
			}
		}
		if (!flag) {
			commonLib.logOnSuccess("Add Template",
					"New template has been created");
		} else {
			commonLib.logOnError("Add Template", "Can not create new Template");
		}
		if (commonLib.isDisplayed(mngCommunication.getLinkFirst())) {
			commonLib.click(mngCommunication.getLinkFirst(), "First Page Link");
			commonLib.waitForPageToLoad();
		}
	}
}
