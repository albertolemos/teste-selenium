package testeSelenium;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class TestSiteBTGPactual {

	static WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Alberto\\DL\\Webdriver\\bin\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		driver.manage().window().maximize();
		driver.get("https://www.btgpactualdigital.com/");
		driver.findElement(By.id("btn-open-account-header")).click();
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		// Preenchimento campo Nome
		driver.findElement(By.id("mat-input-0")).sendKeys("Fernando Lemos");

		// Preenchimento campo CPF
		driver.findElement(By.id("mat-input-1")).sendKeys("46251702060");

		// Preenchimento campo Celular
		driver.findElement(By.id("mat-input-2")).sendKeys("81999787931");

		// Preenchimento campo E-mail
		driver.findElement(By.id("mat-input-3")).sendKeys("fernando@googlemail.com");

		// Preenchimento campo Data de nascimento
		driver.findElement(By.id("mat-input-4")).sendKeys("25071984");

		// Preenchimento campo Senha
		driver.findElement(By.id("mat-input-5")).sendKeys("150710");

		// Preenchimento campo Confirmação de senha
		driver.findElement(By.id("mat-input-6")).sendKeys("150710");

		if (driver.findElement(By.cssSelector("#mat-checkbox-2-input")).isSelected())

			driver.findElement(By.cssSelector("#mat-checkbox-2 .mat-checkbox-inner-container")).click();

		// Verifica se aparece mensagem de erro no CPF
		assertTrue(driver.findElement(By.id("mat-error-1")).isDisplayed());

		// Verifica se o botão COMEÇAR está habilitado
		assertFalse(driver.findElement(By.id("btn-begin")).isEnabled());

		// Verifica se a mensagem do CPF é "CPF inválido!"
		assertEquals("CPF inválido!", driver.findElement(By.id("mat-error-1")).getText());
	}

}
