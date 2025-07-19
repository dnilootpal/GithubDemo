package RahulShettyAcademy.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RahulShettyAcademy.TestComponents.BaseTest;
import RahulShettyAcademy.pageobjects.CartPage;
import RahulShettyAcademy.pageobjects.CheckoutPage;
import RahulShettyAcademy.pageobjects.ConfirmationPage;
import RahulShettyAcademy.pageobjects.LandingPage;
import RahulShettyAcademy.pageobjects.OrderPage;
import RahulShettyAcademy.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest{

	String productName = "ZARA COAT 3";

	
	@Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException
	{
		

		//Commenting line 35-47 because we created initializeDriver and launchApp methods in the base test
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		// create object of Landing Page class for it to access the driver from
//		// StandAlone class
//		LandingPage landingPage = new LandingPage(driver);
//		landingPage.goTo();
		
		//Commenting out line 47 since we created object of LandingPage in parent class ie.BaseTest.java
//		LandingPage landingPage = launchApplication();
		ProductCatalogue productCataloguePage = landingPage.loginApplication(input.get("email"), input.get("password"));

// Since we already created prodcatalog object inside landing page so no need to create it in test class
//		ProductCatalogue productCataloguePage = new ProductCatalogue(driver);

		List<WebElement> products = productCataloguePage.getProductList();
		productCataloguePage.addProductToCart(input.get("productName"));

		// Inheritance used so we can use parent class methods in child's class
		CartPage cartPage = productCataloguePage.goToCartPage();

// Since we already created cartPage object inside AbstractClass(for prodCatalog) so no need to create it in test class

//   	CartPage cartPage = new CartPage(driver);
		Boolean match = cartPage.verifyProductDisplay(input.get("productName"));

		Assert.assertTrue(match);

//		Thread.sleep(2000);

		// ways to scroll to checkout button

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// scroll to a specific element
//		WebElement element= driver.findElement(By.cssSelector(".totalRow button"));
//		js.executeScript("arguments[0].scrolllIntoView(true);", element);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		// scroll by pixels
//		js.executeScript("window.scrollBy(0,500);");

		// click on checkout button
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));

		Thread.sleep(2000);

		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();

//		driver.findElement(By.cssSelector(".totalRow button")).click();
//		
//		//Thread.sleep(2000);
//		//js.executeScript("window.scrollBy(0,500);");
//
//
//		//enter country in the auto suggestive dropdown
//		Actions a= new Actions(driver);
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		// or we can type india without using actions
		// driver.findElement(By.cssSelector("[placeholder='Select
		// Country']")).sendKeys("India");

		// to select India from suggestive dropdown
		// css is= .ta-item:nth-of-type(2)
		// xpath is= (//button[contains(@class,'ta-item')])[2]

//		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

		// js.executeScript("window.scrollBy(0,1600);");

//		driver.findElement(By.cssSelector(".action__submit")).click();
//		Thread.sleep(2000);

		js.executeScript("window.scrollTo(0, 0);");

		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		//Commenting out below line since method is created with @AfterMethod in BaseTest
//		driver.close();

	}
	
	//To verify ZARA COAT 3 is displaying in the orders page, another Test Case is reqd
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		ProductCatalogue productCataloguePage = landingPage.loginApplication("dnilootpal@gmail.com", "Nilu@310596");
		OrderPage ordersPage = productCataloguePage.goToOrdersPage();
		Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));
	}
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		
//		return new Object[][] {{"dnilootpal@gmail.com","Nilu@310596","ZARA COAT 3"}, {"nilu@gmail.com","Nilu@310596","ADIDAS ORIGINAL"}};
//	}
	
	//Will use HashMap below so commented out the array method above
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "dnilootpal@gmail.com");
//		map.put("password", "Nilu@310596");
//		map.put("productName", "ZARA COAT 3");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "nilu@gmail.com");
//		map1.put("password", "Nilu@310596");
//		map1.put("productName", "ADIDAS ORIGINAL");
		
		//Will use JSON so commenting out above technique
		List<HashMap<String, String>> data= getJasonDataToHashMap("C:\\Users\\844714\\OneDrive - Cognizant\\eclipse-workspace\\SeleniumFrameworkDesign2\\src\\test\\java\\RahulShettyAcademy\\data\\PurchaseOrder.json");
		
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		System.out.println("Github practice");
		System.out.println("Github practice2");
		
		System.out.println("Github practice3");
		System.out.println("Github practice4");
		System.out.println("Github practice5");

		

	}
	
	

}
