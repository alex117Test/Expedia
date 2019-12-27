package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomeExpedia;
import pages.ResultsExpedia;
import selenium.DriverSetup;

public class ExpediaTest {
	private WebDriver driver;

	@BeforeClass
	public void setupTest() {
		WebDriver driver = DriverSetup.setupDriver(DriverSetup.Browser.Chrome, "chromedriver");
		this.driver = driver;
		driver.get("https://www.expedia.mx/");
	}

	@Test(priority = 0, dataProvider = "busquedaExpedia")
	public void Expedia(String vueloOrigen, String vueloDestino) throws InterruptedException {
		// ## Step 1. Given I am an Expedia user
		HomeExpedia home = new HomeExpedia(driver);
		// ## Step 2. And I select the tab 'Flights'
		home.clickVolarTab();
		// ## Step 3. And I enter a valid 'Flying from'
		home.ingresarVueloOrigen(vueloOrigen);
		// ## Step 4. And I enter a valid 'Flying to'
		home.ingresarVueloDestino(vueloDestino);
		// ## Step 5. And I select a valid random 'Departing Date'
		home.ingresarFechaSalida();
		// ## Step 6. And I select a valid random 'Returning Date'
		home.ingresarFechaRegreso();
		// ## Step 7. And I select the Search button
		// ## - The user is redirected to the search results page
		ResultsExpedia results = home.clickBuscarVuelos();
		String resultadoEsperado = results.obtenerResultadosMayorMenor();
		// ## Step 8. When I sort the list of elements by the Price (Highest)
		results.selectOrdenarMayorMenor();
		// ## Step 9. The list of prices are sorted as Highest to Lowest
		Assert.assertEquals("La lista de resultados no esta ordenada de mayor a menor", resultadoEsperado,
				results.obtenerResultadoActual());
	}

	@DataProvider(name = "busquedaExpedia")
	public Object[][] getData() {
		Object[][] testData = new Object[][] { { "Guadalajara Jalisco", "Los Angeles" } };
		return testData;
	}

	@AfterClass
	public void tearDownClass() {
		driver.quit();
	}
}
