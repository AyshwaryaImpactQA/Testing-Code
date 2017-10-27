package com.scripts.businessLogic;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ManageDistrictAccountInformationPL;

import utils.load.dataSource.ExcelLib;

public class ManageDistrictAccountInformationBL extends Driver {

	ManageDistrictAccountInformationPL mngDistPrivPage = PageFactory.initElements(driver,
			ManageDistrictAccountInformationPL.class);

	CommonUtills commonLib = new CommonUtills();
	LoginBL loginLib = new LoginBL();
	ExcelLib excelData = new ExcelLib();

	JavascriptExecutor js = ((JavascriptExecutor) driver);
	Random randomGenerator = new Random();

	public void navigateToManageDistrictTM() throws Exception {
		commonLib.click(mngDistPrivPage.getMenuManage(), "Manage Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(mngDistPrivPage.getSubMenuDistrictTM(), "District Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void navigateToManageDistrictDA() throws Exception {
		commonLib.click(mngDistPrivPage.getMenuManage(), "Manage Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(mngDistPrivPage.getSubMenuDistrictDA(), "District Sub Menu");
		commonLib.waitForPageToLoad();

	}

	public void navigateToManageDistrictPrivilege(String userType, String district) throws Exception {
		if (userType.equals("TM")) {
			navigateToManageDistrictTM();
			commonLib.typeText(mngDistPrivPage.getTxtBxDstrctName(), district, "District TxtBox");
			commonLib.typeKeys(mngDistPrivPage.getTxtBxDstrctName(), Keys.DOWN);
			commonLib.typeKeys(mngDistPrivPage.getTxtBxDstrctName(), Keys.UP);
			commonLib.click(mngDistPrivPage.getBtnSearch(), "Search Btn");
			commonLib.waitForPageToLoad();
		} else {
			navigateToManageDistrictDA();
		}
		commonLib.click(mngDistPrivPage.getBtnEditDstrct(), "Edit Icon");
		commonLib.waitForPageToLoad();
		if (commonLib.getAttribute(mngDistPrivPage.getAccordionPrivilegeForDistrict(), "class").contains("plus")) {
			commonLib.click(mngDistPrivPage.getAccordionPrivilegeForDistrict(), "Privilege For District Accordion");
			commonLib.waitForPageToLoad();
		}
	}

	public void searchDistrict(String district) throws Exception {
		commonLib.logOnInfo("Search District", "Searching distict with name '" + district + "'");
		commonLib.typeText(mngDistPrivPage.getTxtBxDstrctName(), district, "District TxtBox");
		commonLib.typeKeys(mngDistPrivPage.getTxtBxDstrctName(), Keys.DOWN);
		commonLib.typeKeys(mngDistPrivPage.getTxtBxDstrctName(), Keys.UP);
		commonLib.click(mngDistPrivPage.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngDistPrivPage.getMessageNoRecordFound())) {
			commonLib.logOnError("Search District", "District with name '" + district + "' not found");
		} else {
			commonLib.logOnSuccess("Search District", "District with name '" + district + "' found");
		}
	}

	public void editDistrict(String district) throws Exception {
		commonLib.logOnInfo("Edit District", "Editing distict with name '" + district + "'");
		commonLib.click(mngDistPrivPage.getBtnEditDstrct(), "Edit Icon");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngDistPrivPage.getHeadingEditDistrict())) {
			commonLib.logOnSuccess("Edit District", "Edit district page is loaded successfully");
		} else {
			commonLib.logOnError("Edit District", "Edit district page is not loaded");
		}
	}

	/**
	 * @throws InterruptedException
	 * 
	 */
	public void selectHRIntegrated() throws InterruptedException {
		// TODO Auto-generated method stub
		commonLib.click(mngDistPrivPage.getAccordionAccountInformation(), "Accordion Account Information");
		commonLib.waitForPageToLoad();
		if (!commonLib.isSelected(mngDistPrivPage.getChkBoxNCIntegrated(), "CheckBox NC Integrated")) {
			commonLib.click(mngDistPrivPage.getChkBoxNCIntegrated(), "CheckBox NC Integrated");
		}
		commonLib.waitForPageToLoad();
		if (!commonLib.isSelected(mngDistPrivPage.getRadioBtnHRIntegrated(), "Radio Btn HRIntegrated")) {
			commonLib.click(mngDistPrivPage.getRadioBtnHRIntegrated(), "Radio Btn HRIntegrated");
		}
		commonLib.click(mngDistPrivPage.getBtnSaveDistrict(), "Btn Save District");
		commonLib.waitForPageToLoad();
		commonLib.click(mngDistPrivPage.getBtnClose(), "Btn Close");
		commonLib.waitForPageToLoad();
	}

	/**
	 * @throws InterruptedException
	 * 
	 */
	public void verifyHRIntegratedCheck() throws InterruptedException {
		// TODO Auto-generated method stub
		commonLib.logOnInfo("NC HR Integarted",
				"Verifying that when 'HR Integrated' is checked, user is not allowed to create District Job Orders");
		if (!commonLib.isDisplayed(mngDistPrivPage.getLinkAddJobOrder())) {
			commonLib.logOnSuccess("NC HR Integarted",
					"Job Order Link is not visible, user is not allowed to create District Job Orders");
		} else {
			commonLib.logOnError("NC HR Integarted",
					"Job Order Link is visible, user is allowed to create District Job Orders");
		}
	}
	
	/**
	 * @throws InterruptedException
	 * 
	 */
	public void verifyHRIntegratedUnCheck() throws InterruptedException {
		// TODO Auto-generated method stub
		commonLib.logOnInfo("NC HR Integarted",
				"Verifying that when 'HR Integrated' is Unchecked, user is allowed to create District Job Orders");
		if (commonLib.isDisplayed(mngDistPrivPage.getLinkAddJobOrder())) {
			commonLib.logOnSuccess("NC HR Integarted",
					"Job Order Link is visible, user is allowed to create District Job Orders");
		} else {
			commonLib.logOnError("NC HR Integarted",
					"Job Order Link is not visible, user is not allowed to create District Job Orders");
		}
	}

	/**
	 * @throws InterruptedException 
	 * 
	 */
	public void selectLINQIntegrated() throws InterruptedException {
		// TODO Auto-generated method stub
		commonLib.click(mngDistPrivPage.getAccordionAccountInformation(), "Accordion Account Information");
		commonLib.waitForPageToLoad();
		if (!commonLib.isSelected(mngDistPrivPage.getChkBoxNCIntegrated(), "CheckBox NC Integrated")) {
			commonLib.click(mngDistPrivPage.getChkBoxNCIntegrated(), "CheckBox NC Integrated");
		}
		commonLib.waitForPageToLoad();
		if (!commonLib.isSelected(mngDistPrivPage.getRadioBtnlinqIntegrated(), "Radio Btn linqIntegrated")) {
			commonLib.click(mngDistPrivPage.getRadioBtnlinqIntegrated(), "Radio Btn linqIntegrated");
		}
		commonLib.click(mngDistPrivPage.getBtnSaveDistrict(), "Btn Save District");
		commonLib.waitForPageToLoad();
		commonLib.click(mngDistPrivPage.getBtnClose(), "Btn Close");
		commonLib.waitForPageToLoad();
	}
}