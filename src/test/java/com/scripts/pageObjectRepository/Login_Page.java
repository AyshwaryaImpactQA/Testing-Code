package com.scripts.pageObjectRepository;

/**
* Created by : Abhilash Sharma
* Login.java
* Sep 6, 2018
* Purpose : Description details
*/


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

/**
* @author abhilash.sharma
*
*/
public class Login_Page {

	    CommonUtills commonLib = new CommonUtills();
	    
	    @FindBy(id = "pmlogin")
	    private WebElement gobutton;
	    
	    

	    @FindBy(name = "username")
	    private WebElement txtBoxUsername;

	    @FindBy(name = "password")
	    private WebElement txtBoxPassword;

	    @FindBy(css = "input.btn.btn-success")
	    private WebElement BtnLogin;

	    @FindBy(partialLinkText = "Need new password?")
	    private WebElement linkForgotPassword;

	    
	    public WebElement clickonGobutton() {
	        if (commonLib.isDisplayed(gobutton)) {
	            return gobutton;
	        } else {
	            return null;
	        }
	    }
	    
	    
	public WebElement getTxtBoxUsername() {
	    return txtBoxUsername;
	}

	public WebElement getTxtBoxPassword() {
	    
	        return txtBoxPassword;
	    }


	public WebElement getBtnLogin() {
	    if (commonLib.isDisplayed(BtnLogin)) {
	        return BtnLogin;
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
	}
	

