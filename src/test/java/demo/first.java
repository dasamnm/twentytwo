package demo;

import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class first {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://google.com");
		
		
		FluentWait<WebDriver> wait = new FluentWait<>(driver);
		wait.withTimeout(Duration.ofSeconds(10))
		.pollingEvery(Duration.ofMillis(250))
		.withMessage("Alert is not present")
		.ignoring(NoAlertPresentException.class)
		;
		
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert();
		
	}
}