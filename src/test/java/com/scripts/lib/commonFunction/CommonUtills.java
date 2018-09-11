package com.scripts.lib.commonFunction;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import utils.report.template.LogStatus;
import utils.screenshot.Test_Utils;

public class CommonUtills extends Driver {
	private static final String SECONDS = null;
	boolean flag = false;
	private Long splittedText;
	private String originalWindowHandle;
	protected String username = System.getProperty("user.name");
	protected String project_path = System.getProperty("user.dir");
	private boolean b = false;
	private String user;
	private List<String> al1 = null;
	Test_Utils screenLib = new Test_Utils();
	JavascriptExecutor javascript = (JavascriptExecutor) driver;

	public void waitForPageToLoad() throws InterruptedException {
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(10000);
		
	}
	public void waitForPageToLoad(int time) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		Thread.sleep(time*1000);

	}
	
	public void screenshot(String stepName, String details) {
		reports.log(LogStatus.INFO, stepName, details);
		reports.attachScreenshot(screenLib.CaptureScreenshot(stepName, driver));
		APP_LOGS.debug(stepName + ": " + details);
		System.out.println(stepName + ": " + details);
	}
	
	public void waitForPageToLoadWithCond(final WebElement locator) throws InterruptedException {
		
/*	WebDriverWait wait=new WebDriverWait(driver, 15);
	wait.until(ExpectedConditions.visibilityOf(locator));*/
	
	
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(30, TimeUnit.SECONDS)
		      .pollingEvery(2, TimeUnit.SECONDS)
		      .ignoring(NoSuchElementException.class);

		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return locator;
		     }
		   });
	}
	
	public void pageRefresh() {
		driver.navigate().refresh();
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
		APP_LOGS.debug("Maximizing the window");
		System.out.println("Maximizing the window");
	}

	public boolean waitForElement(WebElement Element, String elementName) {
		if (Element != null) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(Element));
			APP_LOGS.debug(elementName + " is visible");
			System.out.println(elementName + " is visible");
			flag = true;
		} else {
			flag = false;
			APP_LOGS.error(elementName + " is not visible");
			System.err.println(elementName + "is not visible");
		}
		return flag;
	}

	public void logOnSuccessMessage(String stepName, String details) {
		APP_LOGS.debug(stepName + ": " + details);
		System.out.println(stepName + ": " + details);
	}

	public void logOnErrorMessage(String stepName, String details) {
		APP_LOGS.debug(stepName + ": " + details);
		System.err.println(stepName + ": " + details);
	}

	public void logOnInfo(String stepName, String details) {
		APP_LOGS.debug("\n************************************************************\n");
		reports.log(LogStatus.INFO, stepName, details);
		APP_LOGS.debug(stepName + ": " + details);
		System.out.println("\n************************************************************\n");
		System.out.println(stepName + ": " + details);
	}

	public void logOnSuccess(String stepName, String details) {
		reports.log(LogStatus.PASS, stepName, details);
		reports.attachScreenshot(screenLib.CaptureScreenshot(stepName, driver));
		APP_LOGS.debug(stepName + ": " + details);
		System.out.println(stepName + ": " + details);
	}

	public void logOnWarning(String stepName, String details) {
		reports.log(LogStatus.WARNING, stepName, details);
		APP_LOGS.error(stepName + ": " + details);
		System.err.println(stepName + ": " + details);
	}

	public void logOnError(String stepName, String details) {
		reports.log(LogStatus.FAIL, stepName, details);
		reports.attachScreenshot(screenLib.CaptureScreenshot(stepName, driver));
		APP_LOGS.error(stepName + ": " + details);
		System.err.println(stepName + ": " + details);
	}

	public boolean getAndVerifyTextPresent(WebElement element, String expectedText) {
		String actText = element.getText();
		if (expectedText.equals(actText)) {
			APP_LOGS.debug(expectedText + " text is verified");
			System.out.println(expectedText + " text is verified");
			flag = true;
		} else {
			APP_LOGS.error(expectedText + " text is not verified");
			System.err.println(expectedText + " text is not verified");
		}
		return flag;
	}

	public List<WebElement> getRowData(String rowDataXpath, String elementName) {
		if (driver.findElements(By.xpath(rowDataXpath)).size() > 0) {
			List<WebElement> rowData = driver.findElements(By.xpath(rowDataXpath));
			APP_LOGS.debug(elementName + " is visible");
			APP_LOGS.debug("Row contains following data: " + rowData);
			System.out.println("Row contains following data: " + rowData);
			return rowData;
		} else {
			APP_LOGS.error(elementName + " is not visible");
			System.err.println(elementName + " is not visible");
			return null;
		}
	}

	public List<WebElement> getElements(String rowDataXpath) {
		List<WebElement> rowData = driver.findElements(By.xpath(rowDataXpath));
		return rowData;
	}

	public boolean verifyElementXpathPresent(String elementXpath) throws InterruptedException {
		int count = 0;
		while (count <= 10) {
			try {
				driver.findElement(By.xpath(elementXpath));
				flag = true;
				break;
			} catch (ElementNotFoundException t) {
				Thread.sleep(3000);
				count++;
			}
		}
		return flag;
	}

	public void acceptAlert() {
		Alert alt = driver.switchTo().alert();
		alt.accept();
		APP_LOGS.debug("Alert is accepted");
		System.out.println("Alert is accepted");
	}

	public void cancelAlert() {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
		APP_LOGS.debug("Alert is dismissed");
		System.err.println("Alert is dismissed");
	}

	public void clearAndType(WebElement TextBox, String Text) {
		TextBox.clear();
		TextBox.sendKeys(Text);
	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

	public void deleteFile(String FilePath) {
		File f = new File(FilePath);
		f.delete();
	}

	/*
	 * This method is used for fetching fields in the table. And returns the
	 * result in the form of List
	 * 
	 * @param table_id, row_number, column_start, column_end
	 * 
	 * @return cells_text
	 */
	public List<String> getTableRow(String table_id, int row_number, int column_start, int column_end) {
		// System.out.println(table_id);
		List<String> cells_text = new ArrayList<String>();
		WebElement baseTable = driver.findElement(By.id(table_id));
		List<WebElement> tableRows = baseTable.findElements(By.tagName("tr"));
		// System.out.println("size " + tableRows.size());
		WebElement row = tableRows.get(row_number);
		for (int column_value = column_start; column_value <= column_end; column_value++) {
			cells_text.add(row.findElement(By.xpath("td[" + column_value + "]")).getText());
		}
		System.out.println(cells_text);
		return cells_text;
	}

	/*
	 * Function for closing a window Created by: -
	 */
	public boolean close() {
		try {
			driver.close();
			flag = true;
			return flag;
		} catch (Exception ex) {
			return false;
		}
	}

	public Long findxpathText(String objectclicked, int location) throws Exception {

		try {
			// Thread.sleep(Constants.DeltaConstants.time);
			String mMiles = driver.findElement(By.xpath(objectclicked)).getText();
			String[] arr = mMiles.split(" ");
			// String[] arr1 = arr[location].split(",");
			String[] arr2 = arr[location].split(":");

			mMiles = "";
			for (int i = 0; i < arr2.length; i++) {
				mMiles = mMiles + arr2[i];
			}
			String nMiles = mMiles.replace(",", "");
			splittedText = Long.parseLong(nMiles);
		} catch (Exception err) {
			System.out.println("in error" + err.getMessage());
		}
		return splittedText;
	}

	/*
	 * Function for checking the existence of an object used as css element by
	 * calling methods isElementPresent() and isVisible()
	 */
	public boolean isCSSElementPresent(String elementverify) {
		try {
			// Thread.sleep(Constants.DeltaConstants.time);
			if (elementverify != null) {
				if (driver.findElement(By.cssSelector(elementverify)).isDisplayed()) {
					flag = true;
				} else {
					flag = false;
				}
				return flag;
			} else
				flag = false;
			return flag;
		} catch (Exception ex) {
			return false;
		}

	}

	/*
	 * Function for handling alert box
	 */
	public boolean assertEquals(String message) {
		try {
			// Thread.sleep(Constants.DeltaConstants.time);
			if (message != null) {
				Alert alert = driver.switchTo().alert();
				if (message.equalsIgnoreCase(alert.getText())) {
					flag = true;
				} else {
					flag = false;
				}
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean assertaccept() {
		try {
			// Thread.sleep(Constants.DeltaConstants.time);
			driver.switchTo().alert().accept();
			return flag = true;
		} catch (Exception ex) {
			return false;
		}
	}

	// Function for reading Test data from excel sheet testcases_driver

	public String getToolTipText(String elementXPath, WebDriver wDriver) {
		Actions action = new Actions(wDriver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		action.moveToElement(wDriver.findElement(By.xpath(elementXPath))).build().perform();
		return wDriver.findElement(By.xpath(elementXPath)).getText();

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public boolean isThisDateValid(String dateToValidate, String dateFromat) {

		if (dateToValidate == null) {
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);

		try {

			// if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);

		} catch (ParseException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean assertTrue(Boolean Condition) {
		try {
			Assert.assertTrue(Condition);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean assertEquals(String Actual, String Expected) {
		try {
			Assert.assertEquals(Actual, Expected);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean assertEquals(int Actual, int Expected) {
		try {
			Assert.assertEquals(Actual, Expected);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * Use to clear text in a field
	 * 
	 * @param element_name, element_type , value
	 * 
	 * @return int
	 */
	public boolean clear(WebElement Element, String value) {

		try {
			if (Element != null && value != null) {
				Element.clear();
				// element.sendKeys("");
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception ex) {
			return false;
		}
	}

	/*
	 * Function for clicking a link, button or radio button
	 * 
	 * @param element_name, element_type
	 * 
	 * @return int
	 */
	public boolean click(WebElement Element) {
		try {
			
			if (Element != null) {
				// System.out.println(element);
				Element.click();
				flag = true;
				APP_LOGS.debug(Element + " is clicked");
				System.out.println(Element + " is clicked");
			} else {
				flag = false;
				APP_LOGS.error(Element + " can not be clicked");
				System.err.println(Element + " can not be clicked");
			}
			return flag;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean click(WebElement Element, String elementName) {
		try {
			if (Element != null) {
				// javascript.executeScript("arguments[0].setAttribute('style',
				// arguments[1]);",
				// Element, "color: groove green; border: 2px groove green;");
				Element.click();
				flag = true;
				APP_LOGS.debug(elementName + " has been clicked");
				System.out.println(elementName + " has been clicked");
			} else {
				flag = false;
				reports.log(LogStatus.FAIL, elementName, elementName + " is not available");
				reports.attachScreenshot(screenLib.CaptureScreenshot(elementName, driver));
				APP_LOGS.error(elementName + " can not be clicked");
				System.err.println(elementName + " can not be clicked");
				throw new SkipException("");
			}
			return flag;
		} catch (Exception ex) {
			reports.log(LogStatus.FAIL, elementName, elementName + " is not visible");
			throw new SkipException("");
		}
	}

	/*
	 * Method to get attribute of an element
	 * 
	 * @param element_name, element_type, attribute
	 * 
	 * @return String
	 */
	public String getAttribute(WebElement Element, String attribute) {
		String value = null;
		try {
			if (Element != null && attribute != null) {
				value = Element.getAttribute(attribute);
				APP_LOGS.debug(Element + " is available and has value for " + attribute + " is " + value);
			} else {
				APP_LOGS.error(attribute + " for the " + Element + " not available.");
			}
			return value;
		} catch (Exception ex) {
			return value;
		}
	}

	public String getAttribute(WebElement Element, String attribute, String elementName) {
		String value = null;
		try {
			if (Element != null && attribute != null) {
				value = Element.getAttribute(attribute);
				APP_LOGS.debug(elementName + " is available and has value for " + attribute + " is " + value);
			} else {
				APP_LOGS.error(attribute + " for the " + elementName + " not available.");
			}
			return value;
		} catch (Exception ex) {
			return value;
		}
	}

	/*
	 * Method to get attribute of an element
	 * 
	 * @param element_name, element_type, attribute
	 * 
	 * @return String
	 */
	public String getCssValue(WebElement Element, String attribute) throws Exception {
		String str = null;
		try {
			if (Element != null && attribute != null) {
				str = Element.getCssValue(attribute);
			} else {
			}
			return str;
		} catch (Exception ex) {
			return str;
		}

	}

	public Point getLocation(WebElement Element) throws Exception {
		Point point = null;
		try {
			// ////Thread.sleep(Constants.DeltaConstants.mintime);
			if (Element != null) {
				point = Element.getLocation();
			} else {
			}
			return point;
		} catch (Exception ex) {
			return point;
		}

	}

	/*
	 * Function to get dimension of an element
	 * 
	 * @param element_name, element_type, attribute
	 * 
	 * @return dimension
	 */
	public Dimension getSize(WebElement Element) throws Exception {
		Dimension dimension = null;
		try {
			if (Element != null) {
				dimension = Element.getSize();
			} else {
			}
			return dimension;
		} catch (Exception ex) {
			return dimension;
		}
	}

	/*
	 * Function to tag name of an element
	 * 
	 * @param element_name, element_type, attribute
	 * 
	 * @return tag
	 */
	public String getTagName(WebElement Element) throws Exception {
		String tag = null;
		try {
			if (Element != null) {
				tag = Element.getTagName();
			} else {
			}
			return tag;
		} catch (Exception ex) {
			return tag;
		}
	}

	/*
	 * Function to get text of an element
	 * 
	 * @param element_name, element_type, attribute
	 * 
	 * @return text
	 */
	public String getText(WebElement Element) {
		String text = null;
		try {
			if (Element != null) {
				text = Element.getText();
			} else {
			}
			return text;
		} catch (Exception ex) {
			return text;
		}
	}

	public String getText(WebElement Element, String elementName) {
		String text = null;
		try {
			if (isDisplayed(Element) != false) {
				text = Element.getText();
				APP_LOGS.debug(text + " is fetched from " + elementName);
				System.out.println(text + " is fetched from " + elementName);
			} else {
				reports.log(LogStatus.FAIL, elementName, elementName + " is not available");
				reports.attachScreenshot(screenLib.CaptureScreenshot(elementName, driver));
				APP_LOGS.error("Can not get text from " + elementName);
				System.err.println("Can not get text from " + elementName);
			}
			return text;
		} catch (Exception ex) {
			return text;
		}
	}

	/*
	 * Function to check element is displayed or not
	 * 
	 * @param element_name, element_type, attribute
	 * 
	 * @return int
	 */
	public boolean isDisplayed(WebElement Element) {
		try {
			if (Element != null) {
				// Thread.sleep(Constants.DeltaConstants.time);
				// System.out.println(element);
				b = Element.isDisplayed();
				if (b == true)
					flag = true;
				else
					flag = false;
			} else {
				flag = false;
			}
			if (isAlertPresent()) {
				APP_LOGS.fatal("Alert is displayed");
				reports.log(LogStatus.FATAL, "Unexpected Server Error : Undefined");
				reports.attachScreenshot(screenLib.CaptureScreenshot("Alert", driver));
				System.err.println("Unexpected Server Error : Undefined");
				acceptAlert();
			}
			return flag;
		} 
		catch (Exception ex) {
			return false;
		}
	}

	public boolean isDisplayed(WebElement Element, String elementName) {
		if (Element != null) {
			// Thread.sleep(Constants.DeltaConstants.time);
			// System.out.println(element);
			b = Element.isDisplayed();
			if (b == true) {
				flag = true;
				APP_LOGS.debug(elementName + " is displayed");
				System.out.println(elementName + " is displayed");
			} else {
				flag = false;
			}
			if (isAlertPresent()) {
				APP_LOGS.fatal("Alert is displayed");
				reports.log(LogStatus.FATAL, "Unexpected Server Error : Undefined");
				reports.attachScreenshot(screenLib.CaptureScreenshot(elementName, driver));
				System.err.println("Unexpected Server Error : Undefined");
				acceptAlert();
			}
		} else {
			flag = false;
			APP_LOGS.error(elementName + " is not displayed");
		}
		return flag;
	}

	public boolean isDisplayed(List<WebElement> Element) {
		try {
			if (Element != null) {
				// Thread.sleep(Constants.DeltaConstants.time);
				// System.out.println(element);
				b = Element.size() > 0;
				if (b == true) {
					flag = true;
				} else {
					flag = false;
				}
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean isDisplayed(List<WebElement> Element, String elementName) {
		if (Element != null) {
			// Thread.sleep(Constants.DeltaConstants.time);
			// System.out.println(element);
			b = Element.size() > 0;
			if (b == true) {
				flag = true;
				APP_LOGS.debug(elementName + " is displayed");
				System.out.println(elementName + " is displayed");
			} else {
				flag = false;
				APP_LOGS.error(elementName + " is not displayed");
				System.err.println(elementName + " is not displayed");
			}
		} else {
			flag = false;
			APP_LOGS.error(elementName + " is not displayed");
			System.err.println(elementName + " is not displayed");
			reports.log(LogStatus.FAIL, elementName, elementName + " is not available");
			reports.attachScreenshot(screenLib.CaptureScreenshot(elementName, driver));
		}
		return flag;
	}

	/*
	 * To check that field is enabled or not
	 * 
	 * @param element_name, element_type, attribute
	 * 
	 * @return int
	 */

	public boolean isEnabled(WebElement Element) {
		try {
			if (Element != null) {
				// Thread.sleep(Constants.DeltaConstants.time);
				// System.out.println(element);
				b = Element.isEnabled();
				if (b == true)
					flag = true;
				else
					flag = false;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception ex) {
			return false;
		}
	}

	/*
	 * To check that field is selected or not
	 * 
	 * @param element_name, element_type, attribute
	 * 
	 * @return int
	 */
	public boolean isSelected(WebElement Element) {
		try {
			if (Element != null) {
				// Thread.sleep(Constants.DeltaConstants.time);
				// System.out.println(element);
				b = Element.isSelected();
				if (b == true)
					flag = true;
				else
					flag = false;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception ex) {
			return false;
		}
	}

	/*----------------------------------------------------------------------------*/

	/*-------------------------------------Custom Methods Starts---------------------------------------*/

	/*
	 * Method to perform Mouse Over an element
	 * 
	 * @return int
	 * 
	 * @param element_name, element_type
	 */
	public boolean mouseOver(WebElement Element) {
		try {
			// Thread.sleep(Constants.DeltaConstants.time);
			if (Element != null) {
				Actions builder = new Actions(driver);
				builder.moveToElement(Element).perform();
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception ex) {
			return false;
		}
	}

	/*
	 * Use to type text in the field
	 * 
	 * @return int
	 * 
	 * @param element_name, element_type
	 */
	public boolean typeText(WebElement Element, String fieldvalue) {
		try {
			if (Element != null && fieldvalue != null) {
				Element.clear();
				Element.sendKeys(fieldvalue);
				flag = true;
				APP_LOGS.debug(fieldvalue + " is entered in " + Element);
				System.out.println(fieldvalue + " is entered in " + Element);
			} else {
				flag = false;
				APP_LOGS.error(fieldvalue + " can not be entered in " + Element);
				System.err.println(fieldvalue + " can not be entered in " + Element);
				throw new SkipException("");
			}
			return flag;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean typeText(WebElement Element, String fieldvalue, String elementName) {
		try {
			if (Element != null && fieldvalue != null) {
				// javascript.executeScript("arguments[0].setAttribute('style',
				// arguments[1]);",
				// Element, "color: groove green; border: 2px groove green;");
				//Element.click();
			    
				Element.clear();
				Element.sendKeys(fieldvalue);
				flag = true;
				APP_LOGS.debug(fieldvalue + " is entered in " + elementName);
				System.out.println(fieldvalue + " is entered in " + elementName);
			} else {
				flag = false;
				APP_LOGS.error(fieldvalue + " can not be entered in " + elementName);
				System.err.println(fieldvalue + " can not be entered in " + elementName);
				reports.log(LogStatus.FAIL, elementName, elementName + " is not visible");
				throw new SkipException("");
			}
			return flag;
		} catch (Exception ex) {
			return false;
		}
	}

	/*
	 * Use to pressing enter in text boxes
	 */
	public boolean pressEnter(WebElement Element) {
		try {
			if (Element != null) {
				Element.sendKeys(Keys.ENTER);
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception ex) {
			return false;
		}
	}

	/* @dev */

	/*
	 * Function to verify text is present
	 */
	public boolean isTextPresent(String text) {
		try {
			// Thread.sleep(Constants.DeltaConstants.time);
			if (text != null) {
				if (driver.getPageSource().contains(text)) {
					flag = true;
				} else {
					flag = false;
				}
				return flag;
			} else {
				flag = false;

				return flag;
			}
		} catch (Exception ex) {
			return false;
		}
	}

	/*
	 * 
	 * /* This method is used for fetching fields in the table. And returns the
	 * result in the form of List
	 * 
	 * @param table_id, row_number, column_start, column_end
	 * 
	 * @return cells_text
	 */
	public List<String> getTableRow(WebElement Table, int row_number, int column_start, int column_end) {
		// System.out.println(table_id);
		List<String> cells_text = new ArrayList<String>();
		// WebElement baseTable = driver.findElement(By.id(element_name));
		List<WebElement> tableRows = Table.findElements(By.tagName("tr"));
		// System.out.println("size " + tableRows.size());
		WebElement row = tableRows.get(row_number);
		for (int column_value = column_start; column_value <= column_end; column_value++) {
			cells_text.add(row.findElement(By.xpath("td[" + column_value + "]")).getText());
		}
		return cells_text;
	}

	/*
	 * This method is used to read PDF file
	 * 
	 * @param pdf_path, page_num
	 * 
	 * @return pdfDdata
	 */
	public String readPDFData(String pdf_path, int page_num) throws IOException {
		String pdfData = null;
		try {
			PdfReader reader = new PdfReader(pdf_path);
			int n = reader.getNumberOfPages();
			System.out.println("No of pages in PDF" + n);
			pdfData = PdfTextExtractor.getTextFromPage(reader, page_num);
			// Extracting the content from a particular page.
			System.out.println(pdfData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pdfData;
	}

	/*
	 * Read data from CSV file
	 * 
	 * @param
	 * 
	 * @return String
	 * 
	 * This method points to the project's root folder give file variable the
	 * file name like file.csv if your file is in root folder
	 */
	public String fetchDataFromCSV(String file) {
		try {
			String path = System.getProperty("user.dir");
			// path = path + "\\src\\test\\java\\csv\\users.csv";
			path = path + file;
			System.out.println(path);
			al1 = new ArrayList<String>();

			BufferedReader br = new BufferedReader(new FileReader(path));
			String userData = br.readLine();
			while (userData != null) {
				String userArray[] = userData.split(",");
				for (String item1 : userArray) {
					al1.add(item1);
				}
				userData = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		user = al1.get(0);
		return user;
	}

	public String getToolTipText(WebElement Element, WebDriver wDriver) {
		Actions action = new Actions(wDriver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		action.moveToElement(Element).build().perform();
		return Element.getText();

	}

	public void clearField(String objectclicked, String type) {
		if (objectclicked != null) {
			if ("id".equalsIgnoreCase(type)) {
				if (driver.findElement(By.id(objectclicked)).isEnabled()) {
					driver.findElement(By.id(objectclicked)).click();
					WebElement toClear = driver.findElement(By.id(objectclicked));
					toClear.sendKeys(Keys.CONTROL + "a");
					toClear.sendKeys(Keys.DELETE);
					flag = true;
				} else {
					flag = false;
				}

			}
		}

	}

	// Doubt
	public Long findText(String objectclicked, int location) throws Exception {

		try {
			// Thread.sleep(Constants.DeltaConstants.time);
			String mMiles = driver.findElement(By.name(objectclicked)).getText();
			String[] arr = mMiles.split(" ");
			String[] arr1 = arr[location].split(",");
			mMiles = "";
			for (int i = 0; i < arr1.length; i++) {
				mMiles = mMiles + arr1[i];
			}
			splittedText = Long.parseLong(mMiles);
		} catch (Exception err) {
			System.out.println("in error" + err.getMessage());
		}
		return splittedText;
	}

	// ////////////////////////////////////DD////////////////////////////////////
	/*
	 * Function for selection value from drop down list or combo box Created
	 */

	/*
	 * public int selectDropDownValue(String drop_down_name, String
	 * dropDownValue, String element_type) { try { if (drop_down_name != null) {
	 * new Select(findElement(drop_down_name, element_type))
	 * .selectByValue(dropDownValue); if (dropDownValue.indexOf(selenium
	 * .getSelectedLabel(drop_down_name)) != -1) { flag = 1; } else { flag = 0;
	 * } return flag; } else flag = 0; return flag; } catch (Exception ex) {
	 * return 0; } }
	 */

	/*
	 * Function for verification of value from drop down list or combo box
	 */
	public boolean verifyValuebyid(String dropDownName, String dropDownValue) {
		try {
			// Thread.sleep(Constants.DeltaConstants.time);
			if (dropDownName != null && dropDownValue != null) {

				if (dropDownValue.indexOf(driver.findElement(By.name(dropDownName)).getAttribute("value")) != -1) {
					flag = true;
				} else {
					flag = false;

				}

			} else
				flag = false;
			return flag;
		} catch (Exception ex) {
			return false;
		}
	}

	/*
	 * Function for selection multiple values from multi-select element Created
	 */
	/*
	 * public int addSelection(String dropDownName, String dropDownValue) { try
	 * { // Thread.sleep(Constants.DeltaConstants.time); if (dropDownName !=
	 * null || dropDownValue != null) { selenium.addSelection(dropDownName,
	 * dropDownValue); flag = 1; return flag; } else flag = 0; return flag; }
	 * catch (Exception ex) { return 0; } }
	 */

	// //////////////////////////////////DD////////////////////////////////////

	/*
	 * Function for waiting for a pop up window
	 * 
	 * @param windowID, timeout
	 * 
	 * @return "current window"
	 */
	// @SuppressWarnings("deprecation")
	// public void waitForPopUp(final String windowID, String timeout) {
	// final long millis = Long.parseLong(timeout);
	// final String current = driver.getWindowHandle();
	// new Wait() {
	// @Override
	// public boolean until() {
	// try {
	// if ("_blank".equals(windowID)) {
	// selectBlankWindow();
	// } else {
	// driver.switchTo().window(windowID);
	// }
	// return !"about:blank".equals(driver.getCurrentUrl());
	// } catch (SeleniumException e) {
	// // Swallow
	// }
	// return false;
	// }
	// }.wait(String.format("Timed out waiting for %s. Waited %s", windowID,
	// timeout), millis);
	// driver.switchTo().window(current);
	// }

	/*
	 * Function for waiting for a pop up window
	 * 
	 * @param
	 * 
	 * @return "current window"
	 */
	public void selectBlankWindow() throws Exception {
		String current = driver.getWindowHandle();
		// Find the first window without a "name" attribute
		List<String> handles = new ArrayList<String>(driver.getWindowHandles());
		for (String handle : handles) {
			driver.switchTo().window(handle);
			String value = (String) ((JavascriptExecutor) driver).executeScript("return window.name;");
			if (value == null) {
				return;
			}
		}
		driver.switchTo().window(current);
		throw new Exception("Unable to select window _blank");
	}

	/*
	 * Function for selecting a window
	 */
	public void selectWindow(String windowID) throws Exception {
		if ("null".equals(windowID)) {
			driver.switchTo().window(originalWindowHandle);
		} else if ("_blank".equals(windowID)) {
			selectBlankWindow();
		} else {
			if (windowID.startsWith("title=")) {
				selectWindowWithTitle(windowID.substring("title=".length()));
				return;
			}

			if (windowID.startsWith("name=")) {
				windowID = windowID.substring("name=".length());
			}

			try {
				driver.switchTo().window(windowID);
			} catch (NoSuchWindowException e) {
				selectWindowWithTitle(windowID);
			}
		}
	}

	public void selectWindowWithTitle(String title) throws Exception {
		String current = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if (title.equals(driver.getTitle())) {
				return;
			}
		}

		driver.switchTo().window(current);
		throw new Exception("Unable to select window with title: " + title);
	}

	@SuppressWarnings("unused")
	private static String getConfigurationProperty(String envKey, String sysKey, String defValue) {
		String retValue = defValue;
		String envValue = System.getenv(envKey);
		String sysValue = System.getProperty(sysKey);
		// system property prevails over environment variable
		if (sysValue != null) {
			retValue = sysValue;
		} else if (envValue != null) {
			retValue = envValue;
		}
		return retValue;
	}

	public boolean selectDrpDownValue(WebElement dropdownPath, String visibleTxt, String elementName) {
		try {
			if (dropdownPath != null) {
				Select dropdown = new Select(dropdownPath);
				dropdown.selectByVisibleText(visibleTxt);
				flag = true;
				APP_LOGS.debug(elementName + " has selected " + visibleTxt + " from dropdown");
				System.out.println(elementName + " has selected " + visibleTxt + " from dropdown");
			} else {
				flag = false;
				APP_LOGS.error(elementName + " can not select " + visibleTxt + " from dropdown");
				reports.log(LogStatus.FAIL, elementName, elementName + " is not visible");
				reports.attachScreenshot(screenLib.CaptureScreenshot(elementName, driver));
				System.err.println(elementName + " can not select " + visibleTxt + " from dropdown");
				throw new SkipException("");
			}
		} catch (Exception e) {
			flag = false;
			APP_LOGS.error(elementName + " can not select " + visibleTxt + " from dropdown");
			reports.log(LogStatus.FAIL, elementName, elementName + " is not visible");
			reports.attachScreenshot(screenLib.CaptureScreenshot(elementName, driver));
			System.err.println(elementName + " can not select " + visibleTxt + " from dropdown");
			throw new SkipException("");
		}
		return flag;
	}

	public boolean pageName(String text) {
		try {
			// Thread.sleep(Constants.DeltaConstants.time);
			
			
			if (text != null) {
				//System.out.println("page title is:"+driver.getTitle());
				if (driver.getTitle().equalsIgnoreCase(text)) {
					flag = true;
					APP_LOGS.debug("User is navigated to " + text + " page");
				} else {
					flag = false;
					APP_LOGS.error("User is navigated to wrong page which is " + text);
					reports.log(LogStatus.FAIL, "User is navigated to wrong page which is " + text);
					throw new SkipException("");
				}
				return flag;
			} else {
				flag = false;

				return flag;
			}
		} catch (Exception ex) {
			return false;
		}
	}

	public void getTextOfAlertAccept() {
		try {
			// Thread.sleep(Constants.DeltaConstants.time);

			Alert alert = driver.switchTo().alert();
			String alertext = alert.getText();
			if (alertext != null) {
				APP_LOGS.debug("Alert is present with text ---" + alertext + "---");
				alert.accept();
			} else {
				APP_LOGS.error("Alert is not present");

			}
		} catch (Exception ex) {

		}
	}

	public boolean isSelected(WebElement Element, String elementName) {
		if (Element != null) {
			// Thread.sleep(Constants.DeltaConstants.time);
			// System.out.println(element);
			b = Element.isSelected();
			if (b == true) {
				flag = true;
				APP_LOGS.debug(elementName + " is already selected");
			} else {
				flag = false;
			}
		} else {
			flag = false;
			// reports.log(LogStatus.FAIL, elementName, elementName
			// + " is not already selected");
			// reports.attachScreenshot(screenLib.CaptureScreenshot(elementName,
			// driver));
			APP_LOGS.error(elementName + " is not already selected");
		}
		return flag;
	}

	public boolean typeKeys(WebElement Element, Keys key) {
		try {
			if (Element != null && key != null) {
				Element.sendKeys(key);
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean javaScriptClick(WebElement element, String elementName) {
		if (element != null) {
			// System.out.println(element);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			flag = true;
			APP_LOGS.debug(elementName + " has been clicked");
			System.out.println(elementName + " has been clicked");
		} else {
			flag = false;
			reports.log(LogStatus.FAIL, elementName, elementName + " is not available");
			reports.attachScreenshot(screenLib.CaptureScreenshot(elementName, driver));
			APP_LOGS.error(elementName + " can not be clicked");
			System.err.println(elementName + " can not be clicked");
			throw new SkipException("");
		}
		return flag;
	}

	public int countOfGrid(String records) {
		String[] parts = records.split("of");
		// String subString1 = parts[0];
		String subString2 = parts[1];
		String[] newSubString = subString2.split(" ");
		// String newSubString1 = newSubString[0];
		String newSubString2 = newSubString[1];
		int count = Integer.parseInt(newSubString2);
		return count;
	}
}
