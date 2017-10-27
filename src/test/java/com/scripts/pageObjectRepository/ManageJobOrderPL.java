package com.scripts.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.scripts.lib.commonFunction.CommonUtills;

public class ManageJobOrderPL {

	CommonUtills commonLib = new CommonUtills();

	@FindBy(id = "menuid4")
	private WebElement btnMenuJobOrders;

	@FindBy(id = "submenuid41")
	private WebElement menuOptnDJO;

	@FindBy(id = "submenuid42")
	private WebElement menuOptnSJO;

	@FindBy(id = "searchTerm")
	private WebElement txtBoxKeywordSearch;

	@FindBy(id = "districtORSchoolName")
	private WebElement txtBoxDistrict;

	@FindBy(id = "jobOrderId")
	private WebElement txtBoxJobID;
	
	@FindBy(id = "searchTerm")
	private WebElement txtBoxJobTitle;

	public WebElement getTxtBoxJobTitle() {
		if (commonLib.isDisplayed(txtBoxJobTitle)) {
			return txtBoxJobTitle;
		} else {
			return null;
		}
	}

	@FindBy(id = "jeffcoButtonSearchHide")
	private WebElement btnSearchJobs;

	@FindAll(@FindBy(xpath = "//table[@id='tblGrid']//td[3]"))
	private List<WebElement> linkJobTitle;

	@FindAll(@FindBy(xpath = "//table[@id='tblGrid']//td[15]/a"))
	private List<WebElement> linkCGIconTM;

	@FindAll(@FindBy(xpath = "//*[@id='tblGrid']/tbody/tr/td[10]"))
	private List<WebElement> linkCGIconDA;
	
	public WebElement getFirstlinkCGIconDA() {
		if (commonLib.isDisplayed(FirstlinkCGIconDA)) {
			return FirstlinkCGIconDA;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "(//span[@class='icon-table icon-large'])[1]")
	private WebElement FirstlinkCGIconDA;

	@FindBy(xpath = "//table[@id='tblGrid']//tr[1]/td[11]/a")
	private WebElement linkCGIconSA;
	
	@FindAll(@FindBy(xpath = "//*[@id='tblGrid']/tbody/tr[1]/td[1]"))
	private List<WebElement> linkJobId;
	
	@FindBy(xpath = "//*[@id='incompasc']/span")
	private WebElement expandCandidatesGrid;

	@FindAll(@FindBy(xpath = "//span[@id='divInCompCGGrid']//tbody//a[3]"))
	private List<WebElement> candidatesEmails;

	public WebElement getExpandCandidatesGrid() {
		if (commonLib.isDisplayed(expandCandidatesGrid)) {
			return expandCandidatesGrid;
		} else {
			return null;
		}
	}

	public List<WebElement> getCandidatesEmails() {
		if (commonLib.isDisplayed(candidatesEmails)) {
			return candidatesEmails;
		} else {
			return null;
		}
	}

	public List<WebElement> getLinkJobId() {
		if (commonLib.isDisplayed(linkJobId)) {
			return linkJobId;
		} else {
			return null;
		}
	}

	public WebElement getBtnMenuJobOrders() {
		if (commonLib.isDisplayed(btnMenuJobOrders)) {
			return btnMenuJobOrders;
		} else {
			return null;
		}
	}

	public WebElement getMenuOptnDJO() {
		if (commonLib.isDisplayed(menuOptnDJO)) {
			return menuOptnDJO;
		} else {
			return null;
		}
	}

	public WebElement getMenuOptnSJO() {
		if (commonLib.isDisplayed(menuOptnSJO)) {
			return menuOptnSJO;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxKeywordSearch() {
		if (commonLib.isDisplayed(txtBoxKeywordSearch)) {
			return txtBoxKeywordSearch;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxDistrict() {
		if (commonLib.isDisplayed(txtBoxDistrict)) {
			return txtBoxDistrict;
		} else {
			return null;
		}
	}

	public WebElement getTxtBoxJobID() {
		if (commonLib.isDisplayed(txtBoxJobID)) {
			return txtBoxJobID;
		} else {
			return null;
		}
	}

	public WebElement getBtnSearchJobs() {
		if (commonLib.isDisplayed(btnSearchJobs)) {
			return btnSearchJobs;
		} else {
			return null;
		}
	}

	public List<WebElement> getLinkJobTitle() {
		if (commonLib.isDisplayed(linkJobTitle)) {
			return linkJobTitle;
		} else {
			return null;
		}
	}

	public List<WebElement> getLinkCGIconTM() {
		if (commonLib.isDisplayed(linkCGIconTM)) {
			return linkCGIconTM;
		} else {
			return null;
		}
	}

	public List<WebElement> getLinkCGIconDA() {
		if (commonLib.isDisplayed(linkCGIconDA)) {
			return linkCGIconDA;
		} else {
			return null;
		}
	}

	public WebElement getLinkCGIconSA() {
		if (commonLib.isDisplayed(linkCGIconSA)) {
			return linkCGIconSA;
		} else {
			return null;
		}
	}

}
