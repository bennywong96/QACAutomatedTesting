package com.qa.quickstart.DemoQA;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
	ExtentReports ("C:\\Users\\Admin\\Desktop\\Automated Test\\Reports\\DemoTest.html", true);
	ExtentTest test;
	Home newHome;
	Selectable demoSelect;

	
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
		newHome = PageFactory.initElements(driver, Home.class);
		demoSelect = PageFactory.initElements(driver, Selectable.class);
		
	}
	
	@Test
	public void droppableTest() {
		test = newReport.startTest("Droppable");
		newHome.draggablePage();
		test.log(LogStatus.INFO, "Homepage executing method to go to draggable page");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Droppable demoDrop = PageFactory.initElements(driver, Droppable.class);
		test.log(LogStatus.INFO, "Page Factory init elements");
		demoDrop.dragIt();
		test.log(LogStatus.INFO, "DragIt method from Droppable.clas");
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
	public void selectableSelectAll() {
		//List<String> list = new ArrayList<String>();
		test = newReport.startTest("Selectable");
		newHome.selectablePage();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		demoSelect.selectAll();
		WebElement testing = driver.findElement(By.id("selectable"));
		List<WebElement> comparison1 = testing.findElements(By.cssSelector("#selectable li"));
		int counter1 = 0;
			for (WebElement match:comparison1) {
				if (match.getAttribute("class").contains("ui-selected")) {
					counter1++;
				}
				else {
					break;
				}
				 //list.add(match.getAttribute("class"));
			}
			
			
			try {assertTrue(counter1==7);
				test.log(LogStatus.PASS, "All the items were selected");
			}
			catch (AssertionError e) {
				test.log(LogStatus.FAIL, "Not all items were selected");
		    	fail();
			}
			finally {
			newReport.endTest(test);
			}
	}
	
	@Test
	public void selectableItem3() {
		test = newReport.startTest("Selectable");
		newHome.selectablePage();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		demoSelect.selectItem3();
		//list.get[2]
		WebElement testing = driver.findElement(By.id("selectable"));
		List<WebElement> comparison1 = testing.findElements(By.cssSelector("#selectable li"));
			try {assertEquals("ui-widget-content ui-corner-left ui-selectee ui-selected",comparison1.get(2).getAttribute("class"));
				test.log(LogStatus.PASS, "Item 3 is selected :)");
			}
			catch (AssertionError e) {
				test.log(LogStatus.FAIL, "Item 3 isn't selected :(");
		    	fail();
			}
			finally {
			newReport.endTest(test);
			}
	}
	
	
	
	
	
	@After
	public void quitting(){
		driver.quit();
		newReport.flush();
	}

}
