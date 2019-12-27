package Helper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Helper {
	WebDriver driver;
	WebDriverWait wait;
	WebElement charge;
	List<WebElement> listElement;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public Helper(WebDriver driver) {
		this.driver = driver;
	}

	public void pauseImplicit(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void isElementClickable(By element, int time) {
		wait = new WebDriverWait(driver, time);
		charge = wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void isElementVisible(By element, int time) {
		wait = new WebDriverWait(driver, time);
		charge = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public void listElementVisible(List<WebElement> element, int time) {
		wait = new WebDriverWait(driver, time);
		listElement = wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public boolean noSuchElement(By element) {
		try {
			driver.findElement(element);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void scrolTo(By element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void selectDropdownOptionByText(By element, String option, int t) {
		isElementClickable(element, 5);
		Select select = new Select(driver.findElement(element));
		select.selectByVisibleText(option);
	}
}
