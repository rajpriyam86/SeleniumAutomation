package frameWrokTesting.pageComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import frameWrokTesting.utilities.GenericMethods;

public class CartPage extends GenericMethods{
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="(//button[@routerlink='/dashboard/cart'])[1]")
	WebElement cartIcon;
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartItems;
	
	@FindBy(xpath = "//div[contains(@class, 'subtotal')]/ul/li[3]/button")
	WebElement submitButton;
	
	By proceedToBuyButton = By.xpath("//div[contains(@class, 'subtotal')]/ul/li[3]/button");
	
	public void checkItems(String[] shoppingItems) {
		cartIcon.click();
		for (WebElement cartItem : cartItems) {
		    boolean matchFound = false; // Flag to track if a match is found

		    for (String shoppingItem : shoppingItems) {
		        if (cartItem.getText().toLowerCase().contains(shoppingItem.toLowerCase())) {
		            matchFound = true; // Match found
		            break; // Exit inner loop
		        }
		    }

		    // Assert outside the inner loop to check if a match was found
		    Assert.assertTrue(matchFound, "Cart item does not match any shopping items: " + cartItem.getText());
		}
	}
	
	public void proceedToBuy() throws InterruptedException {
		Thread.sleep(1000);
		waitForElement(proceedToBuyButton);
		scrollDownToEndByKeyboard();
		submitButton.click();
	}
}
