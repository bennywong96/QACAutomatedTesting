package com.qa.quickstart.TheDemoSite;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Verify;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TheDemoTest {
	String status;
	WebElement newUserU;
	WebElement newUserP;
	ChromeDriver driver;
	ExtentReports newReport = new ExtentReports("C:\\Users\\Admin\\Desktop\\Automated Test\\Reports\\newReport.html",
			true);
	ExtentTest test;
	ExtentTest test2;
	FileInputStream file = null;
	FileOutputStream fileOut = null;
	XSSFWorkbook workbook = null;
	XSSFCell username;
	XSSFCell password;
	XSSFCell cellValue;

	@Before
	public void before1() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/index.php";
		driver.navigate().to(url);

	}

	@Test
	public void test() {
		test = newReport.startTest("Creating New Login");
		driver.findElement(By.linkText("3. Add a User")).click();
		test.log(LogStatus.INFO, "Navigated to Add New User");
		assertEquals("http://thedemosite.co.uk/addauser.php", driver.getCurrentUrl());
		newUser1();
		test.log(LogStatus.INFO, "Entered TestingAc as username and H1Th3r3 as password");
		driver.findElement(By.linkText("4. Login")).click();
		test.log(LogStatus.INFO, "Navigate to Login Page");
		newUser1();
		test.log(LogStatus.INFO, "Login with new created account");
		WebElement newElement = driver
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		status = newElement.getText();

		try {
			newMethod();
			test.log(LogStatus.PASS, "Successful Login");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Ya Failed M8");
			fail();
		} finally {
			System.out.println(status);
			newReport.endTest(test);
		}

	}

	public void newUser1() {
		newUserU = driver.findElement(By.name("username"));
		newUserU.click();
		newUserU.clear();
		newUserU.sendKeys("TestingAc");
		newUserP = driver.findElement(By.name("password"));
		newUserP.click();
		newUserP.clear();
		newUserP.sendKeys("H1Th3r3");
		driver.findElement(By.name("FormsButton2")).click();
	}

	public void excelUsers() {
		newUserU = driver.findElement(By.name("username"));
		newUserU.click();
		newUserU.clear();
		newUserU.sendKeys(username.getStringCellValue());
		newUserP = driver.findElement(By.name("password"));
		newUserP.click();
		newUserP.clear();
		newUserP.sendKeys(password.getStringCellValue());
		driver.findElement(By.name("FormsButton2")).click();
	}

	public void newMethod() throws AssertionError {
		assertEquals("**Successful Login**", status);
	}

	@Ignore
	@Test
	public void excelTest() throws EncryptedDocumentException, InvalidFormatException, IOException {
		test2 = newReport.startTest("Excel Time");

		file = new FileInputStream(Constants.Path_TestData + Constants.File_TestData);
		workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		fileOut = new FileOutputStream("C:\\Users\\Admin\\Desktop\\Automated Test\\TestData\\abcde.xlsx");
		int i = 0;
		int j = 0;
		username = sheet.getRow(i).getCell(j);
		while (!username.getStringCellValue().equals("")) {
			file = new FileInputStream(Constants.Path_TestData + Constants.File_TestData);
			workbook = new XSSFWorkbook(file);
			username = sheet.getRow(i).getCell(j);
			password = sheet.getRow(i).getCell(1);
			cellValue = sheet.getRow(i).getCell(2);
			if (cellValue == null) {
				cellValue = sheet.getRow(i).createCell(2);
			}
			System.out.println(username.getStringCellValue());
			System.out.println(sheet.getRow(i).getCell(1));
			System.out.println();
			driver.findElement(By.linkText("3. Add a User")).click();
			test2.log(LogStatus.INFO, "Navigated to Add New User");
			excelUsers();
			driver.findElement(By.linkText("4. Login")).click();
			test2.log(LogStatus.INFO, "Navigate to Login Page");
			excelUsers();
			file.close();
			workbook.close();

			workbook = new XSSFWorkbook();
			Sheet sheet1 = workbook.createSheet("Results");
			Row newRow = sheet1.createRow(i);
			Cell cell = newRow.createCell(0);

			cell.setCellValue(status);
			System.out.println(cell);
			workbook.write(fileOut);

			fileOut.close();
			workbook.close();

			i++;
		}
		// file.close();

		//
	}

	XSSFSheet sheet2;
	XSSFWorkbook workbook1;

	@Test
	public void newReading() throws IOException {
		test2 = newReport.startTest("Excel Time");
		readingFrom();
	}

	private void modifyExistingWorkbook(int i) throws InvalidFormatException, IOException {

		Row row = sheet2.createRow(0);
		Cell cell = row.createCell(i);
		WebElement newElement = driver
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		status = newElement.getText();
		cell.setCellValue(status);
	}

	private void writeTo() throws IOException {
		FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData + Constants.File_TestData);

		workbook1.write(fileOut);
		fileOut.close();
		workbook1.close();
	}
	
	private void readingFrom() throws IOException {
		file = new FileInputStream(Constants.Path_TestData + Constants.File_TestData);
		workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int i = 0;
		int j = 0;
		username = sheet.getRow(i).getCell(j);
		password = sheet.getRow(i).getCell(1);
		while (!username.getStringCellValue().equals("")) {
			driver.findElement(By.linkText("3. Add a User")).click();
			test2.log(LogStatus.INFO, "Navigated to Add New User");
			excelUsers();
			driver.findElement(By.linkText("4. Login")).click();
			test2.log(LogStatus.INFO, "Navigate to Login Page");
			excelUsers();

			i++;
			username = sheet.getRow(i).getCell(j);
			password = sheet.getRow(i).getCell(1);
		}
		file.close();

	}

	@After
	public void quitting() {
		driver.quit();
		newReport.flush();
	}
}
