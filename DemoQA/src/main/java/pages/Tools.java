package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Tools {
	WebDriver driver;
	public Tools(WebDriver driver){
        this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id=\"age\"]")
	private WebElement age;
	@FindBy(xpath = "//*[@id=\"tabs-1\"]/div/p[1]/a")
	private WebElement text;
	
	

	
	public void toolTip() {
		
		Actions act1 = new Actions(driver);
		act1.moveToElement(text).perform();
		sleepNow();
		sleepNow();
		act1.moveToElement(age).perform();
		sleepNow();
		
	}
	
	
	public void sleepNow() {
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
