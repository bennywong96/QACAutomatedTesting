package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Draggable {
	WebDriver driver;
	public Draggable(WebDriver driver){
        this.driver = driver;
	}
	
	@FindBy(id = "draggableview") 
	private WebElement draggable;
	@FindBy(id = "droppableview") 
	private WebElement droppable;

public void dragIt() {
	try {
		Actions act1 = new Actions(driver);
		act1.moveToElement(draggable).clickAndHold().moveToElement(droppable).perform();
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	

}
