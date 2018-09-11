package com.scripts.businessLogic;

import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;
import com.scripts.lib.commonFunction.Driver;

import com.scripts.pageObjectRepository.Manage_Org_Page;

public class Manage_Org_Page_BL extends Driver{

//	CommonUtills cu = null;
	Manage_Org_Page orgPl =PageFactory.initElements(driver, Manage_Org_Page.class);
	
	CommonUtills cu = new CommonUtills();
	 
// For Click on the page DropDown
	
	public void dropdownClick() throws InterruptedException {
		cu.click(orgPl.getNameDropDown());
		 cu.waitForPageToLoad();
		}
	
	//For Manage Organization
	public void manageOrganizationButton() {
		
		cu.click(orgPl.getManageOrglink());
		
	}
	
	
	
	//Print Page Title 
		public void nameOfPage(String name) {
			
		boolean value =	cu.pageName(name);
		if (value) {
			System.out.println(name);
		}
		else {
			System.out.println("Page Title is not Correct");
		}
		}
		

	
}
