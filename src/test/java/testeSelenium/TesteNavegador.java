package testeSelenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class TesteNavegador {

	static WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Alberto\\DL\\Webdriver\\bin\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		driver.get("https://portal.ifpe.edu.br/campus/garanhuns");

	}

}
