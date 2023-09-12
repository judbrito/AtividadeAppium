package test_appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Desafio {
	@Test
	public void automacaoUsandoInpector() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:deviceName", "ctAppium");
		desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
		desiredCapabilities.setCapability("appium:appPackage", "com.ctappium");
		desiredCapabilities.setCapability("appium:appActivity", "com.ctappium.MainActivity");
		desiredCapabilities.setCapability("platformName", "Android");
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement el1 = (WebElement) driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView");
		el1.click();
		WebElement el2 = driver.findElementByAccessibilityId("nome");
		el2.sendKeys("VAI TROXA");
		WebElement el3 = driver.findElementByAccessibilityId("console");
		el3.click();
		WebElement el4 = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]");
		el4.click();
		WebElement el5 = driver.findElementByAccessibilityId("switch");
		el5.click();
		WebElement el6 = driver.findElementByAccessibilityId("check");
		el6.click();
		WebElement el7 = driver
				.findElementByXPath("//android.widget.Button[@content-desc=\"save\"]/android.widget.TextView");
		el7.click();
		WebElement el8 = driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button[2]/android.widget.TextView");
		el8.click();

		driver.quit();

	}

	@Test
	public void usandoUiautomatorSelector() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:deviceName", "ctAppium");
		desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
		desiredCapabilities.setCapability("appium:appPackage", "com.ctappium");
		desiredCapabilities.setCapability("appium:appActivity", "com.ctappium.MainActivity");
		desiredCapabilities.setCapability("platformName", "Android");
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByXPath("//android.widget.TextView[@text='Formulário']").click();
		driver.findElementByAccessibilityId("nome").sendKeys("digitei algo aqui");
		driver.findElementByClassName("android.widget.Spinner").click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"ON\")")).click();
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='SALVAR']")).click();
		MobileElement elementText = driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='Nome: digitei algo aqui']"));
		Assert.assertEquals("Nome: digitei algo aqui", elementText.getText());

		MobileElement elementText1 = driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='Console: switch']"));
		Assert.assertEquals("Console: switch", elementText1.getText());

		MobileElement elementText2 = driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='Slider: 25']"));
		Assert.assertEquals("Slider: 25", elementText2.getText());

		MobileElement elementText3 = driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='Switch: Off']"));
		Assert.assertEquals("Switch: Off", elementText3.getText());

		MobileElement elementText4 = driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='Checkbox: Marcado']"));
		Assert.assertEquals("Checkbox: Marcado", elementText4.getText());

		MobileElement elementText5 = driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='Data: 01/01/2000']"));
		Assert.assertEquals("Data: 01/01/2000", elementText5.getText());

		MobileElement elementText6 = driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='Hora: 12:00']"));
		Assert.assertEquals("Hora: 12:00", elementText6.getText());

		MobileElement elementText7 = driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='Nome: digitei algo aqui']"));
		Assert.assertEquals("Nome: digitei algo aqui", elementText7.getText());

		driver.quit();

	}
}
