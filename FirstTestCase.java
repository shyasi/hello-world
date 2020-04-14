package automationFramework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      WebDriver driver = new FirefoxDriver();
      String URL = "www.google.com";
      driver.get(URL);
      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      System.out.println("Website is opened successfully");
      driver.close();
	}
}