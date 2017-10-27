package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class HomePagePL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid2")
	private WebElement usersMenu;

	@FindBy(id = "submenuid21")
	private WebElement administratorAnalystMenu;

	public WebElement getUsersMenu() {
		if (commonLib.isDisplayed(usersMenu)) {
			return usersMenu;
		} else {
			return null;
		}
	}

	public WebElement getAdministratorAnalystMenu() {
		if (commonLib.isDisplayed(administratorAnalystMenu)) {
			return administratorAnalystMenu;
		} else {
			return null;
		}
	}

}
