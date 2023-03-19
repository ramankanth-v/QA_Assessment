package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.CommonUtils;

import java.time.Duration;

public class DriverFactory {
	
	static WebDriver driver = null;
	
	public static WebDriver initializeBrowser(String browserName) {

		switch (browserName) {

			case "chrome":
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);
			break;
			
			case "firefox":
			driver = new FirefoxDriver();
			break;


			case "edge" :
			driver = new EdgeDriver();
			break;


			case "safari":
			driver = new SafariDriver();
			break;
		}



		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		
		return driver;
		
	}
	
	public static WebDriver getDriver() {
		
		return driver;
		
	}

}
