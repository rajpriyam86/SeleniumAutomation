package frameWrokTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderConfirmationPage {
	
	WebDriver driver;
	
	
	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h1[@class='hero-primary']")
	WebElement confirmationmsg;

	public void confirmOrder() throws InterruptedException {
		Thread.sleep(2000);
		String msg = confirmationmsg.getText();
		Assert.assertEquals(msg, "THANKYOU FOR THE ORDER.");
		
	}
	

}
