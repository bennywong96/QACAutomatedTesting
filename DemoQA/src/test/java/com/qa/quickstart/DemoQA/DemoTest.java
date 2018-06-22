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
	static ExtentReports newReport;
	ExtentTest test;  ExtentTest test1; ExtentTest test2;
	ExtentTest test3; ExtentTest test4; ExtentTest test5;
	ExtentTest test6; ExtentTest test7; ExtentTest test8;
	ExtentTest test9;
	Home newHome;
	Selectable demoSelect;

	
	 @BeforeClass
		public static void init() {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		 newReport = new
					ExtentReports ("C:\\Users\\Admin\\Desktop\\Automated Test\\Reports\\DemoTest.html", true);
	 }
	
	@Before
	public void before1() {
		
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
		test1 = newReport.startTest("Selectable");
		newHome.selectablePage();
		test1.log(LogStatus.INFO, "Selectable Page");
		sleep1Second();
		demoSelect.selectAll();
		test1.log(LogStatus.INFO, "selectAll method from Selectable.java");
		WebElement testing = driver.findElement(By.id("selectable"));
		List<WebElement> comparison1 = testing.findElements(By.cssSelector("#selectable li"));
		test1.log(LogStatus.INFO, "find grid containing all selectables");
		int counter1 = 0;
		test1.log(LogStatus.INFO, "go through all selectables and add to counter if it is selected");
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
			test1.log(LogStatus.INFO, "when counter equals 7 it is true");
			test1.log(LogStatus.PASS, "All the items were selected");
			}
			catch (AssertionError e) {
				test1.log(LogStatus.INFO, "counter didnt reach 7 so it is false");
				test1.log(LogStatus.FAIL, "Not all items were selected");
		    	fail();
			}
			finally {
			newReport.endTest(test1);
			}
	}
	
	@Test
	public void selectableItem3() {
		test2 = newReport.startTest("Select Item 3");
		newHome.selectablePage();
		test2.log(LogStatus.INFO, "Go to selectable page");
		sleep1Second();
		demoSelect.selectItem3();
		test2.log(LogStatus.INFO, "run selectItem3() from Selectable.java");
		//list.get[2]
		WebElement testing = driver.findElement(By.id("selectable"));
		List<WebElement> comparison1 = testing.findElements(By.cssSelector("#selectable li"));
		test2.log(LogStatus.INFO, "get all the selectables within a grid and add it to array list");
		test2.log(LogStatus.INFO, "AssertEquals to check if item 3 is selected");
			try {assertEquals("ui-widget-content ui-corner-left ui-selectee ui-selected",comparison1.get(2).getAttribute("class"));
				test2.log(LogStatus.PASS, "Item 3 is selected :)");
			}
			catch (AssertionError e) {
				test2.log(LogStatus.FAIL, "Item 3 isn't selected :(");
		    	fail();
			}
			finally {
			newReport.endTest(test2);
			}
	}
	
	@Test
	public void accordionTest() {
		test3 = newReport.startTest("Accordion");
		newHome.accordionPage();
		test3.log(LogStatus.INFO, "Go to accordion page");
		sleep1Second();
		Accordion demoAccordion = PageFactory.initElements(driver, Accordion.class);
		test3.log(LogStatus.INFO, "Pagefactory demoAccordion");
		demoAccordion.selectingBoxes();
		test3.log(LogStatus.INFO, "run selectingBoxes from Accordion.java");
		WebElement box1 = driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]"));
		test3.log(LogStatus.INFO, "get box1 via xpath");
		test3.log(LogStatus.INFO, "assertEquals to check if box1 is selected");
		try {assertEquals("ui-accordion-header ui-state-default ui-accordion-icons ui-accordion-header-active ui-state-active ui-corner-top", 
				box1.getAttribute("class"));
			test3.log(LogStatus.PASS, "Box1 is selected");
		}
		catch (AssertionError m) {
			test3.log(LogStatus.FAIL, "Something else is selected");
			
		}
		
		finally {
		newReport.endTest(test3);
		}
	}
	
	@Test
	public void autoCompleteTest() {
		test4 = newReport.startTest("Auto Complete");
		newHome.autoComplete();
		test4.log(LogStatus.INFO, "Go to auto complete page");
		sleep1Second();
		Tags demoAutoComplete = PageFactory.initElements(driver, Tags.class);
		demoAutoComplete.searchHaskell();
		test4.log(LogStatus.INFO, "create demoautocomplete and run search haskell method");
		WebElement boxValue = driver.findElement(By.id("tagss"));
		test4.log(LogStatus.INFO, "Find the box");
		String value = boxValue.getAttribute("value");
		test4.log(LogStatus.INFO, "Get what is in the box");
		try {assertEquals("Haskell", value);
		test4.log(LogStatus.PASS, "Textbox auto completed successfully");
		}
		catch (AssertionError p) {
		test4.log(LogStatus.FAIL, "Textbox didnt get Haskell");
		fail();
		}
		finally {
			newReport.endTest(test4);
		}
	}
	
	@Test
	public void datePickerTest() {
		test5 = newReport.startTest("Date Picker");
		newHome.datePicker();
		test5.log(LogStatus.INFO, "Go to datepicker page");
		sleep1Second();
		DatePicker demoDate = PageFactory.initElements(driver, DatePicker.class);
		demoDate.pickMe();
		test5.log(LogStatus.INFO, "run pickMe from DatePick.java");
		WebElement dateChosen = driver.findElement(By.id("datepicker1"));
		String dateValue = dateChosen.getAttribute("value");
		System.out.println("Your chosen date is "+dateValue);
		test5.log(LogStatus.INFO, "Get value attribute from within the box");
		test5.log(LogStatus.INFO, "check if date is December 27, 2018");
		try {
		assertEquals("December 27, 2018", dateValue);
		test5.log(LogStatus.PASS, "The date chosen is " + dateValue);
		}
		catch (AssertionError x) {
		test5.log(LogStatus.FAIL, "The date chosen is " + dateValue);
		fail();
		}
		finally {
			newReport.endTest(test5);
		}
		
	}
	
	@Test
	public void menuTest() {
		test6 = newReport.startTest("Menu");
		newHome.menu();
		test6.log(LogStatus.INFO, "Go to menu page");
		sleep1Second();
		Menu demoDate = PageFactory.initElements(driver, Menu.class);
		demoDate.hoverMenu();
		test6.log(LogStatus.INFO, "run hoverMenu from menu.java");
		WebElement contact = driver.findElement(By.xpath("//*[@id=\"navigate\"]/ul/li[3]/a"));
		WebElement box = driver.findElement(By.xpath("//*[@id=\"navigate\"]/ul/li[3]"));
		String backgroundColour1 = box.getCssValue("background-color");
		String href1 = contact.getAttribute("href");
		test6.log(LogStatus.INFO, "obtain background colour and href of Contact box");
		try {
		assertEquals("http://demoqa.com/menu/#", href1);
		assertEquals("rgba(255, 153, 0, 1)", backgroundColour1);
		test6.log(LogStatus.PASS, "It worked!");
		}
		catch (AssertionError x) {
		test6.log(LogStatus.FAIL, "Link isn't # or Background colour didn't change");
		fail();
		}
		finally {
			newReport.endTest(test6);
		}
	}
	
	@Test
	public void sliderTest() {
		test7 = newReport.startTest("Slider");
		newHome.slider();
		test7.log(LogStatus.INFO, "Go to slider page");
		sleep1Second();
		Slider demoSlider = PageFactory.initElements(driver, Slider.class);
		demoSlider.slideIt();
		test7.log(LogStatus.INFO, "run sliderIT from slider.java");
		WebElement numberBox = driver.findElement(By.id("amount1"));
		String value = numberBox.getAttribute("value");
		System.out.println(value);
		test7.log(LogStatus.INFO, "get the value that is displayed on the page, comapare it to what it should display");
		try {assertEquals("6",value);
			test7.log(LogStatus.PASS, "The number equals 6!");
		}
		catch (AssertionError f) {
			test7.log(LogStatus.FAIL, "Number does not equal 6");
			fail();
		}
		finally {
			newReport.endTest(test7);
		}
	}
	
	@Test
	public void tabsTest() {
		test8 = newReport.startTest("Tabs");
		newHome.tabs();
		test8.log(LogStatus.INFO, "Go to tabs page");
		sleep1Second();
		Tabs demoTabs = PageFactory.initElements(driver, Tabs.class);
		demoTabs.selectingTabs();
		test8.log(LogStatus.INFO, "run selectingTabs from tabs.java");
		WebElement tab2 = driver.findElement(By.xpath("//*[@id=\"tabs222\"]/ul/li[2]"));
		String tab2Class = tab2.getAttribute("class");
		System.out.println(tab2Class);
		test8.log(LogStatus.INFO, "assign tab2 as webelement via xpath, then get attribute and compare between active state");
		try{
			assertEquals("ui-state-default ui-corner-top ui-state-hover ui-state-focus ui-tabs-active ui-state-active", tab2Class);
			//could do assertTrue and do .contains(ui-state-active)
			test8.log(LogStatus.PASS, "Tab 2 was selected");
		}
		catch (AssertionError w) {
			test8.log(LogStatus.FAIL, "Tab 2 is not selected");
			fail();
		}
		finally {
			newReport.endTest(test8);
		}
	}
	
	@Test
	public void toolsTest() {
		test9 = newReport.startTest("Tooltip");
		newHome.tools();
		test9.log(LogStatus.INFO, "Go to tabs page");
		sleep1Second();
		Tools demoTabs = PageFactory.initElements(driver, Tools.class);
		demoTabs.toolTip();
		test9.log(LogStatus.INFO, "run selectingTabs from tabs.java");
		WebElement tab2 = driver.findElement(By.className("ui-tooltip"));
		System.out.println(tab2);
		test9.log(LogStatus.INFO, "assign tab2 as the pop up tool tip and see if it is displayed");
		try{
			assertTrue("Tooltip is not Displayed",tab2.isDisplayed());
		
			test9.log(LogStatus.PASS, "Tooltip displayed");
		}
		catch (AssertionError w) {
			test9.log(LogStatus.FAIL, "Tooltip did not show");
			fail();
		}
		finally {
			newReport.endTest(test9);
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
