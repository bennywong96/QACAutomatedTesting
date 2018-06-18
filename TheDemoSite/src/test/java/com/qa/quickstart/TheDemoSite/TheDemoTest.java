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

public class TheDemoTest {
ChromeDriver driver;
	

	@Before
	public void before1() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test() {
		driver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/index.php";
		driver.navigate().to(url);
		driver.findElement(By.linkText("3. Add a User")).click();
		assertEquals("http://thedemosite.co.uk/addauser.php", driver.getCurrentUrl());
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("TestingAc");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("H1Th3r3");
	    driver.findElement(By.name("FormsButton2")).click();
	    driver.findElement(By.linkText("4. Login")).click();
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("TestingAc");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("H1Th3r3");
	    driver.findElement(By.name("FormsButton2")).click();
	
	    WebElement newElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
	    String status = newElement.getText();
	    System.out.println(status);
	    assertEquals("**Sucessful Login**", status);
	    
	}
	
	@After
	public void quitting(){
		driver.quit();
	}
}
