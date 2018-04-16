/**
 * 
 */
package cucumberJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author Rogers Nyunja
 *
 */
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class WebDriverBase {

  static protected WebDriver driver;

  public static void setup() {

    ChromeDriverManager.getInstance().setup();
    ChromeOptions chromeOptions = new ChromeOptions();

    chromeOptions.addArguments("--headless");
    driver = new ChromeDriver(chromeOptions);
  }

  public static void main(String[] args) {
    WebDriverBase.setup();
    driver.get("https://www.testingexcellence.com");
  }
}
