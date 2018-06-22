package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Tabs {
	WebDriver driver;
	public Tabs(WebDriver driver){
        this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id=\"tabs222\"]/ul/li[1]")
	private WebElement tab1;
	
	@FindBy(xpath = "//*[@id=\"tabs222\"]/ul/li[2]") 
	private WebElement tab2;
	
	@FindBy(xpath = "//*[@id=\"tabs222\"]/ul/li[3]")
	private WebElement tab3;
	

	
	public void selectingTabs() {
		tab2.click();
		sleepNow();
		tab3.click();
		sleepNow();
		tab1.click();
		sleepNow();
		tab2.click();
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
