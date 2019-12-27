package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Helper.Helper;

public class ResultsExpedia extends Helper {
	private WebDriver driver;
	private List<WebElement> prices;
	
	// ## Locators
	private By resultsList = By.cssSelector(".bColumn .full-bold");
	private By results = By.cssSelector(".bColumn");
	private By ordenarDropdown = By.cssSelector("#sortDropdown");
	// ## Locators

	// ## Constructor
	public ResultsExpedia(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	// ## Constructor

	// ## Public Method
	/// <summary>
	/// Obtener la lista de precios invertida
	/// </summary>
	public String obtenerResultadosMayorMenor() {
		isElementClickable(resultsList, 15);
		ArrayList<String> obtainedList = new ArrayList<>();
		prices = driver.findElements(resultsList);
		for (WebElement we : prices) {
			obtainedList.add(we.getText());
		}
		Collections.reverse(obtainedList);
		return obtainedList.toString();
	}

	/// <summary>
	/// Obtener la lista de precios actual
	/// </summary>
	public String obtenerResultadoActual() {
		isElementClickable(resultsList, 15);
		isElementVisible(results, 10);
		pauseImplicit(10);
		ArrayList<String> obtainedList = new ArrayList<>();
		prices = driver.findElements(resultsList);
		for (WebElement we : prices) {
			obtainedList.add(we.getText());
		}
		return obtainedList.toString();
	}

	/// <summary>
	/// Seleccionar opcion del dropdown por texto para ordenar de mayor a menor
	/// </summary>
	public void selectOrdenarMayorMenor() {
		selectDropdownOptionByText(ordenarDropdown, "Precio (mayor)", 10);
	}
	// ## Public Method
}
