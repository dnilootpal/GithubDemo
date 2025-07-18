package RahulShettyAcademy.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;

	// Now will create a constructor to access chromedriver
	// Constructor takes same name as class name
	// but constructor method will execute first if anybody tries to initialize the object of this class
	
	//This is a page object and it should not hold any data
	//It should just hold Elements and actions

	public CartPage(WebDriver driver) 
	{
		super(driver);

		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	public boolean verifyProductDisplay(String productName)
	{
		Boolean match = cartProducts.stream().anyMatch(Product->Product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutElement;
	
	public CheckoutPage goToCheckout()
	{
		checkoutElement.click();
		return new CheckoutPage(driver);
	}
	
	
}
