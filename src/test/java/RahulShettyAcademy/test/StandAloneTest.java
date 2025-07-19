package RahulShettyAcademy.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import RahulShettyAcademy.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String productName= "ZARA COAT 3";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		
		//create object of Landing Page class for it to access the driver from StandAlone class
		LandingPage landingPage= new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("dnilootpal@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Nilu@310596");
		driver.findElement(By.id("login")).click();
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod=products.stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		//for loading icon class name is //ng-animating
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		//this small change makes it fast in execution
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1600)");
		
		//click on checkout button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));

		Thread.sleep(2000);

		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		//Thread.sleep(2000);
		//js.executeScript("window.scrollBy(0,1600)");

		//enter country in the auto suggestive dropdown
		Actions a= new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		//or we can type india without using actions
		//driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("India");

		//to select India from suggestive dropdown
		//css is= .ta-item:nth-of-type(2)
		//xpath is= (//button[contains(@class,'ta-item')])[2]
		
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

		//js.executeScript("window.scrollBy(0,1600)");

		driver.findElement(By.cssSelector(".action__submit")).click();
		
		//js.executeScript("window.scrollBy(0,-1600");

		
		String confirmMessage= driver.findElement(By.cssSelector("hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
		
		System.out.println("Git changes by GitX user");

	}

}
