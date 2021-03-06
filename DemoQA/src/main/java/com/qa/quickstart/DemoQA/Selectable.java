package com.qa.quickstart.DemoQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Selectable {
	WebDriver driver;
	public Selectable(WebDriver driver){
        this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[1]") 
	private WebElement selectable;
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[3]")
	private WebElement item3;

public void selectAll() {
	try {
		Actions act1 = new Actions(driver);
		act1.moveToElement(selectable).clickAndHold().moveByOffset(0, 250).release().perform();
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void selectItem3() {
	try {
		Actions act2 = new Actions(driver);
		act2.moveToElement(item3).click().perform();
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
