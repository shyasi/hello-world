import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.List;
import  java.util.*;
import java.util.concurrent.TimeUnit;

public class solution1
{
    public static void main(String[] args) throws InterruptedException {
         WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pmgi\\MyDev\\MyGit\\Pod\\Hybris_Lubs_QA\\test\\jars\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--test-type");
        options.addArguments("--disable-extensions"); // to disable browser extension popup
        options.setAcceptInsecureCerts(true);
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("disable-popup-blocking");
        options.addArguments("test-type");
        options.addArguments("disable-redirect-blocking");
        options.setCapability("applicationCacheEnabled", false);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);


        driver.get("https://demos.devexpress.com/ASPxNavigationAndLayoutDemos/TabControl/TabScrolling.aspx");
        navigateLeft(driver);
        navigateRight(driver);
        
        System.out.println "Testing Github";

    }
    private static void navigateLeft(WebDriver driver)throws InterruptedException {
        for(int i=1;i<7;i++) {
            WebElement leftElement = driver.findElement(By.xpath("//img[@id='ContentHolder_ASPxPageControl1_SBLImg']"));
            String strValue = leftElement.findElement(By.xpath("./..")).getAttribute("class");
            if (strValue.endsWith("Disabled")) {
                break;
            } else {
                leftElement.click();
                Thread.sleep(2000);
            }
        }

    }
    private static void navigateRight(WebDriver driver)throws InterruptedException {
        for(int i=1;i<7;i++) {
            WebElement rightElement=driver.findElement(By.xpath("//img[@id='ContentHolder_ASPxPageControl1_SBRImg']"));
            String strValue = rightElement.findElement(By.xpath("./..")).getAttribute("class");
            if (strValue.endsWith("Disabled")) {
                break;
            } else {
                rightElement.click();
                Thread.sleep(2000);
            }
        }

    }
}
