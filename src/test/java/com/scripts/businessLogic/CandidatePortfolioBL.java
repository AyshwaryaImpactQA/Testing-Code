package com.scripts.businessLogic;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.CandidatePortfolioPL;

public class CandidatePortfolioBL extends Driver {

	CandidatePortfolioPL portfolioPage = PageFactory.initElements(driver,
			CandidatePortfolioPL.class);
	CommonUtills commonLib = new CommonUtills();

	public void personalInfo(String salutation, String country, String zip,
			String address, String phone1, String phone2, String phone3,
			String gender) throws InterruptedException {
		commonLib.logOnInfo("Candidate Portfolio", "Filling Personal Details");
		commonLib.click(portfolioPage.getPortfolioMenu(), "Portfolio Menu");
		commonLib.waitForPageToLoad();
		commonLib
		.click(portfolioPage.getBtnPersonalInfo(), "Personal Info Btn");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(portfolioPage.getTxtBoxZip())) {
			commonLib.logOnError("Candidate Portfolio",
					"Personal Info page not loaded");
		}
		if (gender.equalsIgnoreCase("female")) {
			commonLib.click(portfolioPage.getRadioBtnGenderFemale(),
					"Female Radio Button");
		} else if (gender.equalsIgnoreCase("male")) {
			commonLib.click(portfolioPage.getRadioBtnGenderMale(),
					"Male Radio Button");
		} else {
			commonLib.click(portfolioPage.getRadioBtnGenderDeclined(),
					"Declined to Answer Radio Button");
		}
		commonLib.selectDrpDownValue(portfolioPage.getDrpDownSalutation(),
				salutation, "Salutation Drpdown");
		List<WebElement> chkBoxesRace = portfolioPage.getChkBoxesRace();
		for (WebElement race : chkBoxesRace) {
			if (!commonLib.isSelected(race)) {
				commonLib.click(race, "Race ChkBox");
			}
		}
		commonLib.typeText(portfolioPage.getTxtBoxZip(), zip, "Zip TxtBox");
		commonLib.waitForPageToLoad();
		//Thread.sleep(5000);
		commonLib.typeText(portfolioPage.getTxtBoxAddress(), address,
				"Address TxtBox");
		commonLib.typeText(portfolioPage.getTxtBoxPhone1(), phone1,
				"Phone1 TxtBox");
		commonLib.typeText(portfolioPage.getTxtBoxPhone2(), phone2,
				"Phone2 TxtBox");
		commonLib.typeText(portfolioPage.getTxtBoxPhone3(), phone3,
				"Phone3 TxtBox");
		commonLib.click(portfolioPage.getBtnSaveAndContinue(),
				"Save and Continue Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(portfolioPage.getLinkAddaSchool())) {
			commonLib.logOnSuccess("Candidate Portfolio",
					"Personal Info filled successfully");
		} else {
			commonLib.logOnError("Candidate Portfolio",
					"Personal Info not filled");
		}
	}

	public void addAcademicsDetails(String attenedYear, String leftYear,
			String cumulativeGPA, String degree, String school)
					throws Exception {
		commonLib.logOnInfo("Candidate Portfolio", "Filling Academic Details");
		commonLib.click(portfolioPage.getLinkAcademics(), "Academic Link");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(portfolioPage.getLinkAddaSchool())) {
			commonLib.click(portfolioPage.getLinkAddaSchool(),
					"Add a School link");
			commonLib.waitForPageToLoad();
			commonLib.typeText(portfolioPage.getBoxDegree(), degree,
					"Degree TxtBox");
			commonLib.typeText(portfolioPage.getBoxSchool(), school,
					"School TxtBox");
			Thread.sleep(2000);
			commonLib.click(portfolioPage.getLinkFieldNotListed(),
					"Field Not Listed Link");
			commonLib.selectDrpDownValue(
					portfolioPage.getDrpDownAttendinYear(), attenedYear,
					"Attend Year Drpdown");
			commonLib.selectDrpDownValue(portfolioPage.getDrpDownLeftinYear(),
					leftYear, "Left Year Drpdown");
			commonLib.typeText(portfolioPage.getTxtBoxOtherField(),
					"Accounting", "Other Field TxtBox");
			Thread.sleep(4000);
			commonLib.typeKeys(portfolioPage.getFirstOptionFieldOfStudy(), Keys.ENTER);
//		//	commonLib.click(portfolioPage.getFirstOptionFieldOfStudy(),
//					"First Option Field of Study");
			if (commonLib.isDisplayed(portfolioPage.getBoxCumulativeGPA())) {
				commonLib.typeText(portfolioPage.getBoxCumulativeGPA(),
						cumulativeGPA, "Cumulative GPA TxtBox");
			}
			osName = System.getProperty("os.name");
			if (osName.contains("Windows")) {
				commonLib.typeText(portfolioPage.getFileUpload(),
						System.getProperty("user.dir")
						+ "\\src\\test\\resources\\Event_Logo.png",
						"Upload File");
			} else {
				commonLib.typeText(portfolioPage.getFileUpload(),
						System.getProperty("user.dir")
						+ "/src/test/resources/Event_Logo.png",
						"Upload File");
			}
			commonLib.waitForPageToLoad();
			commonLib.click(portfolioPage.getBtnSaveAndContinue(),
					"Save and Continue Btn");
			commonLib.waitForPageToLoad();
			if (commonLib.isDisplayed(portfolioPage.getVerifyCredentialsPage())) {
				commonLib.logOnSuccess("Candidate Portfolio",
						"Academics details saved successfully");
			} else {
				commonLib.logOnError("Candidate Portfolio",
						"Academics details are not saved");
			}
		} else {
			commonLib.logOnError("Candidate Portfolio",
					"Portfolio menu is not displayed");
		}
	}

	public void editAcademicsDetails(String attenedYear, String leftYear,
			String cumulativeGPA, String degree, String school)
					throws Exception {
		commonLib.waitForPageToLoad();
		commonLib.logOnInfo("Candidate Portfolio", "Editing Academic Details");
		if (commonLib.isDisplayed(portfolioPage.getLinkEditAcademic())) {
			commonLib.click(portfolioPage.getLinkEditAcademic(),
					"Edit Academic link");
			commonLib.waitForPageToLoad();
			commonLib.typeText(portfolioPage.getBoxDegree(), degree,
					"Degree TxtBox");
			commonLib.typeText(portfolioPage.getBoxSchool(), school,
					"School TxtBox");
			commonLib.click(portfolioPage.getLinkFieldNotListed(),
					"Field Not Listed link");
			commonLib.selectDrpDownValue(
					portfolioPage.getDrpDownAttendinYear(), attenedYear,
					"Attended Year");
			commonLib.selectDrpDownValue(portfolioPage.getDrpDownLeftinYear(),
					leftYear, "Left Year");
			commonLib.typeText(portfolioPage.getBoxCumulativeGPA(),
					cumulativeGPA, "Cumulative GPA");
			commonLib.waitForPageToLoad();
			commonLib.click(portfolioPage.getBtnSaveAndContinue(),
					"Save and Continue Btn");
			commonLib.waitForPageToLoad();
			if (commonLib.isDisplayed(portfolioPage.getVerifyCredentialsPage())) {
				commonLib.logOnSuccess("Candidate Portfolio",
						"Academics details edited successfully");
			} else {
				commonLib.logOnError("Candidate Portfolio",
						"Academics details are not saved");
			}
		} else {
			commonLib.logOnError("Candidate Portfolio",
					"Portfolio menu is not displayed");
		}
	}

	public void addCredentialsNavigate() throws InterruptedException {
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(portfolioPage.getSubHeadingCredentials())) {
			commonLib.logOnInfo("Candidate Portfolio",
					"Filling Credentials Details");
			commonLib.click(portfolioPage.getPortfolioMenu());
			commonLib.waitForPageToLoad();
			commonLib.click(portfolioPage.getLinkCredentials());
			commonLib.waitForPageToLoad();
			commonLib.click(portfolioPage.getAccordionReferences());
			commonLib.logOnSuccess("Candidate Portfolio",
					"Credentials page loaded successfully");
		} else {
			commonLib.logOnError("Candidate Portfolio",
					"Credentials Section is not displayed.");
		}
	}

	public void editCredentialsCertification(String nbcYear)
			throws InterruptedException {
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(portfolioPage.getSubHeadingCredentials())) {
			commonLib.logOnInfo("Candidate Portfolio",
					"Editing Credentials Details");
			if (commonLib.isDisplayed(portfolioPage.getDrpDownNBCYear())) {
				commonLib.selectDrpDownValue(portfolioPage.getDrpDownNBCYear(),
						nbcYear, "TFA");
			}
			commonLib.waitForPageToLoad();
			commonLib.click(portfolioPage.getBtnSaveCreds(),
					"Save and Continue button");
			commonLib.waitForPageToLoad();
			commonLib.logOnSuccess("Candidate Portfolio",
					"Credentials page updated successfully");
		} else {
			commonLib.logOnError("Candidate Portfolio",
					"Credentials Section is not displayed.");
		}
	}

	public void addCredentialsCertification(String certificationStatus,
			String certificationType, String state, String receivedYear,
			String certificationName, String tfaAffiliate, String corpYear,
			String region) throws InterruptedException {

		commonLib.selectDrpDownValue(portfolioPage.getDrpDownTFA(),
				tfaAffiliate, "TFA");
		commonLib.selectDrpDownValue(portfolioPage.getDrpDownCorpYear(),
				corpYear, "Corp Year");
		commonLib.selectDrpDownValue(portfolioPage.getDrpDownRegion(), region,
				"Region");
		commonLib.logOnInfo("Candidate Portfolio", "Filling Certifications");
		commonLib.click(portfolioPage.getLinkAddCertification(),
				"Add Certification Link");

		if (!commonLib.isDisplayed(portfolioPage.getEditCertificationStatus())){  

			commonLib.waitForPageToLoadWithCond(portfolioPage.getDrpDownCertificationStatus());

			commonLib.selectDrpDownValue(portfolioPage.getDrpDownCertificationStatus(),certificationStatus, "Certification Status Dropdown");
			commonLib.selectDrpDownValue(
					portfolioPage.getDrpDownCertificationType(), certificationType,
					"Certification Type Dropdown");
			commonLib.selectDrpDownValue(
					portfolioPage.getDrpDownCertificationState(), state,
					"Certification State Dropdown");
			commonLib.selectDrpDownValue(portfolioPage.getDrpDownYearReceived(),
					receivedYear, "Year received Dropdown");
			commonLib.waitForPageToLoad();
			commonLib.typeText(portfolioPage.getBoxCertificationName(),
					certificationName, "Certification Name TxtBox");
			commonLib.waitForPageToLoad();
			Thread.sleep(2000);
			commonLib.click(portfolioPage.getFirstElementCertType(),
					"First Certification Name");
			commonLib.waitForPageToLoad();
		}
		else
		{
			commonLib.click(portfolioPage.getEditCertificationStatus(),"First Certification Name");

		}

		commonLib.waitForPageToLoadWithCond(portfolioPage.getLinkSaveSectionCert());
		commonLib.click(portfolioPage.getLinkSaveSectionCert(),"Save Certification");
		commonLib.waitForPageToLoad();
		List<WebElement> certifications = portfolioPage
				.getVerifyCertificationDetails();
		if (!commonLib.isDisplayed(portfolioPage.getDivError())) {
			for (WebElement uiCertification : certifications) {
				if (commonLib.getText(uiCertification).contains(
						certificationName)) {
					commonLib.logOnSuccess("Candidate Portfolio",
							"Certification details added successfully");
					break;
				}
			}
		} else {
			commonLib.logOnError("Candidate Portfolio",
					"Certification details are not added");
		}
		commonLib
		.click(portfolioPage.getBtnSaveCreds(), "Save Credentials Btn");
		commonLib.waitForPageToLoad();
	}

	public void addCredentialsReferences(String refFirstNmae,
			String refLastName, String refContactNo, String refEmail , String refType , String refTitle , 
			String refOrganisation)
					throws InterruptedException {
		commonLib.logOnInfo("Candidate Portfolio", "Adding References");
		commonLib.click(portfolioPage.getPortfolioMenu(), "Portfolio Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(portfolioPage.getLinkCredentials(), "Credentials Link");
		commonLib.waitForPageToLoad();
		commonLib.click(portfolioPage.getAccordionReferences(),
				"References Accordian");
		commonLib.waitForPageToLoad();
		commonLib.click(portfolioPage.getLinkAddReference(),
				"Add Reference Link");
		commonLib.waitForPageToLoad();
		commonLib.typeText(portfolioPage.getBoxFirstName(), refFirstNmae,
				"First Name TxtBox");
		commonLib.typeText(portfolioPage.getBoxLastName(), refLastName,
				"Last Name TxtBox");
		commonLib.typeText(portfolioPage.getBoxContactNumber(), refContactNo,
				"Contact No TxtBox");
		commonLib.typeText(portfolioPage.getBoxEmail(), refEmail,
				"Email TxtBox");
		commonLib.typeText(portfolioPage.getBoxTitle(), refTitle,
				"Title TxtBox");
		commonLib.typeText(portfolioPage.getBoxOrganization(), refOrganisation,
				"Organisation TxtBox");
		commonLib.click(portfolioPage.getRadioBtnDirectContact(),
				"Direct Contact Radio Btn");
		commonLib.selectDrpDownValue(portfolioPage.getDrpDownReferenceType(),
				refType , "Reference Type Dropdown");
		commonLib.click(portfolioPage.getBtnSaveCreds(), "Save Credentials Btn");
		osName = System.getProperty("os.name");
		if (osName.contains("Windows")) {
			commonLib.typeText(portfolioPage.getFileUploadReference(),
					System.getProperty("user.dir")
					+ "\\src\\test\\resources\\Event_Logo.png",
					"Upload File");
		} else {
			commonLib.typeText(portfolioPage.getFileUploadReference(),
					System.getProperty("user.dir")
					+ "/src/test/resources/Event_Logo.png",
					"Upload File");
		}
		commonLib.waitForPageToLoad();


		if (!commonLib.isDisplayed(portfolioPage.getDivError())) {
			commonLib.logOnSuccess("Candidate Portfolio",
					"Reference added successfully");
		} else {
			commonLib.logOnError("Candidate Portfolio",
					"References are not added");
		}
	}

	public void experiences(String position, String role, String field,
			String org, String city, String state, String startMonth,
			String startYear, String endMonth, String endYear, String reason)
					throws InterruptedException {
		commonLib.logOnInfo("Candidate Portfolio",
				"Filling the experiences details");
		commonLib.click(portfolioPage.getPortfolioMenu(), "Portfolio Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(portfolioPage.getBtnExperiences(), "Experiences Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.getAttribute(portfolioPage.getAccordionResume(), "class")
				.contains("collapsed")) {
			commonLib.click(portfolioPage.getAccordionResume(),
					"Resume Accordion");
			commonLib.waitForPageToLoad();
		}
		osName = System.getProperty("os.name");
		if (osName.contains("Windows")) {
			commonLib.typeText(portfolioPage.getFileUpload(),
					System.getProperty("user.dir")
					+ "\\src\\test\\resources\\Logout.png",
					"Upload File");
		} else {
			commonLib.typeText(portfolioPage.getFileUpload(),
					System.getProperty("user.dir")
					+ "/src/test/resources/Logout.png", "Upload File");
		}
		commonLib.waitForPageToLoad();
		commonLib.click(portfolioPage.getTabEmpHistory(), "Emp History Tab");
		Thread.sleep(2000);
		commonLib.click(portfolioPage.getBtnAddEmployment(),
				"Add Employment Btn");
		commonLib.waitForPageToLoad();
		commonLib.selectDrpDownValue(portfolioPage.getDrpDownPosition(),
				position, "Position");
		commonLib.typeText(portfolioPage.getTxtBoxRole(), role, "Role TxtBox");
		commonLib.selectDrpDownValue(portfolioPage.getDrpDownField(), field,
				"Field");
		commonLib.typeText(portfolioPage.getTxtBoxOrg(), org, "Org TxtBox");
		commonLib.typeText(portfolioPage.getTxtBoxCity(), city, "City TxtBox");
		commonLib.typeText(portfolioPage.getTxtBoxState(), state,
				"State TxtBox");
		commonLib.selectDrpDownValue(portfolioPage.getDrpDownStartMonth(),
				startMonth, "Start Month");
		commonLib.selectDrpDownValue(portfolioPage.getDrpDownStartYear(),
				startYear, "Start Year");
		commonLib.selectDrpDownValue(portfolioPage.getDrpDownEndMonth(),
				endMonth, "End Month");
		commonLib.selectDrpDownValue(portfolioPage.getDrpDownEndYear(),
				endYear, "End Year");
		commonLib.click(portfolioPage.getRadioBtnGenMember(),
				"Gen Member Radio Btn");
		commonLib.typeText(portfolioPage.getTxtBoxReason(), reason,
				"Reason TxtBox");
		commonLib.waitForPageToLoad();
		commonLib.click(portfolioPage.getBtnSaveSchool(), "Save School Btn");
		commonLib.waitForPageToLoad();
		String text = commonLib.getText(portfolioPage.getEmploymentTable());
		if (text.equals("No record found.")) {
			commonLib.logOnError("Candidate Portfolio",
					"Employment history not added");
		} else {
			commonLib.logOnSuccess("Candidate Portfolio",
					"Employment history added successfully");
		}
		commonLib.click(portfolioPage.getBtnSaveExp(), "Save Experience Btn");
		commonLib.waitForPageToLoad();
	}

	public void editExperiences() throws InterruptedException {
		if (commonLib.isDisplayed(portfolioPage.getSubHeadingExperiences())) {
			commonLib.logOnInfo("Candidate Portfolio", "View Affidavit");
			osName = System.getProperty("os.name");
			if (osName.contains("Windows")) {
				commonLib.typeText(portfolioPage.getFileUpload(),
						System.getProperty("user.dir")
						+ "\\src\\test\\resources\\Event_Logo.png",
						"Upload File");
			} else {
				commonLib.typeText(portfolioPage.getFileUpload(),
						System.getProperty("user.dir")
						+ "/src/test/resources/Event_Logo.png",
						"Upload File");
			}
			commonLib.waitForPageToLoad();
			if (commonLib.isDisplayed(portfolioPage.getBtnOk())) {
				commonLib.click(portfolioPage.getBtnOk(), "Ok button");
				commonLib.waitForPageToLoad();
			}
			commonLib.click(portfolioPage.getBtnSaveAndContinue(),
					"Save and Continue Btn");
			commonLib.waitForPageToLoad();
			if (commonLib.isDisplayed(portfolioPage.getTxtAffidavitHeading())) {
				commonLib.logOnSuccess("Candidate Portfolio",
						"Experiences page edited successfully");
			} else {
				commonLib.logOnError("Candidate Portfolio",
						"Experiences Section can not be edited");
			}
		} else {
			commonLib.logOnError("Candidate Portfolio",
					"Experiences Section is not displayed");
		}
	}

	public void affidavit() throws InterruptedException {
		commonLib.logOnInfo("Candidate Portfolio", "Filling the affidavit");
		commonLib.click(portfolioPage.getPortfolioMenu(), "Portfolio Menu");
		commonLib.waitForPageToLoad();
		commonLib.click(portfolioPage.getBtnAffidavit(), "Affidavit Btn");
		commonLib.waitForPageToLoad();
		if (!commonLib.isDisplayed(portfolioPage.getTxtAffidavitHeading())) {
			commonLib
			.logOnError("Filling affidavit", "Affidavit not displayed");
			return;
		}
		if (commonLib.isDisplayed(portfolioPage.getCheckBoxAccept())) {
			commonLib.click(portfolioPage.getCheckBoxAccept(),
					"Accept Checkbox");
		}
		commonLib.click(portfolioPage.getBtnComplete(), "Complete Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.getText(portfolioPage.getStatusPortfolio()).contains(
				"Complete")) {
			commonLib.logOnSuccess("Candidate Portfolio",
					"Affidavit filled successfully");
		} else {
			commonLib.logOnError("Candidate Portfolio",
					"Affidavit not completed");
		}
	}
}
