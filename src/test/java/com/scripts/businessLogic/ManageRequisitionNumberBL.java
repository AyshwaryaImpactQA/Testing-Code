package com.scripts.businessLogic;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ManageRequisitionNumberPL;

public class ManageRequisitionNumberBL extends Driver {

	ManageRequisitionNumberPL mngReqNoPage = PageFactory.initElements(driver,
			ManageRequisitionNumberPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void navigateToRequisitionNumberPageTM() throws Exception {
		commonLib.click(mngReqNoPage.getMenuManage(), "Manage Menu");
		//commonLib.waitForPageToLoad();
		commonLib.click(mngReqNoPage.getSubMenuRequisitionNumberTM(),
				"Requisition Number Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void navigateToRequisitionNumberPageDA() throws Exception {
		commonLib.click(mngReqNoPage.getMenuManage(), "Manage Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(mngReqNoPage.getSubMenuRequisitionNumberDA(),
				"Requisition Number Sub Menu");
		commonLib.waitForPageToLoad();
	}

	public void verifyMandatoryFields(String userType) throws Exception {
		commonLib.logOnInfo("Verify Mandatory Fields",
				"Adding req. no. without filling mandatory fields");
		if (userType.equals("TM")) {
			navigateToRequisitionNumberPageTM();
		} else {
			navigateToRequisitionNumberPageDA();
		}
		commonLib.click(mngReqNoPage.getLinkAddRequisitionNo(),
				"Add Req. no. link");
	//	commonLib.waitForPageToLoad();
		Thread.sleep(2000);
		if (!commonLib.isDisplayed(mngReqNoPage.getTxtBoxAddRequisitionNo())) {
			commonLib.logOnError("Verify Mandatory Fields",
					"Add requisition no. page is not loaded");
			return;
		}
		commonLib.click(mngReqNoPage.getBtnSaveRequisitionNo(),
				"Save Requisition No. Btn");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(mngReqNoPage.getErrorMessage())) {
			commonLib.logOnError("Verify Mandatory Fields",
					"Requisition no. is added");
		} else {
			commonLib
					.logOnSuccess("Verify Mandatory Fields",
							"Requisition no. can not be added without filling mandatory fields");
		}
	}

	public void addRequisitionNo(String userType, String district,
			String reqNo, String positionType, String location,
			String positionTitle) throws Exception {
		commonLib.logOnInfo("Add Requisition No",
				"Adding new requisition number");
		commonLib.click(mngReqNoPage.getLinkAddRequisitionNo(),
				"Add Req. no. link");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(mngReqNoPage.getTxtBoxAddRequisitionNo())) {
			commonLib.logOnError("Add Requisition No",
					"Add requisition no. page is not loaded");
			return;
		}
		if (userType.equals("TM")) {
			commonLib.typeText(mngReqNoPage.getTxtBoxAddDistrict(), district,
					"District TxtBox");
			Thread.sleep(2000);
			commonLib.click(mngReqNoPage.getFirstOptionAddDistrict(),
					"First District Option");
		}
		commonLib.typeText(mngReqNoPage.getTxtBoxAddRequisitionNo(), reqNo,
				"Requisition No TxtBox");
		commonLib.selectDrpDownValue(mngReqNoPage.getDrpDownPositionType(),
				positionType, "Position Type Dropdown");
		
	/*	commonLib.typeText(mngReqNoPage.getTxtBoxLocation(), location,"Location TxtBox");
		commonLib.typeText(mngReqNoPage.getTxtBoxPositionTitle(),positionTitle, "Position Title TxtBox");*/      //Not required in NC 
		
		commonLib.click(mngReqNoPage.getBtnSaveRequisitionNo(),
				"Save Requisition No Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngReqNoPage.getErrorMessage())) {
			commonLib.logOnError("Add Requisition No",
					"Requisition no. is not added");
		} else {
			commonLib.logOnSuccess("Add Requisition No",
					"Requisition no. is added successfully");
		}
	}

	public void searchRequisitionNo(String userType, String district,
			String reqNo) throws Exception {
		commonLib.logOnInfo("Search Requisition No",
				"Searching newly created requisition number");
		if (userType.equals("TM")) {
			commonLib.typeText(mngReqNoPage.getTxtBoxDistrictName(), district,
					"District TxtBox");
			Thread.sleep(2000);
			commonLib.click(mngReqNoPage.getFirstOptionDistrict(),
					"First Option District");
		}
		commonLib.typeText(mngReqNoPage.getTxtBoxReqNo(), reqNo,
				"Requisition No TxtBox");
		commonLib.click(mngReqNoPage.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		Thread.sleep(8000);
		List<WebElement> columnReqNo = mngReqNoPage.getColumnReqNo();
		for (WebElement no : columnReqNo) {
			if (commonLib.getText(no).equals(reqNo)) {
				commonLib.logOnSuccess("Search Requisition No",
						"Newly created req no. found");
				return;
			}
		}
		commonLib.logOnError("Search Requisition No",
				"Newly created req no. not found");
	}

	public void editRequisitionNo(String reqNo) throws Exception {
		boolean flag = false;
		commonLib.logOnInfo("Edit Requisition No",
				"Editing newly created requisition number");
		commonLib.waitForPageToLoad();
		List<WebElement> columnReqNo = mngReqNoPage.getColumnReqNo();
		List<WebElement> columnEditIcon = mngReqNoPage.getColumnEditIcon();
		for (int i = 0; i < columnReqNo.size(); i++) {
			if (commonLib.getText(columnReqNo.get(i)).equals(reqNo)) {
				commonLib.click(columnEditIcon.get(i), "Edit Icon");
				commonLib.waitForPageToLoad();
				flag = true;
				break;
			}
		}
		if (!flag) {
			commonLib.logOnError("Edit Requisition No",
					"Requisition no. not found");
			return;
		}
		if (!commonLib.isDisplayed(mngReqNoPage.getTxtBoxAddRequisitionNo())) {
			commonLib.logOnError("Edit Requisition No",
					"Edit requisition no. page is not loaded");
			return;
		}
		commonLib.click(mngReqNoPage.getBtnSaveRequisitionNo(),
				"Save Requisition No Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(mngReqNoPage.getErrorMessage())) {
			commonLib.logOnError("Edit Requisition No",
					"Requisition no. is not edited");
		} else {
			commonLib.logOnSuccess("Edit Requisition No",
					"Requisition no. is edited successfully");
		}
	}

	public void deleteRequisitionNo(String reqNo) throws Exception {
		boolean flag = false;
		commonLib.logOnInfo("Delete Requisition No",
				"Deleting newly created requisition number");
		commonLib.waitForPageToLoad();
		List<WebElement> columnReqNo = mngReqNoPage.getColumnReqNo();
		List<WebElement> columnDeleteIcon = mngReqNoPage.getColumnDeleteIcon();
		for (int i = 0; i < columnReqNo.size(); i++) {
			if (commonLib.getText(columnReqNo.get(i)).equals(reqNo)) {
				commonLib.click(columnDeleteIcon.get(i), "Delete Icon");
				commonLib.waitForPageToLoad();
				flag = true;
				break;
			}
		}
		if (!flag) {
			commonLib.logOnError("Delete Requisition No",
					"Requisition no. not found");
			return;
		}
		if (!commonLib.isDisplayed(mngReqNoPage.getNoRecordFoundMessage())) {
			commonLib.logOnError("Delete Requisition No",
					"Requisition no. is not deleted");
		} else {
			commonLib.logOnSuccess("Delete Requisition No",
					"Requisition no. is deleted successfully");
		}
	}

}
