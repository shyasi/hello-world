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

public class solution2
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
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://demos.devexpress.com/ASPxGridViewDemos/PagingAndScrolling/Scrolling.aspx");
        Thread.sleep(2000);
        String expectedPage="12";
        String expectedColumnName="Ship City";
        selectHorizontalScrollBarMode(driver,"Auto");
        NavigateToPage(driver,expectedPage);
        Thread.sleep(4000);
        Actions ac=new Actions(driver);
        WebElement HeaderColumntable=driver.findElement(By.id("ContentHolder_Grid_DXHeaderTable"));
        int Columnindex=getColumnIndex(ac,HeaderColumntable,expectedColumnName);
        System.out.println(GetRowNoList(ac,driver,"London",Columnindex));
        driver.quit();

    }



    private static void selectHorizontalScrollBarMode(WebDriver driver,String strValue)throws InterruptedException {
        driver.findElement(By.xpath("//img[@id='ControlOptionsTopHolder_HorzScrollCombo_B-1Img']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//table[@id='ControlOptionsTopHolder_HorzScrollCombo_DDD_L_LBT']//td[.='"+strValue+"']")).click();
        Thread.sleep(5000);

    }
    private static int getColumnIndex(Actions ac,WebElement d,String columnname){
        List<WebElement> headers= d.findElements(By.xpath(".//tr[2]/td"));
        int i=0;
        for(WebElement e:headers){
            i++;
            ac.moveToElement(e.findElement(By.xpath(".//tr/td[1]"))).build().perform();
            if(columnname.equalsIgnoreCase(e.findElement(By.xpath(".//tr/td[1]")).getText().trim())){
               break;
            }
        }
        return i;
    }

    private static void NavigateToPage(WebDriver driver,String expectedPage)throws InterruptedException{
        boolean flag=true;
        while(flag){
        List<WebElement>pages=driver.findElements(By.xpath("//a[@class='dxp-num']"));
            for(WebElement page:pages) {
                if(expectedPage.equalsIgnoreCase(page.getText().trim())){
                    page.click();
                    flag=false;
                    break;
                }
            }
            if(flag) {
                driver.findElement(By.id("ContentHolder_Grid_DXPagerBottom_PBN")).click();
                Thread.sleep(5000);
            }

        }
    }
    private static ArrayList<Integer> GetRowNoList(Actions ac,WebDriver driver,String expectedCountry,int columnindex)throws InterruptedException{
        ArrayList<Integer> al = new ArrayList<Integer>();
        boolean flag=true;
            List<WebElement>rows=driver.findElements(By.xpath("//table[@id='ContentHolder_Grid_DXMainTable']//tr"));
            int i=0;
            for(WebElement row:rows) {
                i++;
                ac.moveToElement(row.findElement(By.xpath("./td["+columnindex+"]"))).build().perform();
                if(expectedCountry.equalsIgnoreCase(row.findElement(By.xpath("./td["+columnindex+"]")).getText().trim())){
                    al.add(i);
                }
            }
            return al;
    }
}
