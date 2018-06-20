package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Menu {
	
	WebDriver driver;
	public Menu(WebDriver driver){
        this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id=\"navigate\"]/ul/li[3]/a") 
	private WebElement contact;
	
	
	public void hoverMenu() {
		Actions act1 = new Actions(driver);
		act1.moveToElement(contact).perform();
		act1.moveByOffset(0, -30).pause(1000).moveByOffset(0, -30).perform();
		act1.pause(1000).moveByOffset(0, 120).pause(1000).perform();
		act1.moveByOffset(0, -30).pause(1000).moveByOffset(0,-30).pause(2000).perform();
		
		//check if background colour = yellow
		
	}
	

}
