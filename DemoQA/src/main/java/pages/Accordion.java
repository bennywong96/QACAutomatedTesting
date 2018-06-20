package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accordion {
	
	WebDriver driver;
	public Accordion(WebDriver driver){
        this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id=\"ui-id-4\"]")
	private WebElement section1;
	
	@FindBy(xpath = "//*[@id=\"ui-id-6\"]") 
	private WebElement section2;
	
	@FindBy(xpath = "//*[@id=\"ui-id-8\"]")
	private WebElement section3;
	
	@FindBy(xpath = "//*[@id=\"ui-id-10\"]")
	private WebElement section4;

	
	public void selectingBoxes() {
		section2.click();
		sleepNow();
		section3.click();
		sleepNow();
		section4.click();
		sleepNow();
		section1.click();
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
