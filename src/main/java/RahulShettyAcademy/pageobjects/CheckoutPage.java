package RahulShettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import RahulShettyAcademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {


	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement countryElement;
	
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	@FindBy(css = ".action__submit")
	WebElement submit;
	
	By results= By.cssSelector(".ta-results");
	
	public void selectCountry (String countryName)
	{
		Actions a= new Actions(driver);
		a.sendKeys(countryElement,countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();

	}
	public ConfirmationPage submitOrder()
	{
		submit.click();
		return new ConfirmationPage(driver);
	}
}
