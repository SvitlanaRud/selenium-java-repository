package ua.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class TestBase {

    public static WebDriver driver;
    public static WebDriverWait wait;



    @Before
    public void start(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void stop(){
        if(driver!=null)
            driver.quit();
    }

    public void loginToAdminPanel() {
        driver.navigate().to("http://localhost/litecard/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//img[@title='My Store']")));
      }

    public void navigateToLitecartShop(){
        driver.navigate().to("http://localhost/litecard/");
    }

    public boolean isElementPresent(By locator){
        try{
           driver.findElement(locator);
            return true;
        }catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean areElementsPresent(By locator){
        return driver.findElements(locator).size()>0;
    }
}
