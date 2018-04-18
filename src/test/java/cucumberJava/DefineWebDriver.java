/**
 * 
 */
package cucumberJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Rogers Nyunja
 * DefineWebDriver allows user to manage different WebDrivers
 *
 */
public class DefineWebDriver {
	WebDriver driver = null;

	/**
	 * A WebDriver will be set depending on the browser parsed
	 * @param driver
	 * 
	 */
	public void openBrowser(String browser) {
		
		try {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\ncr_r\\GeckoDriver\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.get("http://seleniumhq.com");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
