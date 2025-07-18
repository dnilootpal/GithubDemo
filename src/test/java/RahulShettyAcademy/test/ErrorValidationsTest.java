package RahulShettyAcademy.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import RahulShettyAcademy.TestComponents.BaseTest;
import RahulShettyAcademy.TestComponents.Retry;
import RahulShettyAcademy.pageobjects.CartPage;
import RahulShettyAcademy.pageobjects.CheckoutPage;
import RahulShettyAcademy.pageobjects.ConfirmationPage;
import RahulShettyAcademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest{

	//Trying some negative TCs in this java class
	
	@Test(groups={"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws InterruptedException, IOException
	{
		
		String productName = "ZARA COAT 3";

		ProductCatalogue productCataloguePage = landingPage.loginApplication("dnilootpal@gmail.com", "abcNilu@310596");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	
	@Test
	public void ProductErrorValidation() throws InterruptedException, IOException
	{
		
		String productName = "ZARA COAT 3";

	
		ProductCatalogue productCataloguePage = landingPage.loginApplication("dnilootpal@gmail.com", "Nilu@310596");
		List<WebElement> products = productCataloguePage.getProductList();
		productCataloguePage.addProductToCart(productName);

		// Inheritance used so we can use parent class methods in child's class
		CartPage cartPage = productCataloguePage.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");

		Assert.assertFalse(match);

	

	}

}
