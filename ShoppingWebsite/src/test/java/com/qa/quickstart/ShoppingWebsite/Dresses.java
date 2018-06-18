package com.qa.quickstart.ShoppingWebsite;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dresses {
	ChromeDriver driver;

	
	@Before
	public void before1() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test() {
		driver.manage().window().maximize();
		String url = "http://automationpractice.com/index.php";
		driver.navigate().to(url);
	    driver.findElement(By.id("search_query_top")).click();
	    driver.findElement(By.id("search_query_top")).clear();
	    driver.findElement(By.id("search_query_top")).sendKeys("dress");
	    driver.findElement(By.id("searchbox")).submit();
	    WebElement testing = driver.findElement(By.xpath("(//a[contains(text(),'Printed Dress')])[3]"));
	    String testing1 = testing.getText();
	    System.out.println(testing1);
	}
	
	@After
	public void quitting(){
		driver.quit();
	}



}
