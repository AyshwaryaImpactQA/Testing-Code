package com.scripts.pageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scripts.lib.commonFunction.CommonUtills;


public class Online_Scoring_Page {
	WebDriver driver;
	
	CommonUtills cu= null;
	
	
	public Online_Scoring_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		CommonUtills cu= new CommonUtills();
	}
	//Id and ClassName Locator is not available for Tests button
	@FindBy(id=" ")
	private WebElement testButtonTitlebar;
	
	@FindBy(linkText="Online Scoring")
	private WebElement onlineScoringButton;
	
	@FindBy(id="select2-test-selection-container")
	private WebElement testTilteBox;
	
	@FindBy(id="os-byStudent-view")
	private WebElement scoreByStudentButton;
	
	@FindBy(id="os--byItem-view")
	private WebElement scoreByItem;
	
	//For Second Item 
	@FindBy(id="select2-s8a3-container")
	private WebElement itemSecondDropDown;
	
	//For Ninth Item
	@FindBy(id="select2-oz7l-container")
	private WebElement itemNineDropDown;
	
	//For tenth Item
	@FindBy(id="select2-jint-container")
	private WebElement itemTenDropDown;
	
	//For twelveth Item
	@FindBy(id="select2-gh04-container")
	private WebElement itemTwelveDropDown;


	public WebElement getTestButtonTitlebar() {
		return testButtonTitlebar;
	}

	public WebElement getOnlineScoringButton() {
		return onlineScoringButton;
	}

	public WebElement getTestTilteBox() {
		return testTilteBox;
	}

	public WebElement getScoreByStudentButton() {
		return scoreByStudentButton;
	}

	public WebElement getScoreByItem() {
		return scoreByItem;
	}

	public WebElement getItemSecondDropDown() {
		return itemSecondDropDown;
	}

	public WebElement getItemNineDropDown() {
		return itemNineDropDown;
	}

	public WebElement getItemTenDropDown() {
		return itemTenDropDown;
	}

	public WebElement getItemTwelveDropDown() {
		return itemTwelveDropDown;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
