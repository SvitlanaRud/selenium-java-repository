package ua.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

public class BrowserLogging extends TestBase{

    @Test
    public void verifyBrowserLogs(){
        loginToAdminPanel();
        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        List<WebElement> items = driver.findElements(By.linkText("fjfj"));
        for (WebElement item : items){
            item.click();
            driver.manage().logs().get("browser").getAll();
        }
        for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
            System.out.println(l);
        }

    }
}
