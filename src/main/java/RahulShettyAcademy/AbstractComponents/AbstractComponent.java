package RahulShettyAcademy.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import RahulShettyAcademy.pageobjects.CartPage;
import RahulShettyAcademy.pageobjects.OrderPage;

public class AbstractComponent {
	
	//AbstractComponent will be the parent class to all page object classes like LandingPage, ProductCatalogue
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);


	}

	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisapper(WebElement ele) throws InterruptedException
	{
		//For faster execution used thread.sleep()
		Thread.sleep(1000);
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;

	}
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	
	public OrderPage goToOrdersPage()
	{
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;

	}

}
