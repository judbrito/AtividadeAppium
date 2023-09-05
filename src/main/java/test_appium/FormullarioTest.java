package test_appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormullarioTest {

	@Test

	public void preencherCampoTexto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\JudrianideBrito\\PROJETO BRITO\\AulaAppium\\src\\main\\resources\\CTAppium_2_0.apk");
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<MobileElement> elementoEncontrado = driver.findElements(By.className("android.widget.TextView"));
		
		for (MobileElement elemento : elementoEncontrado) {
			System.out.println(elemento.getText());
		}
		
		elementoEncontrado.get(1).click();
		
		WebElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Brito");
		
		String text = campoNome.getText();
		
		Assert.assertEquals("Brito", text);
		System.out.println("Nome digitado é "+text);
		
		 driver.quit();
	}
}
