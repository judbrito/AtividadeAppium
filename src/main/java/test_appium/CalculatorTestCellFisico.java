package test_appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorTestCellFisico {

	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "caju");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		desiredCapabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		WebElement el1 = (WebElement) driver.findElementByAccessibilityId("5");
		el1.click();
		WebElement el2 = (WebElement) driver.findElementByAccessibilityId("Multiplicação");
		el2.click();
		WebElement el3 = (WebElement) driver.findElementByAccessibilityId("9");
		el3.click();
		WebElement el4 = (WebElement) driver.findElementByAccessibilityId("Igual");
		el4.click();
		WebElement el5 = (WebElement) driver.findElementById("com.sec.android.app.popupcalculator:id/calc_edt_formula");

		System.out.println("o valor é  " + el5.getText());
		driver.quit();
	}

}
