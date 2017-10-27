package com.scripts.regTestCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageQualificationScreenBL;
import com.scripts.lib.commonFunction.Driver;

public class DAManageQualificationScreen extends Driver {

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
		excelData.setExcelData("Qualification_Screen", 2, 5, "AutoQuestionSet"
				+ randomGenerator.nextInt(99999));
		excelData.setExcelData("Qualification_Screen", 2, 7, "AutoQuestion"
				+ randomGenerator.nextInt(99999));
		username = excelData.getExcelData("Login", 3, 1);
		password = excelData.getExcelData("Login", 3, 4);
		userType = excelData.getExcelData("Login", 3, 5);
		reports.startTest("Manage Qualification Screen with District Admin");
		loginLib.login(username, password, userType);
	}

/*	@Test(priority = 1)
	public void addQuestionSet() throws Exception {
		userType = excelData.getExcelData("Login", 3, 5);
		district = excelData.getExcelData("Qualification_Screen", 2, 4);
		questionSet = excelData.getExcelData("Qualification_Screen", 2, 5);
		status = excelData.getExcelData("Qualification_Screen", 2, 6);
		mngQualificationScrLib.addQuestionSet(userType, district, questionSet,
				status);
	}*/           //Not for DA

	/*@Test(priority = 2)
	public void searchQuestionSet() throws Exception {
		mngQualificationScrLib.searchQuestionSet(userType, district,
				questionSet, status);
	}*/   //Not for DA 

	@Test(priority = 1)
	public void editQuestionSet() throws Exception {
		userType = excelData.getExcelData("Login", 3, 5);
		district = excelData.getExcelData("Qualification_Screen", 2, 4);
		questionSet = excelData.getExcelData("Qualification_Screen", 2, 5);
		status = excelData.getExcelData("Qualification_Screen", 2, 6);
		mngQualificationScrLib.editQuestionSetDA(questionSet,userType);
	}
/*
	@Test(priority = 4)
	public void manageQuestions() throws Exception {
		questionSet = excelData.getExcelData("Qualification_Screen", 2, 5);
		question = excelData.getExcelData("Qualification_Screen", 2, 7);
		questionType = excelData.getExcelData("Qualification_Screen", 2, 8);
		instruction = excelData.getExcelData("Qualification_Screen", 2, 9);
		mngQualificationScrLib.manageQuestions(questionSet, question,
				questionType, instruction);
	}*/             //Not for DA

	@Test(priority = 2)
	public void deactivateQuestionSet() throws Exception {
		userType = excelData.getExcelData("Login", 3, 5);
		district = excelData.getExcelData("Qualification_Screen", 2, 4);
		questionSet = excelData.getExcelData("Qualification_Screen", 2, 5);
		status = excelData.getExcelData("Qualification_Screen", 2, 6);
		mngQualificationScrLib.deactivateQuestionSetDA(userType, district,
				questionSet, status);
	}
	
	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}
}
