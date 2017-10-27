/**
 * Created by : Mayank Bansal
 * ReportsPL.java
 * Aug 11, 2016
 * Purpose : Page objects for report page
 */
package com.scripts.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ReportsPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid5")
	private WebElement menuReports;

	@FindBy(id = "submenuid51")
	private WebElement subMenuAdhocReports;

	@FindBy(xpath = "//ul[li[a[@id='submenuid51']]]/li[2]/a")
	private WebElement subMenuCustomReports;

	@FindBy(xpath = "//ul[li[a[@id='submenuid51']]]/li[3]/a")
	private WebElement subMenuStdReports;

	@FindBy(xpath = "//a[@id='submenuid52'][text()=' Applicants without tag']")
	private WebElement subMenuApplicantsWithoutTag;

	@FindBy(xpath = "//a[@id='submenuid52'][text()=' WECAN Export']")
	private WebElement subMenuWECANExport;

	@FindBy(xpath = "//a[@id='submenuid52'][text()=' Noble St Application']")
	private WebElement subMenuNobleStApplication;

	@FindBy(xpath = "//a[@id='submenuid52'][text()=' Noble St Candidate']")
	private WebElement subMenuNobleStCandidate;

	@FindBy(xpath = "//a[@id='submenuid52'][text()=' Noble St Jobs']")
	private WebElement subMenuNobleStJobs;

	@FindBy(xpath = "//a[@id='submenuid52'][text()=' Noble St DSPQ']")
	private WebElement subMenuNobleStDSPQ;

	@FindBy(xpath = "//a[@id='submenuid52'][text()=' Noble St School Position']")
	private WebElement subMenuNobleStSchoolPosition;

	@FindBy(xpath = "//a[@id='submenuid52'][text()=' EAA Job Vacancy Records']")
	private WebElement subMenuEAAJobVacancyRecords;

	@FindBy(xpath = "//a[@id='submenuid52'][text()=' EAA Application Records']")
	private WebElement subMenuEAAApplicationRecords;

	@FindBy(xpath = "//a[@id='submenuid52'][text()=' EAA Candidate Records']")
	private WebElement subMenuEAACandidateRecords;

	@FindBy(xpath = "//a[@id='submenuid52'][text()=' EAA Application Status History Records']")
	private WebElement subMenuEAAApplicationStatusHistoryRecords;

	@FindBy(xpath = "//a[@id='submenuid52'][text()=' EAA Interview Question Records']")
	private WebElement subMenuEAAInterviewQuestionRecords;

	@FindBy(xpath = "//a[@id='submenuid52'][text()=' Portability Report-Hired']")
	private WebElement subMenuPortabilityReportHired;

	@FindBy(xpath = "//a[@id='submenuid52'][text()=' Licensed Contract Report']")
	private WebElement subMenuLicensedContractReport;

	@FindBy(xpath = "//div[text()='Ad-Hoc Reports']")
	private WebElement sectionAdhocReports;

	@FindBy(id = "districtORSchoolName")
	private WebElement txtDistrictName;

	@FindBy(id = "divResultdivTxtShowData0")
	private WebElement firstOptionDistrict;

	@FindBy(xpath = "//td[contains(text(),'Records')][1]")
	private WebElement noOfRecords;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement btnSearch;

	@FindBy(xpath = "//td[text()='No Record found']")
	private WebElement messageNoRecordFound;
	
	@FindBy(xpath = "//td[text()='No record found.']")
	private WebElement messageSmallNoRecordFound;

	@FindBy(id = "exlId")
	private WebElement iconDownloadToExcel;

	@FindBy(id = "pdfId")
	private WebElement iconDownloadToPDF;

	@FindBy(id = "printId")
	private WebElement iconPrint;
	
	@FindBy(id = "csvId")
	private WebElement iconCSV;

	@FindBy(xpath = "//div[contains(@id,'modalDownload')][contains(@style,'display: block;')]//button[text()='Close']")
	private WebElement btnClosePDFDownload;

	@FindAll(@FindBy(xpath = "//table[@id='tblGridJobVacancy']//tr"))
	private List<WebElement> rowCountInEAAJobVacancyReport;
	
	@FindAll(@FindBy(xpath = "//table[@id='tblGridApplicationSHR']//tr"))
	private List<WebElement> rowCountInEAAApplicationStatusHistoryReport;
	
	@FindAll(@FindBy(xpath = "//table[@id='tblGridInterviewQuestionRecords']//tr"))
	private List<WebElement> rowCountInEAAInterviewQuestionReport;
	
	@FindAll(@FindBy(xpath = "//table[@id='tblGridHired']//tr"))
	private List<WebElement> rowCountInLicensedContractReport;

	public WebElement getMenuReports() {
		if (commonLib.isDisplayed(menuReports)) {
			return menuReports;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuAdhocReports() {
		if (commonLib.isDisplayed(subMenuAdhocReports)) {
			return subMenuAdhocReports;
		} else {
			return null;
		}
	}

	public WebElement getSectionAdhocReports() {
		if (commonLib.isDisplayed(sectionAdhocReports)) {
			return sectionAdhocReports;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuCustomReports() {
		if (commonLib.isDisplayed(subMenuCustomReports)) {
			return subMenuCustomReports;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuStdReports() {
		if (commonLib.isDisplayed(subMenuStdReports)) {
			return subMenuStdReports;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuApplicantsWithoutTag() {
		if (commonLib.isDisplayed(subMenuApplicantsWithoutTag)) {
			return subMenuApplicantsWithoutTag;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuWECANExport() {
		if (commonLib.isDisplayed(subMenuWECANExport)) {
			return subMenuWECANExport;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuNobleStApplication() {
		if (commonLib.isDisplayed(subMenuNobleStApplication)) {
			return subMenuNobleStApplication;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuNobleStCandidate() {
		if (commonLib.isDisplayed(subMenuNobleStCandidate)) {
			return subMenuNobleStCandidate;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuNobleStJobs() {
		if (commonLib.isDisplayed(subMenuNobleStJobs)) {
			return subMenuNobleStJobs;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuNobleStDSPQ() {
		if (commonLib.isDisplayed(subMenuNobleStDSPQ)) {
			return subMenuNobleStDSPQ;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuNobleStSchoolPosition() {
		if (commonLib.isDisplayed(subMenuNobleStSchoolPosition)) {
			return subMenuNobleStSchoolPosition;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuEAAJobVacancyRecords() {
		if (commonLib.isDisplayed(subMenuEAAJobVacancyRecords)) {
			return subMenuEAAJobVacancyRecords;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuEAAApplicationRecords() {
		if (commonLib.isDisplayed(subMenuEAAApplicationRecords)) {
			return subMenuEAAApplicationRecords;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuEAACandidateRecords() {
		if (commonLib.isDisplayed(subMenuEAACandidateRecords)) {
			return subMenuEAACandidateRecords;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuEAAApplicationStatusHistoryRecords() {
		if (commonLib.isDisplayed(subMenuEAAApplicationStatusHistoryRecords)) {
			return subMenuEAAApplicationStatusHistoryRecords;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuEAAInterviewQuestionRecords() {
		if (commonLib.isDisplayed(subMenuEAAInterviewQuestionRecords)) {
			return subMenuEAAInterviewQuestionRecords;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuPortabilityReportHired() {
		if (commonLib.isDisplayed(subMenuPortabilityReportHired)) {
			return subMenuPortabilityReportHired;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuLicensedContractReport() {
		if (commonLib.isDisplayed(subMenuLicensedContractReport)) {
			return subMenuLicensedContractReport;
		} else {
			return null;
		}
	}

	public WebElement getTxtDistrictName() {
		if (commonLib.isDisplayed(txtDistrictName)) {
			return txtDistrictName;
		} else {
			return null;
		}
	}

	public WebElement getFirstOptionDistrict() {
		if (commonLib.isDisplayed(firstOptionDistrict)) {
			return firstOptionDistrict;
		} else {
			return null;
		}
	}

	public WebElement getNoOfRecords() {
		if (commonLib.isDisplayed(noOfRecords)) {
			return noOfRecords;
		} else {
			return null;
		}
	}

	public WebElement getBtnSearch() {
		if (commonLib.isDisplayed(btnSearch)) {
			return btnSearch;
		} else {
			return null;
		}
	}

	public WebElement getMessageNoRecordFound() {
		if (commonLib.isDisplayed(messageNoRecordFound)) {
			return messageNoRecordFound;
		} else {
			return null;
		}
	}

	public WebElement getMessageSmallNoRecordFound() {
		if (commonLib.isDisplayed(messageSmallNoRecordFound)) {
			return messageSmallNoRecordFound;
		} else {
			return null;
		}
	}

	public WebElement getIconDownloadToExcel() {
		if (commonLib.isDisplayed(iconDownloadToExcel)) {
			return iconDownloadToExcel;
		} else {
			return null;
		}
	}

	public WebElement getIconDownloadToPDF() {
		if (commonLib.isDisplayed(iconDownloadToPDF)) {
			return iconDownloadToPDF;
		} else {
			return null;
		}
	}

	public WebElement getIconPrint() {
		if (commonLib.isDisplayed(iconPrint)) {
			return iconPrint;
		} else {
			return null;
		}
	}

	public WebElement getIconCSV() {
		if (commonLib.isDisplayed(iconCSV)) {
			return iconCSV;
		} else {
			return null;
		}
	}

	public WebElement getBtnClosePDFDownload() {
		if (commonLib.isDisplayed(btnClosePDFDownload)) {
			return btnClosePDFDownload;
		} else {
			return null;
		}
	}

	public List<WebElement> getRowCountInEAAJobVacancyReport() {
		if (commonLib.isDisplayed(rowCountInEAAJobVacancyReport)) {
			return rowCountInEAAJobVacancyReport;
		} else {
			return null;
		}
	}

	public List<WebElement> getRowCountInEAAApplicationStatusHistoryReport() {
		if (commonLib.isDisplayed(rowCountInEAAApplicationStatusHistoryReport)) {
			return rowCountInEAAApplicationStatusHistoryReport;
		} else {
			return null;
		}
	}

	public List<WebElement> getRowCountInEAAInterviewQuestionReport() {
		if (commonLib.isDisplayed(rowCountInEAAInterviewQuestionReport)) {
			return rowCountInEAAInterviewQuestionReport;
		} else {
			return null;
		}
	}

	public List<WebElement> getRowCountInLicensedContractReport() {
		if (commonLib.isDisplayed(rowCountInLicensedContractReport)) {
			return rowCountInLicensedContractReport;
		} else {
			return null;
		}
	}

}
