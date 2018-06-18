package com.qa.quickstart.SeleniumTesting;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {
	ChromeDriver driver;
	
	
	@Before
	public void before1() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");
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
