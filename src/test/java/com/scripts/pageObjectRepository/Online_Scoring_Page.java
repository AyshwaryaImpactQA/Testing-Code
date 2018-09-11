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
	
	public WebElement getTestButtonTitlebar() {
		if (cu.click(testButtonTitlebar)) {
			return testButtonTitlebar;
		} 
		else {
			return null;
		}
					
		}
		
	
	//For Online Scoring Button
	@FindBy(linkText="Online Scoring")
	private WebElement onlineScoringButton;
	
	public WebElement getOnlineScoringButton() {
		if (cu.click(onlineScoringButton)) {
		  return onlineScoringButton;
		}
		else {
			return null;
		}
		
	}
	
	
	//For Test Title Bar (for review)
	@FindBy(id="select2-test-selection-container")
	private WebElement testTilteBox;
	
	public WebElement getTestTilteBox() {
			if(cu.click(testTilteBox)) {
	            return testTilteBox;
				}
	else {
		return null;
	}
		}
		
	
			
	//for Searching Test in Test Title Bar
	@FindBy(className="select2-search__field")
	private WebElement testFieldOfTitleBar;
	
	public WebElement getTestFieldOfTitleBar() {
	   if(cu.typeText(testFieldOfTitleBar, "Test Name")) {
		return testFieldOfTitleBar;
	   }
	   else {
		   return null;
		   
	   }
	}
	
	//For Score By Student Tab (or Score By Item)
	@FindBy(id="os-byStudent-view")
	private WebElement scoreByStudentButton;
	
    public WebElement getScoreByStudentButton() {
		if(cu.click(scoreByStudentButton)) {
			return scoreByStudentButton;
		}else {
			
			return null;
		}
    	
	}

	//For Score By Item (or Score By Student Tab)
	@FindBy(id="os--byItem-view")
	private WebElement scoreByItem;
	
	public WebElement getScoreByItem() {
		if(cu.click(scoreByItem)) {
			return scoreByItem;
		}
		else {
			return null;
		}
		
	}
	
	//for Student Name Field
	@FindBy(id="select2-student-select-container")
	private WebElement studentDropDown;
	
	public WebElement getStudentDropDown() {
		if(cu.click(studentDropDown)) {
			return studentDropDown;
		}
		else {
			return null;
		}
	}
	
	//for Searching student in Student DropDown
	@FindBy(className="select2-search__field")
	private WebElement studentFieldDropDown;
	
	public WebElement getStudentFieldDropDown() {
		if(cu.typeText(studentFieldDropDown, "Text of Student Name")) {
		return studentFieldDropDown;
	}
		else {
			return null;
		}
	}
	
	
	//For Second Item 
	@FindBy(className="select2-selection__arrow")
	private WebElement itemSecondDropDown;
	
	public WebElement getItemSecondDropDown() {
		if(cu.click(itemSecondDropDown)) {
			return itemSecondDropDown;
		}
		else {
			
			return null;
		}
		
	}

	
	//For Ninth Item
	@FindBy(id="select2-oz7l-container")
	private WebElement itemNineDropDown;
	
	public WebElement getItemNineDropDown() {
		if(cu.click(itemNineDropDown)) {
		return itemNineDropDown;
		}
		else {
			return null;
		}
	}
	
	//For tenth Item
	@FindBy(id="select2-jint-container")
	private WebElement itemTenDropDown;
	
	public WebElement getItemTenDropDown() {
		return itemTenDropDown;
	}
	
	//For twelveth Item
	@FindBy(id="select2-gh04-container")
	private WebElement itemTwelveDropDown;

	public WebElement getItemTwelveDropDown() {
		return itemTwelveDropDown;
	}
	

	


	


	

	

	
	
	
 
	
	
	
	
	
	
	
	
	
	
	
	
	
}
