package com.scripts.regTestCases;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.load.dataSource.ExcelLib;

import com.scripts.businessLogic.CandidatePortfolioBL;
import com.scripts.businessLogic.LoginBL;
import com.scripts.lib.commonFunction.Driver;

public class CandidatePortfolio extends Driver {

	String position, role, field, org, city, state1, startMonth, startYear,
			endMonth, endYear, reason, salutation, country, zip, address,
			phone1, phone2, phone3, attenedYear, leftYear, cumulativeGPA,
			degree, school, certificationStatus, certificationType, state,
			receivedYear, certificationName, refFirstNmae, refLastName,
			refEmail, refContactNo, tfaAffiliate, corpYear, region, gender,
			username, password, userType, refType, refTitle , refOrganisation;
	CandidatePortfolioBL portfolioLib;
	ExcelLib excelData;
	LoginBL loginLib;

	@BeforeClass
	public void configBeforeClass() throws Exception {
		excelData = new ExcelLib();
		portfolioLib = new CandidatePortfolioBL();
		loginLib = new LoginBL();
		username = excelData.getExcelData("AddUser", 4, 3);
		password = excelData.getExcelData("AddUser", 4, 4);
		userType = excelData.getExcelData("AddUser", 4, 5);
		reports.startTest("Candidate Portfolio");
		loginLib.login(username, password, userType);
	}

	//@Test(priority = 1)
	@Test
	public void personalInfo() throws Exception {
		salutation = excelData.getExcelData("CandidatePersonalInfo", 1, 1);
		country = excelData.getExcelData("CandidatePersonalInfo", 1, 5);
		zip = excelData.getExcelData("CandidatePersonalInfo", 1, 2);
		address = excelData.getExcelData("CandidatePersonalInfo", 1, 6);
		phone1 = excelData.getExcelData("CandidatePersonalInfo", 1, 7);
		phone2 = excelData.getExcelData("CandidatePersonalInfo", 1, 8);
		phone3 = excelData.getExcelData("CandidatePersonalInfo", 1, 9);
		gender = excelData.getExcelData("CandidatePersonalInfo", 1, 10);
		portfolioLib.personalInfo(salutation, country, zip, address, phone1,
			phone2, phone3, gender);
		
		attenedYear = excelData.getExcelData("CandidateAcademics", 2, 1);
		leftYear = excelData.getExcelData("CandidateAcademics", 2, 2);
		cumulativeGPA = excelData.getExcelData("CandidateAcademics", 2, 3);
		degree = excelData.getExcelData("CandidateAcademics", 2, 4);
		school = excelData.getExcelData("CandidateAcademics", 2, 5);
	portfolioLib.addAcademicsDetails(attenedYear, leftYear, cumulativeGPA,
			degree, school);
	
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(999);
	tfaAffiliate = excelData.getExcelData("CandidateAcademics", 2, 15);
	corpYear = excelData.getExcelData("CandidateAcademics", 2, 16);
	region = excelData.getExcelData("CandidateAcademics", 2, 17);
	certificationStatus = excelData
			.getExcelData("CandidateAcademics", 2, 6);
	certificationType = excelData.getExcelData("CandidateAcademics", 2, 7);
	state1 = excelData.getExcelData("CandidateAcademics", 2, 8);
	receivedYear = excelData.getExcelData("CandidateAcademics", 2, 9);
	certificationName = excelData.getExcelData("CandidateAcademics", 2, 10);
	portfolioLib.addCredentialsCertification(certificationStatus,
			certificationType, state1, receivedYear, certificationName,
			tfaAffiliate, corpYear, region);
	for (int i = 2; i <= 4; i++) {
		refFirstNmae = "fname" + randomInt + i;
		refLastName = "lname" + randomInt + i;
		refEmail = refFirstNmae + "@yopmail.com";
		excelData.setExcelData("CandidateAcademics", i, 12, refFirstNmae);
		excelData.setExcelData("CandidateAcademics", i, 13, refLastName);
		excelData.setExcelData("CandidateAcademics", i, 14, refEmail);
		refContactNo = excelData.getExcelData("CandidateAcademics", 2, 11);
		refType = excelData.getExcelData("CandidateAcademics",2 ,18 );
		refTitle = excelData.getExcelData("CandidateAcademics", 2 , 19);
		refOrganisation = excelData.getExcelData("CandidateAcademics", 2 , 20);
		portfolioLib.addCredentialsReferences(refFirstNmae, refLastName,
				refContactNo, refEmail, refType, refTitle , refOrganisation);
	}
		position = excelData.getExcelData("CandidateExperience", 1, 1);
		role = excelData.getExcelData("CandidateExperience", 1, 2);
		field = excelData.getExcelData("CandidateExperience", 1, 3);
		org = excelData.getExcelData("CandidateExperience", 1, 4);
		city = excelData.getExcelData("CandidateExperience", 1, 5);
		state = excelData.getExcelData("CandidateExperience", 1, 6);
		startMonth = excelData.getExcelData("CandidateExperience", 1, 7);
		startYear = excelData.getExcelData("CandidateExperience", 1, 8);
		endMonth = excelData.getExcelData("CandidateExperience", 1, 9);
		endYear = excelData.getExcelData("CandidateExperience", 1, 10);
		reason = excelData.getExcelData("CandidateExperience", 1, 11);
		portfolioLib.experiences(position, role, field, org, city, state,
		startMonth, startYear, endMonth, endYear, reason);
		
		position = excelData.getExcelData("CandidateExperience", 1, 1);
		role = excelData.getExcelData("CandidateExperience", 1, 2);
		field = excelData.getExcelData("CandidateExperience", 1, 3);
		org = excelData.getExcelData("CandidateExperience", 1, 4);
		city = excelData.getExcelData("CandidateExperience", 1, 5);
		state = excelData.getExcelData("CandidateExperience", 1, 6);
		startMonth = excelData.getExcelData("CandidateExperience", 1, 7);
		startYear = excelData.getExcelData("CandidateExperience", 1, 8);
		endMonth = excelData.getExcelData("CandidateExperience", 1, 9);
		endYear = excelData.getExcelData("CandidateExperience", 1, 10);
		reason = excelData.getExcelData("CandidateExperience", 1, 11);
		portfolioLib.experiences(position, role, field, org, city, state,
		startMonth, startYear, endMonth, endYear, reason);
		
		portfolioLib.affidavit();
	}

	/*@Test(priority = 2)
	public void addAcademicsDetails() throws Exception, InvalidFormatException,
			IOException {
		attenedYear = excelData.getExcelData("CandidateAcademics", 2, 1);
		leftYear = excelData.getExcelData("CandidateAcademics", 2, 2);
		cumulativeGPA = excelData.getExcelData("CandidateAcademics", 2, 3);
		degree = excelData.getExcelData("CandidateAcademics", 2, 4);
		school = excelData.getExcelData("CandidateAcademics", 2, 5);
	portfolioLib.addAcademicsDetails(attenedYear, leftYear, cumulativeGPA,
			degree, school);
	}

	@Test(priority = 3)
	public void addCredentialsDetails() throws InterruptedException,
			InvalidFormatException, IOException {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(999);
		tfaAffiliate = excelData.getExcelData("CandidateAcademics", 2, 15);
		corpYear = excelData.getExcelData("CandidateAcademics", 2, 16);
		region = excelData.getExcelData("CandidateAcademics", 2, 17);
		certificationStatus = excelData
				.getExcelData("CandidateAcademics", 2, 6);
		certificationType = excelData.getExcelData("CandidateAcademics", 2, 7);
		state1 = excelData.getExcelData("CandidateAcademics", 2, 8);
		receivedYear = excelData.getExcelData("CandidateAcademics", 2, 9);
		certificationName = excelData.getExcelData("CandidateAcademics", 2, 10);
		portfolioLib.addCredentialsCertification(certificationStatus,
				certificationType, state1, receivedYear, certificationName,
				tfaAffiliate, corpYear, region);
		for (int i = 2; i <= 4; i++) {
			refFirstNmae = "fname" + randomInt + i;
			refLastName = "lname" + randomInt + i;
			refEmail = refFirstNmae + "@yopmail.com";
			excelData.setExcelData("CandidateAcademics", i, 12, refFirstNmae);
			excelData.setExcelData("CandidateAcademics", i, 13, refLastName);
			excelData.setExcelData("CandidateAcademics", i, 14, refEmail);
			refContactNo = excelData.getExcelData("CandidateAcademics", 2, 11);
			refType = excelData.getExcelData("CandidateAcademics",2 ,18 );
			refTitle = excelData.getExcelData("CandidateAcademics", 2 , 19);
			refOrganisation = excelData.getExcelData("CandidateAcademics", 2 , 20);
			portfolioLib.addCredentialsReferences(refFirstNmae, refLastName,
					refContactNo, refEmail, refType, refTitle , refOrganisation);
		}
		portfolioLib.addCredentialsCertification(certificationStatus,                              // commente by KG
				certificationType, state1, receivedYear, certificationName,
				tfaAffiliate, corpYear, region);
	}

	@Test(priority = 4)
	public void experiences() throws InterruptedException,
			InvalidFormatException, IOException {
		position = excelData.getExcelData("CandidateExperience", 1, 1);
		role = excelData.getExcelData("CandidateExperience", 1, 2);
		field = excelData.getExcelData("CandidateExperience", 1, 3);
		org = excelData.getExcelData("CandidateExperience", 1, 4);
		city = excelData.getExcelData("CandidateExperience", 1, 5);
		state = excelData.getExcelData("CandidateExperience", 1, 6);
		startMonth = excelData.getExcelData("CandidateExperience", 1, 7);
		startYear = excelData.getExcelData("CandidateExperience", 1, 8);
		endMonth = excelData.getExcelData("CandidateExperience", 1, 9);
		endYear = excelData.getExcelData("CandidateExperience", 1, 10);
		reason = excelData.getExcelData("CandidateExperience", 1, 11);
		portfolioLib.experiences(position, role, field, org, city, state,
		startMonth, startYear, endMonth, endYear, reason);
	}

	@Test(priority = 5)
	public void affidavit() throws InterruptedException {
		portfolioLib.affidavit();
	}*/

	@AfterClass
	public void logout() throws Exception {
		loginLib.logout();
	}
}
