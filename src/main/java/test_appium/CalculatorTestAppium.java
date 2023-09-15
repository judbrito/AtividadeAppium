package test_appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorTestAppium {

	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
		desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		WebElement el1 = (WebElement) driver.findElementByAccessibilityId("9");
		el1.click();
		WebElement el2 = (WebElement) driver.findElementByAccessibilityId("multiply");
		el2.click();
		WebElement el3 = (WebElement) driver.findElementByAccessibilityId("9");
		el3.click();
		WebElement el4 = (WebElement) driver.findElementByAccessibilityId("equals");
		el4.click();
		WebElement el5 = (WebElement) driver.findElementById("com.google.android.calculator:id/result_final");
		Assert.assertEquals("81", el5.getText());
		System.out.println("o valor é  " + el5.getText());
		driver.quit();
	}

}

	