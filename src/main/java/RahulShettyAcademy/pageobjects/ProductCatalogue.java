package RahulShettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	WebDriver driver;

	// Now will create a constructor to access chromedriver
	// Constructor takes same name as class name
	// but constructor method will execute first if anybody tries to initialize the object of this class
	
	//This is a page object and it should not hold any data
	//It should just hold Elements and actions

	public ProductCatalogue(WebDriver driver) 
	{
		super(driver);

		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));


	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	By productsBy= By.cssSelector(".mb-3");
	By addToCart= By.cssSelector(".card-body button:last-of-type");
	By toastMessage= By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
		
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	@FindBy(css = "#toast-container")
	WebElement spinner;
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod= getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//driver.findEle so we using PageFactory

		waitForElementToDisapper(spinner);
	}
	
	
}
