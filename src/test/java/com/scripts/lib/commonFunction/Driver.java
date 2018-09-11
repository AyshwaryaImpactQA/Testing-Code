package com.scripts.lib.commonFunction;

import java.awt.Toolkit;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import utils.load.dataSource.ExcelLib;
import utils.load.dataSource.LoadProperty;
import utils.report.template.ExtentReports;
import utils.report.template.GridType;
import utils.screenshot.Test_Utils;

public class Driver {
	String Url = LoadProperty.getVar("url", "data");
	public static WebDriver driver = null;
	public static ExtentReports reports = new ExtentReports();
	// public static Logger log = Logger.getLogger("devpinoyLogger");
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	public static Date date = new Date();
	public ExcelLib excelData = new ExcelLib();
	public Random randomGenerator = new Random();
	public static String reportPath = System.getProperty("user.dir") + "/src/test/resources/Reports/NC "
			+ dateFormat.format(date) + ".html";
	public static Logger APP_LOGS = null;
	public String url = null;
	public String environment = LoadProperty.getVar("environment", "data");
	String reportTitle = LoadProperty.getVar("reportTitle", "data");
	String browserName = LoadProperty.getVar("browser", "data");
	public String urlQA = LoadProperty.getVar("urlQA", "data");
	public String urlCloud = LoadProperty.getVar("urlCloud", "data");
	public String urlPlatform = LoadProperty.getVar("urlPlatform", "data");
	public String tmAdmin = null;
	public String daAdmin = null;
	public String candidateFname = null;
	public String candidateLname = null;
	public String candidateEmail = null;
	public String saAdmin = null;
	public String osName = null;
	Test_Utils screenLib = new Test_Utils();

	public void preConfigure() {
		System.setProperty("Selenium.log", System.getProperty("user.dir") + "/src/test/resources/Selenium.log");
		System.setProperty("Application.log", System.getProperty("user.dir") + "/src/test/resources/Application.log");
		osName = System.getProperty("os.name");
	}

	public void configureBase() throws Exception {
		// object initialization
		System.out.println("Initializing Driver and Report");
		APP_LOGS = Logger.getLogger("SA");
		invokeDriver(browserName, Url);
		// For report initialization
		Driver.reports.init(Driver.reportPath, true);
		Driver.reports.config().displayCallerClass(false);
		Driver.reports.init(Driver.reportPath, true, GridType.STANDARD);
		Driver.reports.config().setImageSize("30%");
		Driver.reports.config().documentTitle(reportTitle);
		Driver.reports.config().reportHeadline("Suite has been ran on " + environment + " environment.");
	}

	/**
	 * This method is used to initialize the WebDriver object
	 */
	/**
	 * @param browser
	 * @param url
	 * @throws Exception
	 */
	public void invokeDriver(String browser, String url) {
		if (osName.contains("Windows")) {
			try {
				if (browser.equalsIgnoreCase("Firefox")) {
					System.setProperty("webdriver.gecko.driver",
							System.getProperty("user.dir") + "/src/test/resources/Drivers/Windows/geckodriver.exe");
					driver = new FirefoxDriver(FirefoxDriverProfile());
					APP_LOGS.info(browser + " Browser launched successfully.");

				} else if (browser.equalsIgnoreCase("Chrome")) {
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "/src/test/resources/Drivers/Windows/chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--start-maximized");
					driver = new ChromeDriver(options);
					APP_LOGS.info(browser + " Browser launched successfully.");

				} else if (browser.equalsIgnoreCase("IE")) {
					driver.manage().deleteAllCookies();
					System.setProperty("webdriver.ie.driver",
							System.getProperty("user.dir") + "/src/test/resources/Drivers/Windows/IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					APP_LOGS.info(browser + " Browser launched successfully.");
				} else {
					APP_LOGS.info("Browser not selected.");
				}
			} catch (Exception e) {
				APP_LOGS.error("System is Unable to launch the browser. Please select Firefox, Chrome or IE browsers.");
			}
		} else if (osName.contains("Mac")) {
			try {
				if (browser.equalsIgnoreCase("Firefox")) {
					FirefoxProfile firefoxProfile = new FirefoxProfile();
					firefoxProfile.setAcceptUntrustedCertificates(true);
					firefoxProfile.setPreference("browser.download.folderList", 2);
					firefoxProfile.setPreference("browser.download.dir","/user/");
					firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/xml,text/plain,text/xml,image/jpeg,application/json,text/calender");
					firefoxProfile.setPreference("webdriver.log.browser.ignore", true);
					firefoxProfile.setPreference("webdriver.log.driver.ignore", true);
					firefoxProfile.setPreference("webdriver.log.profiler.ignore", true);
					DesiredCapabilities dc = DesiredCapabilities.firefox();
      				dc.setCapability("marionette", true);
					dc.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/Drivers/Mac/geckodriver");
					driver = new FirefoxDriver(dc);
					APP_LOGS.info(browser+" Browser launched successfully.");
				}
				if (browser.equalsIgnoreCase("Chrome")) {

					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "/src/test/resources/Drivers/Mac/chromedriver");
					driver = new ChromeDriver();
					APP_LOGS.info(browser + " Browser launched successfully.");
				} else {
					APP_LOGS.info("Browser not selected.");
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		} 
		try {
			openURL();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	public static FirefoxProfile FirefoxDriverProfile() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 0);
		profile.setPreference("browser.download.dir", false);
		profile.setPreference("plugin.disable_full_page_plugin_for_types", "application/pdf");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"text/csv,application/x-msexcel,application/excel,application/x-excel,application/pdfss,application/x-pdf,application/pdf,application/x-pdf, application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml, application/octet-stream");
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		return profile;
	}

	/**
	 * This method is used to maximize the browser and open the given
	 * URL @throws Exception @throws
	 * 
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	public void openURL() throws InvalidFormatException, IOException {
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		Dimension screenResolution = new Dimension((int) 
//		                   toolkit.getScreenSize().getWidth(), (int) 
//		                   toolkit.getScreenSize().getHeight());
//
//		driver.manage().window().setSize(screenResolution);
		
		if (environment.equalsIgnoreCase("SA Platform")) {
			System.out.println("SA Enviroment");
			url = urlQA;
			
		}
		 if (environment.equalsIgnoreCase("NC Cloud")) {
			 
			url = urlCloud;
		
			
		}
		if (environment.equalsIgnoreCase("NC Platform")) {
			url = urlPlatform;
 
			candidateEmail = excelData.getExcelData("Controller", 3, 7);
		}
		
		driver.get(url);
		APP_LOGS.debug(url + " has been entered into browser");
		System.out.println(url + " has been entered into browser");
	}

	public String[] splitCredentials(String credential) {
		String cred[] = credential.split("/");
		return cred;
	}

}