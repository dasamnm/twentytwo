package DriverClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverClass {

	WebDriver driver = null;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = new EdgeDriver();
	}
	
	public void close()
	{
		driver.close();
	}
	
	
}
