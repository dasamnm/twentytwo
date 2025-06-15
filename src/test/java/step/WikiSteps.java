package step;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import DriverClass.DriverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WikiSteps {
	DriverClass driverClass = new DriverClass();
	WebDriver driver = null;

	@Given("i am on wikipedia page")
	public void i_am_on_wikipedia_page() {
		driverClass.setDriver(driver);
		driver = driverClass.getDriver();
		driver.manage().window().maximize();

		driver.get("https://en.wikipedia.org/wiki/Main_Page");

	}

	@When("i enter text in searchbox")
	public void i_enter_text_in_searchbox() {
		driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys("pop");

	}

	@When("click on search button")
	public void click_on_search_button() {
		driver.findElement(By.xpath(
				"(//button[contains(@class, 'cdx-button') and contains(@class, 'cdx-search-input__end-button')])[1]"))
				.sendKeys(Keys.ENTER);

	}

	@Then("results should be displayed")
	public void results_should_be_displayed() {

		String actualText = driver.findElement(By.xpath("(//span[@class='mw-page-title-main'])[1]")).getText();
		String expectedText = "Pop";

		Assert.assertEquals(expectedText, actualText);
		driverClass.close();
	}

}
