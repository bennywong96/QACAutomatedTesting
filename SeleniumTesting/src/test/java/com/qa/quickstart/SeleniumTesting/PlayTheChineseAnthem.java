package com.qa.quickstart.SeleniumTesting;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PlayTheChineseAnthem {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testPlayTheChineseAnthem() throws Exception {
    driver.get("https://www.google.co.uk/search?q=wikipedia&rlz=1C1CHBF_en-GBGB801GB801&oq=wiki&aqs=chrome.0.35i39j69i57j69i60l3j0.1455j0j4&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.linkText("Wikipedia, the free encyclopedia")).click();
    driver.findElement(By.linkText("Li Yuan")).click();
    driver.findElement(By.linkText("Emperor Taizong")).click();
    driver.findElement(By.linkText("Tang dynasty")).click();
    driver.findElement(By.linkText("Guangzhou Massacre")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Guangzhou')])[3]")).click();
    driver.findElement(By.linkText("mainland China")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Republic of China')])[4]")).click();
    driver.findElement(By.linkText("People's Republic of China")).click();
    driver.findElement(By.xpath("//div[@id='mw-content-text']/div/table/tbody/tr[3]/td/div/div[2]/div/div/span/div/div[2]/div[6]/span")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
