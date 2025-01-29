package FrameWrokTesting.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import FrameWrokTesting.base.BaseTest;
import frameWrokTesting.pageComponents.CartPage;
import frameWrokTesting.pageComponents.LoginPage;
import frameWrokTesting.pageComponents.OrderConfirmationPage;
import frameWrokTesting.pageComponents.PaymentPage;
import frameWrokTesting.pageComponents.ProductCataloguePage;
import frameWrokTesting.pageComponents.RegistrationPage;

public class EndToEndTesting extends BaseTest {


		String userFirstName = "User";
		String userLastName = "Test";
		String userEmailId = "usertest82107@gmail.com";
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
		
		//URL
		String url = "https://rahulshettyacademy.com/client";
		
		String[] shoppingItems;


		// Register

		@Test
		public void resgistartionTest() throws InterruptedException {
		RegistrationPage registrationPage = new RegistrationPage(getDriver());
		registrationPage.goTo(url);
		String accountCreationConfirmation = registrationPage.formFillUp(userFirstName, userLastName, userEmailId, userMobileNumber, userOccupation,
				setPassword);
		Assert.assertEquals(accountCreationConfirmation, "Account Created Successfully");
		}

		// Login
		@Test(dependsOnMethods = "resgistartionTest")
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