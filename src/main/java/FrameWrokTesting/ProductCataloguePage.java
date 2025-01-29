package frameWrokTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericMethods;

public class ProductCataloguePage extends GenericMethods{
	
	WebDriver driver;

	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div[contains(@class, mb-3)]/div[@class = 'card']")
	List<WebElement> productList;
	
	By products = By.xpath("//div[contains(@class, mb-3)]/div[@class = 'card']");
	
	public String[]  selectProduct(String productToBuy) throws InterruptedException {
		
		waitForElement(products);
		String[] shoppingItems = productToBuy.split(",");
		
		int j = 1; // to stop after finding required products

		String selectedProduct;
		System.out.println(productList.size());

		outer: // Label for the outer loop
		for (WebElement product : productList) {
		    selectedProduct = product.getText();
		    for (int i = 0; i < shoppingItems.length; i++) {
		        System.out.println(i);
		        System.out.println(shoppingItems[i]);
		        if (selectedProduct.toLowerCase().contains(shoppingItems[i].toLowerCase())) {
		            j++;
		            product.findElement(By.xpath(".//button[2]")).click(); // Relative XPath
		            Thread.sleep(2000);
		            if (j > shoppingItems.length) { // Stop after adding all required items
		                break outer; // Breaks out of both loops
		            }
		            break; // Breaks out of the inner loop
		        }
		    }
		}
		return shoppingItems;
	}

}
