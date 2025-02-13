package FrameWrokTesting.tests;

import org.testng.annotations.Test;

import FrameWrokTesting.base.BaseTest;
import frameWrokTesting.pageComponents.CartPage;
import frameWrokTesting.pageComponents.LoginPage;
import frameWrokTesting.pageComponents.OrderConfirmationPage;
import frameWrokTesting.pageComponents.PaymentPage;
import frameWrokTesting.pageComponents.ProductCataloguePage;

public class Purchase extends BaseTest {
	// login variables
	String userName = "user.test54365@gmail.com";
	String password = "User@123";
	// URL
	String url = "https://rahulshettyacademy.com/client";

	// Getting the product list from user
	String productToBuy = "iPhone,qwerty";
	String[] shoppingItems;
	// Payment Variables
	String cvv = "856";
	String name = "User";
	String country = "India";

	@Test
	public void submitOrder() throws InterruptedException {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.goTo(url);
		loginPage.login(userName, password);
		ProductCataloguePage productCatalogue = new ProductCataloguePage(getDriver());
		shoppingItems = productCatalogue.selectProduct(productToBuy);
		// Cross checking the items are correct or not
		CartPage cartPage = new CartPage(driver);
		cartPage.checkItems(shoppingItems);
		// proceed to buy
		cartPage.proceedToBuy();
		PaymentPage paymentPage = new PaymentPage(driver);
		paymentPage.paymentProcess(cvv, name, country);
		OrderConfirmationPage confirmOrder = new OrderConfirmationPage(driver);
		confirmOrder.confirmOrder();

	}

}
