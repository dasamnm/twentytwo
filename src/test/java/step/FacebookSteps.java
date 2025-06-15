package step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverClass.DriverClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookSteps {
	DriverClass driverClass = new DriverClass();
	WebDriver driver = null;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		driverClass.setDriver(driver);
		driver = driverClass.getDriver();
		driver.get("https://www.facebook.com/");
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		System.out.println(username);
		driver.findElement(By.id("email")).sendKeys(username);
	}

	@When("password {string}")
	public void password(String password) {
		System.out.println(password);
		driver.findElement(By.id("pass")).sendKeys(password);
	}

	@And("clicks on login button")
	public void clicks_login_button()
	{
		driver.findElement(By.name("login")).submit();
	}
	@Then("profile page should be displayed")
	public void profile_page_should_be_displayed() {
		driverClass.close();
	}

	@Then("{string} error message should be displayed")
	public void error_message_should_be_displayed(String errorMsg) {
		
		String actualText = driver.findElement(By.cssSelector("._9ay7")).getText();
		System.out.println(actualText);
		driverClass.close();
	}
}
