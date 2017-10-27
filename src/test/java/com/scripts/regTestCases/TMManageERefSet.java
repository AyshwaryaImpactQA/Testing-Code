package com.scripts.regTestCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageERefSetBL;
import com.scripts.lib.commonFunction.Driver;

public class TMManageERefSet extends Driver {

	LoginBL loginLib;
	ManageERefSetBL mngERefSetLib;
	ExcelLib excelData;
	Random randomGenerator;
	String username, password, userType, district, questionSet, status,
			newQuestionSet, question, questionType, questionMaxScore,
			instruction;

	@BeforeClass
	public void configClass() throws Exception {
		loginLib = new LoginBL();
		mngERefSetLib = new ManageERefSetBL();
		excelData = new ExcelLib();
		randomGenerator = new Random();
		excelData.setExcelData("ERefSet", 1, 5, "AutoQuestionSet"
				+ randomGenerator.nextInt(99999));
		excelData.setExcelData("ERefSet", 1, 7, "AutoQuestion"
				+ randomGenerator.nextInt(99999));
		excelData.setExcelData("ERefSet", 1, 10, "AutoInstruction"
				+ randomGenerator.nextInt(99999));
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 4);
		userType = excelData.getExcelData("Login", 1, 5);
		reports.startTest("Manage E-Reference Set with TM Admin");
		loginLib.login(username, password, userType);
		mngERefSetLib.navigateToERefSetPageTM();
	}

	//@Test(priority = 1)
	@Test
	public void verifyMandatoryFields() throws Exception {
		mngERefSetLib.verifyMandatoryFields();
		
		userType = excelData.getExcelData("Login", 1, 5);
		district = excelData.getExcelData("ERefSet", 1, 4);
		questionSet = excelData.getExcelData("ERefSet", 1, 5);
		status = excelData.getExcelData("ERefSet", 1, 6);
		mngERefSetLib.addQuestionSet(userType, district, questionSet, status);
		
		userType = excelData.getExcelData("Login", 1, 5);
		district = excelData.getExcelData("ERefSet", 1, 4);
		questionSet = excelData.getExcelData("ERefSet", 1, 5);
		mngERefSetLib.searchQuestionSet(userType, district, questionSet);
		
		questionSet = excelData.getExcelData("ERefSet", 1, 5);
		excelData.setExcelData("ERefSet", 1, 5, "AutoQuestionSet"
				+ randomGenerator.nextInt(99999));
		newQuestionSet = excelData.getExcelData("ERefSet", 1, 5);
		mngERefSetLib.editQuestionSet(questionSet, newQuestionSet);
		
		userType = excelData.getExcelData("Login", 1, 5);
		district = excelData.getExcelData("ERefSet", 1, 4);
		newQuestionSet = excelData.getExcelData("ERefSet", 1, 5);
		mngERefSetLib.deactivateQuestionSet(userType, district, newQuestionSet);
	}

	/*@Test(priority = 2)
	public void addQuestionSet() throws Exception {
		userType = excelData.getExcelData("Login", 1, 5);
		district = excelData.getExcelData("ERefSet", 1, 4);
		questionSet = excelData.getExcelData("ERefSet", 1, 5);
		status = excelData.getExcelData("ERefSet", 1, 6);
		mngERefSetLib.addQuestionSet(userType, district, questionSet, status);
	}

	@Test(priority = 3)
	public void searchQuestionSet() throws Exception {
		userType = excelData.getExcelData("Login", 1, 5);
		district = excelData.getExcelData("ERefSet", 1, 4);
		questionSet = excelData.getExcelData("ERefSet", 1, 5);
		mngERefSetLib.searchQuestionSet(userType, district, questionSet);
	}

	@Test(priority = 4)
	public void editQuestionSet() throws Exception {
		questionSet = excelData.getExcelData("ERefSet", 1, 5);
		excelData.setExcelData("ERefSet", 1, 5, "AutoQuestionSet"
				+ randomGenerator.nextInt(99999));
		newQuestionSet = excelData.getExcelData("ERefSet", 1, 5);
		mngERefSetLib.editQuestionSet(questionSet, newQuestionSet);
	}

	@Test(priority = 5)
	public void manageQuestions() throws Exception {
		newQuestionSet = excelData.getExcelData("ERefSet", 1, 5);
		question = excelData.getExcelData("ERefSet", 1, 7);
		questionType = excelData.getExcelData("ERefSet", 1, 8);
		questionMaxScore = excelData.getExcelData("ERefSet", 1, 9);
		instruction = excelData.getExcelData("ERefSet", 1, 10);
		mngERefSetLib.manageQuestions(newQuestionSet, question, questionType,
				questionMaxScore, instruction);
	}                 // Not for sanity

	@Test(priority = 6)
	public void deactivateQuestionSet() throws Exception {
		userType = excelData.getExcelData("Login", 1, 5);
		district = excelData.getExcelData("ERefSet", 1, 4);
		newQuestionSet = excelData.getExcelData("ERefSet", 1, 5);
		mngERefSetLib.deactivateQuestionSet(userType, district, newQuestionSet);
	}*/
	
	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}
}
