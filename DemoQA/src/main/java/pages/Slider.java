package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Slider {

	WebDriver driver;
	public Slider(WebDriver driver){
        this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id=\"slider-range-max\"]/span") 
	private WebElement slider;

public void slideIt() {
	try {
		Actions act1 = new Actions(driver);
		act1.moveToElement(slider).clickAndHold().perform();
		for (int i = 0; i <= 8; i++) {
			act1.moveByOffset(65,0).pause(700).perform();
		}
		
		for (int j=0;j<=3; j++) {
			act1.moveByOffset(-65,0).pause(700).perform();
		}
		act1.release();
		
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
