package test_appium;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import core.Dsl;
import io.appium.java_client.MobileBy;

public class FormularioTest {
	Dsl dsl = new Dsl();

	@Before
	public void inicializarAppium() {
		getDriver();
		getDriver().findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	}

	@After
	public void tearDown() {
		killDriver();
	}

	@Test
	public void preencherCampoTexto() throws MalformedURLException {

		dsl.escrever(MobileBy.className("android.widget.EditText"), "Brito");
		String texto = dsl.obterTexto(MobileBy.className("android.widget.EditText"));
		Assert.assertEquals("Brito", texto);
		System.out.println("Nome digitado é " + texto);
	}

	@Test
	public void deveInteragirCombo() {
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "PS4");
		String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		Assert.assertEquals("PS4", text);

	}

	@Test
	public void deveInteragirSwichtCheckbox() {
		dsl.clickElement(By.className("android.widget.CheckBox"));
		dsl.clickElement(MobileBy.AccessibilityId("switch"));
		Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

	}

	@Test

	public void deveRealizarCadastro() {
		dsl.clicarPorTexto("Formulário");
		dsl.escrever(By.className("android.widget.EditText"), "digitei algo");
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
		dsl.clickElement(By.className("android.widget.CheckBox"));
		dsl.clickElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"ON\")"));
		dsl.clicarPorTexto("SALVAR");

		String elementText = dsl.obterTexto(By.className("android.widget.EditText"));
		Assert.assertEquals("digitei algo", elementText);

		String elementText1 = dsl.obterTexto(MobileBy.xpath("//android.widget.TextView[@text='Nintendo Switch']"));
		Assert.assertEquals("Nintendo Switch", elementText1);

		String elementText2 = dsl.obterTexto(MobileBy.xpath("//android.widget.TextView[@text='Slider: 25']"));
		Assert.assertEquals("Slider: 25", elementText2);

		String elementText3 = dsl.obterTexto(MobileBy.xpath("//android.widget.TextView[@text='Switch: Off']"));
		Assert.assertEquals("Switch: Off", elementText3);

		String elementText4 = dsl.obterTexto(MobileBy.xpath("//android.widget.TextView[@text='Checkbox: Marcado']"));
		Assert.assertEquals("Checkbox: Marcado", elementText4);

		String elementText5 = dsl.obterTexto(MobileBy.xpath("//android.widget.TextView[@text='Data: 01/01/2000']"));
		Assert.assertEquals("Data: 01/01/2000", elementText5);

		String elementText6 = dsl.obterTexto(MobileBy.xpath("//android.widget.TextView[@text='Hora: 12:00']"));
		Assert.assertEquals("Hora: 12:00", elementText6);

	}
}