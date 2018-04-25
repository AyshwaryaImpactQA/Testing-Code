package com.scripts.regTestCases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.CopySheet;
import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.ImportJobsBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.lib.commonFunction.Driver;

public class TMImportJobs extends Driver {
	LoginBL loginLib;
	ExcelLib excelData;
	CopySheet copyData;
	Random random;
	ImportJobsBL importJobsBL;
	String file, jobId, jobTitle, jobType, username, password, userType, path,
			jobstartdate, jobenddate, districtName;

	@BeforeClass
	public void configClass() throws Exception {
		loginLib = new LoginBL();
		random = new Random();
		excelData = new ExcelLib();
		copyData = new CopySheet();
		path = System.getProperty("user.dir") + "\\src\\test\\resources\\";
		importJobsBL = new ImportJobsBL();
		excelData.setExcelData("TMJobImport", 1, 0, "AutoImportJobId"
				+ random.nextInt(99999));
		excelData.setExcelData("TMJobImport", 1, 2, "AutoImportJobTitle"
				+ random.nextInt(99999));
		username = excelData.getExcelData("Login", 1, 1);
		password = excelData.getExcelData("Login", 1, 2);
		userType = excelData.getExcelData("Login", 1, 3);
		reports.startTest("Import Jobs with TM Admin");
		loginLib.login(username, password, userType);
	}

	@Test
	public void importJobs() throws Exception {
		jobId = excelData.getExcelData("TMJobImport", 1, 0);
		jobType = excelData.getExcelData("TMJobImport", 1, 1);
		jobTitle = excelData.getExcelData("TMJobImport", 1, 2);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dateobj = new Date();
		jobstartdate = df.format(dateobj);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(jobstartdate));
		c.add(Calendar.DATE, 7); // number of days to add
		jobenddate = sdf.format(c.getTime());
		excelData.setExcelData("TMJobImport", 1, 3, jobstartdate);
		excelData.setExcelData("TMJobImport", 1, 4, jobenddate);
		copyData.copySheet(path + "TPLTestDataSheet.xls", path
				+ "Import\\ImportJobs.xls", "TMJobImport");
		file = path + "Import\\ImportJobs.xls";

		districtName = excelData.getExcelData("TMJobImport", 1, 6);
		importJobsBL.importJobs(file, districtName, jobTitle);
	}

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}

}
