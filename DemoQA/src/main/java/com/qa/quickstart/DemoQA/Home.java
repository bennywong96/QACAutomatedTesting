package com.qa.quickstart.DemoQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Home {
	WebDriver driver;
	public Home(WebDriver driver){
        this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id=\\\"menu-item-141\\\"]/a") 
	private WebElement droppable;
	@FindBy(xpath = "//*[@id=\\\"menu-item-142\\\"]/a") 
	private WebElement selectable;

	public void draggablePage() {
		droppable.click();
	}

	public void selectablePage() {
		selectable.click();
	}
}
