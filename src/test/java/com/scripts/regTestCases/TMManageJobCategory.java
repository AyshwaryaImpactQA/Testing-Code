package com.scripts.regTestCases;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.LoginBL;
import com.scripts.businessLogic.ManageJobCategoryBL;
import com.scripts.lib.commonFunction.Driver;

public class TMManageJobCategory extends Driver {

	String username, password, userType, district, jobCategoryName, entityType,
			newJobCategoryName;
	ExcelLib excelData;
	LoginBL loginLib;
	ManageJobCategoryBL mngJobCategoryLib;
	Random random;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		mngJobCategoryLib = new ManageJobCategoryBL();
		excelData = new ExcelLib();
		loginLib = new LoginBL();
		random = new Random();
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 4);
		userType = excelData.getExcelData("Login", 1, 5);
		district = excelData.getExcelData("Job Category", 1, 4);
		entityType = excelData.getExcelData("Job Category", 1, 5);
		reports.startTest("Manage Job Category as TM Admin");
		loginLib.login(username, password, userType);
		mngJobCategoryLib.navigateToManageJobCategoryPage();
	}

	//@Test(priority = 1)
	@Test
	public void addJobCategory() throws Exception {
		jobCategoryName = "AutoJobCategory" + random.nextInt(99999);
		excelData.setExcelData("Job Category", 1, 6, jobCategoryName);
		mngJobCategoryLib.addJobCategory(district, jobCategoryName);
		
		jobCategoryName = excelData.getExcelData("Job Category", 1, 6);
		newJobCategoryName = "AutoJobCategory" + random.nextInt(99999);
		excelData.setExcelData("Job Category", 1, 6, newJobCategoryName);
		mngJobCategoryLib.editJobCategory(district, entityType,
				jobCategoryName, newJobCategoryName);
		
		jobCategoryName = excelData.getExcelData("Job Category", 1, 6);
		mngJobCategoryLib.showHistoryForJobCategory(jobCategoryName);
		
		jobCategoryName = excelData.getExcelData("Job Category", 1, 6);
		mngJobCategoryLib.showHistoryForJobCategory(jobCategoryName);
	}

	/*@Test(priority = 2)
	public void editJobCategory() throws Exception {
		jobCategoryName = excelData.getExcelData("Job Category", 1, 6);
		newJobCategoryName = "AutoJobCategory" + random.nextInt(99999);
		excelData.setExcelData("Job Category", 1, 6, newJobCategoryName);
		mngJobCategoryLib.editJobCategory(district, entityType,
				jobCategoryName, newJobCategoryName);
		
		jobCategoryName = excelData.getExcelData("Job Category", 1, 6);
		mngJobCategoryLib.deactivateJobCategory(jobCategoryName);
	}

	@Test(priority = 3)
	public void showHistoryForJobCategory() throws Exception {
		jobCategoryName = excelData.getExcelData("Job Category", 1, 6);
		mngJobCategoryLib.showHistoryForJobCategory(jobCategoryName);
	}

	@Test(priority = 4)
	public void deactivateJobCategory() throws Exception {
		jobCategoryName = excelData.getExcelData("Job Category", 1, 6);
		mngJobCategoryLib.deactivateJobCategory(jobCategoryName);
	}*/
	
	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}

}
