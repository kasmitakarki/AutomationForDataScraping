package church.Global;

import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class churchCommon 
{
	protected static WebDriver driver;
	protected WebDriverWait wait;
	

	
	public churchCommon() 
	{
		if(driver==null) 
		{
			System.setProperty("webdriver.chrome.driver","C:\\selenium\\Drivers\\chromedriver.exe" );
			driver= new ChromeDriver();
			wait= new WebDriverWait(driver, Duration.ofSeconds(60));
			driver.manage().window().maximize();
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public WebDriverWait getWait() {
		return wait;
	}
	
	public void openbroser() {
		driver.get("https://www.upward.org/");
	}
	
	public void verifyTitle(String title) {
		if(driver.getTitle().equals(title))
		{
			System.out.println(title+" displayed" );
		}
		else
		{
			System.out.println("Failed to display "+title );
			return;
		} 	
	}
	
	public WebElement findElement(String identifier, String locatior) 
	{
		WebElement e=null;
		switch(identifier) 
		{
		case "id":
			e= driver.findElement(By.id(locatior));
			break;
		case "className":
			e= driver.findElement(By.className(locatior));
			break;
		case "cssSelector":
			e= driver.findElement(By.cssSelector(locatior));
			break;
		case "linkText":
			e= driver.findElement(By.linkText(locatior));
			break;
		case "name":
			e= driver.findElement(By.name(locatior));
			break;
		case "partialLinkText":
			e= driver.findElement(By.partialLinkText(locatior));
			break;
		case "tagName":
			e= driver.findElement(By.tagName(locatior));
			break;
		case "xpath":
			e= driver.findElement(By.xpath(locatior));
			break;
		
		default:
			System.out.println("Not found");
			e=null;
		}
		return e;
	}
	
	public void clickElement(String identifier, String locator) {
		WebElement e= findElement( identifier,  locator);
		e.click();
	}
	
	public void clearElement(String identifier, String locator) {
		WebElement e= findElement( identifier,  locator);
		e.clear();;
	}
	
	public void sendKeyToElement(String identifier, String locator, String content) {
		WebElement e= findElement( identifier,  locator);
		e.sendKeys(content);;
	}

	
}
