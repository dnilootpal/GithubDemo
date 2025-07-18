package RahulShettyAcademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import RahulShettyAcademy.TestComponents.BaseTest;
import RahulShettyAcademy.pageobjects.CartPage;
import RahulShettyAcademy.pageobjects.CheckoutPage;
import RahulShettyAcademy.pageobjects.ConfirmationPage;
import RahulShettyAcademy.pageobjects.LandingPage;
import RahulShettyAcademy.pageobjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImplementation extends BaseTest{
	
	public LandingPage landingPage;
	public ProductCatalogue productCataloguePage;
	public ConfirmationPage confirmationPage;
	
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage=launchApplication();
	}
	
    @Given("I logged in with username {string} and password {string}")
    public void  I_logged_in_with_username_and_password(String username, String password)
    {
    	productCataloguePage = landingPage.loginApplication(username, password);
    }
    
    @When("I add product {string} to Cart")
    public void I_add_product_to_Cart(String productName) throws InterruptedException
    {
    	List<WebElement> products = productCataloguePage.getProductList();
		productCataloguePage.addProductToCart(productName);
    }
    
    @When("Checkout product {string} and submit the order")
    public void Checkout_product_and_submit_the_order(String productName) throws InterruptedException
    {
		CartPage cartPage = productCataloguePage.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
	    confirmationPage = checkoutPage.submitOrder();

    }
    
    @Then("I verify the message {string} is displayed on Confirmation page")
    public void I_verify_the_message_is_displayed_on_Confirmation_page(String message)
    {
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollTo(0, 0);");

		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(message));
		driver.close();
    }
    
    @Then("Verify {string} message is displayed")
    public void Verify_message_is_displayed(String errorMessage)
    {
		Assert.assertEquals(errorMessage, landingPage.getErrorMessage());
		driver.close();

    }


}