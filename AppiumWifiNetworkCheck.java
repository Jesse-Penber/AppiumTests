package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

//prints the name of the WiFi network an Android device is accessing
//created by Jesse Penber, 8-16-2018

public class AppiumWifiNetworkCheck {
	
	public static void main(String[] args) throws MalformedURLException {
		
		//set capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platform",Platform.ANDROID);
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","7.1.1");
		capabilities.setCapability("deviceName","Test Device");
		capabilities.setCapability("app", "C:\\Appium\\node_modules\\appium\\build\\unlock_apk\\unlock_apk-debug.apk");
		
		//create Appium server and driver variables
		URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(serverURL, capabilities); 

		//navigate to Android home, click Settings, click Wifi button to turn on
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		driver.findElementByAndroidUIAutomator("new UISelector().text(\"Settings\")").click();
		driver.findElementByAndroidUIAutomator("new UISelector().textContains(\"Wi\").textContains(\"Fi\")").click();
		
		//identify and print Wifi SSID (network name)
		String SSID = driver.findElementsByXPath("//android.widget.TextView[@text=\"Connected\"]/predeceding::android.widget.TextView[1]"].getAttribute(name));
		if (SSID != "") {
		System.out.println("Connected to: " + SSID);
	} else {
		System.out.println("This device is not connected to wifi.");
		}
	}
}
