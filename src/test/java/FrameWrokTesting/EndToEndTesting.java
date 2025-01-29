package FrameWrokTesting;

import org.testng.annotations.Test;

import base.BaseTest;
import frameWrokTesting.CartPage;
import frameWrokTesting.LoginPage;
import frameWrokTesting.OrderConfirmationPage;
import frameWrokTesting.PaymentPage;
import frameWrokTesting.ProductCataloguePage;
import frameWrokTesting.RegistrationPage;

public class EndToEndTesting extends BaseTest {


		String userFirstName = "User";
		String userLastName = "Test";
		String userEmailId = "usertest84567@gmail.com";
		String userMobileNumber = "8542136582";
		String userOccupation = "Student";
//		String userGender = null;
		String setPassword = "User@123";
		
		//login variables
		String userName = "user.test54365@gmail.com";
		String password = "User@123";
		
		//Payment Variables
		String cvv = "856";
		String name = "User";
		String country = "India";
		
		// Getting the product list from user
		String productToBuy = "iPhone,qwerty";
		
		String[] shoppingItems;


		// Register

		@Test
		public void resgistartionTest() throws InterruptedException {
		RegistrationPage registrationPage = new RegistrationPage(getDriver());
		registrationPage.formFillUp(userFirstName, userLastName, userEmailId, userMobileNumber, userOccupation,
				setPassword);
		}

		// Login
		@Test(dependsOnMethods = "resgistartionTest")
		public void loginTest() {
		driver.get("https://rahulshettyacademy.com/client");

		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.login(userName, password);
		}

		
		@Test(dependsOnMethods = "loginTest")
		public void selectProduct() throws InterruptedException {
		ProductCataloguePage productCatalogue = new ProductCataloguePage(getDriver());
		shoppingItems = productCatalogue.selectProduct(productToBuy);
		}
		
		

		@Test(dependsOnMethods = "selectProduct")
		public void confirmItems() throws InterruptedException {
		// Cross checking the items are correct or not
		CartPage cartPage = new CartPage(driver);
		cartPage.checkItems(shoppingItems);
		// proceed to buy
		cartPage.proceedToBuy();
		}
		
		@Test(dependsOnMethods = "confirmItems")
		public void makePayment() throws InterruptedException {
		PaymentPage paymentPage = new PaymentPage(driver);
		paymentPage.paymentProcess(cvv, name, country);
		}

		@Test(dependsOnMethods = "makePayment")
		public void orderConfirmation() throws InterruptedException {
		OrderConfirmationPage confirmOrder = new OrderConfirmationPage(driver);
		confirmOrder.confirmOrder();
		}


}