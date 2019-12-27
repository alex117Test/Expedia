package pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Helper.Helper;

public class HomeExpedia extends Helper {
	
private WebDriver driver;
	
	// ## Locators
	private By vuelos = By.cssSelector("#tab-flight-tab-hp");
	private By vueloOrigen = By.cssSelector("#flight-origin-hp-flight");
	private By opcionesVuelos = By.cssSelector("#typeaheadDataPlain");
	private By vueloDestino = By.cssSelector("#flight-destination-hp-flight");
	private By buscarVuelos = By.cssSelector("#gcw-flights-form-hp-flight .btn-primary");
	private By fechaSalida = By.cssSelector("input#flight-departing-hp-flight");
	private By fechaRegreso = By.cssSelector("input#flight-returning-hp-flight");
	private By diasDisponiblesCalendario = By.cssSelector(".datepicker-cal .datepicker-cal-date:not([class*='disabled'])");
	private By calendario = By.cssSelector(".datepicker-cal");
	private By siguienteMes = By.cssSelector(".datepicker-cal .next");
	// ## Locators
	
	// ## Constructor
	public HomeExpedia(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	// ## Constructor

	// ## Metodos Publicos
	/// <summary>
    /// Seleccionar la opcion Volar 
    /// </summary>
	public void clickVolarTab() {
		isElementClickable(vuelos, 5);
		driver.findElement(vuelos).click();
	}

	/// <summary>
    /// Ingresar vuelo de origen 
    /// </summary>
	public void ingresarVueloOrigen(String vuelo) {
		isElementVisible(vueloOrigen, 5);
		driver.findElement(vueloOrigen).sendKeys(vuelo);
		seleccionarOpcionVuelo();
	}
	
	/// <summary>
    /// Ingresar vuelo de destino 
    /// </summary>
	public void ingresarVueloDestino(String vuelo) {
		isElementClickable(vueloDestino, 5);
		driver.findElement(vueloDestino).sendKeys(vuelo);
		seleccionarOpcionVuelo();
	}
	
	/// <summary>
    /// Seleccionar la opcion de vuelo de la lista desplegable 
    /// </summary>
	public void seleccionarOpcionVuelo() {
		isElementClickable(opcionesVuelos, 6);
		driver.findElement(vueloOrigen).sendKeys(Keys.ENTER);
	}
	
	/// <summary>
    /// Click en el boton buscar 
    /// </summary>
	public ResultsExpedia clickBuscarVuelos() {
		isElementClickable(buscarVuelos, 6);
		driver.findElement(buscarVuelos).click();
		ResultsExpedia results = new ResultsExpedia(driver);
		return results;
	}
	
	/// <summary>
    /// Click en el campo fecha de salida 
    /// </summary>
	public void ingresarFechaSalida() {
		isElementClickable(fechaSalida, 5);
		driver.findElement(fechaSalida).click();
		seleccionarDiaAleatorio();
	}
	
	/// <summary>
    /// Click en el campo fecha de regreso 
    /// </summary>
	public void ingresarFechaRegreso() {
		isElementClickable(fechaRegreso,5);
		driver.findElement(fechaRegreso).click();
		clickSiguienteMes();
		seleccionarDiaAleatorio();
	}
	
	/// <summary>
    /// Seleccionar una fecha de salia disponible de manera aleatoria 
    /// </summary>
	public void seleccionarDiaAleatorio() {
		 isElementClickable(calendario, 5);
		 List<WebElement> dias = driver.findElements(diasDisponiblesCalendario);
		 Random rand = new Random();
		 int randomProduct = rand.nextInt(dias.size());
		 dias.get(randomProduct).click();
	}
	
	/// <summary>
    /// Click en la fecha para mostrar el siguiente mes 
    /// </summary>
	public void clickSiguienteMes() {
		isElementClickable(siguienteMes, 5);
		driver.findElement(siguienteMes).click();
	}
	// ## Metodos Publicos
}
