package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.android.AndroidDriver;

//launches the WhatsApp native application in an Android Studio virtual device using Appium
//created by Jesse Penber 8-7-2018

public class AppiumWhatsApp {
	
	public static void main(String[] args) throws MalformedURLException {
		
		//create Android capabilities object
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		
		//set capabilities browser, platform, version, device name, package, and activity
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platform",Platform.ANDROID);
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","7.1.1");
		capabilities.setCapability("deviceName","Test Device");
		
		//set file path for WhatsApp .apk
		File file = new File("C:\\whatsapp.apk");
		Capabilities.setCapability("app", file.getAbsolutePath());
		
		//set server URL and driver
		URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");
		WebDriver driver = new AndroidDriver();
		driver = new AndroidDriver(serverURL, capabilities); 
		
	}

}