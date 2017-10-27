package com.scripts.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class JobPreferencesPL {
	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid4")
	private WebElement jobPrefrences;

	@FindBy(xpath = "//label[@class='checkbox']//input[not(@name='regions')][not(@name='isAffilated')]")
	private List<WebElement> checkBoxPrefrences;

	@FindBy(xpath = "//*[@id='userpreferences']//button")
	private WebElement btnSavePreferences;

	@FindBy(xpath = "//label[contains(@class,'checkbox show')]//input[@type='checkbox']")
	private List<WebElement> chkBxRegions;

	@FindBy(xpath = "//label[contains(@class,'checkbox')]//input[@type='checkbox']")
	private List<WebElement> chkBxGeoType;

	@FindBy(xpath = "//div[contains(text(),'Please set the preferences first.')]")
	private WebElement setPrefPopUp;

	@FindBy(xpath = "//*[@id='setPrefences_Modal']//button[text()='Close']")
	private WebElement setPrefPopUpClose;

	@FindBy(xpath = "//tr[td[contains(text(), 'Job Preferences')]]//strong")
	private WebElement jobPreferenceStatus;
	
	@FindBy(xpath = "//*[@id='resumeDisagreementLabel']/input")
	private List<WebElement> radioBtnProfileSharing;

//	public WebElement getSharingStatus() {
//		if (commonLib.isDisplayed(sharingStatus)) {
//			return sharingStatus;
//		} else {
//			return null;
//		}
//	}

	public List<WebElement> getRadioBtnProfileSharing() {
		if (commonLib.isDisplayed(radioBtnProfileSharing)) {
			return radioBtnProfileSharing;
		} else {
			return null;
		}
	}

	public WebElement getJobPrefrences() {
		if (commonLib.isDisplayed(jobPrefrences)) {
			return jobPrefrences;
		} else {
			return null;
		}
	}

	public List<WebElement> getCheckBoxPrefrences() {
		if (commonLib.isDisplayed(checkBoxPrefrences)) {
			return checkBoxPrefrences;
		} else {
			return null;
		}
	}

	public WebElement getBtnSavePreferences() {
		if (commonLib.isDisplayed(btnSavePreferences)) {
			return btnSavePreferences;
		} else {
			return null;
		}
	}

	public List<WebElement> getChkBxRegions() {
		if (commonLib.isDisplayed(chkBxRegions)) {
			return chkBxRegions;
		} else {
			return null;
		}
	}

	public List<WebElement> getChkBxGeoType() {
		if (commonLib.isDisplayed(chkBxGeoType)) {
			return chkBxGeoType;
		} else {
			return null;
		}
	}

	public WebElement getSetPrefPopUp() {
		if (commonLib.isDisplayed(setPrefPopUp)) {
			return setPrefPopUp;
		} else {
			return null;
		}
	}

//	public WebElement getRadioBtnProfileSharing() {
//		if (commonLib.isDisplayed(radioBtnProfileSharing)) {
//			return radioBtnProfileSharing;
//		} else {
//			return null;
//		}
//	}

	public WebElement getSetPrefPopUpClose() {
		if (commonLib.isDisplayed(setPrefPopUpClose)) {
			return setPrefPopUpClose;
		} else {
			return null;
		}
	}

	public WebElement getJobPreferenceStatus() {
		if (commonLib.isDisplayed(jobPreferenceStatus)) {
			return jobPreferenceStatus;
		} else {
			return null;
		}
	}

}
