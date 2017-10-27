package com.scripts.regTestCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManagaeCommunicationBL;
import com.scripts.lib.commonFunction.Driver;

import utils.load.dataSource.ExcelLib;

public class TMManageCommunication extends Driver {
	ManagaeCommunicationBL mngCommLib;
	ExcelLib excelData;
	String loginUsername, loginPassword, loginUserType, districtName,
			tmpltType, tmpltTypeEvent, tmpltTypeFacil, tmpltTypePart,
			tmpltTypeStatus, tmpltName, tmpltSubj, tmpltBody;
	Random randomGenerator = new Random();
	LoginBL loginBL;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		excelData = new ExcelLib();
		loginBL = new LoginBL();
		mngCommLib = new ManagaeCommunicationBL();
		tmpltName = "AutoGenTmpltName" + randomGenerator.nextInt(99999);
		tmpltSubj = "AutoGenSubj" + randomGenerator.nextInt(99999);
		tmpltBody = "AutoGenTempltBody" + randomGenerator.nextInt(99999);
		for (int i = 1; i < 6; i++) {
			excelData.setExcelData("Communication", i, 6, tmpltName);
			excelData.setExcelData("Communication", i, 7, tmpltSubj);
			excelData.setExcelData("Communication", i, 8, tmpltBody);
		}
		loginUsername = excelData.getExcelData("Login", 1, 1);
		loginPassword = excelData.getExcelData("Login", 1, 4);
		loginUserType = excelData.getExcelData("Login", 1, 5);
		reports.startTest("Manage Commumication by TM Admin");
		loginBL.login(loginUsername, loginPassword, loginUserType);
	}

	//@Test(priority = 1)
	@Test
	public void searchAddCommunication() throws Exception {
		districtName = excelData.getExcelData("Communication", 1, 4);
		tmpltType = excelData.getExcelData("Communication", 1, 5);
		tmpltTypeEvent = excelData.getExcelData("Communication", 2, 5);
		tmpltTypeFacil = excelData.getExcelData("Communication", 3, 5);
		tmpltTypePart = excelData.getExcelData("Communication", 4, 5);
		tmpltTypeStatus = excelData.getExcelData("Communication", 5, 5);
		tmpltName = excelData.getExcelData("Communication", 1, 6);
		tmpltSubj = excelData.getExcelData("Communication", 1, 7);
		tmpltBody = excelData.getExcelData("Communication", 1, 8);
		mngCommLib.navigateToCommunication();
		mngCommLib.searchTemplates(loginUserType, districtName, tmpltType);
		mngCommLib.addCommunicationTemplate(tmpltName, tmpltSubj, tmpltBody);
		mngCommLib.searchTemplates(loginUserType, districtName, tmpltTypeEvent);
		mngCommLib.addCommunicationTemplate(tmpltName, tmpltSubj, tmpltBody);
		mngCommLib.searchTemplates(loginUserType, districtName, tmpltTypeFacil);
		mngCommLib.addCommunicationTemplate(tmpltName, tmpltSubj, tmpltBody);
		mngCommLib.searchTemplates(loginUserType, districtName, tmpltTypePart);
		mngCommLib.addCommunicationTemplate(tmpltName, tmpltSubj, tmpltBody);
	}

	@AfterClass
	public void logout() throws Exception {
		loginBL.logout();
	}
}
