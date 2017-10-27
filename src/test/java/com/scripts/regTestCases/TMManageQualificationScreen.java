package com.scripts.regTestCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageQualificationScreenBL;
import com.scripts.lib.commonFunction.Driver;

public class TMManageQualificationScreen extends Driver {

	LoginBL loginLib;
	ManageQualificationScreenBL mngQualificationScrLib;
	ExcelLib excelData;
	Random randomGenerator;
	String username, password, userType, district, questionSet, status,
			question, questionType, instruction;

	@BeforeClass
	public void configClass() throws Exception {
		loginLib = new LoginBL();
		mngQualificationScrLib = new ManageQualificationScreenBL();
		excelData = new ExcelLib();
		randomGenerator = new Random();
		excelData.setExcelData("Qualification_Screen", 1, 5, "AutoQuestionSet"
				+ randomGenerator.nextInt(99999));
		excelData.setExcelData("Qualification_Screen", 1, 7, "AutoQuestion"
				+ randomGenerator.nextInt(99999));
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 4);
		userType = excelData.getExcelData("Login", 1, 5);
		reports.startTest("Manage Qualification Screen with TM Admin");
		loginLib.login(username, password, userType);
	}

	@Test(priority = 1)
	public void addQuestionSet() throws Exception {
		
		district = excelData.getExcelData("Qualification_Screen", 1, 4);
		questionSet = excelData.getExcelData("Qualification_Screen", 1, 5);
		status = excelData.getExcelData("Qualification_Screen", 1, 6);
		mngQualificationScrLib.addQuestionSet(userType, district, questionSet,
				status);
	}

	@Test(priority = 2)
	public void searchQuestionSet() throws Exception {
		//userType = excelData.getExcelData("Login", 1, 3);
		district = excelData.getExcelData("Qualification_Screen", 1, 4);
		questionSet = excelData.getExcelData("Qualification_Screen", 1, 5);
		status = excelData.getExcelData("Qualification_Screen", 1, 6);
		mngQualificationScrLib.searchQuestionSet(userType, district,
				questionSet, status);
	}

	@Test(priority = 3)
	public void editQuestionSet() throws Exception {
		questionSet = excelData.getExcelData("Qualification_Screen", 1, 5);
		mngQualificationScrLib.editQuestionSet(questionSet);
	}

	@Test(priority = 4)
	public void manageQuestions() throws Exception {
		questionSet = excelData.getExcelData("Qualification_Screen", 1, 5);
		question = excelData.getExcelData("Qualification_Screen", 1, 7);
		questionType = excelData.getExcelData("Qualification_Screen", 1, 8);
		instruction = excelData.getExcelData("Qualification_Screen", 1, 9);
		mngQualificationScrLib.manageQuestions(questionSet, question,
				questionType, instruction);
	}

	@Test(priority = 5)
	public void deactivateQuestionSet() throws Exception {
		//userType = excelData.getExcelData("Login", 1, 3);
		district = excelData.getExcelData("Qualification_Screen", 1, 4);
		questionSet = excelData.getExcelData("Qualification_Screen", 1, 5);
		status = excelData.getExcelData("Qualification_Screen", 1, 6);
		mngQualificationScrLib.deactivateQuestionSet(userType, district,
				questionSet, status);
	}
	
	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}
}
