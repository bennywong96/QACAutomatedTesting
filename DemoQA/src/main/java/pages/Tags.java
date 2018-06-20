package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Tags {


	WebDriver driver;
	public Tags(WebDriver driver){
        this.driver = driver;
	}
	
	@FindBy(id = "tagss")
	private WebElement tags;
	
	@FindBy(className = "ui-menu-item")
	private WebElement menuItem;
	
	
	public void searchHaskell() {
		Actions act1 = new Actions(driver);
		tags.click();
		tags.sendKeys("Hask");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		act1.moveToElement(menuItem).click().perform();
		
		
	}
}
