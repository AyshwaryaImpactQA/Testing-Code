package com.scripts.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.scripts.businessLogic.Manage_Org_Page_BL;
import com.scripts.pageObjectRepository.Manage_Org_Page;

public class Manage_Org_Page_TC {
	Manage_Org_Page orgPl;
	Manage_Org_Page_BL orgBl;
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		}
	
	
	@Test(description = "SA-2532:ORG: Smoke Test")
	public void SA_2532() throws InterruptedException {
		orgBl = new Manage_Org_Page_BL();
		
		orgBl.dropdownClick();
		orgBl.manageOrganizationButton();
		orgBl.nameOfPage("Unify Organizations");
		
		
	}
	
	
	
}
