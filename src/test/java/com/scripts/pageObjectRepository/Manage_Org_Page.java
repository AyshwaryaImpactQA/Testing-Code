package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.scripts.lib.commonFunction.CommonUtills;

public class Manage_Org_Page {

	//WebDriver driver;
//	 CommonUtills cu = null;
	 CommonUtills cu = new CommonUtills();
//	public Manage_Org_Page(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//		CommonUtills cu = new CommonUtills();
//	}
//	
	//For Name DropDown
	@FindBy(className="fullname")
	private WebElement nameDropDown;

	public WebElement getNameDropDown() {
		if(cu.isDisplayed(nameDropDown)) {
			return nameDropDown;
		}
		else  {
			return null;
	}
	}
	
	
	//For Manage Organization
	@FindBy(linkText="Manage Organization")
	private WebElement manageOrglink;

	public WebElement getManageOrglink() {
		if(cu.isDisplayed(manageOrglink)) {
		return manageOrglink;
		}
		else {
			return null;
		}
	}
	
	
	
}







