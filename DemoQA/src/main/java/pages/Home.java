package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Home {
	WebDriver driver;
	public Home(WebDriver driver){
        this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id=\"menu-item-141\"]/a") 
	private WebElement droppable;
	@FindBy(xpath = "//*[@id=\"menu-item-142\"]/a") 
	private WebElement selectable;
	@FindBy(xpath = "//*[@id=\"menu-item-144\"]/a")
	private WebElement accordion;
	@FindBy(xpath = "//*[@id=\"menu-item-145\"]/a")
	private WebElement autoComplete;
	@FindBy(xpath = "//*[@id=\"menu-item-146\"]/a")
	private WebElement datePicker;
	@FindBy(xpath = "//*[@id=\"menu-item-147\"]/a")
	private WebElement menu;
	@FindBy(xpath = "//*[@id=\"menu-item-97\"]/a")
	private WebElement slider;
	@FindBy(xpath = "//*[@id=\"menu-item-98\"]/a")
	private WebElement tabs;
	@FindBy(xpath = "//*[@id=\"menu-item-99\"]/a")
	private WebElement tooltip;
	
	public void draggablePage() {
		droppable.click();
	}

	public void selectablePage() {
		selectable.click();
	}
	
	public void accordionPage() {
		accordion.click();
	}
	
	public void autoComplete() {
		autoComplete.click();
	}
	
	public void datePicker() {
		datePicker.click();
	}
	
	public void menu() {
		menu.click();
	}
	
	public void slider() {
		slider.click();
	}
	
	public void tabs() {
		tabs.click();
	}
	public void tools() {
		tooltip.click();
	}
}
