package step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import DriverClass.DriverClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	WebDriver driver = null;
	DriverClass driverClass = null;

	@After
	public void afterScenario() {

	}

}
