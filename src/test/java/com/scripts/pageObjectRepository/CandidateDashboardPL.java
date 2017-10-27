package com.scripts.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class CandidateDashboardPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid1")
	private WebElement menuDashboard;

	@FindBy(id = "iconpophover1")
	private WebElement iconJobPreferences;

	@FindBy(id = "iconpophoverscore")
	private WebElement iconPowerProfile;

	@FindBy(xpath = "//a[@href='portfolio.do']/img")
	private WebElement iconPortfolio;

	@FindBy(xpath = "//tr[td[text()='Portfolio Report']]//a")
	private WebElement iconPortfolioReport;

	@FindBy(id = "tpApply1")
	private WebElement iconFirstApplyNow;

	@FindBy(xpath = "//*[@id='divFavTeacher']//tr[1]/td[1]/a")
	private WebElement firstJobNameJOISection;

	@FindAll(@FindBy(xpath = "//*[@id='divFavTeacher']//td[1]/a[contains(@href,'applyjob.do')]"))
	private List<WebElement> allJobNamesJOISection;

	@FindBy(xpath = "//*[@id='divFavTeacher']//tr[1]/td[3]/a[2]")
	private WebElement firstJobHideIconJOISection;

	@FindBy(xpath = "//*[@id='divFavTeacher']//tr[1]/td[3]/a[3]")
	private WebElement firstJobShareIconJOISection;

	@FindBy(xpath = "//*[@id='divFavTeacher']//a/strong")
	private WebElement linkSeeAllJOISection;
	
	@FindBy(xpath = "//*[@id='divJbInterest']//strong[text()='See All']")
	private WebElement linkSeeAllJASection;

	@FindBy(xpath = "//*[@id='footerbtn']/button[1]")
	private WebElement btnConfirmHideJob;
	
	@FindBy(xpath = "//*[@id='footerbtn']/button[1]")
	private WebElement btnConfirmWithdrawJob;

	@FindBy(id = "fname1")
	private WebElement txtBoxFirstFriendName;

	@FindBy(id = "fremail1")
	private WebElement txtBoxFirstFriendEmail;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement btnSubmit;

	@FindBy(xpath = "//*[@id='footerbtn1']/button")
	private WebElement btnOkMailSent;

	@FindBy(xpath = "//a[contains(@href,'searchby=avlbl')]")
	private WebElement linkNotAppliedJobsJOISection;

	@FindBy(xpath = "//a[contains(@href,'searchby=widrw')]")
	private WebElement linkWithdrawnJobsJOISection;
	
	@FindBy(xpath = "//*[@id='divJbInterest']//a[contains(@href,'comp')]")
	private WebElement linkCompletedJobsJASection;
	
	@FindBy(xpath = "//*[@id='divJbInterest']//a[contains(@href,'icomp')]")
	private WebElement linkIncompletedJobsJASection;

	@FindAll(@FindBy(xpath = "//*[@id='divJbInterest']//td[1]/a[contains(@href,'applyjob')]"))
	private List<WebElement> columnJobNameJASection;

	@FindAll(@FindBy(xpath = "//*[@id='divJbInterest']//td[3]/a[@data-original-title='Withdraw']"))
	private List<WebElement> columnWithdrawIconJASection;

	//@FindAll(@FindBy(xpath = "//*[@id='divJbInterest']//td[3]/a[@data-original-title='Cover Letter']"))
	

	@FindAll(@FindBy(xpath = "//*[@id='divJbInterest']/table/tbody/tr[1]/td[3]/a[@data-original-title='Cover Letter']"))

	
	
	private List<WebElement> columnCoverLetterIconJASection;

	@FindAll(@FindBy(xpath = "//*[@id='divJbInterest']//td[3]/a[@data-original-title='Update Portfolio']"))
	private List<WebElement> columnUpdatePortfolioIconJASection;

	@FindAll(@FindBy(xpath = "//*[@id='divJbInterest']//td[3]/a[@data-original-title='Share']"))
	private List<WebElement> columnShareIconJASection;

	@FindAll(@FindBy(xpath = "//*[@id='divJbInterest']//td[3]/a[@data-original-title='QQ']"))
	private List<WebElement> columnQQIconJASection;

	public WebElement getMenuDashboard() {
		if (commonLib.isDisplayed(menuDashboard)) {
			return menuDashboard;
		} else {
			return null;
		}
	}

	public WebElement getIconJobPreferences() {
		if (commonLib.isDisplayed(iconJobPreferences)) {
			return iconJobPreferences;
		} else {
			return null;
		}
	}

	public WebElement getIconPowerProfile() {
		if (commonLib.isDisplayed(iconPowerProfile)) {
			return iconPowerProfile;
		} else {
			return null;
		}
	}

	public WebElement getIconPortfolio() {
		if (commonLib.isDisplayed(iconPortfolio)) {
			return iconPortfolio;
		} else {
			return null;
		}
	}

	public WebElement getIconPortfolioReport() {
		if (commonLib.isDisplayed(iconPortfolioReport)) {
			return iconPortfolioReport;
		} else {
			return null;
		}
	}

	public WebElement getIconFirstApplyNow() {
		if (commonLib.isDisplayed(iconFirstApplyNow)) {
			return iconFirstApplyNow;
		} else {
			return null;
		}
	}

	public WebElement getFirstJobNameJOISection() {
		if (commonLib.isDisplayed(firstJobNameJOISection)) {
			return firstJobNameJOISection;
		} else {
			return null;
		}
	}

	public List<WebElement> getAllJobNamesJOISection() {
		if (commonLib.isDisplayed(allJobNamesJOISection)) {
			return allJobNamesJOISection;
		} else {
			return null;
		}
	}

	public WebElement getFirstJobHideIconJOISection() {
		if (commonLib.isDisplayed(firstJobHideIconJOISection)) {
			return firstJobHideIconJOISection;
		} else {
			return null;
		}
	}

	public WebElement getFirstJobShareIconJOISection() {
		if (commonLib.isDisplayed(firstJobShareIconJOISection)) {
			return firstJobShareIconJOISection;
		} else {
			return null;
		}
	}

	public WebElement getLinkSeeAllJOISection() {
		if (commonLib.isDisplayed(linkSeeAllJOISection)) {
			return linkSeeAllJOISection;
		} else {
			return null;
		}
	}

	public WebElement getLinkSeeAllJASection() {
		if (commonLib.isDisplayed(linkSeeAllJASection)) {
			return linkSeeAllJASection;
		} else {
			return null;
		}
	}

	public WebElement getBtnConfirmHideJob() {
		if (commonLib.isDisplayed(btnConfirmHideJob)) {
			return btnConfirmHideJob;
		} else {
			return null;
		}
	}

	public WebElement getBtnConfirmWithdrawJob() {
		if (commonLib.isDisplayed(btnConfirmWithdrawJob)) {
			return btnConfirmWithdrawJob;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxFirstFriendName() {
		if (commonLib.isDisplayed(txtBoxFirstFriendName)) {
			return txtBoxFirstFriendName;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxFirstFriendEmail() {
		if (commonLib.isDisplayed(txtBoxFirstFriendEmail)) {
			return txtBoxFirstFriendEmail;
		} else {
			return null;
		}
	}

	public WebElement getBtnSubmit() {
		if (commonLib.isDisplayed(btnSubmit)) {
			return btnSubmit;
		} else {
			return null;
		}
	}

	public WebElement getBtnOkMailSent() {
		if (commonLib.isDisplayed(btnOkMailSent)) {
			return btnOkMailSent;
		} else {
			return null;
		}
	}

	public WebElement getLinkNotAppliedJobsJOISection() {
		if (commonLib.isDisplayed(linkNotAppliedJobsJOISection)) {
			return linkNotAppliedJobsJOISection;
		} else {
			return null;
		}
	}

	public WebElement getLinkWithdrawnJobsJOISection() {
		if (commonLib.isDisplayed(linkWithdrawnJobsJOISection)) {
			return linkWithdrawnJobsJOISection;
		} else {
			return null;
		}
	}

	public WebElement getLinkCompletedJobsJASection() {
		if (commonLib.isDisplayed(linkCompletedJobsJASection)) {
			return linkCompletedJobsJASection;
		} else {
			return null;
		}
	}

	public WebElement getLinkIncompletedJobsJASection() {
		if (commonLib.isDisplayed(linkIncompletedJobsJASection)) {
			return linkIncompletedJobsJASection;
		} else {
			return null;
		}
	}

	public List<WebElement> getColumnJobNameJASection() {
		if (commonLib.isDisplayed(columnJobNameJASection)) {
			return columnJobNameJASection;
		} else {
			return null;
		}
	}

	public List<WebElement> getColumnWithdrawIconJASection() {
		if (commonLib.isDisplayed(columnWithdrawIconJASection)) {
			return columnWithdrawIconJASection;
		} else {
			return null;
		}
	}

	public List<WebElement> getColumnCoverLetterIconJASection() {
		if (commonLib.isDisplayed(columnCoverLetterIconJASection)) {
			return columnCoverLetterIconJASection;
		} else {
			return null;
		}
	}

	public List<WebElement> getColumnUpdatePortfolioIconJASection() {
		if (commonLib.isDisplayed(columnUpdatePortfolioIconJASection)) {
			return columnUpdatePortfolioIconJASection;
		} else {
			return null;
		}
	}

	public List<WebElement> getColumnShareIconJASection() {
		if (commonLib.isDisplayed(columnShareIconJASection)) {
			return columnShareIconJASection;
		} else {
			return null;
		}
	}

	public List<WebElement> getColumnQQIconJASection() {
		if (commonLib.isDisplayed(columnQQIconJASection)) {
			return columnQQIconJASection;
		} else {
			return null;
		}
	}

}
