package com.app.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.app.pageObjects.Homepage;
import com.app.pageObjects.LoginPage;
import com.app.utilities.ExcelUtils;

public class TC_LoginTestDD_002 extends BaseClass {



	@Test(dataProvider ="LoginData")
	public void DDTLoginTest(String user, String pwd) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		Homepage hp = new Homepage(driver);
		lp.setUsername(username);
		logger.info("Username provided");
		lp.setPassword(pwd);
		logger.info("Password provided");

		lp.Login();


		if(hp.hometab.isDisplayed()!=true) {

			Assert.assertTrue(false);
			logger.warn("Login failed");
		}

		else {
			Thread.sleep(3);
			lp.Logout();
			Assert.assertTrue(true);
			logger.info("logging passed");

		}
	}

	@DataProvider(name="LoginData")
	String[][] getData()throws IOException{

		String path = System.getProperty("user.dir")+"/src/test/java/com/app/testData/TestData.xlsx";

		int rownum=ExcelUtils.getRowCount(path, "Sheet1");
		int colnum= ExcelUtils.getCellCount(path, "Sheet1", 1);		
		String loginData[][]= new String[rownum][colnum];




		for(int i=1;i<=rownum;i++) {

			for(int j=0;j<colnum;j++) {
				loginData[i-1][j]=ExcelUtils.getCellData(path, "Sheet1", i, j);

			}
		}

		return loginData;
	}
}
