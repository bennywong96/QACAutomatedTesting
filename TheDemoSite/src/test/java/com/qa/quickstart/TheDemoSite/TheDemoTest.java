package com.qa.quickstart.TheDemoSite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Verify;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TheDemoTest {
String status;
WebElement newUserU;
WebElement newUserP;
ChromeDriver driver;
ExtentReports newReport = new
ExtentReports ("C:\\Users\\Admin\\Desktop\\newReport.html", true);
ExtentTest test;



	@Before
	public void before1() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		test = newReport.startTest("Creating New Login");
	}
	
	@Test
	public void test() {
		driver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/index.php";
		driver.navigate().to(url);
		driver.findElement(By.linkText("3. Add a User")).click();
		test.log(LogStatus.INFO,"Navigated to Add New User");
		assertEquals("http://thedemosite.co.uk/addauser.php", driver.getCurrentUrl());
		newUser1();
	    test.log(LogStatus.INFO,"Entered TestingAc as username and H1Th3r3 as password");
	    driver.findElement(By.linkText("4. Login")).click();
	    test.log(LogStatus.INFO, "Navigate to Login Page");
		newUser1();
	    test.log(LogStatus.INFO, "Login with new created account");
	    WebElement newElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
	    status = newElement.getText();
	    
	    
	    try {newMethod();
	    test.log(LogStatus.PASS, "Successful Login");
	    }
	    catch (AssertionError e) {
	    test.log(LogStatus.FAIL, "Ya Failed M8");
	    fail();
	    }
	    finally {
	    	System.out.println(status);
	    	newReport.endTest(test);
	    }
	    
	    
	   
	    
	    
	
	    
	}
	
	public void newUser1() {
		newUserU = driver.findElement(By.name("username"));
		newUserU.click();
		newUserU.clear();
		newUserU.sendKeys("TestingAc");
		newUserP =driver.findElement(By.name("password"));
		newUserP.click();
		newUserP.clear();
		newUserP.sendKeys("H1Th3r3");
	    driver.findElement(By.name("FormsButton2")).click();
	    
	}
	
	public void newMethod() throws AssertionError {
		 assertEquals("**Successful Login**", status);
	}
	    
	
	@After
	public void quitting(){
		driver.quit();
		newReport.flush();
	}
}
