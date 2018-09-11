package com.scripts.businessLogic;


	

	import org.openqa.selenium.support.PageFactory;

	import com.scripts.lib.commonFunction.CommonUtills;
	import com.scripts.lib.commonFunction.Driver;
import com.scripts.pageObjectRepository.Login_Page;
	

	public class LoginLogic extends Driver {

	    Login_Page loginPage = PageFactory.initElements(driver, Login_Page.class);
	    CommonUtills commonLib = new CommonUtills();

	    public void login(String username, String password)
	            throws Exception {
	        
	        //commonLib.waitForPageToLoad();
	        /*try {
	            openURL();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            System.out.println(e);
	        }*/
	        
	    //commonLib.logOnInfo("Login with ","Login with ");
	        if (commonLib.isDisplayed(loginPage.clickonGobutton())) {
	            commonLib.click(loginPage.clickonGobutton(),
	                    "go  button");
	            
	        }
	        
	        if(commonLib.isDisplayed(loginPage.getTxtBoxUsername()))
	            
	        {
	            commonLib.typeText(loginPage.getTxtBoxUsername(), username,
	                    "UserName TxtBx");
	        }
	        
	       if(commonLib.isDisplayed(loginPage.getTxtBoxPassword()))
	            
	        {
	            commonLib.typeText(loginPage.getTxtBoxPassword(), password,
	                    "Password TxtBx");
	        }
	        
	       if (commonLib.isDisplayed(loginPage.getBtnLogin())) {
	            commonLib.click(loginPage.getBtnLogin(),
	                    "Login Button");
	            commonLib.waitForPageToLoad();
	            
	        }

	    
	    }

	    public void closeBrowser() {
	        reports.startTest("Close Browser");
	        driver.quit();
	        commonLib.logOnInfo("Close Browser", "Browser is closed");
	    }

	}

