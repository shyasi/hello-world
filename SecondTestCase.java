package automationFramework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondTestCase {
	    WebDriver wd;

	    public void invokeBrowser() {
	        wd = new ChromeDriver();
	        wd.manage().deleteAllCookies();
	        wd.manage().window().fullscreen();
	        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        wd.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	        wd.get("www.google.com");    }

	    public static void main(String[] args) {
	        loginPage mlp = new loginPage();
	        mlp.invokeBrowser();    }
	}
}
