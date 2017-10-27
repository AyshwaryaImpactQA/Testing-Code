package com.scripts.regTestCases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scripts.businessLogic.DistrictJobOrderBL;
import com.scripts.businessLogic.ImportCandidatesBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageDistPrivilegeBL;
import com.scripts.lib.commonFunction.Driver;

import utils.load.dataSource.CopySheet;
import utils.load.dataSource.ExcelLib;

public class TMImportCandidates extends Driver {

	LoginBL loginLib;
	ImportCandidatesBL importCandidatesLib;
	ManageDistPrivilegeBL mngDistPrivLib;
	ExcelLib excelData;
	CopySheet copyData;
	DistrictJobOrderBL dJobOrdersLib;
	String daUsername, daPassword, daUserType, district, firstName, lastName, jobId , email, dateApplied, path, file, refNo;
	int rowNum, randomNumber;
	Random randomGenerator;
	

	@BeforeClass
	public void configClass() throws Exception {
		loginLib = new LoginBL();
		randomGenerator = new Random();
		dJobOrdersLib = new DistrictJobOrderBL();
		copyData = new CopySheet();
		importCandidatesLib = new ImportCandidatesBL();
		mngDistPrivLib = new ManageDistPrivilegeBL();
		excelData = new ExcelLib();
		daUsername = excelData.getExcelData("Login", 1, 1);
		daPassword = excelData.getExcelData("Login", 1, 4);
		daUserType = excelData.getExcelData("Login", 1, 5);
		district = excelData.getExcelData("TMCandidateImport", 1, 5);
		path = System.getProperty("user.dir") + "\\src\\test\\resources\\";
		reports.startTest("Import Candidates with TM");
		loginLib.login(daUsername, daPassword, daUserType);
	}

	//@Test(priority = 1)
	@Test
	public void importCandidates() throws Exception {
		//jobId = excelData.getDateExcelData("TMCandidateImport", 1, 6);
		refNo = excelData.getExcelData("DADJO", 1, 17);
		excelData.setExcelData("TMCandidateImport", 1, 0, refNo);
		jobId = excelData.getExcelData("DADJO", 1, 12);
		excelData.setExcelData("TMCandidateImport", 1, 6, jobId);
		randomNumber = randomGenerator.nextInt(9999);
		firstName = "fname_aut" + randomNumber;
		lastName = "lname_aut" + randomNumber;
		email = firstName + "@yopmail.com";
		excelData.setExcelData("TMCandidateImport", 1, 1, firstName);
		excelData.setExcelData("TMCandidateImport", 1, 2, lastName);
		excelData.setExcelData("TMCandidateImport", 1, 3, email);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dateobj = new Date();
		dateApplied = df.format(dateobj);
		excelData.setExcelData("TMCandidateImport", 1, 4, dateApplied);
		district = excelData.getExcelData("TMCandidateImport", 1, 5);
		copyData.copySheet(path + "NCTestDataSheet.xls", path + "Import\\ImportCandidates.xls", "TMCandidateImport");
		file = path + "Import\\ImportCandidates.xls";
		importCandidatesLib.importCandidates(file, jobId, district, email);
	}

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}

}
