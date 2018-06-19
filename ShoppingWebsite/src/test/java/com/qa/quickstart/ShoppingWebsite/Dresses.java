package com.qa.quickstart.ShoppingWebsite;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Verify;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Dresses {
	ChromeDriver driver;
	ExtentReports newReport = new
	ExtentReports ("C:\\Users\\Admin\\Desktop\\ShoppingReport.html", true);
	ExtentTest test;

	
	@Before
	public void before1() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		test = newReport.startTest("Searching for a Blouse when typing Dress");
	}
	
	@Test
	public void test() {
		List<String> list = new ArrayList<String>();
		driver.manage().window().maximize();
		String url = "http://automationpractice.com/index.php";
		driver.navigate().to(url);
		test.log(LogStatus.INFO,"Navigate to Shopping Website");
		WebElement web1 = driver.findElement(By.id("search_query_top"));
	    web1.click();
	    web1.clear();
	    web1.sendKeys("dress");
	    driver.findElement(By.id("searchbox")).submit();
	    test.log(LogStatus.INFO,"Find Searchbox, type in dress and submit");
	    WebElement testing = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul"));
	    test.log(LogStatus.INFO,"Find the grid that contains all the result");
	    List<WebElement> matches = testing.findElements(By.className("product-name"));
	    test.log(LogStatus.INFO,"Create WebElement array list");
	    for (WebElement match : matches) {
	        list.add(match.getText());
	    }
	    test.log(LogStatus.INFO,"Loop through webelement list to then add to string list");
	    try {assertTrue(list.contains("Blouse"));
	    test.log(LogStatus.PASS, "There is a blouse in search result.");
	    }
	    catch (AssertionError a) {
	    	//tested that if Blouse is changed to something not blouse it will return assertion error
	    	//therefore reaching this stage to fail the test
	    	test.log(LogStatus.FAIL, "The result shows there are no blouses in the result.");
	    	fail();
	    }
	    finally {
	    	System.out.println(list);
	    	newReport.endTest(test);
	    }
	    
	}
	
	@After
	public void quitting(){
		driver.close();
		driver.quit();
		newReport.flush();
	}



}
