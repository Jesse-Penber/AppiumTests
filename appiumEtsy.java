package test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

// logs into Etsy web app in Chrome, using Appium and Android Studio virtual device
// created by Jesse Penber, 8-7-2018

public class AppiumEtsyLogin {
	
	public void test() throws MalformedURLException {
	//create Android capabilities object
	DesiredCapabilities capabilities = DesiredCapabilities.android();
	
	//set capabilities browse, platform, android version, and device name
	capabilities.setCapability("browserName",BrowserType.CHROME);
	capabilities.setCapability("platform",Platform.ANDROID);
	capabilities.setCapability("platformName","Android");
	capabilities.setCapability("platformVersion","7.1.1");
	capabilities.setCapability("deviceName","Test Device");
	
	//create Appium server object 
	URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");
	
	//create Android driver object
	WebDriver driver = new RemoteWebDriver(serverURL, capabilities); 
	
	//Open Etsy in Chrome and log in
	driver.navigate().to("https://www.etsy.com");
	driver.findElement(By.cssSelector("#sign-in")).click();
	driver.findElement(By.cssSelector("#username-existing")).sendKeys("penberelf46@gmail.com");
	driver.findElement(By.cssSelector("#password-existing")).sendKeys("test12");
	driver.findElement(By.cssSelector("#signin-button")).click();
	}
	
	//exit test
	//driver.quit();
}