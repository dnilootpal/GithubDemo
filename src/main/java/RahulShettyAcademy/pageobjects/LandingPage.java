package RahulShettyAcademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	// Now will create a constructor to access chromedriver
	// Constructor takes same name as class name
	// but constructor method will execute first if anybody tries to initialize the object of this class
	
	//This is a page object and it should not hold any data
	//It should just hold Elements and actions

	public LandingPage(WebDriver driver) {
		
		//To send variables from child to driver we can use super()
		//To catch driver in PARENT, create constructor
		
		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");

	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	// Another way to declare is PageFactory

	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	WebElement userPassword;
	
	@FindBy(id = "login")
	WebElement Submit;
	
	//class of incorrect username or pwd error message is: ng-tns-c4-8 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalogue loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		Submit.click();
		ProductCatalogue productCataloguePage = new ProductCatalogue(driver);
		return productCataloguePage;
		
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
}
