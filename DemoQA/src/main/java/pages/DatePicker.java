package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatePicker {
	WebDriver driver;
	public DatePicker(WebDriver driver){
        this.driver = driver;
	}
	
	@FindBy(id = "datepicker1") 
	private WebElement datePicker1;
	
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")
	private WebElement nextMonth;
	
	@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[4]/a")
	private WebElement the27th;
	
	public void pickMe() {
		datePicker1.click();
		sleep1Second();
		
		for (int i = 0; i<6; i++) {
			nextMonth.click();
			sleep1Second();	
		}
		the27th.click();
		sleep1Second();
		sleep1Second();
		
	}
	
	public void sleep1Second(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
