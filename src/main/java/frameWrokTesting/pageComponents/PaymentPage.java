package frameWrokTesting.pageComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameWrokTesting.utilities.GenericMethods;

public class PaymentPage extends GenericMethods {
	
	WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@class ='input txt'][1]")
	WebElement cvv;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement name;
	
	@FindBy(xpath="//input[@placeholder ='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//button[@type='button'][2]")
	WebElement selectCountry;
	
	@FindBy(xpath = "//a[contains(@class, 'action__submit')]")
	WebElement placeOrderButton;
	
	public void paymentProcess(String typeCvv, String typeName, String typeCountry) throws InterruptedException {
		cvv.sendKeys(typeCvv);
		name.sendKeys(typeName);
		country.sendKeys(typeCountry);
		Thread.sleep(2000);
		moveToElement(selectCountry);
		placeOrderButton.click();
	}
	

}
