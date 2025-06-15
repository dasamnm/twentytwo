package step;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverClass.DriverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {

	WebDriver driver = null;
	WebDriverWait wait = null;
	DriverClass driverClass = new DriverClass();

	@Given("user is on DuckDuckGo home page")
	public void user_is_on_google_home_page() {
		driverClass.setDriver(driver);
		driver = driverClass.getDriver();
		driver.get("https://duckduckgo.com/");

	}

	@When("user enters {string}")
	public void user_enters(String string) {
		driver.findElement(By.id("searchbox_input")).sendKeys(string);

	}

	@When("clicks on search button")
	public void clicks_on_search_button() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Search']")));
		driver.findElement(By.xpath("//button[@aria-label='Search']")).click();

	}

	@Then("search results should be displayed")
	public void search_results_should_be_displayed() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@data-testid='spelling-message']/p)[1]")));
		String text = driver.findElement(By.xpath("(//div[@data-testid='spelling-message']/p/a)[1]")).getText();
		String actualText = driver.findElement(By.xpath("(//div[@data-testid='spelling-message']/p)[1]")).getText();
		String expectedText = "Including results for Hello World";

		Assert.assertEquals(actualText, expectedText);
		driverClass.close();
	}

	@Then("java results should be displayed")
	public void java_results_should_be_displayed() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[text()='Java'])[1]")));
		String actualText = driver.findElement(By.xpath("(//p[text()='Java'])[1]")).getText();
		String expectedText = "Java";
		Assert.assertEquals(expectedText, actualText);
		driverClass.close();
	}

	

}