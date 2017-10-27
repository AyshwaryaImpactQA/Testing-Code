package com.scripts.businessLogic;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.ApplyForJobsPL;
import com.scripts.pageObjectRepository.CandidateDashboardPL;
import com.scripts.pageObjectRepository.CandidatePortfolioPL;
import com.scripts.pageObjectRepository.JobPreferencesPL;

public class CandidateDashboardBL extends Driver {

	CandidateDashboardPL candidateDashboardPage = PageFactory.initElements(
			driver, CandidateDashboardPL.class);
	JobPreferencesPL jobPreferencePage = PageFactory.initElements(driver,
			JobPreferencesPL.class);
	CandidatePortfolioPL portfolioPage = PageFactory.initElements(driver,
			CandidatePortfolioPL.class);
	ApplyForJobsPL applyForJobsPage = PageFactory.initElements(driver,
			ApplyForJobsPL.class);
	CommonUtills commonLib = new CommonUtills();
	String parentWindow, jobName;

	public void navigateToDashboardPage() throws Exception {
		commonLib.waitForPageToLoadWithCond(candidateDashboardPage.getMenuDashboard());
		commonLib.click(candidateDashboardPage.getMenuDashboard(),
				"Dashboard Menu");
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
	}

	public void switchToChildWindow(String parentWindow) {
		Set<String> windows = driver.getWindowHandles();
		for (String temp : windows) {
			if (!temp.equals(parentWindow)) {
				driver.switchTo().window(temp);
				break;
			}
		}
	}

	public void verifyPersonalPlanningSection() throws Exception {
		verifyJobPreferencesRedirection();
		verifyPowerProfileRedirection();
		verifyPortfolioRedirection();
	}

	public void verifyJobPreferencesRedirection() throws Exception {
		commonLib.logOnInfo("Job Preferences Redirection",
				"Verifying Job Preferences Redirection");
		commonLib.click(candidateDashboardPage.getIconJobPreferences(),
				"Job Preferences Icon");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(jobPreferencePage.getBtnSavePreferences())) {
			commonLib.logOnSuccess("Job Preferences Redirection",
					"Job Preferences Redirection passed");
		} else {
			commonLib.logOnError("Job Preferences Redirection",
					"Job Preferences Redirection failed");
		}
		navigateToDashboardPage();
	}

	public void verifyPowerProfileRedirection() throws Exception {
		commonLib.logOnInfo("Power Profile Redirection",
				"Verifying Power Profile Redirection");
		parentWindow = driver.getWindowHandle();
		commonLib.click(candidateDashboardPage.getIconPowerProfile(),
				"Power Profile Icon");
		commonLib.waitForPageToLoad();
		Thread.sleep(3000);
		switchToChildWindow(parentWindow);
		if (driver.getTitle().equals("Power Profile Index")) {
			commonLib.logOnSuccess("Power Profile Redirection",
					"Power Profile Redirection passed");
		} else {
			commonLib.logOnError("Power Profile Redirection",
					"Power Profile Redirection failed");
		}
		driver.close();
		driver.switchTo().window(parentWindow);
	}

	public void verifyPortfolioRedirection() throws Exception {
		commonLib.logOnInfo("Portfolio Redirection",
				"Verifying Portfolio Redirection");
		commonLib.click(candidateDashboardPage.getIconPortfolio(),
				"Portfolio Icon");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(portfolioPage.getTxtBoxFirstName())) {
			commonLib.logOnSuccess("Portfolio Redirection",
					"Portfolio Redirection passed");
		} else {
			commonLib.logOnError("Portfolio Redirection",
					"Portfolio Redirection failed");
		}
		navigateToDashboardPage();
	}

	public void verifyCommunicationSection() throws Exception {
		commonLib.logOnInfo("Verify Portfolio Report",
				"Verifying Portfolio Report");
		parentWindow = driver.getWindowHandle();
		commonLib.waitForPageToLoadWithCond(candidateDashboardPage.getIconPortfolioReport());
		commonLib.click(candidateDashboardPage.getIconPortfolioReport(),
				"Portfolio Report Icon");
		commonLib.waitForPageToLoad();
		commonLib.logOnSuccess("Verify Portfolio Report",
				"Portfolio Report saved sucessfully");
	}

	public void verifyJobsOfInterestSection() throws Exception {
		verifyApplyNowIconRedirection();
		hideUnhideJob();
		shareJob();
		verifyNotAppliedLinkRedirection();
		//verifyWithdrawnLinkRedirection();
	}

	public void verifyApplyNowIconRedirection() throws Exception {
		commonLib.logOnInfo("Verify Apply Now Redirection",
				"Verifying Apply Now Redirection");
		commonLib.click(candidateDashboardPage.getIconFirstApplyNow(),
				"Apply Now Icon");
		commonLib.waitForPageToLoad();
		Thread.sleep(3000);
		if (commonLib.isDisplayed(applyForJobsPage.getBtnApplyforJob())) {
			commonLib.logOnSuccess("Verify Apply Now Redirection",
					"Apply Now Redirection passed");
		} else {
			commonLib.logOnError("Verify Apply Now Redirection",
					"Apply Now Redirection failed");
		}
		navigateToDashboardPage();
	}

	public void hideUnhideJob() throws Exception {
		commonLib.logOnInfo("Hide Job", "Hiding job");
		jobName = commonLib.getText(candidateDashboardPage
				.getFirstJobNameJOISection());
		commonLib.click(candidateDashboardPage.getFirstJobHideIconJOISection(),
				"Hide Icon");
		commonLib.waitForPageToLoadWithCond(candidateDashboardPage.getBtnConfirmHideJob());
		commonLib.click(candidateDashboardPage.getBtnConfirmHideJob(), "Ok Btn");
		Thread.sleep(2000);
		Thread.sleep(10000);
		commonLib.waitForPageToLoadWithCond(candidateDashboardPage.getFirstJobNameJOISection());
		
		String newJobName = commonLib.getText(candidateDashboardPage.getFirstJobNameJOISection());
		
		if (!jobName.equals(newJobName)) {
			commonLib.logOnSuccess("Hide Job", "Job is hidden");
		} else {
			commonLib.logOnError("Hide Job", "Job is not hidden");
		}
		commonLib.logOnInfo("Unhide Job", "Unhiding the hidden job");
		
		commonLib.waitForPageToLoadWithCond(candidateDashboardPage.getLinkSeeAllJOISection());
		commonLib.click(candidateDashboardPage.getLinkSeeAllJOISection(),"See All Link");
		Thread.sleep(20000);
		commonLib.waitForPageToLoadWithCond(applyForJobsPage.getBtnSearch());
		commonLib.selectDrpDownValue(applyForJobsPage.getDrpDownStatus(),"Hidden", "Status Drpdown");
		commonLib.click(applyForJobsPage.getBtnSearch(), "Search Btn");
		commonLib.waitForPageToLoad();
		Thread.sleep(10000);
		commonLib.waitForPageToLoadWithCond(applyForJobsPage.getBtnSearch());
		
		List<WebElement> columnJobTitle = applyForJobsPage.getColumnJobTitle();
		List<WebElement> jobActionIcons = applyForJobsPage.getJobActionIcons();
		for (int i = 0; i < columnJobTitle.size(); i++) {
			if (commonLib.getText(columnJobTitle.get(i)).equals(jobName)) {
				commonLib.click(jobActionIcons.get(i), "Unhide Icon");
				commonLib.waitForPageToLoad();
				break;
			}
		}
		commonLib.waitForPageToLoadWithCond(applyForJobsPage.getBtnConfirmUnhide());
		commonLib.click(applyForJobsPage.getBtnConfirmUnhide(), "Ok Btn");
		commonLib.waitForPageToLoad();
		navigateToDashboardPage();

		List<WebElement> allJobNamesJOISection = candidateDashboardPage
				.getAllJobNamesJOISection();
		for (WebElement temp : allJobNamesJOISection) {
			if (commonLib.getText(temp).equals(jobName)) {
				commonLib.logOnSuccess("Unhide Job", "Job is available");
				return;
			}
		}
		commonLib.logOnError("Unhide Job", "Job is not available");
	}

	public void shareJob() throws Exception {
		commonLib.logOnInfo("Share Job", "Sharing the job with friend");
		jobName = commonLib.getText(candidateDashboardPage
				.getFirstJobNameJOISection());
		commonLib.click(
				candidateDashboardPage.getFirstJobShareIconJOISection(),
				"Share Icon");
		commonLib.waitForPageToLoad();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(9999);
		String name = "Name" + randomInt;
		String email = name + "@mailinator.com";
		commonLib.typeText(candidateDashboardPage.getTxtBoxFirstFriendName(),
				name, "First Friend's Name TxtBox");
		commonLib.typeText(candidateDashboardPage.getTxtBoxFirstFriendEmail(),
				email, "First Friend's Email TxtBox");
		commonLib.click(candidateDashboardPage.getBtnSubmit(), "Submit Btn");
		commonLib.waitForPageToLoad();
		if (commonLib.isDisplayed(candidateDashboardPage.getBtnOkMailSent())) {
			commonLib.logOnSuccess("Share Job", "Job is shared with friend");
			commonLib.click(candidateDashboardPage.getBtnOkMailSent(), "Ok Btn");
			commonLib.waitForPageToLoad();
		} else {
			commonLib.logOnError("Share Job", "Job is not shared with friend");
		}
		// driver.get("https://www.mailinator.com/");
		// commonLib.waitForPageToLoad();
	}

	public void verifyNotAppliedLinkRedirection() throws Exception {
		commonLib.logOnInfo("Verify Not Applied Link Redirection",
				"Verifying Not Applied Link Redirection");
		commonLib.waitForPageToLoadWithCond(candidateDashboardPage.getLinkNotAppliedJobsJOISection());
		commonLib.click(candidateDashboardPage.getLinkNotAppliedJobsJOISection(),"Not Applied Jobs Link");
		Thread.sleep(20000);
		/*commonLib.waitForPageToLoad();
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(applyForJobsPage.getDrpDownStatus()));*/
		commonLib.waitForPageToLoadWithCond(applyForJobsPage.getDrpDownStatus());
		Select drpDownStatus = new Select(applyForJobsPage.getDrpDownStatus());
		String status = commonLib.getText(drpDownStatus.getFirstSelectedOption());
		if (status.equals("Available")) {
			commonLib.logOnSuccess("Verify Not Applied Link Redirection",
					"Not Applied Link redirection passed");
		} else {
			commonLib.logOnError("Verify Not Applied Link Redirection",
					"Not Applied Link redirection failed");
		}
		navigateToDashboardPage();
	}

	public void verifyWithdrawnLinkRedirection() throws Exception {
		commonLib.logOnInfo("Verify Withdrawn Link Redirection",
				"Verifying Withdrawn Link Redirection");
		if (commonLib.isDisplayed(candidateDashboardPage
				.getLinkWithdrawnJobsJOISection())) {
			commonLib.click(
					candidateDashboardPage.getLinkWithdrawnJobsJOISection(),
					"Withdrawn Jobs Link");
			commonLib.waitForPageToLoad();
			Thread.sleep(5000);
			Select drpDownStatus = new Select(
					applyForJobsPage.getDrpDownStatus());
			String status = commonLib.getText(drpDownStatus
					.getFirstSelectedOption());
			if (status.equals("Withdrawn")) {
				commonLib.logOnSuccess("Verify Withdrawn Link Redirection",
						"Withdrawn Link redirection passed");
			} else {
				commonLib.logOnError("Verify Withdrawn Link Redirection",
						"Withdrawn Link redirection failed");
			}
			navigateToDashboardPage();
		} else {
			commonLib.logOnSuccess("Verify Withdrawn Link Redirection",
					"There is no withdrawn jobs available");
		}
	}

	public void verifyJobApplicationSection() throws Exception {
		verifyCoverLetterRedirection();
		shareJobJASection();
		//verifyQQRedirection();
		withdrawJob();
		verifySeeAllLinkJASection();
		verifyCompletedLinkRedirection();
		verifyIncompletedLinkRedirection();
	}

	public void withdrawJob() throws Exception {
		commonLib.logOnInfo("Withdraw Job", "Withdrawing the job");
		List<WebElement> columnJobNameJASection = candidateDashboardPage
				.getColumnJobNameJASection();
		List<WebElement> columnWithdrawIconJASection = candidateDashboardPage
				.getColumnWithdrawIconJASection();
		if (columnJobNameJASection.size() > 1) {
			jobName = commonLib.getText(columnJobNameJASection.get(0));
			commonLib.click(columnWithdrawIconJASection.get(0), "Withdraw Icon");
			commonLib.waitForPageToLoad();
			commonLib.waitForPageToLoadWithCond(candidateDashboardPage.getBtnConfirmWithdrawJob());
			commonLib.click(candidateDashboardPage.getBtnConfirmWithdrawJob(),
					"Ok Btn");
			Thread.sleep(8000);
			
			columnJobNameJASection = candidateDashboardPage.getColumnJobNameJASection();
			for (WebElement job : columnJobNameJASection) {
				if (commonLib.getText(job).equals(jobName)) {
					commonLib.logOnError("Withdraw Job", "Job is not withdrawn");
					return;
				}
			}
			commonLib.logOnSuccess("Withdraw Job",
					"Job is withdrawn successfully");
		} else {
			commonLib.logOnInfo("Withdraw Job",
					"Only 1 job is there so not withdrawing");
		}

	}

	public void verifyCoverLetterRedirection() throws Exception {
		commonLib.logOnInfo("Verify Cover Letter Redirection",
				"Verifying cover letter icon redirection");
		
		List<WebElement> columnCoverLetterIconJASection = candidateDashboardPage
				.getColumnCoverLetterIconJASection();
		commonLib.click(columnCoverLetterIconJASection.get(0),
				"Cover Letter Icon");
		commonLib.waitForPageToLoadWithCond(applyForJobsPage.getHeaderCoverLetter());
		if (commonLib.isDisplayed(applyForJobsPage.getHeaderCoverLetter())) {
			commonLib.logOnSuccess("Verify Cover Letter Redirection",
					"Cover letter icon redirection passed");
			commonLib.click(applyForJobsPage.getBtnCloseCoverLetter(),
					"Close Btn");
			commonLib.waitForPageToLoad();
		} else {
			commonLib.logOnError("Verify Cover Letter Redirection",
					"Cover letter icon redirection failed");
		}
	}

	public void verifyUpdatePortfolioRedirection() throws Exception {
		commonLib.logOnInfo("Verify Update Portfolio Redirection",
				"Verifying update portfolio icon redirection");
		List<WebElement> columnUpdatePortfolioIconJASection = candidateDashboardPage
				.getColumnUpdatePortfolioIconJASection();
		commonLib.click(columnUpdatePortfolioIconJASection.get(0),
				"Update Portfolio Icon");
		commonLib.waitForPageToLoad();
		Thread.sleep(5000);
		if (commonLib.isDisplayed(applyForJobsPage.getBtnCloseDSPQ())) {
			commonLib.logOnSuccess("Verify Update Portfolio Redirection",
					"Update portfolio icon redirection passed");
			commonLib.click(applyForJobsPage.getBtnCloseDSPQ(), "Close Btn");
			commonLib.waitForPageToLoad();
		} else {
			commonLib.logOnError("Verify Update Portfolio Redirection",
					"Update portfolio icon redirection failed");
		}
	}

	public void shareJobJASection() throws Exception {
		commonLib.logOnInfo("Share Job", "Sharing the job with friend");
		commonLib.waitForPageToLoadWithCond(candidateDashboardPage.getFirstJobNameJOISection());
		jobName = commonLib.getText(candidateDashboardPage.getFirstJobNameJOISection());
		List<WebElement> columnShareIconJASection = candidateDashboardPage
				.getColumnShareIconJASection();
		commonLib.click(columnShareIconJASection.get(0), "Share Icon");
		commonLib.waitForPageToLoad();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(9999);
		String name = "Name" + randomInt;
		String email = name + "@mailinator.com";
		commonLib.waitForPageToLoadWithCond(candidateDashboardPage.getTxtBoxFirstFriendName());
		commonLib.typeText(candidateDashboardPage.getTxtBoxFirstFriendName(),
				name, "First Friend's Name TxtBox");
		commonLib.typeText(candidateDashboardPage.getTxtBoxFirstFriendEmail(),
				email, "First Friend's Email TxtBox");
		commonLib.click(candidateDashboardPage.getBtnSubmit(), "Submit Btn");
		
		commonLib.waitForPageToLoadWithCond(candidateDashboardPage.getBtnOkMailSent());
		if (commonLib.isDisplayed(candidateDashboardPage.getBtnOkMailSent())) {
			commonLib.logOnSuccess("Share Job", "Job is shared with friend");
			commonLib
					.click(candidateDashboardPage.getBtnOkMailSent(), "Ok Btn");
			commonLib.waitForPageToLoad();
		} else {
			commonLib.logOnError("Share Job", "Job is not shared with friend");
		}
		// driver.get("https://www.mailinator.com/");
		// commonLib.waitForPageToLoad();
	}

	public void verifyQQRedirection() throws Exception {
		commonLib.logOnInfo("Verify QQ Redirection","Verifying QQ icon redirection");
		commonLib.waitForPageToLoad();
		List<WebElement> columnQQIconJASection = candidateDashboardPage.getColumnQQIconJASection();
		commonLib.click(columnQQIconJASection.get(0), "QQ Icon");
		
		commonLib.waitForPageToLoadWithCond(applyForJobsPage.getBtnCloseDASpecificQQ());
		
		if (commonLib.isDisplayed(applyForJobsPage.getBtnCloseDASpecificQQ())) {
			commonLib.logOnSuccess("Verify QQ Redirection",
					"QQ icon redirection passed");
			commonLib.click(applyForJobsPage.getBtnCloseDASpecificQQ(),
					"Close Btn");
			commonLib.waitForPageToLoad();
		} 
		
		else if (commonLib.isDisplayed(applyForJobsPage.getBtnOKDASpecificQQ())) {
			commonLib.logOnSuccess("Verify QQ Redirection",
					"QQ icon redirection passed");
			commonLib.click(applyForJobsPage.getBtnOKDASpecificQQ(),
					"Close Btn");
			commonLib.waitForPageToLoad();
		} 
		else {
			commonLib.logOnError("Verify QQ Redirection",
					"QQ icon redirection failed");
		}
	}

	public void verifySeeAllLinkJASection() throws Exception {
		commonLib.logOnInfo("Verify 'See All' Link Redirection",
				"Verifying 'See All' link redirection");
		commonLib.waitForPageToLoadWithCond(candidateDashboardPage.getLinkSeeAllJASection());
		commonLib.click(candidateDashboardPage.getLinkSeeAllJASection(),
				"See All Link");
		commonLib.waitForPageToLoad();
		commonLib.waitForPageToLoadWithCond(applyForJobsPage.getDrpDownStatus());
		Select drpDownStatus = new Select(applyForJobsPage.getDrpDownStatus());
		String status = commonLib.getText(drpDownStatus.getFirstSelectedOption());
		if (status.equals("All")) {
			commonLib.logOnSuccess("Verify 'See All' Link Redirection",
					"'See All' link redirection passed");
		} else {
			commonLib.logOnError("Verify 'See All' Link Redirection",
					"'See All' link redirection failed");
		}
		navigateToDashboardPage();
	}

	public void verifyCompletedLinkRedirection() throws Exception {
		commonLib.logOnInfo("Verify Completed Link Redirection",
				"Verifying Completed link redirection");
		commonLib.waitForPageToLoadWithCond(candidateDashboardPage.getLinkCompletedJobsJASection());
		commonLib.click(candidateDashboardPage.getLinkCompletedJobsJASection(),
				"Completed Link");
		commonLib.waitForPageToLoad();
		commonLib.waitForPageToLoadWithCond(applyForJobsPage.getDrpDownStatus());
		Select drpDownStatus = new Select(applyForJobsPage.getDrpDownStatus());
		String status = commonLib.getText(drpDownStatus
				.getFirstSelectedOption());
		if (status.equals("Complete")) {
			commonLib.logOnSuccess("Verify Completed Link Redirection",
					"Completed link redirection passed");
		} else {
			commonLib.logOnError("Verify Completed Link Redirection",
					"Completed link redirection failed");
		}
		navigateToDashboardPage();
	}

	public void verifyIncompletedLinkRedirection() throws Exception {
		commonLib.logOnInfo("Verify Incompleted Link Redirection",
				"Verifying Incompleted link redirection");
		commonLib.waitForPageToLoadWithCond(candidateDashboardPage.getLinkIncompletedJobsJASection());
		if (commonLib.isDisplayed(candidateDashboardPage.getLinkIncompletedJobsJASection())) {
			commonLib.click(candidateDashboardPage.getLinkIncompletedJobsJASection(),"Incompleted Link");
			commonLib.waitForPageToLoad();
			commonLib.waitForPageToLoadWithCond(applyForJobsPage.getDrpDownStatus());
			
			Select drpDownStatus = new Select(applyForJobsPage.getDrpDownStatus());
			
			String status = commonLib.getText(drpDownStatus.getFirstSelectedOption());
			if (status.equals("Incomplete")) {
				commonLib.logOnSuccess("Verify Incompleted Link Redirection",
						"Incompleted link redirection passed");
			} else {
				commonLib.logOnError("Verify Incompleted Link Redirection",
						"Incompleted link redirection failed");
			}
		} else {
			commonLib.logOnInfo("Verify Incompleted Link Redirection",
					"There are not incomplete jobs");
		}
		navigateToDashboardPage();
	}
}
