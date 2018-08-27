package com.scripts.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ApplyForJobsPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid3")
	private WebElement jobOpps;

	@FindBy(id = "districtName")
	private WebElement txtBoxDistrict;

	@FindBy(id = "headId")
	private WebElement headerJobsOfInterest;

	@FindBy(xpath = "//button[@onclick='serachByBtn()']")
	private WebElement btnSearch;

	@FindBy(xpath = "//a[@id='tpApply1']")
	private WebElement btnApply1Job;

	@FindAll(@FindBy(xpath = "//a[@data-original-title=' Apply Now']"))
	private List<WebElement> columnButtonApplyJob;

	@FindAll(@FindBy(xpath = "//table[@id='tblGridJoF']//td[8]/a[1]/img"))
	private List<WebElement> jobActionIcons;

	@FindBy(xpath = "//*[@id='applyToNext']/button")
	private WebElement btnApplyforJob;
	
	@FindBy(xpath = "//*[@id='myModal2']/div/div/div[3]/button")
	private WebElement btnConfirmUnhide;

	//@FindBy(id = "hidePrompt")
	//private WebElement btnConfirmUnhide;

	// Cover Letter

	@FindBy(xpath = "//*[@id='divCoverLetter']/div[@class='jqte']/div[@class='jqte_editor']")
	private WebElement txtBoxCoverLetter;

	public List<WebElement> getJobActionIcons() {
		if (commonLib.isDisplayed(jobActionIcons)) {
			return jobActionIcons;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//button[@onclick='checkCL_dynamicPortfolio();']/strong")
	private WebElement btnSaveCoverLetter;

	@FindAll(@FindBy(xpath = "//table[@id='tblGridJoF']//td[1]/a"))
	private List<WebElement> columnJobTitle;

	@FindBy(id = "rdoCL2")
	private WebElement radioButtonNoCoverLetter;

	@FindBy(xpath = "//h3[contains(text(),'Cover Letter')]")
	private WebElement headerCoverLetter;

	@FindBy(xpath = "//*[@id='myModalCL']//button[text()='Close']")
	private WebElement btnCloseCoverLetter;

	@FindBy(xpath = "//*[@id='dynamicSaveDspq']")
	private WebElement btnSaveDSPQ;

	@FindBy(id = "divResultdivTxtDistrictData0")
	private WebElement firstElementInList;

	// QQ

	/**
	 * @return the columnJobTitle
	 */
	@FindBy(xpath="(//button[@class='btn btn-primary'])[8]")
	private WebElement btnContinueMandatory;
	
	public WebElement getButtonContinueMandatory() {
		if(commonLib.isDisplayed(btnContinueMandatory)) {
			return btnContinueMandatory;
		} else {
			return null;
		}
	}
	@FindBy(xpath="//input[@id='Q5073validQuestion']/..//input[@name='Q1opt']")
	private WebElement btnradio1;
	
	public WebElement getBtnradio1() {
		if(commonLib.isDisplayed(btnradio1)) {
			return btnradio1;
		} else {
			return null;
		}
	}
	@FindBy(xpath="//input[@id='Q5075validQuestion']/..//input[@name='Q2opt']")
	private WebElement btnradio2;
	
	public WebElement getBtnradio2() {
		if(commonLib.isDisplayed(btnradio2)) {
			return btnradio2;
		} else {
			return null;
		}
	}
	
	public List<WebElement> getColumnJobTitle() {
		if (commonLib.isDisplayed(columnJobTitle)) {
			return columnJobTitle;
		} else {
			return null;
		}
	}
	

	public WebElement getFirstElementInList() {
		if (commonLib.isDisplayed(firstElementInList)) {
			return firstElementInList;
		} else {
			return null;
		}
	}

	public WebElement getBtnSaveDSPQ() {
		if (commonLib.isDisplayed(btnSaveDSPQ)) {
			return btnSaveDSPQ;
		} else {
			return null;
		}
	}

	public WebElement getRadioButtonNoCoverLetter() {
		if (commonLib.isDisplayed(radioButtonNoCoverLetter)) {
			return radioButtonNoCoverLetter;
		} else {
			return null;
		}
	}

	public WebElement getHeaderCoverLetter() {
		if (commonLib.isDisplayed(headerCoverLetter)) {
			return headerCoverLetter;
		} else {
			return null;
		}
	}

	@FindBy(name = "acceptornot")
    private WebElement checkAffidavit;

	public WebElement getCheckAffidavit() {
		if (commonLib.isDisplayed(checkAffidavit)) {
			return checkAffidavit;
		} else {
			return null;
		}
	}

	@FindBy(id = "continueButton")
	private WebElement continueBtn;
	
	
	public WebElement getContinueBtn() {
		if (commonLib.isDisplayed(continueBtn)) {
			return continueBtn;
		} else {
			return null;
		}
	}

	@FindAll(@FindBy(xpath = "//table[@id='tblGrid']//tr/td//input[@type='radio']"))
	private List<WebElement> radioBtnQQ;

	@FindBy(id = "Q1opt")
	private WebElement txtBoxQQ;
	
	@FindBy(id = "Q2optet")
	private WebElement txtBoxQQ1;

	public WebElement getTxtBoxQQ1() {
		if (commonLib.isDisplayed(txtBoxQQ1)) {
			return txtBoxQQ1;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//button[contains(@onclick,'setDistrictQuestions')]")
	private WebElement btnSaveQQ;

	@FindBy(id = "Q1question")
	private WebElement question1QQ;

	@FindBy(id = "Q2question")
	private WebElement question2QQ;
	
	@FindBy(xpath = "(//img[@src='images/option01.png'])[1]")
	private WebElement ClickOnApplyNow;
	
	
	public WebElement getClickOnApplyNow() {
		//if (commonLib.isDisplayed(ClickOnApplyNow)) {
			return ClickOnApplyNow;
	//	} else {
		//	return null;
		//}
	}

	@FindBy(xpath = "//div[@id='myModalDASpecificQuestions']//button[contains(text(),'Close')]")
	private WebElement btnCloseQQ;

	@FindBy(xpath = "//div[@id='myModalDASpecificQuestionsQQ']//button[contains(text(),'Cancel')]")
	private WebElement btnCloseDASpecificQQ;
	
	@FindBy(xpath = "//*[@id='QuestionNotAvailable']/div/div/div[3]/button")
	private WebElement btnOKDASpecificQQ;

	public WebElement getBtnOKDASpecificQQ() {
		if (commonLib.isDisplayed(btnOKDASpecificQQ)) {
			return btnOKDASpecificQQ;
		} else {
			return null;
		}
	}

	@FindBy(id = "closeButtonDsqp")
	private WebElement btnCloseDSPQ;

	@FindBy(id = "selJBIStatus")
	private WebElement drpDownStatus;

	public List<WebElement> getColumnButtonApplyJob() {
		if (commonLib.isDisplayed(columnButtonApplyJob)) {
			return columnButtonApplyJob;
		} else {
			return null;
		}
	}

	public List<WebElement> getRadioBtnQQ() {
		if (commonLib.isDisplayed(radioBtnQQ)) {
			return radioBtnQQ;
		} else {
			return null;
		}
	}

	public WebElement getRadioBtnEPI() {
		if (commonLib.isDisplayed(radioBtnEPI)) {
			return radioBtnEPI;
		} else {
			return null;
		}
	}

	public WebElement getJobOpps() {
		if (commonLib.isDisplayed(jobOpps)) {
			return jobOpps;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxDistrict() {
		if (commonLib.isDisplayed(txtBoxDistrict)) {
			return txtBoxDistrict;
		} else {
			return null;
		}
	}

	public WebElement getHeaderJobsOfInterest() {
		if (commonLib.isDisplayed(headerJobsOfInterest)) {
			return headerJobsOfInterest;
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

	public WebElement getBtnApply1Job() {
		if (commonLib.isDisplayed(btnApply1Job)) {
			return btnApply1Job;
		} else {
			return null;
		}
	}

	public WebElement getBtnApplyforJob() {
		if (commonLib.isDisplayed(btnApplyforJob)) {
			return btnApplyforJob;
		} else {
			return null;
		}
	}

	public WebElement getBtnConfirmUnhide() {
		if (commonLib.isDisplayed(btnConfirmUnhide)) {
			return btnConfirmUnhide;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxCoverLetter() {
		if (commonLib.isDisplayed(txtBoxCoverLetter)) {
			return txtBoxCoverLetter;
		} else {
			return null;
		}
	}

	public WebElement getBtnSaveCoverLetter() {
		if (commonLib.isDisplayed(btnSaveCoverLetter)) {
			return btnSaveCoverLetter;
		} else {
			return null;
		}
	}

	public WebElement getBtnSaveQQ() {
		if (commonLib.isDisplayed(btnSaveQQ)) {
			return btnSaveQQ;
		} else {
			return null;
		}
	}

	// EPI
	@FindBy(xpath = "//*[@id='applyToNext']/button")
	private WebElement btnStartEPI;

	@FindBy(xpath = "//button[@onclick = 'splashInstruction1()']")
	private WebElement btnContinueEPI;

	@FindBy(xpath = "//button[@onclick = 'splashInstruction2();']")
	private WebElement btnOkEPIInstruction;

	@FindBy(xpath = "//button[@onclick = 'startInventory();']")
	private WebElement btnStartEPIInstruction;

	public WebElement getBtnStartJSIInstruction() {
		if (commonLib.isDisplayed(btnStartJSIInstruction)) {
			return btnStartJSIInstruction;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//button[@onclick = 'startInventory()']")
	private WebElement btnStartJSIInstruction;

	public WebElement getBtnStartEPIInstruction() {
		if (commonLib.isDisplayed(btnStartEPIInstruction)) {
			return btnStartEPIInstruction;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[contains(text(),'Professional Inventory')]")
	private WebElement headingEPIPage;

	@FindBy(id = "sbmtbtn")
	private WebElement btnSubmitInstructions;

	@FindBy(xpath = "//table[@id='tblGrid']//table//tr[1]//input[@type='radio']")
	private WebElement radioBtnEPI;

	@FindBy(xpath = "//button[@onclick = 'redirectTo()'][contains(text() , 'Ok')]")
	private WebElement btnCompleteEPI;

	@FindBy(xpath = "//div[@id='nextStep']/button/strong[text()='Start Job Specific Inventory ']")
	private WebElement btnStartJSI;

	@FindBy(xpath = "//button[text()='Ok']")
	private WebElement btnOkJobApplication;

	@FindBy(xpath = "//b[text()='Instructions for the section']")
	private WebElement headingInstructions;

	@FindBy(xpath = ".//*[@id='footerbtn1']/button")
	private WebElement popupJobComplete;

	// JSI

	public WebElement getPopupJobComplete() {
		if (commonLib.isDisplayed(popupJobComplete)) {
			return popupJobComplete;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxQQ() {
		if (commonLib.isDisplayed(txtBoxQQ)) {
			return txtBoxQQ;
		} else {
			return null;
		}
	}

	public WebElement getHeadingEPIPage() {
		if (commonLib.isDisplayed(headingEPIPage)) {
			return headingEPIPage;
		} else {
			return null;
		}
	}

	public WebElement getHeadingInstructions() {
		if (commonLib.isDisplayed(headingInstructions)) {
			return headingInstructions;
		} else {
			return null;
		}
	}

	public WebElement getBtnOkEPIInstruction() {
		if (commonLib.isDisplayed(btnOkEPIInstruction)) {
			return btnOkEPIInstruction;
		} else {
			return null;
		}
	}

	public WebElement getBtnStartEPI() {
		if (commonLib.isDisplayed(btnStartEPI)) {
			return btnStartEPI;
		} else {
			return null;
		}
	}

	public WebElement getBtnOkJobApplication() {
		if (commonLib.isDisplayed(btnOkJobApplication)) {
			return btnOkJobApplication;
		} else {
			return null;
		}
	}

	public WebElement getBtnStartJSI() {
		if (commonLib.isDisplayed(btnStartJSI)) {
			return btnStartJSI;
		} else {
			return null;
		}
	}

	public WebElement getBtnContinueEPI() {
		if (commonLib.isDisplayed(btnContinueEPI)) {
			return btnContinueEPI;
		} else {
			return null;
		}
	}

	public WebElement getBtnSubmitInstructions() {
		if (commonLib.isDisplayed(btnSubmitInstructions)) {
			return btnSubmitInstructions;
		} else {
			return null;
		}
	}

	@FindBy(id = "opt")
	private WebElement txtBoxJsi;

	public WebElement getBtnCompleteEPI() {
		if (commonLib.isDisplayed(btnCompleteEPI)) {
			return btnCompleteEPI;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxJsi() {
		if (commonLib.isDisplayed(txtBoxJsi)) {
			return txtBoxJsi;
		} else {
			return null;
		}
	}

	public WebElement getQuestion1QQ() {
		if (commonLib.isDisplayed(question1QQ)) {
			return question1QQ;
		} else {
			return null;
		}
	}

	public WebElement getQuestion2QQ() {
		if (commonLib.isDisplayed(question2QQ)) {
			return question2QQ;
		} else {
			return null;
		}
	}

	public WebElement getBtnCloseQQ() {
		if (commonLib.isDisplayed(btnCloseQQ)) {
			return btnCloseQQ;
		} else {
			return null;
		}
	}

	public WebElement getBtnCloseDASpecificQQ() {
		if (commonLib.isDisplayed(btnCloseDASpecificQQ)) {
			return btnCloseDASpecificQQ;
		} else {
			return null;
		}
	}

	public WebElement getBtnCloseDSPQ() {
		if (commonLib.isDisplayed(btnCloseDSPQ)) {
			return btnCloseDSPQ;
		} else {
			return null;
		}
	}

	public WebElement getDrpDownStatus() {
		if (commonLib.isDisplayed(drpDownStatus)) {
			return drpDownStatus;
		} else {
			return null;
		}
	}

	public WebElement getBtnCloseCoverLetter() {
		if (commonLib.isDisplayed(btnCloseCoverLetter)) {
			return btnCloseCoverLetter;
		} else {
			return null;
		}
	}
	@FindBy(xpath="//button[@id='dynamicSaveDspq']/strong")
	private WebElement btnDynamiqSaveDSPQ;
	
	public WebElement getBtnDynamicSaveDSPQ() {
		if(commonLib.isDisplayed(btnDynamiqSaveDSPQ)) {
			return btnDynamiqSaveDSPQ;
		} else {
			return null;
		}
		
	}

}

     
