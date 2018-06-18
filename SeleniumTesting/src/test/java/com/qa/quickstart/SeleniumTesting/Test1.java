package com.qa.quickstart.SeleniumTesting;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
	ChromeDriver driver;
	
	@BeforeClass
	public void settingChrome() {
	System.setProperty("webdriver.chrome.driver","Desktop\\chromedriver.exe");
	}
	
	@Before
	public void before1() {
		driver = new ChromeDriver();
	}
	
	@Test
	public void test() {
		driver.manage().window().maximize();
		String url = "http://www.google.com";
		driver.navigate().to(url);
		assertEquals("http://www.google.com", driver.getCurrentUrl());
	}
	
	@After
	public void quitting(){
		driver.quit();
	}

}
