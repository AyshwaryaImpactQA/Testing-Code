package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class LoginPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "emailAddress")
	private WebElement txtBoxUsername;

	@FindBy(id = "password")
	private WebElement txtBoxPassword;

	@FindBy(id = "submitLogin")
	private WebElement BtnLogin;

	@FindBy(xpath = "//button[contains(text(), 'Sign up')]")
	private WebElement BtnSignUp;

	@FindBy(partialLinkText = "Forgot Password?")
	private WebElement linkForgotPassword;

	@FindBy(xpath = "//span[@class = 'tabletbodyadmin']")
	private WebElement drpdownUserName;

	@FindBy(xpath = "//a[@href = 'logout.do']")
	private WebElement subMenuSignOut;

	@FindBy(xpath = "//a[@href = 'signin.do']")
	private WebElement linkSignOut;

	//@FindBy(id = "errordiv")
	@FindBy(xpath = "(//div[@id='divServerError'])[1]")
	private WebElement errorMessage;
	
	@FindBy(xpath = "//div[contains(text(),'• Please enter Email')]")
	private WebElement errorBlank;

	public WebElement getErrorBlank() {
		if (commonLib.isDisplayed(errorBlank)) {
			return errorBlank;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[contains(text(),'Invalid Email or Password.')]")
	private WebElement errorMessageInvalidPassword;

	public WebElement getTxtBoxUsername() {
		if (commonLib.isDisplayed(txtBoxUsername)) {
			return txtBoxUsername;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxPassword() {
		if (commonLib.isDisplayed(txtBoxPassword)) {
			return txtBoxPassword;
		} else {
			return null;
		}
	}

	public WebElement getBtnLogin() {
		if (commonLib.isDisplayed(BtnLogin)) {
			return BtnLogin;
		} else {
			return null;
		}
	}

	public WebElement getBtnSignUp() {
		if (commonLib.isDisplayed(BtnSignUp)) {
			return BtnSignUp;
		} else {
			return null;
		}
	}

	public WebElement getLinkForgotPassword() {
		if (commonLib.isDisplayed(linkForgotPassword)) {
			return linkForgotPassword;
		} else {
			return null;
		}
	}

	public WebElement getDrpdownUserName() {
		if (commonLib.isDisplayed(drpdownUserName)) {
			return drpdownUserName;
		} else {
			return null;
		}
	}

	public WebElement getSubMenuSignOut() {
		if (commonLib.isDisplayed(subMenuSignOut)) {
			return subMenuSignOut;
		} else {
			return null;
		}
	}

	public WebElement getLinkSignOut() {
		if (commonLib.isDisplayed(linkSignOut)) {
			return linkSignOut;
		} else {
			return null;
		}
	}

	public WebElement getErrorMessage() {
		if (commonLib.isDisplayed(errorMessage)) {
			return errorMessage;
		} else {
			return null;
		}
	}

	public WebElement getErrorMessageInvalidPassword() {
		if (commonLib.isDisplayed(errorMessageInvalidPassword)) {
			return errorMessageInvalidPassword;
		} else {
			return null;
		}
	}

}
