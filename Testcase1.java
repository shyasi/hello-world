package seautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testcase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","C:/Kavita/Selenium/gecko/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
	    driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
	    System.out.println("Website is opened successfully");
	     //driver.close();
	}
}