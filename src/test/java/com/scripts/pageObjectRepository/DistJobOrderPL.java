package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class DistJobOrderPL {
	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid4")
	private WebElement btnMenuJobOrders;

	@FindBy(id = "submenuid41")
	private WebElement btnDistJobOrders;

	@FindBy(id = "isExpHireNotEqualToReqNo")
	private WebElement chkBoxMultipleHires;

	/**
	 * @return the btnMenuJobOrders
	 */
	public WebElement getBtnMenuJobOrders() {
		if (commonLib.isDisplayed(btnMenuJobOrders)) {
			return btnMenuJobOrders;
		} else {
			return null;
		}
	}

	/**
	 * @return the btnDistJobOrders
	 */
	public WebElement getBtnDistJobOrders() {
		if (commonLib.isDisplayed(btnDistJobOrders)) {
			return btnDistJobOrders;
		} else {
			return null;
		}
	}

	/**
	 * @return the chkBoxMultipleHires
	 */
	public WebElement getChkBoxMultipleHires() {
		if (commonLib.isDisplayed(chkBoxMultipleHires)) {
			return chkBoxMultipleHires;
		} else {
			return null;
		}
	}

}
