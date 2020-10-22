package testeSelenium;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class AvaliacaoTesteSoftware {

	static WebDriver driver;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Alberto\\DL\\Webdriver\\bin\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
		driver.get("https://loja.canaltech.com.br/cadastro");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// Verifica se aparece mensagem de erro ao deixar o campo Nome em branco
	@Test
	void testNomeVazio() {
		driver.findElement(By.linkText("Pessoa Física")).click();
		this.nomeCompleto("");
		this.dataNascimento("15072010");
		this.cpf("46251702060");
		this.telefoneFixo("8737611124");
		this.celular("81999787931");
		this.email("alberto@g.com");
		this.repetirEmail("alberto@g.com");
		this.senha("1234");
		this.repetirSenha("1234");
		driver.findElement(By.cssSelector(".botao-commerce-img")).click();
		assertEquals("Digite o seu nome completo, por favor.",
				driver.findElement(By.id("pf_nome_cliente_erro")).getText());
	}

	// Verifica se a mensagem de CPF inválido é apresentada ao colocar o cpf com
	// menos de 11 dígitos
	@Test
	void testCpfIncompleto() {
		driver.findElement(By.linkText("Pessoa Física")).click();
		this.nomeCompleto("Fernando Lima");
		this.dataNascimento("15072010");
		this.cpf("219480710");
		this.telefoneFixo("8737611124");
		this.celular("81999787932");
		this.email("fernando@gmail.com");
		this.repetirEmail("fernando@gmail.com");
		this.senha("1234");
		this.repetirSenha("1234");
		driver.findElement(By.cssSelector(".botao-commerce-img")).click();
		assertEquals("CPF inválido! Por favor, digite um número válido.",
				driver.findElement(By.id("pf_cpf_cliente_erro")).getText());
	}

	// Verifica se a caixa "Desejo receber e-mails promocionais" está selecionada,
	// caso esteja, desmarca. Verifica também se a mensagem de erro é mostrada ao
	// colocar senhas diferentes nos campos senha e repetir senha
	@Test
	void testCaixaSelecionada() {
		driver.findElement(By.linkText("Pessoa Física")).click();
		this.nomeCompleto("Islame Rogéria");
		this.dataNascimento("");
		this.cpf("83069543006");
		this.telefoneFixo("8134537931");
		this.celular("81999787931");
		this.email("islame@g.com");
		this.repetirEmail("islame@g.com");
		this.senha("123123123");
		this.repetirSenha("123123");
		if (driver.findElement(By.id("email")).isSelected())
			driver.findElement(By.id("email")).click();
		assertEquals("Sua senha está diferente da confirmação. Por favor, digite-as novamente.",
				driver.findElement(By.id("senha_cliente2_erro")).getText());	
	}

	void nomeCompleto(String nomeCompleto) {
		driver.findElement(By.id("pf_nome_cliente")).sendKeys(nomeCompleto);
	}

	void dataNascimento(String dataNasc) {
		driver.findElement(By.id("pf_data_nascimento")).sendKeys(dataNasc);
	}

	void cpf(String cpf) {
		driver.findElement(By.id("pf_cpf_cliente")).sendKeys(cpf);
	}

	void telefoneFixo(String telFixo) {
		driver.findElement(By.id("telefone_cliente")).sendKeys(telFixo);
	}

	void celular(String telDois) {
		driver.findElement(By.id("telefone_cliente_2")).sendKeys(telDois);
	}

	void email(String email) {
		driver.findElement(By.id("email_cliente")).sendKeys(email);
	}

	void repetirEmail(String repetirEmail) {
		driver.findElement(By.id("email_cliente2")).sendKeys(repetirEmail);
	}

	void senha(String senha) {
		driver.findElement(By.id("senha_cliente")).sendKeys(senha);
	}

	void repetirSenha(String senha) {
		driver.findElement(By.id("senha_cliente2")).sendKeys(senha);
	}

}
