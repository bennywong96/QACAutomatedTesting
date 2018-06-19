package com.qa.quickstart.DemoQA;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoTest {
	ChromeDriver driver;
	ExtentReports newReport = new
	ExtentReports ("C:\\Users\\Admin\\Desktop\\DemoTest.html", true);
	ExtentTest test;
	Home newHome = PageFactory.initElements(driver, Home.class);
	
	 @BeforeClass
		public static void init() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dale\\Desktop\\chromedriver.exe");
	 }
	
	@Before
	public void before1() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://demoqa.com/";
		driver.navigate().to(url);
	}
	
	@Test
	public void droppableTest() {
		test = newReport.startTest("Droppable");
		newHome.draggablePage();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Droppable demoDrop = PageFactory.initElements(driver, Droppable.class);
		demoDrop.dragIt();
		try {
			String comparison1 = driver.findElement(By.id("droppableview")).getText();
			assertEquals("Dropped!", comparison1);
			test.log(LogStatus.PASS, "Draggable was dragged to Droppable");
		}
		catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Draggable was not dragged to Droppable");
	    	fail();
		}
		finally {
			newReport.endTest(test);
		}
		
	}
	
	@Test
	public void selectableTest() {
		test = newReport.startTest("Selectable");
		newHome.selectablePage();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	
	@After
	public void quitting(){
		driver.quit();
		newReport.flush();
	}

}
