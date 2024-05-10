import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.en.Then;

public class LamdaTestAssignment {
	
	
	WebDriver driver;
	public void Initialisation() throws MalformedURLException
	{
		FirefoxOptions browserOptions2 = new FirefoxOptions();
		browserOptions2.setPlatformName("Windows 11");
		browserOptions2.setBrowserVersion("125");
		HashMap<String, Object> ltOptions2 = new HashMap<String, Object>();
		ltOptions2.put("username", "sayorchatterjee003");
		ltOptions2.put("accessKey", "VClZnuxzyUEN48ynTbM8zviH5EWxbUjN0CzdO1eEgiljZtuiaj");
		ltOptions2.put("visual", true);
		ltOptions2.put("video", true);
		ltOptions2.put("build", "Selenium101");
		ltOptions2.put("project", "Trial");
		ltOptions2.put("name", "Selenium101Assignment");
		ltOptions2.put("w3c", true);
		browserOptions2.setCapability("LT:Options", ltOptions2);
		
		driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions2);
	}
	

	@BeforeMethod
	public void getURL() throws MalformedURLException {
		Initialisation();
		String siteurl = "https://www.lambdatest.com/selenium-playground";
		driver.manage().window().maximize();
		driver.get(siteurl);
	}
	@Test
	public void senario1() throws MalformedURLException {
		
		driver.findElement(By.linkText("Simple Form Demo")).click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.lambdatest.com/selenium-playground/simple-form-demo");
		driver.findElement(By.id("user-message")).sendKeys("Welcome to LambdaTest");
		driver.findElement(By.id("showInput")).click();
		//throw new io.cucumber.java.PendingException();
    	Assert.assertEquals("Welcome to LambdaTest", driver.findElement(By.id("message")).getText());
		driver.close();
	}
	@Test
	public void senario2() throws MalformedURLException {
		//driver.manage().window().maximize();
		//driver.get(siteurl);
		driver.findElement(By.linkText("Drag & Drop Sliders")).click();
		for(int i = 0; i<80; i++ )
		{
			driver.findElement(By.xpath("//*[@id=\"slider3\"]/div/input")).sendKeys(Keys.ARROW_RIGHT);
		}
		Assert.assertEquals("95", driver.findElement(By.id("rangeSuccess")).getText());
		Assert.assertEquals("95", driver.findElement(By.id("rangeSuccess")).getText());
		driver.close();
	}
	@Test
	public void senario3() throws InterruptedException {
		
		driver.findElement(By.linkText("Input Form Submit")).click();
		driver.findElement(By.xpath("//*[@id=\"seleniumform\"]/div[6]/button")).click();
		WebElement username = driver.findElement(By.id("name"));    
		String validationMessage = username.getAttribute("validationMessage");
		Assert.assertEquals(validationMessage, "Please fill out this field.");
		driver.findElement(By.id("name")).sendKeys("Sayor Chatterjee");
		Thread.sleep(2000);
		driver.findElement(By.id("inputEmail4")).sendKeys("sayorchatterjee03@gmail.com");
		driver.findElement(By.id("inputPassword4")).sendKeys("sayor@123");
		driver.findElement(By.id("company")).sendKeys("cognizant");
		driver.findElement(By.id("websitename")).sendKeys("cognizant.com");
		WebElement d = driver.findElement(By.name("country"));
		Select s = new Select(d);
		s.selectByVisibleText("United States");
		driver.findElement(By.id("inputCity")).sendKeys("New York");
		driver.findElement(By.id("inputAddress1")).sendKeys("P 209");
		driver.findElement(By.id("inputAddress2")).sendKeys("New York");
		driver.findElement(By.id("inputState")).sendKeys("New York");
		driver.findElement(By.id("inputZip")).sendKeys("700054");
		driver.findElement(By.xpath("//*[@id=\"seleniumform\"]/div[6]/button")).click();
		Assert.assertEquals("Thanks for contacting us, we will get back to you shortly.", driver.findElement(By.className("success-msg")).getText());
        driver.close();
        
        
	}

}
