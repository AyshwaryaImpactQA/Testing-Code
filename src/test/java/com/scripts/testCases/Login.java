package com.scripts.testCases;

    import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import com.scripts.businessLogic.LoginLogic;
	import com.scripts.lib.commonFunction.Driver;
	import utils.load.dataSource.ExcelLib;

	public class Login extends Driver {
	    String username, password;

	    ExcelLib excelData;
	    LoginLogic loginLib;

	    @BeforeClass
	    public void configBeforeClass() throws Exception {
	        excelData = new ExcelLib();
	        loginLib = new LoginLogic();
//	        reports.startTest("Login with TM Admin");
	    }

	    //@Test(priority = 1)
	    @Test(description = "SA-1696 : Login details")
	    public void SA_1696() throws Exception {
	        
	        
	        username = excelData.getExcelData("Login", 1, 1);
	        password = excelData.getExcelData("Login", 1, 2);
	        loginLib.login(username, password);

	        
	    }
	}

