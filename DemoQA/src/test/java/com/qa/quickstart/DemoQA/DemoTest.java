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

import pages.*;

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
		sleep1Second();
		Droppable demoDrop = PageFactory.initElements(driver, Droppable.class);
		test.log(LogStatus.INFO, "Page Factory init elements");
		demoDrop.dragIt();
		test.log(LogStatus.INFO, "DragIt method from Droppable.java");
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
		test.log(LogStatus.INFO, "Selectable Page");
		sleep1Second();
		demoSelect.selectAll();
		test.log(LogStatus.INFO, "selectAll method from Selectable.java");
		WebElement testing = driver.findElement(By.id("selectable"));
		List<WebElement> comparison1 = testing.findElements(By.cssSelector("#selectable li"));
		test.log(LogStatus.INFO, "find grid containing all selectables");
		int counter1 = 0;
		test.log(LogStatus.INFO, "go through all selectables and add to counter if it is selected");
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
			test.log(LogStatus.INFO, "when counter equals 7 it is true");
				test.log(LogStatus.PASS, "All the items were selected");
			}
			catch (AssertionError e) {
				test.log(LogStatus.INFO, "counter didnt reach 7 so it is false");
				test.log(LogStatus.FAIL, "Not all items were selected");
		    	fail();
			}
			finally {
			newReport.endTest(test);
			}
	}
	
	@Test
	public void selectableItem3() {
		test = newReport.startTest("Select Item 3");
		newHome.selectablePage();
		test.log(LogStatus.INFO, "Go to selectable page");
		sleep1Second();
		demoSelect.selectItem3();
		test.log(LogStatus.INFO, "run selectItem3() from Selectable.java");
		//list.get[2]
		WebElement testing = driver.findElement(By.id("selectable"));
		List<WebElement> comparison1 = testing.findElements(By.cssSelector("#selectable li"));
		test.log(LogStatus.INFO, "get all the selectables within a grid and add it to array list");
		test.log(LogStatus.INFO, "AssertEquals to check if item 3 is selected");
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
	
	@Test
	public void accordionTest() {
		test = newReport.startTest("Accordion");
		newHome.accordionPage();
		test.log(LogStatus.INFO, "Go to accordion page");
		sleep1Second();
		Accordion demoAccordion = PageFactory.initElements(driver, Accordion.class);
		test.log(LogStatus.INFO, "Pagefactory demoAccordion");
		demoAccordion.selectingBoxes();
		test.log(LogStatus.INFO, "run selectingBoxes from Accordion.java");
		WebElement box1 = driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]"));
		test.log(LogStatus.INFO, "get box1 via xpath");
		test.log(LogStatus.INFO, "assertEquals to check if box1 is selected");
		try {assertEquals("ui-accordion-header ui-state-default ui-accordion-icons ui-accordion-header-active ui-state-active ui-corner-top", 
				box1.getAttribute("class"));
			test.log(LogStatus.PASS, "Box1 is selected");
		}
		catch (AssertionError m) {
			test.log(LogStatus.FAIL, "Something else is selected");
			
		}
		
		finally {
		newReport.endTest(test);
		}
	}
	
	@Test
	public void autoCompleteTest() {
		test = newReport.startTest("Auto Complete");
		newHome.autoComplete();
		test.log(LogStatus.INFO, "Go to auto complete page");
		sleep1Second();
		Tags demoAutoComplete = PageFactory.initElements(driver, Tags.class);
		demoAutoComplete.searchHaskell();
		test.log(LogStatus.INFO, "create demoautocomplete and run search haskell method");
		WebElement boxValue = driver.findElement(By.id("tagss"));
		test.log(LogStatus.INFO, "Find the box");
		String value = boxValue.getAttribute("value");
		test.log(LogStatus.INFO, "Get what is in the box");
		try {assertEquals("Haskell", value);
		test.log(LogStatus.PASS, "Textbox auto completed successfully");
		}
		catch (AssertionError p) {
		test.log(LogStatus.FAIL, "Textbox didnt get Haskell");
		fail();
		}
		finally {
			newReport.endTest(test);
		}
	}
	
	@Test
	public void datePickerTest() {
		test = newReport.startTest("Date Picker");
		newHome.datePicker();
		test.log(LogStatus.INFO, "Go to datepicker page");
		sleep1Second();
		DatePicker demoDate = PageFactory.initElements(driver, DatePicker.class);
		demoDate.pickMe();
		WebElement dateChosen = driver.findElement(By.id("datepicker1"));
		String dateValue = dateChosen.getAttribute("value");
		System.out.println(dateValue);
		try {
		assertEquals("December 27, 2018", dateValue);
		test.log(LogStatus.PASS, "The date chosen is " + dateValue);
		}
		catch (AssertionError x) {
		test.log(LogStatus.FAIL, "The date chosen is " + dateValue);
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
	
	public void sleep1Second(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
