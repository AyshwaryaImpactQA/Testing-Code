package com.scripts.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class CandidateGridPL {

	CommonUtills commonLib = new CommonUtills();

	@FindAll(@FindBy(xpath = "//a[@class='profile']"))
	private List<WebElement> linkCandidateName;
	
	@FindBy(xpath = "//*[@id='myModalStatus']/div/div/div[3]/button")
	private WebElement doneBtn;
	
	public WebElement getDoneBtn() {
		if (commonLib.isDisplayed(doneBtn)) {
			return doneBtn;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "(//a[contains(text(),'Available')])[1]")
	private WebElement statusGrid;

	public WebElement getStatusGrid() {
		if (commonLib.isDisplayed(statusGrid)) {
			return statusGrid;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//*[@id='divStatus']/table/tbody/tr/td[5]/table[1]/tbody/tr/td/a/img")
	private WebElement hiredNode;

	public WebElement getHiredNode() {
		if (commonLib.isDisplayed(hiredNode)) {
			return hiredNode;
		} else {
			return null;
		}
	}

	@FindBy(xpath = ".//*[@id='statusFinalize']/button")
	private WebElement finalizeBtn;
	
	public WebElement getFinalizeBtn() {
		if (commonLib.isDisplayed(finalizeBtn)) {
			return finalizeBtn;
		} else {
			return null;
		}
	}

	@FindAll(@FindBy(xpath = "//a[contains(@onclick, 'getMessageDiv')]"))
	private List<WebElement> linkCandidateEmail;

	@FindBy(id = "tpSearch")
	private WebElement iconSearch;

	@FindBy(id = "firstName")
	private WebElement txtBoxFirstName;

	@FindBy(id = "lastName")
	private WebElement txtBoxLastName;

	@FindBy(id = "emailAddress")
	private WebElement txtBoxEmail;

	@FindBy(xpath = "//button[@onclick='searchCG()']")
	private WebElement btnSearchCG;

	@FindBy(xpath = "//a[@id='tpLegend']/span")
	private WebElement iconLegend;

	@FindBy(xpath = "//b[contains(text(), 'Candidate Grid Key')]")
	private WebElement txtlegend;

	@FindBy(id = "tpPDReportprofile")
	private WebElement btnPDReport;

	@FindBy(xpath = "//div[contains(text(), 'PROFESSIONAL DEVELOPMENT REPORT')]")
	private WebElement txtPDReport;

	@FindBy(id = "tpJSAProfile")
	private WebElement btnJSI;

	@FindBy(xpath = "//div[contains(text(), 'JOB SPECIFIC INVENTORY REPORT')]")
	private WebElement txtJSI;

	@FindBy(xpath = "//a[contains(@onclick, 'getCommunicationsDiv')]")
	private WebElement btnCommunication;

	@FindBy(xpath = "//button[@onclick='showCommunicationsDivForSave();'][text()='Close']")
	private WebElement btnCloseCommunication;

	@FindBy(xpath = "//td[@class='commbgcolor']")
	private WebElement messageCommunication;

	@FindBy(xpath = "//div[@id='modalDownloadPDR']//button[contains(text(), 'Close')]")
	private WebElement btnClosePD;

	@FindAll(@FindBy(xpath = "//td[@class='commbgcolor']"))
	private List<WebElement> listCommHistroy;

	@FindBy(xpath = "//td[contains(text(), 'No record found.')]")
	private WebElement commListEmpty;

	@FindBy(xpath = "//table[@id='tblGrid']//td[14]//a[contains(@onclick,'showStatus')]")
	private WebElement linkStatus;

	@FindBy(xpath = "//div[@aria-hidden='false']//button[@id='confirmTrue']")
	private WebElement btnOkIncompleteApplication;

	@FindBy(xpath = "//td[text()='Screening Complete']")
	private WebElement nodePointScreeningComplete;
	
	@FindBy(xpath = "//td[text()='Hired']")
	private WebElement nodePointHired;

	@FindBy(xpath = "//td[text()='Evaluation Complete']")
	private WebElement nodePointEvaluationComplete;

	@FindBy(id = "statusFinalize")
	private WebElement btnFinalize;

	@FindBy(id = "notScore")
	private WebElement btnDontScore;

	@FindBy(partialLinkText = "Add Note")
	private WebElement linkAddNote;

	@FindBy(xpath = "//*[@id='statusNotes']/div/div[3]")
	private WebElement txtBoxNote;

	@FindBy(xpath = "//div[@id='myModalStatus']//button[text()='Done']")
	private WebElement btnDone;

	@FindBy(id = "errorStatusNote")
	private WebElement errorMessageStatusNote;

	@FindBy(id = "cancelButtonRefChk")
	private WebElement btnCancelReferenceChk;

	public List<WebElement> getListCommHistroy() {
		if (commonLib.isDisplayed(listCommHistroy)) {
			return listCommHistroy;
		} else {
			return null;
		}
	}

	public WebElement getCommListEmpty() {
		if (commonLib.isDisplayed(commListEmpty)) {
			return commListEmpty;
		} else {
			return null;
		}
	}

	public WebElement getBtnClosePD() {
		if (commonLib.isDisplayed(btnClosePD)) {
			return btnClosePD;
		} else {
			return null;
		}
	}

	public List<WebElement> getLinkCandidateName() {
		if (commonLib.isDisplayed(linkCandidateName)) {
			return linkCandidateName;
		} else {
			return null;
		}
	}

	public WebElement getBtnCloseCommunication() {
		if (commonLib.isDisplayed(btnCloseCommunication)) {
			return btnCloseCommunication;
		} else {
			return null;
		}
	}

	public List<WebElement> getLinkCandidateEmail() {
		if (commonLib.isDisplayed(linkCandidateEmail)) {
			return linkCandidateEmail;
		} else {
			return null;
		}
	}

	public WebElement getIconSearch() {
		if (commonLib.isDisplayed(iconSearch)) {
			return iconSearch;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxFirstName() {
		if (commonLib.isDisplayed(txtBoxFirstName)) {
			return txtBoxFirstName;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxLastName() {
		if (commonLib.isDisplayed(txtBoxLastName)) {
			return txtBoxLastName;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxEmail() {
		if (commonLib.isDisplayed(txtBoxEmail)) {
			return txtBoxEmail;
		} else {
			return null;
		}
	}

	public WebElement getBtnSearchCG() {
		if (commonLib.isDisplayed(btnSearchCG)) {
			return btnSearchCG;
		} else {
			return null;
		}
	}

	public WebElement getIconLegend() {
		if (commonLib.isDisplayed(iconLegend)) {
			return iconLegend;
		} else {
			return null;
		}
	}

	public WebElement getTxtlegend() {
		if (commonLib.isDisplayed(txtlegend)) {
			return txtlegend;
		} else {
			return null;
		}
	}

	public WebElement getBtnPDReport() {
		if (commonLib.isDisplayed(btnPDReport)) {
			return btnPDReport;
		} else {
			return null;
		}
	}

	public WebElement getTxtPDReport() {
		if (commonLib.isDisplayed(txtPDReport)) {
			return txtPDReport;
		} else {
			return null;
		}
	}

	public WebElement getBtnJSI() {
		if (commonLib.isDisplayed(btnJSI)) {
			return btnJSI;
		} else {
			return null;
		}
	}

	public WebElement getTxtJSI() {
		if (commonLib.isDisplayed(txtJSI)) {
			return txtJSI;
		} else {
			return null;
		}
	}

	public WebElement getBtnCommunication() {
		if (commonLib.isDisplayed(btnCommunication)) {
			return btnCommunication;
		} else {
			return null;
		}
	}

	public WebElement getMessageCommunication() {
		if (commonLib.isDisplayed(messageCommunication)) {
			return messageCommunication;
		} else {
			return null;
		}
	}

	public WebElement getLinkStatus() {
		if (commonLib.isDisplayed(linkStatus)) {
			return linkStatus;
		} else {
			return null;
		}
	}

	public WebElement getBtnOkIncompleteApplication() {
		if (commonLib.isDisplayed(btnOkIncompleteApplication)) {
			return btnOkIncompleteApplication;
		} else {
			return null;
		}
	}

	public WebElement getNodePointScreeningComplete() {
		if (commonLib.isDisplayed(nodePointScreeningComplete)) {
			return nodePointScreeningComplete;
		} else {
			return null;
		}
	}

	public WebElement getNodePointHired() {
		if (commonLib.isDisplayed(nodePointHired)) {
			return nodePointHired;
		} else {
			return null;
		}
	}

	public WebElement getNodePointEvaluationComplete() {
		if (commonLib.isDisplayed(nodePointEvaluationComplete)) {
			return nodePointEvaluationComplete;
		} else {
			return null;
		}
	}

	public WebElement getBtnFinalize() {
		if (commonLib.isDisplayed(btnFinalize)) {
			return btnFinalize;
		} else {
			return null;
		}
	}

	public WebElement getBtnDontScore() {
		if (commonLib.isDisplayed(btnDontScore)) {
			return btnDontScore;
		} else {
			return null;
		}
	}

	public WebElement getLinkAddNote() {
		if (commonLib.isDisplayed(linkAddNote)) {
			return linkAddNote;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxNote() {
		if (commonLib.isDisplayed(txtBoxNote)) {
			return txtBoxNote;
		} else {
			return null;
		}
	}

	public WebElement getBtnDone() {
		if (commonLib.isDisplayed(btnDone)) {
			return btnDone;
		} else {
			return null;
		}
	}

	public WebElement getErrorMessageStatusNote() {
		if (commonLib.isDisplayed(errorMessageStatusNote)) {
			return errorMessageStatusNote;
		} else {
			return null;
		}
	}

	public WebElement getBtnCancelReferenceChk() {
		if (commonLib.isDisplayed(btnCancelReferenceChk)) {
			return btnCancelReferenceChk;
		} else {
			return null;
		}
	}

}
